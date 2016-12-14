package my.mini.java.compiler.AST.nodes.literals;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;

/**
 * Created by alex on 11/28/2016.
 */
public class BooleanLiteralNode extends LiteralNode
{
    public Token value;
    public Token variablesValue;

    public BooleanLiteralNode(Token value)
    {
        this.value = value;
    }

    public BooleanLiteralNode(CommonToken aBoolean, Token varName)
    {
        this.value = aBoolean;
        this.variablesValue = varName;
    }
}
