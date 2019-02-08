package main.java.grammar;

import java.util.ArrayList;
import java.util.List;

public class NTerm implements Terms {

    private String name;
    private List<String> parameters;

    public NTerm(String name) {
        this.name = name;
        parameters = new ArrayList<>();
    }

    public void addParameter(String parameter) {
        parameters.add(parameter);
    }

    public String getName() {
        return name;
    }

    public List<String> getParameters() {
        return parameters;
    }
}
