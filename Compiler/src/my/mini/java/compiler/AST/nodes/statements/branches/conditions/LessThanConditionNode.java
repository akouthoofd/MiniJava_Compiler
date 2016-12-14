package my.mini.java.compiler.AST.nodes.statements.branches.conditions;

import my.mini.java.compiler.AST.nodes.Node;

/**
 * Created by alex on 11/28/2016.
 */
public class LessThanConditionNode extends ConditionNode
{
    public Node leftCondition;
    public Node rightCondition;

    public LessThanConditionNode(Node leftCondition, Node rightCondition)
    {
        this.leftCondition = leftCondition;
        this.rightCondition = rightCondition;
    }
}
