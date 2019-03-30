package main.java.FrontEnd;

import main.java.MyUtil.TypeSystem.*;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.lang.reflect.MalformedParameterizedTypeException;

public class BuildAstVisitor extends MxStarBaseVisitor <Node> {
    @Override
    public Node visitCode(MxStarParser.CodeContext ctx) {
        Node res = new CodeNode();
        for(int i = 0; i < ctx.getChildCount(); i++) {
            res.son.add(visit(ctx.getChild(i)));
        }
        return res;
    }

    @Override
    public Node visitClassDef(MxStarParser.ClassDefContext ctx) {
        Node res = new ClassDefNode();
        res.son.addAll(visit(ctx.classBody()).son);
        res.name = ctx.Identifier().getText();
        res.loc = new Location(ctx.Identifier().getSymbol());
        return res;
    }

    @Override
    public Node visitClassBody(MxStarParser.ClassBodyContext ctx) {
        Node res = new ClassDefNode();
        for(int i = 0; i < ctx.varDefStatementWithoutInit().size(); i++) {
            res.son.add(visit(ctx.varDefStatementWithoutInit(i)));
        }
        for(int i = 0; i < ctx.functionDef().size(); i++) {
            res.son.add(visit(ctx.functionDef(i)));
        }
        res.son.add(visit(ctx.constructionFunction()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitFunctionDef(MxStarParser.FunctionDefContext ctx) {
        Node res = new FuncDefNode();
        res.type = TypeRef.buildTypeRef(ctx.typeName().getText());
        res.name = ctx.Identifier().getText();
        res.son.addAll(visit(ctx.parameterList()).son);
        res.son.add(visit(ctx.compoundStatement()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitConstructionFunction(MxStarParser.ConstructionFunctionContext ctx) {
        Node res = new ConsFuncDefNode();
        res.name = ctx.Identifier().getText();
        res.type = new VoidTypeRef();
        res.son.add(visit(ctx.compoundStatement()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitParameterList(MxStarParser.ParameterListContext ctx) {
        Node res = new FuncDefNode();
        for(int i = 0; i < ctx.parameter().size(); i++) {
            res.son.add(visit(ctx.parameter(i)));
        }
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitParameter(MxStarParser.ParameterContext ctx) {
        Node res = new VarDefNode();
        res.type = TypeRef.buildTypeRef(ctx.typeName().getText());
        res.name = ctx.varName().getText();
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitCompStat(MxStarParser.CompStatContext ctx) {
        return visit(ctx.compoundStatement());
    }

    @Override
    public Node visitExprStat(MxStarParser.ExprStatContext ctx) {
        return visit(ctx.expressionStatement());
    }

    @Override
    public Node visitSeleStat(MxStarParser.SeleStatContext ctx) {
        return visit(ctx.selectionStatement());
    }

    @Override
    public Node visitIterStat(MxStarParser.IterStatContext ctx) {
        return visit(ctx.iterativeStatement());
    }

    @Override
    public Node visitJumpStat(MxStarParser.JumpStatContext ctx) {
        return visit(ctx.jumpStatement());
    }

    @Override
    public Node visitVarDefStat(MxStarParser.VarDefStatContext ctx) {
        return visit(ctx.varDefStatement());
    }

    @Override
    public Node visitEmptyStat(MxStarParser.EmptyStatContext ctx) {
        return visit(ctx.emptyStatement());
    }

    @Override
    public Node visitEmptyStatement(MxStarParser.EmptyStatementContext ctx) {
        Node res = new EmptyStatNode();
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitCompoundStatement(MxStarParser.CompoundStatementContext ctx) {
        Node res = new CompStatNode();
        for(int i = 0; i < ctx.statement().size(); i++) {
            res.son.add(visit(ctx.statement(i)));
        }
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitExpressionStatement(MxStarParser.ExpressionStatementContext ctx) {
        Node res = new ExprStatNode();
        res.son.add(visit(ctx.expression()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitIfStat(MxStarParser.IfStatContext ctx) {
        Node res = new IfStatNode();
        //res.elseExit = false;
        res.son.add(visit(ctx.expression()));
        res.son.add(visit(ctx.statement()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitIfElseStat(MxStarParser.IfElseStatContext ctx) {
        Node res = new IfElseStatNode();
        res.son.add(visit(ctx.expression()));
        res.son.add(visit(ctx.statement(0)));
        res.son.add(visit(ctx.statement(1)));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitWhileStat(MxStarParser.WhileStatContext ctx) {
        return visit(ctx.whileStatement());
    }

    @Override
    public Node visitForStat(MxStarParser.ForStatContext ctx) {
        return visit(ctx.forStatement());
    }

    @Override
    public Node visitWhileStatement(MxStarParser.WhileStatementContext ctx) {
        Node res = new WhileStatNode();
        res.son.add(visit(ctx.expression()));
        res.son.add(visit(ctx.statement()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitForStatement(MxStarParser.ForStatementContext ctx) {
        Node res = new ForStatNode();
        if(ctx.forInitExpr == null)res.son.add(new EmptyExprNode());
        else res.son.add(visit(ctx.forInitExpr));
        if(ctx.forCondExpr == null)res.son.add(new EmptyExprNode());
        else res.son.add(visit(ctx.forCondExpr));
        if(ctx.forLoopExpr == null)res.son.add(new EmptyExprNode());
        else res.son.add(visit(ctx.forLoopExpr));
        res.son.add(visit(ctx.statement()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitReturnJump(MxStarParser.ReturnJumpContext ctx) {
        Node res = new ReturnStatNode();
        if(ctx.expression() != null)res.son.add(visit(ctx.expression()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitBreakJump(MxStarParser.BreakJumpContext ctx) {
        Node res = new BreakStatNode();
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitContinueJump(MxStarParser.ContinueJumpContext ctx) {
        Node res = new ContinueStatNode();
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitVarDefStatement(MxStarParser.VarDefStatementContext ctx) {
        Node res = new VarDefStatNode();
        res.type = TypeRef.buildTypeRef(ctx.typeName().getText());
        for(int i = 0; i < ctx.varDef().size(); i++) {
            Node tmp = visit(ctx.varDef(i));
            tmp.type = res.type;
            res.son.add(tmp);
        }
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitVarDefStatementWithoutInit(MxStarParser.VarDefStatementWithoutInitContext ctx) {
        Node res = new VarDefStatNode();
        res.type = TypeRef.buildTypeRef(ctx.typeName().getText());
        for(int i = 0; i < ctx.Identifier().size(); i++) {
            Node tmp = new VarDefNode();
            tmp.name = ctx.Identifier(i).getText();
            tmp.type = res.type;
            tmp.loc = new Location(ctx.Identifier(i).getSymbol());
            res.son.add(tmp);
        }
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitVarWithoutInit(MxStarParser.VarWithoutInitContext ctx) {
        Node res = new VarDefNode();
        res.name = ctx.Identifier().getText();
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitVarWithInit(MxStarParser.VarWithInitContext ctx) {
        Node res = new VarDefNode();
        res.name = ctx.Identifier().getText();
        res.son.add(visit(ctx.expression()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitIntLite(MxStarParser.IntLiteContext ctx) {
        Node res = new IntLiteralNode();
        res.name = ctx.IntLiteral().getText();
        res.type = new IntTypeRef();
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitBoolLite(MxStarParser.BoolLiteContext ctx) {
        Node res = new BoolLiteralNode();
        res.name = ctx.boolLiteral().getText();
        res.type = new BoolTypeRef();
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitStringLite(MxStarParser.StringLiteContext ctx) {
        Node res = new StringLiteralNode();
        String tmp = ctx.StringLiteral().getText();
        res.name = "";
        for(int i = 1; i < tmp.length() - 1; i++) {
            if (tmp.charAt(i) != '\\') res.name += tmp.charAt(i);
            else {
                if (tmp.charAt(i + 1) == '\\') res.name += '\\';
                if (tmp.charAt(i + 1) == 'n') res.name += '\n';
                if (tmp.charAt(i + 1) == 't') res.name += '\t';
                if (tmp.charAt(i + 1) == '\"') res.name += '\"';
            }
        }
        res.type = new StringTypeRef();
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitNullLite(MxStarParser.NullLiteContext ctx) {
        Node res = new NullLiteralNode();
        res.name = "null";
        res.type = new NullTypeRef();
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitExpression(MxStarParser.ExpressionContext ctx) {
        return visit(ctx.assignmentExpr());
    }

    @Override
    public Node visitExprList(MxStarParser.ExprListContext ctx) {
        Node res = new FuncExprNode();
        for (int i = 0; i < ctx.expression().size(); i++)
            res.son.add(visit(ctx.expression(i)));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitLiteralOriExpr(MxStarParser.LiteralOriExprContext ctx) {
        return visit(ctx.literal());
    }

    @Override
    public Node visitVarOriExpr(MxStarParser.VarOriExprContext ctx) {
        Node res = new VarExprNode();
        res.name = ctx.varName().getText();
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitSonOriExpr(MxStarParser.SonOriExprContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Node visitOriPriExpr(MxStarParser.OriPriExprContext ctx) {
        return visit(ctx.originExpr());
    }

    @Override
    public Node visitFuncPriExpr(MxStarParser.FuncPriExprContext ctx) {
        Node res = new FuncExprNode();
        res.name = ctx.Identifier().getText();
        if(ctx.exprList() != null) {
            res.son.addAll(visit(ctx.exprList()).son);
        }
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override public Node visitArrPriExpr(MxStarParser.ArrPriExprContext ctx) {
        Node res = new ArrExprNode();
        Node tmp = visit(ctx.primaryExpr());
        res.son.add(tmp);
        res.name = tmp.name;
        res.loc = new Location(ctx.start);
        res.son.add(visit(ctx.expression()));
        return res;
    }

    @Override public Node visitObjPriExpr(MxStarParser.ObjPriExprContext ctx) {
        Node res = new ObjExprNode();
        if(ctx.primaryExpr(0).getText().equals("this")) {
            Node tmp = new VarExprNode();
            tmp.loc = new Location(ctx.primaryExpr(0).start);
            tmp.name = "this";
            res.son.add(tmp);
            res.son.add(visit(ctx.primaryExpr(1)));
            res.loc = new Location(ctx.start);
        }
        else {
            for(int i = 0; i < 2; i++) {
                res.son.add(visit(ctx.primaryExpr(i)));
            }
            res.loc = new Location(ctx.start);
        }
        return res;
    }

    @Override
    public Node visitOpRUExpr(MxStarParser.OpRUExprContext ctx) {
        Node res = new RightUnaryExprNode();
        res.name = ctx.op.getText();
        res.son.add(visit(ctx.rightUnaryExpr()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitPriRUExpr(MxStarParser.PriRUExprContext ctx) {
        return visit(ctx.primaryExpr());
    }

    @Override public Node visitRUExpr(MxStarParser.RUExprContext ctx) {
        return visit(ctx.rightUnaryExpr());
    }

    @Override public Node visitLUExpr(MxStarParser.LUExprContext ctx) {
        Node res = new LeftUnaryExprNode();
        res.name = ctx.op.getText();
        res.son.add(visit(ctx.unaryExpr()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override public Node visitNewUExpr(MxStarParser.NewUExprContext ctx) {
        Node res = new NewExprNode();
        res.son.add(visit(ctx.newCreator()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitNewCreator(MxStarParser.NewCreatorContext ctx) {
        int dim = 0;
        String tmp = ctx.getText();
        for(int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == '[') dim++;
        }
        Node res = new TypeExprNode(), nowNode = res;
        for(int i = 0; i < ctx.expression().size(); i++) {
            nowNode.son.add(visit(ctx.expression(i)));
            nowNode.son.add(new TypeExprNode());
            nowNode = nowNode.son.get(nowNode.son.size() - 1);
        }
        for(int i = ctx.expression().size(); i < dim; i++) {
            nowNode.son.add(new EmptyExprNode());
            nowNode.son.add(new TypeExprNode());
            nowNode = nowNode.son.get(nowNode.son.size() - 1);
        }
        if(ctx.Identifier() != null) {
            nowNode.type = TypeRef.buildTypeRef(ctx.Identifier().getText());
        }
        else {
            nowNode.type = TypeRef.buildTypeRef(ctx.basicTypeName().getText());
        }
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitUnaryMulExpr(MxStarParser.UnaryMulExprContext ctx) {
        return visit(ctx.unaryExpr());
    }

    @Override
    public Node visitMulExpr(MxStarParser.MulExprContext ctx) {
        Node res = new BinaryExprNode();
        res.name = ctx.op.getText();
        res.son.add(visit(ctx.multiplicativeExpr()));
        res.son.add(visit(ctx.unaryExpr()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitMulAddExpr(MxStarParser.MulAddExprContext ctx) {
        return visit(ctx.multiplicativeExpr());
    }

    @Override
    public Node visitAddExpr(MxStarParser.AddExprContext ctx) {
        Node res = new BinaryExprNode();
        res.name = ctx.op.getText();
        res.son.add(visit(ctx.additiveExpr()));
        res.son.add(visit(ctx.multiplicativeExpr()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitAddShiftExpr(MxStarParser.AddShiftExprContext ctx) {
        return visit(ctx.additiveExpr());
    }

    @Override
    public Node visitShftExpr(MxStarParser.ShftExprContext ctx) {
        Node res = new BinaryExprNode();
        res.name = ctx.op.getText();
        res.son.add(visit(ctx.shiftExpr()));
        res.son.add(visit(ctx.additiveExpr()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitShiftRelExpr(MxStarParser.ShiftRelExprContext ctx) {
        return visit(ctx.shiftExpr());
    }

    @Override
    public Node visitRelExpr(MxStarParser.RelExprContext ctx) {
       Node res = new BinaryExprNode();
       res.name = ctx.op.getText();
       res.son.add(visit(ctx.relationExpr()));
       res.son.add(visit(ctx.shiftExpr()));
       res.loc = new Location(ctx.start);
       return res;
    }

    @Override
    public Node visitRelaEqualExpr(MxStarParser.RelaEqualExprContext ctx) {
        return visit(ctx.relationExpr());
    }

    @Override
    public Node visitEqualExpr(MxStarParser.EqualExprContext ctx) {
        Node res = new BinaryExprNode();
        res.name = ctx.op.getText();
        res.son.add(visit(ctx.equalityExpr()));
        res.son.add(visit(ctx.relationExpr()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitEqualAndExpr(MxStarParser.EqualAndExprContext ctx) {
        return visit(ctx.equalityExpr());
    }

    @Override
    public Node visitAExpr(MxStarParser.AExprContext ctx) {
        Node res = new BinaryExprNode();
        res.name = ctx.op.getText();
        res.son.add(visit(ctx.andExpr()));
        res.son.add(visit(ctx.equalityExpr()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitXExpr(MxStarParser.XExprContext ctx) {
        Node res = new BinaryExprNode();
        res.name = ctx.op.getText();
        res.son.add(visit(ctx.xorExpr()));
        res.son.add(visit(ctx.andExpr()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitAndXorExpr(MxStarParser.AndXorExprContext ctx) {
        return visit(ctx.andExpr());
    }

    @Override
    public Node visitXorOrExpr(MxStarParser.XorOrExprContext ctx) {
        return visit(ctx.xorExpr());
    }

    @Override
    public Node visitOExpr(MxStarParser.OExprContext ctx) {
        Node res = new BinaryExprNode();
        res.name = ctx.op.getText();
        res.son.add(visit(ctx.orExpr()));
        res.son.add(visit(ctx.xorExpr()));
        res.loc = new Location(ctx.start);
        return visitChildren(ctx);
    }

    @Override
    public Node visitLogicAndExpr(MxStarParser.LogicAndExprContext ctx) {
        Node res = new BinaryExprNode();
        res.name = ctx.op.getText();
        res.son.add(visit(ctx.logicalAndExpr()));
        res.son.add(visit(ctx.orExpr()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitOrLogicAndExpr(MxStarParser.OrLogicAndExprContext ctx) {
        return visit(ctx.orExpr());
    }

    @Override
    public Node visitLogicOrExpr(MxStarParser.LogicOrExprContext ctx) {
        Node res = new BinaryExprNode();
        res.name = ctx.op.getText();
        res.son.add(visit(ctx.logicalOrExpr()));
        res.son.add(visit(ctx.logicalAndExpr()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitAndLogicOrExpr(MxStarParser.AndLogicOrExprContext ctx) {
        return visit(ctx.logicalAndExpr());
    }

    @Override
    public Node visitAssignExpr(MxStarParser.AssignExprContext ctx) {
        Node res = new BinaryExprNode();
        res.name = ctx.op.getText();
        res.son.add(visit(ctx.assignmentExpr()));
        res.son.add(visit(ctx.logicalOrExpr()));
        res.loc = new Location(ctx.start);
        return res;
    }

    @Override
    public Node visitOrAssignEXpr(MxStarParser.OrAssignEXprContext ctx) {
        return visit(ctx.logicalOrExpr());
    }

}