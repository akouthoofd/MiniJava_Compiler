.source MyVisitor.j
.class public MyVisitor
.super Visitor

;================================
; default constructor
;================================
.method public <init>()V
    aload_0
    invokespecial Visitor/<init>()V
    return
.end method

;================================
; visit method
;================================
.method public visit(LTree;)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; nti is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    aload 1                                                            ; Loading object
    invokevirtual Tree/GetHas_Right()I
    ifeq else_38
    aload_0                                                            ; Getting object reference
    aload 1                                                            ; Loading object
    invokevirtual Tree/GetRight()LTree;
    putfield Visitor/r LTree;                                                            ; Storing object into field r
    goto finally_38
  else_38:
    ldc 0                                                               ; Loading int constant
    istore 2                                                            ; Storing item into nti
  finally_38:

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 1                                                            ; Loading object
    invokevirtual Tree/GetKey()I
    invokevirtual java/io/PrintStream/println(I)V
    aload 1                                                            ; Loading object
    invokevirtual Tree/GetHas_Left()I
    ifeq else_39
    aload_0                                                            ; Getting object reference
    aload 1                                                            ; Loading object
    invokevirtual Tree/GetLeft()LTree;
    putfield Visitor/l LTree;                                                            ; Storing object into field l
    goto finally_39
  else_39:
    ldc 0                                                               ; Loading int constant
    istore 2                                                            ; Storing item into nti
  finally_39:
    ldc 0                                                               ; Loading int constant


    ireturn
.end method



