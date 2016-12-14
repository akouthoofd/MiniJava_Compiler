// Generated from C:/Users/alex/Coding/CSC444/MyCompiler/Compiler/src/my/mini/java/grammar\MiniJava.g4 by ANTLR 4.5.3
package my.mini.java.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniJavaParser}.
 */
public interface MiniJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MiniJavaParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MiniJavaParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Main}
	 * labeled alternative in {@link MiniJavaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void enterMain(MiniJavaParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Main}
	 * labeled alternative in {@link MiniJavaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void exitMain(MiniJavaParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Class}
	 * labeled alternative in {@link MiniJavaParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClass(MiniJavaParser.ClassContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Class}
	 * labeled alternative in {@link MiniJavaParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClass(MiniJavaParser.ClassContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChildClass}
	 * labeled alternative in {@link MiniJavaParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterChildClass(MiniJavaParser.ChildClassContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChildClass}
	 * labeled alternative in {@link MiniJavaParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitChildClass(MiniJavaParser.ChildClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(MiniJavaParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(MiniJavaParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(MiniJavaParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(MiniJavaParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#operatorDecl}.
	 * @param ctx the parse tree
	 */
	void enterOperatorDecl(MiniJavaParser.OperatorDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#operatorDecl}.
	 * @param ctx the parse tree
	 */
	void exitOperatorDecl(MiniJavaParser.OperatorDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#formalList}.
	 * @param ctx the parse tree
	 */
	void enterFormalList(MiniJavaParser.FormalListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#formalList}.
	 * @param ctx the parse tree
	 */
	void exitFormalList(MiniJavaParser.FormalListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MiniJavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MiniJavaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Scoped}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterScoped(MiniJavaParser.ScopedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Scoped}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitScoped(MiniJavaParser.ScopedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Print}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrint(MiniJavaParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Print}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrint(MiniJavaParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MiniJavaParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MiniJavaParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayAssignment}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssignment(MiniJavaParser.ArrayAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayAssignment}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssignment(MiniJavaParser.ArrayAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Loop}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterLoop(MiniJavaParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Loop}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitLoop(MiniJavaParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code If}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIf(MiniJavaParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code If}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIf(MiniJavaParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link MiniJavaParser#condExpr}.
	 * @param ctx the parse tree
	 */
	void enterNot(MiniJavaParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link MiniJavaParser#condExpr}.
	 * @param ctx the parse tree
	 */
	void exitNot(MiniJavaParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link MiniJavaParser#condExpr}.
	 * @param ctx the parse tree
	 */
	void enterLessThan(MiniJavaParser.LessThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link MiniJavaParser#condExpr}.
	 * @param ctx the parse tree
	 */
	void exitLessThan(MiniJavaParser.LessThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link MiniJavaParser#condExpr}.
	 * @param ctx the parse tree
	 */
	void enterAnd(MiniJavaParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link MiniJavaParser#condExpr}.
	 * @param ctx the parse tree
	 */
	void exitAnd(MiniJavaParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NestedCondition}
	 * labeled alternative in {@link MiniJavaParser#condExpr}.
	 * @param ctx the parse tree
	 */
	void enterNestedCondition(MiniJavaParser.NestedConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NestedCondition}
	 * labeled alternative in {@link MiniJavaParser#condExpr}.
	 * @param ctx the parse tree
	 */
	void exitNestedCondition(MiniJavaParser.NestedConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Exp}
	 * labeled alternative in {@link MiniJavaParser#condExpr}.
	 * @param ctx the parse tree
	 */
	void enterExp(MiniJavaParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Exp}
	 * labeled alternative in {@link MiniJavaParser#condExpr}.
	 * @param ctx the parse tree
	 */
	void exitExp(MiniJavaParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Calculation}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCalculation(MiniJavaParser.CalculationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Calculation}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCalculation(MiniJavaParser.CalculationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Trailing}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTrailing(MiniJavaParser.TrailingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Trailing}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTrailing(MiniJavaParser.TrailingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayAccess}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(MiniJavaParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayAccess}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(MiniJavaParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayLength}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayLength(MiniJavaParser.ArrayLengthContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayLength}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayLength(MiniJavaParser.ArrayLengthContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodCall}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(MiniJavaParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodCall}
	 * labeled alternative in {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(MiniJavaParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link MiniJavaParser#math}.
	 * @param ctx the parse tree
	 */
	void enterMult(MiniJavaParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link MiniJavaParser#math}.
	 * @param ctx the parse tree
	 */
	void exitMult(MiniJavaParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Atm}
	 * labeled alternative in {@link MiniJavaParser#math}.
	 * @param ctx the parse tree
	 */
	void enterAtm(MiniJavaParser.AtmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Atm}
	 * labeled alternative in {@link MiniJavaParser#math}.
	 * @param ctx the parse tree
	 */
	void exitAtm(MiniJavaParser.AtmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link MiniJavaParser#math}.
	 * @param ctx the parse tree
	 */
	void enterPlus(MiniJavaParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link MiniJavaParser#math}.
	 * @param ctx the parse tree
	 */
	void exitPlus(MiniJavaParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link MiniJavaParser#math}.
	 * @param ctx the parse tree
	 */
	void enterMinus(MiniJavaParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link MiniJavaParser#math}.
	 * @param ctx the parse tree
	 */
	void exitMinus(MiniJavaParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNumber(MiniJavaParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNumber(MiniJavaParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBool(MiniJavaParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBool(MiniJavaParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectReference}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterObjectReference(MiniJavaParser.ObjectReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectReference}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitObjectReference(MiniJavaParser.ObjectReferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Instatiate}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterInstatiate(MiniJavaParser.InstatiateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Instatiate}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitInstatiate(MiniJavaParser.InstatiateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReferenceThis}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterReferenceThis(MiniJavaParser.ReferenceThisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReferenceThis}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitReferenceThis(MiniJavaParser.ReferenceThisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewIntArray}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNewIntArray(MiniJavaParser.NewIntArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewIntArray}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNewIntArray(MiniJavaParser.NewIntArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedExpr}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpr(MiniJavaParser.ParenthesizedExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedExpr}
	 * labeled alternative in {@link MiniJavaParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpr(MiniJavaParser.ParenthesizedExprContext ctx);
}