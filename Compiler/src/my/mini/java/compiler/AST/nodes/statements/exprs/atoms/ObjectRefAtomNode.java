package my.mini.java.compiler.AST.nodes.statements.exprs.atoms;

import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;
import my.mini.java.compiler.AST.nodes.statements.exprs.ExprNode;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by alex on 11/28/2016.
 */
public class ObjectRefAtomNode extends AtomNode
{
    public IdLiteralNode varName;
    public Optional<IdLiteralNode> methodName;
    public Optional<ArrayList<ExprNode>> expressions;

    public ObjectRefAtomNode (IdLiteralNode varName)
    {
        this(varName, null, null);
    }

    public ObjectRefAtomNode (IdLiteralNode varName, IdLiteralNode methodName, ArrayList<ExprNode> expressions)
    {
        this.varName = varName;
        this.methodName = (methodName != null) ? Optional.of(methodName): Optional.empty();
        this.expressions = (expressions != null) ? Optional.of(expressions): Optional.empty();
    }

    public void setMethodName(IdLiteralNode methodName)
    {
        this.methodName = Optional.of(methodName);
    }

    public void setExpressions(ArrayList<ExprNode> expressions)
    {
        this.expressions = Optional.of(expressions);
    }
}
