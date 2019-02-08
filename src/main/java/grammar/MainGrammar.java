package main.java.grammar;

import java.util.*;

public class MainGrammar {

    public String start;
    public List<NRule> nRules;
    public List<TRule> tRules;
    public String skip;
    public Map<String, String> typeOfNT;
    private Map<String, Integer> numOfNT;
    private List<HashSet<String>> first;
    private List<HashSet<String>> follow;
    private Map<List<Terms>, Integer> termsListToNum;
    private List<HashSet<String>> firstTermsList;
    private String name;

    public MainGrammar(String start, String name) {
        this.start = start;
        this.name = name;
        nRules = new ArrayList<>();
        tRules = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean makeAndCheck() {
        makeTypeOfNT();
        makeFirst();
        makeFollow();
        return (checkLeftRec() && checkRightBranch());
    }

    public void addTermRule(TRule rule) {
        tRules.add(rule);
    }

    public void addNTermRule(NRule rule) {
        nRules.add(rule);
    }

    public void addSkip(String skip) {
        this.skip = skip;
    }

    public HashSet<String> getFirstTermsList(List<Terms> termsList) {
        return firstTermsList.get(termsListToNum.get(termsList));
    }

    public HashSet<String> getFollow(String nTerm) {
        return follow.get(numOfNT.get(nTerm));
    }

    private boolean checkLeftRec() {
        for (NRule rule : nRules) {
            for (List<Terms> terms : rule.rules) {
                for (Terms term : terms) {
                    if (term instanceof Code) continue;
                    if (term instanceof Term) break;
                    if (rule.name.equals(((NTerm) term).getName())) {
                        return false;
                    } else {
                        break;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkRightBranch() {

        for (NRule rule : nRules) {
            for (int i = 0; i < rule.rules.size(); i++) {
                List<Terms> termsList1 = rule.rules.get(i);
                int list1Id = termsListToNum.get(termsList1);
                for (int j = i + 1; j < rule.rules.size(); j++) {
                    List<Terms> termsList2 = rule.rules.get(j);
                    int listId2 = termsListToNum.get(termsList2);
                    for (String terms : firstTermsList.get(list1Id)) {
                        if (firstTermsList.get(listId2).contains(terms))
                            return false;
                    }
                }
            }
        }
        return true;
    }

    private void makeTypeOfNT() {
        typeOfNT = new HashMap<>();
        for (NRule rule : nRules) {
            typeOfNT.put(rule.name, rule.getRetType());
        }
    }

    private int makeTermsListToNum() {
        termsListToNum = new HashMap<>();
        int sz = 0;
        for (NRule rule : nRules) {
            for (List<Terms> termsList : rule.rules) {
                termsListToNum.put(termsList, sz++);
            }
        }
        return sz;
    }

    private int makeNumOfNT() {
        numOfNT = new HashMap<>();
        int sz = 0;
        for (NRule rule : nRules) {
            numOfNT.put(rule.name, sz++);
        }
        return sz;
    }

    private void makeFirst() {
        int sz = makeNumOfNT();
        first = new ArrayList<>();
        for (int i = 0; i < sz; i++) {
            first.add(new HashSet<>());
        }

        sz = makeTermsListToNum();
        firstTermsList = new ArrayList<>();

        for (int i = 0; i < sz; i++) {
            firstTermsList.add(new HashSet<>());
        }

        boolean flag = true;

        while (flag) {
            flag = false;
            for (NRule NT : nRules) {
                int id = numOfNT.get(NT.name);
                for (List<Terms> termsList : NT.rules) {
                    int listId = termsListToNum.get(termsList);
                    boolean isEps = true;
                    for (Terms terms : termsList) {
                        if (terms instanceof Code)
                            continue;
                        if (terms instanceof Term) {
                            if (first.get(id).add(((Term) terms).name)) {
                                flag = true;
                            }
                            firstTermsList.get(listId).add(((Term) terms).name);
                        } else {
                            int sId = numOfNT.get(((NTerm) terms).getName());
                            if (first.get(id).addAll(first.get(sId))) {
                                flag = true;
                            }
                            firstTermsList.get(listId).addAll(first.get(sId));
                        }
                        isEps = false;
                        break;
                    }
                    if (isEps) {
                        if (first.get(id).add("EPS")) {
                            flag = true;
                            firstTermsList.get(listId).add("EPS");
                        }
                    }
                }
            }
        }
    }

    private void makeFollow() {
        int sz = first.size();
        follow = new ArrayList<>(sz);
        for (int i = 0; i < sz; i++) {
            follow.add(new HashSet<>());
        }
        boolean flag = true;
        follow.get(numOfNT.get(start)).add("END");

        while (flag) {
            flag = false;
            for (NRule rule : nRules) {
                int id = numOfNT.get(rule.name);
                for (List<Terms> termsList : rule.rules) {
                    for (int i = 0; i < termsList.size(); i++) {
                        Terms terms = termsList.get(i);
                        if (terms instanceof NTerm) {
                            int termsId = numOfNT.get(((NTerm) terms).getName());
                            if (addNextTerms(i + 1, termsList, termsId, id))
                                flag = true;
                        }
                    }
                }
            }
        }
    }

    private boolean addNextTerms(int id, List<Terms> termsList, int termsId, int startId) {
        boolean flag = false;
        boolean eps = false;
        for (int i = id; i < termsList.size(); i++) {
            Terms terms = termsList.get(i);
            if (terms instanceof Code)
                continue;
            if (terms instanceof Term) {
                String termsName = ((Term) terms).name;
                if (follow.get(termsId).add(termsName)) {
                    flag = true;
                }
                break;
            } else {
                int nextId = numOfNT.get(((NTerm) terms).getName());
                boolean next = false;
                for (String s : first.get(nextId)) {
                    if (s.equals("EPS")) {
                        next = true;
                        eps = true;
                    } else if (follow.get(termsId).add(s))
                        flag = true;
                }
                if (!next) break;
            }
        }
        if (eps || isLast(id, termsList))
            if (follow.get(termsId).addAll(follow.get(startId)))
                flag = true;
        return flag;
    }

    private boolean isLast(int id, List<Terms> termsList) {
        if (id == termsList.size()) return true;
        for (int i = id; i < termsList.size(); i++) {
            if (!(termsList.get(i) instanceof Code))
                return false;
        }
        return true;
    }
}
