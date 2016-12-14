package my.mini.java.compiler.AST;

import my.mini.java.compiler.AST.nodes.Node;
import my.mini.java.compiler.AST.nodes.classes.ChildClassNode;
import my.mini.java.compiler.AST.nodes.classes.ClassNode;
import my.mini.java.compiler.AST.nodes.classes.MainClassNode;
import my.mini.java.compiler.AST.nodes.classes.SimpleClassNode;
import my.mini.java.compiler.AST.nodes.formal_list.ParameterNode;
import my.mini.java.compiler.AST.nodes.literals.BooleanLiteralNode;
import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;
import my.mini.java.compiler.AST.nodes.literals.IntLiteralNode;
import my.mini.java.compiler.AST.nodes.literals.LiteralNode;
import my.mini.java.compiler.AST.nodes.methods.BasicMethodNode;
import my.mini.java.compiler.AST.nodes.methods.OverloadMethodNode;
import my.mini.java.compiler.AST.nodes.program.ProgramNode;
import my.mini.java.compiler.AST.nodes.statements.StatementNode;
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
import my.mini.java.compiler.AST.nodes.type.*;
import my.mini.java.compiler.AST.nodes.variable.VarDeclarationNode;
import my.mini.java.compiler.AST.symbol.StaticSymbolTable;
import my.mini.java.compiler.AST.symbol.Symbol;
import my.mini.java.compiler.Exceptions.IllegalLiteralException;
import my.mini.java.compiler.Exceptions.IllegalOperatorException;
import my.mini.java.compiler.Exceptions.IllegalStatementException;
import my.mini.java.parser.MiniJavaBaseVisitor;
import my.mini.java.parser.MiniJavaLexer;
import my.mini.java.parser.MiniJavaParser;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by alex on 11/28/2016.
 */
public class BuildASTVisitor extends MiniJavaBaseVisitor<Node>
{
    private StaticSymbolTable symbolTable;
    private String sourceName;
    private ClassNode currentClass;

    public BuildASTVisitor(String sourceName)
    {
        currentClass = null;
        this.sourceName = sourceName;
        symbolTable = new StaticSymbolTable();
    }

    public StaticSymbolTable getSymbolTable()
    {
        return symbolTable;
    }

    @Override
    public Node visitProg(MiniJavaParser.ProgContext ctx)
    {
        ProgramNode programNode = new ProgramNode((MainClassNode) visit(ctx.mainClass()));
        for (MiniJavaParser.ClassDeclContext classDeclContext: ctx.classDecl())
        {
            if (classDeclContext instanceof MiniJavaParser.ChildClassContext)
                programNode.classNodes.add((ChildClassNode) visit(classDeclContext));
            else
                programNode.classNodes.add((SimpleClassNode) visit(classDeclContext));
        }
        programNode.classNodes.stream().filter(classNode -> classNode instanceof ChildClassNode)
                .forEach(classNode -> programNode.classNodes.stream()
                        .filter(node -> ((ChildClassNode) classNode).extendsClass.value.getText().equals(node.className.value.getText()))
                        .forEach(node -> ((ChildClassNode) classNode).parentClass = node));
        return programNode;
    }

    @Override
    public Node visitMain(MiniJavaParser.MainContext ctx)
    {
        symbolTable.enterScope();
        MainClassNode mainClassNode = new MainClassNode(new IdLiteralNode(ctx.className), new IdLiteralNode(ctx.paramName), ctx.str);
        currentClass = mainClassNode;
        mainClassNode.varDeclarationNodes.addAll(ctx.varDecl().stream().map(varDeclContext -> (VarDeclarationNode) visit(varDeclContext)).collect(Collectors.toList()));
        for (MiniJavaParser.StatementContext statementContext: ctx.statement())
        {
            if (statementContext instanceof MiniJavaParser.ScopedContext)
                mainClassNode.statementNodes.add((ScopeBranchNode) visit(statementContext));
            else if (statementContext instanceof MiniJavaParser.PrintContext)
                mainClassNode.statementNodes.add((PrintAssertNode) visit(statementContext));
            else if (statementContext instanceof MiniJavaParser.AssignmentContext)
                mainClassNode.statementNodes.add((AssignAssertNode) visit(statementContext));
            else if (statementContext instanceof MiniJavaParser.ArrayAssignmentContext)
                mainClassNode.statementNodes.add((ArrayAssignAssertNode) visit(statementContext));
            else if (statementContext instanceof MiniJavaParser.LoopContext)
                mainClassNode.statementNodes.add((LoopBranchNode) visit(statementContext));
            else if (statementContext instanceof MiniJavaParser.IfContext)
                mainClassNode.statementNodes.add((IfBranchNode) visit(statementContext));
            else
                throw new IllegalStatementException(statementContext.getText() + " is an invalid statement.", currentClass.className.value, "main", statementContext.getStart(), sourceName);
        }
        symbolTable.exitScope();
        return mainClassNode;
    }

    @Override
    public Node visitClass(MiniJavaParser.ClassContext ctx)
    {
        symbolTable.enterScope();
        SimpleClassNode simpleClassNode = new SimpleClassNode(new IdLiteralNode(ctx.className));
        currentClass = simpleClassNode;
        simpleClassNode.varDeclarationNodes.addAll(ctx.varDecl().stream().map(varDeclContext -> (VarDeclarationNode) visit(varDeclContext)).collect(Collectors.toList()));
        simpleClassNode.methodNodes.addAll(ctx.methodDecl().stream().map(methodDeclContext -> (BasicMethodNode) visit(methodDeclContext)).collect(Collectors.toList()));
        simpleClassNode.operatorNodes.addAll(ctx.operatorDecl().stream().map(operatorDeclContext -> (OverloadMethodNode) visit(operatorDeclContext)).collect(Collectors.toList()));
        symbolTable.exitScope();
        return simpleClassNode;
    }

    @Override
    public Node visitChildClass(MiniJavaParser.ChildClassContext ctx)
    {
        symbolTable.enterScope();
        ChildClassNode childClassNode = new ChildClassNode(new IdLiteralNode(ctx.className), new IdLiteralNode(ctx.parentName));
        currentClass = childClassNode;
        childClassNode.varDeclarationNodes.addAll(ctx.varDecl().stream().map(varDeclContext -> (VarDeclarationNode) visit(varDeclContext)).collect(Collectors.toList()));
        childClassNode.methodNodes.addAll(ctx.methodDecl().stream().map(methodDeclContext -> (BasicMethodNode) visit(methodDeclContext)).collect(Collectors.toList()));
        childClassNode.operatorNodes.addAll(ctx.operatorDecl().stream().map(operatorDeclContext -> (OverloadMethodNode) visit(operatorDeclContext)).collect(Collectors.toList()));
        symbolTable.exitScope();
        return childClassNode;
    }

    @Override
    public Node visitVarDecl(MiniJavaParser.VarDeclContext ctx)
    {
        VarDeclarationNode varDeclarationNode = new VarDeclarationNode((TypeNode) visit (ctx.type()), new IdLiteralNode(ctx.ID().getSymbol()));
        varDeclarationNode.type.loc = ctx.getStart();
        symbolTable.addSymbol(new Symbol(varDeclarationNode.varName.value, varDeclarationNode.type, varDeclarationNode));
        return varDeclarationNode;
    }

    @Override
    public Node visitMethodDecl(MiniJavaParser.MethodDeclContext ctx)
    {
        symbolTable.enterScope();
//        if (currentClass.methodLookup(ctx.methodName.getText()) != null)
//            throw new MethodAlreadyDeclaredException();
        BasicMethodNode basicMethodNode = new BasicMethodNode((TypeNode) visit (ctx.type()), new IdLiteralNode(ctx.methodName), (ExprNode) visit(ctx.expr()), ctx.retn);
        basicMethodNode.parameters.addAll(ctx.formalList().stream().map(formalListContext -> (ParameterNode) visit(formalListContext)).collect(Collectors.toList()));
        basicMethodNode.varDeclarationNodes.addAll(ctx.varDecl().stream().map(varDeclContext -> (VarDeclarationNode) visit(varDeclContext)).collect(Collectors.toList()));
        for (MiniJavaParser.StatementContext statementContext: ctx.statement())
        {
            if (statementContext instanceof MiniJavaParser.ScopedContext)
                basicMethodNode.statementNodes.add((ScopeBranchNode) visit(statementContext));
            else if (statementContext instanceof MiniJavaParser.PrintContext)
                basicMethodNode.statementNodes.add((PrintAssertNode) visit(statementContext));
            else if (statementContext instanceof MiniJavaParser.AssignmentContext)
                basicMethodNode.statementNodes.add((AssignAssertNode) visit(statementContext));
            else if (statementContext instanceof MiniJavaParser.ArrayAssignmentContext)
                basicMethodNode.statementNodes.add((ArrayAssignAssertNode) visit(statementContext));
            else if (statementContext instanceof MiniJavaParser.LoopContext)
                basicMethodNode.statementNodes.add((LoopBranchNode) visit(statementContext));
            else if (statementContext instanceof MiniJavaParser.IfContext)
                basicMethodNode.statementNodes.add((IfBranchNode) visit(statementContext));
            else
                throw new IllegalStatementException(statementContext.getText() + " has an invalid statement.", currentClass.className.value, basicMethodNode.methodName, statementContext.getStart(), sourceName);
        }
        symbolTable.exitScope();
        return basicMethodNode;
    }

    @Override
    public Node visitOperatorDecl(MiniJavaParser.OperatorDeclContext ctx)
    {
        symbolTable.enterScope();
        OverloadMethodNode overloadMethodNode = new OverloadMethodNode((TypeNode) visit (ctx.type()), getOperator(ctx.operator), (ParameterNode) visit(ctx.formalList()), (ExprNode) visit(ctx.expr()), ctx.retn);
        overloadMethodNode.varDeclarationNodes.addAll(ctx.varDecl().stream().map(varDeclContext -> (VarDeclarationNode) visit(varDeclContext)).collect(Collectors.toList()));
        for (MiniJavaParser.StatementContext statementContext: ctx.statement())
        {
            if (statementContext instanceof MiniJavaParser.ScopedContext)
                overloadMethodNode.statementNodes.add((ScopeBranchNode) visit(statementContext));
            else if (statementContext instanceof MiniJavaParser.PrintContext)
                overloadMethodNode.statementNodes.add((PrintAssertNode) visit(statementContext));
            else if (statementContext instanceof MiniJavaParser.AssignmentContext)
                overloadMethodNode.statementNodes.add((AssignAssertNode) visit(statementContext));
            else if (statementContext instanceof MiniJavaParser.ArrayAssignmentContext)
                overloadMethodNode.statementNodes.add((ArrayAssignAssertNode) visit(statementContext));
            else if (statementContext instanceof MiniJavaParser.LoopContext)
                overloadMethodNode.statementNodes.add((LoopBranchNode) visit(statementContext));
            else if (statementContext instanceof MiniJavaParser.IfContext)
                overloadMethodNode.statementNodes.add((IfBranchNode) visit(statementContext));
            else
                throw new IllegalStatementException(statementContext.getText() + " has an invalid statement.", currentClass.className.value, overloadMethodNode.methodName, statementContext.getStart(), sourceName);
        }
        symbolTable.exitScope();
        return overloadMethodNode;
    }

    @Override
    public Node visitFormalList(MiniJavaParser.FormalListContext ctx)
    {
        ParameterNode parameterNode = new ParameterNode((TypeNode) visit (ctx.type()), new IdLiteralNode(ctx.ID().getSymbol()));
        parameterNode.type.loc = ctx.getStart();
        symbolTable.addSymbol(new Symbol(parameterNode.name.value, parameterNode.type, parameterNode));
        return parameterNode;
    }

    @Override
    public Node visitType(MiniJavaParser.TypeContext ctx)
    {
        if (ctx.getText().equals("int"))
            return new IntTypeNode(ctx.getStart());
        else if (ctx.getText().equals("int[]"))
            return new IntArrayTypeNode(ctx.getStart());
        else if (ctx.getText().equals("boolean"))
            return new BooleanTypeNode(ctx.getStart());
        else
            return new ObjectTypeNode(new IdLiteralNode(ctx.getStart()));
    }

    @Override
    public Node visitScoped(MiniJavaParser.ScopedContext ctx)
    {
        symbolTable.enterScope();
        ScopeBranchNode scopeBranchNode = new ScopeBranchNode();
        scopeBranchNode.statementNodes.addAll(ctx.statement().stream().map(statementDeclContext -> (StatementNode) visit(statementDeclContext)).collect(Collectors.toList()));
        symbolTable.exitScope();
        return scopeBranchNode;
    }

    @Override
    public Node visitPrint(MiniJavaParser.PrintContext ctx)
    {
        return new PrintAssertNode(ctx.getStart(), (ExprNode) visit (ctx.expr()));
    }

    @Override
    public Node visitAssignment(MiniJavaParser.AssignmentContext ctx)
    {
        return new AssignAssertNode(new IdLiteralNode(ctx.varName), (ExprNode) visit(ctx.assignee));
    }

    @Override
    public Node visitArrayAssignment(MiniJavaParser.ArrayAssignmentContext ctx)
    {
        return new ArrayAssignAssertNode(new IdLiteralNode(ctx.varName), getLiteral(ctx.element), (ExprNode) visit(ctx.assignee));
    }

    @Override
    public Node visitLoop(MiniJavaParser.LoopContext ctx)
    {
        return new LoopBranchNode((StatementNode) visit(ctx.condition), (StatementNode)visit(ctx.statement()));
    }

    @Override
    public Node visitIf(MiniJavaParser.IfContext ctx)
    {
        StatementNode node = null;
        if (ctx.stm2 != null)
            node = (StatementNode)visit(ctx.stm2);
        return new IfBranchNode((StatementNode) visit(ctx.condition), (StatementNode)visit(ctx.stm1), node);
    }

    @Override
    public Node visitNestedCondition(MiniJavaParser.NestedConditionContext ctx)
    {
        return new NestedConditionNode(visit(ctx.condExpr()));
    }

    @Override
    public Node visitNot(MiniJavaParser.NotContext ctx)
    {
        return new NotConditionNode(visit(ctx.condExpr()));
    }

    @Override
    public Node visitLessThan(MiniJavaParser.LessThanContext ctx)
    {
        return new LessThanConditionNode(visit(ctx.cond1), visit(ctx.cond2));
    }

    @Override
    public Node visitAnd(MiniJavaParser.AndContext ctx)
    {
        return new AndConditionNode(visit(ctx.cond1), visit(ctx.cond2));
    }

    @Override
    public Node visitTrailing(MiniJavaParser.TrailingContext ctx)
    {
        return new TrailingExprNode(getOperator(ctx.operator), visit(ctx.atom()));
    }

    @Override
    public Node visitArrayAccess(MiniJavaParser.ArrayAccessContext ctx)
    {
        return new ArrayAccessExprNode((AtomNode) visit(ctx.atom()), (ExprNode) visit(ctx.expr()));
    }

    @Override
    public Node visitArrayLength(MiniJavaParser.ArrayLengthContext ctx)
    {
        return new ArrayLengthExprNode((AtomNode) visit(ctx.atom()));
    }

    @Override
    public Node visitMethodCall(MiniJavaParser.MethodCallContext ctx)
    {
        MethodCallExprNode methodCallExprNode = new MethodCallExprNode((AtomNode) visit(ctx.atom()), new IdLiteralNode(ctx.methodName));
        if (methodCallExprNode.objectName instanceof ObjectRefAtomNode)
        {
            ((ObjectRefAtomNode) methodCallExprNode.objectName).setMethodName(methodCallExprNode.methodName);
            ((ObjectRefAtomNode) methodCallExprNode.objectName).setExpressions(methodCallExprNode.expressions);
        }
        methodCallExprNode.expressions.addAll(ctx.expr().stream().map(exprContext -> (ExprNode) visit(exprContext)).collect(Collectors.toList()));
        return methodCallExprNode;
    }

    @Override
    public Node visitMult(MiniJavaParser.MultContext ctx)
    {
        return new MultMathNode(visit(ctx.left), visit(ctx.right));
    }

    @Override
    public Node visitMinus(MiniJavaParser.MinusContext ctx)
    {
        return new MinusMathNode(visit(ctx.left), visit(ctx.right));
    }

    @Override
    public Node visitPlus(MiniJavaParser.PlusContext ctx)
    {
        return new PlusMathNode(visit(ctx.left), visit(ctx.right));
    }

    @Override
    public Node visitAtm(MiniJavaParser.AtmContext ctx)
    {
        return visit(ctx.atom());
    }

    @Override
    public Node visitNumber(MiniJavaParser.NumberContext ctx)
    {
        return new IntLiteralNode(ctx.INT().getSymbol());
    }

    @Override
    public Node visitBool(MiniJavaParser.BoolContext ctx)
    {
        return new BooleanLiteralNode(ctx.BOOLEAN().getSymbol());
    }

    @Override
    public Node visitObjectReference(MiniJavaParser.ObjectReferenceContext ctx)
    {
        if (ctx.varName.getText().equals("false") || ctx.varName.getText().equals("true"))
        {
            if (currentClass instanceof MainClassNode || ctx.methodName == null)
                return new BooleanLiteralNode(new CommonToken(6, "boolean"), ctx.varName);
            return new BooleanLiteralNode(ctx.methodName);
        }
        ObjectRefAtomNode objectRefAtomNode;
        // (varName=ID | varName='this') ('.' methodName=ID '(' expr ')')? #ObjectReference
        if (ctx.methodName == null)
            objectRefAtomNode = new ObjectRefAtomNode(new IdLiteralNode(ctx.varName));
        else
        {
            ArrayList<ExprNode> expressions = new ArrayList<>();
            expressions.add((ExprNode) visit(ctx.expr()));
            objectRefAtomNode = new ObjectRefAtomNode(new IdLiteralNode(ctx.varName), new IdLiteralNode(ctx.methodName), expressions);
        }
        return objectRefAtomNode;
    }

    @Override
    public Node visitInstatiate(MiniJavaParser.InstatiateContext ctx)
    {
        return new InstatiateAtomNode(new IdLiteralNode(ctx.className));
    }

    @Override
    public Node visitReferenceThis(MiniJavaParser.ReferenceThisContext ctx)
    {
        ObjectTypeNode objectTypeNode = new ObjectTypeNode(currentClass.className);
        objectTypeNode.loc = ctx.getStart();
        return new RefThisAtomNode(objectTypeNode);
    }

    @Override
    public Node visitNewIntArray(MiniJavaParser.NewIntArrayContext ctx)
    {
        return new NewIntArrayAtomNode((ExprNode) visit(ctx.expr()), ctx.getStart());
    }

    @Override
    public Node visitParenthesizedExpr(MiniJavaParser.ParenthesizedExprContext ctx)
    {
        return new ParenExprAtomNode((ExprNode) visit(ctx.expr()));
    }

    @Override
    public Node visitCalculation(MiniJavaParser.CalculationContext ctx)
    {
        return visit(ctx.math());
    }


    @Override
    public Node visitExp(MiniJavaParser.ExpContext ctx)
    {
        return visit(ctx.expr());
    }

    private LiteralNode getLiteral(Token element)
    {
        if (element.getType() == MiniJavaLexer.INT)
            return new IntLiteralNode(element);
        else if (element.getType() == MiniJavaLexer.ID)
            return new IdLiteralNode(element);
        else if (element.getType() == MiniJavaLexer.BOOLEAN)
            return new BooleanLiteralNode(element);
        else
            throw new IllegalLiteralException(element.getText() + " is an illegal literal");
    }

    private Operators getOperator(Token operator)
    {
        if (operator.getText().equals("+"))
            return Operators.PLUS_SIGN;
        else if (operator.getText().equals("-"))
            return Operators.MINUS_SIGN;
        else if (operator.getText().equals("*"))
            return Operators.MULT_SIGN;
        else if (operator.getText().equals("&&"))
            return Operators.AND_SIGN;
        else if (operator.getText().equals("<"))
            return Operators.LESS_THAN_SIGN;
        else
            throw new IllegalOperatorException(operator.getText() + " cannot be overridden!");
    }
}
