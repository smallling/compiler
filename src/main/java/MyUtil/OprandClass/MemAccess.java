package main.java.MyUtil.OprandClass;

import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.LinkedList;

public class MemAccess extends Oprand{
    String ac;
    Oprand base;
    Oprand offset;
    Oprand offsetSize;
    Oprand offsetBase;

    public MemAccess(String tmpAc) {
        ac = tmpAc;
        base = null;
        offsetSize = null;
        offsetBase = null;
        offset = null;
    }

    public MemAccess(Oprand tmpBase) {
        base = tmpBase;
        offsetSize = null;
        offsetBase = null;
        offset = null;
        ac = "qword [" + base.get() + "]";
    }

    public MemAccess(Oprand tmpBase, Oprand tmpOffset) {
        base = tmpBase;
        offset = tmpOffset;
        offsetSize = null;
        offsetBase = null;
        ac = "qword [" + base.get() + "+" + offset.get() + "]";
    }

    public MemAccess(Oprand tmpBase, Oprand tmpOffSize, Oprand tmpOffBase) {
        base = tmpBase;
        offset = null;
        offsetSize = tmpOffSize;
        offsetBase = tmpOffBase;
        if(offsetBase instanceof Register) {
            System.err.println("fuck you!");
        }
        ac = "qword [" + base.get() + "+" + offsetSize.get() + "*" + offsetBase.get() + "]";
    }

    public MemAccess(Oprand tmpBase, Oprand tmpOffSize, Oprand tmpOffBase, Oprand tmpOff) {
        base = tmpBase;
        offsetSize = tmpOffSize;
        offsetBase = tmpOffBase;
        if(offsetBase instanceof Register) {
            System.err.println("fuck you!");
        }
        offset = tmpOff;
        ac = "qword [" + base.get() + "+" + offsetSize.get() + "*" + offsetBase.get() + "+" + offset.get() + "]";
    }

    @Override
    public String getPrint() {
        String tmp = this.get();
        return tmp;
    }

    public LinkedList<String> getUsedReg() {
        LinkedList<String> curList = new LinkedList<>();
        if(base != null)curList.add(base.get());
        if(offsetSize != null && offsetSize instanceof Register)curList.add(offsetSize.get());
        return curList;
    }

    public Oprand getBase() {
        return base;
    }

    public Oprand getOffsetSize() {
        return offsetSize;
    }

    public void renameUsedReg(HashMap<String, String> renameMap) {
        if(base != null && renameMap.containsKey(base.get())) {
            base.set(renameMap.get(base.get()));
        }
        if(offsetSize != null && offsetSize instanceof Register && renameMap.containsKey(offsetSize.get())) {
            offsetSize.set(renameMap.get(offsetSize.get()));
        }
    }

    public void setBase(Register tmp) {
        base = tmp.clone();
    }

    public void setOffset(ImmOprand tmp) {
        offset = tmp;
    }

    @Override
    public String get() {
        if(base == null && this instanceof StackSlot) {
            return "stack[" + ac + "]";
        }
        ac = "qword [";
        if (base != null) ac += base.get();
        if (offsetSize != null) ac += "+" + String.format("%s*%s", offsetSize.get(), offsetBase.get());
        if (offset != null) ac += "+" + offset.get();
        ac += "]";
        return ac;
    }

    @Override
    public String getName() {
        return ac;
    }

    @Override
    public void set(String tmp) {
        ac = tmp;
    }

    @Override
    public MemAccess clone() {
        if(base == null)return new MemAccess(ac);
        else if(offset == null && offsetSize == null)return new MemAccess(base);
        else if(offset == null && offsetSize != null)return new MemAccess(base, offsetSize, offsetBase);
        else if(offset != null && offsetSize == null)return new MemAccess(base, offset);
        return new MemAccess(base, offsetSize, offsetBase, offset);
    }

}
