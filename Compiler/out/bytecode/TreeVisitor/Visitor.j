.source Visitor.j
.class public Visitor
.super java/lang/Object

.field public l LTree;                                                        ; Creating public field for class Visitor
.field public r LTree;                                                        ; Creating public field for class Visitor
;================================
; default constructor
;================================
.method public <init>()V
    aload_0
    invokespecial java/lang/Object/<init>()V
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
    ifeq else_36
    aload_0                                                            ; Getting object reference
    aload 1                                                            ; Loading object
    invokevirtual Tree/GetRight()LTree;
    putfield Visitor/r LTree;                                                            ; Storing object into field r
    goto finally_36
  else_36:
    ldc 0                                                               ; Loading int constant
    istore 2                                                            ; Storing item into nti
  finally_36:
    aload 1                                                            ; Loading object
    invokevirtual Tree/GetHas_Left()I
    ifeq else_37
    aload_0                                                            ; Getting object reference
    aload 1                                                            ; Loading object
    invokevirtual Tree/GetLeft()LTree;
    putfield Visitor/l LTree;                                                            ; Storing object into field l
    goto finally_37
  else_37:
    ldc 0                                                               ; Loading int constant
    istore 2                                                            ; Storing item into nti
  finally_37:
    ldc 0                                                               ; Loading int constant


    ireturn
.end method



