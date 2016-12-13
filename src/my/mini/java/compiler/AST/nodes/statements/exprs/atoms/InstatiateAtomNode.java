package my.mini.java.compiler.AST.nodes.statements.exprs.atoms;

import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;

/**
 * Created by alex on 11/28/2016.
 */
public class InstatiateAtomNode extends AtomNode
{
    public IdLiteralNode className;

    public InstatiateAtomNode (IdLiteralNode className)
    {
        this.className = className;
    }
}
