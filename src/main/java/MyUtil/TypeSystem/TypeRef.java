package main.java.MyUtil.TypeSystem;

public abstract class TypeRef {
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

    public boolean equalsSingleType(String type) {
        return (this instanceof SingleTypeRef) && (((SingleTypeRef) this).typeName.equals(type));
    }

    public abstract boolean equals(TypeRef other);

    public static boolean isAddType(TypeRef ref) {
        return (ref instanceof SpecialTypeRef) || (ref instanceof ArrTypeRef);
    }
}
