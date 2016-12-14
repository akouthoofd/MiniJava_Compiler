package my.mini.java.compiler.AST.nodes.statements.exprs.math;

import my.mini.java.compiler.AST.nodes.Node;

/**
 * Created by alex on 11/28/2016.
 */
public class MinusMathNode extends MathNode
{
    public MinusMathNode(Node leftMathNode, Node rightMathNode)
    {
        super(leftMathNode, rightMathNode);
    }
}
