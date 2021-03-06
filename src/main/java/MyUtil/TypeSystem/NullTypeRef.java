package main.java.MyUtil.TypeSystem;

public class NullTypeRef extends SingleTypeRef {
    public NullTypeRef() {
        typeName = "null";
        size = curLen;
    }

    public NullTypeRef clone() {
        return new NullTypeRef();
    }

    @Override
    public boolean equals(TypeRef other) {
        return (other instanceof NullTypeRef);
    }
}
