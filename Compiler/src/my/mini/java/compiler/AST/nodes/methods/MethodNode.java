package my.mini.java.compiler.AST.nodes.methods;

import my.mini.java.compiler.AST.nodes.Node;
import my.mini.java.compiler.AST.nodes.statements.StatementNode;
import my.mini.java.compiler.AST.nodes.statements.exprs.ExprNode;
import my.mini.java.compiler.AST.nodes.type.TypeNode;
import my.mini.java.compiler.AST.nodes.variable.VarDeclarationNode;

import java.util.ArrayList;

/**
 * Created by alex on 11/28/2016.
 */
public abstract class MethodNode extends Node
{
    public String methodName;
    public TypeNode typeNode;
    public ArrayList<VarDeclarationNode> varDeclarationNodes;
    public ArrayList<StatementNode> statementNodes;
    public ExprNode returnExpression;
}
