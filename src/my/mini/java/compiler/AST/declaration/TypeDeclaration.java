package my.mini.java.compiler.AST.declaration;

import my.mini.java.compiler.AST.nodes.type.TypeNode;

/**
 * Created by alex on 11/30/2016.
 */
public class TypeDeclaration extends Declaration
{
    public TypeDeclaration(TypeNode typeDeclaration)
    {
        declaration = typeDeclaration;
    }
}
