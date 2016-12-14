package my.mini.java.compiler.Exceptions;

import org.antlr.v4.runtime.Token;

/**
 * Created by alex on 12/3/2016.
 */
public class IncorrectReturnType extends RuntimeException
{
    public IncorrectReturnType(String errorMessage, Token className, String methodName, Token method, String sourceName)
    {
        super(errorMessage);
        setStackTrace(new StackTraceElement[]{
                new StackTraceElement(className.getText(), methodName, sourceName, method.getLine()),
                new StackTraceElement(className.getText(), "class", sourceName, className.getLine())
        });
    }
}
