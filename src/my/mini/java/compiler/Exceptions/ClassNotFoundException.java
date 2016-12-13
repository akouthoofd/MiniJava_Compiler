package my.mini.java.compiler.Exceptions;

import org.antlr.v4.runtime.Token;

/**
 * Created by alex on 12/3/2016.
 */
public class ClassNotFoundException extends RuntimeException
{
    public ClassNotFoundException(String errorMessage, Token className, String sourceName)
    {
        super(errorMessage);
        setStackTrace(new StackTraceElement[]{
                new StackTraceElement(className.getText(), "class", sourceName, className.getLine())
        });
    }
}
