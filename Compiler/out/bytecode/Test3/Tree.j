.source Tree.j
.class public Tree
.super java/lang/Object

.field public left LTree;                                                        ; Creating public field for class Tree
.field public right LTree;                                                        ; Creating public field for class Tree
.field public key I                                                        ; Creating public field for class Tree
.field public has_left I                                                        ; Creating public field for class Tree
.field public has_right I                                                        ; Creating public field for class Tree
.field public my_null LTree;                                                        ; Creating public field for class Tree
;================================
; default constructor
;================================
.method public <init>()V
    aload_0
    invokespecial java/lang/Object/<init>()V
    return
.end method

;================================
; SetLeft method
;================================
.method public SetLeft(LTree;)I
    .limit stack 10
    .limit locals 50

    aload_0                                                            ; Getting object reference
    aload 1                                                         ; Getting ln's value from local pool
    putfield Tree/left LTree;                                                            ; Storing object into field left
    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
.end method

;================================
; GetLeft method
;================================
.method public GetLeft()LTree;
    .limit stack 10
    .limit locals 50

    aload 0
    getfield Tree/left LTree;                                                            ; Getting object into field left


    areturn
.end method

;================================
; GetKey method
;================================
.method public GetKey()I
    .limit stack 10
    .limit locals 50

    aload 0
    getfield Tree/key I                                                             ; Getting object into field key


    ireturn
.end method

;================================
; SetKey method
;================================
.method public SetKey(I)I
    .limit stack 10
    .limit locals 50

    aload_0                                                            ; Getting object reference
    iload 1                                                         ; Getting v_key's value from local pool
    putfield Tree/key I                                                             ; Storing object into field key
    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
.end method

;================================
; GetHas_Left method
;================================
.method public GetHas_Left()I
    .limit stack 10
    .limit locals 50

    aload 0
    getfield Tree/has_left I                                                             ; Getting object into field has_left


    ireturn
.end method

;================================
; SetHas_Left method
;================================
.method public SetHas_Left(I)I
    .limit stack 10
    .limit locals 50

    aload_0                                                            ; Getting object reference
    iload 1                                                         ; Getting val's value from local pool
    putfield Tree/has_left I                                                             ; Storing object into field has_left
    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
.end method

;================================
; RemoveLeft method
;================================
.method public RemoveLeft(LTree;LTree;)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; ntb is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    aload 2                                                            ; Loading object
    aload 2                                                            ; Loading object
    invokevirtual Tree/GetLeft()LTree;
    invokevirtual Tree/GetKey()I
    invokevirtual Tree/SetKey(I)I
    istore 3                                                            ; Storing item into ntb
    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
.end method



