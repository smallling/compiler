package main.java.MyUtil.OprandClass;

public class GeneralMemAccess extends MemAccess{
    public GeneralMemAccess(String tmpName) {
        super(tmpName);
    }

    public String getName() {
        return ac;
    }

    @Override
    public String getPrint() {
        return this.get();
    }

    @Override
    public String get() {
        return "qword [rel " + ac + "]";
    }

    @Override
    public void set(String tmp) {
        ac = tmp;
    }

    @Override
    public GeneralMemAccess clone() {
        return new GeneralMemAccess(ac);
    }
}
