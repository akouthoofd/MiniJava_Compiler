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
    aload_0                                                            ; Getting object reference
    new Tree                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Tree/<init>()V                                                        ; Calling parent's constructor
    putfield Visitor/l LTree;                                                            ; Storing object into field l
    aload_0                                                            ; Getting object reference
    new Tree                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Tree/<init>()V                                                        ; Calling parent's constructor
    putfield Visitor/r LTree;                                                            ; Storing object into field r
    aload 0
    getfield Visitor/r LTree;                                                            ; Getting object into field r
    aload 0                                                         ; Getting this's value from local pool
    invokevirtual Tree/accept(LVisitor;)I
    istore 2                                                            ; Storing item into nti
    aload 0
    getfield Visitor/l LTree;                                                            ; Getting object into field l
    aload 0                                                         ; Getting this's value from local pool
    invokevirtual Tree/accept(LVisitor;)I
    istore 2                                                            ; Storing item into nti
    ldc 0                                                               ; Loading int constant


    ireturn
.end method



