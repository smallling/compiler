package main.java.FrontEnd;

public class TestAst {
    public void dfs(Node root, String tab) {
        root.print(tab);
        for(int i = 0; i < root.sonSize(); i++)
            dfs(root.sonAt(i), tab + '\t');
    }
}
