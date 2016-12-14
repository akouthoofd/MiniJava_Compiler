package my.mini.java.compiler.AST.nodes.statements.exprs;

import my.mini.java.compiler.AST.nodes.statements.exprs.atoms.AtomNode;

/**
 * Created by alex on 11/28/2016.
 */
public class ArrayAccessExprNode extends ExprNode
{
    public AtomNode varName;
    public ExprNode element;

    public ArrayAccessExprNode (AtomNode varName, ExprNode element)
    {
        this.varName = varName;
        this.element = element;
    }
}
