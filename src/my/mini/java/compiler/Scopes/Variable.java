package my.mini.java.compiler.Scopes;

import my.mini.java.parser.MiniJavaParser;

import java.util.Optional;

/**
 * Created by alex on 11/8/2016.
 */
public class Variable implements Scope
{
    private String name;
    private Scope parentScope;
    private String type;
    private Object value;

    private static final Klass IntType = new Klass("int");
    private static final Klass BooleanType = new Klass("boolean");

    private static Klass getType(MiniJavaParser.ExprContext assignee)
    {
        if (assignee.getText().equals("true") || assignee.getText().equals("false"))
            return BooleanType;
        return IntType;
    }

    public Variable(String name, String type, Scope parentScope)
    {
        this.name = name;
        this.type = type;
        this.parentScope = parentScope;
    }

    public Object getValue()
    {
        return value;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getType()
    {
        return type;
    }

    @Override
    public Optional<Scope> getParentScope()
    {
        return (parentScope == null) ? Optional.empty() : Optional.of(parentScope);
    }

    /*  public void declareSymbol(Klass type, Object value)
    {
        if (this.type.getName().equals(type.getName()))
            this.value = value;
        else
            throw new IncompatibleTypesError(type.getName() + " cannot be converted to " + this.type.getName(), new CommonToken(Token.INVALID_TYPE), "Test");
    }*/

    public boolean initializeSymbol(MiniJavaParser.ExprContext type, Object value, int line, String sourceName)
    {
        Klass k = getType(type);
        if (this.type.equals(k.getName()))
        {
            this.value = value;
            return true;
        }
        return false;
    }

    @Override
    public boolean isDeclared(String name)
    {
        return true;
    }

    @Override
    public boolean isInitialized()
    {
        return (value != null);
    }

    @Override
    public boolean exists(String text)
    {
        return false;
    }

    @Override
    public void addItem(Scope item)
    {

    }

    @Override
    public Variable get(String varName)
    {
        return null;
    }
}
