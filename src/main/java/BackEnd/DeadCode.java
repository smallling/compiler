package main.java.BackEnd;

import main.java.MyUtil.BasicBlock;
import main.java.MyUtil.FuncFrame;
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
        for(BasicBlock block : func.blockList) {
            HashSet<String> liveSet = new HashSet<>(liveOut.get(block));
            LinkedList<Quad> curCodeList = new LinkedList<>();
            for(Quad code : block.codeList) {
                LinkedList<String> used = code.getUsedReg();
                LinkedList<String> defined = code.getDefinedReg();
                boolean dead = true;
                if(defined.isEmpty()) {
                    dead = false;
                }
                for(String reg : defined) {
                    if(!dead)break;
                    if(liveSet.contains(reg) || reg.length() < 3 || !((reg.charAt(0) == 'A' || reg.charAt(0) == 'V') && (reg.charAt(2) >= '0' && reg.charAt(2) <= '9'))) {
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
        }
    }
}
