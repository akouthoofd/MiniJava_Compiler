package my.mini.java.compiler.AST.symbol;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.Stack;

/**
 * Created by alex on 11/30/2016.
 */
public class SymbolTable
{
    private Stack<Symbol> symbolList;

    public SymbolTable()
    {
        symbolList = new StringStack();
    }

    public void enterScope()
    {
        symbolList.push(new Symbol(null, null, null));
    }

    public Symbol findSymbol(String key)
    {
        for (int i = symbolList.size() - 1; i >= 0; i--)
        {
            if (symbolList.elementAt(i).key != null
                    && symbolList.elementAt(i).key.getText().equals(key))
                return symbolList.elementAt(i);
        }
        return null;
    }

    public void addSymbol(Symbol symbol)
    {
        symbolList.push(symbol);
    }

    public boolean checkScope(Symbol symbol)
    {
        for (int i = symbolList.size() - 1; i >= 0; i--)
        {
            if (symbolList.elementAt(i).key == null)
                return false;
            if (symbolList.elementAt(i).key.getText().equals(symbol.key.getText()))
                return true;
        }
        return false;
    }

    public void exitScope()
    {
        while (!(symbolList.peek().key == null))
            symbolList.pop();
        symbolList.pop();
    }
}
