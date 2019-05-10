package main.java.MyUtil.TypeSystem;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;

public class ArrTypeRef extends VarTypeRef {
    VarTypeRef type;

    public ArrTypeRef(VarTypeRef tmp) {
        type = tmp;
        size = 8;
    }

    public ArrTypeRef(String typeName, int dim) {
        VarTypeRef tmp = (VarTypeRef) TypeRef.buildTypeRef(typeName);
        for(int i = 1; i < dim; i++) {
            tmp = new ArrTypeRef(tmp);
        }
        type = tmp;
        size = 8;
    }

    public ArrTypeRef clone() {
        return new ArrTypeRef(type.clone());
    }

    public SingleTypeRef getSingleType() {
        if(type instanceof SingleTypeRef)return (SingleTypeRef)type;
        return ((ArrTypeRef) type).getSingleType();
    }

    public VarTypeRef getInnerType() {
        return type;
    }

    public boolean equals(TypeRef other) {
        if(!(other instanceof ArrTypeRef)) return false;
        ArrTypeRef tmp = (ArrTypeRef) other;
        if((type instanceof SingleTypeRef) && (tmp.type instanceof SingleTypeRef))return type.equals(tmp.type);
        if((type instanceof SingleTypeRef) || (tmp.type instanceof SingleTypeRef))return false;
        return type.equals(tmp.type);
    }
}
