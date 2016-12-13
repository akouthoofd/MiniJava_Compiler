package my.mini.java.compiler.AST.nodes.methods;

import my.mini.java.compiler.AST.Operators;
import my.mini.java.compiler.AST.nodes.formal_list.ParameterNode;
import my.mini.java.compiler.AST.nodes.statements.exprs.ExprNode;
import my.mini.java.compiler.AST.nodes.type.TypeNode;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;

/**
 * Created by alex on 11/28/2016.
 */
public class OverloadMethodNode extends MethodNode
{
    public Operators sign;
    public ParameterNode parameter;
    public Token retn;

    public OverloadMethodNode(TypeNode typeNode, Operators sign, ParameterNode parameter, ExprNode returnExpr, Token retn)
    {
        this.methodName = "$operator_" + sign.name();
        this.typeNode = typeNode;
        this.sign = sign;
        this.parameter = parameter;
        this.returnExpression = returnExpr;
        this.retn = retn;
        statementNodes = new ArrayList<>();
        varDeclarationNodes = new ArrayList<>();
    }
}
