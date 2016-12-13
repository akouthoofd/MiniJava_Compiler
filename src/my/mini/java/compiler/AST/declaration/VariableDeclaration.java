package my.mini.java.compiler.AST.declaration;

import my.mini.java.compiler.AST.nodes.type.TypeNode;

/**
 * Created by alex on 11/30/2016.
 */
public class VariableDeclaration extends Declaration
{
    public VariableDeclaration(TypeNode typeDeclaration)
    {
        declaration = typeDeclaration;
    }
}
