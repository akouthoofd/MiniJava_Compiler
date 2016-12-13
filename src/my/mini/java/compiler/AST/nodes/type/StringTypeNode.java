package my.mini.java.compiler.AST.nodes.type;

import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;

/**
 * Created by alex on 12/2/2016.
 */
public class StringTypeNode extends TypeNode
{
    public StringTypeNode (IdLiteralNode type)
    {
        this.type = type;
        loc = type.value;
    }

    public String toString(String name)
    {
        return type.value.getText() + "[] " + name;
    }
}
