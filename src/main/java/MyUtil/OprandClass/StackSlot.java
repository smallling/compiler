package main.java.MyUtil.OprandClass;

public class StackSlot extends MemAccess {
    public StackSlot(String tmpName) {
        super(tmpName);
    }

    public String getName() {
        return ac;
    }

    @Override
    public String getPrint() {
        String tmp = this.get();
        return tmp.substring(6);
    }

    @Override
    public void set(String tmp) {
        ac = tmp;
    }

    @Override
    public StackSlot clone() {
        return new StackSlot(ac);
    }
}
