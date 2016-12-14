package my.mini.java.compiler.AST.nodes.type;

import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;

/**
 * Created by alex on 11/28/2016.
 */
public class ObjectTypeNode extends TypeNode
{
    public ObjectTypeNode (IdLiteralNode type)
    {
        this.type = type;
    }
}
