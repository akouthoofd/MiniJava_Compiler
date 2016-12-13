package my.mini.java.compiler.Scopes;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by alex on 11/27/2016.
 */
public class If implements Scope
{
    private String name;
    private Scope parentScope;
    private ArrayList<Scope> items;

    public If(String name)
    {
        this(name, null);
    }

    public If(String name, Scope parentScope)
    {
        this.name = name;
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
        return "If";
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
    public boolean isInitialized() { return true; }

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
