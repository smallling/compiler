package main.java.MyUtil.OprandClass;


public class FuncName extends Oprand {
    String func;

    public FuncName(String tmp) {
        func = tmp;
    }

    @Override
    public String getPrint() {
        return func;
    }

    @Override
    public String get() {
        return func;
    }

    @Override
    public void set(String tmp) {
        func = tmp;
    }

    @Override
    public Oprand clone() {
        return new FuncName(func);
    }
}
