package my.mini.java.compiler.AST.nodes.statements.assertions;

import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;
import my.mini.java.compiler.AST.nodes.statements.exprs.ExprNode;

/**
 * Created by alex on 11/28/2016.
 */
public class AssignAssertNode extends AssertNode
{
    public IdLiteralNode varName;

    public AssignAssertNode (IdLiteralNode varName, ExprNode expression)
    {
        this.varName = varName;
        this.expression = expression;
    }
}
