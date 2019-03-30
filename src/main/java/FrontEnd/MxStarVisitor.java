// Generated from /home/smallling/compiler/src/main/java/FrontEnd/MxStar.g4 by ANTLR 4.7.2
package main.java.FrontEnd;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxStarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxStarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxStarParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(MxStarParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(MxStarParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(MxStarParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#functionDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDef(MxStarParser.FunctionDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#constructionFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructionFunction(MxStarParser.ConstructionFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(MxStarParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(MxStarParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompStat(MxStarParser.CompStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStat(MxStarParser.ExprStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code seleStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeleStat(MxStarParser.SeleStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iterStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterStat(MxStarParser.IterStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jumpStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStat(MxStarParser.JumpStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStat(MxStarParser.EmptyStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(MxStarParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(MxStarParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(MxStarParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStat}
	 * labeled alternative in {@link MxStarParser#selectionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(MxStarParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfElseStat}
	 * labeled alternative in {@link MxStarParser#selectionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStat(MxStarParser.IfElseStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MxStarParser#iterativeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(MxStarParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link MxStarParser#iterativeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStat(MxStarParser.ForStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MxStarParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(MxStarParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnJump}
	 * labeled alternative in {@link MxStarParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnJump(MxStarParser.ReturnJumpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakJump}
	 * labeled alternative in {@link MxStarParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakJump(MxStarParser.BreakJumpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continueJump}
	 * labeled alternative in {@link MxStarParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueJump(MxStarParser.ContinueJumpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#varDefStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefStatement(MxStarParser.VarDefStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#varDefStatementWithoutInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefStatementWithoutInit(MxStarParser.VarDefStatementWithoutInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varWithoutInit}
	 * labeled alternative in {@link MxStarParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarWithoutInit(MxStarParser.VarWithoutInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varWithInit}
	 * labeled alternative in {@link MxStarParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarWithInit(MxStarParser.VarWithInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intLite}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLite(MxStarParser.IntLiteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolLite}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLite(MxStarParser.BoolLiteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLite}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLite(MxStarParser.StringLiteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullLite}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLite(MxStarParser.NullLiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MxStarParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(MxStarParser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalOriExpr}
	 * labeled alternative in {@link MxStarParser#originExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralOriExpr(MxStarParser.LiteralOriExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varOriExpr}
	 * labeled alternative in {@link MxStarParser#originExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarOriExpr(MxStarParser.VarOriExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sonOriExpr}
	 * labeled alternative in {@link MxStarParser#originExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSonOriExpr(MxStarParser.SonOriExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oriPriExpr}
	 * labeled alternative in {@link MxStarParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOriPriExpr(MxStarParser.OriPriExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcPriExpr}
	 * labeled alternative in {@link MxStarParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncPriExpr(MxStarParser.FuncPriExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrPriExpr}
	 * labeled alternative in {@link MxStarParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrPriExpr(MxStarParser.ArrPriExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objPriExpr}
	 * labeled alternative in {@link MxStarParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjPriExpr(MxStarParser.ObjPriExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opRUExpr}
	 * labeled alternative in {@link MxStarParser#rightUnaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpRUExpr(MxStarParser.OpRUExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code priRUExpr}
	 * labeled alternative in {@link MxStarParser#rightUnaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPriRUExpr(MxStarParser.PriRUExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rUExpr}
	 * labeled alternative in {@link MxStarParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRUExpr(MxStarParser.RUExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lUExpr}
	 * labeled alternative in {@link MxStarParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLUExpr(MxStarParser.LUExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newUExpr}
	 * labeled alternative in {@link MxStarParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewUExpr(MxStarParser.NewUExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#newCreator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewCreator(MxStarParser.NewCreatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryMulExpr}
	 * labeled alternative in {@link MxStarParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMulExpr(MxStarParser.UnaryMulExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link MxStarParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpr(MxStarParser.MulExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulAddExpr}
	 * labeled alternative in {@link MxStarParser#additiveExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulAddExpr(MxStarParser.MulAddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link MxStarParser#additiveExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(MxStarParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addShiftExpr}
	 * labeled alternative in {@link MxStarParser#shiftExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddShiftExpr(MxStarParser.AddShiftExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shftExpr}
	 * labeled alternative in {@link MxStarParser#shiftExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShftExpr(MxStarParser.ShftExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shiftRelExpr}
	 * labeled alternative in {@link MxStarParser#relationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftRelExpr(MxStarParser.ShiftRelExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relExpr}
	 * labeled alternative in {@link MxStarParser#relationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExpr(MxStarParser.RelExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relaEqualExpr}
	 * labeled alternative in {@link MxStarParser#equalityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelaEqualExpr(MxStarParser.RelaEqualExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalExpr}
	 * labeled alternative in {@link MxStarParser#equalityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualExpr(MxStarParser.EqualExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalAndExpr}
	 * labeled alternative in {@link MxStarParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualAndExpr(MxStarParser.EqualAndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aExpr}
	 * labeled alternative in {@link MxStarParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAExpr(MxStarParser.AExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xExpr}
	 * labeled alternative in {@link MxStarParser#xorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXExpr(MxStarParser.XExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andXorExpr}
	 * labeled alternative in {@link MxStarParser#xorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndXorExpr(MxStarParser.AndXorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xorOrExpr}
	 * labeled alternative in {@link MxStarParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXorOrExpr(MxStarParser.XorOrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oExpr}
	 * labeled alternative in {@link MxStarParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOExpr(MxStarParser.OExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicAndExpr}
	 * labeled alternative in {@link MxStarParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicAndExpr(MxStarParser.LogicAndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orLogicAndExpr}
	 * labeled alternative in {@link MxStarParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrLogicAndExpr(MxStarParser.OrLogicAndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicOrExpr}
	 * labeled alternative in {@link MxStarParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicOrExpr(MxStarParser.LogicOrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andLogicOrExpr}
	 * labeled alternative in {@link MxStarParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndLogicOrExpr(MxStarParser.AndLogicOrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MxStarParser#assignmentExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(MxStarParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orAssignEXpr}
	 * labeled alternative in {@link MxStarParser#assignmentExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrAssignEXpr(MxStarParser.OrAssignEXprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#varName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarName(MxStarParser.VarNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(MxStarParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#basicTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicTypeName(MxStarParser.BasicTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#boolLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(MxStarParser.BoolLiteralContext ctx);
}