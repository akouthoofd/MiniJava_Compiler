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
    new Tree                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Tree/<init>()V                                                        ; Calling parent's constructor
    astore 1                                                            ; Storing object into root
    aload 1                                                            ; Loading object
    ldc 16                                                               ; Loading int constant
    invokevirtual Tree/Init(I)I
    istore 2                                                            ; Storing item into ntb
    aload 1                                                            ; Loading object
    invokevirtual Tree/Print()I
    istore 2                                                            ; Storing item into ntb

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 100000000                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
    aload 1                                                            ; Loading object
    ldc 8                                                               ; Loading int constant
    invokevirtual Tree/Insert(I)I
    istore 2                                                            ; Storing item into ntb
    aload 1                                                            ; Loading object
    invokevirtual Tree/Print()I
    istore 2                                                            ; Storing item into ntb
    aload 1                                                            ; Loading object
    ldc 24                                                               ; Loading int constant
    invokevirtual Tree/Insert(I)I
    istore 2                                                            ; Storing item into ntb
    aload 1                                                            ; Loading object
    ldc 4                                                               ; Loading int constant
    invokevirtual Tree/Insert(I)I
    istore 2                                                            ; Storing item into ntb
    aload 1                                                            ; Loading object
    ldc 12                                                               ; Loading int constant
    invokevirtual Tree/Insert(I)I
    istore 2                                                            ; Storing item into ntb
    aload 1                                                            ; Loading object
    ldc 20                                                               ; Loading int constant
    invokevirtual Tree/Insert(I)I
    istore 2                                                            ; Storing item into ntb
    aload 1                                                            ; Loading object
    ldc 28                                                               ; Loading int constant
    invokevirtual Tree/Insert(I)I
    istore 2                                                            ; Storing item into ntb
    aload 1                                                            ; Loading object
    ldc 14                                                               ; Loading int constant
    invokevirtual Tree/Insert(I)I
    istore 2                                                            ; Storing item into ntb
    aload 1                                                            ; Loading object
    invokevirtual Tree/Print()I
    istore 2                                                            ; Storing item into ntb

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 1                                                            ; Loading object
    ldc 24                                                               ; Loading int constant
    invokevirtual Tree/Search(I)I
    invokevirtual java/io/PrintStream/println(I)V

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 1                                                            ; Loading object
    ldc 12                                                               ; Loading int constant
    invokevirtual Tree/Search(I)I
    invokevirtual java/io/PrintStream/println(I)V

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 1                                                            ; Loading object
    ldc 16                                                               ; Loading int constant
    invokevirtual Tree/Search(I)I
    invokevirtual java/io/PrintStream/println(I)V

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 1                                                            ; Loading object
    ldc 50                                                               ; Loading int constant
    invokevirtual Tree/Search(I)I
    invokevirtual java/io/PrintStream/println(I)V

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 1                                                            ; Loading object
    ldc 12                                                               ; Loading int constant
    invokevirtual Tree/Search(I)I
    invokevirtual java/io/PrintStream/println(I)V
    aload 1                                                            ; Loading object
    ldc 12                                                               ; Loading int constant
    invokevirtual Tree/Delete(I)I
    istore 2                                                            ; Storing item into ntb
    aload 1                                                            ; Loading object
    invokevirtual Tree/Print()I
    istore 2                                                            ; Storing item into ntb

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 1                                                            ; Loading object
    ldc 12                                                               ; Loading int constant
    invokevirtual Tree/Search(I)I
    invokevirtual java/io/PrintStream/println(I)V
    ldc 0                                                               ; Loading int constant


    ireturn
.end method



