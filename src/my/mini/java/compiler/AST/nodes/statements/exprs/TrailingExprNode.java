package my.mini.java.compiler.AST.nodes.statements.exprs;

import my.mini.java.compiler.AST.Operators;
import my.mini.java.compiler.AST.nodes.Node;

/**
 * Created by alex on 11/28/2016.
 */
public class TrailingExprNode extends ExprNode
{
    public Operators operator;
    public Node atom;

    public TrailingExprNode (Operators operator, Node atom)
    {
        this.operator = operator;
        this.atom = atom;
    }
}
