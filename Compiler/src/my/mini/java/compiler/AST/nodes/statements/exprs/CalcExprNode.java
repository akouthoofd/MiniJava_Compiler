package my.mini.java.compiler.AST.nodes.statements.exprs;

import my.mini.java.compiler.AST.nodes.statements.exprs.math.MathNode;

/**
 * Created by alex on 11/28/2016.
 */
public class CalcExprNode extends ExprNode
{
    public MathNode mathCalculation;

    public CalcExprNode (MathNode mathCalculation)
    {
        this.mathCalculation = mathCalculation;
    }
}
