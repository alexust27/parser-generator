// Generated from /home/alex/IdeaProjects/MT4/src/main/antlr/Grammar.g4 by ANTLR 4.7.2
package main.java.parser;

    import main.java.grammar.*;

    import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
    import org.antlr.v4.runtime.tree.*;
import java.util.List;
    import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, TERM=13, NTERM=14, String=15, Code=16, WS=17, 
		COMMA=18;
	public static final int
		RULE_start = 0, RULE_oneRule = 1, RULE_args = 2, RULE_arg = 3, RULE_rulePart = 4, 
		RULE_terms = 5, RULE_param = 6, RULE_type = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "oneRule", "args", "arg", "rulePart", "terms", "param", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'grammar'", "';'", "':'", "'::'", "'skip'", "'->'", "'('", "')'", 
			"'return'", "'['", "']'", "'|'", null, null, null, null, null, "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "TERM", "NTERM", "String", "Code", "WS", "COMMA"
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
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public MainGrammar v;
		public Token TERM;
		public Token NTERM;
		public TerminalNode TERM() { return getToken(GrammarParser.TERM, 0); }
		public TerminalNode NTERM() { return getToken(GrammarParser.NTERM, 0); }
		public List<OneRuleContext> oneRule() {
			return getRuleContexts(OneRuleContext.class);
		}
		public OneRuleContext oneRule(int i) {
			return getRuleContext(OneRuleContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(T__0);
			setState(17);
			((StartContext)_localctx).TERM = match(TERM);
			setState(18);
			((StartContext)_localctx).NTERM = match(NTERM);
			 ((StartContext)_localctx).v =  new MainGrammar((((StartContext)_localctx).NTERM!=null?((StartContext)_localctx).NTERM.getText():null), (((StartContext)_localctx).TERM!=null?((StartContext)_localctx).TERM.getText():null)); 
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20);
				oneRule(_localctx.v);
				setState(21);
				match(T__1);
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << TERM) | (1L << NTERM))) != 0) );
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

	public static class OneRuleContext extends ParserRuleContext {
		public MainGrammar g;
		public Token TERM;
		public Token String;
		public Token NTERM;
		public ArgsContext args;
		public RulePartContext rulePart;
		public TerminalNode TERM() { return getToken(GrammarParser.TERM, 0); }
		public TerminalNode String() { return getToken(GrammarParser.String, 0); }
		public TerminalNode NTERM() { return getToken(GrammarParser.NTERM, 0); }
		public List<RulePartContext> rulePart() {
			return getRuleContexts(RulePartContext.class);
		}
		public RulePartContext rulePart(int i) {
			return getRuleContext(RulePartContext.class,i);
		}
		public List<ArgsContext> args() {
			return getRuleContexts(ArgsContext.class);
		}
		public ArgsContext args(int i) {
			return getRuleContext(ArgsContext.class,i);
		}
		public OneRuleContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public OneRuleContext(ParserRuleContext parent, int invokingState, MainGrammar g) {
			super(parent, invokingState);
			this.g = g;
		}
		@Override public int getRuleIndex() { return RULE_oneRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterOneRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitOneRule(this);
		}
	}

	public final OneRuleContext oneRule(MainGrammar g) throws RecognitionException {
		OneRuleContext _localctx = new OneRuleContext(_ctx, getState(), g);
		enterRule(_localctx, 2, RULE_oneRule);

		            NRule nr;
		            List<Argument> lrets = null;
		            List<Argument> largs = null;
		            String name;
		        
		int _la;
		try {
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				((OneRuleContext)_localctx).TERM = match(TERM);
				setState(28);
				match(T__2);
				setState(29);
				((OneRuleContext)_localctx).String = match(String);
				 _localctx.g.addTermRule(new TRule(false, (((OneRuleContext)_localctx).TERM!=null?((OneRuleContext)_localctx).TERM.getText():null), (((OneRuleContext)_localctx).String!=null?((OneRuleContext)_localctx).String.getText():null))); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				((OneRuleContext)_localctx).TERM = match(TERM);
				setState(32);
				match(T__3);
				setState(33);
				((OneRuleContext)_localctx).String = match(String);
				 _localctx.g.addTermRule(new TRule(true, (((OneRuleContext)_localctx).TERM!=null?((OneRuleContext)_localctx).TERM.getText():null), (((OneRuleContext)_localctx).String!=null?((OneRuleContext)_localctx).String.getText():null))); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(35);
				match(T__4);
				setState(36);
				match(T__5);
				setState(37);
				((OneRuleContext)_localctx).String = match(String);
				 _localctx.g.addSkip((((OneRuleContext)_localctx).String!=null?((OneRuleContext)_localctx).String.getText():null)); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(39);
				((OneRuleContext)_localctx).NTERM = match(NTERM);
				 name = (((OneRuleContext)_localctx).NTERM!=null?((OneRuleContext)_localctx).NTERM.getText():null); 
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(41);
					match(T__6);
					setState(42);
					((OneRuleContext)_localctx).args = args();
					 largs = ((OneRuleContext)_localctx).args.v; 
					setState(44);
					match(T__7);
					}
				}

				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(48);
					match(T__8);
					setState(49);
					match(T__9);
					setState(50);
					((OneRuleContext)_localctx).args = args();
					 lrets = ((OneRuleContext)_localctx).args.v; 
					setState(52);
					match(T__10);
					}
				}

				 nr = new NRule(name, largs, lrets); 
				setState(57);
				match(T__2);
				setState(58);
				((OneRuleContext)_localctx).rulePart = rulePart();
				 nr.addRule(((OneRuleContext)_localctx).rulePart.v); 
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(60);
					match(T__11);
					setState(61);
					((OneRuleContext)_localctx).rulePart = rulePart();
					 nr.addRule(((OneRuleContext)_localctx).rulePart.v); 
					}
					}
					setState(68);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				 _localctx.g.addNTermRule(nr); 
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

	public static class ArgsContext extends ParserRuleContext {
		public List<Argument> v;
		public ArgContext arg;
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GrammarParser.COMMA, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			((ArgsContext)_localctx).arg = arg();
			 ((ArgsContext)_localctx).v =  new ArrayList(); 
			 _localctx.v.add(((ArgsContext)_localctx).arg.v); 
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(76);
				match(COMMA);
				setState(77);
				((ArgsContext)_localctx).arg = arg();
				 _localctx.v.add(((ArgsContext)_localctx).arg.v); 
				}
				}
				setState(84);
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

	public static class ArgContext extends ParserRuleContext {
		public Argument v;
		public Token NTERM;
		public TypeContext type;
		public TerminalNode NTERM() { return getToken(GrammarParser.NTERM, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArg(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_arg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			((ArgContext)_localctx).NTERM = match(NTERM);
			setState(86);
			match(T__2);
			setState(87);
			((ArgContext)_localctx).type = type();
			 ((ArgContext)_localctx).v =  new Argument(((ArgContext)_localctx).type.v, (((ArgContext)_localctx).NTERM!=null?((ArgContext)_localctx).NTERM.getText():null)); 
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

	public static class RulePartContext extends ParserRuleContext {
		public List<Terms> v;
		public TermsContext terms;
		public List<TermsContext> terms() {
			return getRuleContexts(TermsContext.class);
		}
		public TermsContext terms(int i) {
			return getRuleContext(TermsContext.class,i);
		}
		public RulePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulePart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterRulePart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitRulePart(this);
		}
	}

	public final RulePartContext rulePart() throws RecognitionException {
		RulePartContext _localctx = new RulePartContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rulePart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((RulePartContext)_localctx).v =  new ArrayList<>(); 
			setState(94); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(91);
				((RulePartContext)_localctx).terms = terms();
				 _localctx.v.add(((RulePartContext)_localctx).terms.v); 
				}
				}
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TERM) | (1L << NTERM) | (1L << Code))) != 0) );
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

	public static class TermsContext extends ParserRuleContext {
		public Terms v;
		public Token TERM;
		public Token NTERM;
		public ParamContext param;
		public Token Code;
		public TerminalNode TERM() { return getToken(GrammarParser.TERM, 0); }
		public TerminalNode NTERM() { return getToken(GrammarParser.NTERM, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GrammarParser.COMMA, i);
		}
		public TerminalNode Code() { return getToken(GrammarParser.Code, 0); }
		public TermsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTerms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTerms(this);
		}
	}

	public final TermsContext terms() throws RecognitionException {
		TermsContext _localctx = new TermsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_terms);
		int _la;
		try {
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TERM:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				((TermsContext)_localctx).TERM = match(TERM);
				 ((TermsContext)_localctx).v =  new Term((((TermsContext)_localctx).TERM!=null?((TermsContext)_localctx).TERM.getText():null)); 
				}
				break;
			case NTERM:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				((TermsContext)_localctx).NTERM = match(NTERM);
				 NTerm t = new NTerm((((TermsContext)_localctx).NTERM!=null?((TermsContext)_localctx).NTERM.getText():null)); 
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(102);
					match(T__6);
					setState(103);
					((TermsContext)_localctx).param = param();
					 t.addParameter(((TermsContext)_localctx).param.v); 
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(105);
						match(COMMA);
						setState(106);
						((TermsContext)_localctx).param = param();
						 t.addParameter(((TermsContext)_localctx).param.v); 
						}
						}
						setState(113);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(114);
					match(T__7);
					}
				}

				 ((TermsContext)_localctx).v =  t; 
				}
				break;
			case Code:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				((TermsContext)_localctx).Code = match(Code);
				 ((TermsContext)_localctx).v =  new Code((((TermsContext)_localctx).Code!=null?((TermsContext)_localctx).Code.getText():null)); 
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

	public static class ParamContext extends ParserRuleContext {
		public String v;
		public TypeContext type;
		public Token Code;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Code() { return getToken(GrammarParser.Code, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_param);
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TERM:
			case NTERM:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				((ParamContext)_localctx).type = type();
				 ((ParamContext)_localctx).v =  ((ParamContext)_localctx).type.v; 
				}
				break;
			case Code:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				((ParamContext)_localctx).Code = match(Code);
				 ((ParamContext)_localctx).v =  (((ParamContext)_localctx).Code!=null?((ParamContext)_localctx).Code.getText():null).substring(1, (((ParamContext)_localctx).Code!=null?((ParamContext)_localctx).Code.getText():null).length() - 1); 
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

	public static class TypeContext extends ParserRuleContext {
		public String v;
		public Token NTERM;
		public Token TERM;
		public TerminalNode NTERM() { return getToken(GrammarParser.NTERM, 0); }
		public TerminalNode TERM() { return getToken(GrammarParser.TERM, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NTERM:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				((TypeContext)_localctx).NTERM = match(NTERM);
				 ((TypeContext)_localctx).v =  (((TypeContext)_localctx).NTERM!=null?((TypeContext)_localctx).NTERM.getText():null); 
				}
				break;
			case TERM:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				((TypeContext)_localctx).TERM = match(TERM);
				 ((TypeContext)_localctx).v =  (((TypeContext)_localctx).TERM!=null?((TypeContext)_localctx).TERM.getText():null); 
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24\u008b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\6\2\32\n\2\r\2\16\2\33\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\61\n\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\5\39\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3C\n\3\f\3\16\3"+
		"F\13\3\3\3\3\3\5\3J\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4S\n\4\f\4\16\4"+
		"V\13\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\6\6a\n\6\r\6\16\6b\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7p\n\7\f\7\16\7s\13\7\3\7\3\7\5"+
		"\7w\n\7\3\7\3\7\3\7\5\7|\n\7\3\b\3\b\3\b\3\b\3\b\5\b\u0083\n\b\3\t\3\t"+
		"\3\t\3\t\5\t\u0089\n\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\2\2\u0091\2\22\3"+
		"\2\2\2\4I\3\2\2\2\6K\3\2\2\2\bW\3\2\2\2\n\\\3\2\2\2\f{\3\2\2\2\16\u0082"+
		"\3\2\2\2\20\u0088\3\2\2\2\22\23\7\3\2\2\23\24\7\17\2\2\24\25\7\20\2\2"+
		"\25\31\b\2\1\2\26\27\5\4\3\2\27\30\7\4\2\2\30\32\3\2\2\2\31\26\3\2\2\2"+
		"\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\3\3\2\2\2\35\36\7\17\2\2"+
		"\36\37\7\5\2\2\37 \7\21\2\2 J\b\3\1\2!\"\7\17\2\2\"#\7\6\2\2#$\7\21\2"+
		"\2$J\b\3\1\2%&\7\7\2\2&\'\7\b\2\2\'(\7\21\2\2(J\b\3\1\2)*\7\20\2\2*\60"+
		"\b\3\1\2+,\7\t\2\2,-\5\6\4\2-.\b\3\1\2./\7\n\2\2/\61\3\2\2\2\60+\3\2\2"+
		"\2\60\61\3\2\2\2\618\3\2\2\2\62\63\7\13\2\2\63\64\7\f\2\2\64\65\5\6\4"+
		"\2\65\66\b\3\1\2\66\67\7\r\2\2\679\3\2\2\28\62\3\2\2\289\3\2\2\29:\3\2"+
		"\2\2:;\b\3\1\2;<\7\5\2\2<=\5\n\6\2=D\b\3\1\2>?\7\16\2\2?@\5\n\6\2@A\b"+
		"\3\1\2AC\3\2\2\2B>\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2FD\3"+
		"\2\2\2GH\b\3\1\2HJ\3\2\2\2I\35\3\2\2\2I!\3\2\2\2I%\3\2\2\2I)\3\2\2\2J"+
		"\5\3\2\2\2KL\5\b\5\2LM\b\4\1\2MT\b\4\1\2NO\7\24\2\2OP\5\b\5\2PQ\b\4\1"+
		"\2QS\3\2\2\2RN\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2U\7\3\2\2\2VT\3\2"+
		"\2\2WX\7\20\2\2XY\7\5\2\2YZ\5\20\t\2Z[\b\5\1\2[\t\3\2\2\2\\`\b\6\1\2]"+
		"^\5\f\7\2^_\b\6\1\2_a\3\2\2\2`]\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2"+
		"c\13\3\2\2\2de\7\17\2\2e|\b\7\1\2fg\7\20\2\2gv\b\7\1\2hi\7\t\2\2ij\5\16"+
		"\b\2jq\b\7\1\2kl\7\24\2\2lm\5\16\b\2mn\b\7\1\2np\3\2\2\2ok\3\2\2\2ps\3"+
		"\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\7\n\2\2uw\3\2\2\2vh\3"+
		"\2\2\2vw\3\2\2\2wx\3\2\2\2x|\b\7\1\2yz\7\22\2\2z|\b\7\1\2{d\3\2\2\2{f"+
		"\3\2\2\2{y\3\2\2\2|\r\3\2\2\2}~\5\20\t\2~\177\b\b\1\2\177\u0083\3\2\2"+
		"\2\u0080\u0081\7\22\2\2\u0081\u0083\b\b\1\2\u0082}\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0083\17\3\2\2\2\u0084\u0085\7\20\2\2\u0085\u0089\b\t\1\2\u0086"+
		"\u0087\7\17\2\2\u0087\u0089\b\t\1\2\u0088\u0084\3\2\2\2\u0088\u0086\3"+
		"\2\2\2\u0089\21\3\2\2\2\16\33\608DITbqv{\u0082\u0088";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}