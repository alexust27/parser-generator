package main.java.results.logic;
import java.text.ParseException;

public class LogicParser {
    private LogicLexer lex;

    public class expr {
        public String v;
    }

    public class e2 {
        public String v;
    }

    public class x {
        public String v;
    }

    public class x2 {
        public String v;
    }

    public class c {
        public String v;
    }

    public class c2 {
        public String v;
    }

    public class vv {
        public String v;
    }

    public expr parse(String expr) throws ParseException {
        lex = new LogicLexer(expr);
        lex.nextToken();
        expr p = expr();
        if (lex.getCurToken() != LogicToken.END) {
            throw new AssertionError(lex.getCurToken());
        }
        return p;
    }

    private expr expr() throws ParseException {
        expr ret = new expr();
        switch (lex.getCurToken()) {
            case OP:
            case NOT:
            case VAR:
            {
                x x = x();
                e2 e2 = e2();
                ret.v = x.v + e2.v;
                return ret;
            }
            default:
                throw new AssertionError();
        }
    }

    private e2 e2() throws ParseException {
        e2 ret = new e2();
        switch (lex.getCurToken()) {
            case OR:
            {
                String OR = consume(LogicToken.OR);
                x x = x();
                e2 e2 = e2();
                 ret.v = "|" + x.v + e2.v; 
                return ret;
            }
            case END:
            case CP:
                 ret.v = ""; 
                return ret;
            default:
                throw new AssertionError();
        }
    }

    private x x() throws ParseException {
        x ret = new x();
        switch (lex.getCurToken()) {
            case OP:
            case NOT:
            case VAR:
            {
                c c = c();
                x2 x2 = x2();
                ret.v = c.v + x2.v; 
                return ret;
            }
            default:
                throw new AssertionError();
        }
    }

    private x2 x2() throws ParseException {
        x2 ret = new x2();
        switch (lex.getCurToken()) {
            case XOR:
            {
                String XOR = consume(LogicToken.XOR);
                c c = c();
                x2 x2 = x2();
                 ret.v = "^" + c.v + x2.v; 
                return ret;
            }
            case OR:
            case END:
            case CP:
                 ret.v = ""; 
                return ret;
            default:
                throw new AssertionError();
        }
    }

    private c c() throws ParseException {
        c ret = new c();
        switch (lex.getCurToken()) {
            case OP:
            case NOT:
            case VAR:
            {
                vv vv = vv();
                c2 c2 = c2();
                ret.v = vv.v + c2.v; 
                return ret;
            }
            default:
                throw new AssertionError();
        }
    }

    private c2 c2() throws ParseException {
        c2 ret = new c2();
        switch (lex.getCurToken()) {
            case AND:
            {
                String AND = consume(LogicToken.AND);
                vv vv = vv();
                c2 c2 = c2();
                 ret.v = "&" + vv.v + c2.v; 
                return ret;
            }
            case OR:
            case XOR:
            case END:
            case CP:
                 ret.v = ""; 
                return ret;
            default:
                throw new AssertionError();
        }
    }

    private vv vv() throws ParseException {
        vv ret = new vv();
        switch (lex.getCurToken()) {
            case NOT:
            {
                String NOT = consume(LogicToken.NOT);
                vv vv = vv();
                 ret.v = NOT + vv.v; 
                return ret;
            }
            case VAR:
            {
                String VAR = consume(LogicToken.VAR);
                 ret.v = VAR; 
                return ret;
            }
            case OP:
            {
                String OP = consume(LogicToken.OP);
                expr expr = expr();
                String CP = consume(LogicToken.CP);
                 ret.v = OP + expr.v + CP;
                return ret;
            }
            default:
                throw new AssertionError();
        }
    }

    private String consume(LogicToken token) throws ParseException {
        if (lex.getCurToken() != token) {
            throw new ParseException("Incorrect token at position: ", lex.getCurPos());
        }
        String lexeme = lex.getLexeme();
        lex.nextToken();
        return lexeme;
    }

}
