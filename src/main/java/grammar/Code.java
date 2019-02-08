package main.java.grammar;

public class Code implements Terms {

    public String code;

    public Code(String code) {
        this.code = code.substring(1, code.length() - 1);
    }
}
