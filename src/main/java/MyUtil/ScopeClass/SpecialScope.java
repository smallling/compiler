package main.java.MyUtil.ScopeClass;

public class SpecialScope<T> extends Scope<T> {
    public SpecialScope(Scope<T> tmpFa, String tmpName) {
        super(tmpFa, tmpName);
    }
}
