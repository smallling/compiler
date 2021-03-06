package main.java.MyUtil.TypeSystem;

import java.util.ArrayList;

public abstract class TypeRef {
    public static int curLen = 8;

    long size;
    public static TypeRef buildTypeRef(String typeName) {
        if(typeName.contains("[")) {
            int dim = 0;
            String arrName = "";
            for(int i = 0; i < typeName.length(); i++)
                if(typeName.charAt(i) == '[') {
                    arrName = typeName.substring(0, i);
                    break;
                }
            for(int i = 0; i < typeName.length(); i++) {
                if (typeName.charAt(i) == '[') dim++;
            }
            return new ArrTypeRef(arrName, dim);
        }
        else {
            if(typeName.equals("int")) return new IntTypeRef();
            if(typeName.equals("bool")) return new BoolTypeRef();
            if(typeName.equals("string")) return new StringTypeRef();
            if(typeName.equals("void")) return new VoidTypeRef();
            return new ClassTypeRef(typeName);
        }
    }

    public static String getPre(TypeRef tmp) {
        if(tmp instanceof SpecialTypeRef || tmp instanceof ArrTypeRef)return "A_";
        return "V_";
    }

    public boolean equalsSingleType(String type) {
        return (this instanceof SingleTypeRef) && (((SingleTypeRef) this).typeName.equals(type));
    }

    public long getSize() {
        return size;
    }

    public abstract boolean equals(TypeRef other);

    public static boolean isAddType(TypeRef ref) {
        return (ref instanceof SpecialTypeRef) || (ref instanceof ArrTypeRef);
    }
}
