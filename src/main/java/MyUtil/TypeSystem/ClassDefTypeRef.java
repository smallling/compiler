package main.java.MyUtil.TypeSystem;

import java.util.HashMap;
import java.util.Map;

public class ClassDefTypeRef extends TypeRef {
    HashMap<String, TypeRef> map;

    public ClassDefTypeRef() {
        map = new HashMap<>();
    }

    public ClassDefTypeRef(HashMap<String, TypeRef> tmpMap) {
        map = (HashMap<String, TypeRef>) tmpMap.clone();
    }

    public void insert(String key, TypeRef value) {
        map.put(key, value);
    }

    public boolean equals(TypeRef other) {
        if(!(other instanceof ClassDefTypeRef))return false;
        ClassDefTypeRef tmp = (ClassDefTypeRef) other;
        if(map.size() != tmp.map.size())return false;
        for(String nowkey : map.keySet()) {
            if(!(tmp.map.containsKey(nowkey)) || !(tmp.map.get(nowkey).equals(map.get(nowkey))))return false;
        }
        return true;
    }

    public boolean checkExit(String str) {
        return map.containsKey(str);
    }

    public TypeRef getTypeRef(String str) {
        return map.get(str);
    }


}
