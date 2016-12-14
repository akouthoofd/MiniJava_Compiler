package my.mini.java.compiler.AST;

import my.mini.java.compiler.AST.nodes.classes.ChildClassNode;
import my.mini.java.compiler.AST.nodes.classes.ClassNode;
import my.mini.java.compiler.AST.nodes.classes.MainClassNode;
import my.mini.java.compiler.AST.nodes.classes.SimpleClassNode;
import my.mini.java.compiler.AST.nodes.formal_list.ParameterNode;
import my.mini.java.compiler.AST.nodes.literals.BooleanLiteralNode;
import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;
import my.mini.java.compiler.AST.nodes.literals.IntLiteralNode;
import my.mini.java.compiler.AST.nodes.literals.StringLiteralNode;
import my.mini.java.compiler.AST.nodes.methods.BasicMethodNode;
import my.mini.java.compiler.AST.nodes.methods.MainMethodNode;
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
import my.mini.java.compiler.AST.nodes.type.*;
import my.mini.java.compiler.AST.nodes.variable.VarDeclarationNode;
import my.mini.java.compiler.AST.symbol.Symbol;
import my.mini.java.compiler.AST.symbol.SymbolTable;
import my.mini.java.compiler.Exceptions.ClassNotFoundException;
import my.mini.java.compiler.Exceptions.*;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by alex on 11/28/2016.
 */
public class EvaluatedASTVisitor extends ASTVisitor<TypeNode>
{
    private StringBuilder stringBuilder;
    private SymbolTable symbolTable;
    private List<ClassNode> classNames;
    private ClassNode currentClass;
    private MethodNode currentMethod;
    private String sourceName;
    private String mainClassName;
    private HashMap<String, List<ParameterNode>> parameters = new HashMap<>();
//    private ErrorReporter errorReporter;

    public EvaluatedASTVisitor(String sourceName)
    {
        this.sourceName = sourceName;
        classNames = new ArrayList<>();
        currentClass = null;
        currentMethod = null;
        stringBuilder = new StringBuilder("");
        symbolTable = new SymbolTable();
    }

    public HashMap<String, List<ParameterNode>> getParameters()
    {
        return parameters;
    }

    public List<ClassNode> getClassNames()
    {
        return classNames;
    }

    public String getMainClassName()
    {
        return mainClassName;
    }

    @Override
    public TypeNode visit(ProgramNode node)
    {
        classNames = node.classNodes;
        classNames.add(node.mainClassNode);
        mainClassName = node.mainClassNode.className.valueString;
        TypeNode.classes = classNames;
        stringBuilder.append(visit(node.mainClassNode));
        node.classNodes.forEach(this::visit);
        return new ObjectTypeNode(node.mainClassNode.className);
    }

    @Override
    public TypeNode visit(MainClassNode node)
    {
        currentClass = node;
        currentMethod = new MainMethodNode();
        symbolTable.enterScope();
        // String[] for main method is the only of its kind (And will likely never be used)
        symbolTable.addSymbol(new Symbol(node.paramName.value, new StringTypeNode(new IdLiteralNode(node.mainArg)),  new StringLiteralNode()));
        node.varDeclarationNodes.forEach(this::visit);
        node.statementNodes.forEach(this::visit);
        // No return needed.
        symbolTable.exitScope();
        currentMethod = null;
        return new ObjectTypeNode(node.className);
    }

    @Override
    public TypeNode visit(SimpleClassNode node)
    {
        currentClass = node;
        symbolTable.enterScope();
        visit(node.className);
        node.varDeclarationNodes.forEach(this::visit);
        node.methodNodes.forEach(this::visit);
        node.operatorNodes.forEach(this::visit);
        symbolTable.exitScope();
        return new ObjectTypeNode(node.className);
    }

    @Override
    public TypeNode visit(ChildClassNode node)
    {
        currentClass = node;
        symbolTable.enterScope();
        visit(node.className);
        visit(node.extendsClass);
        node.varDeclarationNodes.forEach(this::visit);
        node.methodNodes.forEach(this::visit);
        node.operatorNodes.forEach(this::visit);
        symbolTable.exitScope();
        return new ObjectTypeNode(node.className);
    }

    @Override
    public TypeNode visit(ParameterNode node)
    {
        Symbol paramVar = new Symbol(node.name.value, node.type, node);
        if (symbolTable.checkScope(paramVar))
            throw new VariableAlreadyDeclaredException("Variable " + node.name.value.getText() + " has already been declared.", node.name.value, sourceName);
        symbolTable.addSymbol(paramVar);
        node.type.initialize();
        return node.type;
    }

    @Override
    public TypeNode visit(VarDeclarationNode node)
    {
        Symbol varDecl = new Symbol(node.varName.value, node.type, node);
        if (symbolTable.checkScope(varDecl))
            throw new VariableAlreadyDeclaredException("Variable " + node.varName.value.getText() + " has already been declared.", node.varName.value, sourceName);
        if (currentMethod == null)
            node.type.initialize();
        symbolTable.addSymbol(varDecl);
        return node.type;
    }

    @Override
    public TypeNode visit(BooleanLiteralNode node)
    {
        return new BooleanTypeNode(node.value);
    }

    @Override
    public TypeNode visit(IdLiteralNode node)
    {
        Symbol symbol = symbolTable.findSymbol(node.value.getText());
        if (symbol != null)
            return symbol.type;
        VarDeclarationNode varNode = currentClass.varLookup(node.value.getText());
        if (varNode != null)
            return varNode.type;

        for (ClassNode classNode: classNames)
            if (classNode.className.valueString.equals(node.valueString))
            {
                ClassTypeNode classTypeNode = new ClassTypeNode(node);
                classTypeNode.initialize();
                return classTypeNode;
            }

        if (node.valueString.equals("this"))
        {
            ThisTypeNode thisTypeNode = new ThisTypeNode(currentClass.className);
            thisTypeNode.initialize();
            return thisTypeNode;
        }

        throw new VariableNotDeclaredException("Variable " + node.value.getText() + " is not declared.",
                currentClass.className.value, node.value, sourceName);
    }

    @Override
    public TypeNode visit(IntLiteralNode node)
    {
        return new IntTypeNode("int", node.value);
    }

    @Override
    public TypeNode visit(BasicMethodNode node)
    {
        currentMethod = node;
        symbolTable.enterScope();
        if (parameters.putIfAbsent(currentMethod.methodName, node.parameters) != null)
            parameters.put(currentMethod.methodName+"_"+parameters.size(), node.parameters);
        node.parameters.forEach(this::visit);
        node.varDeclarationNodes.forEach(this::visit);
        node.statementNodes.forEach(this::visit);
        TypeNode rtnType = visit(node.returnExpression);
        if (!node.typeNode.matches(rtnType))
            throw new IncorrectReturnType(node.methodName + "() returns a(n) " + node.typeNode.getType() + " and you return a(n) " + rtnType.getType(),
                    currentClass.className.value, node.methodName, node.retn, sourceName);
        symbolTable.exitScope();
        currentMethod = null;
        return node.typeNode;
    }

    @Override
    public TypeNode visit(OverloadMethodNode node)
    {
        currentMethod = node;
        symbolTable.enterScope();
        if (parameters.putIfAbsent(currentMethod.methodName, Arrays.asList(node.parameter)) != null)
            parameters.put(currentMethod.methodName+"_"+parameters.size(), Arrays.asList(node.parameter));
        visit(node.parameter);
        node.varDeclarationNodes.forEach(this::visit);
        node.statementNodes.forEach(this::visit);
        TypeNode rtnType = visit(node.returnExpression);
        if (!node.typeNode.matches(rtnType))
            throw new IncorrectReturnType(node.methodName + "() returns a(n) " + node.typeNode.getType() + " and you return a(n) " + rtnType.getType(),
                    currentClass.className.value, node.methodName, node.retn, sourceName);
        symbolTable.exitScope();
        currentMethod = null;
        return node.typeNode;
    }

    @Override
    public TypeNode visit(ArrayAssignAssertNode node)
    {
        TypeNode var = visit(node.varName); //IntArray
        if (!(var instanceof IntArrayTypeNode))
            throw new NotAnArrayException(node.varName.valueString + " is not an int array.", currentClass.className.value,
                    currentMethod.methodName, node.varName.value, sourceName);
        TypeNode ele = visit(node.element); //Int
        if (!(ele instanceof IntTypeNode))
            throw new InvalidIndexException(node.element + " is not a valid index. (int)", currentClass.className.value,
                    currentMethod.methodName, node.varName.value, sourceName);
        TypeNode exp = visit(node.expression); //Int
        if (!(exp instanceof IntTypeNode))
            throw new IncompatibleTypesError(node.expression + " is not a valid expression. Needs to return an int but returns " + exp.getType(), currentClass.className.value, currentMethod.methodName, node.varName.value, sourceName);
        return exp;
    }

    @Override
    public TypeNode visit(AssignAssertNode node)
    {
        TypeNode retnType = visit(node.varName);
        if (retnType instanceof ThisTypeNode)
            retnType = new ObjectTypeNode(currentClass.className);
        TypeNode exprType = visit(node.expression);
        if (exprType instanceof ThisTypeNode)
            exprType = new ObjectTypeNode(currentClass.className);
        if (!exprType.matches(retnType))
            throw new IncompatibleTypesError( exprType.getType() + " is not cast-able to " + retnType.getType(),
                    currentClass.className.value, currentMethod.methodName, node.varName.value, sourceName);
        retnType.initialize();
        return retnType;
    }

    @Override
    public TypeNode visit(PrintAssertNode node)
    {
        TypeNode type = visit(node.expression);
        if (!(type instanceof IntTypeNode))
            throw new IncompatibleTypesError("Println's must have expressions that resolve to an int. Was: " + type.getClass(),
                    currentClass.className.value, currentMethod.methodName, node.location, sourceName);
        return type;
    }

    @Override
    public TypeNode visit(AndConditionNode node)
    {
        TypeNode type1 = visit(node.leftCondition);
        TypeNode type2 = visit(node.rightCondition);
        return getType(type1, type2, Operators.AND_SIGN);
    }

    @Override
    public TypeNode visit(LessThanConditionNode node)
    {
        TypeNode type1 = visit(node.leftCondition);
        TypeNode type2 = visit(node.rightCondition);
        return getType(type1, type2, Operators.LESS_THAN_SIGN);
    }

    /**
     * Returns type of operation or throws an error if no viable options
     * @param type1
     *      Type of the first condition in operation
     * @param type2
     *      Type of the second condition in operation
     * @param operator
     *      The operation being performed on above types
     * @return
     *      Type returned by the operation
     * @throws NoViableOperatorException
     *      When user tries an operation on variable that doesn't support said operation
     */
    private TypeNode getType(TypeNode type1, TypeNode type2, Operators operator)
    {
        if (type1 instanceof IntTypeNode && type2 instanceof IntTypeNode || type1 instanceof BooleanTypeNode && type2 instanceof BooleanTypeNode)
        {
            switch (operator)
            {
                case AND_SIGN:
                case LESS_THAN_SIGN:
                    return new BooleanTypeNode(type2);
                case MINUS_SIGN:
                case MULT_SIGN:
                case PLUS_SIGN:
                    return new IntTypeNode(type2);
                default:
                    throw new IllegalOperatorException(operator + " doesn't exists!");
            }
        }else
        {
            // Operator overload checking happens here
            for (ClassNode classNode: classNames)
            {
                if (classNode.className.valueString.equals(type1.type.valueString))
                {
                    MethodNode methodNode = classNode.operatorMethodLookup("$operator_" + operator.name());
                    if (methodNode != null && type2.matches(((OverloadMethodNode)methodNode).parameter.type))
                        return methodNode.typeNode;
                }
            }
        }
        throw new NoViableOperatorException(type1.getType() + " and " + type2.getType() + " cannot be resolved with the " + operator.getSign() + " operator.",
                currentClass.className.value, currentMethod.methodName, type1.loc, sourceName);
    }


    @Override
    public TypeNode visit(NotConditionNode node)
    {
        TypeNode condition = visit(node.condition);
        if (!(condition instanceof BooleanTypeNode))
            throw new InvalidIndexException(condition.getType() + " is not a conditional. Must be of type boolean.",
                    currentClass.className.value, currentMethod.methodName, condition.loc, sourceName);
        return condition;
    }

    @Override
    public TypeNode visit(NestedConditionNode node)
    {
        return visit(node.condition);
    }

    @Override
    public TypeNode visit(IfBranchNode node)
    {
        TypeNode condition = visit(node.condition);
        if (!(condition instanceof BooleanTypeNode))
            throw new InvalidIndexException(condition.getType() + " is not a conditional. Must be of type boolean.",
                    currentClass.className.value, currentMethod.methodName, condition.loc, sourceName);
        visit(node.ifStatement);
        if (node.thenStatement != null)
            visit(node.thenStatement);
        // If branches type should be ignored. Too ensure that it's given invalid type.
        return new ObjectTypeNode(null);
    }

    @Override
    public TypeNode visit(LoopBranchNode node)
    {
        TypeNode condition = visit(node.condition);
        if (!(condition instanceof BooleanTypeNode))
            throw new InvalidIndexException(condition.getType() + " is not a conditional. Must be of type boolean.",
                    currentClass.className.value, currentMethod.methodName, condition.loc, sourceName);
        visit(node.statement);
        // Loops type should be ignored. Too ensure that it's given invalid type.
        return new ObjectTypeNode(null);
    }

    @Override
    public TypeNode visit(ScopeBranchNode node)
    {
        symbolTable.enterScope();
        node.statementNodes.forEach(this::visit);
        symbolTable.exitScope();
        // Scopes type should be ignored. Too ensure that it's given invalid type.
        return new ObjectTypeNode(null);
    }

    @Override
    public TypeNode visit(InstatiateAtomNode node)
    {
        for (ClassNode classNode: classNames)
        {
            if (node.className.valueString.equals(classNode.className.valueString))
            {
                // 35 is ID token
                Token token = new CommonToken(35, getNewObject(node.className.valueString));
                ObjectTypeNode objectTypeNode = new ObjectTypeNode(node.className);
                symbolTable.addSymbol(new Symbol(token, objectTypeNode, node));
                objectTypeNode.initialize();
                return objectTypeNode;
            }
        }
        throw new ClassNotFoundException(node.className.valueString + " has not be declared.", currentClass.className.value, sourceName);
    }

    private String getNewObject(String valueString)
    {
        int count = -1;
        while(symbolTable.findSymbol(valueString + "_" + ++count) != null);
        return valueString + "_" + count;
    }

    @Override
    public TypeNode visit(NewIntArrayAtomNode node)
    {
        TypeNode size = visit(node.size);
        if (!(size instanceof IntTypeNode))
            throw new InvalidIndexException(node.size + " is of type " + size.getType() + " instead of the required int.",
                    currentClass.className.value, currentMethod.methodName, node.loc, sourceName);
        return new IntArrayTypeNode(size.loc);
    }

    @Override
    public TypeNode visit(ParenExprAtomNode node)
    {
        return visit(node.expression);
    }

    @Override
    public TypeNode visit(RefThisAtomNode node)
    {
        return node.type;
    }

    @Override
    public TypeNode visit(ObjectRefAtomNode node)
    {
        TypeNode type1 = visit(node.varName);
        if (!type1.isInitialized())
            throw new VariableNotInitializedException("'" + node.varName.valueString + "' variable has not been initialized.",
                    currentClass.className.value, currentMethod.methodName, node.varName.value, sourceName);
        TypeNode type3 = null;
        if (node.expressions.isPresent())
        {
            ArrayList<TypeNode> expectedTypes = new ArrayList<>();
            for (ExprNode exprNode: node.expressions.get())
                expectedTypes.add(visit(exprNode));

            List<TypeNode> actualNodes = new ArrayList<>();
            for (ClassNode classNode : classNames)
            {
                if ((type1 instanceof ThisTypeNode) || type1.getType().equals(classNode.className.valueString))
                {
                    List<MethodNode> methods;
                    currentClass.clearMethods();
                    classNode.clearMethods();
                    if (type1 instanceof ThisTypeNode)
                        methods = currentClass.advancedMethodLookup(node.methodName.get().valueString);
                    else
                        methods = classNode.advancedMethodLookup(node.methodName.get().valueString);
                    MethodNode method = null;
                    for (MethodNode m: methods)
                    {
                        boolean matches = true;
                        if (m instanceof BasicMethodNode)
                        {
                            if (((BasicMethodNode) m).parameters.size() == node.expressions.get().size())
                            {
                                for (int i = 0; i < ((BasicMethodNode) m).parameters.size(); i++)
                                {
                                    if (!(visit(node.expressions.get().get(i)).matches(((BasicMethodNode) m).parameters.get(i).type)))
                                    {
                                        matches = false;
                                        break;
                                    }
                                }
                            }
                            else
                                matches = false;
                        }
                        if (matches)
                        {
                            method = m;
                            break;
                        }
                    }
                    if (method == null)
                        throw new MethodDoesNotExist(node.methodName.get().valueString + " does not have an overload with the required parameters",
                                                        currentClass.className.value, currentMethod.methodName, node.methodName.get().value, sourceName);
                    if (method instanceof BasicMethodNode)
                        for (ParameterNode parameterNode : ((BasicMethodNode) method).parameters)
                            actualNodes.add(parameterNode.type);
                    if (method == null)
                        throw new MethodDoesNotExist("class " + type1.getType() + " does not have a(n) " + node.methodName.get().valueString + "() method",
                                                            currentClass.className.value, currentMethod.methodName, node.methodName.get().value, sourceName);
                    type3 = method.typeNode;
                    type3.initialize();
                    break;
                }
            }
            if (expectedTypes.size() != actualNodes.size())
                throw new IncorrectNumberOfParameters("The parameters don't match up. Expected: " + expectedTypes.size() + " but Found: " + actualNodes.size(),
                        currentClass.className.value, currentMethod.methodName, node.varName.value, sourceName);
            for (int i = 0; i < actualNodes.size(); i++)
                if (!expectedTypes.get(i).matches(actualNodes.get(i)))
                    throw new IncompatibleTypesError("Incompatible parameters.",
                            currentClass.className.value, currentMethod.methodName, actualNodes.get(i).loc, sourceName);
        }

        return (type3 == null) ? type1 : type3;
    }

    @Override
    public TypeNode visit(MinusMathNode node)
    {
        TypeNode type1 = visit(node.leftMathNode);
        TypeNode type2 = visit(node.rightMathNode);
        return getType(type1, type2, Operators.MINUS_SIGN);
    }

    @Override
    public TypeNode visit(MultMathNode node)
    {
        TypeNode type1 = visit(node.leftMathNode);
        TypeNode type2 = visit(node.rightMathNode);
        return getType(type1, type2, Operators.MULT_SIGN);
    }

    @Override
    public TypeNode visit(PlusMathNode node)
    {
        TypeNode type1 = visit(node.leftMathNode);
        TypeNode type2 = visit(node.rightMathNode);
        return getType(type1, type2, Operators.PLUS_SIGN);
    }

    @Override
    public TypeNode visit(ArrayAccessExprNode node)
    {
        TypeNode var = visit(node.varName);
        if (!(var instanceof IntArrayTypeNode))
            throw new IncompatibleTypesError(var.getType() + " cannot be cast into an int[]",
                    currentClass.className.value, currentMethod.methodName, var.loc, sourceName);
        TypeNode ele = visit(node.element);
        if (!(ele instanceof IntTypeNode))
            throw new InvalidIndexException(node.element + " is not a valid index. (int)",
                    currentClass.className.value, currentMethod.methodName, ele.loc, sourceName);
        return ele;
    }

    @Override
    public TypeNode visit(ArrayLengthExprNode node)
    {
        TypeNode length = visit(node.arrayVar);
        if (!(length instanceof IntArrayTypeNode))
            throw new InvalidIndexException(length.getType() + " is not a valid index. Must be an int.",
                    currentClass.className.value, currentMethod.methodName, length.loc, sourceName);
        // length.loc is a poor stack trace! It points at the variable declaration not the actual var.length call
        return new IntTypeNode(length.loc);
    }

    @Override
    public TypeNode visit(CalcExprNode node)
    {
        return visit(node.mathCalculation);
    }

    @Override
    public TypeNode visit(MethodCallExprNode node)
    {
        TypeNode typeNode = visit(node.objectName);
        if (typeNode instanceof ThisTypeNode)
        {
            List<MethodNode> methods = currentClass.advancedMethodLookup(node.methodName.valueString);
            MethodNode method = null;
            for (MethodNode m: methods)
            {
                boolean matches = true;
                if (m instanceof BasicMethodNode)
                {
                    if (((BasicMethodNode) m).parameters.size() == node.expressions.size())
                    {
                        for (int i = 0; i < ((BasicMethodNode) m).parameters.size(); i++)
                        {
                            if (!((BasicMethodNode) m).parameters.get(i).type.getType().equals(visit(node.expressions.get(i)).getType()))
                            {
                                matches = false;
                                break;
                            }
                        }
                    }
                    else
                        matches = false;
                }
                if (matches)
                {
                    method = m;
                    break;
                }
            }
            if (method == null)
                throw new MethodDoesNotExist(method.methodName + " does not have an overload with the required parameters",
                        currentClass.className.value, currentMethod.methodName, node.methodName.value, sourceName);

            if (method instanceof BasicMethodNode)
            {
                List<ParameterNode> parameterNodes = ((BasicMethodNode) method).parameters;
                for (int i = 0; i < parameterNodes.size(); i++)
                    if (!visit(node.expressions.get(i)).matches(parameterNodes.get(i).type))
                        throw new IncompatibleTypesError("Incompatible parameters.",
                                currentClass.className.value, currentMethod.methodName, typeNode.loc, sourceName);
                if (method.methodName.equals(currentMethod.methodName))
                    ;// Should log warning of recursion here
                return method.typeNode;
            }
            else if (method instanceof OverloadMethodNode)
            {
                if (node.expressions.size() != 1)
                    throw new IncorrectNumberOfParameters("There are " + node.expressions.size() + " parameters when there should only be 1.", currentClass.className.value, currentMethod.methodName, typeNode.loc, sourceName);
                if (!(visit(node.expressions.get(0)).matches(((OverloadMethodNode) method).parameter.type)))
                    throw new IncompatibleTypesError("Incompatible parameters.",
                            currentClass.className.value, currentMethod.methodName, typeNode.loc, sourceName);
                if (method.methodName.equals(currentMethod.methodName))
                    ;// Should log warning of recursion here
                return method.typeNode;
            }
            else
            {
                // Can you call the main method?
            }
        }
        else
        {
            TypeNode variableType = null;
            if (node.objectName instanceof ObjectRefAtomNode)
                variableType = visit(((ObjectRefAtomNode) node.objectName).varName);
            else if (node.objectName instanceof InstatiateAtomNode)
                variableType = new ObjectTypeNode(((InstatiateAtomNode) node.objectName).className);
            else if (node.objectName instanceof ParenExprAtomNode)
                variableType = typeNode;

            if (variableType instanceof ThisTypeNode)
            {
                List<MethodNode> methods = currentClass.advancedMethodLookup(node.methodName.valueString);
                MethodNode method = null;
                for (MethodNode m: methods)
                {
                    boolean matches = true;
                    if (m instanceof BasicMethodNode)
                    {
                        if (((BasicMethodNode) m).parameters.size() == node.expressions.size())
                        {
                            for (int i = 0; i < ((BasicMethodNode) m).parameters.size(); i++)
                            {
                                if (!((BasicMethodNode) m).parameters.get(i).type.getType().equals(visit(node.expressions.get(i)).getType()))
                                {
                                    matches = false;
                                    break;
                                }
                            }
                        }
                        else
                            matches = false;
                    }
                    if (matches)
                    {
                        method = m;
                        break;
                    }
                }
                if (method == null)
                    throw new MethodDoesNotExist(method.methodName + " does not have an overload with the required parameters",
                            currentClass.className.value, currentMethod.methodName, node.methodName.value, sourceName);


                if (method instanceof BasicMethodNode)
                {
                    List<ParameterNode> parameterNodes = ((BasicMethodNode) method).parameters;
                    for (int i = 0; i < parameterNodes.size(); i++)
                        if (!visit(node.expressions.get(i)).matches(parameterNodes.get(i).type))
                            throw new IncompatibleTypesError("Incompatible parameters.",
                                    currentClass.className.value, currentMethod.methodName, typeNode.loc, sourceName);
                    if (method.methodName.equals(currentMethod.methodName))
                        ;// Should log warning of recursion here
                    return method.typeNode;
                }
                else if (method instanceof OverloadMethodNode)
                {
                    if (node.expressions.size() != 1)
                        throw new IncorrectNumberOfParameters("There are " + node.expressions.size() + " parameters when there should only be 1.", currentClass.className.value, currentMethod.methodName, typeNode.loc, sourceName);
                    if (!(visit(node.expressions.get(0)).matches(((OverloadMethodNode) method).parameter.type)))
                        throw new IncompatibleTypesError("Incompatible parameters.",
                                currentClass.className.value, currentMethod.methodName, typeNode.loc, sourceName);
                    if (method.methodName.equals(currentMethod.methodName))
                        ;// Should log warning of recursion here
                    return method.typeNode;
                }
                else
                {
                    // Can you call the main method?
                }
            }
            else if (variableType != null)
            {
                for (ClassNode classNode : classNames)
                {
                    if (classNode.className.valueString.equals(variableType.type.valueString))
                    {
                        classNode.clearMethods();
                        List<MethodNode> methods = classNode.advancedMethodLookup(node.methodName.valueString);
                        if (methods.size() == 0)
                            throw new MethodDoesNotExist(node.methodName.valueString + " does not exist.", currentClass.className.value,
                                                            currentMethod.methodName, node.methodName.value, sourceName);
                        for (MethodNode methodNode: methods)
                        {
                            if (methodNode instanceof BasicMethodNode)
                            {
                                List<ParameterNode> parameterNodes = ((BasicMethodNode) methodNode).parameters;
                                if (node.expressions.size() < parameterNodes.size())
                                    continue;
                                for (int i = 0; i < parameterNodes.size(); i++)
                                    if (!visit(node.expressions.get(i)).matches(parameterNodes.get(i).type))
                                        continue;
                                if (methodNode.methodName.equals(currentMethod.methodName))
                                    ;// Should log warning of recursion here
                                return methodNode.typeNode;
                            }
                            else if (methodNode instanceof OverloadMethodNode)
                            {
                                if (node.expressions.size() != 1)
                                    throw new IncorrectNumberOfParameters("There are " + node.expressions.size() + " parameters when there should only be 1.", currentClass.className.value, currentMethod.methodName, typeNode.loc, sourceName);
                                if (!(visit(node.expressions.get(0)).matches(((OverloadMethodNode) methodNode).parameter.type)))
                                    throw new IncompatibleTypesError("Incompatible parameters.",
                                            currentClass.className.value, currentMethod.methodName, typeNode.loc, sourceName);
                                if (methodNode.methodName.equals(currentMethod.methodName))
                                    ;// Should log warning of recursion here
                                return methodNode.typeNode;
                            }
                            else
                            {
                                // Can you call the main method?
                            }
                        }
                        throw new IncompatibleTypesError("Incompatible parameters.",
                                currentClass.className.value, currentMethod.methodName, (typeNode.loc == null) ? typeNode.type.value : typeNode.loc, sourceName);
                    }
                }
            }
        }
        return typeNode;
//        throw new MethodDoesNotExist(node.methodName.valueString + " does not exist.", currentClass.className.value, currentMethod.methodName, node.methodName.value, sourceName);
    }

    @Override
    public TypeNode visit(TrailingExprNode node)
    {
        // Operator
        return visit(node.atom);
    }
}
