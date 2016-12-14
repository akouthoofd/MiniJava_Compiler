# MiniJava_Compiler
MiniJava Compiler - Parser generated with ANTLR_v4 and bytecode with Jasmin

# Soot Optimization
My bytecode optimization can be found in src/optimization. Optimization is done -via-shimple.
The optimization reduces known variables to single constants and any if statements that can reduced to true or false are remove accordingly.