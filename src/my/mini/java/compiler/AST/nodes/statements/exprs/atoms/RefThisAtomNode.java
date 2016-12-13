package my.mini.java.compiler.AST.nodes.statements.exprs.atoms;

import my.mini.java.compiler.AST.nodes.type.TypeNode;

/**
 * Created by alex on 11/28/2016.
 */
public class RefThisAtomNode extends AtomNode
{
    public TypeNode type;

    public RefThisAtomNode (TypeNode type)
    {
        this.type = type;
    }
}
