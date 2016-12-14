package my.mini.java.compiler.AST.nodes.type;

import my.mini.java.compiler.AST.nodes.Node;
import my.mini.java.compiler.AST.nodes.classes.ChildClassNode;
import my.mini.java.compiler.AST.nodes.classes.ClassNode;
import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;
import org.antlr.v4.runtime.Token;

import java.util.List;

/**
 * Created by alex on 11/28/2016.
 */
public class TypeNode extends Node
{
    public static List<ClassNode> classes;
    public Token loc;
    public IdLiteralNode type;

    public boolean matches(TypeNode typeNode)
    {
        if (getType().equals(typeNode.getType()))
            return true;
        else
        {
            for (ClassNode classNode: classes)
            {
                if (getType().equals(classNode.className.valueString)
                        && classNode instanceof ChildClassNode
                        && ((ChildClassNode) classNode).parentClass.type.matches(typeNode))
                    return true;
            }
            return false;
        }
    }
    public String getType()
    {
        return type.valueString;
    }
    public String toString(String name)
    {
        return type.valueString + " " + name;
    }
}
