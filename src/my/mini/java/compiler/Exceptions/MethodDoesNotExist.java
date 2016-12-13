package my.mini.java.compiler.Exceptions;

import org.antlr.v4.runtime.Token;

/**
 * Created by alex on 12/2/2016.
 */
public class MethodDoesNotExist extends RuntimeException
{
    public MethodDoesNotExist (String errorMessage, Token className, String methodName, Token method, String sourceName)
    {
        super(errorMessage);
        setStackTrace(new StackTraceElement[]{
                new StackTraceElement(className.getText(), methodName, sourceName, method.getLine()),
                new StackTraceElement(className.getText(), "class", sourceName, className.getLine())
        });
    }

    public MethodDoesNotExist (String errorMessage, Token name, String sourceName)
    {
        super(errorMessage);
        setStackTrace(new StackTraceElement[]{
                new StackTraceElement(name.getText(), name.getText(), sourceName, name.getLine())
        });
    }
}
