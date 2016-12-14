package my.mini.java.compiler.AST.nodes.variable;

import my.mini.java.compiler.AST.nodes.Node;
import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;
import my.mini.java.compiler.AST.nodes.type.TypeNode;

/**
 * Created by alex on 11/28/2016.
 */
public class VarDeclarationNode extends Node
{
    public TypeNode type;
    public IdLiteralNode varName;

    public VarDeclarationNode (TypeNode type, IdLiteralNode varName)
    {
        this.type = type;
        this.varName = varName;
    }
}
