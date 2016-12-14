package my.mini.java.compiler.AST.symbol;

import my.mini.java.compiler.AST.nodes.Node;
import my.mini.java.compiler.AST.nodes.type.EnterScopeNode;
import my.mini.java.compiler.AST.nodes.type.ExitScopeNode;
import my.mini.java.compiler.AST.nodes.type.TypeNode;
import org.antlr.v4.runtime.Token;

/**
 * Created by alex on 11/30/2016.
 */
public class Symbol
{
    public Token key;
    public TypeNode type;
    public Node node;
    public int level;

    public Symbol (Token key, TypeNode type, Node node)
    {
        this.key = key;
        this.type = type;
        this.node = node;
        level = 0;
    }

    @Override
    public String toString()
    {
        if (type == null)
            return "Enter Scope";
        if (type instanceof EnterScopeNode)
            return "Enter Scope ";// + level++;
        if (type instanceof ExitScopeNode)
            return "Exit Scope ";// + --level;
        return type.toString(key.getText());
    }
}
