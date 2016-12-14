.source BinaryTree.j
.class public BinaryTree
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
; main method
;================================
.method public static main([Ljava/lang/String;)V
    .limit stack 10
    .limit locals 50


    getstatic java/lang/System/out Ljava/io/PrintStream;
    new BT                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial BT/<init>()V                                                        ; Calling parent's constructor
    invokevirtual BT/Start()I
    invokevirtual java/io/PrintStream/println(I)V


    return
.end method



