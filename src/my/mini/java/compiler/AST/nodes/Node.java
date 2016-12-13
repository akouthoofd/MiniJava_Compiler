package my.mini.java.compiler.AST.nodes;

/**
 * Created by alex on 11/28/2016.
 */
public abstract class Node
{
    public boolean initialized;

    public void initialize()
    {
        initialized = true;
    }

    public boolean isInitialized()
    {
        return initialized;
    }
}
