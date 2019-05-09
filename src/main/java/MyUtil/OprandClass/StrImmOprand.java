package main.java.MyUtil.OprandClass;

public class StrImmOprand extends Oprand{
    String val;

    public StrImmOprand(String tmpVal) {
        val = tmpVal;
    }

    @Override
    public String getPrint() {
        return val;
    }

    @Override
    public String get() {
        return val;
    }

    @Override
    public void set(String tmp) {
        val = tmp;
    }

    @Override
    public Oprand clone() {
        return new StrImmOprand(val);
    }
}
