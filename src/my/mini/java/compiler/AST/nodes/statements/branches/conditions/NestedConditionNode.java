package my.mini.java.compiler.AST.nodes.statements.branches.conditions;

import my.mini.java.compiler.AST.nodes.Node;

/**
 * Created by alex on 11/28/2016.
 */
public class NestedConditionNode extends ConditionNode
{
    public Node condition;

    public NestedConditionNode (Node condition)
    {
        this.condition = condition;
    }
}
