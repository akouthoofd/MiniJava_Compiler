// Generated from C:/Users/alex/Coding/CSC444/MyCompiler/Compiler/src/my/mini/java/grammar\MiniJava.g4 by ANTLR 4.5.3
package my.mini.java.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniJavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniJavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(MiniJavaParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Main}
	 * labeled alternative in {@link MiniJavaParser#mainClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(MiniJavaParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Class}
	 * labeled alternative in {@link MiniJavaParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass(MiniJavaParser.ClassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChildClass}
	 * labeled alternative in {@link MiniJavaParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChildClass(MiniJavaParser.ChildClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(MiniJavaParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#methodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDecl(MiniJavaParser.MethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#operatorDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorDecl(MiniJavaParser.OperatorDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#formalList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalList(MiniJavaParser.FormalListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MiniJavaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Scoped}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScoped(MiniJavaParser.ScopedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Print}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(MiniJavaParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MiniJavaParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayAssignment}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssignment(MiniJavaParser.ArrayAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Loop}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(MiniJavaParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code If}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(MiniJavaParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link MiniJavaParser#condExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(MiniJavaParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link MiniJavaParser#condExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThan(MiniJavaParser.LessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link MiniJavaParser#condExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(MiniJavaParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NestedCondition}
	 * labeled alternative in {@link MiniJavaParser#condExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedCondition(MiniJavaParser.NestedConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Exp}
	 * labeled alternative in {@link MiniJavaParser#condExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(MiniJavaParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Calculation}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalculation(MiniJavaParser.CalculationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Trailing}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrailing(MiniJavaParser.TrailingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayAccess}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(MiniJavaParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayLength}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLength(MiniJavaParser.ArrayLengthContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MethodCall}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(MiniJavaParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link MiniJavaParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(MiniJavaParser.MultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Atm}
	 * labeled alternative in {@link MiniJavaParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtm(MiniJavaParser.AtmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link MiniJavaParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(MiniJavaParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link MiniJavaParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(MiniJavaParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(MiniJavaParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(MiniJavaParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectReference}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectReference(MiniJavaParser.ObjectReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Instatiate}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstatiate(MiniJavaParser.InstatiateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReferenceThis}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceThis(MiniJavaParser.ReferenceThisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewIntArray}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewIntArray(MiniJavaParser.NewIntArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedExpr}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedExpr(MiniJavaParser.ParenthesizedExprContext ctx);
}