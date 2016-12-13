package my.mini.java.compiler.Exceptions;

import org.antlr.v4.runtime.Token;

/**
 * Created by alex on 12/2/2016.
 */
public class IncorrectNumberOfParameters extends RuntimeException
{
    public IncorrectNumberOfParameters (String errorMessage, Token className, String methodName, Token variable, String sourceName)
    {
        super(errorMessage);
        setStackTrace(new StackTraceElement[]{
                new StackTraceElement(className.getText(), methodName, sourceName, variable.getLine()),
                new StackTraceElement(className.getText(), "class", sourceName, className.getLine())
        });
    }
}
