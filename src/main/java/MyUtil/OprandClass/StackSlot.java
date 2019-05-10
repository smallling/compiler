package main.java.MyUtil.OprandClass;

public class StackSlot extends MemAccess {
    public StackSlot(String tmpName) {
        super(tmpName);
    }

    public String getName() {
        return ac;
    }

    public StackSlot(Oprand tmpBase) {
        super(tmpBase);
    }

    public StackSlot(Oprand tmpBase, Oprand tmpOffset) {
        super(tmpBase, tmpOffset);
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
        if(base == null)return new StackSlot(ac);
        else if(offset == null)return new StackSlot(base);
        return new StackSlot(base, offset);
    }
}
