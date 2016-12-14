.source Some.j
.class public Some
.super java/lang/Object

.field public numb I                                                        ; Creating public field for class Some
;================================
; default constructor
;================================
.method public <init>()V
    aload_0
    invokespecial java/lang/Object/<init>()V
    return
.end method

;================================
; getNumb method
;================================
.method public getNumb()I
    .limit stack 10
    .limit locals 50

    aload 0                                                            ; Loading object
    invokevirtual Some/getNum()I


    ireturn
.end method

;================================
; getNum method
;================================
.method public getNum()I
    .limit stack 10
    .limit locals 50

    aload 0
    getfield Some/numb I                                                             ; Getting object into field numb


    ireturn
.end method

;================================
; stuff method
;================================
.method public stuff([I)[I
    .limit stack 10
    .limit locals 50

    aload 1                                                         ; Getting arr's value from local pool


    areturn
.end method

;================================
; setNumb method
;================================
.method public setNumb(I)I
    .limit stack 10
    .limit locals 50

    aload_0                                                            ; Getting object reference
    iload 1                                                         ; Getting a's value from local pool
    putfield Some/numb I                                                             ; Storing object into field numb
    iload 1                                                         ; Getting a's value from local pool


    ireturn
.end method

;================================
; getOther method
;================================
.method public getOther(LOther;)LOther;
    .limit stack 10
    .limit locals 50

    aload 1                                                         ; Getting o's value from local pool


    areturn
.end method

;================================
; $operator_MULT_SIGN method
;================================
.method public $operator_MULT_SIGN(LOther;)I
    .limit stack 10
    .limit locals 50

    aload 0                                                            ; Loading object
    invokevirtual Some/getNum()I
    aload 1                                                            ; Loading object
    invokevirtual Other/getNum()I
    imul                                                            ; Multiplying top elements on stack


    ireturn
.end method



