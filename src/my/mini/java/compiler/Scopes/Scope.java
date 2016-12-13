package my.mini.java.compiler.Scopes;

import java.util.Optional;

/**
 * Created by alex on 11/8/2016.
 */
public interface Scope
{
    /**
     * The name of the scope and it's key
     * @return  name of scope
     */
    String getName();

    /**
     * The type of the scope (e.g. class, block, method)
     * @return  name of scope
     */
    String getType();

    /**
     * Get the parent scope of the class
     * @return  parentScope
     */
    Optional<Scope> getParentScope();

    boolean isDeclared(String name);

    boolean isInitialized();

    boolean exists(String text);

    void addItem(Scope item);

    Variable get(String varName);
}
