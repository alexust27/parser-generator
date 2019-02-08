package main.java.writer;

import main.java.grammar.MainGrammar;
import main.java.grammar.TRule;

import java.util.List;

public class TokenWriter extends GrammarWriter {

    private String name;

    public TokenWriter(String dir, String name, MainGrammar grammar) {
        super(dir,  "Token.java", grammar);
        this.name = grammar.getName() + "Token";
    }

    void printImports() {
        print(LS);
    }

    void printClass() {
        print("public enum ", name, " {", LS, TAB);
        List<TRule> tRules = grammar.tRules;
        for (TRule rule : tRules) {
            print(rule.name, ", ");
        }
        print("END", LS, "}");
    }
}
