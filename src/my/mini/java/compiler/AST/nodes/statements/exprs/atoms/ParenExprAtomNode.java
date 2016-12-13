package my.mini.java.compiler.AST.nodes.statements.exprs.atoms;

import my.mini.java.compiler.AST.nodes.statements.exprs.ExprNode;

/**
 * Created by alex on 11/28/2016.
 */
public class ParenExprAtomNode extends AtomNode
{
    public ExprNode expression;

    public ParenExprAtomNode (ExprNode expression)
    {
        this.expression = expression;
    }
}
