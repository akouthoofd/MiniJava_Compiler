package my.mini.java.compiler.AST.declaration;

import my.mini.java.compiler.AST.nodes.statements.exprs.ExprNode;
import my.mini.java.compiler.AST.nodes.type.TypeNode;

/**
 * Created by alex on 11/30/2016.
 */
public class ConstantDeclaration extends Declaration
{
    public ExprNode value;

    public ConstantDeclaration(TypeNode typeDeclaration, ExprNode expression)
    {
        declaration = typeDeclaration;
        value = expression;
    }
}
