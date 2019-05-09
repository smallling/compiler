package main.java.MyUtil;

import main.java.Main;
import main.java.MyUtil.OprandClass.ImmOprand;
import main.java.MyUtil.OprandClass.Oprand;
import main.java.MyUtil.OprandClass.Register;
import main.java.MyUtil.QuadClass.ArthQuad;
import main.java.MyUtil.QuadClass.CJumpQuad;
import main.java.MyUtil.QuadClass.Quad;

import java.util.ArrayList;
import java.util.LinkedList;

public class BasicBlock {
    int idx;
    String name;
    ArrayList<BasicBlock> in;
    public ArrayList<BasicBlock> out;

    public LinkedList<Quad> codeList;

    public BasicBlock(String tmpLabel) {
        idx = 0;
        name = tmpLabel;
        in = new ArrayList<>();
        out = new ArrayList<>();
        codeList = new LinkedList<>();
    }

    boolean isPow2(long val) {
        if(val < 0)val = -val;
        while(val > 1) {
            if(val % 2 == 1)return false;
            val /= 2;
        }
        return true;
    }

    int getLog(long val) {
        int cnt = 0;
        int f = 1;
        if(val < 0) {
            val = -val;
            f = -1;
        }
        while(val > 1) {
            cnt++;
            val /= 2;
        }
        return f * cnt;
    }

    String getTempName() {
        return "TEMP" + Main.rebuildCnt++;
    }

    public void rebuild() {
        LinkedList<Quad> curCodeList = new LinkedList<>();
        for(int i = 0; i < codeList.size(); i++) {
            Quad code = codeList.get(i);
            if(code.getLabel() == null) {
                code.setLabel(codeList.get(i - 1).getLabel());
            }
            String op = code.getOp();
            Oprand rt = code.getRt();
            Oprand r1 = code.getR1();
            Oprand r2 = code.getR2();
            int lastSize = curCodeList.size();
            if(op.equals("inc") || op.equals("dec")) {
                curCodeList.add(code.clone());
            }
            if(op.equals("add") || op.equals("sub") || op.equals("and") || op.equals("or") || op.equals("xor")) {
                curCodeList.add(new Quad("mov", rt.clone(), r1.clone()));
                curCodeList.add(new ArthQuad(op, rt.clone(), r2.clone()));
            }
            if(op.equals("sal") || op.equals("sar")) {
                curCodeList.add(new Quad("mov", rt.clone(), r1.clone()));
                if(r2 instanceof ImmOprand) {
                    curCodeList.add(new ArthQuad(op, rt.clone(), r2.clone()));
                }
                else {
                    Register tmp = new Register("rcx");
                    curCodeList.add(new Quad("mov", tmp, r2.clone()));
                    curCodeList.add(new ArthQuad(op, rt.clone(), new Register("cl")));
                }
            }
            if(op.equals("mul")) {
                if(r1 instanceof ImmOprand) {
                    Oprand tmp = r1;
                    r1 = r2;
                    r2 = tmp;
                }
                if(r2 instanceof ImmOprand) {
                    long val = Long.parseLong(r2.get());
                    if(isPow2(val)) {
                        int log = getLog(val);
                        if(log >= 0) {
                            curCodeList.add(new Quad("mov", rt.clone(), r1.clone()));
                        }
                        else {
                            curCodeList.add(new Quad("mov", rt.clone(), r1.clone()));
                            curCodeList.add(new Quad("neg", rt.clone()));
                            log = -log;
                        }
                        if(log != 0)curCodeList.add(new ArthQuad("sal", rt.clone(), new ImmOprand(log)));
                    }
                    else{
                        curCodeList.add(new ArthQuad("imul", rt.clone(), r1.clone(), r2.clone()));
                    }
                }
                else {
                    Register tmp = new Register("rax");
                    curCodeList.add(new Quad("mov", tmp, r1.clone()));
                    curCodeList.add(new ArthQuad("imul", r2.clone()));
                    curCodeList.add(new Quad("mov", rt.clone(), tmp.clone()));
                }
            }
            if(op.equals("div")) {
                if(r2 instanceof ImmOprand) {
                    long val = Long.parseLong(r2.get());
                    if(isPow2(val) && getLog(val) >= 0) {
                        int log = getLog(val);
                        if(log != 0) {
                            curCodeList.add(new Quad("mov", rt.clone(), r1.clone()));
                            curCodeList.add(new ArthQuad("sar", rt.clone(), new ImmOprand(log)));
                        }else {
                            curCodeList.add(new Quad("mov", rt.clone(), r1.clone()));
                        }
                    }
                }
                if(curCodeList.size() == lastSize) {
                    Register tmp = new Register(getTempName());
                    Register ttmp = new Register("rax");
                    curCodeList.add(new Quad("mov", tmp, r2.clone()));
                    curCodeList.add(new Quad("mov", ttmp, r1.clone()));
                    curCodeList.add(new Quad("dqo"));
                    curCodeList.add(new ArthQuad("idiv", r2.clone()));
                    curCodeList.add(new Quad("mov", rt.clone(), ttmp.clone()));
                }
            }
            if(op.equals("mod")) {
                if(r2 instanceof ImmOprand) {
                    long val = Long.parseLong(r2.get());
                    if(isPow2(val) && getLog(val) >= 0) {
                        curCodeList.add(new Quad("mov", rt.clone(), r1.clone()));
                        curCodeList.add(new ArthQuad("and", rt.clone(), new ImmOprand(val - 1)));
                    }
                }
                if(curCodeList.size() == lastSize) {
                    Register tmp = new Register(getTempName());
                    Register ttmp = new Register("rax");
                    Register tttmp = new Register("rdx");
                    curCodeList.add(new Quad("mov", tmp, r2.clone()));
                    curCodeList.add(new Quad("mov", ttmp, r1.clone()));
                    curCodeList.add(new Quad("cqo"));
                    curCodeList.add(new Quad("idiv", r2.clone()));
                    curCodeList.add(new Quad("mov", tttmp, rt.clone()));
                }
            }
            if(op.equals("not") || op.equals("neg")) {
                curCodeList.add(new Quad("mov", rt.clone(), r1.clone()));
                curCodeList.add(new Quad(op, rt.clone()));
            }
            if(code instanceof CJumpQuad) {
                curCodeList.add(code.clone());
                curCodeList.add(new Quad("jump", r2.clone()));
            }
            if(op.equals("mov") || op.equals("lea") || op.equals("call") || op.equals("push") || op.equals("jump")) {
                curCodeList.add(code.clone());
            }
            if(op.equals("cmp")) {
                if (!(rt instanceof Register)) {
                    Register tmp = new Register(getTempName());
                    curCodeList.add(new Quad("mov", tmp, rt.clone()));
                    curCodeList.add(new CJumpQuad(op, tmp, r1.clone()));
                } else {
                    curCodeList.add(code.clone());
                }
            }
            if(op.equals("ret")) {
                if(rt != null) {
                    Register tmp = new Register("rax");
                    curCodeList.add(new Quad("mov", tmp, rt));
                }
                curCodeList.add(code.clone());
            }
            for(int j = lastSize; j < curCodeList.size(); j++)
                curCodeList.get(j).setLabel(code.getLabel());
        }
        codeList = new LinkedList<>();
        for(int i = 0; i < curCodeList.size(); i++)
        {
            Quad code = curCodeList.get(i);
            if(code.getOp().equals("mov")) {
                if(code.getRt().equals(code.getR1())) {
                    continue;
                }
            }
            codeList.add(code);
        }
    }

    public void print() {
        System.out.printf("BasicBlock %s:\n", name);
        for(int i = 0; i < codeList.size(); i++) {
            codeList.get(i).print();
        }
        System.out.println();
        System.out.print("In:");
        for(int i = 0; i < in.size(); i++) {
            System.out.print(" " + in.get(i).getName());
        }
        System.out.println();
        System.out.print("Out:");
        for(int i = 0; i < out.size(); i++) {
            System.out.print(" " + out.get(i).getName());
        }
        System.out.println();
    }

    public void setIdx(int tmp) {
        idx = tmp;
    }

    public int getIdx() {
        return idx;
    }

    public void addOut(BasicBlock tmp) {
        out.add(tmp);
        tmp.addIn(this);
    }

    public void addIn(BasicBlock tmp) {
        in.add(tmp);
    }

    public void addQuad(Quad code) {
        codeList.add(code);
    }

    public String getName() {
        return name;
    }
}
