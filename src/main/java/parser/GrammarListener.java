// Generated from /home/alex/IdeaProjects/MT4/src/main/antlr/Grammar.g4 by ANTLR 4.7.2
package main.java.parser;

    import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(GrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(GrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#oneRule}.
	 * @param ctx the parse tree
	 */
	void enterOneRule(GrammarParser.OneRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#oneRule}.
	 * @param ctx the parse tree
	 */
	void exitOneRule(GrammarParser.OneRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(GrammarParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(GrammarParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(GrammarParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(GrammarParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#rulePart}.
	 * @param ctx the parse tree
	 */
	void enterRulePart(GrammarParser.RulePartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#rulePart}.
	 * @param ctx the parse tree
	 */
	void exitRulePart(GrammarParser.RulePartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#terms}.
	 * @param ctx the parse tree
	 */
	void enterTerms(GrammarParser.TermsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#terms}.
	 * @param ctx the parse tree
	 */
	void exitTerms(GrammarParser.TermsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(GrammarParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(GrammarParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GrammarParser.TypeContext ctx);
}