.source N.j
.class public N
.super Apple

.field public a LApple;                                                        ; Creating public field for class N
;================================
; default constructor
;================================
.method public <init>()V
    aload_0
    invokespecial Apple/<init>()V
    return
.end method

;================================
; random method
;================================
.method public random()I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; num is being initialized and set to zero/false
    istore 1                                                            ; Saving variable in locals
    new Apple                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Apple/<init>()V                                                        ; Calling parent's constructor
    astore 2                                                            ; store the reference to local variable 2
    ldc 5                                                               ; Loading int constant
    istore 1                                                            ; Storing item into num
    aload_0                                                            ; Getting object reference
    iload 1                                                         ; Getting num's value from local pool
    newarray int                                                        ; initializing int array
    putfield Apple/variable [I                                                            ; Storing object into field variable
    new N                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial N/<init>()V                                                        ; Calling parent's constructor
    astore 2                                                            ; Storing object into t
    aload 2                                                            ; Loading object
    invokevirtual Apple/two()LF;
    invokevirtual F/F()I
    istore 1                                                            ; Storing item into num
    ldc 1                                                               ; Loading int constant


    ireturn
.end method

;================================
; stuff method
;================================
.method public stuff(LApple;)I
    .limit stack 10
    .limit locals 50

    ldc 1                                                               ; Loading int constant


    ireturn
.end method

;================================
; stuff method
;================================
.method public stuff()I
    .limit stack 10
    .limit locals 50

    ldc 1                                                               ; Loading int constant


    ireturn
.end method

;================================
; addAttempt method
;================================
.method public addAttempt()I
    .limit stack 10
    .limit locals 50

    new F                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial F/<init>()V                                                        ; Calling parent's constructor
    astore 1                                                            ; store the reference to local variable 1
    new F                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial F/<init>()V                                                        ; Calling parent's constructor
    astore 2                                                            ; store the reference to local variable 2
    ldc 0                                                               ; num is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    new N                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial N/<init>()V                                                        ; Calling parent's constructor
    astore 2                                                            ; Storing object into f
    new Apple                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Apple/<init>()V                                                        ; Calling parent's constructor
    astore 1                                                            ; Storing object into fa
    aload 2                                                         ; Getting f's value from local pool
    aload 1                                                         ; Getting fa's value from local pool
invokevirtual F/$operator_PLUS_SIGN(LFactorial;)I
    istore 3                                                            ; Storing item into num
    iload 3                                                         ; Getting num's value from local pool


    ireturn
.end method



