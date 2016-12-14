package my.mini.java.compiler.AST.nodes.literals;

import org.antlr.v4.runtime.Token;

/**
 * Created by alex on 11/28/2016.
 */
public class IdLiteralNode extends LiteralNode
{
    public Token value;
    public String valueString;

    public IdLiteralNode(Token value)
    {
        this.value = value;
        if (value != null)
            valueString = value.getText();
    }

    public IdLiteralNode (String valueString)
    {
        this.valueString = valueString;
    }
}
