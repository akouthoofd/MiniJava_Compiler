package my.mini.java.compiler.AST.nodes.statements.exprs.atoms;

/**
 * Created by alex on 11/28/2016.
 */
public class NumberAtomNode extends AtomNode
{
    public int number;

    public NumberAtomNode (int number)
    {
        this.number = number;
    }
}
