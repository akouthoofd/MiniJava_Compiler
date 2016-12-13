package  my.mini.java.compiler.AST.nodes;

import my.mini.java.compiler.AST.nodes.type.TypeNode;

/**
 * Created by alex on 11/8/2016.
 */
public class SymbolNode extends Node
{
    private String name;
    private String type;
    private Object value;

    public SymbolNode(String name, String type)
    {
        this.name = name;
        this.type = type;
    }

    public Object getValue()
    {
        return value;
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public void assignValue(TypeNode type, Object value, int line, String sourceName)
    {
//        if (this.type.equals(type.type.value.getText()))
//            this.value = value;
//        else
//        {
//            ClassCastException classCastException = new ClassCastException(this.type + " cannot be cast into " + type.type.value.getText());
//            classCastException.setStackTrace(new StackTraceElement[]
//                    {
//                            new StackTraceElement("hsdgsj", getName(), sourceName, line)
//                    });
//            throw  classCastException;
//        }
    }
}
