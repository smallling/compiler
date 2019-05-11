package main.java.MyUtil.OprandClass;

public class Register extends Oprand{
    String name;
    String memPos;

    public Register(String tmpName) {
        name = tmpName;
    }

    public Register(String tmpName, String tmpMemPos) {
        name = tmpName;
        memPos = tmpMemPos;
    }

    public void setMemPos(String tmp) {
        memPos = tmp;
    }

    public String getMemPos() {
        return memPos;
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
        return new Register(name, memPos);
    }
}
