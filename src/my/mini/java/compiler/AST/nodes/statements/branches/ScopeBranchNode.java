package my.mini.java.compiler.AST.nodes.statements.branches;

import my.mini.java.compiler.AST.nodes.statements.StatementNode;

import java.util.ArrayList;

/**
 * Created by alex on 11/28/2016.
 */
public class ScopeBranchNode extends BranchedNode
{
    public ArrayList<StatementNode> statementNodes;

    public ScopeBranchNode ()
    {
        statementNodes = new ArrayList<>();
    }
}
