package my.mini.java.compiler.AST;

import my.mini.java.compiler.AST.nodes.classes.ChildClassNode;
import my.mini.java.compiler.AST.nodes.classes.ClassNode;
import my.mini.java.compiler.AST.nodes.classes.MainClassNode;
import my.mini.java.compiler.AST.nodes.classes.SimpleClassNode;
import my.mini.java.compiler.AST.nodes.formal_list.ParameterNode;
import my.mini.java.compiler.AST.nodes.literals.BooleanLiteralNode;
import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;
import my.mini.java.compiler.AST.nodes.literals.IntLiteralNode;
import my.mini.java.compiler.AST.nodes.methods.BasicMethodNode;
import my.mini.java.compiler.AST.nodes.methods.MethodNode;
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
import my.mini.java.compiler.AST.nodes.type.IntArrayTypeNode;
import my.mini.java.compiler.AST.nodes.type.ObjectTypeNode;
import my.mini.java.compiler.AST.nodes.type.TypeNode;
import my.mini.java.compiler.AST.nodes.variable.VarDeclarationNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by alex on 12/4/2016.
 */
public class CodeGenerationVisitor extends ASTVisitor<String>
{
    private static final String commentSpaces = "                                                        ";
    private final StringBuilder program = new StringBuilder("");

    private final HashMap<String, List<ParameterNode>> parameters;
    private final List<ClassNode> classNames;

    private HashMap<String, HashMap<String, Integer>> scopes = new HashMap<>();
    private HashMap<String, HashMap<String, String>> loaderScopes = new HashMap<>();
    private HashMap<String, HashMap<String, String>> storerScopes = new HashMap<>();

    private HashMap<String, Integer> classVariables = new HashMap<>();
    private HashMap<String, Integer> variables = new HashMap<>();

    private HashMap<String, String> classLoader = new HashMap<>();
    private HashMap<String, String> classStorer = new HashMap<>();
    private HashMap<String, String> loader = new HashMap<>();
    private HashMap<String, String> storer = new HashMap<>();

    private HashMap<String, TypeNode> types = new HashMap<>();

    private String currentClass = null;
    private String currentMethod = null;
    private int elseCount = -1;

    public CodeGenerationVisitor(HashMap<String, List<ParameterNode>> parameters, List<ClassNode> classNames)
    {
        this.parameters = parameters;
        this.classNames = classNames;
    }

    @Override
    public String visit(ProgramNode node)
    {
        node.classNodes.forEach(this::visit);
        return program.toString();
    }

    @Override
    public String visit(MainClassNode node)
    {
        currentClass = node.className.valueString;
        currentMethod = "main";
        variables.put("this", 0);
        loader.put("this", "0");
        storer.put("this", "0");
        scopes.put(node.className.valueString, variables);
        loaderScopes.put(node.className.valueString, loader);
        storerScopes.put(node.className.valueString, storer);
        program.append(".source ")
				.append(node.className.valueString)
				.append(".j")
				.append(System.lineSeparator());
        program.append(".class public ")
				.append(node.className.valueString)
				.append("\n");
        program.append(".super java/lang/Object\n\n");

        program.append(";================================")
				.append(System.lineSeparator());
        program.append("; default constructor")
				.append(System.lineSeparator());
        program.append(";================================")
				.append(System.lineSeparator());
        program.append(".method public <init>()V")
				.append(System.lineSeparator());
        program.append("    aload_0")
				.append(System.lineSeparator());
        program.append("    invokespecial java/lang/Object/<init>()V")
				.append(System.lineSeparator());
        program.append("    return")
				.append(System.lineSeparator());
        program.append(".end method")
				.append(System.lineSeparator())
				.append(System.lineSeparator());

        program.append(";================================")
				.append(System.lineSeparator());
        program.append("; main method")
				.append(System.lineSeparator());
        program.append(";================================")
				.append(System.lineSeparator());
        program.append(".method public static main([Ljava/lang/String;)V\n");
        program.append("    .limit stack 10\n");
        program.append("    .limit locals 50\n\n");
        node.varDeclarationNodes.forEach(this::visit);
        node.statementNodes.forEach(this::visit);
        program.append("\n");
        program.append("\n    return\n");
        program.append(".end method")
				.append(System.lineSeparator())
				.append(System.lineSeparator());
        currentMethod = null;
        classVariables = null;
        return program.toString();
    }

    @Override
    public String visit(SimpleClassNode node)
    {
        currentClass = node.className.valueString;
        variables = new HashMap<>();
        loader = new HashMap<>();
        storer = new HashMap<>();
        variables.put("this", 0);
        loader.put("this", "0");
        storer.put("this", "0");
        scopes.put(node.className.valueString, variables);
        loaderScopes.put(node.className.valueString, loader);
        storerScopes.put(node.className.valueString, storer);
        program.append(".source ")
				.append(node.className.valueString)
				.append(".j")
				.append(System.lineSeparator());
        program.append(".class public ")
				.append(node.className.valueString)
				.append("\n");
        program.append(".super java/lang/Object\n\n");

        node.varDeclarationNodes.forEach(this::visit);

        program.append(";================================")
                .append(System.lineSeparator());
        program.append("; default constructor")
                .append(System.lineSeparator());
        program.append(";================================")
                .append(System.lineSeparator());
        program.append(".method public <init>()V")
                .append(System.lineSeparator());
        program.append("    aload_0")
                .append(System.lineSeparator());
        program.append("    invokespecial java/lang/Object/<init>()V")
                .append(System.lineSeparator());
        program.append("    return")
                .append(System.lineSeparator());
        program.append(".end method")
                .append(System.lineSeparator())
                .append(System.lineSeparator());

        classVariables = variables;
        classLoader = loader;
        classStorer = storer;
        node.methodNodes.forEach(this::visit);
        node.operatorNodes.forEach(this::visit);

        classLoader = null;
        classStorer = null;
        classVariables = null;
        return program.toString();
    }

    @Override
    public String visit(ChildClassNode node)
    {
        currentClass = node.className.valueString;
        variables = new HashMap<>();
        loader = new HashMap<>();
        storer = new HashMap<>();
        variables.put("this", 0);
        loader.put("this", "0");
        storer.put("this", "0");
        scopes.put(node.className.valueString, variables);
        loaderScopes.put(node.className.valueString, loader);
        storerScopes.put(node.className.valueString, storer);
        program.append(".source ")
				.append(node.className.valueString)
				.append(".j")
				.append(System.lineSeparator());
        program.append(".class public ")
				.append(node.className.valueString)
				.append("\n");
        program.append(".super ")
				.append(node.extendsClass.valueString)
				.append("\n\n");

        node.varDeclarationNodes.forEach(this::visit);

        program.append(";================================")
                .append(System.lineSeparator());
        program.append("; default constructor")
                .append(System.lineSeparator());
        program.append(";================================")
                .append(System.lineSeparator());
        program.append(".method public <init>()V")
                .append(System.lineSeparator());
        program.append("    aload_0")
                .append(System.lineSeparator());
        program.append("    invokespecial ")
                .append(node.extendsClass.valueString)
                .append("/<init>()V")
                .append(System.lineSeparator());
        program.append("    return")
                .append(System.lineSeparator());
        program.append(".end method")
                .append(System.lineSeparator())
                .append(System.lineSeparator());

        classVariables = variables;
        classLoader = loader;
        classStorer = storer;
        node.methodNodes.forEach(this::visit);
        node.operatorNodes.forEach(this::visit);

        classLoader = null;
        classStorer = null;
        classVariables = null;
        return program.toString();
    }

    @Override
    public String visit(BasicMethodNode node)
    {
        currentMethod = node.methodName;
        variables = new HashMap<>();
        loader = new HashMap<>();
        storer = new HashMap<>();
        variables.put("this", 0);
        loader.put("this", "0");
        storer.put("this", "0");
        scopes.put(node.methodName, variables);
        loaderScopes.put(node.methodName, loader);
        storerScopes.put(node.methodName, storer);
        program.append(";================================")
				.append(System.lineSeparator())
                .append("; ")
				.append(node.methodName)
				.append(" method")
				.append(System.lineSeparator());
        program.append(";================================")
				.append(System.lineSeparator());
        program.append(".method public ")
				.append(node.methodName)
				.append("(");
        StringBuilder temp = new StringBuilder();
        node.parameters.forEach(parameterNode -> temp.append(visit(parameterNode)));
        program.append(")")
                .append(getIdentifier(node.typeNode.getType()))
                .append("\n");
        program.append("    .limit stack 10\n");
        program.append("    .limit locals 50\n\n");
        program.append(temp);
        node.varDeclarationNodes.forEach(this::visit);
        node.statementNodes.forEach(this::visit);
        visit(node.returnExpression);
        program.append("\n");
        program.append("\n    ")
            .append(getReturn(node.typeNode.getType()))
            .append("\n");
        program.append(".end method")
				.append(System.lineSeparator())
				.append(System.lineSeparator());
        currentMethod = null;
        return null;
    }

    private String getReturn(String type)
    {
        if (type.equals("int") || type.equals("boolean"))
            return "ireturn";
        else
            return "areturn";
    }

    @Override
    public String visit(OverloadMethodNode node)
    {
        currentMethod = node.methodName;
        variables = new HashMap<>();
        loader = new HashMap<>();
        storer = new HashMap<>();
        variables.put("this", 0);
        loader.put("this", "0");
        storer.put("this", "0");
        scopes.put(node.methodName, variables);
        loaderScopes.put(node.methodName, loader);
        storerScopes.put(node.methodName, storer);
        program.append(";================================")
				.append(System.lineSeparator());
        program.append("; ")
				.append(node.methodName)
				.append(" method")
				.append(System.lineSeparator());
        program.append(";================================")
				.append(System.lineSeparator());
        program.append(".method public ")
				.append("$operator_")
                .append(node.sign.name())
				.append("(");
        String temp = visit(node.parameter);
        program.append(")")
            .append(getIdentifier(node.typeNode.getType()))
            .append("\n");
        program.append("    .limit stack 10\n");
        program.append("    .limit locals 50\n\n");
        program.append(temp);
        node.varDeclarationNodes.forEach(this::visit);
        node.statementNodes.forEach(this::visit);
        visit(node.returnExpression);
        program.append("\n");
        program.append("\n    ireturn\n");
        program.append(".end method")
				.append(System.lineSeparator())
				.append(System.lineSeparator());
        currentMethod = null;
        return null;
    }

    @Override
    public String visit(ParameterNode node)
    {
//        StringBuilder temp = new StringBuilder();
        variables.putIfAbsent(node.name.valueString, variables.size());
        types.putIfAbsent(node.name.valueString, node.type);
        if (node.type instanceof IntArrayTypeNode)
        {
            loader.putIfAbsent(node.name.valueString, "aload ");
            storer.putIfAbsent(node.name.valueString, "astore ");
            program.append("[I");
//            temp.append("    ldc 2")
//				.append(commentSpaces)
//				.append("    ; push 2 onto the stack")
//				.append(System.lineSeparator())
//				.append("    newarray int")
//				.append(commentSpaces)
//				.append("; call newarray to make a 2-element int array")
//				.append(System.lineSeparator())
//				.append("    astore ")
//				.append(variables.size() - 1)
//				.append(commentSpaces)
//				.append("    ; store the reference to the array in local variable 1")
//				.append(System.lineSeparator());
        }
        else if (node.type instanceof ObjectTypeNode)
        {
            loader.putIfAbsent(node.name.valueString, "aload ");
            storer.putIfAbsent(node.name.valueString, "astore ");
            program.append("L").append(node.type.getType()).append(";");
//            temp.append("    new ")
//				.append(node.type.getType())
//				.append(commentSpaces)
//				.append("    ; creating object")
//				.append(System.lineSeparator())
//				.append("    dup")
//				.append(commentSpaces)
//				.append("         ; dup the object reference")
//				.append(System.lineSeparator())
//				.append("    invokespecial ")
//				.append(node.type.getType())
//				.append("/<init>()V")
//				.append(commentSpaces)
//				.append("; Calling parent's constructor")
//				.append(System.lineSeparator())
//				.append("    astore ")
//				.append(variables.size() - 1)
//				.append(commentSpaces)
//				.append("    ; store the reference to local variable ")
//				.append(variables.size() - 1)
//				.append(System.lineSeparator());
        }
        else
        {
            loader.putIfAbsent(node.name.valueString, "iload ");
            storer.putIfAbsent(node.name.valueString, "istore ");
            program.append("I");
//            temp.append("    ldc 0")
//				.append(commentSpaces)
//				.append("       ; ")
//				.append(node.name.valueString)
//				.append(" is being initialized and set to zero/false")
//				.append(System.lineSeparator())
//                .append("    istore ")
//				.append(variables.size() - 1)
//				.append(commentSpaces)
//				.append("    ; Saving variable in locals")
//				.append(System.lineSeparator());
        }
        return ""; //temp.toString();
    }

    @Override
    public String visit(VarDeclarationNode node)
    {

        // .field private balance D = 0.0
        // .field public foo I
        variables.putIfAbsent(node.varName.valueString, variables.size());
        types.put(node.varName.valueString, node.type);
        if (currentMethod == null)
        {
            if (node.type instanceof IntArrayTypeNode)
            {
                loader.putIfAbsent(node.varName.valueString, "getfield " + currentClass + "/" + node.varName.valueString + " [I");
                storer.putIfAbsent(node.varName.valueString, "putfield " + currentClass + "/" + node.varName.valueString + " [I");
            }
            else if (node.type instanceof ObjectTypeNode)
            {
                loader.putIfAbsent(node.varName.valueString, "getfield " + currentClass + "/" + node.varName.valueString + " L" + node.type.getType() + ";");
                storer.putIfAbsent(node.varName.valueString, "putfield " + currentClass + "/" + node.varName.valueString + " L" + node.type.getType() + ";");
            }
            else
            {
                loader.putIfAbsent(node.varName.valueString, "getfield " + currentClass + "/" + node.varName.valueString + " I ");
                storer.putIfAbsent(node.varName.valueString, "putfield " + currentClass + "/" + node.varName.valueString + " I ");
            }
            program.append(".field public ")
                .append(node.varName.valueString)
                .append(" ")
                .append(getIdentifier(node.type.getType()))
                .append(commentSpaces)
                .append("; Creating public field for class ")
                .append(currentClass)
                .append(System.lineSeparator());
        }
        else if (node.type instanceof IntArrayTypeNode)
        {
            loader.putIfAbsent(node.varName.valueString, "aload ");
            storer.putIfAbsent(node.varName.valueString, "astore ");
            program.append("    ldc 2")
				.append(commentSpaces)
				.append("    ; push 2 onto the stack")
				.append(System.lineSeparator())
				.append("    newarray int")
				.append(commentSpaces)
				.append("; call newarray to make a 2-element int array")
				.append(System.lineSeparator())
				.append("    astore ")
				.append(variables.size() - 1)
				.append(commentSpaces)
				.append("    ; store the reference to the array in local variable 1")
				.append(System.lineSeparator());
        }
        else if (node.type instanceof ObjectTypeNode)
        {
            loader.putIfAbsent(node.varName.valueString, "aload ");
            storer.putIfAbsent(node.varName.valueString, "astore ");
            program.append("    new ")
				.append(node.type.getType())
				.append(commentSpaces)
				.append("    ; creating object")
				.append(System.lineSeparator())
				.append("    dup")
				.append(commentSpaces)
				.append("         ; dup the object reference")
				.append(System.lineSeparator())
				.append("    invokespecial ")
				.append(node.type.getType())
				.append("/<init>()V")
				.append(commentSpaces)
				.append("; Calling parent's constructor")
				.append(System.lineSeparator())
				.append("    astore ")
				.append(variables.size() - 1)
				.append(commentSpaces)
				.append("    ; store the reference to local variable ")
				.append(variables.size() - 1)
				.append(System.lineSeparator());
        }
        else
        {
            loader.putIfAbsent(node.varName.valueString, "iload ");
            storer.putIfAbsent(node.varName.valueString, "istore ");
            program.append("    ldc 0")
				.append(commentSpaces)
				.append("       ; ")
				.append(node.varName.valueString)
				.append(" is being initialized and set to zero/false")
				.append(System.lineSeparator());
            program.append("    istore ")
				.append(variables.size() - 1)
				.append(commentSpaces)
				.append("    ; Saving variable in locals")
				.append(System.lineSeparator());
        }
        return null;
    }

    private String getIdentifier(String type)
    {
        switch (type)
        {
            case "int":
            case "boolean":
                return "I";
            case "int[]":
                return "[I";
            default:
                return "L" + type + ";";
        }
    }

    @Override
    public String visit(BooleanLiteralNode node)
    {
        if (node.variablesValue != null)
            program.append("    ldc ")
				.append((node.variablesValue.getText().equals("false")) ? "0" : "1")
				.append(commentSpaces)
				.append("       ; Loading in boolean constant(")
				.append(node.variablesValue.getText())
				.append(")")
				.append(System.lineSeparator());
        return null;
    }

    @Override
    public String visit(IdLiteralNode node)
    {
        String loader = getLoader(node.valueString);
        if (loader.contains("getfield"))
        {
            program.append("    aload ")
                    .append(getVar("this"))
                    .append(System.lineSeparator())
                    .append("    ")
                    .append(loader)
                    .append(commentSpaces)
                    .append("    ; Getting object into field ")
                    .append(node.valueString)
                    .append(System.lineSeparator());
        }
        else
        {
            program.append("    ").append(loader)
                    .append(getVar(node.valueString))
                    .append(commentSpaces)
                    .append("    ; Getting '")
                    .append(node.valueString)
                    .append("' from the local pool")
                    .append(System.lineSeparator());
        }
        return node.valueString + System.lineSeparator();
    }

    private String getVar(String valueString)
    {
        if (valueString.equals("this"))
            return "0";
        if (variables.get(valueString) == null && classVariables != null)
        {
            if (classVariables.get(valueString) != null)
                return String.valueOf(classVariables.get(valueString));
            for (ClassNode classNode: classNames)
                if (classNode.className.valueString.equals(currentClass))
                    if (classNode instanceof ChildClassNode && classNode.varLookup(valueString) != null)
                    {
                        HashMap<String, Integer> stringIntegerHashMap = scopes.get(((ChildClassNode) classNode).parentClass.className.valueString);
                        if (stringIntegerHashMap.get(valueString) != null)
                            return String.valueOf(stringIntegerHashMap.get(valueString));
                        return deepSearch(valueString, stringIntegerHashMap);
                    }
        }
        return String.valueOf(variables.get(valueString));
    }

    private String deepSearch(String valueString, HashMap<String, Integer> stringIntegerHashMap)
    {
        if (stringIntegerHashMap.get(valueString) != null)
            return String.valueOf(stringIntegerHashMap.get(valueString));
        for (ClassNode classNode: classNames)
            if (classNode.className.valueString.equals(currentClass))
                if (classNode instanceof ChildClassNode && classNode.varLookup(valueString) != null)
                {
                    HashMap<String, Integer> map = scopes.get(((ChildClassNode) classNode).parentClass.className.valueString);
                    if (map.get(valueString) != null)
                        return String.valueOf(map.get(valueString));
                    return deepSearch(valueString, map);
                }
        return String.valueOf(stringIntegerHashMap.get(valueString));
    }

    @Override
    public String visit(IntLiteralNode node)
    {
        program.append("    ldc ")
				.append(node.value.getText())
				.append(commentSpaces)
				.append("       ; Loading int constant")
				.append(System.lineSeparator());
        return null;
    }

    @Override
    public String visit(ArrayAssignAssertNode node)
    {
        String loader = getLoader(node.varName.valueString);
        if (loader.contains("getfield"))
        {
            program.append("    aload ")
                    .append(getVar("this"))
                    .append(System.lineSeparator())
                    .append("    ")
                    .append(loader)
                    .append(commentSpaces)
                    .append("    ; Getting object into field ")
                    .append(node.varName.valueString)
                    .append(System.lineSeparator());
            visit(node.element);
            visit(node.expression);
            program.append("    iastore")
                    .append(commentSpaces)
                    .append("    ; storing above variable")
                    .append(System.lineSeparator());
        }
        else
        {
            program.append("    aload ")
                    .append(getVar(node.varName.valueString))
                    .append(commentSpaces)
                    .append("    ; get array reference")
                    .append(System.lineSeparator());
            visit(node.element);
            visit(node.expression);
            program.append("    iastore")
                    .append(commentSpaces)
                    .append("    ; storing above variable")
                    .append(System.lineSeparator());
        }
        return "array";
    }

    @Override
    public String visit(AssignAssertNode node)
    {
        String storer = getStorer(node.varName.valueString);
        if (storer.contains("putfield"))
        {
            program.append("    aload_0")
                    .append(commentSpaces)
                    .append("    ; Getting object reference")
                    .append(System.lineSeparator());
        }
        String type = visit(node.expression);
        if (type != null && (type.equals("array") || node.expression instanceof InstatiateAtomNode))
        {
            if (storer.contains("putfield"))
            {
                program.append("    " + storer)
                        .append(commentSpaces)
                        .append("    ; Storing object into field ")
                        .append(node.varName.valueString)
                        .append(System.lineSeparator());
            }
            else
            {
                program.append("    ")
                        .append(storer)
                        .append(getVar(node.varName.valueString))
                        .append(commentSpaces)
                        .append("    ; Storing object into ")
                        .append(node.varName.valueString)
                        .append(System.lineSeparator());
            }
        }
        else
        {
            if (storer.contains("putfield"))
            {
                program.append("    " + storer)
                        .append(commentSpaces)
                        .append("    ; Storing object into field ")
                        .append(node.varName.valueString)
                        .append(System.lineSeparator());
            }
            else
            {
                program.append("    ")
                        .append(getStorer(node.varName.valueString))
                        .append(getVar(node.varName.valueString))
                        .append(commentSpaces)
                        .append("    ; Storing item into ")
                        .append(node.varName.valueString)
                        .append(System.lineSeparator());
            }
        }
        return null;
    }

    @Override
    public String visit(PrintAssertNode node)
    {
        program.append(System.lineSeparator())
				.append("    getstatic java/lang/System/out Ljava/io/PrintStream;")
				.append(System.lineSeparator());
        visit(node.expression);
        program.append("    invokevirtual java/io/PrintStream/println(I)V")
				.append(System.lineSeparator());
        return null;
    }

    @Override
    public String visit(AndConditionNode node)
    {
        int temp = ++elseCount;
        String name = visit(node.leftCondition);
        TypeNode type = types.get(name);
        if (type instanceof ObjectTypeNode)
        {
            for (ClassNode classNode: classNames)
            {
                if (classNode.className.valueString.equals(type.getType()))
                {
                    OverloadMethodNode method = classNode.operatorMethodLookup("$operator_" + Operators.AND_SIGN.name());
                    if (method != null)
                    {
                        visit(node.rightCondition);
                        program.append("invokevirtual ")
                                .append(getType(name))
                                .append("/")
                                .append("$operator_").append(Operators.AND_SIGN.name())
                                .append("(");
                        parameters.get(method.methodName).forEach(this::visit);
                        program.append(")")
                                .append(getIdentifier(method.typeNode.getType()))
                                .append(System.lineSeparator());
                    }
                }
            }
        }
        else
        {
            program.append("    ifeq else_")
                    .append(temp)
                    .append(commentSpaces)
                    .append(" ; Compare the two boolean expression to make sure they are both either true or false")
                    .append(System.lineSeparator());
            visit(node.rightCondition);
            program.append("    ifeq else_")
                    .append(temp)
                    .append(commentSpaces)
                    .append(" ; Check if the conditional is true or false")
                    .append(System.lineSeparator());

            program.append("    ldc 1")
                    .append(commentSpaces)
                    .append("   ; Literal true given on successful pass of above conditionals")
                    .append(System.lineSeparator())
                    .append("    goto finally_")
                    .append(temp)
                    .append(System.lineSeparator())
                    .append("else_")
                    .append(temp)
                    .append(":")
                    .append(System.lineSeparator())
                    .append("    ldc 0")
                    .append(commentSpaces)
                    .append("   ; Literal true given on successful pass of above conditionals")
                    .append(System.lineSeparator())
                    .append("finally_")
                    .append(temp)
                    .append(":")
                    .append(System.lineSeparator());
        }
        return null;
    }

    @Override
    public String visit(LessThanConditionNode node)
    {
        int temp = ++elseCount;
        String name = visit(node.leftCondition);
        visit(node.rightCondition);
        TypeNode type = types.get(name);
        if (type instanceof ObjectTypeNode)
        {
            for (ClassNode classNode: classNames)
            {
                if (classNode.className.valueString.equals(type.getType()))
                {
                    OverloadMethodNode method = classNode.operatorMethodLookup("$operator_" + Operators.LESS_THAN_SIGN.name());
                    if (method != null)
                    {
                        program.append("invokevirtual ")
                                .append(getType(name))
                                .append("/")
                                .append("$operator_").append(Operators.LESS_THAN_SIGN.name())
                                .append("(");
                        parameters.get(method.methodName).forEach(this::visit);
                        program.append(")")
                                .append(getIdentifier(method.typeNode.getType()))
                                .append(System.lineSeparator());
                    }
                }
            }
        }
        else
        {
            program.append("    if_icmpge else_")
                    .append(temp)
                    .append(commentSpaces.substring(8))
                    .append("; Comparing top two elements on the stack")
                    .append(System.lineSeparator())
                    .append("    ldc 1")
                    .append(commentSpaces)
                    .append("   ; Literal true given on successful pass of above conditional")
                    .append(System.lineSeparator())
                    .append("    goto finally_")
                    .append(temp)
                    .append(System.lineSeparator())
                    .append("else_")
                    .append(temp)
                    .append(":")
                    .append(System.lineSeparator())
                    .append("    ldc 0")
                    .append(commentSpaces)
                    .append("   ; Literal true given on successful pass of above conditionals")
                    .append(System.lineSeparator())
                    .append("finally_")
                    .append(temp)
                    .append(":")
                    .append(System.lineSeparator());
        }
        return null;
    }

    @Override
    public String visit(NotConditionNode node)
    {
        int temp = ++elseCount;
        visit(node.condition);
        program.append("    ifne else_")
				.append(temp)
				.append(commentSpaces.substring(3))
				.append("; Not the boolean expression")
				.append(System.lineSeparator())
				.append("    ldc 1")
				.append(commentSpaces)
				.append("   ; Literal true given on successful pass of above conditional")
				.append(System.lineSeparator())
				.append("    goto finally_")
				.append(temp)
				.append(System.lineSeparator())
				.append("else_")
				.append(temp)
				.append(":")
				.append(System.lineSeparator())
				.append("    ldc 0")
				.append(commentSpaces)
				.append("   ; Literal true given on successful pass of above conditionals")
				.append(System.lineSeparator())
				.append("finally_")
				.append(temp)
				.append(":")
				.append(System.lineSeparator());
        return null;
    }

    @Override
    public String visit(NestedConditionNode node)
    {
        visit(node.condition);
        return null;
    }

    @Override
    public String visit(IfBranchNode node)
    {
        if (node.condition instanceof BooleanLiteralNode)
        {
            if (((BooleanLiteralNode) node.condition).variablesValue.getText().equals("true"))
                visit(node.ifStatement);
            else if (node.thenStatement != null)
                visit(node.thenStatement);
            return null;
        }

        visit(node.condition);
        int temp = ++elseCount;
        program.append("    ifeq else_")
				.append(temp)
				.append(System.lineSeparator());
        visit(node.ifStatement);
        if (node.thenStatement != null)
            program.append("    goto finally_")
				.append(temp)
				.append(System.lineSeparator());
        program.append("  else_")
				.append(temp)
				.append(":")
				.append(System.lineSeparator());
        if (node.thenStatement != null)
        {
            visit(node.thenStatement);
            program.append("  finally_")
				.append(temp)
				.append(":")
				.append(System.lineSeparator());
        }
        return null;
    }

    @Override
    public String visit(LoopBranchNode node)
    {
        int temp = ++elseCount;
        program.append("finally_")
				.append(temp)
				.append(":")
				.append(System.lineSeparator());
        visit(node.condition);
        program.append("    ifeq else_")
				.append(temp)
				.append(System.lineSeparator());
        visit(node.statement);
        program.append("    goto finally_")
				.append(temp)
				.append(System.lineSeparator());
        program.append("  else_")
				.append(temp)
				.append(":")
				.append(System.lineSeparator());
        return null;
    }

    @Override
    public String visit(ScopeBranchNode node)
    {
        node.statementNodes.forEach(this::visit);
        return null;
    }

    @Override
    public String visit(InstatiateAtomNode node)
    {
        program.append("    new ")
				.append(node.className.valueString)
				.append(commentSpaces)
				.append("    ; creating object")
				.append(System.lineSeparator())
				.append("    dup")
				.append(commentSpaces)
				.append("         ; dup the object reference")
				.append(System.lineSeparator())
				.append("    invokespecial ")
				.append(node.className.valueString)
				.append("/<init>()V")
				.append(commentSpaces)
				.append("; Calling parent's constructor")
				.append(System.lineSeparator());
        return node.className.valueString;
    }

    @Override
    public String visit(NewIntArrayAtomNode node)
    {
        visit(node.size);
        program.append("    newarray int")
				.append(commentSpaces)
				.append("; initializing int array")
				.append(System.lineSeparator());
        return "array";
    }

    @Override
    public String visit(ParenExprAtomNode node)
    {
        return visit(node.expression);
    }

    @Override
    public String visit(RefThisAtomNode node)
    {
        program.append("    aload ")
				.append(getVar("this"))
				.append(commentSpaces)
				.append("    ; Reference this object");
        return null;
    }

    @Override
    public String visit(ObjectRefAtomNode node)
    {
        if (!node.methodName.isPresent())
        {
            String loader = getLoader(node.varName.valueString);
            if (loader.contains("getfield"))
            {
                program.append("    aload ")
                        .append(getVar("this"))
                        .append(System.lineSeparator())
                        .append("    ")
                        .append(loader)
                        .append(commentSpaces)
                        .append("    ; Getting object into field ")
                        .append(node.varName.valueString)
                        .append(System.lineSeparator());
            }
            else
            {
                program.append("    ")
                        .append(loader)
                        .append(getVar(node.varName.valueString))
                        .append(commentSpaces)
                        .append(" ; Getting ")
                        .append(node.varName.valueString)
                        .append("'s value from local pool")
                        .append(System.lineSeparator());
            }
        }
        else
        {
            String loader = getLoader(node.varName.valueString);
            if (loader.contains("getfield"))
            {
                program.append("    aload ")
                        .append(getVar("this"))
                        .append(System.lineSeparator())
                        .append("    ")
                        .append(loader)
                        .append(commentSpaces)
                        .append("    ; Getting object into field ")
                        .append(node.varName.valueString)
                        .append(System.lineSeparator());
            }
            else
            {
                program.append("    aload ")
                        .append(getVar(node.varName.valueString))
                        .append(commentSpaces)
                        .append("    ; Loading object")
                        .append(System.lineSeparator());
            }
            String name = node.methodName.get().valueString;
            node.expressions.get().forEach(this::visit);
            program.append("    invokevirtual ")
                    .append(getType(node.varName.valueString))
                    .append("/")
                    .append(node.methodName.get().valueString)
                    .append("(");
            List<ParameterNode> params = parameters.get(node.methodName.get().valueString);
            if (params.size() != node.expressions.get().size())
            {
                for (String p: parameters.keySet())
                {
                    if (p.contains(node.methodName.get().valueString))
                    {
                        List<ParameterNode> pa = parameters.get(p);
                        if (pa.size() == node.expressions.get().size())
                        {
                            boolean isGood = true;
                            Iterator<ExprNode> expr = node.expressions.get().iterator();
                            for (ParameterNode par : pa)
                            {
                                if (!par.type.getType().equals(expr.next()))
                                {
                                    isGood = false;
                                    break;
                                }
                            }
                            if (isGood)
                                pa.forEach(this::visit);
                        }
                    }
                }
            }
            else
            {
                params.forEach(this::visit);
            }
            program.append(")");
            String type = getType(node.varName.valueString);
            MethodNode methodNode = null;
            for (ClassNode classNode : classNames)
            {
                if (type.equals(classNode.className.valueString))
                {
                    methodNode = classNode.methodLookup(node.methodName.get().valueString);
                    if (methodNode != null)
                    {
                        program.append(getIdentifier(methodNode.typeNode.getType()));
                        break;
                    }
                }
            }
            program.append(System.lineSeparator());
            return (methodNode != null) ? methodNode.typeNode.getType() : null;
        }
        return node.varName.valueString;
    }

    private String getLoader(String valueString)
    {
        if (valueString.equals("this"))
            return "aload ";
        if (loader.get(valueString) == null && classLoader != null)
        {
            if (classLoader.get(valueString) != null)
                return String.valueOf(classLoader.get(valueString));
            for (ClassNode classNode: classNames)
                if (classNode.className.valueString.equals(currentClass))
                    if (classNode instanceof ChildClassNode && classNode.varLookup(valueString) != null)
                    {
                        HashMap<String, String> stringIntegerHashMap = loaderScopes.get(((ChildClassNode) classNode).parentClass.className.valueString);
                        if (stringIntegerHashMap.get(valueString) != null)
                            return String.valueOf(stringIntegerHashMap.get(valueString));
                        return deepSearch2(valueString, stringIntegerHashMap);
                    }
        }
        return String.valueOf(loader.get(valueString));
    }

    private String deepSearch2(String valueString, HashMap<String, String> stringIntegerHashMap)
    {
        if (stringIntegerHashMap.get(valueString) == null)
        {
            if (stringIntegerHashMap.get(valueString) != null)
                return String.valueOf(stringIntegerHashMap.get(valueString));
            for (ClassNode classNode: classNames)
                if (classNode.className.valueString.equals(currentClass))
                    if (classNode instanceof ChildClassNode && classNode.varLookup(valueString) != null)
                    {
                        HashMap<String, String> map = loaderScopes.get(((ChildClassNode) classNode).parentClass.className.valueString);
                        if (map.get(valueString) != null)
                            return String.valueOf(map.get(valueString));
                        return deepSearch2(valueString, map);
                    }
        }
        return String.valueOf(stringIntegerHashMap.get(valueString));
    }

    private String getStorer(String valueString)
    {
        if (valueString.equals("this"))
            return "astore ";
        if (storer.get(valueString) == null && classStorer != null)
        {
            if (classStorer.get(valueString) != null)
                return String.valueOf(classStorer.get(valueString));
            for (ClassNode classNode: classNames)
                if (classNode.className.valueString.equals(currentClass))
                    if (classNode instanceof ChildClassNode && classNode.varLookup(valueString) != null)
                    {
                        HashMap<String, String> stringIntegerHashMap = storerScopes.get(((ChildClassNode) classNode).parentClass.className.valueString);
                        if (stringIntegerHashMap.get(valueString) != null)
                            return String.valueOf(stringIntegerHashMap.get(valueString));
                        return deepSearch3(valueString, stringIntegerHashMap);
                    }
        }
        return String.valueOf(storer.get(valueString));
    }

    private String deepSearch3(String valueString, HashMap<String, String> stringIntegerHashMap)
    {
        if (stringIntegerHashMap.get(valueString) == null)
        {
            if (stringIntegerHashMap.get(valueString) != null)
                return String.valueOf(stringIntegerHashMap.get(valueString));
            for (ClassNode classNode: classNames)
                if (classNode.className.valueString.equals(currentClass))
                    if (classNode instanceof ChildClassNode && classNode.varLookup(valueString) != null)
                    {
                        HashMap<String, String> map = storerScopes.get(((ChildClassNode) classNode).parentClass.className.valueString);
                        if (map.get(valueString) != null)
                            return String.valueOf(map.get(valueString));
                        return deepSearch3(valueString, map);
                    }
        }
        return String.valueOf(stringIntegerHashMap.get(valueString));
    }

    @Override
    public String visit(MinusMathNode node)
    {
//        if (node.leftMathNode instanceof ObjectRefAtomNode)
//        {
//            program.append("    aload ")
//                    .append(getVar(((ObjectRefAtomNode) node.leftMathNode).varName.valueString))
//                    .append(System.lineSeparator());
//        }
        String name = visit(node.leftMathNode);
        visit(node.rightMathNode);
        TypeNode type = types.get(name);
        if (type instanceof ObjectTypeNode)
        {
            for (ClassNode classNode: classNames)
            {
                if (classNode.className.valueString.equals(type.getType()))
                {
                    OverloadMethodNode method = classNode.operatorMethodLookup("$operator_" + Operators.MINUS_SIGN.name());
                    if (method != null)
                    {
                        program.append("invokevirtual ")
                                .append(getType(name))
                                .append("/")
                                .append("$operator_").append(Operators.MINUS_SIGN.name())
                                .append("(");
                        parameters.get(method.methodName).forEach(this::visit);
                        program.append(")")
                                .append(getIdentifier(method.typeNode.getType()))
                                .append(System.lineSeparator());
                    }
                }
            }
        }
        else
        {
            program.append("    isub")
                    .append(commentSpaces)
                    .append("    ; Subtracting top elements on stack")
                    .append(System.lineSeparator());
        }
        return null;
    }

    @Override
    public String visit(MultMathNode node)
    {
//        if (node.leftMathNode instanceof ObjectRefAtomNode)
//        {
//            program.append("    aload ")
//                    .append(getVar(((ObjectRefAtomNode) node.leftMathNode).varName.valueString))
//                    .append(System.lineSeparator());
//        }
        String name = visit(node.leftMathNode);
        visit(node.rightMathNode);
        TypeNode type = types.get(name);
        if (type instanceof ObjectTypeNode)
        {
            for (ClassNode classNode: classNames)
            {
                if (classNode.className.valueString.equals(type.getType()))
                {
                    OverloadMethodNode method = classNode.operatorMethodLookup("$operator_" + Operators.MULT_SIGN.name());
                    if (method != null)
                    {
                        program.append("invokevirtual ")
                                .append(getType(name))
                                .append("/")
                                .append("$operator_").append(Operators.MULT_SIGN.name())
                                .append("(");
                        parameters.get(method.methodName).forEach(this::visit);
                        program.append(")")
                                .append(getIdentifier(method.typeNode.getType()))
                                .append(System.lineSeparator());
                    }
                }
            }
        }
        else
        {
            program.append("    imul")
                .append(commentSpaces)
                .append("    ; Multiplying top elements on stack")
                .append(System.lineSeparator());
        }
        return null;
    }

    @Override
    public String visit(PlusMathNode node)
    {
//        if (node.leftMathNode instanceof ObjectRefAtomNode)
//        {
//            program.append("    aload ")
//                    .append(getVar(((ObjectRefAtomNode) node.leftMathNode).varName.valueString))
//                    .append(System.lineSeparator());
//        }
        String name = visit(node.leftMathNode);
        visit(node.rightMathNode);
        TypeNode type = types.get(name);
        if (type instanceof ObjectTypeNode)
        {
            for (ClassNode classNode: classNames)
            {
                if (classNode.className.valueString.equals(type.getType()))
                {
                    OverloadMethodNode method = classNode.operatorMethodLookup("$operator_" + Operators.PLUS_SIGN.name());
                    if (method != null)
                    {
                        program.append("invokevirtual ")
                            .append(getType(name))
                            .append("/")
                            .append("$operator_").append(Operators.PLUS_SIGN.name())
                            .append("(");
                        parameters.get(method.methodName).forEach(this::visit);
                        program.append(")")
                                .append(getIdentifier(method.typeNode.getType()))
                                .append(System.lineSeparator());
                    }
                }
            }
        }
        else
        {
            program.append("    iadd")
                .append(commentSpaces)
                .append("    ; Adding top elements on stack")
                .append(System.lineSeparator());
        }
        return null;
    }

    @Override
    public String visit(ArrayAccessExprNode node)
    {
        if (node.varName instanceof ObjectRefAtomNode)
        {
//            visit(node.element);
            visit(node.varName);
//            program.append("    aload ")
//				.append(getVar(((ObjectRefAtomNode) node.varName).varName.valueString))
//				.append(commentSpaces)
//				.append("    ; accessing array in memory")
//				.append(System.lineSeparator());
            visit(node.element);
            program.append("    iaload")
				.append(commentSpaces)
				.append("    ; pulling int from array")
				.append(System.lineSeparator());
        }
        else if (node.varName instanceof ParenExprAtomNode)
        {
            visit(node.varName);
            visit(node.element);
            program.append("    iaload")
                    .append(commentSpaces)
                    .append("    ; pulling int from array")
                    .append(System.lineSeparator());
        }
        return null;
    }

    @Override
    public String visit(ArrayLengthExprNode node)
    {
        if (node.arrayVar instanceof ObjectRefAtomNode)
        {
            visit(node.arrayVar);
            program.append("    arraylength")
				.append(commentSpaces)
				.append("    ; getting length of loaded array")
				.append(System.lineSeparator());
        }
        return null;
    }

    @Override
    public String visit(CalcExprNode node)
    {
        visit(node.mathCalculation);
        return null;
    }

    @Override
    public String visit(MethodCallExprNode node)
    {
        // invokevirtual mypackage/MyClass/foo(Ljava/lang/Object;[I)I
        String type = visit(node.objectName);
        if ((node.objectName instanceof ParenExprAtomNode || node.objectName instanceof InstatiateAtomNode) && type != null)
        {
            for (ClassNode classNode: classNames)
            {
                if (classNode.className.valueString.equals(type))
                {
                    MethodNode method = classNode.methodLookup(node.methodName.valueString);
                    if (method != null)
                    {
                        node.expressions.forEach(this::visit);
                        program.append("    invokevirtual ")
                                .append(type)
                                .append("/")
                                .append(node.methodName.valueString)
                                .append("(");
                        parameters.get(node.methodName.valueString).forEach(this::visit);
                        program.append(")")
                                .append(getIdentifier(method.typeNode.getType()))
                                .append(System.lineSeparator());
                    }
                }
            }
        }
        return type;
    }

    private String getType(String varName)
    {
        if (varName.equals("this"))
            return currentClass;
        return types.get(varName).getType();
    }

    @Override
    public String visit(TrailingExprNode node)
    {
        visit(node.atom);
        if (node.operator == Operators.MINUS_SIGN)
            program.append("    ineg")
				.append(commentSpaces)
				.append("    ; Negating number")
				.append(System.lineSeparator());
        return null;
    }
}
