package main.java.results.logic;
import java.text.ParseException;
import java.util.*;
import java.util.regex.*;


public class LogicLexer {

    private String input;
    private int curPos;
    private LogicToken curToken;
    private Map<LogicToken, Pattern> regex;
    private Pattern patternWS;
    private Matcher m;

    public LogicLexer(String input) {
        this.input = input;
        curPos = 0;
        setRegex();
        patternWS = Pattern.compile("[ \n\t\r]+");
        m = Pattern.compile("").matcher(input);
    }

    private void setRegex() {
        regex = new HashMap<>();
        regex.put(LogicToken.AND, Pattern.compile("[&]"));
        regex.put(LogicToken.OR, Pattern.compile("[|]"));
        regex.put(LogicToken.OP, Pattern.compile("[(]"));
        regex.put(LogicToken.CP, Pattern.compile("[)]"));
        regex.put(LogicToken.XOR, Pattern.compile("\\^"));
        regex.put(LogicToken.NOT, Pattern.compile("[!]"));
        regex.put(LogicToken.VAR, Pattern.compile("[a-z]+"));
        regex.put(LogicToken.END, Pattern.compile("$"));
    }

    private void skipWhiteSpaces() {
        m.usePattern(patternWS);
        m.region(curPos, input.length());
        if (m.lookingAt()) {
            curPos += m.end() - m.start();
        }
    }

    private boolean findNextToken() {
        for (LogicToken t : LogicToken.values()) {
            m.usePattern(regex.get(t));
            m.region(curPos, input.length());
            if (m.lookingAt()) {
                curToken = t;
                curPos += m.end() - m.start();
                return true;
            }
        }
        return false;
    }

    public void nextToken() throws ParseException {
        if (curPos == input.length()) {
            curToken = LogicToken.END;
            return;
        }
        skipWhiteSpaces();
        if (curPos == input.length()) {
            curToken = LogicToken.END;
            return;
        }
        if (!findNextToken()) {
            throw new ParseException("Illegal character at", curPos);
        }
    }

    public String getLexeme() {
        return m.group();
    }

    public int getCurPos() {
        return curPos;
    }

    public LogicToken getCurToken() {
        return curToken;
    }

}
