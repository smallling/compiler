package main.java.BackEnd;

import javafx.util.Pair;
import main.java.MyUtil.FuncFrame;
import main.java.MyUtil.LinearIR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CodeGen {
    ArrayList<String> globals;
    ArrayList<String> externs;
    ArrayList<FuncFrame> funcs;
    ArrayList<String> codeList;
    HashMap<String, Long> varSize;
    FuncFrame initFunc;

    ArrayList<Pair<String, Long> > uninitMem;
    ArrayList<Pair<String, String> > roData;

    public CodeGen(LinearIR ir) {
        globals = ir.globals;
        globals.add("S_substring");
        globals.add("S_parseInt");
        globals.add("S_ord");
        globals.add("S_strcpy");
        globals.add("S_strcat");
        globals.add("S_strlen");
        globals.add("F_print");
        globals.add("F_println");
        globals.add("F_getString");
        globals.add("F_getInt");
        globals.add("F_toString");

        funcs = ir.funcs;
        initFunc = ir.init;
        codeList = new ArrayList<>();
        varSize = ir.varSize;

        externs = new ArrayList<>();

        externs.add("strcmp");
        externs.add("__sprintf_chk");
        externs.add("_IO_getc");
        externs.add("stdin");
        externs.add("puts");
        externs.add("scanf");
        externs.add("_IO_putc");
        externs.add("stdout");
        externs.add("__stack_chk_fail");
        externs.add("sscanf");
        externs.add("memcpy");
        externs.add("malloc");

        uninitMem = ir.uninitMem;
        roData = ir.roData;
    }

    public ArrayList<String> genCode() {
        codeList.add("default rel");
        codeList.add("");

        for(int i = 0; i < globals.size(); i++) {
            codeList.add("global " + globals.get(i));
        }
        codeList.add("");

        for(int i = 0; i < externs.size(); i++) {
            codeList.add("extern " + externs.get(i));
        }

        codeList.add("");

        codeList.add("SECTION .text");

        codeList.add(BuiltinCode.text);

        for(int i = 0; i < funcs.size(); i++) {
            FuncFrame func = funcs.get(i);
            if(func.getName().equals("main")) func.addInit(initFunc);
            CodeGenFunc funcGen = new CodeGenFunc(func, varSize);
            codeList.addAll(funcGen.genCode());
            codeList.add("");
            codeList.add("");
        }

        if(initFunc != null) {
            CodeGenFunc funcGen = new CodeGenFunc(initFunc, varSize);
            codeList.addAll(funcGen.genCode());
            codeList.add("");
            codeList.add("");
        }

        codeList.add("SECTION .data    align=8");

        codeList.add("");
        codeList.add("SECTION .bss     align=8");

        for(Pair<String, Long> data : uninitMem) {
            codeList.add(data.getKey() + ":");
            codeList.add(String.format("%-8s resq %s", " ", data.getValue()));
        }

        codeList.add("");
        codeList.add("SECTION .rodata");
        for (Pair<String, String> data: roData) {
            codeList.add(data.getKey() + ": ");
            codeList.add(String.format("%-8s db %s", " ", data.getValue()));
        }
        codeList.add(BuiltinCode.roDataString);


        return codeList;
    }
}
