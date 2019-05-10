package main.java.MyUtil.QuadClass;

import main.java.MyUtil.OprandClass.Oprand;

/*
 * add       rt r1 r2
 * sub       rt r1 r2
 * mul       rt r1 r2
 * div       rt r1 r2
 * mod       rt r1 r2
 * sal       rt r1 r2
 * sar       rt r1 r2
 * and       rt r1 r2
 * or        rt r1 r2
 * xor       rt r1 r2
 * not       rt r1     ( xor r1 (1<<31)-1 )
 * neg       rt r1     ( sub 0  neg       )
 */

public class ArthQuad extends Quad{
    public ArthQuad(String tmpOp, Oprand tmpRt) {
        super(tmpOp, tmpRt);
    }

    public ArthQuad(String tmpOp, Oprand tmpRt, Oprand tmpR1) {
        super(tmpOp, tmpRt, tmpR1);
    }

    public ArthQuad(String tmpOp, Oprand tmpResult, Oprand tmpR1, Oprand tmpR2) {
        super(tmpOp, tmpResult, tmpR1, tmpR2);
    }

    @Override
    public ArthQuad clone() {
        String tmoOp = op;
        Oprand tmpRt = (rt != null ? rt.clone() : null);
        Oprand tmpR1 = (r1 != null ? r1.clone() : null);
        Oprand tmpR2 = (r2 != null ? r2.clone() : null);
        return new ArthQuad(tmoOp, tmpRt, tmpR1, tmpR2);
    }
}
