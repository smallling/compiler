package main.java.FrontEnd;

public abstract class AstVisitor {
    void visit(Node node) throws Exception {
        if (node instanceof CodeNode) visit((CodeNode) node);
        else if (node instanceof VarDefNode) visit((VarDefNode) node);
        else if (node instanceof ClassDefNode) visit((ClassDefNode) node);
        else if (node instanceof ConsFuncDefNode) visit((ConsFuncDefNode) node);
        else if (node instanceof FuncDefNode) visit((FuncDefNode) node);
        else if (node instanceof CompStatNode) visit((CompStatNode) node);
        else if (node instanceof ExprStatNode) visit((ExprStatNode) node);
        else if (node instanceof IfElseStatNode) visit((IfElseStatNode) node);
        else if (node instanceof IfStatNode) visit((IfStatNode) node);
        else if (node instanceof ForStatNode) visit((ForStatNode) node);
        else if (node instanceof WhileStatNode) visit((WhileStatNode) node);
        else if (node instanceof ReturnStatNode) visit((ReturnStatNode) node);
        else if (node instanceof BreakStatNode) visit((BreakStatNode) node);
        else if (node instanceof ContinueStatNode) visit((ContinueStatNode) node);
        else if (node instanceof EmptyStatNode) visit((EmptyStatNode) node);
        else if (node instanceof VarDefStatNode) visit((VarDefStatNode) node);
        else if (node instanceof EmptyExprNode) visit((EmptyExprNode) node);
        else if (node instanceof BinaryExprNode) visit((BinaryExprNode) node);
        else if (node instanceof LeftUnaryExprNode) visit((LeftUnaryExprNode) node);
        else if (node instanceof RightUnaryExprNode) visit((RightUnaryExprNode) node);
        else if (node instanceof NewExprNode) visit((NewExprNode) node);
        else if (node instanceof TypeExprNode) visit((TypeExprNode) node);
        else if (node instanceof FuncExprNode) visit((FuncExprNode) node);
        else if (node instanceof ArrExprNode) visit((ArrExprNode) node);
        else if (node instanceof ObjExprNode) visit((ObjExprNode) node);
        else if (node instanceof VarExprNode) visit((VarExprNode) node);
        else if (node instanceof IntLiteralNode) visit((IntLiteralNode) node);
        else if (node instanceof BoolLiteralNode) visit((BoolLiteralNode) node);
        else if (node instanceof NullLiteralNode) visit((NullLiteralNode) node);
        else if (node instanceof StringLiteralNode) visit((StringLiteralNode) node);
    }

    void visitChild(Node node) throws Exception {
        if (node == null) return;
        for (int i = 0; i < node.son.size(); ++i) {
            visit(node.son.get(i));
        }
    }

    void visit(CodeNode node) throws Exception {
        visitChild(node);
    }

    void visit(VarDefNode node) throws Exception {
        visitChild(node);
    }

    void visit(ClassDefNode node) throws Exception {
        visitChild(node);
    }

    void visit(FuncDefNode node) throws Exception {
        visitChild(node);
    }

    void visit(ConsFuncDefNode node) throws Exception {
        visitChild(node);
    }

    void visit(CompStatNode node) throws Exception {
        visitChild(node);
    }

    void visit(ExprStatNode node) throws Exception {
        visitChild(node);
    }

    void visit(IfElseStatNode node) throws Exception {
        visitChild(node);
    }

    void visit(IfStatNode node) throws Exception {
        visitChild(node);
    }

    void visit(ForStatNode node) throws Exception {
        visitChild(node);
    }

    void visit(WhileStatNode node) throws Exception {
        visitChild(node);
    }

    void visit(ReturnStatNode node) throws Exception {
        visitChild(node);
    }

    void visit(BreakStatNode node) throws Exception {
        visitChild(node);
    }

    void visit(ContinueStatNode node) throws Exception {
        visitChild(node);
    }

    void visit(EmptyStatNode node) throws Exception {
        visitChild(node);
    }

    void visit(VarDefStatNode node) throws Exception {
        visitChild(node);
    }

    void visit(EmptyExprNode node) throws Exception {
        visitChild(node);
    }

    void visit(BinaryExprNode node) throws Exception {
        visitChild(node);
    }

    void visit(LeftUnaryExprNode node) throws Exception {
        visitChild(node);
    }

    void visit(RightUnaryExprNode node) throws Exception {
        visitChild(node);
    }

    void visit(NewExprNode node) throws Exception {
        visitChild(node);
    }

    void visit(TypeExprNode node) throws Exception {
        visitChild(node);
    }

    void visit(FuncExprNode node) throws Exception {
        visitChild(node);
    }

    void visit(ArrExprNode node) throws Exception {
        visitChild(node);
    }

    void visit(ObjExprNode node) throws Exception {
        visitChild(node);
    }

    void visit(VarExprNode node) throws Exception {
        visitChild(node);
    }

    void visit(IntLiteralNode node) throws Exception {
        visitChild(node);
    }

    void visit(BoolLiteralNode node) throws Exception {
        visitChild(node);
    }

    void visit(NullLiteralNode node) throws Exception {
        visitChild(node);
    }

    void visit(StringLiteralNode node) throws Exception {
        visitChild(node);
    }
}
