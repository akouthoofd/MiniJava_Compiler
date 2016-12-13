package my.mini.java.compiler.AST.nodes.statements.assertions;

import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;
import my.mini.java.compiler.AST.nodes.literals.LiteralNode;
import my.mini.java.compiler.AST.nodes.statements.exprs.ExprNode;

/**
 * Created by alex on 11/28/2016.
 */
public class ArrayAssignAssertNode extends AssertNode
{
    public IdLiteralNode varName;
    public LiteralNode element;

    public ArrayAssignAssertNode (IdLiteralNode varName, LiteralNode element, ExprNode expression)
    {
        this.varName = varName;
        this.element = element;
        this.expression = expression;
    }
}
