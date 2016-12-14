// Generated from C:/Users/alex/Coding/CSC444/MyCompiler/Compiler/src/my/mini/java/grammar\MiniJava.g4 by ANTLR 4.5.3
package my.mini.java.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniJavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, ID=35, INT=36, BOOLEAN=37, WS=38, COMMENT=39, 
		LINE_COMMENT=40;
	public static final int
		RULE_prog = 0, RULE_mainClass = 1, RULE_classDecl = 2, RULE_varDecl = 3, 
		RULE_methodDecl = 4, RULE_operatorDecl = 5, RULE_formalList = 6, RULE_type = 7, 
		RULE_statement = 8, RULE_condExpr = 9, RULE_expr = 10, RULE_math = 11, 
		RULE_atom = 12;
	public static final String[] ruleNames = {
		"prog", "mainClass", "classDecl", "varDecl", "methodDecl", "operatorDecl", 
		"formalList", "type", "statement", "condExpr", "expr", "math", "atom"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'{'", "'public'", "'static'", "'void'", "'main'", "'('", 
		"'String'", "'['", "']'", "')'", "'}'", "'extends'", "';'", "','", "'return'", 
		"'$operator'", "'+'", "'-'", "'*'", "'&&'", "'<'", "'int'", "'boolean'", 
		"'System.out.println'", "'='", "'while'", "'if'", "'else'", "'!'", "'.'", 
		"'length'", "'this'", "'new'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "ID", 
		"INT", "BOOLEAN", "WS", "COMMENT", "LINE_COMMENT"
	};
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
	public String getGrammarFileName() { return "MiniJava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniJavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public MainClassContext mainClass() {
			return getRuleContext(MainClassContext.class,0);
		}
		public List<ClassDeclContext> classDecl() {
			return getRuleContexts(ClassDeclContext.class);
		}
		public ClassDeclContext classDecl(int i) {
			return getRuleContext(ClassDeclContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			mainClass();
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(27);
				classDecl();
				}
				}
				setState(32);
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

	public static class MainClassContext extends ParserRuleContext {
		public MainClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainClass; }
	 
		public MainClassContext() { }
		public void copyFrom(MainClassContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MainContext extends MainClassContext {
		public Token className;
		public Token str;
		public Token paramName;
		public List<TerminalNode> ID() { return getTokens(MiniJavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniJavaParser.ID, i);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MainContext(MainClassContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainClassContext mainClass() throws RecognitionException {
		MainClassContext _localctx = new MainClassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainClass);
		int _la;
		try {
			int _alt;
			_localctx = new MainContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(T__0);
			setState(34);
			((MainContext)_localctx).className = match(ID);
			setState(35);
			match(T__1);
			setState(36);
			match(T__2);
			setState(37);
			match(T__3);
			setState(38);
			match(T__4);
			setState(39);
			match(T__5);
			setState(40);
			match(T__6);
			setState(41);
			((MainContext)_localctx).str = match(T__7);
			setState(42);
			match(T__8);
			setState(43);
			match(T__9);
			setState(44);
			((MainContext)_localctx).paramName = match(ID);
			setState(45);
			match(T__10);
			setState(46);
			match(T__1);
			setState(50);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(47);
					varDecl();
					}
					} 
				}
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__24) | (1L << T__26) | (1L << T__27) | (1L << ID))) != 0)) {
				{
				{
				setState(53);
				statement();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			match(T__11);
			setState(60);
			match(T__11);
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

	public static class ClassDeclContext extends ParserRuleContext {
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
	 
		public ClassDeclContext() { }
		public void copyFrom(ClassDeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ChildClassContext extends ClassDeclContext {
		public Token className;
		public Token parentName;
		public List<TerminalNode> ID() { return getTokens(MiniJavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniJavaParser.ID, i);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<MethodDeclContext> methodDecl() {
			return getRuleContexts(MethodDeclContext.class);
		}
		public MethodDeclContext methodDecl(int i) {
			return getRuleContext(MethodDeclContext.class,i);
		}
		public List<OperatorDeclContext> operatorDecl() {
			return getRuleContexts(OperatorDeclContext.class);
		}
		public OperatorDeclContext operatorDecl(int i) {
			return getRuleContext(OperatorDeclContext.class,i);
		}
		public ChildClassContext(ClassDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterChildClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitChildClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitChildClass(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassContext extends ClassDeclContext {
		public Token className;
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<MethodDeclContext> methodDecl() {
			return getRuleContexts(MethodDeclContext.class);
		}
		public MethodDeclContext methodDecl(int i) {
			return getRuleContext(MethodDeclContext.class,i);
		}
		public List<OperatorDeclContext> operatorDecl() {
			return getRuleContexts(OperatorDeclContext.class);
		}
		public OperatorDeclContext operatorDecl(int i) {
			return getRuleContext(OperatorDeclContext.class,i);
		}
		public ClassContext(ClassDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDecl);
		int _la;
		try {
			int _alt;
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new ClassContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(T__0);
				setState(63);
				((ClassContext)_localctx).className = match(ID);
				setState(64);
				match(T__1);
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__23) | (1L << ID))) != 0)) {
					{
					{
					setState(65);
					varDecl();
					}
					}
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(74);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(71);
						methodDecl();
						}
						} 
					}
					setState(76);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(77);
					operatorDecl();
					}
					}
					setState(82);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(83);
				match(T__11);
				}
				break;
			case 2:
				_localctx = new ChildClassContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				match(T__0);
				setState(85);
				((ChildClassContext)_localctx).className = match(ID);
				setState(86);
				match(T__12);
				setState(87);
				((ChildClassContext)_localctx).parentName = match(ID);
				setState(88);
				match(T__1);
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__23) | (1L << ID))) != 0)) {
					{
					{
					setState(89);
					varDecl();
					}
					}
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(98);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(95);
						methodDecl();
						}
						} 
					}
					setState(100);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(101);
					operatorDecl();
					}
					}
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(107);
				match(T__11);
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

	public static class VarDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			type();
			setState(111);
			match(ID);
			setState(112);
			match(T__13);
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

	public static class MethodDeclContext extends ParserRuleContext {
		public Token methodName;
		public Token retn;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public List<FormalListContext> formalList() {
			return getRuleContexts(FormalListContext.class);
		}
		public FormalListContext formalList(int i) {
			return getRuleContext(FormalListContext.class,i);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMethodDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMethodDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(T__2);
			setState(115);
			type();
			setState(116);
			((MethodDeclContext)_localctx).methodName = match(ID);
			setState(117);
			match(T__6);
			setState(130);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__23) | (1L << ID))) != 0)) {
				{
				setState(118);
				formalList();
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(119);
					match(T__14);
					setState(121); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(120);
						formalList();
						}
						}
						setState(123); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__23) | (1L << ID))) != 0) );
					}
					}
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(132);
			match(T__10);
			setState(133);
			match(T__1);
			setState(137);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(134);
					varDecl();
					}
					} 
				}
				setState(139);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__24) | (1L << T__26) | (1L << T__27) | (1L << ID))) != 0)) {
				{
				{
				setState(140);
				statement();
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(146);
			((MethodDeclContext)_localctx).retn = match(T__15);
			setState(147);
			expr();
			setState(148);
			match(T__13);
			setState(149);
			match(T__11);
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

	public static class OperatorDeclContext extends ParserRuleContext {
		public Token operator;
		public Token retn;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FormalListContext formalList() {
			return getRuleContext(FormalListContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public OperatorDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterOperatorDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitOperatorDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitOperatorDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorDeclContext operatorDecl() throws RecognitionException {
		OperatorDeclContext _localctx = new OperatorDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_operatorDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__2);
			setState(152);
			type();
			setState(153);
			match(T__16);
			setState(154);
			((OperatorDeclContext)_localctx).operator = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
				((OperatorDeclContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(155);
			match(T__6);
			setState(156);
			formalList();
			setState(157);
			match(T__10);
			setState(158);
			match(T__1);
			setState(162);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(159);
					varDecl();
					}
					} 
				}
				setState(164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__24) | (1L << T__26) | (1L << T__27) | (1L << ID))) != 0)) {
				{
				{
				setState(165);
				statement();
				}
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(171);
			((OperatorDeclContext)_localctx).retn = match(T__15);
			setState(172);
			expr();
			setState(173);
			match(T__13);
			setState(174);
			match(T__11);
			}
		}
		catch (RecognitionException e) {


			            //Custom handling of an exception. Any java code is allowed.
			            if (getCurrentToken().getText().equals(","))
			            System.err.println("Only one parameter is allowed for operator overloading.");
			            throw e;

			        
		}
		catch (ParseCancellationException e) {


			            //Custom handling of an exception. Any java code is allowed.
			            if (getCurrentToken().getText().equals(")"))
			            throw new ParseCancellationException(e.getMessage() + "\nA single parameter with a name is required.");
			            else if (getCurrentToken().getText().equals("("))
			            throw new ParseCancellationException(e.getMessage() + "\nAfter 'operator' one of the above symbols is required.");
			            else if (getCurrentToken().getText().equals("operator"))
			            throw new ParseCancellationException(e.getMessage() + "\n[+, -, *, &&, <] are the possible choices. The above mentioned is not one of them. :/");
			            else if (getCurrentToken().getText().equals("{"))
			            throw new ParseCancellationException(e.getMessage() + "\nAdd a ')' after your parameter.");
			            else
			            throw e;

			        
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalListContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public FormalListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterFormalList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitFormalList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitFormalList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalListContext formalList() throws RecognitionException {
		FormalListContext _localctx = new FormalListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_formalList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			type();
			setState(177);
			match(ID);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(T__22);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				match(T__22);
				setState(181);
				match(T__8);
				setState(182);
				match(T__9);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(183);
				match(T__23);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(184);
				match(ID);
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
	public static class AssignmentContext extends StatementContext {
		public Token varName;
		public ExprContext assignee;
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoopContext extends StatementContext {
		public CondExprContext condition;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public CondExprContext condExpr() {
			return getRuleContext(CondExprContext.class,0);
		}
		public LoopContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintContext extends StatementContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ScopedContext extends StatementContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ScopedContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterScoped(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitScoped(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitScoped(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends StatementContext {
		public CondExprContext condition;
		public StatementContext stm1;
		public StatementContext stm2;
		public CondExprContext condExpr() {
			return getRuleContext(CondExprContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayAssignmentContext extends StatementContext {
		public Token varName;
		public Token element;
		public ExprContext assignee;
		public List<TerminalNode> ID() { return getTokens(MiniJavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniJavaParser.ID, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode INT() { return getToken(MiniJavaParser.INT, 0); }
		public ArrayAssignmentContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterArrayAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitArrayAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitArrayAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		int _la;
		try {
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new ScopedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				match(T__1);
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__24) | (1L << T__26) | (1L << T__27) | (1L << ID))) != 0)) {
					{
					{
					setState(188);
					statement();
					}
					}
					setState(193);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(194);
				match(T__11);
				}
				break;
			case 2:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				match(T__24);
				setState(196);
				match(T__6);
				setState(197);
				expr();
				setState(198);
				match(T__10);
				setState(199);
				match(T__13);
				}
				break;
			case 3:
				_localctx = new AssignmentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				((AssignmentContext)_localctx).varName = match(ID);
				setState(202);
				match(T__25);
				setState(203);
				((AssignmentContext)_localctx).assignee = expr();
				setState(204);
				match(T__13);
				}
				break;
			case 4:
				_localctx = new ArrayAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(206);
				((ArrayAssignmentContext)_localctx).varName = match(ID);
				setState(207);
				match(T__8);
				setState(210);
				switch (_input.LA(1)) {
				case INT:
					{
					setState(208);
					((ArrayAssignmentContext)_localctx).element = match(INT);
					}
					break;
				case ID:
					{
					setState(209);
					((ArrayAssignmentContext)_localctx).element = match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(212);
				match(T__9);
				setState(213);
				match(T__25);
				setState(214);
				((ArrayAssignmentContext)_localctx).assignee = expr();
				setState(215);
				match(T__13);
				}
				break;
			case 5:
				_localctx = new LoopContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(217);
				match(T__26);
				setState(218);
				match(T__6);
				setState(219);
				((LoopContext)_localctx).condition = condExpr(0);
				setState(220);
				match(T__10);
				setState(221);
				statement();
				}
				break;
			case 6:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(223);
				match(T__27);
				setState(224);
				match(T__6);
				setState(225);
				((IfContext)_localctx).condition = condExpr(0);
				setState(226);
				match(T__10);
				setState(227);
				((IfContext)_localctx).stm1 = statement();
				setState(230);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(228);
					match(T__28);
					setState(229);
					((IfContext)_localctx).stm2 = statement();
					}
					break;
				}
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

	public static class CondExprContext extends ParserRuleContext {
		public CondExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condExpr; }
	 
		public CondExprContext() { }
		public void copyFrom(CondExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NotContext extends CondExprContext {
		public CondExprContext condExpr() {
			return getRuleContext(CondExprContext.class,0);
		}
		public NotContext(CondExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessThanContext extends CondExprContext {
		public CondExprContext cond1;
		public CondExprContext cond2;
		public List<CondExprContext> condExpr() {
			return getRuleContexts(CondExprContext.class);
		}
		public CondExprContext condExpr(int i) {
			return getRuleContext(CondExprContext.class,i);
		}
		public LessThanContext(CondExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterLessThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitLessThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitLessThan(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends CondExprContext {
		public CondExprContext cond1;
		public CondExprContext cond2;
		public List<CondExprContext> condExpr() {
			return getRuleContexts(CondExprContext.class);
		}
		public CondExprContext condExpr(int i) {
			return getRuleContext(CondExprContext.class,i);
		}
		public AndContext(CondExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NestedConditionContext extends CondExprContext {
		public CondExprContext condExpr() {
			return getRuleContext(CondExprContext.class,0);
		}
		public NestedConditionContext(CondExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterNestedCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitNestedCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitNestedCondition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpContext extends CondExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExpContext(CondExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondExprContext condExpr() throws RecognitionException {
		return condExpr(0);
	}

	private CondExprContext condExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondExprContext _localctx = new CondExprContext(_ctx, _parentState);
		CondExprContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_condExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				_localctx = new NestedConditionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(235);
				match(T__6);
				setState(236);
				condExpr(0);
				setState(237);
				match(T__10);
				}
				break;
			case 2:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(239);
				match(T__29);
				setState(240);
				condExpr(4);
				}
				break;
			case 3:
				{
				_localctx = new ExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(241);
				expr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(252);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(250);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new LessThanContext(new CondExprContext(_parentctx, _parentState));
						((LessThanContext)_localctx).cond1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condExpr);
						setState(244);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(245);
						match(T__21);
						setState(246);
						((LessThanContext)_localctx).cond2 = condExpr(4);
						}
						break;
					case 2:
						{
						_localctx = new AndContext(new CondExprContext(_parentctx, _parentState));
						((AndContext)_localctx).cond1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condExpr);
						setState(247);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(248);
						match(T__20);
						setState(249);
						((AndContext)_localctx).cond2 = condExpr(3);
						}
						break;
					}
					} 
				}
				setState(254);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayAccessContext extends ExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArrayAccessContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterArrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitArrayAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrailingContext extends ExprContext {
		public Token operator;
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TrailingContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterTrailing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitTrailing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitTrailing(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayLengthContext extends ExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public ArrayLengthContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterArrayLength(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitArrayLength(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitArrayLength(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CalculationContext extends ExprContext {
		public MathContext math() {
			return getRuleContext(MathContext.class,0);
		}
		public CalculationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterCalculation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitCalculation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitCalculation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MethodCallContext extends ExprContext {
		public Token methodName;
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MethodCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr);
		int _la;
		try {
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new CalculationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				math(0);
				}
				break;
			case 2:
				_localctx = new TrailingContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
				switch (_input.LA(1)) {
				case T__17:
					{
					setState(256);
					((TrailingContext)_localctx).operator = match(T__17);
					}
					break;
				case T__18:
					{
					setState(257);
					((TrailingContext)_localctx).operator = match(T__18);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(260);
				atom();
				}
				break;
			case 3:
				_localctx = new ArrayAccessContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(261);
				atom();
				setState(262);
				match(T__8);
				setState(263);
				expr();
				setState(264);
				match(T__9);
				}
				break;
			case 4:
				_localctx = new ArrayLengthContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(266);
				atom();
				setState(267);
				match(T__30);
				setState(268);
				match(T__31);
				}
				break;
			case 5:
				_localctx = new MethodCallContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(270);
				atom();
				setState(271);
				match(T__30);
				setState(272);
				((MethodCallContext)_localctx).methodName = match(ID);
				setState(273);
				match(T__6);
				setState(282);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__32) | (1L << T__33) | (1L << ID) | (1L << INT) | (1L << BOOLEAN))) != 0)) {
					{
					setState(274);
					expr();
					setState(279);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__14) {
						{
						{
						setState(275);
						match(T__14);
						setState(276);
						expr();
						}
						}
						setState(281);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(284);
				match(T__10);
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

	public static class MathContext extends ParserRuleContext {
		public MathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math; }
	 
		public MathContext() { }
		public void copyFrom(MathContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultContext extends MathContext {
		public MathContext left;
		public MathContext right;
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public MultContext(MathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMult(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtmContext extends MathContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtmContext(MathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterAtm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitAtm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitAtm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusContext extends MathContext {
		public MathContext left;
		public MathContext right;
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public PlusContext(MathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinusContext extends MathContext {
		public MathContext left;
		public MathContext right;
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public MinusContext(MathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MathContext math() throws RecognitionException {
		return math(0);
	}

	private MathContext math(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MathContext _localctx = new MathContext(_ctx, _parentState);
		MathContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_math, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new AtmContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(289);
			atom();
			}
			_ctx.stop = _input.LT(-1);
			setState(302);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(300);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
					case 1:
						{
						_localctx = new MultContext(new MathContext(_parentctx, _parentState));
						((MultContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_math);
						setState(291);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(292);
						match(T__19);
						setState(293);
						((MultContext)_localctx).right = math(5);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new MathContext(_parentctx, _parentState));
						((MinusContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_math);
						setState(294);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(295);
						match(T__18);
						setState(296);
						((MinusContext)_localctx).right = math(4);
						}
						break;
					case 3:
						{
						_localctx = new PlusContext(new MathContext(_parentctx, _parentState));
						((PlusContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_math);
						setState(297);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(298);
						match(T__17);
						setState(299);
						((PlusContext)_localctx).right = math(3);
						}
						break;
					}
					} 
				}
				setState(304);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ReferenceThisContext extends AtomContext {
		public ReferenceThisContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterReferenceThis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitReferenceThis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitReferenceThis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberContext extends AtomContext {
		public TerminalNode INT() { return getToken(MiniJavaParser.INT, 0); }
		public NumberContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolContext extends AtomContext {
		public TerminalNode BOOLEAN() { return getToken(MiniJavaParser.BOOLEAN, 0); }
		public BoolContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ObjectReferenceContext extends AtomContext {
		public Token varName;
		public Token methodName;
		public List<TerminalNode> ID() { return getTokens(MiniJavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniJavaParser.ID, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ObjectReferenceContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterObjectReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitObjectReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitObjectReference(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesizedExprContext extends AtomContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenthesizedExprContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterParenthesizedExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitParenthesizedExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitParenthesizedExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewIntArrayContext extends AtomContext {
		public ExprContext size;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NewIntArrayContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterNewIntArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitNewIntArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitNewIntArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InstatiateContext extends AtomContext {
		public Token className;
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public InstatiateContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterInstatiate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitInstatiate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitInstatiate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_atom);
		try {
			setState(334);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new NumberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				match(INT);
				}
				break;
			case 2:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(306);
				match(BOOLEAN);
				}
				break;
			case 3:
				_localctx = new ObjectReferenceContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(309);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(307);
					((ObjectReferenceContext)_localctx).varName = match(ID);
					}
					break;
				case T__32:
					{
					setState(308);
					((ObjectReferenceContext)_localctx).varName = match(T__32);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(317);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(311);
					match(T__30);
					setState(312);
					((ObjectReferenceContext)_localctx).methodName = match(ID);
					setState(313);
					match(T__6);
					setState(314);
					expr();
					setState(315);
					match(T__10);
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new InstatiateContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(319);
				match(T__33);
				setState(320);
				((InstatiateContext)_localctx).className = match(ID);
				setState(321);
				match(T__6);
				setState(322);
				match(T__10);
				}
				break;
			case 5:
				_localctx = new ReferenceThisContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(323);
				match(T__32);
				}
				break;
			case 6:
				_localctx = new NewIntArrayContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(324);
				match(T__33);
				setState(325);
				match(T__22);
				setState(326);
				match(T__8);
				setState(327);
				((NewIntArrayContext)_localctx).size = expr();
				setState(328);
				match(T__9);
				}
				break;
			case 7:
				_localctx = new ParenthesizedExprContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(330);
				match(T__6);
				setState(331);
				expr();
				setState(332);
				match(T__10);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return condExpr_sempred((CondExprContext)_localctx, predIndex);
		case 11:
			return math_sempred((MathContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean condExpr_sempred(CondExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean math_sempred(MathContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u0153\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\7\2\37\n\2\f\2\16\2\"\13\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\63\n\3\f\3"+
		"\16\3\66\13\3\3\3\7\39\n\3\f\3\16\3<\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\7\4E\n\4\f\4\16\4H\13\4\3\4\7\4K\n\4\f\4\16\4N\13\4\3\4\7\4Q\n\4\f\4"+
		"\16\4T\13\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4]\n\4\f\4\16\4`\13\4\3\4\7"+
		"\4c\n\4\f\4\16\4f\13\4\3\4\7\4i\n\4\f\4\16\4l\13\4\3\4\5\4o\n\4\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6|\n\6\r\6\16\6}\7\6\u0080\n"+
		"\6\f\6\16\6\u0083\13\6\5\6\u0085\n\6\3\6\3\6\3\6\7\6\u008a\n\6\f\6\16"+
		"\6\u008d\13\6\3\6\7\6\u0090\n\6\f\6\16\6\u0093\13\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00a3\n\7\f\7\16\7\u00a6\13"+
		"\7\3\7\7\7\u00a9\n\7\f\7\16\7\u00ac\13\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00bc\n\t\3\n\3\n\7\n\u00c0\n\n\f\n\16"+
		"\n\u00c3\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\5\n\u00d5\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00e9\n\n\5\n\u00eb\n\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\5\13\u00f5\n\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\7\13\u00fd\n\13\f\13\16\13\u0100\13\13\3\f\3\f\3\f\5\f\u0105\n\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0118"+
		"\n\f\f\f\16\f\u011b\13\f\5\f\u011d\n\f\3\f\3\f\5\f\u0121\n\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u012f\n\r\f\r\16\r\u0132\13"+
		"\r\3\16\3\16\3\16\3\16\5\16\u0138\n\16\3\16\3\16\3\16\3\16\3\16\3\16\5"+
		"\16\u0140\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\5\16\u0151\n\16\3\16\2\4\24\30\17\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\2\3\3\2\24\30\u0177\2\34\3\2\2\2\4#\3\2\2\2\6n\3\2"+
		"\2\2\bp\3\2\2\2\nt\3\2\2\2\f\u0099\3\2\2\2\16\u00b2\3\2\2\2\20\u00bb\3"+
		"\2\2\2\22\u00ea\3\2\2\2\24\u00f4\3\2\2\2\26\u0120\3\2\2\2\30\u0122\3\2"+
		"\2\2\32\u0150\3\2\2\2\34 \5\4\3\2\35\37\5\6\4\2\36\35\3\2\2\2\37\"\3\2"+
		"\2\2 \36\3\2\2\2 !\3\2\2\2!\3\3\2\2\2\" \3\2\2\2#$\7\3\2\2$%\7%\2\2%&"+
		"\7\4\2\2&\'\7\5\2\2\'(\7\6\2\2()\7\7\2\2)*\7\b\2\2*+\7\t\2\2+,\7\n\2\2"+
		",-\7\13\2\2-.\7\f\2\2./\7%\2\2/\60\7\r\2\2\60\64\7\4\2\2\61\63\5\b\5\2"+
		"\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65:\3\2\2\2\66"+
		"\64\3\2\2\2\679\5\22\n\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3"+
		"\2\2\2<:\3\2\2\2=>\7\16\2\2>?\7\16\2\2?\5\3\2\2\2@A\7\3\2\2AB\7%\2\2B"+
		"F\7\4\2\2CE\5\b\5\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GL\3\2\2\2"+
		"HF\3\2\2\2IK\5\n\6\2JI\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MR\3\2\2\2"+
		"NL\3\2\2\2OQ\5\f\7\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2\2"+
		"TR\3\2\2\2Uo\7\16\2\2VW\7\3\2\2WX\7%\2\2XY\7\17\2\2YZ\7%\2\2Z^\7\4\2\2"+
		"[]\5\b\5\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_d\3\2\2\2`^\3\2\2"+
		"\2ac\5\n\6\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2ej\3\2\2\2fd\3\2\2"+
		"\2gi\5\f\7\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2"+
		"\2mo\7\16\2\2n@\3\2\2\2nV\3\2\2\2o\7\3\2\2\2pq\5\20\t\2qr\7%\2\2rs\7\20"+
		"\2\2s\t\3\2\2\2tu\7\5\2\2uv\5\20\t\2vw\7%\2\2w\u0084\7\t\2\2x\u0081\5"+
		"\16\b\2y{\7\21\2\2z|\5\16\b\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2"+
		"~\u0080\3\2\2\2\177y\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081"+
		"\u0082\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0084x\3\2\2\2"+
		"\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\7\r\2\2\u0087\u008b"+
		"\7\4\2\2\u0088\u008a\5\b\5\2\u0089\u0088\3\2\2\2\u008a\u008d\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u0091\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008e\u0090\5\22\n\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2"+
		"\2\2\u0094\u0095\7\22\2\2\u0095\u0096\5\26\f\2\u0096\u0097\7\20\2\2\u0097"+
		"\u0098\7\16\2\2\u0098\13\3\2\2\2\u0099\u009a\7\5\2\2\u009a\u009b\5\20"+
		"\t\2\u009b\u009c\7\23\2\2\u009c\u009d\t\2\2\2\u009d\u009e\7\t\2\2\u009e"+
		"\u009f\5\16\b\2\u009f\u00a0\7\r\2\2\u00a0\u00a4\7\4\2\2\u00a1\u00a3\5"+
		"\b\5\2\u00a2\u00a1\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00aa\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a9\5\22"+
		"\n\2\u00a8\u00a7\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae\7\22"+
		"\2\2\u00ae\u00af\5\26\f\2\u00af\u00b0\7\20\2\2\u00b0\u00b1\7\16\2\2\u00b1"+
		"\r\3\2\2\2\u00b2\u00b3\5\20\t\2\u00b3\u00b4\7%\2\2\u00b4\17\3\2\2\2\u00b5"+
		"\u00bc\7\31\2\2\u00b6\u00b7\7\31\2\2\u00b7\u00b8\7\13\2\2\u00b8\u00bc"+
		"\7\f\2\2\u00b9\u00bc\7\32\2\2\u00ba\u00bc\7%\2\2\u00bb\u00b5\3\2\2\2\u00bb"+
		"\u00b6\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\21\3\2\2"+
		"\2\u00bd\u00c1\7\4\2\2\u00be\u00c0\5\22\n\2\u00bf\u00be\3\2\2\2\u00c0"+
		"\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4\3\2"+
		"\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00eb\7\16\2\2\u00c5\u00c6\7\33\2\2\u00c6"+
		"\u00c7\7\t\2\2\u00c7\u00c8\5\26\f\2\u00c8\u00c9\7\r\2\2\u00c9\u00ca\7"+
		"\20\2\2\u00ca\u00eb\3\2\2\2\u00cb\u00cc\7%\2\2\u00cc\u00cd\7\34\2\2\u00cd"+
		"\u00ce\5\26\f\2\u00ce\u00cf\7\20\2\2\u00cf\u00eb\3\2\2\2\u00d0\u00d1\7"+
		"%\2\2\u00d1\u00d4\7\13\2\2\u00d2\u00d5\7&\2\2\u00d3\u00d5\7%\2\2\u00d4"+
		"\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\7\f"+
		"\2\2\u00d7\u00d8\7\34\2\2\u00d8\u00d9\5\26\f\2\u00d9\u00da\7\20\2\2\u00da"+
		"\u00eb\3\2\2\2\u00db\u00dc\7\35\2\2\u00dc\u00dd\7\t\2\2\u00dd\u00de\5"+
		"\24\13\2\u00de\u00df\7\r\2\2\u00df\u00e0\5\22\n\2\u00e0\u00eb\3\2\2\2"+
		"\u00e1\u00e2\7\36\2\2\u00e2\u00e3\7\t\2\2\u00e3\u00e4\5\24\13\2\u00e4"+
		"\u00e5\7\r\2\2\u00e5\u00e8\5\22\n\2\u00e6\u00e7\7\37\2\2\u00e7\u00e9\5"+
		"\22\n\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea"+
		"\u00bd\3\2\2\2\u00ea\u00c5\3\2\2\2\u00ea\u00cb\3\2\2\2\u00ea\u00d0\3\2"+
		"\2\2\u00ea\u00db\3\2\2\2\u00ea\u00e1\3\2\2\2\u00eb\23\3\2\2\2\u00ec\u00ed"+
		"\b\13\1\2\u00ed\u00ee\7\t\2\2\u00ee\u00ef\5\24\13\2\u00ef\u00f0\7\r\2"+
		"\2\u00f0\u00f5\3\2\2\2\u00f1\u00f2\7 \2\2\u00f2\u00f5\5\24\13\6\u00f3"+
		"\u00f5\5\26\f\2\u00f4\u00ec\3\2\2\2\u00f4\u00f1\3\2\2\2\u00f4\u00f3\3"+
		"\2\2\2\u00f5\u00fe\3\2\2\2\u00f6\u00f7\f\5\2\2\u00f7\u00f8\7\30\2\2\u00f8"+
		"\u00fd\5\24\13\6\u00f9\u00fa\f\4\2\2\u00fa\u00fb\7\27\2\2\u00fb\u00fd"+
		"\5\24\13\5\u00fc\u00f6\3\2\2\2\u00fc\u00f9\3\2\2\2\u00fd\u0100\3\2\2\2"+
		"\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\25\3\2\2\2\u0100\u00fe"+
		"\3\2\2\2\u0101\u0121\5\30\r\2\u0102\u0105\7\24\2\2\u0103\u0105\7\25\2"+
		"\2\u0104\u0102\3\2\2\2\u0104\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0121"+
		"\5\32\16\2\u0107\u0108\5\32\16\2\u0108\u0109\7\13\2\2\u0109\u010a\5\26"+
		"\f\2\u010a\u010b\7\f\2\2\u010b\u0121\3\2\2\2\u010c\u010d\5\32\16\2\u010d"+
		"\u010e\7!\2\2\u010e\u010f\7\"\2\2\u010f\u0121\3\2\2\2\u0110\u0111\5\32"+
		"\16\2\u0111\u0112\7!\2\2\u0112\u0113\7%\2\2\u0113\u011c\7\t\2\2\u0114"+
		"\u0119\5\26\f\2\u0115\u0116\7\21\2\2\u0116\u0118\5\26\f\2\u0117\u0115"+
		"\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a"+
		"\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u0114\3\2\2\2\u011c\u011d\3\2"+
		"\2\2\u011d\u011e\3\2\2\2\u011e\u011f\7\r\2\2\u011f\u0121\3\2\2\2\u0120"+
		"\u0101\3\2\2\2\u0120\u0104\3\2\2\2\u0120\u0107\3\2\2\2\u0120\u010c\3\2"+
		"\2\2\u0120\u0110\3\2\2\2\u0121\27\3\2\2\2\u0122\u0123\b\r\1\2\u0123\u0124"+
		"\5\32\16\2\u0124\u0130\3\2\2\2\u0125\u0126\f\6\2\2\u0126\u0127\7\26\2"+
		"\2\u0127\u012f\5\30\r\7\u0128\u0129\f\5\2\2\u0129\u012a\7\25\2\2\u012a"+
		"\u012f\5\30\r\6\u012b\u012c\f\4\2\2\u012c\u012d\7\24\2\2\u012d\u012f\5"+
		"\30\r\5\u012e\u0125\3\2\2\2\u012e\u0128\3\2\2\2\u012e\u012b\3\2\2\2\u012f"+
		"\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\31\3\2\2"+
		"\2\u0132\u0130\3\2\2\2\u0133\u0151\7&\2\2\u0134\u0151\7\'\2\2\u0135\u0138"+
		"\7%\2\2\u0136\u0138\7#\2\2\u0137\u0135\3\2\2\2\u0137\u0136\3\2\2\2\u0138"+
		"\u013f\3\2\2\2\u0139\u013a\7!\2\2\u013a\u013b\7%\2\2\u013b\u013c\7\t\2"+
		"\2\u013c\u013d\5\26\f\2\u013d\u013e\7\r\2\2\u013e\u0140\3\2\2\2\u013f"+
		"\u0139\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0151\3\2\2\2\u0141\u0142\7$"+
		"\2\2\u0142\u0143\7%\2\2\u0143\u0144\7\t\2\2\u0144\u0151\7\r\2\2\u0145"+
		"\u0151\7#\2\2\u0146\u0147\7$\2\2\u0147\u0148\7\31\2\2\u0148\u0149\7\13"+
		"\2\2\u0149\u014a\5\26\f\2\u014a\u014b\7\f\2\2\u014b\u0151\3\2\2\2\u014c"+
		"\u014d\7\t\2\2\u014d\u014e\5\26\f\2\u014e\u014f\7\r\2\2\u014f\u0151\3"+
		"\2\2\2\u0150\u0133\3\2\2\2\u0150\u0134\3\2\2\2\u0150\u0137\3\2\2\2\u0150"+
		"\u0141\3\2\2\2\u0150\u0145\3\2\2\2\u0150\u0146\3\2\2\2\u0150\u014c\3\2"+
		"\2\2\u0151\33\3\2\2\2$ \64:FLR^djn}\u0081\u0084\u008b\u0091\u00a4\u00aa"+
		"\u00bb\u00c1\u00d4\u00e8\u00ea\u00f4\u00fc\u00fe\u0104\u0119\u011c\u0120"+
		"\u012e\u0130\u0137\u013f\u0150";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}