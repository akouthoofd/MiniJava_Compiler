package my.mini.java.compiler.Scopes;

import my.mini.java.parser.MiniJavaParser;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.Optional;

public class Overload implements Scope
{
    private String name;
    private Scope parentScope;
    private Token operator;
    private String returnType;
    private MiniJavaParser.FormalListContext parameters;
    private ArrayList<Scope> items;

    public Overload(String name, String returnType, MiniJavaParser.FormalListContext parameters, Scope parentScope, Token operatorOverloaded)
    {
        this.name = name;
        this.parentScope = parentScope;
        this.returnType = returnType;
        this.parameters = parameters;
        operator = operatorOverloaded;
        items = new ArrayList<>();
    }

    public Token getOperator()
    {
        return operator;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getType()
    {
        return "Overload";
    }

    public MiniJavaParser.FormalListContext getParameters()
    {
        return parameters;
    }

    public String getReturnType()
    {
        return returnType;
    }

    @Override
    public Optional<Scope> getParentScope()
    {
        return (parentScope == null) ? Optional.empty() : Optional.of(parentScope);
    }

    @Override
    public boolean isDeclared(String name)
    {
        return false;
    }

    @Override
    public boolean isInitialized()
    {
        return false;
    }

    @Override
    public boolean exists(String text)
    {
        for (Scope item: items)
        {
            if (item.getName().equals(text))
                return true;
            if (item.exists(text))
                return true;
        }
        return false;
    }

    @Override
    public void addItem(Scope item)
    {
        items.add(item);
    }

    @Override
    public Variable get(String varName)
    {
        for (Scope item: items)
        {
            if (item instanceof Variable && item.getName().equals(varName))
                return (Variable) item;
//            Scope it = item.get(varName);
//            if (it != null)
//                return (Variable) it;
        }
        if (parentScope != null)
            return parentScope.get(varName);
        return null;
    }
}
