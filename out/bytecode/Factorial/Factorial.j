.source Factorial.j
.class public Factorial
.super java/lang/Object

;================================
; default constructor
;================================
.method public <init>()V
    aload_0
    invokespecial java/lang/Object/<init>()V
    return
.end method

;================================
; main method
;================================
.method public static main([Ljava/lang/String;)V
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; b is being initialized and set to zero/false
    istore 4                                                            ; Saving variable in locals
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 4                                                            ; Storing item into b

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 5                                                               ; Loading int constant
    ldc 3                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    ldc 12                                                               ; Loading int constant
    ldc 2                                                               ; Loading int constant
    imul                                                            ; Multiplying top elements on stack
    iadd                                                            ; Adding top elements on stack
    invokevirtual java/io/PrintStream/println(I)V
    ldc 1                                                               ; Loading int constant
    ldc 5                                                               ; Loading int constant
    if_icmpge else_4                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_4
else_4:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_4:
    ifeq else_5

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 5                                                               ; Loading int constant
    ldc 3                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    ldc 12                                                               ; Loading int constant
    ldc 2                                                               ; Loading int constant
    imul                                                            ; Multiplying top elements on stack
    iadd                                                            ; Adding top elements on stack
    invokevirtual java/io/PrintStream/println(I)V
  else_5:


    return
.end method



