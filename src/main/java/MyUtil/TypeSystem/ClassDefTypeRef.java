package main.java.MyUtil.TypeSystem;

import javafx.util.Pair;

import java.util.HashMap;

public class ClassDefTypeRef extends TypeRef {
    HashMap<String, Pair<TypeRef, Long>> map;

    public ClassDefTypeRef() {
        map = new HashMap<>();
        size = 0;
    }

    public ClassDefTypeRef(HashMap<String, TypeRef> tmpMap) {
        map = new HashMap<>();
        for(String key : tmpMap.keySet()) {
            TypeRef now = tmpMap.get(key);
            map.put(key, new Pair<>(now, size));
            if(now instanceof VarTypeRef)size += now.getSize();
        }
    }

    public void insert(String key, TypeRef value) {
        size += value.getSize();
        map.put(key, new Pair<>(value, size));
    }

    public boolean equals(TypeRef other) {
        if(!(other instanceof ClassDefTypeRef))return false;
        ClassDefTypeRef tmp = (ClassDefTypeRef) other;
        if(map.size() != tmp.map.size())return false;
        for(String key : map.keySet()) {
            if(!(tmp.map.containsKey(key)) || !(tmp.map.get(key).equals(map.get(key))))return false;
        }
        return true;
    }

    public boolean checkExit(String str) {
        return map.containsKey(str);
    }

    public TypeRef getTypeRef(String str) {
        return map.get(str).getKey();
    }

    public long getSize(String str) {
        return map.get(str).getValue();
    }
}
