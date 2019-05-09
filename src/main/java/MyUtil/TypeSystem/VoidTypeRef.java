package main.java.MyUtil.TypeSystem;

public class VoidTypeRef extends SingleTypeRef {
    public VoidTypeRef() {
        typeName = "void";
        size = 0;
    }

    public VoidTypeRef clone() {
        return new VoidTypeRef();
    }

    @Override
    public boolean equals(TypeRef other) {
        return (other instanceof VoidTypeRef);
    }
}
