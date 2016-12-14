package my.mini.java.compiler.AST.nodes.statements.assertions;

import my.mini.java.compiler.AST.nodes.statements.StatementNode;
import my.mini.java.compiler.AST.nodes.statements.exprs.ExprNode;

/**
 * Created by alex on 11/28/2016.
 */
public abstract class AssertNode extends StatementNode
{
    public ExprNode expression;
}
