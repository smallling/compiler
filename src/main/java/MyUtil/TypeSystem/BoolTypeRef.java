package main.java.MyUtil.TypeSystem;

public class BoolTypeRef extends SimpleTypeRef {
    public BoolTypeRef() {
        typeName = "bool";
    }

    public BoolTypeRef clone() {
        return new BoolTypeRef();
    }

    @Override
    public boolean equals(TypeRef other) {
        return (other instanceof BoolTypeRef);
    }

}
