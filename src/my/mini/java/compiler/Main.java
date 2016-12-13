package my.mini.java.compiler;

import jasmin.ClassFile;
import my.mini.java.compiler.AST.BuildASTVisitor;
import my.mini.java.compiler.AST.CodeGenerationVisitor;
import my.mini.java.compiler.AST.EvaluatedASTVisitor;
import my.mini.java.compiler.AST.nodes.Node;
import my.mini.java.parser.ExceptionErrorStrategy;
import my.mini.java.parser.MiniJavaLexer;
import my.mini.java.parser.MiniJavaParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Created by alex on 11/2/2016.
 */
public class Main
{
//    private static File program;
    private static String dirName;

    public static void main(String[] args) throws Exception
    {
//        ANTLRInputStream input = new ANTLRFileStream("src/my/mini/java/grammar/Simple.java");
//        ANTLRInputStream input = new ANTLRFileStream("src/my/mini/java/grammar/Main.mjava");
        ANTLRInputStream input = new ANTLRFileStream("src/my/mini/java/grammar/Test.java");
//        ANTLRInputStream input = new ANTLRFileStream("src/my/mini/java/grammar/Test2.java");
//        ANTLRInputStream input = new ANTLRFileStream("src/my/mini/java/grammar/Test3.java");
//        ANTLRInputStream input = new ANTLRFileStream("src/my/mini/java/grammar/Test4.java");
//        ANTLRInputStream input = new ANTLRFileStream("src/my/mini/java/grammar/Test5.java");
//        ANTLRInputStream input = new ANTLRFileStream("src/my/mini/java/grammar/BinarySearch.java");
//        ANTLRInputStream input = new ANTLRFileStream("src/my/mini/java/grammar/BinaryTree.java");
//        ANTLRInputStream input = new ANTLRFileStream("src/my/mini/java/grammar/BubbleSort.java");
//        ANTLRInputStream input = new ANTLRFileStream("src/my/mini/java/grammar/Factorial.java");
//        ANTLRInputStream input = new ANTLRFileStream("src/my/mini/java/grammar/LinearSearch.java");
//        ANTLRInputStream input = new ANTLRFileStream("src/my/mini/java/grammar/QuickSort.java");
//        ANTLRInputStream input = new ANTLRFileStream("src/my/mini/java/grammar/TreeVisitor.java");
//        ANTLRInputStream input = new ANTLRFileStream("src/my/mini/java/grammar/LinkedList.java");

        String jasmin = compile(input);
        System.out.println(jasmin);
        System.out.println(compileAndRun(jasmin));
//        File input = new File("out\\other_classes\\");
//        for (File in: input.listFiles())
//        {
//            for (File i: in.listFiles())
//            {
//                Process process = Runtime.getRuntime().exec(new String[]{"java", "-cp", i.getAbsolutePath().replace(i.getName(), ""), i.getName().replace(".class", "")});
//                StringBuilder output = new StringBuilder();
//                try(InputStream stream = process.getInputStream())
//                {
//                    Scanner sc = new Scanner(stream);
//                    while (sc.hasNextLine())
//                    {
//                        String o = sc.nextLine();
//                        output.append(o).append(System.lineSeparator());
//                        System.out.println(o);
//                    }
//                    try(  PrintWriter out = new PrintWriter("C:\\Users\\alex\\Coding\\CSC444\\MyCompiler\\Compiler\\out\\other_output\\" + i.getName().replace(".class", "") + ".txt")  ){
//                        out.println(output.toString());
//                        out.close();
//                    }
////            return new Scanner(in).useDelimiter("\\A").next();
//                }
//            }
//        }
    }

    public static String compile(ANTLRInputStream input)
    {
        // Get our lexer
        MiniJavaLexer lexer = new MiniJavaLexer(input);
        lexer.addErrorListener(new MyErrorListener());

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        MiniJavaParser parser = new MiniJavaParser(tokens);
        parser.addErrorListener(new MyErrorListener());
        parser.setErrorHandler(new ExceptionErrorStrategy());

        MiniJavaParser.ProgContext miniJavaContext = parser.prog();

        ParseTreeWalker walker = new ParseTreeWalker();
        MyListener listener;
        if (input.getSourceName().contains("/"))
        {
            String sourceName = input.getSourceName().substring(input.getSourceName().lastIndexOf("/")).replace("/", "");
            listener = new MyListener(sourceName);
            walker.walk(listener, miniJavaContext);

            BuildASTVisitor visitor = new BuildASTVisitor(sourceName);
            Node ast = visitor.visit(miniJavaContext);
//            System.out.println(visitor.getSymbolTable());
            EvaluatedASTVisitor eval = new EvaluatedASTVisitor(sourceName);
            eval.visit(ast);
            dirName = eval.getMainClassName();
//            return new MyVisitor().visit(miniJavaContext);
            return new CodeGenerationVisitor(eval.getParameters(), eval.getClassNames()).visit(ast);
        }
        else
        {
            listener = new MyListener(input.getSourceName());
            walker.walk(listener, miniJavaContext);

            BuildASTVisitor visitor = new BuildASTVisitor(input.getSourceName());
            Node ast = visitor.visit(miniJavaContext);
            EvaluatedASTVisitor eval = new EvaluatedASTVisitor(input.getSourceName());
            eval.visit(ast);
            dirName = eval.getMainClassName();
//            return createJasminFile(new MyVisitor().visit(miniJavaContext));
            return new CodeGenerationVisitor(eval.getParameters(), eval.getClassNames()).visit(ast);
        }
//        return "";
    }

    private static String compileAndRun(String code) throws Exception
    {
        String[] classes = code.split(".source");
        File program = new File("C:\\Users\\alex\\Coding\\CSC444\\MyCompiler\\Compiler\\out\\classes\\" + dirName);
        if (!program.exists())
            program.mkdir();
        ClassFile main = null;
        for (String s: classes)
        {
            if (!s.equals(""))
            {
                String oneClass = ".source" + s + System.lineSeparator();
                ClassFile classFile = new ClassFile();
                classFile.readJasmin(new StringReader(oneClass), "", false);
                Path outputPath = program.toPath().resolve(classFile.getClassName() + ".class");
                File jasminFile = new File("C:\\Users\\alex\\Coding\\CSC444\\MyCompiler\\Compiler\\out\\bytecode\\" + dirName);
                if (!jasminFile.exists())
                    jasminFile.mkdir();
                try(  PrintWriter out = new PrintWriter("C:\\Users\\alex\\Coding\\CSC444\\MyCompiler\\Compiler\\out\\bytecode\\" + dirName + "\\" + classFile.getClassName() + ".j")  ){
                    out.println( oneClass );
                    out.close();
                }
                classFile.write(Files.newOutputStream(outputPath));
                if (s.contains(dirName+".j"))
                    main = classFile;
            }
        }

        return runJavaClass(program.toPath(), main.getClassName());
    }

    private static String runJavaClass(Path tempDir, String className) throws IOException
    {
        File outFile = new File("C:\\Users\\alex\\Coding\\CSC444\\MyCompiler\\Compiler\\out\\output");
        if (!outFile.exists())
            outFile.mkdir();
        Process process = Runtime.getRuntime().exec(new String[]{"java", "-cp", tempDir.toString(), className});
        StringBuilder output = new StringBuilder();
        try(InputStream in = process.getInputStream())
        {
            Scanner sc = new Scanner(in);
            while (sc.hasNextLine())
            {
                String o = sc.nextLine();
                output.append(o).append(System.lineSeparator());
                System.out.println(o);
            }
            try(  PrintWriter out = new PrintWriter("C:\\Users\\alex\\Coding\\CSC444\\MyCompiler\\Compiler\\out\\output\\" + className + ".txt")  ){
                out.println(output.toString());
                out.close();
            }
//            return new Scanner(in).useDelimiter("\\A").next();
        }
        return "";
    }
}
