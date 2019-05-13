package main.java.MyUtil.ScopeClass;

import main.java.MyUtil.Pair;
import main.java.MyUtil.SymbolTable;

import java.util.ArrayList;

public class Scope<T> {
    public ArrayList<Scope<T>> sonScope;
    public Scope<T> fa;
    public SymbolTable<T> table;
    String name;

    public Scope(Scope<T> tmpFa, String tmpName) {
        sonScope = new ArrayList<>();
        table = new SymbolTable<>();
        fa = tmpFa;
        name = tmpName;
    }

    public static <L> ClassScope<L> newClassScope(Scope<L> tmpFa) {
        ClassScope<L> sonScope = new ClassScope<>(tmpFa, tmpFa.name + '.' + Integer.toString(tmpFa.sonScope.size()));
        tmpFa.addSonScope(sonScope);
        return sonScope;
    }

    public static <L> LocalScope<L> newLocalScope(Scope<L> tmpFa) {
        LocalScope<L> sonScope = new LocalScope<>(tmpFa, tmpFa.name + "." + Integer.toString(tmpFa.sonScope.size()));
        tmpFa.addSonScope(sonScope);
        return sonScope;
    }

    public String getName() {
        return name;
    }

    public void addSonScope(Scope<T> ls) {
        sonScope.add(ls);
    }

    public boolean addIteam(String name, T value) {
        return table.insert(name, value);
    }

    public T findItem(String name) {
        return table.find(name);
    }

    public Pair<Scope<T>, T> findVarName(String name) {
        Scope<T> p = this;
        while(p != null) {
            T now = p.table.find(name);
            if(now != null)return new Pair<>(p, now);
            p = p.fa;
        }
        return null;
    }
}
