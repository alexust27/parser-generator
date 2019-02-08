package main.java.writer;

import main.java.grammar.*;

public class LexerWriter extends GrammarWriter {

    private String tokenName;
    private String lexerName;

    public LexerWriter(String dir, String name, MainGrammar grammar) {
        super(dir, "Lexer.java", grammar);
        this.tokenName = grammar.getName() + "Token";
        this.lexerName = grammar.getName() + "Lexer";
    }

    void printImports() {
        printLines("import java.text.ParseException;",
                "import java.util.*;",
                "import java.util.regex.*;", LS
        );
    }

    void printClass() {
        print("public class ", lexerName, " {", LS, LS);
        printFields();
        printMethods();
        print("}", LS);
    }

    private void printFields() {
        printLines(TAB + "private String input;", TAB + "private int curPos;");
        writeWithTabs(1, "private ", tokenName, " curToken;");
        writeWithTabs(1, "private Map<", tokenName, ", Pattern> regex;");
        if (grammar.skip != null)
            writeWithTabs(1, "private Pattern patternWS;");
        writeWithTabs(1, "private Matcher m;", LS);
        //constructor:
        writeWithTabs(1, "public ", lexerName, "(String input) {");
        printLines(tabs(2) + "this.input = input;", tabs(2) + "curPos = 0;",
                tabs(2) + "setRegex();"
        );

        if (grammar.skip != null)
            writeWithTabs(2, "patternWS = Pattern.compile(", grammar.skip, ");");
        writeWithTabs(2, "m = Pattern.compile(\"\").matcher(input);");
        print(TAB, "}", LS, LS);
    }

    private void printMethods() {
        printMethodSetRegex();
        if (grammar.skip != null)
            printMethodSkipWhiteSpaces();
        printMethodFindNextToken();
        printMethodNextToken();
        printMethodGetLexeme();
        printMethodGetCurPos();
        printMethodGetCurToken();
    }

    private void printMethodSetRegex() {
        writeWithTabs(1, "private void setRegex() {");
        writeWithTabs(2, "regex = new HashMap<>();");
        for (TRule rule : grammar.tRules) {
            StringBuilder res = new StringBuilder();
            res.append("regex.put(")
                    .append(tokenName).append('.').append(rule.name)
                    .append(", Pattern.compile(");

            if (rule.isRegex)
                res.append(rule.value);
            else {
                String value = rule.value;
                res.append('\"');
                for (int i = 1; i < value.length() - 1; i++)
                    if (value.charAt(i) == '^')
                        res.append("\\\\").append(value.charAt(i));
                    else
                        res.append('[').append(value.charAt(i)).append(']');
                res.append('\"');
            }
            res.append("));");
            writeWithTabs(2, res.toString());
        }
        writeWithTabs(2, "regex.put(", tokenName, ".END, Pattern.compile(\"$\"));");
        writeWithTabs(1, "}", LS);
    }

    private void printMethodSkipWhiteSpaces() {
        print("    private void skipWhiteSpaces() {", LS,
                "        m.usePattern(patternWS);", LS,
                "        m.region(curPos, input.length());", LS,
                "        if (m.lookingAt()) {", LS,
                "            curPos += m.end() - m.start();", LS,
                "        }", LS,
                "    }"
        );
    }

    private void printMethodFindNextToken() {
        print("    private boolean findNextToken() {", LS,
                "        for (", tokenName, " t : ", tokenName, ".values()) {", LS,
                "            m.usePattern(regex.get(t));", LS,
                "            m.region(curPos, input.length());", LS,
                "            if (m.lookingAt()) {", LS,
                "                curToken = t;", LS,
                "                curPos += m.end() - m.start();", LS,
                "                return true;", LS,
                "            }", LS,
                "        }", LS,
                "        return false;", LS,
                "    }"
        );
    }

    private void printMethodNextToken() {
        print("    public void nextToken() throws ParseException {", LS,
                "        if (curPos == input.length()) {", LS,
                "            curToken = ", tokenName, ".END;", LS,
                "            return;", LS,
                "        }", LS
        );
        if (grammar.skip != null)
            writeWithTabs(2, "skipWhiteSpaces();");
        writeWithTabs(2, "if (curPos == input.length()) {");
        writeWithTabs(3, "curToken = ", tokenName, ".END;");
        writeWithTabs(3, "return;");
        writeWithTabs(2, "}");
        writeWithTabs(2, "if (!findNextToken()) {");
        writeWithTabs(3, "throw new ParseException(\"Illegal character at\", curPos);");
        writeWithTabs(2, "}");
        writeWithTabs(1, "}", LS);
    }

    private void printMethodGetLexeme() {
        writeWithTabs(1, "public String getLexeme() {");
        writeWithTabs(2, "return m.group();");
        writeWithTabs(1, "}", LS);
    }

    private void printMethodGetCurPos() {
        writeWithTabs(1, "public int getCurPos() {");
        writeWithTabs(2, "return curPos;");
        writeWithTabs(1, "}", LS);
    }

    private void printMethodGetCurToken() {
        writeWithTabs(1, "public ", tokenName, " getCurToken() {");
        printLines(tabs(2) + "return curToken;", TAB + "}", "");
    }
}
