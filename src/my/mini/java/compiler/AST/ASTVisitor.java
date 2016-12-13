package my.mini.java.compiler.AST;

import my.mini.java.compiler.AST.nodes.Node;
import my.mini.java.compiler.AST.nodes.classes.ChildClassNode;
import my.mini.java.compiler.AST.nodes.classes.MainClassNode;
import my.mini.java.compiler.AST.nodes.classes.SimpleClassNode;
import my.mini.java.compiler.AST.nodes.formal_list.ParameterNode;
import my.mini.java.compiler.AST.nodes.literals.BooleanLiteralNode;
import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;
import my.mini.java.compiler.AST.nodes.literals.IntLiteralNode;
import my.mini.java.compiler.AST.nodes.methods.BasicMethodNode;
import my.mini.java.compiler.AST.nodes.methods.OverloadMethodNode;
import my.mini.java.compiler.AST.nodes.program.ProgramNode;
import my.mini.java.compiler.AST.nodes.statements.assertions.ArrayAssignAssertNode;
import my.mini.java.compiler.AST.nodes.statements.assertions.AssignAssertNode;
import my.mini.java.compiler.AST.nodes.statements.assertions.PrintAssertNode;
import my.mini.java.compiler.AST.nodes.statements.branches.IfBranchNode;
import my.mini.java.compiler.AST.nodes.statements.branches.LoopBranchNode;
import my.mini.java.compiler.AST.nodes.statements.branches.ScopeBranchNode;
import my.mini.java.compiler.AST.nodes.statements.branches.conditions.AndConditionNode;
import my.mini.java.compiler.AST.nodes.statements.branches.conditions.LessThanConditionNode;
import my.mini.java.compiler.AST.nodes.statements.branches.conditions.NestedConditionNode;
import my.mini.java.compiler.AST.nodes.statements.branches.conditions.NotConditionNode;
import my.mini.java.compiler.AST.nodes.statements.exprs.*;
import my.mini.java.compiler.AST.nodes.statements.exprs.atoms.*;
import my.mini.java.compiler.AST.nodes.statements.exprs.math.MinusMathNode;
import my.mini.java.compiler.AST.nodes.statements.exprs.math.MultMathNode;
import my.mini.java.compiler.AST.nodes.statements.exprs.math.PlusMathNode;
import my.mini.java.compiler.AST.nodes.variable.VarDeclarationNode;
import my.mini.java.compiler.Exceptions.IllegalNodeException;

/**
 * Created by alex on 11/28/2016.
 */
public abstract class ASTVisitor<T>
{
    // program
    public abstract T visit(ProgramNode node);

    // classes
    public abstract T visit(MainClassNode node);

    public abstract T visit(SimpleClassNode node);

    public abstract T visit(ChildClassNode node);

    // methods
    public abstract T visit(BasicMethodNode node);

    public abstract T visit(OverloadMethodNode node);

    // formal list
    public abstract T visit(ParameterNode node);

    // variable
    public abstract T visit(VarDeclarationNode node);

    // literals
    public abstract T visit(BooleanLiteralNode node);

    public abstract T visit(IdLiteralNode node);

    public abstract T visit(IntLiteralNode node);

    // assertions
    public abstract T visit(ArrayAssignAssertNode node);

    public abstract T visit(AssignAssertNode node);

    public abstract T visit(PrintAssertNode node);

    // conditions
    public abstract T visit(AndConditionNode node);

    public abstract T visit(LessThanConditionNode node);

    public abstract T visit(NotConditionNode node);

    public abstract T visit(NestedConditionNode node);

    // branches
    public abstract T visit(IfBranchNode node);

    public abstract T visit(LoopBranchNode node);

    public abstract T visit(ScopeBranchNode node);

    // atoms
    public abstract T visit(InstatiateAtomNode node);

    public abstract T visit(NewIntArrayAtomNode node);

    public abstract T visit(ParenExprAtomNode node);

    public abstract T visit(RefThisAtomNode node);

    public abstract T visit(ObjectRefAtomNode node);

    // math
    public abstract T visit(MinusMathNode node);

    public abstract T visit(MultMathNode node);

    public abstract T visit(PlusMathNode node);

    // expressions
    public abstract T visit(ArrayAccessExprNode node);

    public abstract T visit(ArrayLengthExprNode node);

    public abstract T visit(CalcExprNode node);

    public abstract T visit(MethodCallExprNode node);

    public abstract T visit(TrailingExprNode node);


    public T visit(Node node)
    {
        if (node instanceof ProgramNode)
            return visit((ProgramNode)node);
        else if (node instanceof ParameterNode)
            return visit((ParameterNode)node);
        else if (node instanceof VarDeclarationNode)
            return visit((VarDeclarationNode)node);
        else if (node instanceof MainClassNode)
            return visit((MainClassNode)node);
        else if (node instanceof SimpleClassNode)
            return visit((SimpleClassNode)node);
        else if (node instanceof ChildClassNode)
            return visit((ChildClassNode)node);
        else if (node instanceof BooleanLiteralNode)
            return visit((BooleanLiteralNode)node);
        else if (node instanceof IdLiteralNode)
            return visit((IdLiteralNode)node);
        else if (node instanceof IntLiteralNode)
            return visit((IntLiteralNode)node);
        else if (node instanceof BasicMethodNode)
            return visit((BasicMethodNode)node);
        else if (node instanceof OverloadMethodNode)
            return visit((OverloadMethodNode)node);
        else if (node instanceof ArrayAssignAssertNode)
            return visit((ArrayAssignAssertNode)node);
        else if (node instanceof AssignAssertNode)
            return visit((AssignAssertNode)node);
        else if (node instanceof PrintAssertNode)
            return visit((PrintAssertNode)node);
        else if (node instanceof AndConditionNode)
            return visit((AndConditionNode)node);
        else if (node instanceof LessThanConditionNode)
            return visit((LessThanConditionNode)node);
        else if (node instanceof NotConditionNode)
            return visit((NotConditionNode)node);
        else if (node instanceof NestedConditionNode)
            return visit((NestedConditionNode)node);
        else if (node instanceof IfBranchNode)
            return visit((IfBranchNode)node);
        else if (node instanceof LoopBranchNode)
            return visit((LoopBranchNode)node);
        else if (node instanceof ScopeBranchNode)
            return visit((ScopeBranchNode)node);
        else if (node instanceof InstatiateAtomNode)
            return visit((InstatiateAtomNode)node);
        else if (node instanceof NewIntArrayAtomNode)
            return visit((NewIntArrayAtomNode)node);
        else if (node instanceof ObjectRefAtomNode)
            return visit((ObjectRefAtomNode)node);
        else if (node instanceof ParenExprAtomNode)
            return visit((ParenExprAtomNode)node);
        else if (node instanceof RefThisAtomNode)
            return visit((RefThisAtomNode)node);
        else if (node instanceof MinusMathNode)
            return visit((MinusMathNode)node);
        else if (node instanceof MultMathNode)
            return visit((MultMathNode)node);
        else if (node instanceof PlusMathNode)
            return visit((PlusMathNode)node);
        else if (node instanceof ArrayAccessExprNode)
            return visit((ArrayAccessExprNode)node);
        else if (node instanceof ArrayLengthExprNode)
            return visit((ArrayLengthExprNode)node);
        else if (node instanceof CalcExprNode)
            return visit((CalcExprNode)node);
        else if (node instanceof MethodCallExprNode)
            return visit((MethodCallExprNode)node);
        else if (node instanceof TrailingExprNode)
            return visit((TrailingExprNode)node);
        else
            throw new IllegalNodeException(node.getClass() + " shouldn't even exist.");
    }
}