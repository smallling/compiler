package main.java.MyUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class LinearIR {
    public ArrayList<FuncFrame> funcs;
    public FuncFrame init;
    public ArrayList<String> globals;

    public HashMap<String, Long> varSize;

    public ArrayList<Pair<String, Pair<Integer, String> > > roData;
    public ArrayList<Pair<String, Long> > uninitMem;

    public LinearIR() {
        funcs = new ArrayList<>();
        init = null;
        globals = new ArrayList<>();
        varSize = new HashMap<>();
        roData = new ArrayList<>();
        uninitMem = new ArrayList<>();
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

    public void addUninitMem(String name, long len) {
        uninitMem.add(new Pair<>(name, len));
    }

    public void setInit(FuncFrame tmp) {
        init = tmp;
    }

    public void insertVar(String name, Long size) {
        globals.add(name);
        varSize.put(name, size);
    }

    public String insertStringConst(String str) {
        String name = "S_" + roData.size();
        addRoData(name, str.getBytes(), str.length());
        return name;
    }

    void addRoData(String name, byte[] list, int length) {
        int len = list.length;
        String str = "";
        for(int i = 0; i < len; i++) {
            String tmp = Integer.toHexString(list[i]).toUpperCase();
            if(tmp.length() == 1)tmp = "0" + tmp;
            str += tmp + "H, ";
        }

        str += "00H";
        roData.add(new Pair<>(name, new Pair<>(length, str)));
    }
}
