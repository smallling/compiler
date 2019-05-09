package main.java.BackEnd;

import main.java.MyUtil.FuncFrame;
import main.java.MyUtil.LinearIR;

import java.util.ArrayList;
import java.util.HashMap;

public class CodeGen {
    ArrayList<String> globals;
    ArrayList<FuncFrame> funcs;
    ArrayList<String> codeList;
    HashMap<String, Long> varSize;
    FuncFrame initFunc;

    public CodeGen(LinearIR ir) {
        globals = ir.globals;
        funcs = ir.funcs;
        initFunc = ir.init;
        codeList = new ArrayList<>();
        varSize = ir.varSize;
    }

    public ArrayList<String> genCode() {
        codeList.add("default rel");
        codeList.add("");

        for(int i = 0; i < globals.size(); i++) {
            codeList.add("global " + globals.get(i));
        }
        codeList.add("");

        codeList.add("SECTION .text");

        for(int i = 0; i < funcs.size(); i++) {
            FuncFrame func = funcs.get(i);
            if(func.getName().equals("main")) func.addInit(initFunc);
            CodeGenFunc funcGen = new CodeGenFunc(func, varSize);
            codeList.addAll(funcGen.genCode());
            codeList.add("");
            codeList.add("");
            codeList.add("");
            codeList.add("");
            codeList.add("");
            codeList.add("");
        }
        if(initFunc != null) {
            CodeGenFunc funcGen = new CodeGenFunc(initFunc, varSize);
            codeList.addAll(funcGen.genCode());
        }

        return codeList;
    }
}
