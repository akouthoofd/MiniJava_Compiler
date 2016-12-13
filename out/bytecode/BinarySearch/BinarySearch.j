.source BinarySearch.j
.class public BinarySearch
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
    new BS                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial BS/<init>()V                                                        ; Calling parent's constructor
    ldc 20                                                               ; Loading int constant
    invokevirtual BS/Start(I)I
    invokevirtual java/io/PrintStream/println(I)V


    return
.end method



