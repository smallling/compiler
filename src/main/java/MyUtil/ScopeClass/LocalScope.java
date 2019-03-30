package main.java.MyUtil.ScopeClass;

public class LocalScope<T> extends Scope<T> {
    public LocalScope(Scope<T> tmpFa, String tmpName) {
        super(tmpFa,tmpName);
    }
}
