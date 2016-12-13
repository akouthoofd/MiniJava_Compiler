package my.mini.java.compiler.AST;

/**
 * Created by alex on 11/28/2016.
 */
public enum Operators
{
    PLUS_SIGN ("+"),
    MINUS_SIGN ("-"),
    MULT_SIGN ("*"),
    AND_SIGN ("&&"),
    LESS_THAN_SIGN ("<");

    String sign;

    Operators (String sign)
    {
        this.sign = sign;
    }

    public String getSign()
    {
        return sign;
    }

}
