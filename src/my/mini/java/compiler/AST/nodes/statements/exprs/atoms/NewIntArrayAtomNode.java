package my.mini.java.compiler.AST.nodes.statements.exprs.atoms;

import my.mini.java.compiler.AST.nodes.statements.exprs.ExprNode;
import org.antlr.v4.runtime.Token;

/**
 * Created by alex on 11/28/2016.
 */
public class NewIntArrayAtomNode extends AtomNode
{
    public ExprNode size;
    public Token loc;

    public NewIntArrayAtomNode (ExprNode size, Token loc)
    {
        this.size = size;
        this.loc = loc;
    }
}
