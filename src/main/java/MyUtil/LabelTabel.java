package main.java.MyUtil;

import java.util.ArrayList;

public class LabelTabel {
    ArrayList<String> a;

    public void set(int x, String s) {
        a.set(x, s);
    }

    public void expand(int n) {
        while(a.size() < n)a.add(null);
    }
}
