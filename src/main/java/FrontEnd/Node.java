package main.java.FrontEnd;

import main.java.MyUtil.ScopeClass.Scope;
import main.java.MyUtil.TypeSystem.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Node {
    String name;
    TypeRef type;
    Location loc;
    List<Node> son;
    Scope<TypeRef> belong;
    String inClass;

    Node() {
        name = "";
        type = TypeRef.buildTypeRef("void");
        son = new ArrayList<Node>();
        inClass = null;
    }

    public int sonSize() {
        return son.size();
    }

    public Node sonAt(int x){
        return son.get(x);
    }

    public void compiler(AstVisitor visitor) throws Exception {
        visitor.visit(this);
    }

    void print(String indentation) {}
}

class CodeNode extends Node {
    CodeNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<CodeNode> name: " + name + " type: " + type.toString());
    }
}

class VarDefNode extends Node {
    VarDefNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<VarDefNode> name: " + name + " type: " + type.toString());
    }
}

class ClassDefNode extends Node {
    ClassDefNode () {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<ClassDefNode> name: " + name + " type: " + type.toString());
    }
}

class FuncDefNode extends Node {
    FuncDefNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<FuncDefNode> name: " + name + " type: " + type.toString());
    }
}

class ConsFuncDefNode extends FuncDefNode {
    ConsFuncDefNode(){
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<ConsFuncDefNode> name: " + name + " type: " + type.toString());
    }
}

abstract class StatNode extends Node {
    StatNode(){
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<StatNode> name: " + name + " type: " + type.toString());
    }
}

class CompStatNode extends StatNode {
    CompStatNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<CompStatNode> name: " + name + " type: " + type.toString());
    }
}

class ExprStatNode extends StatNode {
    ExprStatNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<ExprStatNode> name: " + name + " type: " + type.toString());
    }
}

abstract class SeleStatNode extends StatNode {
    SeleStatNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<SeleStatNode> name: " + name + " type: " + type.toString());
    }
}

class IfStatNode extends SeleStatNode {
    IfStatNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<IfStatNode> name: " + name + " type: " + type.toString());
    }
}

class IfElseStatNode extends SeleStatNode {
    IfElseStatNode(){
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<IfElseStatNode> name: " + name + " type: " + type.toString());
    }
}

abstract class IterStatNode extends StatNode {
    IterStatNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<IterStatNode> name: " + name + " type: " + type.toString());
    }
}

class ForStatNode extends IterStatNode {
    ForStatNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<ForStatNode> name: " + name + " type: " + type.toString());
    }
}

class WhileStatNode extends IterStatNode {
    WhileStatNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<WhileStatNode> name: " + name + " type: " + type.toString());
    }
}

abstract class JumpStatNode extends StatNode {
    JumpStatNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<JumpStatNode> name: " + name + " type: " + type.toString());
    }
}

class ReturnStatNode extends JumpStatNode {
    ReturnStatNode(){
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<ReturnStatNode> name: " + name + " type: " + type.toString());
    }
}

class BreakStatNode extends JumpStatNode {
    BreakStatNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<BreakStatNode> name: " + name + " type: " + type.toString());
    }
}

class ContinueStatNode extends JumpStatNode {
    ContinueStatNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<ContinueStatNode> name: " + name + " type: " + type.toString());
    }
}

class EmptyStatNode extends StatNode {
    EmptyStatNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<EmptyStatNode> name: " + name + " type: " + type.toString());
    }
}

class VarDefStatNode extends StatNode {
    VarDefStatNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<VarDefStatNode> name: " + name + " type: " + type.toString());
    }
}

abstract class ExprNode extends Node {
    ExprNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<ExprNode> name: " + name + " type: " + type.toString());
    }
}

class EmptyExprNode extends ExprNode {
    EmptyExprNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<EmptyExprNode> name: " + name + " type: " + type.toString());
    }
}

class BinaryExprNode extends ExprNode {
    BinaryExprNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<BinaryExprNode> name: " + name + " type: " + type.toString());
    }
}

abstract class UnaryExprNode extends ExprNode {
    UnaryExprNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<UnaryExprNode> name: " + name + " type: " + type.toString());
    }
}

class LeftUnaryExprNode extends UnaryExprNode {
    LeftUnaryExprNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<LeftUnaryExprNode> name: " + name + " type: " + type.toString());
    }
}

class RightUnaryExprNode extends UnaryExprNode {
    RightUnaryExprNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<RightUnaryExprNode> name: " + name + " type: " + type.toString());
    }
}

class NewExprNode extends ExprNode {
    NewExprNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<NewExprNode> name: " + name + " type: " + type.toString());
    }
}

class TypeExprNode extends ExprNode {
    TypeExprNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<TypeExprNode> name: " + name + " type: " + type.toString());
    }
}

abstract class PrimExprNode extends ExprNode {
    PrimExprNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<PrimExprNode> name: " + name + " type: " + type.toString());
    }
}

class FuncExprNode extends PrimExprNode {
    FuncExprNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<FuncExprNode> name: " + name + " type: " + type.toString());
    }
}

class ArrExprNode extends PrimExprNode {
    ArrExprNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<ArrExprNode> name: " + name + " type: " + type.toString());
    }
}

class ObjExprNode extends PrimExprNode {
    ObjExprNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<ObjExprNode> name: " + name + " type: " + type.toString());
    }
}

class VarExprNode extends PrimExprNode {
    VarExprNode(){
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<VarExprNode> name: " + name + " type: " + type.toString());
    }
}

abstract class LiteralNode extends ExprNode {
    LiteralNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<LiteralNode> name: " + name + " type: " + type.toString());
    }
}

abstract class ArithmeticLiteralNode extends LiteralNode {
    ArithmeticLiteralNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<ArithmeticLiteralNode> name: " + name + " type: " + type.toString());
    }
}

class IntLiteralNode extends ArithmeticLiteralNode {
    IntLiteralNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<IntLiteralNode> name: " + name + " type: " + type.toString());
    }
}

class BoolLiteralNode extends ArithmeticLiteralNode {
    BoolLiteralNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<BoolLiteralNode> name: " + name + " type: " + type.toString());
    }
}

class NullLiteralNode extends LiteralNode {
    NullLiteralNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<NullLiteralNode> name: " + name + " type: " + type.toString());
    }
}

class StringLiteralNode extends LiteralNode {
    StringLiteralNode() {
        super();
    }

    void print(String indentation) {
        System.out.println(indentation + "<StringLiteralNode> name: " + name + " type: " + type.toString());
    }
}