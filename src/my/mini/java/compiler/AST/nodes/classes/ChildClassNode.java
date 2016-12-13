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
public class ChildClassNode extends ClassNode
{
    public ClassNode parentClass;
    public IdLiteralNode extendsClass;
    public ArrayList<VarDeclarationNode> varDeclarationNodes;
    public ArrayList<BasicMethodNode> methodNodes;
    public ArrayList<OverloadMethodNode> operatorNodes;

    public ChildClassNode(IdLiteralNode className, IdLiteralNode extendsClass)
    {
        this.className = className;
        this.extendsClass = extendsClass;
        type = new ClassTypeNode(className);
        varDeclarationNodes = new ArrayList<>();
        methodNodes = new ArrayList<>();
        operatorNodes = new ArrayList<>();
    }

    @Override
    public MethodNode methodLookup(String methodName)
    {
        if (visited.contains(className.value.getText()))
        {
            visited.clear();
            return null;
        }
        for (BasicMethodNode method: methodNodes)
            if (method.name.value.getText().equals(methodName))
            {
                visited.clear();
                return method;
            }
        if (parentClass == null)
            throw new RuntimeException("Parent class has not be set yet for the <" + className.value.getText() + "> child class.");
        visited.add(className.value.getText());
        return parentClass.methodLookup(methodName);
    }

    @Override
    public List<MethodNode> advancedMethodLookup(String methodName)
    {
        if (visited.contains(className.value.getText()))
        {
            visited.clear();
            return methods;
        }
        for (BasicMethodNode method: methodNodes)
            if (method.name.value.getText().equals(methodName))
            {
                visited.clear();
                methods.add(method);
            }
        if (parentClass == null)
            throw new RuntimeException("Parent class has not be set yet for the <" + className.value.getText() + "> child class.");
        visited.add(className.value.getText());
        return parentClass.advancedMethodLookup(methodName);
    }

    @Override
    public OverloadMethodNode operatorMethodLookup(String methodName)
    {
        if (visited.contains(className.value.getText()))
        {
            visited.clear();
            return null;
        }
        for (OverloadMethodNode method: operatorNodes)
            if (method.methodName.equals(methodName))
            {
                visited.clear();
                return method;
            }
        if (parentClass == null)
            throw new RuntimeException("Parent class has not be set yet for the <" + className.value.getText() + "> child class.");
        visited.add(className.value.getText());
        return parentClass.operatorMethodLookup(methodName);
    }

    @Override
    public VarDeclarationNode varLookup(String varName)
    {
        for (VarDeclarationNode varDeclarationNode : varDeclarationNodes)
            if (varDeclarationNode.varName.valueString.equals(varName))
                return varDeclarationNode;
        return parentClass.varLookup(varName);
    }
}
