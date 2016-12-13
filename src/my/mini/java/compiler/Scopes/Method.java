package my.mini.java.compiler.Scopes;

import my.mini.java.parser.MiniJavaParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by alex on 11/25/2016.
 */
public class Method implements Scope
{
    private String name;
    private String returnType;
    private Scope parentScope;
    private List<MiniJavaParser.FormalListContext> parameters;
    private ArrayList<Scope> items;

    public Method(String name)
    {
        this(name, null, null, null);
    }

    public Method(String name, String returnType, List<MiniJavaParser.FormalListContext> parameters, Scope parentScope)
    {
        this.name = name;
        this.returnType = returnType;
        this.parameters = parameters;
        this.parentScope = parentScope;
        items = new ArrayList<>();
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getType()
    {
        return "Method";
    }

    public String getReturnType()
    {
        return returnType;
    }

    public List<MiniJavaParser.FormalListContext> getParameters()
    {
        return parameters;
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
