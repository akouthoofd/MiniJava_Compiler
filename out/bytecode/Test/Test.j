.source Test.j
.class public Test
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

    new Other                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Other/<init>()V                                                        ; Calling parent's constructor
    astore 2                                                            ; store the reference to local variable 2
    new Other                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Other/<init>()V                                                        ; Calling parent's constructor
    astore 2                                                            ; store the reference to local variable 2
    new Thing                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Thing/<init>()V                                                        ; Calling parent's constructor
    astore 3                                                            ; store the reference to local variable 3
    ldc 0                                                               ; size is being initialized and set to zero/false
    istore 4                                                            ; Saving variable in locals
    new Other                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Other/<init>()V                                                        ; Calling parent's constructor
    astore 2                                                            ; Storing object into s
    new Other                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Other/<init>()V                                                        ; Calling parent's constructor
    astore 1                                                            ; Storing object into o
    aload 2                                                            ; Loading object
    ldc 5                                                               ; Loading int constant
    invokevirtual Other/setNumb(I)I
    istore 4                                                            ; Storing item into size
    aload 1                                                            ; Loading object
    ldc 2                                                               ; Loading int constant
    invokevirtual Other/setNumb(I)I
    istore 4                                                            ; Storing item into size
    aload 2                                                         ; Getting s's value from local pool
    aload 1                                                         ; Getting o's value from local pool
invokevirtual Other/$operator_MULT_SIGN(LOther;)I
    ldc 3                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 4                                                            ; Storing item into size
    aload 2                                                         ; Getting s's value from local pool
    aload 1                                                         ; Getting o's value from local pool
invokevirtual Other/$operator_AND_SIGN(LOther;)I
    ifeq else_17

    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 4                                                         ; Getting size's value from local pool
    invokevirtual java/io/PrintStream/println(I)V
  else_17:


    return
.end method



