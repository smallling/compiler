package main.java.MyUtil.OprandClass;

public class ImmOprand extends Oprand{
    long val;

    public ImmOprand(long tmpVal) {
        val = tmpVal;
    }

    @Override
    public String getPrint() {
        return Long.toString(val);
    }

    @Override
    public String get() {
        return Long.toString(val);
    }

    @Override
    public String getName() {
        return Long.toString(val);
    }

    @Override
    public void set(String tmp) {
        val = Long.parseLong(tmp);
    }

    @Override
    public Oprand clone() {
        return new ImmOprand(val);
    }
}
