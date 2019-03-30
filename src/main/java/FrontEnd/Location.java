package main.java.FrontEnd;

import org.antlr.v4.runtime.Token;

public class Location {
    public int line, column;

    public Location(int l, int c) {
        line = l;
        column = c;
    }

    public Location(Location tmp) {
        line = tmp.line;
        column = tmp.column;
    }

    public Location(Token tmp) {
        line = tmp.getLine();
        column = tmp.getCharPositionInLine();
    }

    public String toString() {
        return "(" + line + "," + column + ")";
    }
}
