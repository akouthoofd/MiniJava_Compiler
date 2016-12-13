package my.mini.java.compiler.AST.nodes.statements.assertions;

import my.mini.java.compiler.AST.nodes.statements.exprs.ExprNode;
import org.antlr.v4.runtime.Token;

/**
 * Created by alex on 11/28/2016.
 */
public class PrintAssertNode extends AssertNode
{
    public Token location;

    public PrintAssertNode(Token location, ExprNode expression)
    {
        this.location = location;
        this.expression = expression;
    }
}
