.source Other.j
.class public Other
.super Some

;================================
; default constructor
;================================
.method public <init>()V
    aload_0
    invokespecial Some/<init>()V
    return
.end method

;================================
; random method
;================================
.method public random(I[I)I
    .limit stack 10
    .limit locals 50

    ldc 5                                                               ; Loading int constant


    ireturn
.end method

;================================
; getTrue method
;================================
.method public getTrue()I
    .limit stack 10
    .limit locals 50

    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
.end method

;================================
; $operator_PLUS_SIGN method
;================================
.method public $operator_PLUS_SIGN(LOther;)I
    .limit stack 10
    .limit locals 50

    ldc 2                                                               ; Loading int constant


    ireturn
.end method

;================================
; $operator_MINUS_SIGN method
;================================
.method public $operator_MINUS_SIGN(LOther;)I
    .limit stack 10
    .limit locals 50

    ldc 3                                                               ; Loading int constant


    ireturn
.end method

;================================
; $operator_LESS_THAN_SIGN method
;================================
.method public $operator_LESS_THAN_SIGN(LOther;)I
    .limit stack 10
    .limit locals 50

    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
.end method

;================================
; $operator_AND_SIGN method
;================================
.method public $operator_AND_SIGN(LOther;)I
    .limit stack 10
    .limit locals 50

    aload 1                                                            ; Loading object
    invokevirtual Other/getTrue()I


    ireturn
.end method



