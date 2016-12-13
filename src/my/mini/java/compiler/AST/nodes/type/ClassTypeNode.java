package my.mini.java.compiler.AST.nodes.type;

import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;

/**
 * Created by alex on 12/2/2016.
 */
public class ClassTypeNode extends TypeNode
{
    public ClassTypeNode (IdLiteralNode className)
    {
        this.type = className;
    }
}
