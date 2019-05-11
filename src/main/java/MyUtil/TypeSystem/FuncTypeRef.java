package main.java.MyUtil.TypeSystem;

import java.util.ArrayList;

public class FuncTypeRef extends TypeRef {
    VarTypeRef returnType;
    ArrayList<VarTypeRef> param;

    public String getTypeName() {
        return ((SingleTypeRef) returnType).getTypeName();
    }

    public FuncTypeRef(VarTypeRef tmpReturnType) {
        returnType = tmpReturnType;
        param = new ArrayList<VarTypeRef>();
    }

    public FuncTypeRef(VarTypeRef tmpReturnType, VarTypeRef... tmpParam) {
        returnType = tmpReturnType;
        param = new ArrayList<VarTypeRef>();
        for(int i = 0; i < tmpParam.length; i++) {
            param.add(tmpParam[i]);
        }
    }

    public int getParamSize() {
        return param.size();
    }

    public VarTypeRef getParam(int x) {
        return param.get(x);
    }

    public VarTypeRef getReturnType() {
        return returnType;
    }

    public void addParam(VarTypeRef p) {
        param.add(p);
    }

    public boolean equals(TypeRef other) {
        if(!(other instanceof FuncTypeRef))return false;
        FuncTypeRef tmp = (FuncTypeRef) other;
        if(!returnType.equals(tmp.returnType))return false;
        if(param.size() != tmp.param.size())return false;
        for(int i = 0; i < param.size(); i++){
            if(!param.get(i).equals(tmp.param.get(i)))return false;
        }
        return true;
    }
}
