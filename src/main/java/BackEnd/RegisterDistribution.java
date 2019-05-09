package main.java.BackEnd;

import main.java.Main;
import main.java.MyUtil.BasicBlock;
import main.java.MyUtil.FuncFrame;
import main.java.MyUtil.Graph;
import main.java.MyUtil.OprandClass.*;
import main.java.MyUtil.QuadClass.Quad;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class RegisterDistribution {
    Graph graph;
    Graph originGraph;
    LivenessAnalyzer livenessAnalyzer;

    HashSet<String> simplifyList;
    HashSet<String> spillList;
    HashSet<String> spilledReg;
    LinkedList<String> selectStack;

    LinkedList<String> callerReg;
    LinkedList<String> calleeReg;

    HashMap<String, String> entity;
    HashSet<String> register;

    int K;

    String getTempName() {
        return "TEMP" + Main.rebuildCnt++;
    }

    public RegisterDistribution() {
        K = 14;

        entity = new HashMap<>();
        entity.put("rax", "rax");
        entity.put("rcx", "rcx");
        entity.put("rdx", "rdx");
        entity.put("rbx", "rbx");
        entity.put("rsi", "rsi");
        entity.put("rdi", "rdi");
        entity.put("r8", "r8");
        entity.put("r9", "r9");
        entity.put("r10", "r10");
        entity.put("r11", "r11");
        entity.put("r12", "r12");
        entity.put("r13", "r13");
        entity.put("r14", "r14");
        entity.put("r15", "r15");

        register = new HashSet<>(entity.keySet());

        callerReg = new LinkedList<>();
        callerReg.add("rax");
        callerReg.add("rcx");
        callerReg.add("rdx");
        callerReg.add("rsi");
        callerReg.add("rdi");
        callerReg.add("r8");
        callerReg.add("r9");
        callerReg.add("r10");
        callerReg.add("r11");

        calleeReg = new LinkedList<>();
        for(String reg : entity.keySet()) {
            if(callerReg.contains(reg))continue;
            calleeReg.add(reg);
        }

        livenessAnalyzer = new LivenessAnalyzer();
    }

    void init() {
        simplifyList = new HashSet<>();
        spillList = new HashSet<>();
        spilledReg = new HashSet<>();
        selectStack = new LinkedList<>();
        for(String reg : graph.getAllReg()) {
            if(graph.getDegree(reg) < K) {
                simplifyList.add(reg);
            }
            else {
                spillList.add(reg);
            }
        }
    }

    void simplify() {
        String reg = simplifyList.iterator().next();
        LinkedList<String> neighbor = new LinkedList<>(graph.getAdj(reg));
        graph.delReg(reg);
        for(String adjReg : neighbor) {
            if(graph.getDegree(adjReg) < K && spillList.contains(adjReg)) {
                spillList.remove(adjReg);
                simplifyList.add(adjReg);
            }
        }
        simplifyList.remove(reg);
        selectStack.addFirst(reg);
    }

    void spill() {
        String tmp = null;
        int rk = -2;
        for(String reg : spillList) {
            int curRk = graph.getDegree(reg);
            if(entity.containsKey(reg)) curRk = -1;
            if(curRk > rk) {
                rk = curRk;
                tmp = reg;
            }
        }
        if(tmp != null) {
            graph.delReg(tmp);
            spillList.remove(tmp);
            selectStack.addFirst(tmp);
        }
    }

    void assignColor() {
        for(String reg : selectStack) {
            if(entity.containsKey(reg))continue;
            HashSet<String> curColor = new HashSet<>(register);
            HashSet<String> neighbor = new HashSet<>(originGraph.getAdj(reg));
            for(String adjReg : neighbor) {
                if(entity.containsKey(adjReg))
                    curColor.remove(entity.get(adjReg));
            }
            if(curColor.isEmpty()) {
                spilledReg.add(reg);
            }
            else {
                String tmp = null;
                for(String curReg : callerReg) {
                    if(curColor.contains(curReg)) {
                        tmp = curReg;
                        break;
                    }
                }
                if(tmp == null) {
                    tmp = curColor.iterator().next();
                }
                entity.put(reg, tmp);
            }
        }
    }

    void colorReg(FuncFrame func) {
        HashMap<String, String> renameMap = new HashMap<>(entity);
        for(BasicBlock block : func.blockList) {
            for(Quad code : block.codeList) {
                code.renameUsedReg(renameMap);
                code.renameDefinedReg(renameMap);
            }
        }

    }

    void rewriteFunc(FuncFrame func) {
        HashMap<String, Register> memMap = new HashMap<>();
        for(BasicBlock block : func.blockList) {
            for(Quad code : block.codeList) {
                Oprand rt = code.getRt(), r1 = code.getR1(), r2 = code.getR2();
                if(rt instanceof Register) {
                    memMap.put(rt.get(), (Register) rt);
                }
                if(r1 instanceof Register) {
                    memMap.put(r1.get(), (Register) r1);
                }
                if(r2 instanceof Register) {
                    memMap.put(r2.get(), (Register) r2);
                }
            }
        }
        HashMap<String, MemAccess> spillPlace = new HashMap<>();
        for(String reg : spilledReg) {
            if(memMap.containsKey(reg) && memMap.get(reg).getMemPos() != null) {
                spillPlace.put(reg, new GeneralMemAccess(memMap.get(reg).getMemPos()));
            }
            else {
                spillPlace.put(reg, new StackSlot(reg));
            }
        }
        for(BasicBlock block : func.blockList) {
            LinkedList<Quad> curCodeList = new LinkedList<>();
            for(int i = 0; i < block.codeList.size(); i++) {
                Quad code = block.codeList.get(i);
                LinkedList<String> used = new LinkedList<>(code.getUsedReg());
                LinkedList<String> defined = new LinkedList<>(code.getDefinedReg());
                HashMap<String, String> renameMap = new HashMap<>();
                used.retainAll(spilledReg);
                defined.retainAll(spilledReg);
                for(String reg : used) {
                    if(!renameMap.containsKey(reg)) {
                        Register tmp = new Register(getTempName());
                        memMap.put(tmp.get(), tmp);
                        renameMap.put(reg, tmp.get());
                    }
                }
                for(String reg : defined) {
                    if(!renameMap.containsKey(reg)) {
                        Register tmp = new Register(getTempName());
                        memMap.put(tmp.get(), tmp);
                        renameMap.put(reg, tmp.get());
                    }
                }
                code.renameUsedReg(renameMap);
                code.renameDefinedReg(renameMap);
                for(String reg : used) {
                    curCodeList.add(new Quad("mov", memMap.get(renameMap.get(reg)), spillPlace.get(reg)));
                }
                for(String reg : defined) {
                    curCodeList.add(code);
                    curCodeList.add(new Quad("mov", spillPlace.get(reg), memMap.get(renameMap.get(reg))));
                    i++;
                    code = block.codeList.get(i);
                }
            }
            block.codeList = curCodeList;
        }
    }

    public void processFunc(FuncFrame func) {
        originGraph = new Graph();
        while(true) {
            livenessAnalyzer.getGraph(func, originGraph);
            graph = new Graph(originGraph);
            init();
            do {
                if(!simplifyList.isEmpty()) simplify();
                else if(!spillList.isEmpty()) spill();
            } while(!simplifyList.isEmpty() || !spillList.isEmpty());
            assignColor();
            if(spilledReg.isEmpty()) {
                colorReg(func);
                break;
            }
            else rewriteFunc(func);
        }
    }
}
