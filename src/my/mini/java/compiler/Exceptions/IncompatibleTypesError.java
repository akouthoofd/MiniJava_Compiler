package my.mini.java.compiler.Exceptions;

import org.antlr.v4.runtime.Token;

/**
 * Created by alex on 11/21/2016.
 */
public class IncompatibleTypesError extends RuntimeException
{

    public IncompatibleTypesError(String errorMessage, Token className, String methodName, Token variable, String sourceName)
    {
        super(errorMessage);
        setStackTrace(new StackTraceElement[]{
                new StackTraceElement(className.getText(), methodName, sourceName, variable.getLine()),
                new StackTraceElement(className.getText(), "class", sourceName, className.getLine())
        });
    }
}
