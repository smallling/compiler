// Generated from /home/smallling/compiler/src/main/java/FrontEnd/MxStar.g4 by ANTLR 4.7.2
package main.java.FrontEnd;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxStarParser}.
 */
public interface MxStarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxStarParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(MxStarParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(MxStarParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(MxStarParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(MxStarParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(MxStarParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(MxStarParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(MxStarParser.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(MxStarParser.FunctionDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#constructionFunction}.
	 * @param ctx the parse tree
	 */
	void enterConstructionFunction(MxStarParser.ConstructionFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#constructionFunction}.
	 * @param ctx the parse tree
	 */
	void exitConstructionFunction(MxStarParser.ConstructionFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(MxStarParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(MxStarParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(MxStarParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(MxStarParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCompStat(MxStarParser.CompStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCompStat(MxStarParser.CompStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprStat(MxStarParser.ExprStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprStat(MxStarParser.ExprStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code seleStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSeleStat(MxStarParser.SeleStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code seleStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSeleStat(MxStarParser.SeleStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iterStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIterStat(MxStarParser.IterStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iterStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIterStat(MxStarParser.IterStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jumpStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStat(MxStarParser.JumpStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jumpStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStat(MxStarParser.JumpStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStat(MxStarParser.EmptyStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStat(MxStarParser.EmptyStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(MxStarParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(MxStarParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(MxStarParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(MxStarParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(MxStarParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(MxStarParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStat}
	 * labeled alternative in {@link MxStarParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(MxStarParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStat}
	 * labeled alternative in {@link MxStarParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(MxStarParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfElseStat}
	 * labeled alternative in {@link MxStarParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStat(MxStarParser.IfElseStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfElseStat}
	 * labeled alternative in {@link MxStarParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStat(MxStarParser.IfElseStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MxStarParser#iterativeStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(MxStarParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MxStarParser#iterativeStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(MxStarParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link MxStarParser#iterativeStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStat(MxStarParser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link MxStarParser#iterativeStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStat(MxStarParser.ForStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MxStarParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MxStarParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MxStarParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MxStarParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnJump}
	 * labeled alternative in {@link MxStarParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnJump(MxStarParser.ReturnJumpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnJump}
	 * labeled alternative in {@link MxStarParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnJump(MxStarParser.ReturnJumpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakJump}
	 * labeled alternative in {@link MxStarParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakJump(MxStarParser.BreakJumpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakJump}
	 * labeled alternative in {@link MxStarParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakJump(MxStarParser.BreakJumpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continueJump}
	 * labeled alternative in {@link MxStarParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueJump(MxStarParser.ContinueJumpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continueJump}
	 * labeled alternative in {@link MxStarParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueJump(MxStarParser.ContinueJumpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#varDefStatement}.
	 * @param ctx the parse tree
	 */
	void enterVarDefStatement(MxStarParser.VarDefStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#varDefStatement}.
	 * @param ctx the parse tree
	 */
	void exitVarDefStatement(MxStarParser.VarDefStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#varDefStatementWithoutInit}.
	 * @param ctx the parse tree
	 */
	void enterVarDefStatementWithoutInit(MxStarParser.VarDefStatementWithoutInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#varDefStatementWithoutInit}.
	 * @param ctx the parse tree
	 */
	void exitVarDefStatementWithoutInit(MxStarParser.VarDefStatementWithoutInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varWithoutInit}
	 * labeled alternative in {@link MxStarParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarWithoutInit(MxStarParser.VarWithoutInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varWithoutInit}
	 * labeled alternative in {@link MxStarParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarWithoutInit(MxStarParser.VarWithoutInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varWithInit}
	 * labeled alternative in {@link MxStarParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarWithInit(MxStarParser.VarWithInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varWithInit}
	 * labeled alternative in {@link MxStarParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarWithInit(MxStarParser.VarWithInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intLite}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterIntLite(MxStarParser.IntLiteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intLite}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitIntLite(MxStarParser.IntLiteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolLite}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolLite(MxStarParser.BoolLiteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolLite}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolLite(MxStarParser.BoolLiteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLite}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLite(MxStarParser.StringLiteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLite}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLite(MxStarParser.StringLiteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullLite}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNullLite(MxStarParser.NullLiteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullLite}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNullLite(MxStarParser.NullLiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MxStarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MxStarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(MxStarParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(MxStarParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalOriExpr}
	 * labeled alternative in {@link MxStarParser#originExpr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralOriExpr(MxStarParser.LiteralOriExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalOriExpr}
	 * labeled alternative in {@link MxStarParser#originExpr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralOriExpr(MxStarParser.LiteralOriExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varOriExpr}
	 * labeled alternative in {@link MxStarParser#originExpr}.
	 * @param ctx the parse tree
	 */
	void enterVarOriExpr(MxStarParser.VarOriExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varOriExpr}
	 * labeled alternative in {@link MxStarParser#originExpr}.
	 * @param ctx the parse tree
	 */
	void exitVarOriExpr(MxStarParser.VarOriExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sonOriExpr}
	 * labeled alternative in {@link MxStarParser#originExpr}.
	 * @param ctx the parse tree
	 */
	void enterSonOriExpr(MxStarParser.SonOriExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sonOriExpr}
	 * labeled alternative in {@link MxStarParser#originExpr}.
	 * @param ctx the parse tree
	 */
	void exitSonOriExpr(MxStarParser.SonOriExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code oriPriExpr}
	 * labeled alternative in {@link MxStarParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterOriPriExpr(MxStarParser.OriPriExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code oriPriExpr}
	 * labeled alternative in {@link MxStarParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitOriPriExpr(MxStarParser.OriPriExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcPriExpr}
	 * labeled alternative in {@link MxStarParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterFuncPriExpr(MxStarParser.FuncPriExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcPriExpr}
	 * labeled alternative in {@link MxStarParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitFuncPriExpr(MxStarParser.FuncPriExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrPriExpr}
	 * labeled alternative in {@link MxStarParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterArrPriExpr(MxStarParser.ArrPriExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrPriExpr}
	 * labeled alternative in {@link MxStarParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitArrPriExpr(MxStarParser.ArrPriExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objPriExpr}
	 * labeled alternative in {@link MxStarParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterObjPriExpr(MxStarParser.ObjPriExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objPriExpr}
	 * labeled alternative in {@link MxStarParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitObjPriExpr(MxStarParser.ObjPriExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opRUExpr}
	 * labeled alternative in {@link MxStarParser#rightUnaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterOpRUExpr(MxStarParser.OpRUExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opRUExpr}
	 * labeled alternative in {@link MxStarParser#rightUnaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitOpRUExpr(MxStarParser.OpRUExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code priRUExpr}
	 * labeled alternative in {@link MxStarParser#rightUnaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterPriRUExpr(MxStarParser.PriRUExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code priRUExpr}
	 * labeled alternative in {@link MxStarParser#rightUnaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitPriRUExpr(MxStarParser.PriRUExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rUExpr}
	 * labeled alternative in {@link MxStarParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterRUExpr(MxStarParser.RUExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rUExpr}
	 * labeled alternative in {@link MxStarParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitRUExpr(MxStarParser.RUExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lUExpr}
	 * labeled alternative in {@link MxStarParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterLUExpr(MxStarParser.LUExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lUExpr}
	 * labeled alternative in {@link MxStarParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitLUExpr(MxStarParser.LUExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newUExpr}
	 * labeled alternative in {@link MxStarParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterNewUExpr(MxStarParser.NewUExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newUExpr}
	 * labeled alternative in {@link MxStarParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitNewUExpr(MxStarParser.NewUExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#newCreator}.
	 * @param ctx the parse tree
	 */
	void enterNewCreator(MxStarParser.NewCreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#newCreator}.
	 * @param ctx the parse tree
	 */
	void exitNewCreator(MxStarParser.NewCreatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMulExpr}
	 * labeled alternative in {@link MxStarParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMulExpr(MxStarParser.UnaryMulExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMulExpr}
	 * labeled alternative in {@link MxStarParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMulExpr(MxStarParser.UnaryMulExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link MxStarParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(MxStarParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link MxStarParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(MxStarParser.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulAddExpr}
	 * labeled alternative in {@link MxStarParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void enterMulAddExpr(MxStarParser.MulAddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulAddExpr}
	 * labeled alternative in {@link MxStarParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void exitMulAddExpr(MxStarParser.MulAddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link MxStarParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(MxStarParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link MxStarParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(MxStarParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addShiftExpr}
	 * labeled alternative in {@link MxStarParser#shiftExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddShiftExpr(MxStarParser.AddShiftExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addShiftExpr}
	 * labeled alternative in {@link MxStarParser#shiftExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddShiftExpr(MxStarParser.AddShiftExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shftExpr}
	 * labeled alternative in {@link MxStarParser#shiftExpr}.
	 * @param ctx the parse tree
	 */
	void enterShftExpr(MxStarParser.ShftExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shftExpr}
	 * labeled alternative in {@link MxStarParser#shiftExpr}.
	 * @param ctx the parse tree
	 */
	void exitShftExpr(MxStarParser.ShftExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shiftRelExpr}
	 * labeled alternative in {@link MxStarParser#relationExpr}.
	 * @param ctx the parse tree
	 */
	void enterShiftRelExpr(MxStarParser.ShiftRelExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shiftRelExpr}
	 * labeled alternative in {@link MxStarParser#relationExpr}.
	 * @param ctx the parse tree
	 */
	void exitShiftRelExpr(MxStarParser.ShiftRelExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relExpr}
	 * labeled alternative in {@link MxStarParser#relationExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelExpr(MxStarParser.RelExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relExpr}
	 * labeled alternative in {@link MxStarParser#relationExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelExpr(MxStarParser.RelExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relaEqualExpr}
	 * labeled alternative in {@link MxStarParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelaEqualExpr(MxStarParser.RelaEqualExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relaEqualExpr}
	 * labeled alternative in {@link MxStarParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelaEqualExpr(MxStarParser.RelaEqualExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalExpr}
	 * labeled alternative in {@link MxStarParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualExpr(MxStarParser.EqualExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalExpr}
	 * labeled alternative in {@link MxStarParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualExpr(MxStarParser.EqualExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalAndExpr}
	 * labeled alternative in {@link MxStarParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualAndExpr(MxStarParser.EqualAndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalAndExpr}
	 * labeled alternative in {@link MxStarParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualAndExpr(MxStarParser.EqualAndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aExpr}
	 * labeled alternative in {@link MxStarParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAExpr(MxStarParser.AExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aExpr}
	 * labeled alternative in {@link MxStarParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAExpr(MxStarParser.AExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xExpr}
	 * labeled alternative in {@link MxStarParser#xorExpr}.
	 * @param ctx the parse tree
	 */
	void enterXExpr(MxStarParser.XExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xExpr}
	 * labeled alternative in {@link MxStarParser#xorExpr}.
	 * @param ctx the parse tree
	 */
	void exitXExpr(MxStarParser.XExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andXorExpr}
	 * labeled alternative in {@link MxStarParser#xorExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndXorExpr(MxStarParser.AndXorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andXorExpr}
	 * labeled alternative in {@link MxStarParser#xorExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndXorExpr(MxStarParser.AndXorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xorOrExpr}
	 * labeled alternative in {@link MxStarParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterXorOrExpr(MxStarParser.XorOrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xorOrExpr}
	 * labeled alternative in {@link MxStarParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitXorOrExpr(MxStarParser.XorOrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code oExpr}
	 * labeled alternative in {@link MxStarParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOExpr(MxStarParser.OExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code oExpr}
	 * labeled alternative in {@link MxStarParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOExpr(MxStarParser.OExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicAndExpr}
	 * labeled alternative in {@link MxStarParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicAndExpr(MxStarParser.LogicAndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicAndExpr}
	 * labeled alternative in {@link MxStarParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicAndExpr(MxStarParser.LogicAndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orLogicAndExpr}
	 * labeled alternative in {@link MxStarParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrLogicAndExpr(MxStarParser.OrLogicAndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orLogicAndExpr}
	 * labeled alternative in {@link MxStarParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrLogicAndExpr(MxStarParser.OrLogicAndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicOrExpr}
	 * labeled alternative in {@link MxStarParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicOrExpr(MxStarParser.LogicOrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicOrExpr}
	 * labeled alternative in {@link MxStarParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicOrExpr(MxStarParser.LogicOrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andLogicOrExpr}
	 * labeled alternative in {@link MxStarParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndLogicOrExpr(MxStarParser.AndLogicOrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andLogicOrExpr}
	 * labeled alternative in {@link MxStarParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndLogicOrExpr(MxStarParser.AndLogicOrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MxStarParser#assignmentExpr}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(MxStarParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MxStarParser#assignmentExpr}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(MxStarParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orAssignEXpr}
	 * labeled alternative in {@link MxStarParser#assignmentExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrAssignEXpr(MxStarParser.OrAssignEXprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orAssignEXpr}
	 * labeled alternative in {@link MxStarParser#assignmentExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrAssignEXpr(MxStarParser.OrAssignEXprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#varName}.
	 * @param ctx the parse tree
	 */
	void enterVarName(MxStarParser.VarNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#varName}.
	 * @param ctx the parse tree
	 */
	void exitVarName(MxStarParser.VarNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(MxStarParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(MxStarParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#basicTypeName}.
	 * @param ctx the parse tree
	 */
	void enterBasicTypeName(MxStarParser.BasicTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#basicTypeName}.
	 * @param ctx the parse tree
	 */
	void exitBasicTypeName(MxStarParser.BasicTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(MxStarParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(MxStarParser.BoolLiteralContext ctx);
}