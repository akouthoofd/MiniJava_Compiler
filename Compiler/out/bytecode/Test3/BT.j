.source BT.j
.class public BT
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
; Start method
;================================
.method public Start()I
    .limit stack 10
    .limit locals 50

    new Tree                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Tree/<init>()V                                                        ; Calling parent's constructor
    astore 1                                                            ; store the reference to local variable 1
    ldc 0                                                               ; ntb is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    ldc 0                                                               ; nti is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    ldc 0                                                               ; Loading int constant


    ireturn
.end method



