# MiniJava_Compiler
MiniJava Compiler - Parser generated with ANTLR_v4 and bytecode with Jasmin

# Soot Optimization
My bytecode optimization can be found in src/optimization. Optimization is done -via-shimple.<br/>
The optimization reduces known variables to single constants and any if statements that can reduced to true or false are remove accordingly.<br/>
Run command: java Main -f class -via-shimple -process-dir \<dir with class files in it\> <br/>
<ol>
    <li> Main in optimization folder </li>
    <li> -f class is optional (Explicitly states to generate class files for final output) </li>
    <li> -process-dir will run class files in the specific folder <br/>     Note: If you try to run a directory with more class files in lower folders you'll need additional changes to acknowledge the package difference. </li>
</ol>
