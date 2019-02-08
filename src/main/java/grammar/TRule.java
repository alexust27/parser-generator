package main.java.grammar;

public class TRule {

    public String name;
    public String value;
    public boolean isRegex;

    public TRule(boolean isRegex, String name, String value) {
        this.name = name;
        this.value = value;
        this.isRegex = isRegex;
    }
}
