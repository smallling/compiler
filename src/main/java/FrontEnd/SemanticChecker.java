package main.java.FrontEnd;

import main.java.MyUtil.OprandClass.GeneralMemAccess;
import main.java.MyUtil.OprandClass.ImmOprand;
import main.java.MyUtil.OprandClass.MemAccess;
import main.java.MyUtil.OprandClass.Register;
import main.java.MyUtil.Pair;
import main.java.MyUtil.ScopeClass.ClassScope;
import main.java.MyUtil.ScopeClass.GeneralScope;
import main.java.MyUtil.ScopeClass.LocalScope;
import main.java.MyUtil.ScopeClass.Scope;
import main.java.MyUtil.TypeSystem.*;

import java.util.ArrayList;
import java.util.HashMap;

public class SemanticChecker extends AstVisitor{
    static public HashMap<String, Node> funcMap = new HashMap<>();

    public GeneralScope<TypeRef> rootScope;
    int iterCnt;
    String curClassName;
    TypeRef returnType;

    public SemanticChecker(GeneralScope<TypeRef> other) {
        rootScope = other;
        iterCnt = 0;
        curClassName = "";
        returnType = null;
    }

    boolean checkTypeExit(TypeRef nowType) {
        if(nowType instanceof ArrTypeRef)nowType = ((ArrTypeRef) nowType).getSingleType();
        if(nowType instanceof ClassTypeRef) {
            TypeRef belong = rootScope.findItem(((ClassTypeRef) nowType).getTypeName());
            if(belong == null)return false;
            else ((ClassTypeRef) nowType).belongTo((ClassDefTypeRef) belong);
        }
        return true;
    }

    boolean checkLeftValue(ExprNode node) {
        if(node instanceof VarExprNode)return true;
        if(node instanceof ObjExprNode && checkLeftValue((ExprNode) node.son.get(1)))return true;
        if(node instanceof ArrExprNode)return true;
        return false;
    }

    boolean checkFuncForm(FuncTypeRef func, FuncExprNode node) {
        if(node.son.size() != func.getParamSize())return false;
        for(int i = 0; i < node.son.size(); i++) {
            Node sonNode = node.son.get(i);
            VarTypeRef nowParam = func.getParam(i);
            if(!sonNode.type.equals(nowParam) && !((sonNode.type instanceof NullTypeRef) && (nowParam instanceof ClassTypeRef)))return false;
        }
        return true;
    }

    TypeRef checkArr(ArrTypeRef curArr, ArrExprNode curNode) throws NoCastExpr {
        Node sonNode = curNode.son.get(0);
        VarTypeRef sonType = curArr.getInnerType();
        if(sonType instanceof SingleTypeRef) {
            if(!(sonNode instanceof VarExprNode))throw new NoCastExpr(curNode.loc);
            return sonType;
        }
        else if(!(sonNode instanceof ArrExprNode)) throw new NoCastExpr(curNode.loc);
        else return checkArr((ArrTypeRef) sonType, (ArrExprNode) sonNode);
    }

    TypeRef checkClass(ClassDefTypeRef curClass, Node curNode) throws Exception {
        if(!curClass.checkExit(curNode.name))throw new NoDefinedVarError(curNode.loc);
        TypeRef curType = curClass.getTypeRef(curNode.name);
        if(curNode instanceof FuncExprNode) {
            if(!(curType instanceof FuncTypeRef))throw new ReDefinedError(curNode.loc);
            if(!checkFuncForm((FuncTypeRef)curType, (FuncExprNode) curNode))throw new ReDefinedError(curNode.loc);
            return ((FuncTypeRef) curType).getReturnType();
        }
        else if(curNode instanceof ArrExprNode) {
            if(!(curType instanceof ArrTypeRef))throw new NoCastExpr(curNode.loc);
            return checkArr((ArrTypeRef) curType, (ArrExprNode) curNode);
        }
        else {
            if(!(curType instanceof VarTypeRef))throw new NoDefinedVarError(curNode.loc);
            return curType;
        }
    }

    @Override
    void visit(VarDefNode node) throws Exception {
        if((node.type instanceof VoidTypeRef)
        || ((node.type instanceof ArrTypeRef) && (((ArrTypeRef) node.type).getSingleType() instanceof VoidTypeRef)))throw new VoidDefVarError(node.loc);
        if(!checkTypeExit(node.type))throw new NoDefinedTypeError(node.loc);
        visitChild(node);
        if(node.son.size() > 0) {
            ExprNode tmpNode = (ExprNode)node.son.get(0);
            if(!AssignOpType.checkExpr(node.type, tmpNode.type))throw new NoCastExpr(tmpNode.loc);
        }
        Scope<TypeRef> curScope = node.belong;
        if(curScope instanceof ClassScope) node.inClass = curClassName;
        if(!curScope.addIteam(node.name, node.type))throw new ReDefinedError(node.loc);

        String tmpName = TypeRef.getPre(node.type) + node.name + node.belong.getName();
        if(curScope instanceof GeneralScope)node.reg = new GeneralMemAccess(tmpName);
        else node.reg = new Register(tmpName, tmpName);
    }

    @Override
    void visit(ClassDefNode node) throws Exception {
        curClassName = node.name;
        for(int i = 0; i < node.son.size(); i++) {
            Node sonNode = node.son.get(i);
            if(!(sonNode instanceof VarDefStatNode)) visit(sonNode);
            else {
                if((sonNode.type instanceof ClassTypeRef) && (rootScope.findItem(((ClassTypeRef) sonNode.type).getTypeName()) == null))throw new NoDefinedTypeError(sonNode.loc);
                for(int j = 0; j < sonNode.son.size(); j++) {
                    Node sonSonNode = sonNode.son.get(j);
                    String tmpName = TypeRef.getPre(sonSonNode.type) + sonSonNode.name + sonSonNode.belong.getName();
                    TypeRef curType = sonSonNode.type;
                    if(curType instanceof ArrTypeRef)curType = ((ArrTypeRef) curType).getSingleType();
                    if(curType instanceof ClassTypeRef)((ClassTypeRef) curType).belongTo((ClassDefTypeRef) rootScope.findItem(((ClassTypeRef) curType).getTypeName()));
                    sonSonNode.reg = new Register(tmpName);
                }
            }
        }
        node.type = rootScope.findItem(node.name);
        curClassName = "";
    }

    @Override
    void visit(FuncDefNode node) throws Exception {
        if(!checkTypeExit(node.type)) throw new NoDefinedTypeError(node.loc);
        returnType = node.type;
        visitChild(node);
        returnType = null;
        if(node.belong instanceof ClassScope)node.inClass = curClassName;
        String funcName = node.name;
        if(node.belong instanceof ClassScope)funcName = node.inClass + "." + node.name;
        funcMap.put(funcName, node.son.get(node.son.size() - 1));
    }

    @Override
    void visit(ConsFuncDefNode node) throws Exception {
        if(!node.name.equals(curClassName)) throw new WrongNameConsFunc(node.loc);
        returnType = node.type;
        visitChild(node);
        returnType = null;
        node.inClass = curClassName;
    }

    @Override
    void visit(ExprStatNode node) throws Exception {
        visitChild(node);
    }

    @Override
    void visit(IfElseStatNode node) throws Exception {
        visitChild(node);
    }

    @Override
    void visit(IfStatNode node) throws Exception {
        visitChild(node);
        ExprNode tmpNode = (ExprNode) node.son.get(0);
        if(!tmpNode.type.equalsSingleType("bool"))throw new NotConditionExpr(tmpNode.loc);
    }

    @Override
    void visit(ForStatNode node) throws Exception {
        iterCnt++;
        visitChild(node);
        iterCnt--;
        ExprNode tmpNode = (ExprNode)node.son.get(1);
        if(!(tmpNode instanceof EmptyExprNode) && !tmpNode.type.equalsSingleType("bool"))throw new NotConditionExpr(node.loc);
    }

    @Override
    void visit(WhileStatNode node) throws Exception {
        iterCnt++;
        visitChild(node);
        iterCnt--;
        ExprNode tmpNode = (ExprNode)node.son.get(0);
        if(!tmpNode.type.equalsSingleType("bool"))throw new NotConditionExpr(node.loc);

    }

    @Override
    void visit(ReturnStatNode node) throws Exception {
        //if(returnType == null)throw new DisMatchedFormError(node.loc);
        if(returnType.equalsSingleType("void")) {
            if(node.son.size() > 0)throw new DisMatchedFormError(node.loc);
        }
        else {
            if(node.son.size() == 0)throw new DisMatchedFormError(node.loc);
            Node sonNode = node.son.get(0);
            visitChild(node);
            if((returnType instanceof ArrTypeRef) || (returnType instanceof ClassTypeRef)){
                if(!returnType.equals(sonNode.type) && !(sonNode.type instanceof NullTypeRef))throw new DisMatchedFormError(node.loc);
            }
            else {
                if(!returnType.equals(sonNode.type))throw new DisMatchedFormError(node.loc);
            }
        }
    }

    @Override
    void visit(BreakStatNode node) throws Exception {
        if(iterCnt == 0)throw new BrkOutIterStat(node.loc);
    }

    @Override
    void visit(ContinueStatNode node) throws Exception {
        if(iterCnt == 0)throw new CntOutIterStat(node.loc);
    }

    @Override
    void visit(VarDefStatNode node) throws Exception {
        visitChild(node);
        if(node.son.size() > 0) node.type = node.son.get(0).type;
    }

    @Override
    void visit(BinaryExprNode node) throws Exception {
        visitChild(node);
        ExprNode l = (ExprNode)node.son.get(0);
        ExprNode r = (ExprNode)node.son.get(1);
        OpType op = OpType.belongTo(node.name);
        if(!l.type.equals(r.type) && !((op instanceof AssignOpType) && AssignOpType.checkExpr(l.type, r.type))
        && !((op instanceof RelativeOpType) && ((RelativeOpType) op).checkExpr(l.type, r.type))) {
            throw new NoCastExpr(node.loc);
        }
        if(op instanceof AssignOpType) {
            if(!checkLeftValue(l)) throw new NotLeftValue(node.loc);
            if((l instanceof VarExprNode) && l.name.equals("this")) throw new ThisBeAssigned(l.loc);
            node.type = TypeRef.buildTypeRef("void");
        }
        else if(op.containsType(l.type)) {
            if(op instanceof RelativeOpType) {
                node.type = TypeRef.buildTypeRef("bool");
            }
            else {
                node.type = l.type;
            }
        }
        else throw new NoDefinedOpError(node.loc);
    }

    @Override
    void visit(LeftUnaryExprNode node) throws Exception {
        visitChild(node);
        ExprNode tmpNode = (ExprNode) node.son.get(0);
        OpType op = OpType.belongTo(node.name);
        if(!checkLeftValue(tmpNode) && (op instanceof SelfPmOpType))throw new NotLeftValue(tmpNode.loc);
        if(!op.containsType(tmpNode.type))throw new NoCastExpr(node.loc);
        node.type = tmpNode.type;
    }

    @Override
    void visit(RightUnaryExprNode node) throws Exception {
        visitChild(node);
        ExprNode tmpNode = (ExprNode) node.son.get(0);
        OpType op = OpType.belongTo(node.name);
        if(!checkLeftValue(tmpNode) && (op instanceof SelfPmOpType))throw new NotLeftValue(tmpNode.loc);
        if(!op.containsType(tmpNode.type))throw new NoCastExpr(node.loc);
        node.type = tmpNode.type;
    }

    @Override
    void visit(NewExprNode node) throws Exception {
        visitChild(node);
        node.type = node.son.get(0).type;
    }

    @Override
    void visit(TypeExprNode node) throws Exception {
        visitChild(node);
        if(node.son.size() > 0) {
            node.type = new ArrTypeRef((VarTypeRef) node.son.get(1).type);
        }
        else {
            if(!checkTypeExit(node.type))throw new NoDefinedTypeError(node.loc);
        }
    }

    @Override
    void visit(FuncExprNode node) throws Exception {
        visitChild(node);
        Pair<Scope<TypeRef>, TypeRef> now = node.belong.findVarName(node.name);
        if(now == null)throw new NoDefinedTypeError(node.loc);
        if(now.getKey() instanceof ClassScope)node.inClass = curClassName;
        TypeRef tmp = now.getValue();
        if(!(tmp instanceof FuncTypeRef)) throw new ReDefinedError(node.loc);
        if(!checkFuncForm((FuncTypeRef) tmp, node))throw new NoDefinedTypeError(node.loc);
        node.type = ((FuncTypeRef) tmp).getReturnType();
    }

    @Override
    void visit(ArrExprNode node) throws Exception {
        visitChild(node);
        Node sonNode = node.son.get(0);
        if(!(sonNode.type instanceof ArrTypeRef))throw new NullPointer(node.loc);
        node.type = ((ArrTypeRef) sonNode.type).getInnerType();
    }

    @Override
    void visit(ObjExprNode node) throws Exception {
        Node sonNode = node.son.get(0);
        Node objNode = node.son.get(1);
        visit(sonNode);
        if(sonNode.type instanceof ArrTypeRef) {
            if(objNode.son.size() == 0 && objNode.name.equals("size"))node.type = new IntTypeRef();
            else throw new NoDefinedTypeError(objNode.loc);
            return;
        }

        if(!(sonNode.type instanceof SpecialTypeRef))throw new NoCastExpr(node.loc);
        ClassDefTypeRef tmp = (ClassDefTypeRef) rootScope.findItem(((SpecialTypeRef) sonNode.type).getTypeName());

        for(int i = 0; i <objNode.son.size(); i++) {
            visit(objNode.son.get(i));
        }
        node.type = checkClass(tmp, objNode);

        if(node.type instanceof ClassTypeRef) {
            TypeRef cur = tmp.getTypeRef(objNode.name);
            String curName = null;
            if(cur instanceof SpecialTypeRef) {
                curName = ((SpecialTypeRef) cur).getTypeName();
            }
            else {
                curName = ((FuncTypeRef) cur).getTypeName();
            }
            ((ClassTypeRef) node.type).belongTo((ClassDefTypeRef) rootScope.findItem(curName));
        }
        objNode.inClass = ((SpecialTypeRef) sonNode.type).getTypeName();
        objNode.type = node.type;
    }

    @Override
    void visit(VarExprNode node) throws Exception {
        if(node.name.equals("this")) {
            if(curClassName == "") throw new ThisOutOfClass(node.loc);
            node.type = new ClassTypeRef(curClassName);
            ((ClassTypeRef) node.type).belongTo((ClassDefTypeRef) rootScope.findItem(curClassName));
            node.reg = new Register("A_this.", "A_this.");
        }
        else {
            Pair<Scope<TypeRef>, TypeRef> now = node.belong.findVarName(node.name);
            if(now == null)throw new NoDefinedVarError(node.loc);
            node.type = now.getValue();
            if(now.getKey() instanceof ClassScope) {
                node.inClass = curClassName;
                ClassDefTypeRef tmp = (ClassDefTypeRef) rootScope.findItem(curClassName);
                long offset = tmp.getSize(node.name);
                node.reg = new MemAccess(new Register("A_this.", "A_this."), new ImmOprand(offset));
            }
            else {
                String tmpName = TypeRef.getPre(node.type) + node.name + now.getKey().getName();
                if(now.getKey() instanceof GeneralScope) {
                    node.reg = new GeneralMemAccess(tmpName);
                }
                else if(now.getKey() instanceof LocalScope){
                    node.reg = new Register(tmpName, tmpName);
                }
            }
        }
    }
}
