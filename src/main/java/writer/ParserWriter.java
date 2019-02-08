package main.java.writer;

import main.java.grammar.*;

import java.util.*;

public class ParserWriter extends GrammarWriter {

    private String name;

    public ParserWriter(String dir, String fileName, MainGrammar grammar) {
        super(dir, "Parser.java", grammar);
        name = grammar.getName();
    }

    void printImports() {
        print("import java.text.ParseException;", LS, LS);
    }

    void printClass() {
        print("public class ", name, "Parser", " {", LS);
        writeWithTabs(1, "private ", name, "Lexer", " lex;", LS);
        writeRetClasses();
        writeParse();
        writeNTMethods();
        writeTokenToString();
        print("}", LS);
    }


    private void writeRetClasses() {
        for (NRule rule : grammar.nRules) {
            if (rule.returnList == null) continue;
            writeWithTabs(1, "public class ", rule.getRetType(), " {");
            for (Argument ret : rule.returnList) {
                writeWithTabs(2, "public ", ret.type, " ", ret.name, ";");
            }
            writeWithTabs(1, "}");
            print(LS);
        }
    }

    private void writeParse() {
        String type = grammar.typeOfNT.get(grammar.start);
        writeWithTabs(1, "public ", type, " parse(String expr) throws ParseException {");
        writeWithTabs(2, "lex = new ", name, "Lexer(expr);");
        writeWithTabs(2, "lex.nextToken();");
        writeWithTabs(2, (!type.equals("void") ? type + " p = " : ""), grammar.start, "();");
        writeWithTabs(2, "if (lex.getCurToken() != ", name, "Token.END) {");
        writeWithTabs(3, "throw new AssertionError(lex.getCurToken());");
        writeWithTabs(2, "}");

        if (!type.equals("void"))
            writeWithTabs(2, "return p;");
        writeWithTabs(1, "}");
        print(LS);
    }

    private void writeNTMethods() {
        List<NRule> rules = grammar.nRules;
        for (NRule rule : rules) {
            NTMethod1(rule);
            if (firstNTMethod(rule))
                followNTMethod(rule);
            endNTermMethod();
        }
    }

    private void NTMethod1(NRule rule) {
        StringBuilder res = new StringBuilder();
        res.append(TAB).append("private ")
                .append(rule.getRetType())
                .append(' ')
                .append(rule.name)
                .append('(');

        List<Argument> arguments = rule.args;
        if (arguments != null) {
            for (int i = 0; i < arguments.size(); i++) {
                res.append(arguments.get(i).type)
                        .append(' ')
                        .append(arguments.get(i).name);
                if (i != arguments.size() - 1)
                    res.append(", ");
            }
        }

        res.append(") throws ParseException {").append(LS);
        print(res.toString());
        if (!rule.getRetType().equals("void"))
            writeWithTabs(2, rule.getRetType(), " ret = new ", rule.getRetType(), "();");
        writeWithTabs(2, "switch (lex.getCurToken()) {");
    }

    private boolean firstNTMethod(NRule rule) {
        boolean isHaveEps = false;
        met:
        for (List<Terms> termList : rule.rules) {
            for (String s : grammar.getFirstTermsList(termList)) {
                if (s.equals("EPS")) {
                    isHaveEps = true;
                    continue met;
                } else {
                    writeWithTabs(3, "case ", s, ":");
                }
            }
            caseBody(rule, termList);
        }
        return isHaveEps;
    }

    private String substitute(String code) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            res.append(code.charAt(i) == '$' ? "ret." : code.charAt(i));
        }
        return res.toString();
    }

    private void caseBody(NRule rule, List<Terms> termList) {
        Set<String> isHaveVar = new HashSet<>();
        writeWithTabs(3, "{");
        for (Terms term : termList) {
            if (term instanceof Code) {
                writeWithTabs(4, substitute(((Code) term).code));
            } else if (term instanceof Term) {
                String name = ((Term) term).name;
                StringBuilder res = new StringBuilder();

                if (!isHaveVar.contains(name)) {
                    isHaveVar.add(name);
                    res.append("String ");
                }
                res.append(name).append(" = tokenToString(")
                        .append(this.name)
                        .append("Token")
                        .append('.')
                        .append(name)
                        .append(");");

                writeWithTabs(4, res.toString());
            } else {
                String name = ((NTerm) term).getName();
                StringBuilder res = new StringBuilder();
                String type = grammar.typeOfNT.get(name);
                if (!type.equals("void")) {
                    if (!isHaveVar.contains(name)) {
                        isHaveVar.add(name);
                        res.append(type)
                                .append(' ');
                    }
                    res.append(name)
                            .append(" = ");
                }

                res.append(name)
                        .append('(');
                List<String> parameters = ((NTerm) term).getParameters();
                for (int i = 0; i < parameters.size(); i++) {
                    res.append(parameters.get(i));
                    if (i != parameters.size() - 1)
                        res.append(", ");

                }

                res.append(");");
                writeWithTabs(4, res.toString());
            }
        }
        writeWithTabs(4, "return", (!rule.getRetType().equals("void") ? " ret" : ""), ";");
        writeWithTabs(3, "}");
    }

    private void followNTMethod(NRule rule) {
        if (grammar.getFollow(rule.name).isEmpty()) return;
        for (String s : grammar.getFollow(rule.name)) {
            writeWithTabs(3, "case ", s, ":");
        }
        for (List<Terms> termList : rule.rules) {
            boolean isHaveEps = false;
            for (String s : grammar.getFirstTermsList(termList)) {
                if (s.equals("EPS")) {
                    isHaveEps = true;
                    break;
                }
            }
            if (isHaveEps) {
                for (Terms term : termList) {
                    if (term instanceof Code) {
                        writeWithTabs(4, substitute(((Code) term).code));
                    }
                }
                writeWithTabs(4, "return", (!rule.getRetType().equals("void") ? " ret" : ""), ";");
            }
        }
    }

    private void endNTermMethod() {
        writeWithTabs(3, "default:");
        writeWithTabs(4, "throw new AssertionError();");
        writeWithTabs(2, "}");
        writeWithTabs(1, "}");
        print(LS);
    }

    private void writeTokenToString() {
        writeWithTabs(1, "private String tokenToString(", name, "Token token) throws ParseException {");
        writeWithTabs(2, "if (lex.getCurToken() != token) {");
        writeWithTabs(3, "throw new ParseException(\"Incorrect token at position: \", lex.getCurPos());");
        writeWithTabs(2, "}");
        writeWithTabs(2, "String lexeme = lex.getLexeme();");
        writeWithTabs(2, "lex.nextToken();");
        writeWithTabs(2, "return lexeme;");
        writeWithTabs(1, "}");
        print(LS);
    }
}
