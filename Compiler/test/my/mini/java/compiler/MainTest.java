package my.mini.java.compiler;

import jasmin.ClassFile;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

/**
 * Created by alex on 11/21/2016.
 */
@RunWith(Parameterized.class)
public class MainTest
{
    private Path tempDir;

    @Before
    public void createTempDir() throws IOException
    {
        tempDir = Files.createTempDirectory("mainTest");
    }

    @After
    public void deleteTempDir() throws IOException
    {
        removeDirectory(tempDir);
        tempDir.toFile().deleteOnExit();
        tempDir = null;
    }

    public static void removeDirectory(Path directory) throws IOException
    {
        // does nothing if non-existent
        if (Files.exists(directory))
        {
            directory.toFile().listFiles()[0].delete();
            Runtime.getRuntime().exec(new String[] {"rmdir ", directory.toString()});
        }
    }

    public static void removeRecursive(Path path) throws IOException
    {
        Files.walkFileTree(path, new SimpleFileVisitor<Path>()
        {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException
            {
//                file.toFile().delete();
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException
            {
                // try to delete the file anyway, even if its attributes
                // could not be read, since delete-only access is
                // theoretically possible
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException
            {
                if (exc == null)
                {
//                    Files.deleteIfExists(dir);
                    dir.toFile().delete();
                    return FileVisitResult.CONTINUE;
                }
                else
                {
                    // directory iteration failed; propagate exception
                    throw exc;
                }
            }
        });
    }


    private String code;
    private String expectedText;

    public MainTest(String code, String expectedText)
    {
        this.code = code;
        this.expectedText = expectedText;
    }

    @Test
    public void runningCode_outputsExpectedText() throws Exception
    {
        // Compile
        String actualOutput = compileAndRun(code);
        System.out.println("Output: " + actualOutput);
        // Assert
        Assert.assertEquals(expectedText, actualOutput);
    }

    @Parameterized.Parameters(name = "CompiledCodeTest")
    public static Collection<Object[]> provideCode_expectedText()
    {
        return Arrays.asList(new Object[][]
        {
            {fileWith("System.out.println(1 + 2 - 1 * 5 + 6);"), "4" + System.lineSeparator()}
//            {fileWith("int a;"), "" + System.lineSeparator()}
//            {fileWith("int a; a = 5; System.out.println(a);"), "5" + System.lineSeparator()}

        });
    }

    private static Object fileWith(String s)
    {
        return "class Factorial {\n" +
                "    public static void main(String[] a)\n" +
                "    {\n" +
                "         " + s +
                "    }\n" +
                "}";
    }

    private String compileAndRun(String code) throws Exception
    {
        code = Main.compile(new ANTLRInputStream(code));
        ClassFile classFile = new ClassFile();
        classFile.readJasmin(new StringReader(code), "", false);
        Path outputPath = tempDir.resolve(classFile.getClassName() + ".class");
        classFile.write(Files.newOutputStream(outputPath));
        return runJavaClass(tempDir, classFile.getClassName());
    }

    private String runJavaClass(Path tempDir, String className) throws IOException
    {
        Process process = Runtime.getRuntime().exec(new String[]{"java", "-cp", tempDir.toString(), className});
        try(InputStream in = process.getInputStream())
        {
            return new Scanner(in).useDelimiter("\\A").next();
        }
    }
}