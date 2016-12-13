package my.mini.java.compiler.AST.nodes.literals;

import org.antlr.v4.runtime.Token;

/**
 * Created by alex on 11/28/2016.
 */
public class IntLiteralNode extends LiteralNode
{
    public Token value;

    public IntLiteralNode(Token value)
    {
        this.value = value;
    }
}
