package my.mini.java.compiler;

import my.mini.java.compiler.Exceptions.*;
import my.mini.java.compiler.Scopes.*;
import my.mini.java.parser.MiniJavaBaseListener;
import my.mini.java.parser.MiniJavaParser;

import java.util.HashMap;
import java.util.List;

/**
 * Created by alex on 11/8/2016.
 */
public class MyListener extends MiniJavaBaseListener
{
    private final String sourceName;
    private int blockCount;
    private int ifCount;
    private int loopCount;
    private Scope currentScope;
    private HashMap<String, Klass> klassHashMap = new HashMap<>();


    public MyListener(String sourceName)
    {
        super();
        this.sourceName = sourceName;
        blockCount = 0;
        ifCount = 0;
        loopCount = 0;
        currentScope = null;
    }

    public Scope getCurrentScope()
    {
        return currentScope;
    }

    @Override
    public void enterProg(MiniJavaParser.ProgContext ctx)
    {
    }

    @Override
    public void enterMain(MiniJavaParser.MainContext ctx)
    {
        if (currentScope == null)
            currentScope = new MainKlass(ctx.className.getText());
        if(klassHashMap.putIfAbsent(ctx.className.getText(), new Klass(ctx.className.getText(), currentScope)) != null)
            throw new ClassAlreadyDeclaredException(ctx.className.getText() + " has already been declared.", ctx.className, sourceName);
        if (currentScope.exists(ctx.paramName.getText()))
            throw new VariableAlreadyDeclaredException("Variable has already been declared.", ctx.paramName, sourceName);
        currentScope.addItem(new Variable(ctx.paramName.getText(), "String[]", currentScope));
    }

    @Override
    public void exitMain(MiniJavaParser.MainContext ctx)
    {
        currentScope = null;
    }

    @Override
    public void enterClass(MiniJavaParser.ClassContext ctx)
    {
        if (currentScope == null)
            currentScope = new Klass(ctx.className.getText());
        if (klassHashMap.putIfAbsent(ctx.className.getText(), new Klass(ctx.className.getText(), currentScope)) != null)
            throw new ClassAlreadyDeclaredException(ctx.className.getText() + " has already been declared.", ctx.className, sourceName);
    }

    @Override
    public void exitClass(MiniJavaParser.ClassContext ctx)
    {
        currentScope = null;
    }

    @Override
    public void enterChildClass(MiniJavaParser.ChildClassContext ctx)
    {
        if (currentScope == null)
            currentScope = new Klass(ctx.className.getText());
        if (klassHashMap.putIfAbsent(ctx.className.getText(), new Klass(ctx.className.getText(), currentScope)) != null)
            throw new ClassAlreadyDeclaredException(ctx.className.getText() + " has already been declared.", ctx.className, sourceName);
    }

    @Override
    public void exitChildClass(MiniJavaParser.ChildClassContext ctx)
    {
        currentScope = null;
    }

    @Override
    public void enterMethodDecl(MiniJavaParser.MethodDeclContext ctx)
    {
        if (currentScope == null)
            throw new OutOfScopeException("Method out of class scope. How did you even get this message?!", ctx.methodName, sourceName);
        if (currentScope.exists(ctx.methodName.getText()))
        {
            ((Klass)currentScope).clearMethods();
            List<Method> methods = ((Klass) currentScope).getAdvancedMethod(ctx.methodName.getText());
            for (Method method: methods)
            {
                if (method.getReturnType().equals(ctx.type().getText()))
                {
                    List<MiniJavaParser.FormalListContext> params = ctx.formalList();
                    List<MiniJavaParser.FormalListContext> methodsParams = method.getParameters();
                    if (params.size() == 0 && methodsParams.size() == 0)
                        throw new MethodAlreadyDeclaredException(ctx.methodName.getText() + " has already been declared.", ctx.methodName, sourceName);
                    if (params.size() == methodsParams.size())
                    {
                        boolean identical = true;
                        for (int i = 0; i < params.size(); i++)
                            if (!params.get(i).start.getText().equals(methodsParams.get(i).start.getText()))
                                identical = false;
                        if (identical)
                            throw new MethodAlreadyDeclaredException(ctx.methodName.getText() + " has already been declared.", ctx.methodName, sourceName);
                    }
                }
                else
                {
                    throw new MethodAlreadyDeclaredException(ctx.methodName.getText() + " has already been declared.", ctx.methodName, sourceName);
                }
            }
        }
        Scope newScope = new Method(ctx.methodName.getText(), ctx.type().getText(), ctx.formalList(), currentScope);
        currentScope.addItem(newScope);
        currentScope = newScope;
    }

    @Override
    public void exitMethodDecl(MiniJavaParser.MethodDeclContext ctx)
    {
        ifCount = 0;
        blockCount = 0;
        currentScope = currentScope.getParentScope().get();
    }

    @Override
    public void enterOperatorDecl(MiniJavaParser.OperatorDeclContext ctx)
    {
        String overload = "operator" + ctx.operator.getText();
        if (currentScope == null)
            throw new OutOfScopeException("Method out of class scope. How did you even get this message?!", ctx.getStart(), sourceName);
        if (currentScope.exists(overload))
        {
            ((Klass)currentScope).clearMethods();
            Overload method = ((Klass) currentScope).getOverloadMethod(overload);
            if (method != null && method.getReturnType().equals(ctx.type().getText()))
            {
                MiniJavaParser.FormalListContext parameterNode = ctx.formalList();
                if (parameterNode.type().start.getText().equals(method.getParameters().type().getText()))
                    throw new MethodAlreadyDeclaredException(overload + " has already been declared.", ctx.getStart(), sourceName);
                if (!method.getReturnType().equals(ctx.type().getText()))
                    throw new MethodAlreadyDeclaredException(overload + " has already been declared.", ctx.getStart(), sourceName);
            }
            else
            {
                throw new MethodAlreadyDeclaredException(overload + " has already been declared.", ctx.getStart(), sourceName);
            }
        }
        Scope newScope = new Overload(overload, ctx.type().getText(), ctx.formalList(), currentScope, ctx.operator);
        currentScope.addItem(newScope);
        currentScope = newScope;
    }

    @Override
    public void exitOperatorDecl(MiniJavaParser.OperatorDeclContext ctx)
    {
        ifCount = 0;
        loopCount = 0;
        blockCount = 0;
        currentScope = currentScope.getParentScope().get();
    }

    @Override
    public void enterScoped(MiniJavaParser.ScopedContext ctx)
    {
        if (!currentScope.getType().equals("If") && !currentScope.getType().equals("Loop"))
        {
            Scope newScope = new Method("Block_" + blockCount++, null, null, currentScope);
            currentScope.addItem(newScope);
            currentScope = newScope;
        }
    }

    @Override
    public void exitScoped(MiniJavaParser.ScopedContext ctx)
    {
        if (!currentScope.getType().equals("If") && !currentScope.getType().equals("Loop"))
        {
            currentScope = currentScope.getParentScope().get();
        }
    }

    @Override
    public void enterVarDecl(MiniJavaParser.VarDeclContext ctx)
    {
        if (currentScope.exists(ctx.ID().getText()))
            throw new VariableAlreadyDeclaredException("Variable has already been declared.", ctx.ID().getSymbol(), sourceName);
        currentScope.addItem(new Variable(ctx.ID().getText(), ctx.type().getText(), currentScope));
    }

    @Override
    public void enterAssignment(MiniJavaParser.AssignmentContext ctx)
    {
//        Variable var = currentScope.get(ctx.varName.getText());
//        if (var == null)
//            throw new VariableNotDeclaredException(ctx.varName.getText() + " variable has not be declared.", ctx.varName, sourceName, currentScope);
//        // FIX THIS GET TYPE ISSUE **********************************************************************************************************************************************************************
//        if (!var.initializeSymbol(ctx.assignee, ctx.assignee.getText(), ctx.varName.getLine(), sourceName))
//        {
//            // Made up stuff since I plan to scrap this class
//            IncompatibleTypesError classCastException = new IncompatibleTypesError(var.getType() + " cannot be cast into something", ctx.start, sourceName, ctx.stop, sourceName);
//            classCastException.setStackTrace(new StackTraceElement[]
//                    {
//                            new StackTraceElement(var.getParentScope().get().getName(), var.getName(), sourceName, ctx.varName.getLine())
//                    });
//            throw  classCastException;
//        }
    }

    @Override
    public void enterIf(MiniJavaParser.IfContext ctx)
    {
        Scope newScope = new If("IF_" + ifCount++, currentScope);
        currentScope.addItem(newScope);
        currentScope = newScope;
    }

    @Override
    public void exitIf(MiniJavaParser.IfContext ctx)
    {
        currentScope = currentScope.getParentScope().get();
    }


    @Override
    public void enterLoop(MiniJavaParser.LoopContext ctx)
    {
        Scope newScope = new Loop("LOOP_" + loopCount++, currentScope);
        currentScope.addItem(newScope);
        currentScope = newScope;
    }

    @Override
    public void exitLoop(MiniJavaParser.LoopContext ctx)
    {
        currentScope = currentScope.getParentScope().get();
    }

    @Override
    public void enterFormalList(MiniJavaParser.FormalListContext ctx)
    {
        if (currentScope.exists(ctx.ID().getText()))
            throw new VariableAlreadyDeclaredException("Variable has already been declared.", ctx.ID().getSymbol(), sourceName);
        currentScope.addItem(new Variable(ctx.ID().getText(), ctx.type().getText(), currentScope));
    }
}
