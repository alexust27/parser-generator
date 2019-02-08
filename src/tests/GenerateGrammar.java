package tests;

import main.java.writer.LexerWriter;
import main.java.writer.ParserWriter;
import main.java.writer.TokenWriter;
import main.java.grammar.MainGrammar;
import main.java.parser.GrammarLexer;
import main.java.parser.GrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GenerateGrammar {
    public static void main(String[] args) throws IOException {
//        generate("test1");
        generate("test2");
    }

    private static void generate(String name) throws IOException {
        GrammarLexer lexer = new GrammarLexer(CharStreams.fromFileName("tests/" + name));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);
        MainGrammar grammar = parser.start().v;

        String file = grammar.getName().toLowerCase();
        if (!file.equals(name)) {
            System.out.println("Warning: Grammar name not equal file name");
        }

        Path path = Paths.get("src/main/java/results/", file);
        Path dir;
        if (Files.notExists(path)) {
            dir = Files.createDirectory(path);
        } else {
            dir = path;
        }
        String dirOut = dir.toString();

        boolean isLL1 = grammar.makeAndCheck();
        if (isLL1) {
            TokenWriter tokenWriter = new TokenWriter(dirOut, file, grammar);
            tokenWriter.printToFile();
            LexerWriter lexerGenerator = new LexerWriter(dirOut, file, grammar);
            lexerGenerator.printToFile();
            ParserWriter parserGenerator = new ParserWriter(dirOut, file, grammar);
            parserGenerator.printToFile();
            System.out.println("generated " + file);
        } else {
            System.out.println("Not LL(1) Grammar");
        }
    }
}