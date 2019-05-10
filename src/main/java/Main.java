package main.java;

import main.java.BackEnd.CodeGen;
import main.java.BackEnd.RegisterDistribution;
import main.java.FrontEnd.*;
import main.java.MyUtil.FuncFrame;
import main.java.MyUtil.LinearIR;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;


import java.io.*;
import java.util.ArrayList;

public class Main {

    static public int rebuildCnt = 0;

    public static void main (String[] args) throws Exception {
        String fileName = "test";
        InputStream is = new FileInputStream("testcase/" + fileName);
        ANTLRInputStream input = new ANTLRInputStream (is);
        //ANTLRInputStream input = new ANTLRInputStream (System.in);
        MxStarLexer lexer = new MxStarLexer (input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MxStarParser parser = new MxStarParser(tokens);
        parser.setErrorHandler( new BailErrorStrategy());
        ParseTree tree = parser.code();

        BuildAstVisitor buildAstVisitor = new BuildAstVisitor();
        Node root = buildAstVisitor.visit(tree);

        ScopeBuilder scopeBuilder = new ScopeBuilder();
        scopeBuilder.work(root);

        SemanticChecker checker = new SemanticChecker(scopeBuilder.root);
        try {
            root.compiler(checker);
        } catch (SyntaxError e) {
            System.out.println(e.toString() + " on Line: " + e.loc.line + ",  Column: " + e.loc.column);
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }

        IRBuilder irBuilder = new IRBuilder();
        LinearIR irCode = irBuilder.buildIR(root);

        irCode.print();

        System.err.println("=============================================================");

        irCode.rebuild();

        irCode.print();

        System.err.println("=============================================================");

        for(FuncFrame func : irCode.funcs) {
            RegisterDistribution tmp = new RegisterDistribution();
            tmp.processFunc(func);
        }

        if(irCode.init != null) {
            RegisterDistribution tmp = new RegisterDistribution();
            tmp.processFunc(irCode.init);
        }

      //  irCode.print();

      //  System.err.println("=============================================================");

        CodeGen codeGen = new CodeGen(irCode);
        ArrayList<String> codeList = codeGen.genCode();

        String content = "";

        for(String code : codeList) {
            System.out.println(code);
            content += code + "\n";
        }

        File file = new File("testcase/" + fileName + ".asm");
        OutputStream out = new FileOutputStream(file);
        if (!file.exists()) file.createNewFile();
        out.write(content.getBytes());
        out.flush();
        out.close();
    }
}
