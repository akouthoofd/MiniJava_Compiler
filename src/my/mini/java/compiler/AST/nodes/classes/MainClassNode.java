package my.mini.java.compiler.AST.nodes.classes;

import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;
import my.mini.java.compiler.AST.nodes.methods.MethodNode;
import my.mini.java.compiler.AST.nodes.methods.OverloadMethodNode;
import my.mini.java.compiler.AST.nodes.statements.StatementNode;
import my.mini.java.compiler.AST.nodes.type.ClassTypeNode;
import my.mini.java.compiler.AST.nodes.variable.VarDeclarationNode;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 11/28/2016.
 */
public class MainClassNode extends ClassNode
{
    public Token mainArg;
    public IdLiteralNode paramName;
    public ArrayList<VarDeclarationNode> varDeclarationNodes;
    public ArrayList<StatementNode> statementNodes;

    public MainClassNode(IdLiteralNode className, IdLiteralNode paramName, Token mainArg)
    {
        this.className = className;
        this.paramName = paramName;
        this.mainArg = mainArg;
        type = new ClassTypeNode(className);
        varDeclarationNodes = new ArrayList<>();
        statementNodes = new ArrayList<>();
    }

    @Override
    public MethodNode methodLookup(String methodName)
    {
        return null;
    }

    @Override
    public List<MethodNode> advancedMethodLookup(String methodName)
    {
        return null;
    }

    @Override
    public OverloadMethodNode operatorMethodLookup(String methodName)
    {
        return null;
    }

    @Override
    public VarDeclarationNode varLookup(String varName)
    {
        return null;
    }
}
