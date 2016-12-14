package my.mini.java.compiler.Exceptions;

import org.antlr.v4.runtime.Token;

/**
 * Created by alex on 11/28/2016.
 */
public class IllegalStatementException extends RuntimeException
{

    public IllegalStatementException(String msg, Token className, String methodName, Token variable, String sourceName)
    {
        super(msg);
        setStackTrace(new StackTraceElement[]{
                new StackTraceElement(className.getText(), methodName, sourceName, variable.getLine()),
                new StackTraceElement(className.getText(), "class", sourceName, className.getLine())
        });
    }
}
