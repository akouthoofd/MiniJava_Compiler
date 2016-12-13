package my.mini.java.compiler.Exceptions;

import my.mini.java.compiler.Scopes.Scope;
import org.antlr.v4.runtime.Token;

/**
 * Created by alex on 11/26/2016.
 */
public class VariableNotInitializedException extends RuntimeException
{
    public VariableNotInitializedException(String errorMessage, Token className, String sourceName, Scope scope)
    {
        super(errorMessage);
        if (scope.getParentScope().isPresent())
        {
            setStackTrace(new StackTraceElement[]{
                    new StackTraceElement(scope.getParentScope().get().getName(), scope.getName(), sourceName, className.getLine())
            });
        }
        else
        {
            setStackTrace(new StackTraceElement[]{
                    new StackTraceElement(scope.getName(), "main", sourceName, className.getLine())
            });
        }
    }

    public VariableNotInitializedException(String errorMessage, Token className, String methodName, Token var, String sourceName)
    {
        super(errorMessage);
        setStackTrace(new StackTraceElement[]{
                new StackTraceElement(className.getText(), methodName, sourceName, var.getLine()),
                new StackTraceElement(className.getText(), "class", sourceName, className.getLine())
        });
    }
}
