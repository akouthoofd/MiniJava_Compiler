package my.mini.java.compiler.AST.declaration;

import my.mini.java.compiler.AST.nodes.type.TypeNode;

import java.util.List;

/**
 * Created by alex on 11/30/2016.
 */
public class MethodDeclaration extends Declaration
{
    public List<TypeNode> parameters;

    public MethodDeclaration(TypeNode typeDeclaration, List<TypeNode> parameterTypes)
    {
        declaration = typeDeclaration;
        this.parameters = parameterTypes;
    }
}
