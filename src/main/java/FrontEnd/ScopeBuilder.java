package main.java.FrontEnd;

import main.java.MyUtil.ScopeClass.*;
import main.java.MyUtil.TypeSystem.*;

public class ScopeBuilder {
    public GeneralScope<TypeRef> root = new GeneralScope<>(null, "");

    void init(){
        ClassDefTypeRef stringType = new ClassDefTypeRef();
        stringType.insert("length", new FuncTypeRef(new IntTypeRef()));
        stringType.insert("substring", new FuncTypeRef(new StringTypeRef(), new IntTypeRef(), new IntTypeRef()));
        stringType.insert("parseInt", new FuncTypeRef(new IntTypeRef()));
        stringType.insert("ord", new FuncTypeRef(new IntTypeRef(), new IntTypeRef()));
        root.addIteam("string", stringType);

        root.addIteam("print", new FuncTypeRef(new VoidTypeRef(), new StringTypeRef()));

        root.addIteam("println", new FuncTypeRef(new VoidTypeRef(), new StringTypeRef()));

        root.addIteam("getString", new FuncTypeRef(new StringTypeRef()));

        root.addIteam("getInt", new FuncTypeRef(new IntTypeRef()));

        root.addIteam("toString", new FuncTypeRef(new StringTypeRef(), new IntTypeRef()));
    }

    void dfsLocalScope(LocalScope<TypeRef> curScope, Node curNode) {
        curNode.belong = curScope;
        for(int i = 0; i < curNode.son.size(); i++) {
            Node sonNode = curNode.son.get(i);
            if(sonNode instanceof CompStatNode) {
                LocalScope<TypeRef> sonScope = Scope.newLocalScope(curScope);
                dfsLocalScope(sonScope, sonNode);
            }
            else {
                dfsLocalScope(curScope, sonNode);
            }
        }
    }

    void dfsSpecialScope(SpecialScope<TypeRef> curScope, Node curNode) throws SyntaxError {
        curNode.belong = curScope;
        for(int i = 0; i < curNode.son.size(); i++) {
            Node sonNode = curNode.son.get(i);
            if(sonNode instanceof ClassDefNode) {
                ClassScope<TypeRef> sonScope = Scope.newClassScope(curScope);
                dfsSpecialScope(sonScope, sonNode);
                ClassDefTypeRef tmpClass = new ClassDefTypeRef(sonScope.table.getHashMap());
                if(!curScope.addIteam(sonNode.name, tmpClass)) throw new ReDefinedError(sonNode.loc);
            }
            else if(sonNode instanceof FuncDefNode) {
                //FuncDefNode tmpNode = (FuncDefNode) sonNode;
                sonNode.belong = curScope;
                FuncTypeRef func = new FuncTypeRef((VarTypeRef)sonNode.type);
                LocalScope<TypeRef> sonScope = Scope.newLocalScope(curScope);
                for(int j = 0; j < sonNode.son.size() - 1; j++) {
                    VarDefNode tmpNode = (VarDefNode) sonNode.son.get(j);
                    tmpNode.belong = sonScope;
                    func.addParam((VarTypeRef) tmpNode.type);
                }
                if(!curScope.addIteam(sonNode.name, func)) throw new ReDefinedError(sonNode.loc);
                dfsLocalScope(sonScope, sonNode.son.get(sonNode.son.size() - 1));
            }
            else if(sonNode instanceof VarDefNode) {
                dfsSpecialScope(curScope, sonNode);
                if((curScope instanceof ClassScope) && !curScope.addIteam(sonNode.name, sonNode.type))throw new ReDefinedError(sonNode.loc);
            }
            else dfsSpecialScope(curScope, sonNode);
        }
    }

    public void work(Node astRoot) throws SyntaxError {
        init();
        dfsSpecialScope(root, astRoot);
        TypeRef curType = root.findItem("main");
        if(!(curType instanceof FuncTypeRef) || !(((FuncTypeRef) curType).getReturnType().equalsSingleType("int"))) throw new NoMainFuncError(new Location(0, 0));
    }
}
