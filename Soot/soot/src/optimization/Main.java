package optimization;

import soot.PackManager;
import soot.Transform;

/**
 * Created by alex on 12/12/2016.
 */
public class Main
{
    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            System.out.println("Syntax: java Main <classfile> [soot options]");
            System.exit(0);
        }
        PackManager.v().getPack("stp").add(
                new Transform("stp.MyTransformer", new BranchTransform()));
        soot.Main.main(args);
    }
}

/*
class Propagator extends BodyTransformer
{
    private HashMap<String, Integer> values;
    private static Propagator instance = new Propagator();


    private Propagator()
    {
        values = new HashMap<>();
    }

    public static Propagator v()
    {
        return instance;
    }

    @Override
    protected void internalTransform(Body b, String phaseName, Map<String, String> options)
    {
//        if (soot.Main.isVerbose) System.out.println("[" + b.getMethod().getName() + "] Propagating constants...");
        JimpleBody body = (JimpleBody) b;
        Chain units = body.getUnits();
        CompleteUnitGraph stmtGraph = new CompleteUnitGraph(body);
        LocalDefs localDefs = new SimpleLocalDefs(stmtGraph);
        Iterator stmtIt = units.iterator();
        while (stmtIt.hasNext())
        {
            Stmt stmt = (Stmt) stmtIt.next();
            Iterator useBoxIt = stmt.getUseBoxes().iterator();
            while (useBoxIt.hasNext())
            {
                ValueBox useBox = (ValueBox) useBoxIt.next();
                if (useBox.getValue() instanceof Local)
                {
                    Local l = (Local) useBox.getValue();
                    List defsOfUse = localDefs.getDefsOfAt(l, stmt);
                    if (defsOfUse.size() == 1)
                    {
                        DefinitionStmt def = (DefinitionStmt) defsOfUse.get(0);
                        if (def.getRightOp() instanceof Constant)
                        {
                            if (useBox.canContainValue(def.getRightOp()))
                                useBox.setValue(def.getRightOp());
                        }
                    }
                }

            }
        }
    }

}
*/
