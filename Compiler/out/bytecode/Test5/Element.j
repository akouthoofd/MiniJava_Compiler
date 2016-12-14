.source Element.j
.class public Element
.super java/lang/Object

.field public Age I                                                        ; Creating public field for class Element
.field public Salary I                                                        ; Creating public field for class Element
.field public Married I                                                        ; Creating public field for class Element
;================================
; default constructor
;================================
.method public <init>()V
    aload_0
    invokespecial java/lang/Object/<init>()V
    return
.end method

;================================
; Init method
;================================
.method public Init(III)I
    .limit stack 10
    .limit locals 50

    aload_0                                                            ; Getting object reference
    iload 1                                                         ; Getting v_Age's value from local pool
    putfield Element/Age I                                                             ; Storing object into field Age
    aload_0                                                            ; Getting object reference
    iload 2                                                         ; Getting v_Salary's value from local pool
    putfield Element/Salary I                                                             ; Storing object into field Salary
    aload_0                                                            ; Getting object reference
    iload 3                                                         ; Getting v_Married's value from local pool
    putfield Element/Married I                                                             ; Storing object into field Married
    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
.end method



