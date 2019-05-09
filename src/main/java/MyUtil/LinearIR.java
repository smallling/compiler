package main.java.MyUtil;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class LinearIR {
    public ArrayList<FuncFrame> funcs;
    public FuncFrame init;
    public ArrayList<String> globals;

    public HashMap<String, Long> varSize;

    ArrayList<Pair<String, String> > roData;

    public LinearIR() {
        funcs = new ArrayList<>();
        init = null;
        globals = new ArrayList<>();
        varSize = new HashMap<>();
        roData = new ArrayList<>();
    }

    public void rebuild() {
        if(init != null) {
            init.rebuild();
        }
        for(int i = 0; i < funcs.size(); i++) {
            funcs.get(i).rebuild();
        }
    }

    public void print() {
        for(int i = 0; i < funcs.size(); i++)
            funcs.get(i).print();
    }

    public void insertFunc(FuncFrame func) {
        funcs.add(func);
        globals.add(func.getName());
        varSize.put(func.getName(), func.getRetSize());
    }

    public void setInit(FuncFrame tmp) {
        init = tmp;
    }

    public void insertVar(String name, Long size) {
        globals.add(name);
        varSize.put(name, size);
    }

    public String insertStringConst(String str) {
        String name = str + roData.size();
        addRoData(name, str);
        return name;
    }

    void addRoData(String name, String str) {

    }
}
