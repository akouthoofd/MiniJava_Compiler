package my.mini.java.compiler;

import my.mini.java.parser.MiniJavaBaseVisitor;
import my.mini.java.parser.MiniJavaParser;

import java.util.HashMap;

/**
 * Created by alex on 11/2/2016.
 */
public class MyVisitor extends MiniJavaBaseVisitor<String>
{
    private HashMap<String, Integer> variables = new HashMap<>();

    @Override
    public String visitPrint(MiniJavaParser.PrintContext ctx)
    {
        return "getstatic java/lang/System/out Ljava/io/PrintStream;\n    " +
                visitChildren(ctx) +
                "\n    invokevirtual java/io/PrintStream/println(I)V";
    }

    @Override
    public String visitVarDecl(MiniJavaParser.VarDeclContext ctx)
    {
        variables.put(ctx.ID().getText(), variables.size());
        return "    istore " + (variables.size() - 1);
    }

    @Override
    public String visitAssignment(MiniJavaParser.AssignmentContext ctx)
    {
        return "    ldc " + ctx.assignee.getText()
                + System.lineSeparator()
                + "        iload " + variables.get(ctx.varName.getText());
    }

    @Override
    public String visitMult(MiniJavaParser.MultContext ctx)
    {
        return visitChildren(ctx) + System.lineSeparator() + "    imul";
    }

    @Override
    public String visitPlus(MiniJavaParser.PlusContext ctx)
    {
        return visitChildren(ctx) + System.lineSeparator() + "    iadd";
    }

    @Override
    public String visitMinus(MiniJavaParser.MinusContext ctx)
    {
        return visitChildren(ctx) + System.lineSeparator() + "    isub";
    }

    @Override
    public String visitNumber(MiniJavaParser.NumberContext ctx)
    {
        return "ldc " + ctx.INT().getText();
    }

    @Override
    protected String aggregateResult(String aggregate, String nextResult)
    {
        if (aggregate == null)
            return nextResult;
        if (nextResult == null)
            return aggregate;
        return aggregate + System.lineSeparator() + "    " + nextResult;
    }
}
