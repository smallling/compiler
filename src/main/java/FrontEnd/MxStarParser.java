// Generated from /home/smallling/compiler/src/main/java/FrontEnd/MxStar.g4 by ANTLR 4.7.2
package main.java.FrontEnd;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxStarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, LineComment=33, StringLiteral=34, IntLiteral=35, Bool=36, Int=37, 
		String=38, Null=39, Void=40, True=41, False=42, If=43, For=44, While=45, 
		Break=46, Continue=47, Return=48, New=49, Class=50, This=51, Else=52, 
		Identifier=53, WhiteSpace=54, NewLine=55;
	public static final int
		RULE_code = 0, RULE_classDef = 1, RULE_classBody = 2, RULE_functionDef = 3, 
		RULE_constructionFunction = 4, RULE_parameterList = 5, RULE_parameter = 6, 
		RULE_statement = 7, RULE_emptyStatement = 8, RULE_compoundStatement = 9, 
		RULE_expressionStatement = 10, RULE_selectionStatement = 11, RULE_iterativeStatement = 12, 
		RULE_whileStatement = 13, RULE_forStatement = 14, RULE_jumpStatement = 15, 
		RULE_varDefStatement = 16, RULE_varDefStatementWithoutInit = 17, RULE_varDef = 18, 
		RULE_literal = 19, RULE_expression = 20, RULE_exprList = 21, RULE_originExpr = 22, 
		RULE_primaryExpr = 23, RULE_rightUnaryExpr = 24, RULE_unaryExpr = 25, 
		RULE_newCreator = 26, RULE_multiplicativeExpr = 27, RULE_additiveExpr = 28, 
		RULE_shiftExpr = 29, RULE_relationExpr = 30, RULE_equalityExpr = 31, RULE_andExpr = 32, 
		RULE_xorExpr = 33, RULE_orExpr = 34, RULE_logicalAndExpr = 35, RULE_logicalOrExpr = 36, 
		RULE_assignmentExpr = 37, RULE_varName = 38, RULE_typeName = 39, RULE_basicTypeName = 40, 
		RULE_boolLiteral = 41;
	private static String[] makeRuleNames() {
		return new String[] {
			"code", "classDef", "classBody", "functionDef", "constructionFunction", 
			"parameterList", "parameter", "statement", "emptyStatement", "compoundStatement", 
			"expressionStatement", "selectionStatement", "iterativeStatement", "whileStatement", 
			"forStatement", "jumpStatement", "varDefStatement", "varDefStatementWithoutInit", 
			"varDef", "literal", "expression", "exprList", "originExpr", "primaryExpr", 
			"rightUnaryExpr", "unaryExpr", "newCreator", "multiplicativeExpr", "additiveExpr", 
			"shiftExpr", "relationExpr", "equalityExpr", "andExpr", "xorExpr", "orExpr", 
			"logicalAndExpr", "logicalOrExpr", "assignmentExpr", "varName", "typeName", 
			"basicTypeName", "boolLiteral"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "')'", "','", "';'", "'='", "'.'", "'['", 
			"']'", "'++'", "'--'", "'~'", "'!'", "'-'", "'+'", "'*'", "'/'", "'%'", 
			"'<<'", "'>>'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&'", 
			"'^'", "'|'", "'&&'", "'||'", null, null, null, "'bool'", "'int'", "'string'", 
			"'null'", "'void'", "'true'", "'false'", "'if'", "'for'", "'while'", 
			"'break'", "'continue'", "'return'", "'new'", "'class'", "'this'", "'else'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "LineComment", 
			"StringLiteral", "IntLiteral", "Bool", "Int", "String", "Null", "Void", 
			"True", "False", "If", "For", "While", "Break", "Continue", "Return", 
			"New", "Class", "This", "Else", "Identifier", "WhiteSpace", "NewLine"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MxStar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MxStarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CodeContext extends ParserRuleContext {
		public List<ClassDefContext> classDef() {
			return getRuleContexts(ClassDefContext.class);
		}
		public ClassDefContext classDef(int i) {
			return getRuleContext(ClassDefContext.class,i);
		}
		public List<VarDefStatementContext> varDefStatement() {
			return getRuleContexts(VarDefStatementContext.class);
		}
		public VarDefStatementContext varDefStatement(int i) {
			return getRuleContext(VarDefStatementContext.class,i);
		}
		public List<FunctionDefContext> functionDef() {
			return getRuleContexts(FunctionDefContext.class);
		}
		public FunctionDefContext functionDef(int i) {
			return getRuleContext(FunctionDefContext.class,i);
		}
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_code);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << Class) | (1L << Identifier))) != 0)) {
				{
				setState(87);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(84);
					classDef();
					}
					break;
				case 2:
					{
					setState(85);
					varDefStatement();
					}
					break;
				case 3:
					{
					setState(86);
					functionDef();
					}
					break;
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDefContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(MxStarParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterClassDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitClassDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(Class);
			setState(93);
			match(Identifier);
			setState(94);
			classBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyContext extends ParserRuleContext {
		public List<VarDefStatementWithoutInitContext> varDefStatementWithoutInit() {
			return getRuleContexts(VarDefStatementWithoutInitContext.class);
		}
		public VarDefStatementWithoutInitContext varDefStatementWithoutInit(int i) {
			return getRuleContext(VarDefStatementWithoutInitContext.class,i);
		}
		public List<FunctionDefContext> functionDef() {
			return getRuleContexts(FunctionDefContext.class);
		}
		public FunctionDefContext functionDef(int i) {
			return getRuleContext(FunctionDefContext.class,i);
		}
		public ConstructionFunctionContext constructionFunction() {
			return getRuleContext(ConstructionFunctionContext.class,0);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classBody);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__0);
			setState(101);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(99);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						setState(97);
						varDefStatementWithoutInit();
						}
						break;
					case 2:
						{
						setState(98);
						functionDef();
						}
						break;
					}
					} 
				}
				setState(103);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(104);
				constructionFunction();
				}
				break;
			}
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				setState(109);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(107);
					varDefStatementWithoutInit();
					}
					break;
				case 2:
					{
					setState(108);
					functionDef();
					}
					break;
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDefContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public FunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFunctionDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFunctionDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFunctionDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefContext functionDef() throws RecognitionException {
		FunctionDefContext _localctx = new FunctionDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			typeName();
			setState(117);
			match(Identifier);
			setState(118);
			parameterList();
			setState(119);
			compoundStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructionFunctionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public ConstructionFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructionFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterConstructionFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitConstructionFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitConstructionFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructionFunctionContext constructionFunction() throws RecognitionException {
		ConstructionFunctionContext _localctx = new ConstructionFunctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constructionFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(Identifier);
			setState(122);
			match(T__2);
			setState(123);
			match(T__3);
			setState(124);
			compoundStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterListContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__2);
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(127);
				match(T__3);
				}
				break;
			case Bool:
			case Int:
			case String:
			case Void:
			case Identifier:
				{
				setState(128);
				parameter();
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(129);
					match(T__4);
					setState(130);
					parameter();
					}
					}
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(136);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			typeName();
			setState(141);
			varName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SeleStatContext extends StatementContext {
		public SelectionStatementContext selectionStatement() {
			return getRuleContext(SelectionStatementContext.class,0);
		}
		public SeleStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterSeleStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitSeleStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitSeleStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JumpStatContext extends StatementContext {
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public JumpStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterJumpStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitJumpStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitJumpStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprStatContext extends StatementContext {
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public ExprStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterExprStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitExprStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitExprStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompStatContext extends StatementContext {
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public CompStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterCompStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitCompStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitCompStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IterStatContext extends StatementContext {
		public IterativeStatementContext iterativeStatement() {
			return getRuleContext(IterativeStatementContext.class,0);
		}
		public IterStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterIterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitIterStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitIterStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyStatContext extends StatementContext {
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public EmptyStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterEmptyStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitEmptyStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitEmptyStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new CompStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				compoundStatement();
				}
				break;
			case T__2:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case StringLiteral:
			case IntLiteral:
			case Null:
			case True:
			case False:
			case New:
			case This:
			case Identifier:
				_localctx = new ExprStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				expressionStatement();
				}
				break;
			case If:
				_localctx = new SeleStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(145);
				selectionStatement();
				}
				break;
			case For:
			case While:
				_localctx = new IterStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(146);
				iterativeStatement();
				}
				break;
			case Break:
			case Continue:
			case Return:
				_localctx = new JumpStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(147);
				jumpStatement();
				}
				break;
			case T__5:
				_localctx = new EmptyStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(148);
				emptyStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyStatementContext extends ParserRuleContext {
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitEmptyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompoundStatementContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<VarDefStatementContext> varDefStatement() {
			return getRuleContexts(VarDefStatementContext.class);
		}
		public VarDefStatementContext varDefStatement(int i) {
			return getRuleContext(VarDefStatementContext.class,i);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitCompoundStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitCompoundStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(T__0);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << StringLiteral) | (1L << IntLiteral) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Null) | (1L << Void) | (1L << True) | (1L << False) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << New) | (1L << This) | (1L << Identifier))) != 0)) {
				{
				setState(156);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(154);
					statement();
					}
					break;
				case 2:
					{
					setState(155);
					varDefStatement();
					}
					break;
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(161);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			expression();
			setState(164);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectionStatementContext extends ParserRuleContext {
		public SelectionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionStatement; }
	 
		public SelectionStatementContext() { }
		public void copyFrom(SelectionStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfElseStatContext extends SelectionStatementContext {
		public TerminalNode If() { return getToken(MxStarParser.If, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(MxStarParser.Else, 0); }
		public IfElseStatContext(SelectionStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterIfElseStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitIfElseStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitIfElseStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStatContext extends SelectionStatementContext {
		public TerminalNode If() { return getToken(MxStarParser.If, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IfStatContext(SelectionStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionStatementContext selectionStatement() throws RecognitionException {
		SelectionStatementContext _localctx = new SelectionStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_selectionStatement);
		try {
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(If);
				setState(167);
				match(T__2);
				setState(168);
				expression();
				setState(169);
				match(T__3);
				setState(170);
				statement();
				}
				break;
			case 2:
				_localctx = new IfElseStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(If);
				setState(173);
				match(T__2);
				setState(174);
				expression();
				setState(175);
				match(T__3);
				setState(176);
				statement();
				setState(177);
				match(Else);
				setState(178);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IterativeStatementContext extends ParserRuleContext {
		public IterativeStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterativeStatement; }
	 
		public IterativeStatementContext() { }
		public void copyFrom(IterativeStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ForStatContext extends IterativeStatementContext {
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public ForStatContext(IterativeStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterForStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitForStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitForStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStatContext extends IterativeStatementContext {
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public WhileStatContext(IterativeStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitWhileStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterativeStatementContext iterativeStatement() throws RecognitionException {
		IterativeStatementContext _localctx = new IterativeStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_iterativeStatement);
		try {
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case While:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				whileStatement();
				}
				break;
			case For:
				_localctx = new ForStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				forStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(MxStarParser.While, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(While);
			setState(187);
			match(T__2);
			setState(188);
			expression();
			setState(189);
			match(T__3);
			setState(190);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatementContext extends ParserRuleContext {
		public ExpressionContext forInitExpr;
		public ExpressionContext forCondExpr;
		public ExpressionContext forLoopExpr;
		public TerminalNode For() { return getToken(MxStarParser.For, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(For);
			setState(193);
			match(T__2);
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << StringLiteral) | (1L << IntLiteral) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << Identifier))) != 0)) {
				{
				setState(194);
				((ForStatementContext)_localctx).forInitExpr = expression();
				}
			}

			setState(197);
			match(T__5);
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << StringLiteral) | (1L << IntLiteral) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << Identifier))) != 0)) {
				{
				setState(198);
				((ForStatementContext)_localctx).forCondExpr = expression();
				}
			}

			setState(201);
			match(T__5);
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << StringLiteral) | (1L << IntLiteral) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << Identifier))) != 0)) {
				{
				setState(202);
				((ForStatementContext)_localctx).forLoopExpr = expression();
				}
			}

			setState(205);
			match(T__3);
			setState(206);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JumpStatementContext extends ParserRuleContext {
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
	 
		public JumpStatementContext() { }
		public void copyFrom(JumpStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ReturnJumpContext extends JumpStatementContext {
		public TerminalNode Return() { return getToken(MxStarParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnJumpContext(JumpStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterReturnJump(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitReturnJump(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitReturnJump(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakJumpContext extends JumpStatementContext {
		public TerminalNode Break() { return getToken(MxStarParser.Break, 0); }
		public BreakJumpContext(JumpStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBreakJump(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBreakJump(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBreakJump(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueJumpContext extends JumpStatementContext {
		public TerminalNode Continue() { return getToken(MxStarParser.Continue, 0); }
		public ContinueJumpContext(JumpStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterContinueJump(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitContinueJump(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitContinueJump(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_jumpStatement);
		int _la;
		try {
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Return:
				_localctx = new ReturnJumpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				match(Return);
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << StringLiteral) | (1L << IntLiteral) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << Identifier))) != 0)) {
					{
					setState(209);
					expression();
					}
				}

				setState(212);
				match(T__5);
				}
				break;
			case Break:
				_localctx = new BreakJumpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				match(Break);
				setState(214);
				match(T__5);
				}
				break;
			case Continue:
				_localctx = new ContinueJumpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				match(Continue);
				setState(216);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDefStatementContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public VarDefStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterVarDefStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitVarDefStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitVarDefStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefStatementContext varDefStatement() throws RecognitionException {
		VarDefStatementContext _localctx = new VarDefStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_varDefStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			typeName();
			setState(220);
			varDef();
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(221);
				match(T__4);
				setState(222);
				varDef();
				}
				}
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(228);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDefStatementWithoutInitContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(MxStarParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MxStarParser.Identifier, i);
		}
		public VarDefStatementWithoutInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefStatementWithoutInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterVarDefStatementWithoutInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitVarDefStatementWithoutInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitVarDefStatementWithoutInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefStatementWithoutInitContext varDefStatementWithoutInit() throws RecognitionException {
		VarDefStatementWithoutInitContext _localctx = new VarDefStatementWithoutInitContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_varDefStatementWithoutInit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			typeName();
			setState(231);
			match(Identifier);
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(232);
				match(T__4);
				setState(233);
				match(Identifier);
				}
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(239);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDefContext extends ParserRuleContext {
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
	 
		public VarDefContext() { }
		public void copyFrom(VarDefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarWithoutInitContext extends VarDefContext {
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public VarWithoutInitContext(VarDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterVarWithoutInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitVarWithoutInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitVarWithoutInit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarWithInitContext extends VarDefContext {
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarWithInitContext(VarDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterVarWithInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitVarWithInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitVarWithInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_varDef);
		try {
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new VarWithoutInitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				match(Identifier);
				}
				break;
			case 2:
				_localctx = new VarWithInitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
				match(Identifier);
				setState(243);
				match(T__6);
				setState(244);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringLiteContext extends LiteralContext {
		public TerminalNode StringLiteral() { return getToken(MxStarParser.StringLiteral, 0); }
		public StringLiteContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterStringLite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitStringLite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitStringLite(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLiteContext extends LiteralContext {
		public TerminalNode IntLiteral() { return getToken(MxStarParser.IntLiteral, 0); }
		public IntLiteContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterIntLite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitIntLite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitIntLite(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolLiteContext extends LiteralContext {
		public BoolLiteralContext boolLiteral() {
			return getRuleContext(BoolLiteralContext.class,0);
		}
		public BoolLiteContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBoolLite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBoolLite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBoolLite(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullLiteContext extends LiteralContext {
		public TerminalNode Null() { return getToken(MxStarParser.Null, 0); }
		public NullLiteContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterNullLite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitNullLite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitNullLite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_literal);
		try {
			setState(251);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntLiteral:
				_localctx = new IntLiteContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				match(IntLiteral);
				}
				break;
			case True:
			case False:
				_localctx = new BoolLiteContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				boolLiteral();
				}
				break;
			case StringLiteral:
				_localctx = new StringLiteContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(249);
				match(StringLiteral);
				}
				break;
			case Null:
				_localctx = new NullLiteContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(250);
				match(Null);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public AssignmentExprContext assignmentExpr() {
			return getRuleContext(AssignmentExprContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			assignmentExpr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitExprList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitExprList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			expression();
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(256);
				match(T__4);
				setState(257);
				expression();
				}
				}
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OriginExprContext extends ParserRuleContext {
		public OriginExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_originExpr; }
	 
		public OriginExprContext() { }
		public void copyFrom(OriginExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SonOriExprContext extends OriginExprContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SonOriExprContext(OriginExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterSonOriExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitSonOriExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitSonOriExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralOriExprContext extends OriginExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralOriExprContext(OriginExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterLiteralOriExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitLiteralOriExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitLiteralOriExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarOriExprContext extends OriginExprContext {
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public VarOriExprContext(OriginExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterVarOriExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitVarOriExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitVarOriExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OriginExprContext originExpr() throws RecognitionException {
		OriginExprContext _localctx = new OriginExprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_originExpr);
		try {
			setState(269);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case StringLiteral:
			case IntLiteral:
			case Null:
			case True:
			case False:
				_localctx = new LiteralOriExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(263);
				literal();
				}
				break;
			case This:
			case Identifier:
				_localctx = new VarOriExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				varName();
				}
				break;
			case T__2:
				_localctx = new SonOriExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(265);
				match(T__2);
				setState(266);
				expression();
				setState(267);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryExprContext extends ParserRuleContext {
		public PrimaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpr; }
	 
		public PrimaryExprContext() { }
		public void copyFrom(PrimaryExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OriPriExprContext extends PrimaryExprContext {
		public OriginExprContext originExpr() {
			return getRuleContext(OriginExprContext.class,0);
		}
		public OriPriExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterOriPriExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitOriPriExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitOriPriExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncPriExprContext extends PrimaryExprContext {
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public FuncPriExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFuncPriExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFuncPriExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFuncPriExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrPriExprContext extends PrimaryExprContext {
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrPriExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterArrPriExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitArrPriExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitArrPriExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ObjPriExprContext extends PrimaryExprContext {
		public List<PrimaryExprContext> primaryExpr() {
			return getRuleContexts(PrimaryExprContext.class);
		}
		public PrimaryExprContext primaryExpr(int i) {
			return getRuleContext(PrimaryExprContext.class,i);
		}
		public ObjPriExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterObjPriExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitObjPriExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitObjPriExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExprContext primaryExpr() throws RecognitionException {
		return primaryExpr(0);
	}

	private PrimaryExprContext primaryExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrimaryExprContext _localctx = new PrimaryExprContext(_ctx, _parentState);
		PrimaryExprContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_primaryExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				_localctx = new OriPriExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(272);
				originExpr();
				}
				break;
			case 2:
				{
				_localctx = new FuncPriExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(273);
				match(Identifier);
				setState(274);
				match(T__2);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << StringLiteral) | (1L << IntLiteral) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << Identifier))) != 0)) {
					{
					setState(275);
					exprList();
					}
				}

				setState(278);
				match(T__3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(291);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(289);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new ObjPriExprContext(new PrimaryExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpr);
						setState(281);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(282);
						match(T__7);
						setState(283);
						primaryExpr(4);
						}
						break;
					case 2:
						{
						_localctx = new ArrPriExprContext(new PrimaryExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpr);
						setState(284);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(285);
						match(T__8);
						setState(286);
						expression();
						setState(287);
						match(T__9);
						}
						break;
					}
					} 
				}
				setState(293);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RightUnaryExprContext extends ParserRuleContext {
		public RightUnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightUnaryExpr; }
	 
		public RightUnaryExprContext() { }
		public void copyFrom(RightUnaryExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OpRUExprContext extends RightUnaryExprContext {
		public Token op;
		public RightUnaryExprContext rightUnaryExpr() {
			return getRuleContext(RightUnaryExprContext.class,0);
		}
		public OpRUExprContext(RightUnaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterOpRUExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitOpRUExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitOpRUExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PriRUExprContext extends RightUnaryExprContext {
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public PriRUExprContext(RightUnaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterPriRUExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitPriRUExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitPriRUExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RightUnaryExprContext rightUnaryExpr() throws RecognitionException {
		return rightUnaryExpr(0);
	}

	private RightUnaryExprContext rightUnaryExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RightUnaryExprContext _localctx = new RightUnaryExprContext(_ctx, _parentState);
		RightUnaryExprContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_rightUnaryExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PriRUExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(295);
			primaryExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(301);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OpRUExprContext(new RightUnaryExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_rightUnaryExpr);
					setState(297);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					{
					setState(298);
					((OpRUExprContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__10 || _la==T__11) ) {
						((OpRUExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					} 
				}
				setState(303);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryExprContext extends ParserRuleContext {
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
	 
		public UnaryExprContext() { }
		public void copyFrom(UnaryExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LUExprContext extends UnaryExprContext {
		public Token op;
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public LUExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterLUExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitLUExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitLUExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewUExprContext extends UnaryExprContext {
		public TerminalNode New() { return getToken(MxStarParser.New, 0); }
		public NewCreatorContext newCreator() {
			return getRuleContext(NewCreatorContext.class,0);
		}
		public NewUExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterNewUExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitNewUExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitNewUExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RUExprContext extends UnaryExprContext {
		public RightUnaryExprContext rightUnaryExpr() {
			return getRuleContext(RightUnaryExprContext.class,0);
		}
		public RUExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterRUExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitRUExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitRUExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unaryExpr);
		try {
			setState(319);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case StringLiteral:
			case IntLiteral:
			case Null:
			case True:
			case False:
			case This:
			case Identifier:
				_localctx = new RUExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(304);
				rightUnaryExpr(0);
				}
				break;
			case T__10:
				_localctx = new LUExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(305);
				((LUExprContext)_localctx).op = match(T__10);
				}
				setState(306);
				unaryExpr();
				}
				break;
			case T__11:
				_localctx = new LUExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(307);
				((LUExprContext)_localctx).op = match(T__11);
				}
				setState(308);
				unaryExpr();
				}
				break;
			case T__12:
				_localctx = new LUExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(309);
				((LUExprContext)_localctx).op = match(T__12);
				}
				setState(310);
				unaryExpr();
				}
				break;
			case T__13:
				_localctx = new LUExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(311);
				((LUExprContext)_localctx).op = match(T__13);
				}
				setState(312);
				unaryExpr();
				}
				break;
			case T__14:
				_localctx = new LUExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(313);
				((LUExprContext)_localctx).op = match(T__14);
				}
				setState(314);
				unaryExpr();
				}
				break;
			case T__15:
				_localctx = new LUExprContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				{
				setState(315);
				((LUExprContext)_localctx).op = match(T__15);
				}
				setState(316);
				unaryExpr();
				}
				break;
			case New:
				_localctx = new NewUExprContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(317);
				match(New);
				setState(318);
				newCreator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewCreatorContext extends ParserRuleContext {
		public BasicTypeNameContext basicTypeName() {
			return getRuleContext(BasicTypeNameContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public NewCreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newCreator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterNewCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitNewCreator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitNewCreator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewCreatorContext newCreator() throws RecognitionException {
		NewCreatorContext _localctx = new NewCreatorContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_newCreator);
		try {
			int _alt;
			setState(374);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(321);
				basicTypeName();
				setState(343);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(324); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(322);
							match(T__8);
							setState(323);
							match(T__9);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(326); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				case 2:
					{
					setState(332); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(328);
							match(T__8);
							setState(329);
							expression();
							setState(330);
							match(T__9);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(334); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(340);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(336);
							match(T__8);
							setState(337);
							match(T__9);
							}
							} 
						}
						setState(342);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
					}
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(345);
				match(Identifier);
				setState(369);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(350);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(346);
							match(T__8);
							setState(347);
							match(T__9);
							}
							} 
						}
						setState(352);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
					}
					}
					break;
				case 2:
					{
					setState(359);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(353);
							match(T__8);
							setState(354);
							expression();
							setState(355);
							match(T__9);
							}
							} 
						}
						setState(361);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
					}
					setState(366);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(362);
							match(T__8);
							setState(363);
							match(T__9);
							}
							} 
						}
						setState(368);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
					}
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(371);
				match(Identifier);
				setState(372);
				match(T__2);
				setState(373);
				match(T__3);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeExprContext extends ParserRuleContext {
		public MultiplicativeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpr; }
	 
		public MultiplicativeExprContext() { }
		public void copyFrom(MultiplicativeExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnaryMulExprContext extends MultiplicativeExprContext {
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public UnaryMulExprContext(MultiplicativeExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterUnaryMulExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitUnaryMulExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitUnaryMulExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulExprContext extends MultiplicativeExprContext {
		public Token op;
		public MultiplicativeExprContext multiplicativeExpr() {
			return getRuleContext(MultiplicativeExprContext.class,0);
		}
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public MulExprContext(MultiplicativeExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterMulExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitMulExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitMulExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExprContext multiplicativeExpr() throws RecognitionException {
		return multiplicativeExpr(0);
	}

	private MultiplicativeExprContext multiplicativeExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicativeExprContext _localctx = new MultiplicativeExprContext(_ctx, _parentState);
		MultiplicativeExprContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_multiplicativeExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new UnaryMulExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(377);
			unaryExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(390);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(388);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
					case 1:
						{
						_localctx = new MulExprContext(new MultiplicativeExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpr);
						setState(379);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						{
						setState(380);
						((MulExprContext)_localctx).op = match(T__16);
						}
						setState(381);
						unaryExpr();
						}
						break;
					case 2:
						{
						_localctx = new MulExprContext(new MultiplicativeExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpr);
						setState(382);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(383);
						((MulExprContext)_localctx).op = match(T__17);
						}
						setState(384);
						unaryExpr();
						}
						break;
					case 3:
						{
						_localctx = new MulExprContext(new MultiplicativeExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpr);
						setState(385);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						{
						setState(386);
						((MulExprContext)_localctx).op = match(T__18);
						}
						setState(387);
						unaryExpr();
						}
						break;
					}
					} 
				}
				setState(392);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AdditiveExprContext extends ParserRuleContext {
		public AdditiveExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpr; }
	 
		public AdditiveExprContext() { }
		public void copyFrom(AdditiveExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MulAddExprContext extends AdditiveExprContext {
		public MultiplicativeExprContext multiplicativeExpr() {
			return getRuleContext(MultiplicativeExprContext.class,0);
		}
		public MulAddExprContext(AdditiveExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterMulAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitMulAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitMulAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddExprContext extends AdditiveExprContext {
		public Token op;
		public AdditiveExprContext additiveExpr() {
			return getRuleContext(AdditiveExprContext.class,0);
		}
		public MultiplicativeExprContext multiplicativeExpr() {
			return getRuleContext(MultiplicativeExprContext.class,0);
		}
		public AddExprContext(AdditiveExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExprContext additiveExpr() throws RecognitionException {
		return additiveExpr(0);
	}

	private AdditiveExprContext additiveExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveExprContext _localctx = new AdditiveExprContext(_ctx, _parentState);
		AdditiveExprContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_additiveExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new MulAddExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(394);
			multiplicativeExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(404);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(402);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
					case 1:
						{
						_localctx = new AddExprContext(new AdditiveExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpr);
						setState(396);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(397);
						((AddExprContext)_localctx).op = match(T__15);
						}
						setState(398);
						multiplicativeExpr(0);
						}
						break;
					case 2:
						{
						_localctx = new AddExprContext(new AdditiveExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpr);
						setState(399);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						{
						setState(400);
						((AddExprContext)_localctx).op = match(T__14);
						}
						setState(401);
						multiplicativeExpr(0);
						}
						break;
					}
					} 
				}
				setState(406);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ShiftExprContext extends ParserRuleContext {
		public ShiftExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpr; }
	 
		public ShiftExprContext() { }
		public void copyFrom(ShiftExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddShiftExprContext extends ShiftExprContext {
		public AdditiveExprContext additiveExpr() {
			return getRuleContext(AdditiveExprContext.class,0);
		}
		public AddShiftExprContext(ShiftExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterAddShiftExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitAddShiftExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitAddShiftExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShftExprContext extends ShiftExprContext {
		public Token op;
		public ShiftExprContext shiftExpr() {
			return getRuleContext(ShiftExprContext.class,0);
		}
		public AdditiveExprContext additiveExpr() {
			return getRuleContext(AdditiveExprContext.class,0);
		}
		public ShftExprContext(ShiftExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterShftExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitShftExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitShftExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShiftExprContext shiftExpr() throws RecognitionException {
		return shiftExpr(0);
	}

	private ShiftExprContext shiftExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ShiftExprContext _localctx = new ShiftExprContext(_ctx, _parentState);
		ShiftExprContext _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_shiftExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new AddShiftExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(408);
			additiveExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(418);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(416);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
					case 1:
						{
						_localctx = new ShftExprContext(new ShiftExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_shiftExpr);
						setState(410);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(411);
						((ShftExprContext)_localctx).op = match(T__19);
						}
						setState(412);
						additiveExpr(0);
						}
						break;
					case 2:
						{
						_localctx = new ShftExprContext(new ShiftExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_shiftExpr);
						setState(413);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						{
						setState(414);
						((ShftExprContext)_localctx).op = match(T__20);
						}
						setState(415);
						additiveExpr(0);
						}
						break;
					}
					} 
				}
				setState(420);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RelationExprContext extends ParserRuleContext {
		public RelationExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationExpr; }
	 
		public RelationExprContext() { }
		public void copyFrom(RelationExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ShiftRelExprContext extends RelationExprContext {
		public ShiftExprContext shiftExpr() {
			return getRuleContext(ShiftExprContext.class,0);
		}
		public ShiftRelExprContext(RelationExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterShiftRelExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitShiftRelExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitShiftRelExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelExprContext extends RelationExprContext {
		public Token op;
		public RelationExprContext relationExpr() {
			return getRuleContext(RelationExprContext.class,0);
		}
		public ShiftExprContext shiftExpr() {
			return getRuleContext(ShiftExprContext.class,0);
		}
		public RelExprContext(RelationExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterRelExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitRelExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitRelExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationExprContext relationExpr() throws RecognitionException {
		return relationExpr(0);
	}

	private RelationExprContext relationExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationExprContext _localctx = new RelationExprContext(_ctx, _parentState);
		RelationExprContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_relationExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ShiftRelExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(422);
			shiftExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(438);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(436);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
					case 1:
						{
						_localctx = new RelExprContext(new RelationExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relationExpr);
						setState(424);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						{
						setState(425);
						((RelExprContext)_localctx).op = match(T__21);
						}
						setState(426);
						shiftExpr(0);
						}
						break;
					case 2:
						{
						_localctx = new RelExprContext(new RelationExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relationExpr);
						setState(427);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						{
						setState(428);
						((RelExprContext)_localctx).op = match(T__22);
						}
						setState(429);
						shiftExpr(0);
						}
						break;
					case 3:
						{
						_localctx = new RelExprContext(new RelationExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relationExpr);
						setState(430);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(431);
						((RelExprContext)_localctx).op = match(T__23);
						}
						setState(432);
						shiftExpr(0);
						}
						break;
					case 4:
						{
						_localctx = new RelExprContext(new RelationExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relationExpr);
						setState(433);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						{
						setState(434);
						((RelExprContext)_localctx).op = match(T__24);
						}
						setState(435);
						shiftExpr(0);
						}
						break;
					}
					} 
				}
				setState(440);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualityExprContext extends ParserRuleContext {
		public EqualityExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpr; }
	 
		public EqualityExprContext() { }
		public void copyFrom(EqualityExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RelaEqualExprContext extends EqualityExprContext {
		public RelationExprContext relationExpr() {
			return getRuleContext(RelationExprContext.class,0);
		}
		public RelaEqualExprContext(EqualityExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterRelaEqualExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitRelaEqualExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitRelaEqualExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualExprContext extends EqualityExprContext {
		public Token op;
		public EqualityExprContext equalityExpr() {
			return getRuleContext(EqualityExprContext.class,0);
		}
		public RelationExprContext relationExpr() {
			return getRuleContext(RelationExprContext.class,0);
		}
		public EqualExprContext(EqualityExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterEqualExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitEqualExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitEqualExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExprContext equalityExpr() throws RecognitionException {
		return equalityExpr(0);
	}

	private EqualityExprContext equalityExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualityExprContext _localctx = new EqualityExprContext(_ctx, _parentState);
		EqualityExprContext _prevctx = _localctx;
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_equalityExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new RelaEqualExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(442);
			relationExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(452);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(450);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
					case 1:
						{
						_localctx = new EqualExprContext(new EqualityExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_equalityExpr);
						setState(444);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(445);
						((EqualExprContext)_localctx).op = match(T__25);
						}
						setState(446);
						relationExpr(0);
						}
						break;
					case 2:
						{
						_localctx = new EqualExprContext(new EqualityExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_equalityExpr);
						setState(447);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						{
						setState(448);
						((EqualExprContext)_localctx).op = match(T__26);
						}
						setState(449);
						relationExpr(0);
						}
						break;
					}
					} 
				}
				setState(454);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AndExprContext extends ParserRuleContext {
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
	 
		public AndExprContext() { }
		public void copyFrom(AndExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqualAndExprContext extends AndExprContext {
		public EqualityExprContext equalityExpr() {
			return getRuleContext(EqualityExprContext.class,0);
		}
		public EqualAndExprContext(AndExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterEqualAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitEqualAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitEqualAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AExprContext extends AndExprContext {
		public Token op;
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public EqualityExprContext equalityExpr() {
			return getRuleContext(EqualityExprContext.class,0);
		}
		public AExprContext(AndExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterAExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitAExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitAExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		return andExpr(0);
	}

	private AndExprContext andExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndExprContext _localctx = new AndExprContext(_ctx, _parentState);
		AndExprContext _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_andExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new EqualAndExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(456);
			equalityExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(463);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AExprContext(new AndExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_andExpr);
					setState(458);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					{
					setState(459);
					((AExprContext)_localctx).op = match(T__27);
					}
					setState(460);
					equalityExpr(0);
					}
					} 
				}
				setState(465);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class XorExprContext extends ParserRuleContext {
		public XorExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xorExpr; }
	 
		public XorExprContext() { }
		public void copyFrom(XorExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class XExprContext extends XorExprContext {
		public Token op;
		public XorExprContext xorExpr() {
			return getRuleContext(XorExprContext.class,0);
		}
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public XExprContext(XorExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterXExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitXExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitXExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndXorExprContext extends XorExprContext {
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public AndXorExprContext(XorExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterAndXorExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitAndXorExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitAndXorExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XorExprContext xorExpr() throws RecognitionException {
		return xorExpr(0);
	}

	private XorExprContext xorExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		XorExprContext _localctx = new XorExprContext(_ctx, _parentState);
		XorExprContext _prevctx = _localctx;
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_xorExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new AndXorExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(467);
			andExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(474);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new XExprContext(new XorExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_xorExpr);
					setState(469);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					{
					setState(470);
					((XExprContext)_localctx).op = match(T__28);
					}
					setState(471);
					andExpr(0);
					}
					} 
				}
				setState(476);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class OrExprContext extends ParserRuleContext {
		public OrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpr; }
	 
		public OrExprContext() { }
		public void copyFrom(OrExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class XorOrExprContext extends OrExprContext {
		public XorExprContext xorExpr() {
			return getRuleContext(XorExprContext.class,0);
		}
		public XorOrExprContext(OrExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterXorOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitXorOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitXorOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OExprContext extends OrExprContext {
		public Token op;
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public XorExprContext xorExpr() {
			return getRuleContext(XorExprContext.class,0);
		}
		public OExprContext(OrExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterOExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitOExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitOExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExprContext orExpr() throws RecognitionException {
		return orExpr(0);
	}

	private OrExprContext orExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OrExprContext _localctx = new OrExprContext(_ctx, _parentState);
		OrExprContext _prevctx = _localctx;
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_orExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new XorOrExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(478);
			xorExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(485);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OExprContext(new OrExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_orExpr);
					setState(480);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					{
					setState(481);
					((OExprContext)_localctx).op = match(T__29);
					}
					setState(482);
					xorExpr(0);
					}
					} 
				}
				setState(487);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LogicalAndExprContext extends ParserRuleContext {
		public LogicalAndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpr; }
	 
		public LogicalAndExprContext() { }
		public void copyFrom(LogicalAndExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogicAndExprContext extends LogicalAndExprContext {
		public Token op;
		public LogicalAndExprContext logicalAndExpr() {
			return getRuleContext(LogicalAndExprContext.class,0);
		}
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public LogicAndExprContext(LogicalAndExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterLogicAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitLogicAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitLogicAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrLogicAndExprContext extends LogicalAndExprContext {
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public OrLogicAndExprContext(LogicalAndExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterOrLogicAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitOrLogicAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitOrLogicAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalAndExprContext logicalAndExpr() throws RecognitionException {
		return logicalAndExpr(0);
	}

	private LogicalAndExprContext logicalAndExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalAndExprContext _localctx = new LogicalAndExprContext(_ctx, _parentState);
		LogicalAndExprContext _prevctx = _localctx;
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_logicalAndExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new OrLogicAndExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(489);
			orExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(496);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicAndExprContext(new LogicalAndExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_logicalAndExpr);
					setState(491);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					{
					setState(492);
					((LogicAndExprContext)_localctx).op = match(T__30);
					}
					setState(493);
					orExpr(0);
					}
					} 
				}
				setState(498);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LogicalOrExprContext extends ParserRuleContext {
		public LogicalOrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExpr; }
	 
		public LogicalOrExprContext() { }
		public void copyFrom(LogicalOrExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogicOrExprContext extends LogicalOrExprContext {
		public Token op;
		public LogicalOrExprContext logicalOrExpr() {
			return getRuleContext(LogicalOrExprContext.class,0);
		}
		public LogicalAndExprContext logicalAndExpr() {
			return getRuleContext(LogicalAndExprContext.class,0);
		}
		public LogicOrExprContext(LogicalOrExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterLogicOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitLogicOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitLogicOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndLogicOrExprContext extends LogicalOrExprContext {
		public LogicalAndExprContext logicalAndExpr() {
			return getRuleContext(LogicalAndExprContext.class,0);
		}
		public AndLogicOrExprContext(LogicalOrExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterAndLogicOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitAndLogicOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitAndLogicOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalOrExprContext logicalOrExpr() throws RecognitionException {
		return logicalOrExpr(0);
	}

	private LogicalOrExprContext logicalOrExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalOrExprContext _localctx = new LogicalOrExprContext(_ctx, _parentState);
		LogicalOrExprContext _prevctx = _localctx;
		int _startState = 72;
		enterRecursionRule(_localctx, 72, RULE_logicalOrExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new AndLogicOrExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(500);
			logicalAndExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(507);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicOrExprContext(new LogicalOrExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_logicalOrExpr);
					setState(502);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					{
					setState(503);
					((LogicOrExprContext)_localctx).op = match(T__31);
					}
					setState(504);
					logicalAndExpr(0);
					}
					} 
				}
				setState(509);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AssignmentExprContext extends ParserRuleContext {
		public AssignmentExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpr; }
	 
		public AssignmentExprContext() { }
		public void copyFrom(AssignmentExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignExprContext extends AssignmentExprContext {
		public Token op;
		public AssignmentExprContext assignmentExpr() {
			return getRuleContext(AssignmentExprContext.class,0);
		}
		public LogicalOrExprContext logicalOrExpr() {
			return getRuleContext(LogicalOrExprContext.class,0);
		}
		public AssignExprContext(AssignmentExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitAssignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrAssignEXprContext extends AssignmentExprContext {
		public LogicalOrExprContext logicalOrExpr() {
			return getRuleContext(LogicalOrExprContext.class,0);
		}
		public OrAssignEXprContext(AssignmentExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterOrAssignEXpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitOrAssignEXpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitOrAssignEXpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentExprContext assignmentExpr() throws RecognitionException {
		return assignmentExpr(0);
	}

	private AssignmentExprContext assignmentExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AssignmentExprContext _localctx = new AssignmentExprContext(_ctx, _parentState);
		AssignmentExprContext _prevctx = _localctx;
		int _startState = 74;
		enterRecursionRule(_localctx, 74, RULE_assignmentExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new OrAssignEXprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(511);
			logicalOrExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(518);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AssignExprContext(new AssignmentExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_assignmentExpr);
					setState(513);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					{
					setState(514);
					((AssignExprContext)_localctx).op = match(T__6);
					}
					setState(515);
					logicalOrExpr(0);
					}
					} 
				}
				setState(520);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class VarNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public TerminalNode This() { return getToken(MxStarParser.This, 0); }
		public VarNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterVarName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitVarName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitVarName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarNameContext varName() throws RecognitionException {
		VarNameContext _localctx = new VarNameContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_varName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521);
			_la = _input.LA(1);
			if ( !(_la==This || _la==Identifier) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public BasicTypeNameContext basicTypeName() {
			return getRuleContext(BasicTypeNameContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_typeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(523);
				match(Identifier);
				}
				break;
			case Bool:
			case Int:
			case String:
			case Void:
				{
				setState(524);
				basicTypeName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(531);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(527);
				match(T__8);
				setState(528);
				match(T__9);
				}
				}
				setState(533);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasicTypeNameContext extends ParserRuleContext {
		public TerminalNode Bool() { return getToken(MxStarParser.Bool, 0); }
		public TerminalNode Int() { return getToken(MxStarParser.Int, 0); }
		public TerminalNode String() { return getToken(MxStarParser.String, 0); }
		public TerminalNode Void() { return getToken(MxStarParser.Void, 0); }
		public BasicTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBasicTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBasicTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBasicTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicTypeNameContext basicTypeName() throws RecognitionException {
		BasicTypeNameContext _localctx = new BasicTypeNameContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_basicTypeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Void))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolLiteralContext extends ParserRuleContext {
		public TerminalNode True() { return getToken(MxStarParser.True, 0); }
		public TerminalNode False() { return getToken(MxStarParser.False, 0); }
		public BoolLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBoolLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBoolLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBoolLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolLiteralContext boolLiteral() throws RecognitionException {
		BoolLiteralContext _localctx = new BoolLiteralContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_boolLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			_la = _input.LA(1);
			if ( !(_la==True || _la==False) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 23:
			return primaryExpr_sempred((PrimaryExprContext)_localctx, predIndex);
		case 24:
			return rightUnaryExpr_sempred((RightUnaryExprContext)_localctx, predIndex);
		case 27:
			return multiplicativeExpr_sempred((MultiplicativeExprContext)_localctx, predIndex);
		case 28:
			return additiveExpr_sempred((AdditiveExprContext)_localctx, predIndex);
		case 29:
			return shiftExpr_sempred((ShiftExprContext)_localctx, predIndex);
		case 30:
			return relationExpr_sempred((RelationExprContext)_localctx, predIndex);
		case 31:
			return equalityExpr_sempred((EqualityExprContext)_localctx, predIndex);
		case 32:
			return andExpr_sempred((AndExprContext)_localctx, predIndex);
		case 33:
			return xorExpr_sempred((XorExprContext)_localctx, predIndex);
		case 34:
			return orExpr_sempred((OrExprContext)_localctx, predIndex);
		case 35:
			return logicalAndExpr_sempred((LogicalAndExprContext)_localctx, predIndex);
		case 36:
			return logicalOrExpr_sempred((LogicalOrExprContext)_localctx, predIndex);
		case 37:
			return assignmentExpr_sempred((AssignmentExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean primaryExpr_sempred(PrimaryExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean rightUnaryExpr_sempred(RightUnaryExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiplicativeExpr_sempred(MultiplicativeExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additiveExpr_sempred(AdditiveExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean shiftExpr_sempred(ShiftExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relationExpr_sempred(RelationExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 3);
		case 12:
			return precpred(_ctx, 2);
		case 13:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equalityExpr_sempred(EqualityExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14:
			return precpred(_ctx, 2);
		case 15:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean andExpr_sempred(AndExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 16:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean xorExpr_sempred(XorExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 17:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean orExpr_sempred(OrExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logicalAndExpr_sempred(LogicalAndExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 19:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logicalOrExpr_sempred(LogicalOrExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 20:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean assignmentExpr_sempred(AssignmentExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 21:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\39\u021d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\2\7\2Z\n\2\f\2\16\2]\13\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4f\n"+
		"\4\f\4\16\4i\13\4\3\4\5\4l\n\4\3\4\3\4\7\4p\n\4\f\4\16\4s\13\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7\u0086"+
		"\n\7\f\7\16\7\u0089\13\7\3\7\3\7\5\7\u008d\n\7\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\5\t\u0098\n\t\3\n\3\n\3\13\3\13\3\13\7\13\u009f\n\13\f\13"+
		"\16\13\u00a2\13\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b7\n\r\3\16\3\16\5\16\u00bb\n\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u00c6\n\20\3\20\3\20\5\20"+
		"\u00ca\n\20\3\20\3\20\5\20\u00ce\n\20\3\20\3\20\3\20\3\21\3\21\5\21\u00d5"+
		"\n\21\3\21\3\21\3\21\3\21\3\21\5\21\u00dc\n\21\3\22\3\22\3\22\3\22\7\22"+
		"\u00e2\n\22\f\22\16\22\u00e5\13\22\3\22\3\22\3\23\3\23\3\23\3\23\7\23"+
		"\u00ed\n\23\f\23\16\23\u00f0\13\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24"+
		"\u00f8\n\24\3\25\3\25\3\25\3\25\5\25\u00fe\n\25\3\26\3\26\3\27\3\27\3"+
		"\27\7\27\u0105\n\27\f\27\16\27\u0108\13\27\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\5\30\u0110\n\30\3\31\3\31\3\31\3\31\3\31\5\31\u0117\n\31\3\31\5\31"+
		"\u011a\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u0124\n\31\f"+
		"\31\16\31\u0127\13\31\3\32\3\32\3\32\3\32\3\32\7\32\u012e\n\32\f\32\16"+
		"\32\u0131\13\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\5\33\u0142\n\33\3\34\3\34\3\34\6\34\u0147\n\34\r"+
		"\34\16\34\u0148\3\34\3\34\3\34\3\34\6\34\u014f\n\34\r\34\16\34\u0150\3"+
		"\34\3\34\7\34\u0155\n\34\f\34\16\34\u0158\13\34\5\34\u015a\n\34\3\34\3"+
		"\34\3\34\7\34\u015f\n\34\f\34\16\34\u0162\13\34\3\34\3\34\3\34\3\34\7"+
		"\34\u0168\n\34\f\34\16\34\u016b\13\34\3\34\3\34\7\34\u016f\n\34\f\34\16"+
		"\34\u0172\13\34\5\34\u0174\n\34\3\34\3\34\3\34\5\34\u0179\n\34\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u0187\n\35"+
		"\f\35\16\35\u018a\13\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\7"+
		"\36\u0195\n\36\f\36\16\36\u0198\13\36\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\7\37\u01a3\n\37\f\37\16\37\u01a6\13\37\3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \7 \u01b7\n \f \16 \u01ba\13 \3!\3!\3!\3!"+
		"\3!\3!\3!\3!\3!\7!\u01c5\n!\f!\16!\u01c8\13!\3\"\3\"\3\"\3\"\3\"\3\"\7"+
		"\"\u01d0\n\"\f\"\16\"\u01d3\13\"\3#\3#\3#\3#\3#\3#\7#\u01db\n#\f#\16#"+
		"\u01de\13#\3$\3$\3$\3$\3$\3$\7$\u01e6\n$\f$\16$\u01e9\13$\3%\3%\3%\3%"+
		"\3%\3%\7%\u01f1\n%\f%\16%\u01f4\13%\3&\3&\3&\3&\3&\3&\7&\u01fc\n&\f&\16"+
		"&\u01ff\13&\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u0207\n\'\f\'\16\'\u020a\13\'"+
		"\3(\3(\3)\3)\5)\u0210\n)\3)\3)\7)\u0214\n)\f)\16)\u0217\13)\3*\3*\3+\3"+
		"+\3+\2\17\60\628:<>@BDFHJL,\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*,.\60\62\64\668:<>@BDFHJLNPRT\2\6\3\2\r\16\4\2\65\65\67\67\4\2&(*"+
		"*\3\2+,\2\u023f\2[\3\2\2\2\4^\3\2\2\2\6b\3\2\2\2\bv\3\2\2\2\n{\3\2\2\2"+
		"\f\u0080\3\2\2\2\16\u008e\3\2\2\2\20\u0097\3\2\2\2\22\u0099\3\2\2\2\24"+
		"\u009b\3\2\2\2\26\u00a5\3\2\2\2\30\u00b6\3\2\2\2\32\u00ba\3\2\2\2\34\u00bc"+
		"\3\2\2\2\36\u00c2\3\2\2\2 \u00db\3\2\2\2\"\u00dd\3\2\2\2$\u00e8\3\2\2"+
		"\2&\u00f7\3\2\2\2(\u00fd\3\2\2\2*\u00ff\3\2\2\2,\u0101\3\2\2\2.\u010f"+
		"\3\2\2\2\60\u0119\3\2\2\2\62\u0128\3\2\2\2\64\u0141\3\2\2\2\66\u0178\3"+
		"\2\2\28\u017a\3\2\2\2:\u018b\3\2\2\2<\u0199\3\2\2\2>\u01a7\3\2\2\2@\u01bb"+
		"\3\2\2\2B\u01c9\3\2\2\2D\u01d4\3\2\2\2F\u01df\3\2\2\2H\u01ea\3\2\2\2J"+
		"\u01f5\3\2\2\2L\u0200\3\2\2\2N\u020b\3\2\2\2P\u020f\3\2\2\2R\u0218\3\2"+
		"\2\2T\u021a\3\2\2\2VZ\5\4\3\2WZ\5\"\22\2XZ\5\b\5\2YV\3\2\2\2YW\3\2\2\2"+
		"YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\3\3\2\2\2][\3\2\2\2^_\7\64"+
		"\2\2_`\7\67\2\2`a\5\6\4\2a\5\3\2\2\2bg\7\3\2\2cf\5$\23\2df\5\b\5\2ec\3"+
		"\2\2\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hk\3\2\2\2ig\3\2\2\2jl\5"+
		"\n\6\2kj\3\2\2\2kl\3\2\2\2lq\3\2\2\2mp\5$\23\2np\5\b\5\2om\3\2\2\2on\3"+
		"\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\7\4\2\2u\7"+
		"\3\2\2\2vw\5P)\2wx\7\67\2\2xy\5\f\7\2yz\5\24\13\2z\t\3\2\2\2{|\7\67\2"+
		"\2|}\7\5\2\2}~\7\6\2\2~\177\5\24\13\2\177\13\3\2\2\2\u0080\u008c\7\5\2"+
		"\2\u0081\u008d\7\6\2\2\u0082\u0087\5\16\b\2\u0083\u0084\7\7\2\2\u0084"+
		"\u0086\5\16\b\2\u0085\u0083\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3"+
		"\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a"+
		"\u008b\7\6\2\2\u008b\u008d\3\2\2\2\u008c\u0081\3\2\2\2\u008c\u0082\3\2"+
		"\2\2\u008d\r\3\2\2\2\u008e\u008f\5P)\2\u008f\u0090\5N(\2\u0090\17\3\2"+
		"\2\2\u0091\u0098\5\24\13\2\u0092\u0098\5\26\f\2\u0093\u0098\5\30\r\2\u0094"+
		"\u0098\5\32\16\2\u0095\u0098\5 \21\2\u0096\u0098\5\22\n\2\u0097\u0091"+
		"\3\2\2\2\u0097\u0092\3\2\2\2\u0097\u0093\3\2\2\2\u0097\u0094\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0097\u0096\3\2\2\2\u0098\21\3\2\2\2\u0099\u009a\7\b\2"+
		"\2\u009a\23\3\2\2\2\u009b\u00a0\7\3\2\2\u009c\u009f\5\20\t\2\u009d\u009f"+
		"\5\"\22\2\u009e\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f\u00a2\3\2\2\2"+
		"\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a0"+
		"\3\2\2\2\u00a3\u00a4\7\4\2\2\u00a4\25\3\2\2\2\u00a5\u00a6\5*\26\2\u00a6"+
		"\u00a7\7\b\2\2\u00a7\27\3\2\2\2\u00a8\u00a9\7-\2\2\u00a9\u00aa\7\5\2\2"+
		"\u00aa\u00ab\5*\26\2\u00ab\u00ac\7\6\2\2\u00ac\u00ad\5\20\t\2\u00ad\u00b7"+
		"\3\2\2\2\u00ae\u00af\7-\2\2\u00af\u00b0\7\5\2\2\u00b0\u00b1\5*\26\2\u00b1"+
		"\u00b2\7\6\2\2\u00b2\u00b3\5\20\t\2\u00b3\u00b4\7\66\2\2\u00b4\u00b5\5"+
		"\20\t\2\u00b5\u00b7\3\2\2\2\u00b6\u00a8\3\2\2\2\u00b6\u00ae\3\2\2\2\u00b7"+
		"\31\3\2\2\2\u00b8\u00bb\5\34\17\2\u00b9\u00bb\5\36\20\2\u00ba\u00b8\3"+
		"\2\2\2\u00ba\u00b9\3\2\2\2\u00bb\33\3\2\2\2\u00bc\u00bd\7/\2\2\u00bd\u00be"+
		"\7\5\2\2\u00be\u00bf\5*\26\2\u00bf\u00c0\7\6\2\2\u00c0\u00c1\5\20\t\2"+
		"\u00c1\35\3\2\2\2\u00c2\u00c3\7.\2\2\u00c3\u00c5\7\5\2\2\u00c4\u00c6\5"+
		"*\26\2\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\u00c9\7\b\2\2\u00c8\u00ca\5*\26\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca\3\2"+
		"\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cd\7\b\2\2\u00cc\u00ce\5*\26\2\u00cd"+
		"\u00cc\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\7\6"+
		"\2\2\u00d0\u00d1\5\20\t\2\u00d1\37\3\2\2\2\u00d2\u00d4\7\62\2\2\u00d3"+
		"\u00d5\5*\26\2\u00d4\u00d3\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\3\2"+
		"\2\2\u00d6\u00dc\7\b\2\2\u00d7\u00d8\7\60\2\2\u00d8\u00dc\7\b\2\2\u00d9"+
		"\u00da\7\61\2\2\u00da\u00dc\7\b\2\2\u00db\u00d2\3\2\2\2\u00db\u00d7\3"+
		"\2\2\2\u00db\u00d9\3\2\2\2\u00dc!\3\2\2\2\u00dd\u00de\5P)\2\u00de\u00e3"+
		"\5&\24\2\u00df\u00e0\7\7\2\2\u00e0\u00e2\5&\24\2\u00e1\u00df\3\2\2\2\u00e2"+
		"\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\3\2"+
		"\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e7\7\b\2\2\u00e7#\3\2\2\2\u00e8\u00e9"+
		"\5P)\2\u00e9\u00ee\7\67\2\2\u00ea\u00eb\7\7\2\2\u00eb\u00ed\7\67\2\2\u00ec"+
		"\u00ea\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2"+
		"\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\7\b\2\2\u00f2"+
		"%\3\2\2\2\u00f3\u00f8\7\67\2\2\u00f4\u00f5\7\67\2\2\u00f5\u00f6\7\t\2"+
		"\2\u00f6\u00f8\5*\26\2\u00f7\u00f3\3\2\2\2\u00f7\u00f4\3\2\2\2\u00f8\'"+
		"\3\2\2\2\u00f9\u00fe\7%\2\2\u00fa\u00fe\5T+\2\u00fb\u00fe\7$\2\2\u00fc"+
		"\u00fe\7)\2\2\u00fd\u00f9\3\2\2\2\u00fd\u00fa\3\2\2\2\u00fd\u00fb\3\2"+
		"\2\2\u00fd\u00fc\3\2\2\2\u00fe)\3\2\2\2\u00ff\u0100\5L\'\2\u0100+\3\2"+
		"\2\2\u0101\u0106\5*\26\2\u0102\u0103\7\7\2\2\u0103\u0105\5*\26\2\u0104"+
		"\u0102\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2"+
		"\2\2\u0107-\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u0110\5(\25\2\u010a\u0110"+
		"\5N(\2\u010b\u010c\7\5\2\2\u010c\u010d\5*\26\2\u010d\u010e\7\6\2\2\u010e"+
		"\u0110\3\2\2\2\u010f\u0109\3\2\2\2\u010f\u010a\3\2\2\2\u010f\u010b\3\2"+
		"\2\2\u0110/\3\2\2\2\u0111\u0112\b\31\1\2\u0112\u011a\5.\30\2\u0113\u0114"+
		"\7\67\2\2\u0114\u0116\7\5\2\2\u0115\u0117\5,\27\2\u0116\u0115\3\2\2\2"+
		"\u0116\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u011a\7\6\2\2\u0119\u0111"+
		"\3\2\2\2\u0119\u0113\3\2\2\2\u011a\u0125\3\2\2\2\u011b\u011c\f\5\2\2\u011c"+
		"\u011d\7\n\2\2\u011d\u0124\5\60\31\6\u011e\u011f\f\3\2\2\u011f\u0120\7"+
		"\13\2\2\u0120\u0121\5*\26\2\u0121\u0122\7\f\2\2\u0122\u0124\3\2\2\2\u0123"+
		"\u011b\3\2\2\2\u0123\u011e\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2"+
		"\2\2\u0125\u0126\3\2\2\2\u0126\61\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u0129"+
		"\b\32\1\2\u0129\u012a\5\60\31\2\u012a\u012f\3\2\2\2\u012b\u012c\f\3\2"+
		"\2\u012c\u012e\t\2\2\2\u012d\u012b\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d"+
		"\3\2\2\2\u012f\u0130\3\2\2\2\u0130\63\3\2\2\2\u0131\u012f\3\2\2\2\u0132"+
		"\u0142\5\62\32\2\u0133\u0134\7\r\2\2\u0134\u0142\5\64\33\2\u0135\u0136"+
		"\7\16\2\2\u0136\u0142\5\64\33\2\u0137\u0138\7\17\2\2\u0138\u0142\5\64"+
		"\33\2\u0139\u013a\7\20\2\2\u013a\u0142\5\64\33\2\u013b\u013c\7\21\2\2"+
		"\u013c\u0142\5\64\33\2\u013d\u013e\7\22\2\2\u013e\u0142\5\64\33\2\u013f"+
		"\u0140\7\63\2\2\u0140\u0142\5\66\34\2\u0141\u0132\3\2\2\2\u0141\u0133"+
		"\3\2\2\2\u0141\u0135\3\2\2\2\u0141\u0137\3\2\2\2\u0141\u0139\3\2\2\2\u0141"+
		"\u013b\3\2\2\2\u0141\u013d\3\2\2\2\u0141\u013f\3\2\2\2\u0142\65\3\2\2"+
		"\2\u0143\u0159\5R*\2\u0144\u0145\7\13\2\2\u0145\u0147\7\f\2\2\u0146\u0144"+
		"\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149"+
		"\u015a\3\2\2\2\u014a\u014b\7\13\2\2\u014b\u014c\5*\26\2\u014c\u014d\7"+
		"\f\2\2\u014d\u014f\3\2\2\2\u014e\u014a\3\2\2\2\u014f\u0150\3\2\2\2\u0150"+
		"\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0156\3\2\2\2\u0152\u0153\7\13"+
		"\2\2\u0153\u0155\7\f\2\2\u0154\u0152\3\2\2\2\u0155\u0158\3\2\2\2\u0156"+
		"\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2"+
		"\2\2\u0159\u0146\3\2\2\2\u0159\u014e\3\2\2\2\u015a\u0179\3\2\2\2\u015b"+
		"\u0173\7\67\2\2\u015c\u015d\7\13\2\2\u015d\u015f\7\f\2\2\u015e\u015c\3"+
		"\2\2\2\u015f\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161"+
		"\u0174\3\2\2\2\u0162\u0160\3\2\2\2\u0163\u0164\7\13\2\2\u0164\u0165\5"+
		"*\26\2\u0165\u0166\7\f\2\2\u0166\u0168\3\2\2\2\u0167\u0163\3\2\2\2\u0168"+
		"\u016b\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u0170\3\2"+
		"\2\2\u016b\u0169\3\2\2\2\u016c\u016d\7\13\2\2\u016d\u016f\7\f\2\2\u016e"+
		"\u016c\3\2\2\2\u016f\u0172\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2"+
		"\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0173\u0160\3\2\2\2\u0173"+
		"\u0169\3\2\2\2\u0174\u0179\3\2\2\2\u0175\u0176\7\67\2\2\u0176\u0177\7"+
		"\5\2\2\u0177\u0179\7\6\2\2\u0178\u0143\3\2\2\2\u0178\u015b\3\2\2\2\u0178"+
		"\u0175\3\2\2\2\u0179\67\3\2\2\2\u017a\u017b\b\35\1\2\u017b\u017c\5\64"+
		"\33\2\u017c\u0188\3\2\2\2\u017d\u017e\f\5\2\2\u017e\u017f\7\23\2\2\u017f"+
		"\u0187\5\64\33\2\u0180\u0181\f\4\2\2\u0181\u0182\7\24\2\2\u0182\u0187"+
		"\5\64\33\2\u0183\u0184\f\3\2\2\u0184\u0185\7\25\2\2\u0185\u0187\5\64\33"+
		"\2\u0186\u017d\3\2\2\2\u0186\u0180\3\2\2\2\u0186\u0183\3\2\2\2\u0187\u018a"+
		"\3\2\2\2\u0188\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u01899\3\2\2\2\u018a"+
		"\u0188\3\2\2\2\u018b\u018c\b\36\1\2\u018c\u018d\58\35\2\u018d\u0196\3"+
		"\2\2\2\u018e\u018f\f\4\2\2\u018f\u0190\7\22\2\2\u0190\u0195\58\35\2\u0191"+
		"\u0192\f\3\2\2\u0192\u0193\7\21\2\2\u0193\u0195\58\35\2\u0194\u018e\3"+
		"\2\2\2\u0194\u0191\3\2\2\2\u0195\u0198\3\2\2\2\u0196\u0194\3\2\2\2\u0196"+
		"\u0197\3\2\2\2\u0197;\3\2\2\2\u0198\u0196\3\2\2\2\u0199\u019a\b\37\1\2"+
		"\u019a\u019b\5:\36\2\u019b\u01a4\3\2\2\2\u019c\u019d\f\4\2\2\u019d\u019e"+
		"\7\26\2\2\u019e\u01a3\5:\36\2\u019f\u01a0\f\3\2\2\u01a0\u01a1\7\27\2\2"+
		"\u01a1\u01a3\5:\36\2\u01a2\u019c\3\2\2\2\u01a2\u019f\3\2\2\2\u01a3\u01a6"+
		"\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5=\3\2\2\2\u01a6"+
		"\u01a4\3\2\2\2\u01a7\u01a8\b \1\2\u01a8\u01a9\5<\37\2\u01a9\u01b8\3\2"+
		"\2\2\u01aa\u01ab\f\6\2\2\u01ab\u01ac\7\30\2\2\u01ac\u01b7\5<\37\2\u01ad"+
		"\u01ae\f\5\2\2\u01ae\u01af\7\31\2\2\u01af\u01b7\5<\37\2\u01b0\u01b1\f"+
		"\4\2\2\u01b1\u01b2\7\32\2\2\u01b2\u01b7\5<\37\2\u01b3\u01b4\f\3\2\2\u01b4"+
		"\u01b5\7\33\2\2\u01b5\u01b7\5<\37\2\u01b6\u01aa\3\2\2\2\u01b6\u01ad\3"+
		"\2\2\2\u01b6\u01b0\3\2\2\2\u01b6\u01b3\3\2\2\2\u01b7\u01ba\3\2\2\2\u01b8"+
		"\u01b6\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9?\3\2\2\2\u01ba\u01b8\3\2\2\2"+
		"\u01bb\u01bc\b!\1\2\u01bc\u01bd\5> \2\u01bd\u01c6\3\2\2\2\u01be\u01bf"+
		"\f\4\2\2\u01bf\u01c0\7\34\2\2\u01c0\u01c5\5> \2\u01c1\u01c2\f\3\2\2\u01c2"+
		"\u01c3\7\35\2\2\u01c3\u01c5\5> \2\u01c4\u01be\3\2\2\2\u01c4\u01c1\3\2"+
		"\2\2\u01c5\u01c8\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7"+
		"A\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c9\u01ca\b\"\1\2\u01ca\u01cb\5@!\2\u01cb"+
		"\u01d1\3\2\2\2\u01cc\u01cd\f\3\2\2\u01cd\u01ce\7\36\2\2\u01ce\u01d0\5"+
		"@!\2\u01cf\u01cc\3\2\2\2\u01d0\u01d3\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d1"+
		"\u01d2\3\2\2\2\u01d2C\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d4\u01d5\b#\1\2\u01d5"+
		"\u01d6\5B\"\2\u01d6\u01dc\3\2\2\2\u01d7\u01d8\f\3\2\2\u01d8\u01d9\7\37"+
		"\2\2\u01d9\u01db\5B\"\2\u01da\u01d7\3\2\2\2\u01db\u01de\3\2\2\2\u01dc"+
		"\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01ddE\3\2\2\2\u01de\u01dc\3\2\2\2"+
		"\u01df\u01e0\b$\1\2\u01e0\u01e1\5D#\2\u01e1\u01e7\3\2\2\2\u01e2\u01e3"+
		"\f\3\2\2\u01e3\u01e4\7 \2\2\u01e4\u01e6\5D#\2\u01e5\u01e2\3\2\2\2\u01e6"+
		"\u01e9\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8G\3\2\2\2"+
		"\u01e9\u01e7\3\2\2\2\u01ea\u01eb\b%\1\2\u01eb\u01ec\5F$\2\u01ec\u01f2"+
		"\3\2\2\2\u01ed\u01ee\f\3\2\2\u01ee\u01ef\7!\2\2\u01ef\u01f1\5F$\2\u01f0"+
		"\u01ed\3\2\2\2\u01f1\u01f4\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2\u01f3\3\2"+
		"\2\2\u01f3I\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f5\u01f6\b&\1\2\u01f6\u01f7"+
		"\5H%\2\u01f7\u01fd\3\2\2\2\u01f8\u01f9\f\3\2\2\u01f9\u01fa\7\"\2\2\u01fa"+
		"\u01fc\5H%\2\u01fb\u01f8\3\2\2\2\u01fc\u01ff\3\2\2\2\u01fd\u01fb\3\2\2"+
		"\2\u01fd\u01fe\3\2\2\2\u01feK\3\2\2\2\u01ff\u01fd\3\2\2\2\u0200\u0201"+
		"\b\'\1\2\u0201\u0202\5J&\2\u0202\u0208\3\2\2\2\u0203\u0204\f\3\2\2\u0204"+
		"\u0205\7\t\2\2\u0205\u0207\5J&\2\u0206\u0203\3\2\2\2\u0207\u020a\3\2\2"+
		"\2\u0208\u0206\3\2\2\2\u0208\u0209\3\2\2\2\u0209M\3\2\2\2\u020a\u0208"+
		"\3\2\2\2\u020b\u020c\t\3\2\2\u020cO\3\2\2\2\u020d\u0210\7\67\2\2\u020e"+
		"\u0210\5R*\2\u020f\u020d\3\2\2\2\u020f\u020e\3\2\2\2\u0210\u0215\3\2\2"+
		"\2\u0211\u0212\7\13\2\2\u0212\u0214\7\f\2\2\u0213\u0211\3\2\2\2\u0214"+
		"\u0217\3\2\2\2\u0215\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216Q\3\2\2\2"+
		"\u0217\u0215\3\2\2\2\u0218\u0219\t\4\2\2\u0219S\3\2\2\2\u021a\u021b\t"+
		"\5\2\2\u021bU\3\2\2\2<Y[egkoq\u0087\u008c\u0097\u009e\u00a0\u00b6\u00ba"+
		"\u00c5\u00c9\u00cd\u00d4\u00db\u00e3\u00ee\u00f7\u00fd\u0106\u010f\u0116"+
		"\u0119\u0123\u0125\u012f\u0141\u0148\u0150\u0156\u0159\u0160\u0169\u0170"+
		"\u0173\u0178\u0186\u0188\u0194\u0196\u01a2\u01a4\u01b6\u01b8\u01c4\u01c6"+
		"\u01d1\u01dc\u01e7\u01f2\u01fd\u0208\u020f\u0215";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}