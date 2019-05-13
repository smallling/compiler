package main.java.BackEnd;

import main.java.MyUtil.BasicBlock;
import main.java.MyUtil.FuncFrame;
import main.java.MyUtil.OprandClass.MemAccess;
import main.java.MyUtil.OprandClass.Oprand;
import main.java.MyUtil.OprandClass.Register;
import main.java.MyUtil.QuadClass.CJumpQuad;
import main.java.MyUtil.QuadClass.Quad;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class DeadCode {
    FuncFrame func;
    LivenessAnalyzer livenessAnalyzer;
    HashMap<BasicBlock, HashSet<String> > liveOut;

    public DeadCode() {
        livenessAnalyzer = new LivenessAnalyzer();
    }

    boolean isRemovable(Quad code) {
        String op = code.getOp();
        return !(op.equals("ret") || op.equals("call") || op.equals("cqo") || op.equals("push") || op.equals("pop") || op.equals("jump") || code instanceof CJumpQuad);
    }

    public void processFunc(FuncFrame func) {
        liveOut = livenessAnalyzer.getLiveOut(func);
        HashMap<String, Register> regMap = new HashMap<>();
        for(BasicBlock block : func.blockList) {
            for(Quad code : block.codeList) {
                Oprand rt = code.getRt();
                Oprand r1 = code.getR1();
                Oprand r2 = code.getR2();
                if(rt instanceof Register) {
                    if(!regMap.containsKey(rt.get())) {
                        regMap.put(rt.get(), (Register) rt);
                    }
                }
                else if(rt instanceof MemAccess) {
                    Oprand base = ((MemAccess) rt).getBase();
                    Oprand offsetSize = ((MemAccess) rt).getOffsetSize();
                    if(base instanceof Register) {
                        if(!regMap.containsKey(base.get())) {
                            regMap.put(base.get(), (Register) base);
                        }
                    }
                    if(offsetSize instanceof Register) {
                        if(!regMap.containsKey(offsetSize.get())) {
                            regMap.put(offsetSize.get(), (Register) offsetSize);
                        }
                    }
                }
                if(r1 instanceof Register) {
                    if(!regMap.containsKey(r1.get())) {
                        regMap.put(r1.get(), (Register)r1);
                    }
                }
                else if(r1 instanceof MemAccess) {
                    Oprand base = ((MemAccess) r1).getBase();
                    Oprand offsetSize = ((MemAccess) r1).getOffsetSize();
                    if(base instanceof Register) {
                        if(!regMap.containsKey(base.get())) {
                            regMap.put(base.get(), (Register) base);
                        }
                    }
                    if(offsetSize instanceof Register) {
                        if(!regMap.containsKey(offsetSize.get())) {
                            regMap.put(offsetSize.get(), (Register) offsetSize);
                        }
                    }
                }
                if(r2 instanceof Register) {
                    if(!regMap.containsKey(r2.get())) {
                        regMap.put(r2.get(), (Register)r2);
                    }
                }
                else if(r2 instanceof MemAccess) {
                    Oprand base = ((MemAccess) r2).getBase();
                    Oprand offsetSize = ((MemAccess) r2).getOffsetSize();
                    if(base instanceof Register) {
                        if(!regMap.containsKey(base.get())) {
                            regMap.put(base.get(), (Register) base);
                        }
                    }
                    if(offsetSize instanceof Register) {
                        if(!regMap.containsKey(offsetSize.get())) {
                            regMap.put(offsetSize.get(), (Register) offsetSize);
                        }
                    }
                }
            }
        }

        for(BasicBlock block : func.blockList) {
            HashSet<String> liveSet = new HashSet<>(liveOut.get(block));
            LinkedList<Quad> curCodeList = new LinkedList<>();
            for(int i = block.codeList.size() - 1; i >= 0; i--) {
                Quad code = block.codeList.get(i);
                LinkedList<String> used = code.getUsedReg();
                LinkedList<String> defined = code.getDefinedReg();
                boolean dead = true;
                if(defined.isEmpty()) {
                    dead = false;
                }
                for(String reg : defined) {
                    if(!dead)break;
                    if(liveSet.contains(reg) || (regMap.containsKey(reg) && regMap.get(reg).getMemPos() != null)) {
                        dead = false;
                        break;
                    }
                }
                if(dead && isRemovable(code)) {
                    continue;
                }
                else {
                    liveSet.removeAll(defined);
                    liveSet.addAll(used);
                }
                curCodeList.add(code.clone());
            }
            curCodeList.get(0).setLabel(block.codeList.get(0).getLabel());
            block.codeList = curCodeList;
        }
    }
}
