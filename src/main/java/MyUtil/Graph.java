package main.java.MyUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {
    HashMap<String, HashSet<String> > graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public Graph(Graph g) {
        graph = new HashMap<>();
        for(String reg : g.getAllReg())
            graph.put(reg, new HashSet<>(g.getAdj(reg)));
    }

    public void addReg(LinkedList<String> regList) {
        for(String reg : regList) {
            if(!graph.containsKey(reg)) {
                graph.put(reg, new HashSet<>());
            }
        }
    }

    public void delReg(String reg) {
        for(String tmp : getAdj(reg)) {
            graph.get(tmp).remove(reg);
        }
        graph.remove(reg);
    }

    public void addEdge(String a, String b) {
        if(a.equals(b))return;
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    public void clear() {
        graph.clear();
    }

    public HashSet<String> getAllReg() {
        return new HashSet<>(graph.keySet());
    }

    public HashSet<String> getAdj(String a) {
        return graph.get(a);
    }

    public int getDegree(String a) {
        return graph.get(a) != null ? graph.get(a).size() : 0;
    }
}
