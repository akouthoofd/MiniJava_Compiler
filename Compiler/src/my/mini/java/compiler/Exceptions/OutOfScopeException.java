package my.mini.java.compiler.Exceptions;

import org.antlr.v4.runtime.Token;

/**
 * Created by alex on 11/26/2016.
 */
public class OutOfScopeException extends RuntimeException
{
    public OutOfScopeException(String errorMessage, Token name, String sourceName)
    {
        super(errorMessage);
        setStackTrace(new StackTraceElement[] {});
    }
}
