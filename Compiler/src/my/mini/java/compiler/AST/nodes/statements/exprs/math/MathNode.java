package my.mini.java.compiler.AST.nodes.statements.exprs.math;

import my.mini.java.compiler.AST.nodes.Node;
import my.mini.java.compiler.AST.nodes.statements.exprs.ExprNode;

/**
 * Created by alex on 11/28/2016.
 */
public abstract class MathNode extends ExprNode
{
    public Node leftMathNode;
    public Node rightMathNode;

    public MathNode (Node leftMathNode, Node rightMathNode)
    {
        this.leftMathNode = leftMathNode;
        this.rightMathNode = rightMathNode;
    }
}
