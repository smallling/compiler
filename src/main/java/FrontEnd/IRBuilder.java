package main.java.FrontEnd;

import javafx.util.Pair;
import jdk.nashorn.internal.codegen.MethodEmitter;
import main.java.MyUtil.FuncFrame;
import main.java.MyUtil.LinearIR;
import main.java.MyUtil.OprandClass.*;
import main.java.MyUtil.OprandClass.Oprand;
import main.java.MyUtil.QuadClass.ArthQuad;
import main.java.MyUtil.QuadClass.CJumpQuad;
import main.java.MyUtil.QuadClass.Quad;
import main.java.MyUtil.TypeSystem.*;

import java.util.*;


enum VarDefStatus {GeneralVar, ClassObj, LocalVar}

public class IRBuilder extends AstVisitor {
    private int labelCnt;
    private int quadLabel;
    private int selfLoopCnt;
    private LinearIR linearCode;

    private Stack<VarDefStatus> varState;

    private HashMap<String, Long> curClassObj;
    private long curClassObjSize;

    private Stack<Integer> breakLabel;
    private Stack<Pair<Integer, Boolean> > continueLabel;

    private FuncFrame curFunc;

    private ArrayList<Integer> nextLabel;
    private ArrayList<String> uset;

    private ArrayList<Quad> paramQuad;
    private ArrayList<Quad> curCodeList;

    public ArrayList<String> paramReg;

    ArrayList<String> classStr;

    public IRBuilder() {
        labelCnt = 0;
        quadLabel = 0;
        selfLoopCnt = 0;
        linearCode = new LinearIR();
        varState = new Stack<>();
        curClassObj = new HashMap<>();
        curClassObjSize = 0;
        breakLabel = new Stack<>();
        continueLabel = new Stack<>();
        curFunc = null;
        nextLabel = new ArrayList<>();
        uset = new ArrayList<>();
        paramQuad = new ArrayList<>();
        curCodeList = new ArrayList<>();
        paramReg = new ArrayList<>();
        paramReg.add("rdi");
        paramReg.add("rsi");
        paramReg.add("rdx");
        paramReg.add("rcx");
        paramReg.add("r8");
        paramReg.add("r9");
        classStr = new ArrayList<>();
    }

    public LinearIR buildIR(Node root) throws Exception {
        visit(root);
        return linearCode;
    }

    void insertFunc() {
        curCodeList.add(new Quad("ret"));
        updateLabel(curCodeList);
        setMemPos(curCodeList);
        curFunc.buildCFG(curCodeList);
        curCodeList.clear();
        linearCode.insertFunc(curFunc);
    }

    void setInit() {
        updateLabel(curCodeList);
        setMemPos(curCodeList);
        curFunc.buildCFG(curCodeList);
        linearCode.setInit(curFunc);
        curCodeList.clear();
    }

    boolean isTemp(String s) {
        if(s.charAt(0) != 'A' || s.charAt(0) != 'V')return false;
        if(s.charAt(2) < '0' || s.charAt(2) > '9')return false;
        return true;
    }

    void setMemPos(ArrayList<Quad> codeList) {
        for(int i = 0; i < codeList.size(); i++) {
            Quad code = codeList.get(i);
            Oprand rt = code.getRt(), r1 = code.getR1(), r2 = code.getR2();
            if(rt != null) {
                if(rt instanceof Register) {
                    if(!isTemp(rt.get()))((Register)rt).setMemPos(rt.get());
                }
            }
            if(r1 != null) {
                if(r1 instanceof Register) {
                    if(!isTemp(r1.get()))((Register)r1).setMemPos(r1.get());
                }
            }
            if(r2 != null) {
                if(r2 instanceof Register) {
                    if(!isTemp(r2.get()))((Register)r2).setMemPos(r2.get());
                }
            }
        }
    }

    void updateLabel(ArrayList<Quad> codeList) {
        for(int i = 0; i < codeList.size(); i++) {
            Quad cur = codeList.get(i);
            if(cur.getOp().equals("jump")) {
                Oprand rt = cur.getRt();
                rt.set(uset.get(Integer.parseInt(rt.get())));
            }
            if(cur instanceof CJumpQuad) {
                Oprand r1 = cur.getR1(), r2 = cur.getR2();
                r1.set(uset.get(Integer.parseInt(r1.get())));
                r2.set(uset.get(Integer.parseInt(r2.get())));
            }
        }
    }

    String classFuncLabel(String className, String funcName) {
        return "C_" + className + "_F_" + funcName;
    }

    String funcLabel(String funcName) {
        return "F_" + funcName;
    }

    String getLoopName() {
        return "V_0Loop._" + selfLoopCnt++;
    }

    void calcImm(Node node, Oprand l, Oprand r) {
        String op = node.name;
        long ans = 0;
        if(l instanceof StrImmOprand) {
            String lv = l.get(), rv = r.get();
            if(op.equals("+")) {
                node.reg = new StrImmOprand(lv + rv);
                return;
            }
            int cmp = lv.compareTo(rv);
            if(op.equals("<"))ans = cmp < 0 ? 1 : 0;
            if(op.equals(">"))ans = cmp > 0 ? 1 : 0;
            if(op.equals("<="))ans = cmp <= 0 ? 1 : 0;
            if(op.equals(">="))ans = cmp >= 0 ? 1 : 0;
            if(op.equals("=="))ans = cmp == 0 ? 1 : 0;
            if(op.equals("!="))ans = cmp != 0 ? 1 : 0;
            node.reg = new ImmOprand(ans);
        }
        else {
            long lv = Long.parseLong(l.get()), rv = Long.parseLong(r.get());
            if(op.equals("+"))ans = lv + rv;
            if(op.equals("-"))ans = lv - rv;
            if(op.equals("*"))ans = lv * rv;
            if(op.equals("/"))ans = lv / rv;
            if(op.equals("%"))ans = lv % rv;
            if(op.equals(">>"))ans = lv >> rv;
            if(op.equals("<<"))ans = lv << rv;
            if(op.equals("&"))ans = lv & rv;
            if(op.equals("|"))ans = lv | rv;
            if(op.equals("^"))ans = lv ^ rv;
            if(op.equals("&&"))ans = lv & rv;
            if(op.equals("||"))ans = lv | rv;
            if(op.equals("<"))ans = (lv < rv ? 1 : 0);
            if(op.equals(">"))ans = (lv > rv ? 1 : 0);
            if(op.equals("<="))ans = (lv <= rv ? 1 : 0);
            if(op.equals(">="))ans = (lv >= rv ? 1 : 0);
            if(op.equals("=="))ans = (lv == rv ? 1 : 0);
            if(op.equals("!="))ans = (lv != rv ? 1 : 0);
            node.reg = new ImmOprand(ans);
            return;
        }
    }

    void calcUnaryImm(Node node, Oprand l) {
        long val = Long.parseLong(l.get()), ans = 0;
        String op = node.name;
        if(op.equals("~"))ans = ~val;
        if(op.equals("!"))ans = (~val) & 1;
        if(op.equals("-"))ans = -val;
        if(op.equals("+"))ans = val;
        node.reg = new ImmOprand(ans);
    }

    void insertQuad(Quad tmp) {
        if(nextLabel.size() > 0) {
            String label = "lb" + quadLabel++;
            tmp.setLabel(label);
            for(int data : nextLabel) {
                uset.set(data, label);
            }
            nextLabel.clear();
        }
        if(tmp.getOp().equals("param"))paramQuad.add(tmp);
        else if(tmp.getOp().equals("call")) {
            curCodeList.addAll(paramQuad);
            paramQuad.clear();
            curCodeList.add(tmp);
        }
        else curCodeList.add(tmp);
    }

    void genParam(ArrayList<Oprand> oprs, ArrayList<String> pres) {
        for(int i = 0; i < oprs.size(); i++) {
            if(i < 6) {
                Oprand tmp = new Register(paramReg.get(i));
                insertQuad(new Quad("mov", tmp.clone(), oprs.get(i).clone()));
            }
            else {
                Oprand tmp = new Register(pres.get(i));
                insertQuad(new Quad("mov", tmp.clone(), oprs.get(i).clone()));
                insertQuad(new Quad("push", tmp.clone()));
            }
        }
    }

    void genStringFunc(String funcName, Oprand ans, Oprand left, Oprand right) {
        ArrayList<Oprand> oprs = new ArrayList<>();
        ArrayList<String> pres = new ArrayList<>();
        oprs.add(left);
        oprs.add(right);
        pres.add("A_");
        pres.add("A_");
        genParam(oprs, pres);
        insertQuad(new Quad("call", null, new FuncName(funcName), new ImmOprand(2)));
        if(ans != null)insertQuad(new Quad("mov", ans.clone(), new Register("rax")));
    }

    void genStringAdd(Node node, Oprand reg) throws Exception {
        if(node instanceof BinaryExprNode) {
            genStringAdd(node.son.get(0), reg);
            genStringAdd(node.son.get(1), reg);
        }
        else {
            visit(node);
            genStringFunc("S_strcat", null, reg.clone(), node.reg.clone());
        }
    }

    void genCondition(Node node, int labelTrue, int labelFalse) throws Exception {
        if(node.name.equals("true")) {
            insertQuad(new Quad("jump", new LabelName(Integer.toString(labelTrue))));
            return;
        }
        if(node.name.equals("false")) {
            insertQuad(new Quad("jump", new LabelName(Integer.toString(labelFalse))));
            return;
        }

        if(node.reg != null || node instanceof FuncExprNode || node instanceof ArrExprNode || node instanceof ObjExprNode) {
            visit(node);
            insertQuad(new Quad("cmp", node.reg.clone(), new ImmOprand(0)));
            insertQuad(new CJumpQuad("jne", new LabelName(Integer.toString(labelTrue)), new LabelName(Integer.toString(labelFalse))));
            return;
        }

        if(node.son.size() == 1) {
            if(!node.name.equals("!")) {
                System.out.println("genCondition ! error");
            }
            genCondition(node.son.get(0), labelFalse, labelTrue);
            return;
        }

        Node l = node.son.get(0);
        Node r = node.son.get(1);
        int label = labelCnt++;
        String op = node.name;

        if(op.equals("||")) {
            genCondition(l, labelTrue, label);
            addNextLabel(label);
            genCondition(r, labelTrue, labelFalse);
            return;
        }
        if(op.equals("&&")) {
            genCondition(l, label, labelFalse);
            addNextLabel(label);
            genCondition(r, labelTrue, labelFalse);
            return;
        }

        visit(l);
        visit(r);

        Oprand lReg = l.reg.clone(), rReg = r.reg.clone();
        String irOp = null;


        if(op.equals("<"))irOp = "jl";
        if(op.equals(">"))irOp = "jg";
        if(op.equals("<="))irOp = "jle";
        if(op.equals(">="))irOp = "jge";
        if(op.equals("=="))irOp = "je";
        if(op.equals("!="))irOp = "jne";

        if(l.type instanceof StringTypeRef) {
            Register tmp = new Register(getTmpName("V_"));
            genStringFunc("strcmp", tmp, lReg, rReg);
            insertQuad(new Quad("cmp", tmp, new ImmOprand(0)));
        } else {
            insertQuad(new Quad("cmp", lReg, rReg));
        }
        insertQuad(new CJumpQuad(irOp, new LabelName(Integer.toString(labelTrue)), new LabelName(Integer.toString(labelFalse))));
    }

    Oprand changeOprToReg(Oprand cur) {
        if(cur instanceof Register)return cur;
        Register tmp = new Register(getTmpName(cur.get().charAt(0) == 'A' ? "A_" : "V_"));
        insertQuad(new Quad("mov", tmp, cur.clone()));
        return tmp.clone();
    }

    Oprand genMemAccess(Oprand... oprands) {
        Register tmp = new Register(getTmpName("A_"));
        if(oprands[0] instanceof MemAccess)oprands[0] = changeOprToReg(oprands[0]);
        if(oprands.length > 1 && oprands[1] instanceof MemAccess)oprands[1] = changeOprToReg(oprands[1]);
        if(oprands.length == 1)insertQuad(new Quad("lea", tmp, new MemAccess(oprands[0])));
        if(oprands.length == 2)insertQuad(new Quad("lea", tmp, new MemAccess(oprands[0], oprands[1])));
        if(oprands.length == 3)insertQuad(new Quad("lea", tmp, new MemAccess(oprands[0], oprands[1], oprands[2])));
        if(oprands.length == 4)insertQuad(new Quad("lea", tmp, new MemAccess(oprands[0], oprands[1], oprands[2], oprands[3])));
        return new MemAccess(tmp);
    }

    void genClassFunc(Node node, String className, Oprand base) throws Exception {
        visitChild(node);

        ArrayList<Oprand> oprs = new ArrayList<>();
        ArrayList<String> pres = new ArrayList<>();
        oprs.add(base);
        pres.add("A_");
        int n = node.son.size();
        for(int i = 0; i < n; i++) {
            oprs.add(node.son.get(i).reg);
            pres.add(TypeRef.getPre(node.son.get(i).type));
        }
        genParam(oprs, pres);
        if(node.type instanceof VoidTypeRef) {
            node.reg = null;
            insertQuad(new Quad("call", null, new FuncName(classFuncLabel(className, node.name)), new ImmOprand(n + 1)));
        }
        else {
            node.reg = new Register(getTmpName(TypeRef.getPre(node.type)));
            Oprand tmp = new Register(getTmpName(TypeRef.getPre(node.type)));
            insertQuad(new Quad("call", null, new FuncName(classFuncLabel(className, node.name)), new ImmOprand(n + 1)));
            insertQuad(new Quad("mov", tmp, new Register("rax")));
            insertQuad(new Quad("mov", node.reg, tmp.clone()));
        }
    }

    void genNewFunc(Oprand ret, Oprand len) {
        ArrayList<Oprand> oprs = new ArrayList<>();
        oprs.add(len);
        ArrayList<String> pres = new ArrayList<>();
        pres.add("V_");
        genParam(oprs, pres);
        insertQuad(new Quad("call", null, new FuncName("malloc"), new ImmOprand(1)));
        insertQuad(new Quad("mov", ret, new Register("rax")));
    }

    String getTmpName(String pre) {
        return pre + labelCnt++;
    }

    void addNextLabel(int curLabel) {
        nextLabel.add(curLabel);
        while(uset.size() <= curLabel)uset.add(null);
    }

    @Override
    void visit(CodeNode node) throws Exception {
        varState.push(VarDefStatus.GeneralVar);
        curFunc = new FuncFrame("__init");
        for(int i = 0; i < node.son.size(); i++) {
            Node son = node.son.get(i);
            if(son instanceof VarDefStatNode)visit(son);
        }

        if(!curCodeList.isEmpty())setInit();

        for(int i = 0; i < node.son.size(); i++) {
            Node son = node.son.get(i);
            if(!(son instanceof VarDefStatNode))visit(son);
        }
        varState.pop();
    }

    @Override
    void visit(VarDefNode node) throws Exception {
        VarDefStatus curVarState = varState.peek();
        if(curVarState == VarDefStatus.ClassObj) {
            curClassObj.put(node.name, curClassObjSize);
            curClassObjSize += node.type.getSize();
            if(node.type instanceof StringTypeRef) classStr.add(node.reg.get());
        }
        if(curVarState == VarDefStatus.GeneralVar) {
            String name = ((GeneralMemAccess) node.reg).getName();

            linearCode.insertVar(name, node.type.getSize());

            if(node.type instanceof StringTypeRef) {
                genNewFunc(node.reg, new ImmOprand(256));
                linearCode.addUninitMem(name, 256);
            }
            else {
                linearCode.addUninitMem(name, node.type.getSize() / 8);
            }

            if(node.son.size() > 0) {
                Node son = node.son.get(0);
                visit(son);
                insertQuad(new Quad("mov", node.reg.clone(), son.reg.clone()));
            }
        }
        if(curVarState == VarDefStatus.LocalVar) {
            curFunc.addLocalVar(node.name, node.type.getSize());
            if(node.type instanceof  StringTypeRef) {
                genNewFunc(node.reg, new ImmOprand(256));
                if(node.son.size() > 0) {
                    visit(node.son.get(0));
                    genStringFunc("S_strcpy", null, node.reg.clone(), node.son.get(0).reg.clone());
                }
                return;
            }

            if(node.son.size() > 0) {
                Node son = node.son.get(0);
                visit(son);
                insertQuad(new Quad("mov", node.reg.clone(), son.reg.clone()));
            }
        }
    }

    @Override
    void visit(ClassDefNode node) throws Exception {
        varState.push(VarDefStatus.ClassObj);
        for(int i = 0; i < node.son.size(); i++) {
            Node son = node.son.get(i);
            if(son instanceof VarDefStatNode)visit(son);
        }
        for(int i = 0; i < node.son.size(); i++) {
            Node son = node.son.get(i);
            if(son instanceof FuncDefNode)visit(son);
        }
        varState.pop();
    }

    @Override
    void visit(FuncDefNode node) throws Exception {
        if(node.inClass != null) {
            curFunc = new FuncFrame(classFuncLabel(node.inClass, node.name));
            curFunc.setClassObj(curClassObj);
            curFunc.addParam("A_this", TypeRef.curLen);
        }
        else {
            if(node.name.equals("main")) {
                curFunc = new FuncFrame(node.name);
            }
            else {
                curFunc = new FuncFrame(funcLabel(node.name));
            }
        }
        for(int i = 0; i < node.son.size(); i++) {
            Node son = node.son.get(i);
            if(i < node.son.size() - 1)curFunc.addParam(son.reg.get(), son.type.getSize());
            else {
                varState.push(VarDefStatus.LocalVar);
                visit(son);
                varState.pop();
            }
        }

        if(!nextLabel.isEmpty())insertQuad(new Quad("nop"));
        curFunc.setRetSize(node.type.getSize());

        insertFunc();
    }

    @Override
    void visit(ConsFuncDefNode node) throws Exception {
        curFunc = new FuncFrame(classFuncLabel(node.name, node.name));
        curFunc.setClassObj(curClassObj);
        curFunc.addParam("A_this", TypeRef.curLen);

        for(String var : classStr) {
            genNewFunc(genMemAccess(new Register("A_this", "A_this"), new ImmOprand(curClassObj.get(var))), new ImmOprand(256));
        }

        for(int i = 0; i < node.son.size(); i++) {
            Node son = node.son.get(i);
            if(i < node.son.size() - 1)curFunc.addParam(son.name, son.type.getSize());
            else {
                varState.push(VarDefStatus.LocalVar);
                visit(son);
                varState.pop();
            }
        }
        insertFunc();
    }

    @Override
    void visit(IfElseStatNode node) throws Exception {
        Node cond = node.son.get(0);
        Node stat1 = node.son.get(1);
        Node stat2 = node.son.get(2);
        int labelTrue = labelCnt++;
        int labelFalse = labelCnt++;
        int label = labelCnt++;
        genCondition(cond, labelTrue, labelFalse);
        addNextLabel(labelTrue);
        visit(stat1);
        insertQuad(new Quad("jump", new LabelName(Integer.toString(label))));
        addNextLabel(labelFalse);
        visit(stat2);
        insertQuad(new Quad("jump", new LabelName(Integer.toString(label))));
        addNextLabel(label);
    }

    @Override
    void visit(IfStatNode node) throws Exception {
        Node cond = node.son.get(0);
        Node stat = node.son.get(1);
        int labelTrue = labelCnt++;
        int labelFalse = labelCnt++;
        genCondition(cond, labelTrue, labelFalse);
        addNextLabel(labelTrue);

        visit(stat);
        insertQuad(new Quad("jump", new LabelName(Integer.toString(labelFalse))));
        addNextLabel(labelFalse);
    }

    @Override
    void visit(ForStatNode node) throws Exception {
        Node init = node.son.get(0);
        Node cond = node.son.get(1);
        Node loop = node.son.get(2);
        Node body = node.son.get(3);
        visit(init);

        int labelTrue = labelCnt++;
        int labelFalse = labelCnt++;
        int label = labelCnt++;
        if(cond instanceof EmptyExprNode) {
            insertQuad(new Quad("jump", new LabelName(Integer.toString(labelTrue))));
        }
        else {
            genCondition(cond, labelTrue, labelFalse);
        }

        addNextLabel(labelTrue);
        continueLabel.push(new Pair<>(label, false));
        breakLabel.push(labelFalse);
        visit(body);
        breakLabel.pop();
        if(continueLabel.pop().getValue().equals(true)) {
            addNextLabel(label);
        }

        visit(loop);
        if(cond instanceof EmptyExprNode) {
            insertQuad(new Quad("jump", new LabelName(Integer.toString(labelTrue))));
        }
        else {
            genCondition(cond, labelTrue, labelFalse);
        }
        addNextLabel(labelFalse);
    }

    @Override
    void visit(WhileStatNode node) throws Exception {
        Node cond = node.son.get(0);
        Node body = node.son.get(1);

        int labelTrue = labelCnt++;
        int labelFalse = labelCnt++;
        int label = labelCnt++;
        genCondition(cond, labelTrue, labelFalse);

        addNextLabel(labelTrue);
        continueLabel.push(new Pair<>(label, false));
        breakLabel.push(labelFalse);
        visit(body);
        breakLabel.pop();
        if(continueLabel.pop().getValue().equals(true)) {
            addNextLabel(label);
        }

        genCondition(cond, labelTrue, labelFalse);
        addNextLabel(labelFalse);
    }

    @Override
    void visit(ReturnStatNode node) throws Exception {
        if(node.son.size() == 0) {
            visitChild(node);
            insertQuad(new Quad("ret"));
            return;
        }
        Node son = node.son.get(0);
        visit(son);
        insertQuad(new Quad("ret", son.reg.clone()));
    }

    @Override
    void visit(BreakStatNode node) throws Exception {
        insertQuad(new Quad("jump", new LabelName(Integer.toString(breakLabel.peek()))));
    }

    @Override
    void visit(ContinueStatNode node) throws Exception {
        int label = continueLabel.pop().getKey();
        insertQuad(new Quad("jump", new LabelName(Integer.toString(label))));
        continueLabel.push(new Pair<>(label, true));
    }

    @Override
    void visit(BinaryExprNode node) throws Exception {
        Node left = node.son.get(0);
        Node right = node.son.get(1);

        if(left.type instanceof StringTypeRef && node.name.equals("+")) {
            node.reg = new Register("A_");
            genNewFunc(node.reg, new ImmOprand(256));
            genStringAdd(node, node.reg.clone());
            return;
        }

        if(node.type instanceof BoolTypeRef) {
            int labelTrue = labelCnt++, labelFalse = labelCnt++, label = labelCnt++;
            genCondition(node, labelTrue, labelFalse);
            Register val = new Register(getTmpName("V_"));

            addNextLabel(labelTrue);
            insertQuad(new Quad("mov", val, new ImmOprand(1)));
            insertQuad(new Quad("jump", new LabelName(Integer.toString(label))));

            addNextLabel(labelFalse);
            insertQuad(new Quad("mov", val, new ImmOprand(0)));
            insertQuad(new Quad("jump", new LabelName(Integer.toString(label))));

            addNextLabel(label);
            node.reg = val;
            return;
        }

        if(node.name.equals("=") && right.type instanceof BoolTypeRef && right.reg == null) {
            int labelTrue = labelCnt++, labelFalse = labelCnt++, label = labelCnt++;
            visit(left);
            genCondition(right, labelTrue, labelFalse);

            Oprand lReg = left.reg.clone();

            addNextLabel(labelTrue);
            insertQuad(new Quad("mov", lReg, new ImmOprand(1)));
            insertQuad(new Quad("jump", new LabelName(Integer.toString(label))));

            addNextLabel(labelFalse);
            insertQuad(new Quad("mov", lReg, new ImmOprand(0)));
            insertQuad(new Quad("jump", new LabelName(Integer.toString(label))));

            addNextLabel(label);
            return;
        }

        visit(left);
        visit(right);

        Oprand lReg = left.reg.clone();
        Oprand rReg = right.reg.clone();

        if(left.canBeImm() && right.canBeImm()) {
            node.toBeImm();
            calcImm(node, lReg, rReg);
            return;
        }

        node.reg = new Register(getTmpName(TypeRef.getPre(node.type)));

        String irOp = null, op = node.name;
        if(left.type instanceof IntTypeRef || left.type instanceof BoolTypeRef || left.type instanceof ClassTypeRef || left.type instanceof ArrTypeRef) {
            if(op.equals("=")) irOp = "mov";
            if(op.equals("+")) irOp = "add";
            if(op.equals("-")) irOp = "sub";
            if(op.equals("*")) irOp = "mul";
            if(op.equals("/")) irOp = "div";
            if(op.equals("%")) irOp = "mod";
            if(op.equals(">>")) irOp = "sal";
            if(op.equals("<<")) irOp = "sar";
            if(op.equals("&")) irOp = "and";
            if(op.equals("|")) irOp = "or";
            if(op.equals("^")) irOp = "xor";
            if(irOp.equals("mov")) {
                insertQuad(new Quad(irOp, lReg, rReg));
            }
            else {
                insertQuad(new ArthQuad(irOp, node.reg, lReg, rReg));
            }
            return;
        }
        if(left.type instanceof StringTypeRef) {
            if(node.name.equals("=")) {
                genStringFunc("S_strcpy", null, lReg, rReg);
                return;
            }
        }
        insertQuad(new Quad("mov", lReg.clone(), rReg.clone()));
    }

    @Override
    void visit(LeftUnaryExprNode node) throws Exception {
        visitChild(node);
        Node son = node.son.get(0);
        Oprand sonReg = son.reg;

        if(son.canBeImm()) {
            node.canBeImm();
            calcUnaryImm(node, sonReg);
            return;
        }

        String op = node.name;
        String irOp = null;
        if(op.equals("++"))irOp = "inc";
        if(op.equals("--"))irOp = "dec";
        if(irOp != null) {
            insertQuad(new ArthQuad(irOp, sonReg.clone()));
            node.reg = sonReg.clone();
            return;
        }
        if(op.equals("!") || op.equals("~"))irOp = "not";
        if(op.equals("-"))irOp = "neg";
        if(op.equals("+"))irOp = "mov";
        node.reg = new Register(getTmpName(sonReg.get().charAt(0) == 'A' ? "A_" : "V_"));
        insertQuad(new Quad(irOp, node.reg, sonReg.clone()));
    }

    @Override
    void visit(RightUnaryExprNode node) throws Exception {
        visitChild(node);
        Node son = node.son.get(0);
        Oprand sonReg = son.reg;

        node.reg = new Register(getTmpName("V_"));
        insertQuad(new Quad("mov", node.reg, sonReg.clone()));

        String op = node.name;
        insertQuad(new ArthQuad(op.equals("++") ? "inc" : "dec", sonReg.clone()));
    }

    @Override
    void visit(NewExprNode node) throws Exception {
        Node son = node.son.get(0);
        if(son.type instanceof ClassTypeRef) {
            node.reg = new Register(getTmpName("V_"));
            son.reg = new ImmOprand(((ClassTypeRef) son.type).getBelong().getSize());
            genNewFunc(node.reg, son.reg);
            ArrayList<Oprand> oprs = new ArrayList<>();
            ArrayList<String> pres = new ArrayList<>();
            oprs.add(node.reg);
            pres.add("A_");
            genParam(oprs, pres);

            String className = ((ClassTypeRef) son.type).getTypeName();
            String funcName = classFuncLabel(className, className);
            insertQuad(new Quad("call", null, new FuncName(funcName), new ImmOprand(1)));

            return;
        }
        visit(son);
        node.reg = son.reg.clone();
    }

    @Override
    void visit(TypeExprNode node) throws Exception {
        if(node.son.size() == 0) {
            if(node.type instanceof StringTypeRef) {
                node.reg = new Register(getTmpName("A_"));
                genNewFunc(node.reg, new ImmOprand(256));
            }
            else {
                node.reg = null;
            }
            return;
        }
        Node len = node.son.get(0);
        Node typ = node.son.get(1);
        int size = TypeRef.curLen;
        if(typ.type instanceof StringTypeRef) size = 256;

        if(len instanceof EmptyExprNode) {
            node.reg = null;
            return;
        }
        visit(len);
        node.reg = new Register(getTmpName("A_"));

        Oprand tmp;
        if(len.canBeImm()) {
            long val = Long.parseLong(((ImmOprand) len.reg).get());
            tmp = new ImmOprand(val * size + size);
        }
        else {
            tmp = new Register(getTmpName("V_"));
            insertQuad(new ArthQuad("mul", tmp, len.reg.clone(), new ImmOprand(size)));
            insertQuad(new ArthQuad("add", tmp.clone(), tmp.clone(), new ImmOprand(size)));
        }
        genNewFunc(node.reg, tmp);
        insertQuad(new Quad("mov", genMemAccess(node.reg), changeOprToReg(len.reg)));
        if(typ.type instanceof StringTypeRef || (typ.type instanceof ArrTypeRef && !(typ.son.get(0) instanceof EmptyExprNode))) {
            Oprand low = new ImmOprand(0);
            Oprand high = len.reg.clone();
            Oprand base = node.reg;
            String curLoop = getLoopName();
            Oprand tmpReg = new Register(curLoop);
            insertQuad(new Quad("mov", tmpReg, low));
            insertQuad(new Quad("cmp", tmpReg.clone(), high));
            int labelTrue = labelCnt++, labelFalse = labelCnt++;
            insertQuad(new CJumpQuad("jl", new LabelName(Integer.toString(labelTrue)), new LabelName(Integer.toString(labelFalse))));
            addNextLabel(labelTrue);

            visit(typ);

            insertQuad(new Quad("mov", genMemAccess(base.clone(), tmpReg, new ImmOprand(TypeRef.curLen), new ImmOprand(TypeRef.curLen)), typ.reg.clone()));
            insertQuad(new ArthQuad("add", tmpReg.clone(), tmpReg.clone(), new ImmOprand(1)));
            insertQuad(new Quad("cmp", tmpReg.clone(), high.clone()));
            insertQuad(new CJumpQuad("jl", new LabelName(Integer.toString(labelTrue)), new LabelName(Integer.toString(labelFalse))));
            addNextLabel(labelFalse);
        }
    }

    @Override
    void visit(FuncExprNode node) throws Exception {
        visitChild(node);
        if(node.inClass != null) {
            genClassFunc(node, node.inClass, new Register("A_this"));
            return;
        }
        String func = funcLabel(node.name);
        ArrayList<Oprand> oprs = new ArrayList<>();
        ArrayList<String> pres = new ArrayList<>();
        int n = node.son.size();
        for(int i = 0; i < n; i++) {
            oprs.add(node.son.get(i).reg);
            pres.add(TypeRef.getPre(node.son.get(i).type));
        }
        genParam(oprs, pres);

        if(node.type instanceof VoidTypeRef) {
            node.reg = null;
            insertQuad(new Quad("call", null, new FuncName(func), new ImmOprand(n)));
        }
        else {
            node.reg = new Register(getTmpName(TypeRef.getPre(node.type)));
            insertQuad(new Quad("call", null, new FuncName(func), new ImmOprand(n)));
            insertQuad(new Quad("mov", node.reg, new Register("rax")));
        }
    }

    @Override
    void visit(ArrExprNode node) throws Exception {
        visitChild(node);
        Node son = node.son.get(0);
        Node index = node.son.get(1);

        Oprand tmp1 = son.reg;
        Oprand tmp2 = index.reg;
        if(tmp1 instanceof MemAccess)tmp1 = changeOprToReg(tmp1);
        if(tmp2 instanceof MemAccess)tmp2 = changeOprToReg(tmp2);

        node.reg = genMemAccess(tmp1.clone(), tmp2.clone(), new ImmOprand(TypeRef.curLen), new ImmOprand(TypeRef.curLen));
    }

    @Override
    void visit(ObjExprNode node) throws Exception {
        Node son = node.son.get(0);
        Node mem = node.son.get(1);
        visit(son);
        if(mem instanceof VarExprNode) {
            son.reg = changeOprToReg(son.reg);
            node.reg = genMemAccess(son.reg.clone(), new ImmOprand(((ClassTypeRef)son.type).getBelong().getSize(mem.name)));
            return;
        }
        if(son.type instanceof ClassTypeRef) {
            genClassFunc(mem, ((ClassTypeRef) son.type).getTypeName(), son.reg.clone());
            node.reg = mem.reg;
            return;
        }
        if(son.type instanceof StringTypeRef) {
            Register tmp = new Register(getTmpName("V_"));
            node.reg = tmp;
            Register ttmp = new Register("rax");

            String func = mem.name;
            if(func.equals("length")) {
                ArrayList<Oprand> oprs = new ArrayList<>();
                ArrayList<String> pres = new ArrayList<>();
                oprs.add(son.reg);
                pres.add("A_");
                genParam(oprs, pres);
                insertQuad(new Quad("call", null, new FuncName("S_strlen"), new ImmOprand(1)));
                insertQuad(new Quad("mov", tmp, ttmp));
                return;
            }
            if(func.equals("substring")) {
                Node left = mem.son.get(0), right = mem.son.get(1);
                visit(left);
                visit(right);
                ArrayList<Oprand> oprs = new ArrayList<>();
                ArrayList<String> pres = new ArrayList<>();
                oprs.add(son.reg);
                oprs.add(left.reg);
                oprs.add(right.reg);
                pres.add("A_");
                pres.add("V_");
                pres.add("V_");
                genParam(oprs, pres);
                insertQuad(new Quad("call", null, new FuncName("S_substring"), new ImmOprand(3)));
                insertQuad(new Quad("mov", tmp, ttmp));
                return;
            }
            if(func.equals("parseInt")) {
                ArrayList<Oprand> oprs = new ArrayList<>();
                ArrayList<String> pres = new ArrayList<>();
                oprs.add(son.reg);
                pres.add("A_");
                genParam(oprs, pres);
                insertQuad(new Quad("call", null, new FuncName("S_parseInt"), new ImmOprand(1)));
                insertQuad(new Quad("mov", tmp, ttmp));
                return;
            }
            if(func.equals("ord")) {
                Node memSon = mem.son.get(0);
                visit(memSon);
                ArrayList<Oprand> oprs = new ArrayList<>();
                ArrayList<String> pres = new ArrayList<>();
                oprs.add(son.reg);
                oprs.add(memSon.reg);
                pres.add("A_");
                pres.add("V_");
                genParam(oprs, pres);
                insertQuad(new Quad("call", null, new FuncName("S_ord"), new ImmOprand(2)));
                insertQuad(new Quad("mov", tmp, ttmp));
                return;
            }
            return;
        }
        node.reg = new Register(getTmpName("A_"));
        insertQuad(new Quad("mov", node.reg, genMemAccess(son.reg.clone())));
    }

    @Override
    void visit(IntLiteralNode node) throws Exception {
        node.reg = new ImmOprand(Long.parseLong(node.name));
        node.toBeImm();
    }

    @Override
    void visit(BoolLiteralNode node) throws Exception {
        node.reg = new ImmOprand(node.name.equals("true") ? 1 : 0);
        node.toBeImm();
    }

    @Override
    void visit(NullLiteralNode node) throws Exception {
        node.reg = new ImmOprand(0);
        node.toBeImm();
    }

    @Override
    void visit(StringLiteralNode node) throws Exception {
        node.reg = new StrImmOprand(linearCode.insertStringConst(node.name));
        node.toBeImm();
    }
}
