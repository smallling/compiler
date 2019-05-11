package main.java.MyUtil.OprandClass;

public class LabelName extends Oprand {

    String name;

    public LabelName(String tmpName) {
        name = tmpName;
    }

    @Override
    public String getPrint() {
        return name;
    }

    @Override
    public String get() {
        return name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void set(String tmp) {
        name = tmp;
    }

    @Override
    public Oprand clone() {
        return new LabelName(name);
    }
}
