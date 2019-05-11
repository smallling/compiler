package main.java.MyUtil.OprandClass;

public abstract class Oprand {
    public abstract String getPrint();
    public abstract String get();
    public abstract String getName();
    public abstract void set(String tmp);
    public abstract Oprand clone();
}
