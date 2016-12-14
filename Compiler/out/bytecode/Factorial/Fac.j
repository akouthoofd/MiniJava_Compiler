.source Fac.j
.class public Fac
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
; ComputeFac method
;================================
.method public ComputeFac(I)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; num_aux is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    ldc 0                                                               ; asd is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    new F                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial F/<init>()V                                                        ; Calling parent's constructor
    astore 4                                                            ; store the reference to local variable 4
    new F                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial F/<init>()V                                                        ; Calling parent's constructor
    astore 4                                                            ; Storing object into apple
    aload 4                                                            ; Loading object
    invokevirtual F/hi()I
    istore 3                                                            ; Storing item into asd
    ldc 2                                                               ; Loading int constant
    istore 2                                                            ; Storing item into num_aux
    iload 1                                                         ; Getting num's value from local pool
    ldc 1                                                               ; Loading int constant
    if_icmpge else_0                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_0
else_0:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_0:
    ifeq else_1
    ldc 1                                                               ; Loading int constant
    istore 2                                                            ; Storing item into num_aux
    goto finally_1
  else_1:
    iload 1                                                         ; Getting num's value from local pool
    aload 0                                                            ; Loading object
    iload 1                                                         ; Getting num's value from local pool
    ldc 1                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    invokevirtual Fac/ComputeFac(I)I
    imul                                                            ; Multiplying top elements on stack
    istore 2                                                            ; Storing item into num_aux
  finally_1:
    iload 2                                                         ; Getting num_aux's value from local pool


    ireturn
.end method

;================================
; other method
;================================
.method public other([I)[I
    .limit stack 10
    .limit locals 50

    aload 1                                                         ; Getting a's value from local pool


    areturn
.end method

;================================
; hi method
;================================
.method public hi()I
    .limit stack 10
    .limit locals 50

    ldc 1                                                               ; Loading int constant


    ireturn
.end method

;================================
; $operator_PLUS_SIGN method
;================================
.method public $operator_PLUS_SIGN(LFactorial;)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; a is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    ldc 1                                                               ; Loading int constant
    istore 2                                                            ; Storing item into a
    iload 2                                                         ; Getting a's value from local pool
    ldc 10                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack


    ireturn
.end method



