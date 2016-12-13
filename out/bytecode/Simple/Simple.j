.source Simple.j
.class public Simple
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
    istore 1                                                            ; Saving variable in locals
    ldc 0                                                               ; a is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    ldc 1                                                               ; Loading int constant
    ldc 2                                                               ; Loading int constant
    ldc 2                                                               ; Loading int constant
    imul                                                            ; Multiplying top elements on stack
    iadd                                                            ; Adding top elements on stack
    istore 2                                                            ; Storing item into a
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 1                                                            ; Storing item into b
    ldc 1                                                               ; Loading int constant
    ldc 2                                                               ; Loading int constant
    if_icmpge else_0                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_0
else_0:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_0:
    ifeq else_1

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 5                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
  else_1:
    iload 1                                                         ; Getting b's value from local pool
    ifeq else_2

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 1                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
  else_2:
    ldc 1                                                               ; Loading int constant
    ldc 2                                                               ; Loading int constant
    ldc 4                                                               ; Loading int constant
    ldc 2                                                               ; Loading int constant
    imul                                                            ; Multiplying top elements on stack
    iadd                                                            ; Adding top elements on stack
    if_icmpge else_4                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_4
else_4:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_4:
    ifeq else_3                                                         ; Compare the two boolean expression to make sure they are both either true or false
    iload 1                                                         ; Getting b's value from local pool
    ifeq else_3                                                         ; Check if the conditional is true or false
    ldc 1                                                           ; Literal true given on successful pass of above conditionals
    goto finally_3
else_3:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_3:
    ifeq else_5

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 50                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
  else_5:

    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 2                                                         ; Getting a's value from local pool
    invokevirtual java/io/PrintStream/println(I)V


    return
.end method



