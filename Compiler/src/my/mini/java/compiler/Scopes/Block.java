package my.mini.java.compiler.Scopes;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by alex on 11/21/2016.
 */
public class Block implements Scope
{
    String name;
    Scope parentScope;
    private ArrayList<Scope> items;

    public Block(String name)
    {
        this(name, null);
    }

    public Block(String name, Scope parentScope)
    {
        this.name = name;
        this.parentScope = parentScope;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getType()
    {
        return "Block";
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
        return null;
    }
}
