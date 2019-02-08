package main.java.writer;

import main.java.grammar.MainGrammar;

import java.io.*;

public abstract class GrammarWriter {
    private String packageName;
    MainGrammar grammar;
    PrintWriter out;
    final static String LS = System.lineSeparator();
    final static String TAB = "    ";

    GrammarWriter(String dir, String suffix, MainGrammar grammar) {
        try {
            out = new PrintWriter(new File(dir, grammar.getName() + suffix));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(dir);
        this.packageName = "main.java.results." + grammar.getName().toLowerCase();
        this.grammar = grammar;
    }

    public void printToFile() {
        print("package ", packageName, ";", LS);
        printImports();
        printClass();
        out.close();
    }

    abstract void printImports();

    abstract void printClass();

    String tabs(int count) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < count; i++) {
            res.append(TAB);
        }
        return res.toString();
    }

    void writeWithTabs(int tabs, String... strs) {
        out.write(tabs(tabs));
        for (String str : strs) {
            out.write(str);
        }
        out.write(LS);
    }

    void printLines(String... strings) {
        StringBuilder res = new StringBuilder();
        for (String str : strings) {
            res.append(str);
            res.append(LS);
        }
        out.write(res.toString());
    }

    void print(String... strings) {
        for (String str : strings) {
            out.write(str);
        }
    }
}
