package my.mini.java.compiler.AST.nodes.classes;

import my.mini.java.compiler.AST.nodes.Node;
import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;
import my.mini.java.compiler.AST.nodes.methods.MethodNode;
import my.mini.java.compiler.AST.nodes.methods.OverloadMethodNode;
import my.mini.java.compiler.AST.nodes.type.TypeNode;
import my.mini.java.compiler.AST.nodes.variable.VarDeclarationNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 11/28/2016.
 */
public abstract class ClassNode extends Node
{
    protected static ArrayList<String> visited = new ArrayList<>();
    protected static ArrayList<MethodNode> methods = new ArrayList<>();
    public IdLiteralNode className;
    public TypeNode type;

    public abstract MethodNode methodLookup(String methodName);
    public abstract List<MethodNode> advancedMethodLookup(String methodName);
    public void clearMethods() { methods.clear(); }
    public abstract OverloadMethodNode operatorMethodLookup(String methodName);
    public abstract VarDeclarationNode varLookup(String varName);
}
