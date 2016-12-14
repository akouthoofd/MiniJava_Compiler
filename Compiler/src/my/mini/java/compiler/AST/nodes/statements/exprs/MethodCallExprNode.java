package my.mini.java.compiler.AST.nodes.statements.exprs;

import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;
import my.mini.java.compiler.AST.nodes.statements.exprs.atoms.AtomNode;

import java.util.ArrayList;

/**
 * Created by alex on 11/28/2016.
 */
public class MethodCallExprNode extends ExprNode
{
    public AtomNode objectName;
    public IdLiteralNode methodName;
    public ArrayList<ExprNode> expressions;

    public MethodCallExprNode (AtomNode objectName, IdLiteralNode methodName)
    {
        this.objectName = objectName;
        this.methodName = methodName;
        expressions = new ArrayList<>();
    }
}
