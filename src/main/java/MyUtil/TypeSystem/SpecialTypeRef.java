package main.java.MyUtil.TypeSystem;


public abstract class SpecialTypeRef extends SimpleTypeRef {
    ClassDefTypeRef belong;
    public void belongTo(ClassDefTypeRef tmp) {
        belong = tmp;
    }

    public ClassDefTypeRef getBelong() {
        return belong;
    }

    @Override
    public abstract SpecialTypeRef clone();

    @Override
    public abstract boolean equals(TypeRef other);
}
