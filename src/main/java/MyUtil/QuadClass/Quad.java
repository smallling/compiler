package main.java.MyUtil.QuadClass;

import main.java.MyUtil.OprandClass.MemAccess;
import main.java.MyUtil.OprandClass.Oprand;
import main.java.MyUtil.OprandClass.Register;

import java.util.HashMap;
import java.util.LinkedList;

public class Quad {
    String op;
    String label;
    Oprand r1, r2, rt;

    public void print() {
        if(label != null) System.out.printf("%-10s", label + ":");
        else System.out.printf("%-10s", " ");
        System.out.print(op);
        if(rt != null)System.out.print(" " + rt.get());
        if(r1 != null)System.out.print(" " + r1.get());
        if(r2 != null)System.out.print(" " + r2.get());
        System.out.println();
    }

    public String getPrint() {
        if(op.equals("jump"))op = "jmp";
        String tmp = String.format("%-8s", "");
        tmp += op;
        if(op.equals("ret")) {
            return tmp;
        }
        if(op.equals("call")) {
            tmp += " " + r1.getPrint();
            return tmp;
        }
        if(op.equals("je") || op.equals("jne") || op.equals("jl") || op.equals("jg") || op.equals("jle") || op.equals("jge")) {
            tmp += " " + r1.getPrint();
            return tmp;
        }
        if(rt != null) tmp += " " + rt.getPrint() + ",";
        if(r1 != null) {
            if(op.equals("lea"))tmp += " " + r1.getPrint().substring(6) + ",";
            else tmp += " " + r1.getPrint() + ",";
        }
        if(r2 != null) tmp += " " + r2.getPrint() + ",";
        if(tmp.charAt(tmp.length() - 1) == ',') {
            tmp = tmp.substring(0, tmp.length() - 1);
        }
        return tmp;
    }

    public Quad(String tmpOp) {
        op = tmpOp;
        label = null;
        r1 = r2 = rt = null;
    }

    public Quad(String tmpOp, Oprand tmpResult) {
        op = tmpOp;
        label = null;
        r1 = r2 = null;
        rt = tmpResult.clone();
    }

    public Quad(String tmpOp, Oprand tmpResult, Oprand tmpR1) {
        op = tmpOp;
        label = null;
        r1 = tmpR1.clone();
        r2 = null;
        rt = tmpResult.clone();
    }

    public Quad(String tmpOp, Oprand tmpResult, Oprand tmpR1, Oprand tmpR2) {
        op = tmpOp;
        label = null;
        if(tmpR1 != null)r1 = tmpR1.clone();
        else r1 = null;
        if(tmpR2 != null)r2 = tmpR2.clone();
        else r2 = null;
        if(tmpResult != null)rt = tmpResult.clone();
        else rt = null;
    }

    public Oprand getR1() {
        return r1;
    }

    public Oprand getR2() {
        return r2;
    }

    public Oprand getRt() {
        return rt;
    }

    public void setR1(Oprand tmp) {
        r1 = tmp.clone();
    }

    public void setR2(Oprand tmp) {
        r2 = tmp.clone();
    }

    public void setRt(Oprand tmp) {
        rt = tmp.clone();
    }

    public void setLabel(String tmp) {
        label = tmp;
    }

    public String getLabel() {
        return label;
    }

    public String getOp() {
        return op;
    }

    public Quad clone() {
        String tmoOp = op;
        Oprand tmpRt = (rt != null ? rt.clone() : null);
        Oprand tmpR1 = (r1 != null ? r1.clone() : null);
        Oprand tmpR2 = (r2 != null ? r2.clone() : null);
        return new Quad(tmoOp, tmpRt, tmpR1, tmpR2);
    }

    public LinkedList<String> getUsedReg() {
        LinkedList<String> curList = new LinkedList<>();
        if(op.equals("imul")) {
            curList.add("rax");
        }
        if(op.equals("idiv") || op.equals("mod")) {
            curList.add("rax");
            curList.add("rdx");
        }
        if(this instanceof ArthQuad) {
            if(op.equals("inc") || op.equals("dec") || op.equals("idiv") || (op.equals("imul") && r1 != null)) {
                if(rt instanceof MemAccess) {
                    curList.addAll(((MemAccess) rt).getUsedReg());
                }
                else if(rt instanceof Register) {
                    curList.add(rt.get());
                }
            }
            else {
                if(rt instanceof MemAccess) {
                    curList.addAll(((MemAccess) rt).getUsedReg());
                }
                else if(rt instanceof Register) {
                    curList.add(rt.get());
                }
                if(r1 instanceof MemAccess) {
                    curList.addAll(((MemAccess) r1).getUsedReg());
                }
                else if(r1 instanceof Register) {
                    curList.add(r1.get());
                }
            }
        }
        else {
            if(op.equals("mov")) {
                if(rt instanceof MemAccess) {
                    curList.addAll(((MemAccess) rt).getUsedReg());
                }
                if(r1 instanceof MemAccess) {
                    curList.addAll(((MemAccess) r1).getUsedReg());
                }
                else if(r1 instanceof Register) {
                    curList.add(r1.get());
                }
            }
            if(op.equals("lea")) {
                curList.addAll(((MemAccess) r1).getUsedReg());
                curList.add(rt.get());
            }
            if(op.equals("push")) {
                if(rt instanceof MemAccess) {
                    curList.addAll(((MemAccess) rt).getUsedReg());
                }
            }
            if(op.equals("ret") && rt != null) {
                curList.add("rax");
            }
            if(op.equals("cmp")) {
                if(rt instanceof Register) {
                    curList.add(rt.get());
                }
                if(r1 instanceof MemAccess) {
                    curList.addAll(((MemAccess) r1).getUsedReg());
                }
                else if(r1 instanceof Register) {
                    curList.add(r1.get());
                }
            }
        }
        return curList;
    }

    public LinkedList<String> getDefinedReg() {
        LinkedList<String> curList = new LinkedList<>();
        if(op.equals("imul") || op.equals("idiv") || op.equals("mod")) {
            curList.add("rax");
            curList.add("rdx");
        }
        if(this instanceof ArthQuad) {
            if(op.equals("inc") || op.equals("dec")) {
                if(rt instanceof Register) {
                    curList.add(rt.get());
                }
            }
            else {
                if(rt instanceof Register) {
                    curList.add(rt.get());
                }
            }
        }
        else {
            if(op.equals("mov")) {
                if(rt instanceof Register) {
                    curList.add(rt.get());
                }
            }
            if(op.equals("lea")) {
                curList.add(rt.get());
            }
            if(op.equals("push")) {
                if(rt instanceof Register) {
                    curList.add(rt.get());
                }
            }
            if(op.equals("call")) {
                curList.add("rax");
                curList.add("rcx");
                curList.add("rdx");
                curList.add("rsi");
                curList.add("rdi");
                curList.add("r8");
                curList.add("r9");
                curList.add("r10");
                curList.add("r11");
            }
        }
        return curList;
    }

    public void renameUsedReg(HashMap<String, String> renameMap) {
        if(this instanceof ArthQuad) {
            if(op.equals("inc") || op.equals("dec") || op.equals("idiv") || (op.equals("imul") && r1 != null)) {
                if(rt instanceof MemAccess) {
                    ((MemAccess) rt).renameUsedReg(renameMap);
                }
                else if(rt instanceof Register && renameMap.containsKey(rt.get())) {
                    rt.set(renameMap.get(rt.get()));
                }
            }
            else {
                if(rt instanceof MemAccess) {
                    ((MemAccess) rt).renameUsedReg(renameMap);
                }
                else if(rt instanceof Register && renameMap.containsKey(rt.get())) {
                    rt.set(renameMap.get(rt.get()));
                }
                if(r1 instanceof MemAccess) {
                    ((MemAccess) r1).renameUsedReg(renameMap);
                }
                else if(r1 instanceof Register && renameMap.containsKey(r1.get())) {
                    r1.set(renameMap.get(r1.get()));
                }
            }
        }
        else {
            if(op.equals("mov")) {
                if(rt instanceof MemAccess) {
                    ((MemAccess) rt).renameUsedReg(renameMap);
                }
                if(r1 instanceof MemAccess) {
                    ((MemAccess) r1).renameUsedReg(renameMap);
                }
                else if(r1 instanceof Register && renameMap.containsKey(r1.get())) {
                    r1.set(renameMap.get(r1.get()));
                }
            }
            if(op.equals("lea")) {
                ((MemAccess) r1).renameUsedReg(renameMap);
            }
            if(op.equals("push")) {
                if(rt instanceof MemAccess) {
                    ((MemAccess) rt).renameUsedReg(renameMap);
                }
            }
            if(op.equals("cmp")) {
                if(rt instanceof Register && renameMap.containsKey(rt.get())) {
                    rt.set(renameMap.get(rt.get()));
                }
                if(r1 instanceof MemAccess) {
                    ((MemAccess) r1).renameUsedReg(renameMap);
                }
                else if(r1 instanceof Register && renameMap.containsKey(r1.get())) {
                    r1.set(renameMap.get(r1.get()));
                }
            }
        }
    }

    public void renameDefinedReg(HashMap<String, String> renameMap) {
        if(this instanceof ArthQuad) {
            if(rt instanceof Register && renameMap.containsKey(rt.get())) {
                rt.set(renameMap.get(rt.get()));
            }
        }
        else {
            if(op.equals("mov")) {
                if(rt instanceof Register && renameMap.containsKey(rt.get())) {
                    rt.set(renameMap.get(rt.get()));
                }
            }
            if(op.equals("lea")) {
                if(renameMap.containsKey(rt.get())) {
                    rt.set(renameMap.get(rt.get()));
                }
            }
            if(op.equals("push")) {
                if(rt instanceof Register && renameMap.containsKey(rt.get())) {
                    rt.set(renameMap.get(rt.get()));
                }
            }
        }
    }
}
