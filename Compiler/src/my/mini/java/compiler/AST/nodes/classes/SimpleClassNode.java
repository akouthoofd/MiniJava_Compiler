package my.mini.java.compiler.AST.nodes.classes;

import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;
import my.mini.java.compiler.AST.nodes.methods.BasicMethodNode;
import my.mini.java.compiler.AST.nodes.methods.MethodNode;
import my.mini.java.compiler.AST.nodes.methods.OverloadMethodNode;
import my.mini.java.compiler.AST.nodes.type.ClassTypeNode;
import my.mini.java.compiler.AST.nodes.variable.VarDeclarationNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 11/28/2016.
 */
public class SimpleClassNode extends ClassNode
{
    public ArrayList<VarDeclarationNode> varDeclarationNodes;
    public ArrayList<BasicMethodNode> methodNodes;
    public ArrayList<OverloadMethodNode> operatorNodes;

    public SimpleClassNode (IdLiteralNode className)
    {
        this.className = className;
        type = new ClassTypeNode(className);
        varDeclarationNodes = new ArrayList<>();
        methodNodes = new ArrayList<>();
        operatorNodes  = new ArrayList<>();
    }

    @Override
    public MethodNode methodLookup(String methodName)
    {
        for (BasicMethodNode method: methodNodes)
        {
            if (method.name.value.getText().equals(methodName))
            {
                visited.clear();
                return method;
            }

        }
        return null;
    }

    @Override
    public List<MethodNode> advancedMethodLookup(String methodName)
    {
        for (BasicMethodNode method: methodNodes)
        {
            if (method.name.value.getText().equals(methodName))
            {
                visited.clear();
                methods.add(method);
            }

        }
        visited.clear();
        return methods;
    }

    @Override
    public OverloadMethodNode operatorMethodLookup(String methodName)
    {
        for (OverloadMethodNode method: operatorNodes)
        {
            if (method.methodName.equals(methodName))
            {
                visited.clear();
                return method;
            }
        }
        return null;
    }

    @Override
    public VarDeclarationNode varLookup(String varName)
    {
        for (VarDeclarationNode varDeclarationNode : varDeclarationNodes)
            if (varDeclarationNode.varName.valueString.equals(varName))
                return varDeclarationNode;
        return null;
    }
}
