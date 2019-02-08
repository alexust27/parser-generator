package tests;

import main.java.results.arithmetic.ArithmeticParser;
import main.java.results.logic.LogicParser;

import java.text.ParseException;

public class Test {

    public static void main(String[] args) {
        try {
//            test1();
            test2("2^2^3");
            test2("2^3^3");
            test2("1-2-3");
            test2("3^2+2");
            test2("2^3^2-10");
            test2("3*2^3-2^3");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void test1() throws ParseException {
        LogicParser parser = new LogicParser();
        LogicParser.expr res = parser.parse("a&b^!a|(x&(b|c)&e)");
        System.out.println(res.v);
    }

    private static void test2(String expr) throws ParseException {
        ArithmeticParser parser = new ArithmeticParser();
        ArithmeticParser.addSub res = parser.parse(expr);
        System.out.println(res.v);
    }
}