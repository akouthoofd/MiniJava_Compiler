package my.mini.java.compiler.AST.nodes.statements.branches;

import my.mini.java.compiler.AST.nodes.statements.StatementNode;

/**
 * Created by alex on 11/28/2016.
 */
public class LoopBranchNode extends BranchedNode
{
    public StatementNode condition;
    public StatementNode statement;

    public LoopBranchNode (StatementNode condition, StatementNode statement)
    {
        this.condition = condition;
        this.statement = statement;
    }
}
