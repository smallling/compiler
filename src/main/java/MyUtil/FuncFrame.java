package main.java.MyUtil;

import main.java.MyUtil.OprandClass.FuncName;
import main.java.MyUtil.OprandClass.ImmOprand;
import main.java.MyUtil.OprandClass.Register;
import main.java.MyUtil.OprandClass.StackSlot;
import main.java.MyUtil.QuadClass.CJumpQuad;
import main.java.MyUtil.QuadClass.Quad;
import main.java.MyUtil.ScopeClass.LocalScope;

import java.util.*;

public class FuncFrame {
    String name;
    long retSize;

    HashMap<String, Long> localVar;
    long localVarSize;

    HashMap<String, Long> classObj;

    public ArrayList<String> paramList;
    HashMap<String, Long> param;
    long paramSize;

    HashMap<String, Long> varMap;

    BasicBlock first;
    HashMap<String, BasicBlock> map;

    ArrayList<String> paramReg;

    public ArrayList<BasicBlock> blockList;

    public FuncFrame(String tmpName) {
        name = tmpName;
        retSize = 0;
        localVar = new HashMap<>();
        localVarSize = 0;
        classObj = new HashMap<>();
        paramList = new ArrayList<>();
        param = new HashMap<>();
        paramSize = 0;
        varMap = new HashMap<>();
        first = null;
        map = new HashMap<>();
        blockList = new ArrayList<>();

        paramReg = new ArrayList<>();
        paramReg.add("rdi");
        paramReg.add("rsi");
        paramReg.add("rdx");
        paramReg.add("rcx");
        paramReg.add("r8");
        paramReg.add("r9");
    }

    public void rebuild() {
        for(int i = 0; i < paramList.size(); i++) {
            String name = paramList.get(i);
            BasicBlock block = blockList.get(0);
            if(i < 6)block.codeList.addFirst(new Quad("mov", new Register(name), new Register(paramReg.get(i))));
            else block.codeList.addFirst(new Quad("mov", new Register(name), new StackSlot(name)));
            block.codeList.get(0).setLabel(block.codeList.get(1).getLabel());
        }
        for(int i = 0; i < blockList.size(); i++) {
            blockList.get(i).rebuild();
        }
    }

    public void print() {
        System.out.printf("Func_def %s(", name);
        for(int i = 0; i < paramList.size(); i++)
            System.out.printf("%s, ", paramList.get(i));
        System.out.println(")");
        if(first != null) {
            for(int i = 0; i < blockList.size(); i++) {
                blockList.get(i).print();
            }
        }
        System.out.println("Func_def_done");
    }

    public void setRetSize(long tmp) {
        retSize = tmp;
    }

    public long getRetSize() {
        return retSize;
    }

    public String getName() {
        return name;
    }

    public void setClassObj(HashMap<String, Long> tmpClassObj) {
        classObj = tmpClassObj;
    }

    public void addParam(String tmpName, long tmpSize) {
        if(paramList.size() < 6) {
            param.put(name, (long)-paramList.size());
        }
        else {
            paramSize += tmpSize;
            param.put(name, paramSize);
        }
        varMap.put(name, tmpSize);
        paramList.add(tmpName);
    }

    public void addLocalVar(String tmpName, long tmpSize) {
        localVarSize += tmpSize;
        localVar.put(tmpName, localVarSize);
        varMap.put(tmpName, tmpSize);
    }

    public void buildCFG(ArrayList<Quad> codeList) {
        if(codeList.isEmpty()) {
            if(retSize == 0)codeList.add(new Quad("ret"));
            else return;
        }
        codeList.get(0).setLabel(name);
        int n = codeList.size();
        for(int i = 0; i < n; i++) {
            Quad code = codeList.get(i);
            String label = code.getLabel();
            if(label != null) {
                map.put(label, new BasicBlock(label));
            }
        }

        BasicBlock lastBlock = null;
        Quad lastQuad = null;
        for(int i = 0; i < n; i++) {
            Quad code = codeList.get(i);
            String label = code.getLabel();
            if(label == null)continue;
            BasicBlock block = map.get(label);
            if(i == 0)first = block;

            if(lastQuad != null && !(lastQuad instanceof CJumpQuad) && !lastQuad.getOp().equals("jump") && !lastQuad.getOp().equals("ret")) {
                lastBlock.addOut(block);
            }

            for(int j = i; j < n; j++) {
                lastQuad = code;
                code = codeList.get(j);
                if(i < j && code.getLabel() != null) {
                    i = j - 1;
                    break;
                }
                block.addQuad(code);
                if(code instanceof CJumpQuad) {
                    block.addOut(map.get(code.getR1().get()));
                    block.addOut(map.get(code.getR2().get()));
                    lastQuad = code;
                    i = j;
                    break;
                }
                if(code.getOp().equals("jump")) {
                    block.addOut(map.get(code.getRt().get()));
                    lastQuad = code;
                    i = j;
                    break;
                }
                if(code.getOp().equals("ret")) {
                    lastQuad = code;
                    i = j;
                    break;
                }
            }

            lastBlock = block;
        }

        bfsBlock();
    }

    void bfsBlock() {
        if(first == null)return;
        Stack<BasicBlock> q = new Stack<>();
        HashSet<BasicBlock> vis = new HashSet<>();
        q.push(first);
        while(!q.isEmpty()) {
            BasicBlock x = q.pop();
            x.setIdx(blockList.size());
            blockList.add(x);
            for(int i = 0; i < x.out.size(); i++) {
                BasicBlock y = x.out.get(i);
                if(!vis.contains(y)) {
                    vis.add(y);
                    q.push(y);
                }
            }
        }
    }

    public void addInit(FuncFrame init) {
        if(init == null)return;
        blockList.get(0).codeList.addFirst(new Quad("call", null, new FuncName(init.getName()), new ImmOprand(0)));
    }
}
