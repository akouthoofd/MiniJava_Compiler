package my.mini.java.compiler.AST.nodes.type;

import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;

/**
 * Created by alex on 12/2/2016.
 */
public class ThisTypeNode extends TypeNode
{
    public ThisTypeNode (IdLiteralNode type)
    {
        this.type = type;
    }

    public String toString(String name)
    {
        return "this." + name;
    }
}
