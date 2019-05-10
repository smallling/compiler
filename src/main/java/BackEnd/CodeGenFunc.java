package main.java.BackEnd;

import main.java.MyUtil.BasicBlock;
import main.java.MyUtil.FuncFrame;
import main.java.MyUtil.OprandClass.*;
import main.java.MyUtil.QuadClass.ArthQuad;
import main.java.MyUtil.QuadClass.Quad;

import java.util.*;

public class CodeGenFunc {
    String[] regList = {"rdi", "rsi", "rdx", "rcx", "r8", "r9", "rax", "rbx", "r12", "r13", "r14", "r15", "r11", "r10", "rbp", "rsp"};

    FuncFrame func;

    String curLbal;

    public CodeGenFunc(FuncFrame func, HashMap<String, Long> varSize) {
        this.func = func;

        curLbal = null;
    }

    public ArrayList<String> genCode() {
        LinkedList<String> param = new LinkedList<>(func.paramList);
        HashSet<String> paramName = new HashSet<>();
        HashMap<String, StackSlot> paramMap = new HashMap<>();
        LinkedList<StackSlot> paramStack = new LinkedList<>();
        for(int i = 6; i < param.size(); i++) {
            paramStack.add(new StackSlot(param.get(i)));
            paramName.add(param.get(i));
            paramMap.put(param.get(i), paramStack.get(i));
        }
        for(int i = 0; i < paramStack.size(); i++) {
            StackSlot tmp = paramStack.get(i);
            tmp.setBase(new Register("rbp"));
            tmp.setOffset(new ImmOprand(16 + 8 * i));
        }
        HashSet<String> curReg = new HashSet<>();
        HashMap<String, StackSlot> curStack = new HashMap<>();
        for(BasicBlock block : func.blockList) {
            LinkedList<Quad> curCodeList = new LinkedList<>();
            for(Quad code : block.codeList) {
                curCodeList.add(code);
                Oprand rt = code.getRt();
                Oprand r1 = code.getR1();
                Oprand r2 = code.getR2();
                if(rt != null && paramName.contains(rt.get())) {
                    code.setRt(paramMap.get(rt.get()));
                }
                if(r1 != null && paramName.contains(r1.get())) {
                    code.setRt(paramMap.get(r1.get()));
                }
                if(r2 != null && paramName.contains(r2.get())) {
                    code.setRt(paramMap.get(r2.get()));
                }
                if(code.getOp().equals("call")) {
                    long val = Long.parseLong(r2.get());
                    if(val > 6) {
                        curCodeList.add(new ArthQuad("add", new Register("rsp"), new ImmOprand((val - 6) * 8)));
                    }
                }
                if(rt instanceof StackSlot) {
                    if(!paramName.contains(((StackSlot) rt).getName())) {
                        if(!curStack.containsKey(((StackSlot) rt).getName())) {
                            curStack.put(((StackSlot) rt).getName(), (StackSlot) rt);
                        }
                    }
                }
                if(r1 instanceof StackSlot) {
                    if(!paramName.contains(((StackSlot) r1).getName())) {
                        if(!curStack.containsKey(((StackSlot) r1).getName())) {
                            curStack.put(((StackSlot) r1).getName(), (StackSlot) r1);
                        }
                    }
                }
                if(r2 instanceof StackSlot) {
                    if(!paramName.contains(((StackSlot) r2).getName())) {
                        if(!curStack.containsKey(((StackSlot) r2).getName())) {
                            curStack.put(((StackSlot) r2).getName(), (StackSlot) r2);
                        }
                    }
                }
                if(rt instanceof Register) {
                    curReg.add(rt.get());
                }
                if(r1 instanceof Register) {
                    curReg.add(r1.get());
                }
                if(r2 instanceof Register) {
                    curReg.add(r2.get());
                }
            }
            block.codeList = curCodeList;
        }
        ArrayList<StackSlot> tmpVar = new ArrayList<>(curStack.values());
        HashMap<String, StackSlot> tmpMap = new HashMap<>();

        for(int i = 0; i < tmpVar.size(); i++) {
            StackSlot tmp = tmpVar.get(i);
            tmp.setBase(new Register("rbp"));
            tmp.setOffset(new ImmOprand(-8 - 8 * i));
            tmpMap.put(tmp.getName(), tmp.clone());
        }

        for(BasicBlock block : func.blockList) {
            for(Quad code : block.codeList) {
                Oprand rt = code.getRt();
                Oprand r1 = code.getR1();
                Oprand r2 = code.getR2();
                if(rt instanceof StackSlot && tmpMap.containsKey(((StackSlot) rt).getName())) {
                    code.setRt(tmpMap.get(((StackSlot) rt).getName()));
                }
                if(r1 instanceof StackSlot && tmpMap.containsKey(((StackSlot) r1).getName())) {
                    code.setR1(tmpMap.get(((StackSlot) r1).getName()));
                }
                if(r2 instanceof StackSlot && tmpMap.containsKey(((StackSlot) r2).getName())) {
                    code.setR2(tmpMap.get(((StackSlot) r2).getName()));
                }
            }
        }

        ArrayList<Quad> finalCodeList = new ArrayList<>();
        finalCodeList.add(new Quad("push", new Register("rbp")));
        finalCodeList.add(new Quad("mov", new Register("rbp"), new Register("rsp")));
        finalCodeList.add(new ArthQuad("sub", new Register("rsp"), new ImmOprand((curStack.size() + curStack.size() % 2) * 8)));

        HashSet<String> calleeSave = new HashSet<>();
        calleeSave.add("rbx");
        calleeSave.add("r12");
        calleeSave.add("r13");
        calleeSave.add("r14");
        calleeSave.add("r15");
        curReg.retainAll(calleeSave);
        ArrayList<String> fuck = new ArrayList<>();
        for(String reg : curReg) {
            finalCodeList.add(new Quad("push", new Register(reg)));
            fuck.add(reg);
        }

        String endLabel = "end_" + func.getName();

        for(BasicBlock block : func.blockList) {
            if(block.codeList.size() == 0) {
                block.codeList.add(new Quad("nop"));
            }
            for(int i = 0; i < block.codeList.size(); i++) {
                Quad code = block.codeList.get(i);
                if(code.getOp().equals("ret")) {
                    finalCodeList.add(new Quad("jump", new LabelName(endLabel)));
                }
                else finalCodeList.add(code.clone());
                Quad tmp = finalCodeList.get(finalCodeList.size() - 1);
                if(block.getIdx() > 0 && i == 0) {
                    tmp.setLabel(block.getName());
                }
            }
        }
        int curSize = finalCodeList.size();
        for(int i = fuck.size() - 1; i >= 0; i--) {
            finalCodeList.add(new Quad("pop", new Register(fuck.get(i))));
        }
        Quad curCode = new Quad("mov", new Register("rsp"), new Register("rbp"));
        finalCodeList.add(curCode);
        finalCodeList.add(new Quad("pop", new Register("rbp")));
        finalCodeList.add(new Quad("ret"));
        finalCodeList.get(curSize).setLabel(endLabel);
        ArrayList<String> codes = new ArrayList<>();
        codes.add(func.getName() + ":");
        for(Quad code : finalCodeList) {
            String curLabel = code.getLabel();
            if(curLabel != null) {
                codes.add(curLabel + ":");
            }
            codes.add(code.getPrint());
        }
        return codes;
    }
}
