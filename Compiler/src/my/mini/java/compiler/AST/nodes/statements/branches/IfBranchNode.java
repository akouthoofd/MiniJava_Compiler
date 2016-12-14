package my.mini.java.compiler.AST.nodes.statements.branches;

import my.mini.java.compiler.AST.nodes.statements.StatementNode;

/**
 * Created by alex on 11/28/2016.
 */
public class IfBranchNode extends BranchedNode
{
    public StatementNode condition;
    public StatementNode ifStatement;
    public StatementNode thenStatement;

    public IfBranchNode (StatementNode condition, StatementNode ifStatement, StatementNode thenStatement)
    {
        this.condition = condition;
        this.ifStatement = ifStatement;
        this.thenStatement = thenStatement;
    }
}
