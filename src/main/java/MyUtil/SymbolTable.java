package main.java.MyUtil;

import java.util.HashMap;
import java.util.Iterator;

public class SymbolTable<T> {
    HashMap<String, T> table = new HashMap<>();

    public void println() {

    }

    public T find(String name) {
        return table.get(name);
    }

    public boolean insert(String a, T b) {
        if (table.get(a) != null)return false;
        table.put(a, b);
        return true;
    }

    public HashMap<String, T> getHashMap() {
        return (HashMap<String, T>) table.clone();
    }

    public int size() {
        return table.size();
    }
}
