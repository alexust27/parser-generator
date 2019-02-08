package main.java.grammar;

import java.util.ArrayList;
import java.util.List;

public class NRule {

    public String name;
    private String type;
    public List<Argument> args;
    public List<Argument> returnList;
    public List<List<Terms>> rules;

    public NRule(String name, List<Argument> args, List<Argument> returnList) {
        type = this.name = name;
//        this.type = Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
        this.args = args;
        this.returnList = returnList;
        rules = new ArrayList<>();
    }

    public void addRule(List<Terms> rule) {
        rules.add(rule);
    }

    public String getRetType() {
        if (returnList == null) return "void";
        return type;
    }
}
