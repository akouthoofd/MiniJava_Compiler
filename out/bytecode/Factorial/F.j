.source F.j
.class public F
.super Fac

;================================
; default constructor
;================================
.method public <init>()V
    aload_0
    invokespecial Fac/<init>()V
    return
.end method

;================================
; ComputeFac method
;================================
.method public ComputeFac(I)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; num_aux is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    iload 1                                                         ; Getting num's value from local pool
    ldc 1                                                               ; Loading int constant
    if_icmpge else_2                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_2
else_2:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_2:
    ifeq else_3
    ldc 1                                                               ; Loading int constant
    istore 2                                                            ; Storing item into num_aux
  else_3:
    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
.end method

;================================
; F method
;================================
.method public F()I
    .limit stack 10
    .limit locals 50

    ldc 1                                                               ; Loading int constant


    ireturn
.end method

;================================
; F method
;================================
.method public F(LApple;)I
    .limit stack 10
    .limit locals 50

    ldc 1                                                               ; Loading int constant


    ireturn
.end method

;================================
; F method
;================================
.method public F(I)I
    .limit stack 10
    .limit locals 50

    ldc 1                                                               ; Loading int constant


    ireturn
.end method

;================================
; F method
;================================
.method public F(LN;)I
    .limit stack 10
    .limit locals 50

    ldc 1                                                               ; Loading int constant


    ireturn
.end method

;================================
; $operator_PLUS_SIGN method
;================================
.method public $operator_PLUS_SIGN(LFac;)I
    .limit stack 10
    .limit locals 50

    new F                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial F/<init>()V                                                        ; Calling parent's constructor
    astore 2                                                            ; store the reference to local variable 2
    ldc 0                                                               ; a is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    aload 0                                                         ; Getting this's value from local pool
    astore 2                                                            ; Storing item into fa
    aload 2                                                            ; Loading object
    invokevirtual F/hi()I
    istore 3                                                            ; Storing item into a
    iload 3                                                         ; Getting a's value from local pool
    aload 2                                                            ; Loading object
    ldc 1                                                               ; Loading int constant
    invokevirtual F/F()I
    imul                                                            ; Multiplying top elements on stack
    ldc 10                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack


    ireturn
.end method

;================================
; $operator_PLUS_SIGN method
;================================
.method public $operator_PLUS_SIGN(LN;)I
    .limit stack 10
    .limit locals 50

    new F                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial F/<init>()V                                                        ; Calling parent's constructor
    astore 2                                                            ; store the reference to local variable 2
    ldc 0                                                               ; a is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    aload 0                                                         ; Getting this's value from local pool
    astore 2                                                            ; Storing item into fa
    aload 2                                                            ; Loading object
    invokevirtual F/hi()I
    istore 3                                                            ; Storing item into a
    iload 3                                                         ; Getting a's value from local pool
    aload 2                                                            ; Loading object
    ldc 1                                                               ; Loading int constant
    invokevirtual F/F()I
    imul                                                            ; Multiplying top elements on stack
    ldc 10                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack


    ireturn
.end method

;================================
; $operator_PLUS_SIGN method
;================================
.method public $operator_PLUS_SIGN(LFactorial;)I
    .limit stack 10
    .limit locals 50

    new F                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial F/<init>()V                                                        ; Calling parent's constructor
    astore 2                                                            ; store the reference to local variable 2
    ldc 0                                                               ; a is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    aload 0                                                         ; Getting this's value from local pool
    astore 2                                                            ; Storing item into fa
    aload 2                                                            ; Loading object
    invokevirtual F/hi()I
    istore 3                                                            ; Storing item into a
    iload 3                                                         ; Getting a's value from local pool
    aload 2                                                            ; Loading object
    ldc 1                                                               ; Loading int constant
    invokevirtual F/F()I
    imul                                                            ; Multiplying top elements on stack
    ldc 10                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack


    ireturn
.end method



