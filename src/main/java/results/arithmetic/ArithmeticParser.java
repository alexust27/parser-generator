package main.java.results.arithmetic;
import java.text.ParseException;

public class ArithmeticParser {
    private ArithmeticLexer lex;

    public class addSub {
        public int v;
    }

    public class addSub2 {
        public int v;
    }

    public class mulDiv {
        public int v;
    }

    public class mulDiv2 {
        public int v;
    }

    public class pow {
        public int v;
    }

    public class pow2 {
        public int v;
    }

    public class unary {
        public int v;
    }

    public addSub parse(String expr) throws ParseException {
        lex = new ArithmeticLexer(expr);
        lex.nextToken();
        addSub p = addSub();
        if (lex.getCurToken() != ArithmeticToken.END) {
            throw new AssertionError(lex.getCurToken());
        }
        return p;
    }

    private addSub addSub() throws ParseException {
        addSub ret = new addSub();
        switch (lex.getCurToken()) {
            case OP:
            case NUM:
            {
                mulDiv mulDiv = mulDiv();
                addSub2 addSub2 = addSub2(mulDiv.v);
                ret.v = addSub2.v;
                return ret;
            }
            default:
                throw new AssertionError();
        }
    }

    private addSub2 addSub2(int left) throws ParseException {
        addSub2 ret = new addSub2();
        switch (lex.getCurToken()) {
            case ADD:
            {
                String ADD = tokenToString(ArithmeticToken.ADD);
                mulDiv mulDiv = mulDiv();
                int next = left + mulDiv.v;
                addSub2 addSub2 = addSub2(next);
                ret.v = addSub2.v;
                return ret;
            }
            case SUB:
            {
                String SUB = tokenToString(ArithmeticToken.SUB);
                mulDiv mulDiv = mulDiv();
                int next = left - mulDiv.v;
                addSub2 addSub2 = addSub2(next);
                ret.v = addSub2.v;
                return ret;
            }
            case END:
            case CP:
                ret.v = left;
                return ret;
            default:
                throw new AssertionError();
        }
    }

    private mulDiv mulDiv() throws ParseException {
        mulDiv ret = new mulDiv();
        switch (lex.getCurToken()) {
            case OP:
            case NUM:
            {
                pow pow = pow();
                mulDiv2 mulDiv2 = mulDiv2(pow.v);
                ret.v = mulDiv2.v;
                return ret;
            }
            default:
                throw new AssertionError();
        }
    }

    private mulDiv2 mulDiv2(int left) throws ParseException {
        mulDiv2 ret = new mulDiv2();
        switch (lex.getCurToken()) {
            case MUL:
            {
                String MUL = tokenToString(ArithmeticToken.MUL);
                pow pow = pow();
                mulDiv2 mulDiv2 = mulDiv2(left * pow.v);
                ret.v = mulDiv2.v;
                return ret;
            }
            case DIV:
            {
                String DIV = tokenToString(ArithmeticToken.DIV);
                pow pow = pow();
                mulDiv2 mulDiv2 = mulDiv2(left / pow.v);
                ret.v = mulDiv2.v;
                return ret;
            }
            case ADD:
            case SUB:
            case END:
            case CP:
                ret.v = left;
                return ret;
            default:
                throw new AssertionError();
        }
    }

    private pow pow() throws ParseException {
        pow ret = new pow();
        switch (lex.getCurToken()) {
            case OP:
            case NUM:
            {
                unary unary = unary();
                pow2 pow2 = pow2(unary.v);
                ret.v = pow2.v;
                return ret;
            }
            default:
                throw new AssertionError();
        }
    }

    private pow2 pow2(int left) throws ParseException {
        pow2 ret = new pow2();
        switch (lex.getCurToken()) {
            case POW:
            {
                String POW = tokenToString(ArithmeticToken.POW);
                pow pow = pow();
                ret.v = (int) Math.pow(left, pow.v);
                return ret;
            }
            case DIV:
            case ADD:
            case SUB:
            case MUL:
            case END:
            case CP:
                ret.v = left;
                return ret;
            default:
                throw new AssertionError();
        }
    }

    private unary unary() throws ParseException {
        unary ret = new unary();
        switch (lex.getCurToken()) {
            case OP:
            {
                String OP = tokenToString(ArithmeticToken.OP);
                addSub addSub = addSub();
                String CP = tokenToString(ArithmeticToken.CP);
                ret.v = addSub.v;
                return ret;
            }
            case NUM:
            {
                String NUM = tokenToString(ArithmeticToken.NUM);
                ret.v = Integer.valueOf(NUM);
                return ret;
            }
            default:
                throw new AssertionError();
        }
    }

    private String tokenToString(ArithmeticToken token) throws ParseException {
        if (lex.getCurToken() != token) {
            throw new ParseException("Incorrect token at position: ", lex.getCurPos());
        }
        String lexeme = lex.getLexeme();
        lex.nextToken();
        return lexeme;
    }

}
