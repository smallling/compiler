package main.java.MyUtil.TypeSystem;

public class IntTypeRef extends SimpleTypeRef {
    public IntTypeRef() {
        typeName = "int";
    }

    public IntTypeRef clone() {
        return new IntTypeRef();
    }

    @Override
    public boolean equals(TypeRef other) {
        return (other instanceof IntTypeRef);
    }
}
