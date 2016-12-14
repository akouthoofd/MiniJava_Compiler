package optimization;

import soot.*;
import soot.jimple.*;
import soot.jimple.internal.*;
import soot.jimple.toolkits.scalar.Evaluator;
import soot.shimple.ShimpleBody;

import java.util.*;

/**
 * Created by alex on 12/12/2016.
 */
public class BranchTransform extends BodyTransformer
{
    private Map<String, Integer> valueBoxes;

    @Override
    protected void internalTransform(Body b, String phaseName, Map<String, String> options)
    {
        valueBoxes = new HashMap<>();
        ShimpleBody body = (ShimpleBody) b;
        handleMethod(body.getMethod());

        //        G.v().out.println("Calling!");
        /*for(Iterator clIt = Scene.v().getApplicationClasses().iterator(); clIt.hasNext(); ) {
            final SootClass cl = (SootClass) clIt.next();
            for( Iterator it = cl.methodIterator(); it.hasNext(); ) {
                handleMethod( (SootMethod) it.next() );
            }
        }*/
    }

    private void handleMethod(SootMethod m) {
        if( !m.isConcrete() ) return;
        List<Stmt> removes = new ArrayList<>();
        for( Iterator sIt = m.getActiveBody().getUnits().iterator(); sIt.hasNext(); ) {
            final Stmt s = (Stmt) sIt.next();
//            System.out.println(s);
            if (s instanceof JAssignStmt)
            {
                if (((JAssignStmt) s).rightBox.getValue() instanceof IntConstant)
                {
                    if (((JAssignStmt) s).leftBox.getValue() instanceof Local)
                    {
                        valueBoxes.put(((JimpleLocal) ((JAssignStmt) s).leftBox.getValue()).getName(), ((IntConstant) ((JAssignStmt) s).rightBox.getValue()).value);
                        ((JAssignStmt) s).setRightOp(IntConstant.v(valueBoxes.get(((JimpleLocal) ((JAssignStmt) s).leftBox.getValue()).getName())));
                    }
                }
                else
                {
                    if (valueBoxes.get(((JAssignStmt) s).rightBox) != null)
                    {
                        valueBoxes.put(((JimpleLocal) ((JAssignStmt) s).leftBox.getValue()).getName(), valueBoxes.get(((JAssignStmt) s).rightBox));
                        ((JAssignStmt) s).setRightOp(IntConstant.v(valueBoxes.get(((JimpleLocal) ((JAssignStmt) s).leftBox.getValue()).getName())));
                    }
                    else if (isRetrieveable(((JAssignStmt) s).rightBox))
                    {
                        valueBoxes.put(((JimpleLocal) ((JAssignStmt) s).leftBox.getValue()).getName(), retrieve(((JAssignStmt) s).rightBox));
                        ((JAssignStmt) s).setRightOp(IntConstant.v(valueBoxes.get(((JimpleLocal) ((JAssignStmt) s).leftBox.getValue()).getName())));
                    }
                }

            }
            else if (s instanceof JIfStmt)
            {
                ConditionExprBox val = (ConditionExprBox) ((JIfStmt) s).getConditionBox();
                List<ValueBox> boxes = val.getValue().getUseBoxes();
                Stmt temp =
                        evalGreaterThan(boxes, val, s);
                temp =
                        evalEqualTo(boxes, val, temp);
//                m.setActiveBody();
                if (temp instanceof NopStmt)
                {
//                    System.out.println(m.getActiveBody().getUnits().remove(s));
                    removes.add(s);
                }
                /*
    Chain<Unit> units = stmtBody.getUnits();

        for (Unit stmt : units.toArray(new Unit[units.size()])) {
            if (stmt instanceof IfStmt) {
            	IfStmt ifs = (IfStmt) stmt;
                // check for constant-valued conditions
                Value cond = ifs.getCondition();
                if (Evaluator.isValueConstantValued(cond)) {
                    cond = Evaluator.getConstantValueOf(cond);

                    if (((IntConstant) cond).value == 1) {
                        // if condition always true, convert if to goto
                        Stmt newStmt = Jimple.v().newGotoStmt(ifs.getTarget());
                        units.insertAfter(newStmt, stmt);
                        numTrue++;
                    }
                    else
                        numFalse++;

                    // remove if
                    units.remove(stmt);
                }
            }
        }
     */
            }

        }

//        Chain<Unit> units = m.getActiveBody().getUnits();
//        for (Unit stmt : units.toArray(new Unit[units.size()])) {
//            if (stmt instanceof IfStmt) {
//                IfStmt ifs = (IfStmt) stmt;
//                // check for constant-valued conditions
//                Value cond = ifs.getCondition();
//                if (Evaluator.isValueConstantValued(cond)) {
//                    cond = Evaluator.getConstantValueOf(cond);
//
//                    if (((IntConstant) cond).value == 1) {
//                        // if condition always true, convert if to goto
//                        Stmt newStmt = Jimple.v().newGotoStmt(ifs.getTarget());
//                        units.insertAfter(newStmt, stmt);
////                                numTrue++;
//                    }
////                            else
////                                numFalse++;
//
//                    // remove if
//                    units.remove(stmt);
//                }
//            }
//        }


        for (Stmt stmt: removes)
        {
            IfStmt ifs = (IfStmt) stmt;
            // check for constant-valued conditions
            Value cond = ifs.getCondition();
            if (Evaluator.isValueConstantValued(cond)) {
                cond = Evaluator.getConstantValueOf(cond);

                if (((IntConstant) cond).value == 1) {
                    // if condition always true, convert if to goto
                    Stmt newStmt = Jimple.v().newGotoStmt(ifs.getTarget());
                    m.getActiveBody().getUnits().insertAfter(newStmt, stmt);
                }
                else
                {
                    //remove completely
                }

                // remove if
                m.getActiveBody().getUnits().remove(stmt);
            }
        }
    }

    private boolean isRetrieveable(ValueBox valueBox)
    {
        if (valueBox.getValue() instanceof JAddExpr)
        {
            if (((JAddExpr) valueBox.getValue()).getOp1() instanceof JimpleLocal && valueBoxes.get(((JimpleLocal) ((JAddExpr) valueBox.getValue()).getOp1()).getName()) == null)
                return false;
            if (((JAddExpr) valueBox.getValue()).getOp2() instanceof JimpleLocal && valueBoxes.get(((JimpleLocal) ((JAddExpr) valueBox.getValue()).getOp2()).getName()) == null)
                return false;
            return true;
        }
        else if (valueBox.getValue() instanceof JSubExpr)
        {
            if (((JSubExpr) valueBox.getValue()).getOp1() instanceof JimpleLocal && valueBoxes.get(((JimpleLocal) ((JSubExpr) valueBox.getValue()).getOp1()).getName()) == null)
                return false;
            if (((JSubExpr) valueBox.getValue()).getOp2() instanceof JimpleLocal && valueBoxes.get(((JimpleLocal) ((JSubExpr) valueBox.getValue()).getOp2()).getName()) == null)
                return false;
            return true;
        }
        else if (valueBox.getValue() instanceof JMulExpr)
        {
            if (((JMulExpr) valueBox.getValue()).getOp1() instanceof JimpleLocal && valueBoxes.get(((JimpleLocal) ((JMulExpr) valueBox.getValue()).getOp1()).getName()) == null)
                return false;
            if (((JMulExpr) valueBox.getValue()).getOp2() instanceof JimpleLocal && valueBoxes.get(((JimpleLocal) ((JMulExpr) valueBox.getValue()).getOp2()).getName()) == null)
                return false;
            return true;
        }
        return false;
    }

    private int retrieve(ValueBox valueBox)
    {
        if (valueBox.getValue() instanceof JAddExpr)
        {
            return evalAdd(((JAddExpr) valueBox.getValue()));
        }
        else if (valueBox.getValue() instanceof JSubExpr)
        {
            return evalSub(((JSubExpr) valueBox.getValue()));
        }
        else if (valueBox.getValue() instanceof JMulExpr)
        {
            return evalMul(((JMulExpr) valueBox.getValue()));
        }
        return 0;
    }

    private Stmt evalEqualTo(List<ValueBox> boxes, ConditionExprBox val, Stmt s)
    {
//        if (s instanceof NopStmt)
//            return s;
        if (val.getValue() instanceof JEqExpr && boxes.size() == 2)
        {
            if (boxes.get(0).getValue() instanceof IntConstant && boxes.get(1).getValue() instanceof IntConstant)
            {
                if (((IntConstant) boxes.get(0).getValue()).value == ((IntConstant) boxes.get(1).getValue()).value)
                {
                    if (val.canContainValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(1))))
                    {
                        val.setValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(1)));
                        return Jimple.v().newNopStmt();
                    }
                }
                else
                {
                    if (val.canContainValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(0))))
                        val.setValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(0)));
                }
            }
            else if (boxes.get(0).getValue() instanceof JimpleLocal || boxes.get(1).getValue() instanceof JimpleLocal)
            {
                if (boxes.get(0).getValue() instanceof JimpleLocal)
                {
                    if (valueBoxes.get(((JimpleLocal) boxes.get(0).getValue()).getName()) == null)
                        return s;
                    if (boxes.get(1).getValue() instanceof JimpleLocal)
                    {
                        evalLocalsEqualTo(boxes.get(0).getValue(), boxes.get(1).getValue(), val);
                    }
                    else
                    {
                        if (valueBoxes.get(((JimpleLocal) boxes.get(0).getValue()).getName()) == ((IntConstant) boxes.get(1).getValue()).value)
                        {
                            if (val.canContainValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(1))))
                            {
                                val.setValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(1)));
                                return Jimple.v().newNopStmt();
                            }
                        }
                        else
                        {
                            if (val.canContainValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(0))))
                                val.setValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(0)));
                        }
                    }
                }
                else if (boxes.get(1).getValue() instanceof JimpleLocal)
                {
                    if (valueBoxes.get(((JimpleLocal) boxes.get(1).getValue()).getName()) == null)
                        return s;
                    if (boxes.get(0).getValue() instanceof JimpleLocal)
                    {
                        evalLocalsEqualTo(boxes.get(0).getValue(), boxes.get(1).getValue(), val);
                    }
                    else
                    {
                        if (((IntConstant) boxes.get(0).getValue()).value == valueBoxes.get(((JimpleLocal) boxes.get(1).getValue()).getName()))
                        {
                            if (val.canContainValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(1))))
                            {
                                val.setValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(1)));
                                return Jimple.v().newNopStmt();
                            }
                        }
                        else
                        {
                            if (val.canContainValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(0))))
                                val.setValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(0)));
                        }
                    }
                }
            }
        }
        return s;
    }

    private Stmt evalGreaterThan(List<ValueBox> boxes, ConditionExprBox val, Stmt s)
    {
//        if (s instanceof NopStmt)
//            return s;
        if (val.getValue() instanceof JGeExpr && boxes.size() == 2)
        {
            if (boxes.get(0).getValue() instanceof IntConstant && boxes.get(1).getValue() instanceof IntConstant)
            {
                if (((IntConstant) boxes.get(0).getValue()).value < ((IntConstant) boxes.get(1).getValue()).value)
                {
                    if (val.canContainValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(1))))
                    {
                        val.setValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(1)));
                        return Jimple.v().newNopStmt();
                    }
                }
                else
                {
                    if (val.canContainValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(0))))
                        val.setValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(0)));
                }
            }
            else if (boxes.get(0).getValue() instanceof JimpleLocal || boxes.get(1).getValue() instanceof JimpleLocal)
            {
                if (boxes.get(0).getValue() instanceof JimpleLocal)
                {
                    if (valueBoxes.get(((JimpleLocal) boxes.get(0).getValue()).getName()) == null)
                        return s;
                    if (boxes.get(1).getValue() instanceof JimpleLocal)
                    {
                        evalLocalsLessThan(boxes.get(0).getValue(), boxes.get(1).getValue(), val);
                    }
                    else
                    {
                        if (valueBoxes.get(((JimpleLocal) boxes.get(0).getValue()).getName()) < ((IntConstant) boxes.get(1).getValue()).value)
                        {
                            if (val.canContainValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(1))))
                            {
                                val.setValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(1)));
                                return Jimple.v().newNopStmt();
                            }
                        }
                        else
                        {
                            if (val.canContainValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(0))))
                                val.setValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(0)));
                        }
                    }
                }
                else if (boxes.get(1).getValue() instanceof JimpleLocal)
                {
                    if (valueBoxes.get(((JimpleLocal) boxes.get(1).getValue()).getName()) == null)
                        return s;
                    if (boxes.get(0).getValue() instanceof JimpleLocal)
                    {
                        evalLocalsLessThan(boxes.get(0).getValue(), boxes.get(1).getValue(), val);
                    }
                    else
                    {
                        if (((IntConstant) boxes.get(0).getValue()).value < valueBoxes.get(((JimpleLocal) boxes.get(1).getValue()).getName()))
                        {
                            if (val.canContainValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(1))))
                            {
                                val.setValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(1)));
                                return Jimple.v().newNopStmt();
                            }
                        }
                        else
                        {
                            if (val.canContainValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(0))))
                                val.setValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(0)));
                        }
                    }
                }
            }
        }
        return s;
    }

    private void evalLocalsLessThan(Value value, Value value1, ConditionExprBox val)
    {
        if (valueBoxes.get(value) == null || valueBoxes.get(value1) == null)
            return;
        if (valueBoxes.get(value) < valueBoxes.get(value1))
        {
            if (val.canContainValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(1))))
                val.setValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(1)));
        }
        else
        {
            if (val.canContainValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(0))))
                val.setValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(0)));
        }
    }

    private void evalLocalsEqualTo(Value value, Value value1, ConditionExprBox val)
    {
        if (valueBoxes.get(value) == null || valueBoxes.get(value1) == null)
            return;
        if (valueBoxes.get(value) == valueBoxes.get(value1))
        {
            if (val.canContainValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(1))))
                val.setValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(1)));
        }
        else
        {
            if (val.canContainValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(0))))
                val.setValue(Jimple.v().newEqExpr(IntConstant.v(1), IntConstant.v(0)));
        }
    }

    private int evalSub(JSubExpr rightBox)
    {
        System.out.println("Subtracting...");
        if (rightBox.getOp1() instanceof IntConstant && rightBox.getOp2() instanceof IntConstant)
            return ((IntConstant) rightBox.getOp1()).value - ((IntConstant) rightBox.getOp2()).value;

        if (rightBox.getOp1() instanceof JimpleLocal)
        {
            Integer op1 = valueBoxes.get(((JimpleLocal) rightBox.getOp1()).getName());
            if (rightBox.getOp2() instanceof JimpleLocal)
            {
                if (op1 != null && valueBoxes.get(((JimpleLocal) rightBox.getOp2()).getName()) != null)
                    return op1 - valueBoxes.get(((JimpleLocal) rightBox.getOp2()).getName());
            }
            else if (rightBox.getOp2() instanceof IntConstant)
            {
                if (op1 != null)
                    return op1 - ((IntConstant) rightBox.getOp2()).value;
            }
        }
        else if (rightBox.getOp2() instanceof JimpleLocal)
        {
            Integer op2 = valueBoxes.get(((JimpleLocal) rightBox.getOp2()).getName());
            if (rightBox.getOp1() instanceof JimpleLocal)
            {
                if (op2 != null && valueBoxes.get(((JimpleLocal) rightBox.getOp1()).getName()) != null)
                    return valueBoxes.get(((JimpleLocal) rightBox.getOp1()).getName()) - op2;
            }
            else if (rightBox.getOp1() instanceof IntConstant)
            {
                if (op2 != null)
                    return ((IntConstant) rightBox.getOp1()).value - op2;
            }
        }
        
        return 0;
    }

    private int evalMul(JMulExpr rightBox)
    {
        System.out.println("Multiplying...");
        if (rightBox.getOp1() instanceof IntConstant && rightBox.getOp2() instanceof IntConstant)
            return ((IntConstant) rightBox.getOp1()).value * ((IntConstant) rightBox.getOp2()).value;

        if (rightBox.getOp1() instanceof JimpleLocal)
        {
            Integer op1 = valueBoxes.get(((JimpleLocal) rightBox.getOp1()).getName());
            if (rightBox.getOp2() instanceof JimpleLocal)
            {
                if (op1 != null && valueBoxes.get(((JimpleLocal) rightBox.getOp2()).getName()) != null)
                    return op1 * valueBoxes.get(((JimpleLocal) rightBox.getOp2()).getName());
            }
            else if (rightBox.getOp2() instanceof IntConstant)
            {
                if (op1 != null)
                    return op1 * ((IntConstant) rightBox.getOp2()).value;
            }
        }
        else if (rightBox.getOp2() instanceof JimpleLocal)
        {
            Integer op2 = valueBoxes.get(((JimpleLocal) rightBox.getOp2()).getName());
            if (rightBox.getOp1() instanceof JimpleLocal)
            {
                if (op2 != null && valueBoxes.get(((JimpleLocal) rightBox.getOp1()).getName()) != null)
                    return valueBoxes.get(((JimpleLocal) rightBox.getOp1()).getName()) * op2;
            }
            else if (rightBox.getOp1() instanceof IntConstant)
            {
                if (op2 != null)
                    return ((IntConstant) rightBox.getOp1()).value * op2;
            }
        }
        
        return 0;
    }

    private int evalAdd(JAddExpr rightBox)
    {
        System.out.println("Adding...");
        if (rightBox.getOp1() instanceof IntConstant && rightBox.getOp2() instanceof IntConstant)
            return ((IntConstant) rightBox.getOp1()).value + ((IntConstant) rightBox.getOp2()).value;
        if (rightBox.getOp1() instanceof JimpleLocal)
        {
            Integer op1 = valueBoxes.get(((JimpleLocal) rightBox.getOp1()).getName());
            if (rightBox.getOp2() instanceof JimpleLocal)
            {
                if (op1 != null && valueBoxes.get(((JimpleLocal) rightBox.getOp2()).getName()) != null)
                    return op1 + valueBoxes.get(((JimpleLocal) rightBox.getOp2()).getName());
            }
            else if (rightBox.getOp2() instanceof IntConstant)
            {
                if (op1 != null)
                    return op1 + ((IntConstant) rightBox.getOp2()).value;
            }
        }
        else if (rightBox.getOp2() instanceof JimpleLocal)
        {
            Integer op2 = valueBoxes.get(((JimpleLocal) rightBox.getOp2()).getName());
            if (rightBox.getOp1() instanceof JimpleLocal)
            {
                if (op2 != null && valueBoxes.get(((JimpleLocal) rightBox.getOp1()).getName()) != null)
                    return valueBoxes.get(((JimpleLocal) rightBox.getOp1()).getName()) + op2;
            }
            else if (rightBox.getOp1() instanceof IntConstant)
            {
                if (op2 != null)
                    return ((IntConstant) rightBox.getOp1()).value + op2;
            }
        }
        return 0;
    }
}
