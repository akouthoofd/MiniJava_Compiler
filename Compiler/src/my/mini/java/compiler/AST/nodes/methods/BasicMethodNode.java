package my.mini.java.compiler.AST.nodes.methods;

import my.mini.java.compiler.AST.nodes.formal_list.ParameterNode;
import my.mini.java.compiler.AST.nodes.literals.IdLiteralNode;
import my.mini.java.compiler.AST.nodes.statements.exprs.ExprNode;
import my.mini.java.compiler.AST.nodes.type.TypeNode;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;

/**
 * Created by alex on 11/28/2016.
 */
public class BasicMethodNode extends MethodNode
{
    public IdLiteralNode name;
    public ArrayList<ParameterNode> parameters;
    public Token retn;

    public BasicMethodNode(TypeNode typeNode, IdLiteralNode methodName, ExprNode returnExpr, Token retn)
    {
        this.methodName = methodName.value.getText();
        this.typeNode = typeNode;
        this.name = methodName;
        this.returnExpression = returnExpr;
        this.retn = retn;
        parameters = new ArrayList<>();
        statementNodes = new ArrayList<>();
        varDeclarationNodes = new ArrayList<>();
    }
}
