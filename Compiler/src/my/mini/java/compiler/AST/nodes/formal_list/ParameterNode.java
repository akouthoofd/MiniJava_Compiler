package my.mini.java.compiler.AST.nodes.formal_list;

import my.mini.java.compiler.AST.nodes.Node;
import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;
import my.mini.java.compiler.AST.nodes.type.TypeNode;

/**
 * Created by alex on 11/28/2016.
 */
public class ParameterNode extends Node
{
    public TypeNode type;
    public IdLiteralNode name;

    public ParameterNode(TypeNode type, IdLiteralNode name)
    {
        this.type = type;
        this.name = name;
    }
}
