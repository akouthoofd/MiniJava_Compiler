package my.mini.java.compiler.Scopes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by alex on 11/8/2016.
 */
public class Klass implements Scope
{
    private List<Method> allMethods = new ArrayList<>();
    private List<Overload> allOverloads = new ArrayList<>();
    private String name;
    private Scope parentScope;
    private ArrayList<Scope> methods;

    public Klass(String name)
    {
        this(name, null);
    }

    public Klass(String name, Scope parentScope)
    {
        this.name = name;
        this.parentScope = parentScope;
        methods = new ArrayList<>();
    }

    public void clearMethods()
    {
        allMethods.clear();
        allOverloads.clear();
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getType()
    {
        return name;
    }

    @Override
    public Optional<Scope> getParentScope()
    {
        return (parentScope == null) ? Optional.empty() : Optional.of(parentScope);
    }

    @Override
    public boolean isDeclared(String name)
    {
        return true;
    }

    @Override
    public boolean isInitialized()
    {
        return true;
    }

    @Override
    public boolean exists(String text)
    {
        for (Scope item: methods)
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
        if (item instanceof Method || item instanceof Overload || item instanceof Variable)
            methods.add(item);
        else
            System.err.println("Klass class was asked to add a non-Method Scope");
    }

    @Override
    public Variable get(String varName)
    {
        for (Scope item: methods)
        {
            if (item instanceof Variable && item.getName().equals(varName))
                return (Variable) item;
        }
        if (parentScope != null)
            return parentScope.get(varName);
        return null;
    }

    public Method getMethod(String text)
    {
        for (Scope item: methods)
        {
            if (item instanceof Method && item.getName().equals(text))
                return (Method) item;
        }
        if (parentScope != null && parentScope instanceof Klass)
            return ((Klass)parentScope).getMethod(text);
        return null;
    }

    public List<Method> getAdvancedMethod(String text)
    {
        for (Scope item: methods)
        {
            if (item instanceof Method && item.getName().equals(text))
                allMethods.add ((Method) item);
        }
        if (parentScope != null && parentScope instanceof Klass)
            allMethods.addAll(((Klass)parentScope).getAdvancedMethod(text));
        return allMethods;
    }

    public Overload getOverloadMethod(String text)
    {
        for (Scope item: methods)
        {
            if (item instanceof Overload && item.getName().equals(text))
                return (Overload) item;
        }
        if (parentScope != null && parentScope instanceof Klass)
            return ((Klass)parentScope).getOverloadMethod(text);
        return null;
    }

    public List<Method> getAdvancedOverloadMethod(String text)
    {
        for (Scope item: methods)
        {
            if (item instanceof Overload && item.getName().equals(text))
                allMethods.add ((Method) item);
        }
        if (parentScope != null && parentScope instanceof Klass)
            allMethods.addAll(((Klass)parentScope).getAdvancedOverloadMethod(text));
        return allMethods;
    }
}
