package my.mini.java.compiler.AST.nodes.type;

import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;
import org.antlr.v4.runtime.Token;

/**
 * Created by alex on 11/28/2016.
 */
public class IntArrayTypeNode extends TypeNode
{
    public IntArrayTypeNode(Token type)
    {
        this.type = new IdLiteralNode("int[]");
        this.type.value = type;
        loc = type;
    }
}
