.source LL.j
.class public LL
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

    ldc 0                                                               ; aux01 is being initialized and set to zero/false
    istore 1                                                            ; Saving variable in locals
    new Element                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Element/<init>()V                                                        ; Calling parent's constructor
    astore 2                                                            ; store the reference to local variable 2
    new Element                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Element/<init>()V                                                        ; Calling parent's constructor
    astore 2                                                            ; Storing object into el01
    aload 2                                                            ; Loading object
    ldc 25                                                               ; Loading int constant
    ldc 37000                                                               ; Loading int constant
    ldc 0                                                               ; Loading in boolean constant(false)
    invokevirtual Element/Init(III)I
    istore 1                                                            ; Storing item into aux01
    ldc 0                                                               ; Loading int constant


    ireturn
.end method



