package my.mini.java.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.IntervalSet;

/**
 * Created by alex on 11/25/2016.
 */
public class ExceptionErrorStrategy extends DefaultErrorStrategy
{

    @Override
    public void recover(Parser recognizer, RecognitionException e)
    {
        e.setStackTrace(new StackTraceElement[] {
            new StackTraceElement("Class", "Method", "File", recognizer.getCurrentToken().getLine())
        });
        throw e;
    }

    @Override
    public void reportInputMismatch(Parser recognizer, InputMismatchException e) throws RecognitionException
    {
        String msg = "mismatched input " + getTokenErrorDisplay(e.getOffendingToken());
        msg += " expecting one of "+e.getExpectedTokens().toString(recognizer.getTokenNames());
        RecognitionException ex = new RecognitionException(msg, recognizer, recognizer.getInputStream(), recognizer.getContext());
        e.setStackTrace(new StackTraceElement[] {});
        ex.initCause(e);
        ex.setStackTrace(new StackTraceElement[] {
                new StackTraceElement("Class", "Method", "File", recognizer.getCurrentToken().getLine())
        });
        throw ex;
    }

    @Override
    public void reportMissingToken(Parser recognizer) {
        beginErrorCondition(recognizer);
        Token t = recognizer.getCurrentToken();
        IntervalSet expecting = getExpectedTokens(recognizer);
        String msg = "missing "+expecting.toString(recognizer.getTokenNames()) + " at " + getTokenErrorDisplay(t);// + " line (" + t.getLine() + ":" + t.getCharPositionInLine() + ")";
        RecognitionException ex = new RecognitionException(msg, recognizer, recognizer.getInputStream(), recognizer.getContext());
        ex.setStackTrace(new StackTraceElement[]{
                new StackTraceElement("Class", "Method", "File", recognizer.getCurrentToken().getLine())
        });
        throw ex;
    }
}
