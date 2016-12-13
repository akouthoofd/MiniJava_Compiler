package my.mini.java.compiler.AST.nodes.program;

import my.mini.java.compiler.AST.nodes.Node;
import my.mini.java.compiler.AST.nodes.classes.ClassNode;
import my.mini.java.compiler.AST.nodes.classes.MainClassNode;

import java.util.ArrayList;

/**
 * Created by alex on 11/28/2016.
 */
public class ProgramNode extends Node
{
    public MainClassNode mainClassNode;
    public ArrayList<ClassNode> classNodes;

    public ProgramNode (MainClassNode node)
    {
        mainClassNode = node;
        classNodes = new ArrayList<>();
    }
}
