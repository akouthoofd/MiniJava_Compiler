package my.mini.java.compiler.AST.nodes.statements.exprs;

import my.mini.java.compiler.AST.nodes.statements.exprs.atoms.AtomNode;

/**
 * Created by alex on 11/28/2016.
 */
public class ArrayLengthExprNode extends ExprNode
{
    public AtomNode arrayVar;

    public ArrayLengthExprNode (AtomNode arrayVar)
    {
        this.arrayVar = arrayVar;
    }
}
