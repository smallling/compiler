package main.java.BackEnd;

import main.java.MyUtil.BasicBlock;
import main.java.MyUtil.FuncFrame;
import main.java.MyUtil.Graph;
import main.java.MyUtil.QuadClass.Quad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LivenessAnalyzer {

    HashMap<BasicBlock, HashSet<String> > liveOut;
    HashMap<BasicBlock, HashSet<String> > usedRegister;
    HashMap<BasicBlock, HashSet<String> > definedRegister;

    void init(FuncFrame func) {
        liveOut = new HashMap<>();
        usedRegister = new HashMap<>();
        definedRegister = new HashMap<>();
        for(BasicBlock block : func.blockList) {
            liveOut.put(block, new HashSet<>());
            usedRegister.put(block, new HashSet<>());
            definedRegister.put(block, new HashSet<>());
        }
    }

    void initRegister(BasicBlock block) {
        HashSet<String> curUsed = new HashSet<>();
        HashSet<String> curDefined = new HashSet<>();

        for(int i = 0; i < block.codeList.size(); i++) {
            Quad code = block.codeList.get(i);
            LinkedList<String> tmp = code.getUsedReg();
            for(String reg : tmp) {
                if(!curDefined.contains(reg))
                    curUsed.add(reg);
            }
            curDefined.addAll(code.getDefinedReg());
        }
        usedRegister.put(block, curUsed);
        definedRegister.put(block, curDefined);
    }

    void calcLiveOut(FuncFrame func) {
        init(func);

        for(BasicBlock block : func.blockList)
            initRegister(block);

        boolean change = true;
        while(change) {
            change = false;
            for(BasicBlock block : func.blockList) {
                int oldSize = liveOut.get(block).size();
                for(BasicBlock out : block.out) {
                    HashSet<String> regs = new HashSet<>(liveOut.get(out));
                    regs.removeAll(definedRegister.get(out));
                    regs.addAll(usedRegister.get(out));
                    liveOut.get(block).addAll(regs);
                }
                change = change || (liveOut.get(block).size() != oldSize);
            }
        }
    }

    public void getGraph(FuncFrame func, Graph graph) {
        calcLiveOut(func);

        graph.clear();

        for(BasicBlock block : func.blockList) {
            for(Quad code : block.codeList) {
                graph.addReg(code.getUsedReg());
                graph.addReg(code.getDefinedReg());
            }
        }

        for(BasicBlock block : func.blockList) {
            HashSet<String> liveNow = new HashSet<>(liveOut.get(block));
            for(int i = block.codeList.size() - 1; i >= 0; i--) {
                Quad code = block.codeList.get(i);
                for(String reg1 : code.getDefinedReg()) {
                    for(String reg2 : liveNow) {
                        graph.addEdge(reg1, reg2);
                    }
                }
                liveNow.removeAll(code.getDefinedReg());
                liveNow.addAll(code.getUsedReg());
            }
        }
    }
}
