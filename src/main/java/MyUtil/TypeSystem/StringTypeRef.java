package main.java.MyUtil.TypeSystem;

public class StringTypeRef extends SpecialTypeRef {
    public StringTypeRef() {
        typeName = "string";
        size = curLen;
    }

    public StringTypeRef clone() {
        return new StringTypeRef();
    }

    @Override
    public boolean equals(TypeRef other) {
        return (other instanceof StringTypeRef);
    }
}
