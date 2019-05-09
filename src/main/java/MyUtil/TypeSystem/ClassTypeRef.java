package main.java.MyUtil.TypeSystem;

public class ClassTypeRef extends SpecialTypeRef {
    public ClassTypeRef(String className) {
        typeName = className;
        size = curLen;
    }

    public ClassTypeRef(String className, ClassDefTypeRef tmp) {
        typeName = className;
        belong = tmp;
        size = curLen;
    }

    public ClassTypeRef clone() {
        return new ClassTypeRef(typeName, belong);
    }

    @Override
    public boolean equals(TypeRef other) {
        return (other instanceof  ClassTypeRef) && ((ClassTypeRef)other).typeName.equals(typeName);
    }
}
