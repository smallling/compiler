package main.java.MyUtil.QuadClass;

import main.java.MyUtil.OprandClass.Oprand;

public class CJumpQuad extends Quad {
    public CJumpQuad(String tmpOp, Oprand tmpR1, Oprand tmpR2) {
        super(tmpOp, null, tmpR1, tmpR2);
    }

    @Override
    public CJumpQuad clone() {
        String tmoOp = op;
        Oprand tmpRt = (rt != null ? rt.clone() : null);
        Oprand tmpR1 = (r1 != null ? r1.clone() : null);
        Oprand tmpR2 = (r2 != null ? r2.clone() : null);
        return new CJumpQuad(tmoOp, tmpR1, tmpR2);
    }
}
