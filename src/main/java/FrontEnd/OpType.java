package main.java.FrontEnd;

import main.java.MyUtil.TypeSystem.*;

import java.lang.reflect.Type;

public abstract class OpType {
    String op;

    OpType(String o) {
        op = o;
    }

    static OpType belongTo(String o) {
        if(o.equals("="))
            return new AssignOpType(o);
        if(o.equals("+") || o.equals("-") || o.equals("*") || o.equals("/") || o.equals("%"))
            return new ArithmeticOpType(o);
        if(o.equals("<") || o.equals(">") || o.equals("==") || o.equals("!=") || o.equals("<=") || o.equals(">="))
            return new RelativeOpType(o);
        if(o.equals("&&") || o.equals("||") || o.equals("!"))
            return new LogicalOpType(o);
        if(o.equals("<<") || o.equals(">>") || o.equals("&") || o.equals("|") || o.equals("^") | o.equals("~"))
            return new BitOpType(o);
        if(o.equals("++") || o.equals("--"))
            return new SelfPmOpType(o);
        System.out.println("OpWrong!");
        return new FakeOpType(o);
    }

    abstract boolean containsType(TypeRef type);
}

class ArithmeticOpType extends OpType {
    ArithmeticOpType(String o) {
        super(o);
    }

    @Override
    boolean containsType(TypeRef type) {
        return (type instanceof IntTypeRef) || (op.equals("+") && type instanceof StringTypeRef);
    }
}

class RelativeOpType extends OpType {
    RelativeOpType(String o) {
        super(o);
    }

    @Override
    boolean containsType(TypeRef type) {
        if (op.equals("==") || op.equals("!="))return true;
        return (type instanceof IntTypeRef) || (type instanceof StringTypeRef);
    }

    boolean checkExpr(TypeRef l, TypeRef r) {
        if(l.equals(r))return true;
        else {
            if(op.equals("==") || op.equals("!=")) {
                if(l instanceof ClassTypeRef || l instanceof ArrTypeRef) {
                    return (r instanceof NullTypeRef);
                }
                if(r instanceof ClassTypeRef || r instanceof ArrTypeRef) {
                    return (l instanceof NullTypeRef);
                }
            }
        }
        return false;
    }
}

class LogicalOpType extends OpType {
    LogicalOpType(String o) {
        super(o);
    }

    @Override
    boolean containsType(TypeRef type) {
        return (type instanceof BoolTypeRef);
    }
}

class BitOpType extends OpType {
    BitOpType(String o) {
        super(o);
    }

    @Override
    boolean containsType(TypeRef typeRef) {
        return (typeRef instanceof IntTypeRef);
    }
}

class AssignOpType extends OpType {
    AssignOpType(String o) {
        super(o);
    }

    @Override
    boolean containsType(TypeRef type) {
        return (type instanceof VarTypeRef);
    }

    static boolean checkExpr(TypeRef l, TypeRef r) {
        if(l.equals(r))return true;
        else {
            if (l instanceof ClassTypeRef || l instanceof ArrTypeRef) {
                return (r instanceof NullTypeRef);
            }
        }
        return false;
    }
}

class SelfPmOpType extends OpType {
    SelfPmOpType(String o) {
        super(o);
    }

    @Override
    boolean containsType(TypeRef type) {
        return (type instanceof IntTypeRef);
    }
}

class FakeOpType extends OpType {
    FakeOpType(String o) {
        super(o);
    }

    @Override
    boolean containsType(TypeRef type) {
        return false;
    }
}