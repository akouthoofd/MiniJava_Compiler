package my.mini.java.compiler.AST.symbol;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
import my.mini.java.compiler.AST.nodes.type.EnterScopeNode;
import my.mini.java.compiler.AST.nodes.type.ExitScopeNode;

import java.util.Stack;

/**
 * Created by alex on 12/2/2016.
 */
public class StaticSymbolTable
{
    private Stack<Symbol> symbolList;

    public StaticSymbolTable()
    {
        symbolList = new StringStack();
    }

    public void enterScope()
    {
        symbolList.push(new Symbol(null, new EnterScopeNode(), null));
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
            if (symbolList.elementAt(i).type instanceof EnterScopeNode)
                return false;
            if (symbolList.elementAt(i).key.getText().equals(symbol.key.getText()))
                return true;
        }
        return false;
    }

    public void exitScope()
    {
        symbolList.push(new Symbol(null, new ExitScopeNode(), null));
    }

    @Override
    public String toString()
    {
        StringBuilder retnString = new StringBuilder("");
        int scopeCount = 0;
        for (Symbol symbol: symbolList)
        {
            if (symbol.toString().contains("Exit Scope"))
                scopeCount--;
            for (int i = 0; i < scopeCount; i++)
                retnString.append("\t");
            if (symbol.toString().contains("Enter Scope"))
                scopeCount++;

            retnString.append(symbol.toString());
            retnString.append("\n");
        }
        return retnString.toString();
    }
}
