.source Tree.j
.class public Tree
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
; accept method
;================================
.method public accept(LVisitor;)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; nti is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 333                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
    ldc 0                                                               ; Loading int constant


    ireturn
.end method



