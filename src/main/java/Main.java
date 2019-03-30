package main.java;

import main.java.FrontEnd.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;


import java.io.*;

public class Main {

    public static void main (String[] args) throws IOException, SyntaxError {
        String fileName = "test";
        InputStream is = new FileInputStream("testcase/" + fileName);
        ANTLRInputStream input = new ANTLRInputStream (is);
        MxStarLexer lexer = new MxStarLexer (input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MxStarParser parser = new MxStarParser(tokens);
        parser.setErrorHandler( new BailErrorStrategy());
        ParseTree tree = parser.code();

        BuildAstVisitor buildAstVisitor = new BuildAstVisitor();
        Node root = buildAstVisitor.visit(tree);

        /*
        TestAst test = new TestAst();
        test.dfs(root, "");
        */

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

        System.out.println("Accept");
    }
}
