.source Test4.j
.class public Test4
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
    new Tree                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Tree/<init>()V                                                        ; Calling parent's constructor
    new MyVisitor                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial MyVisitor/<init>()V                                                        ; Calling parent's constructor
    invokevirtual Tree/accept(LVisitor;)I
    invokevirtual java/io/PrintStream/println(I)V

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 50                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V


    return
.end method



