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

    new List                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial List/<init>()V                                                        ; Calling parent's constructor
    astore 1                                                            ; store the reference to local variable 1
    new List                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial List/<init>()V                                                        ; Calling parent's constructor
    astore 2                                                            ; store the reference to local variable 2
    ldc 0                                                               ; aux01 is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    new Element                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Element/<init>()V                                                        ; Calling parent's constructor
    astore 4                                                            ; store the reference to local variable 4
    new Element                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Element/<init>()V                                                        ; Calling parent's constructor
    astore 5                                                            ; store the reference to local variable 5
    new Element                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Element/<init>()V                                                        ; Calling parent's constructor
    astore 6                                                            ; store the reference to local variable 6
    new List                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial List/<init>()V                                                        ; Calling parent's constructor
    astore 2                                                            ; Storing object into last_elem
    aload 2                                                            ; Loading object
    invokevirtual List/Init()I
    istore 3                                                            ; Storing item into aux01
    aload 2                                                         ; Getting last_elem's value from local pool
    astore 1                                                            ; Storing item into head
    aload 1                                                            ; Loading object
    invokevirtual List/Init()I
    istore 3                                                            ; Storing item into aux01
    aload 1                                                            ; Loading object
    invokevirtual List/Print()I
    istore 3                                                            ; Storing item into aux01
    new Element                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Element/<init>()V                                                        ; Calling parent's constructor
    astore 4                                                            ; Storing object into el01
    aload 4                                                            ; Loading object
    ldc 25                                                               ; Loading int constant
    ldc 37000                                                               ; Loading int constant
    ldc 0                                                               ; Loading in boolean constant(false)
    invokevirtual Element/Init(III)I
    istore 3                                                            ; Storing item into aux01
    aload 1                                                            ; Loading object
    aload 4                                                         ; Getting el01's value from local pool
    invokevirtual List/Insert(LElement;)LList;
    astore 1                                                            ; Storing item into head
    aload 1                                                            ; Loading object
    invokevirtual List/Print()I
    istore 3                                                            ; Storing item into aux01

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 10000000                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
    new Element                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Element/<init>()V                                                        ; Calling parent's constructor
    astore 4                                                            ; Storing object into el01
    aload 4                                                            ; Loading object
    ldc 39                                                               ; Loading int constant
    ldc 42000                                                               ; Loading int constant
    ldc 1                                                               ; Loading in boolean constant(true)
    invokevirtual Element/Init(III)I
    istore 3                                                            ; Storing item into aux01
    aload 4                                                         ; Getting el01's value from local pool
    astore 5                                                            ; Storing item into el02
    aload 1                                                            ; Loading object
    aload 4                                                         ; Getting el01's value from local pool
    invokevirtual List/Insert(LElement;)LList;
    astore 1                                                            ; Storing item into head
    aload 1                                                            ; Loading object
    invokevirtual List/Print()I
    istore 3                                                            ; Storing item into aux01

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 10000000                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
    new Element                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Element/<init>()V                                                        ; Calling parent's constructor
    astore 4                                                            ; Storing object into el01
    aload 4                                                            ; Loading object
    ldc 22                                                               ; Loading int constant
    ldc 34000                                                               ; Loading int constant
    ldc 0                                                               ; Loading in boolean constant(false)
    invokevirtual Element/Init(III)I
    istore 3                                                            ; Storing item into aux01
    aload 1                                                            ; Loading object
    aload 4                                                         ; Getting el01's value from local pool
    invokevirtual List/Insert(LElement;)LList;
    astore 1                                                            ; Storing item into head
    aload 1                                                            ; Loading object
    invokevirtual List/Print()I
    istore 3                                                            ; Storing item into aux01
    new Element                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Element/<init>()V                                                        ; Calling parent's constructor
    astore 6                                                            ; Storing object into el03
    aload 6                                                            ; Loading object
    ldc 27                                                               ; Loading int constant
    ldc 34000                                                               ; Loading int constant
    ldc 0                                                               ; Loading in boolean constant(false)
    invokevirtual Element/Init(III)I
    istore 3                                                            ; Storing item into aux01

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 1                                                            ; Loading object
    aload 5                                                         ; Getting el02's value from local pool
    invokevirtual List/Search(LElement;)I
    invokevirtual java/io/PrintStream/println(I)V

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 1                                                            ; Loading object
    aload 6                                                         ; Getting el03's value from local pool
    invokevirtual List/Search(LElement;)I
    invokevirtual java/io/PrintStream/println(I)V

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 10000000                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
    new Element                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Element/<init>()V                                                        ; Calling parent's constructor
    astore 4                                                            ; Storing object into el01
    aload 4                                                            ; Loading object
    ldc 28                                                               ; Loading int constant
    ldc 35000                                                               ; Loading int constant
    ldc 0                                                               ; Loading in boolean constant(false)
    invokevirtual Element/Init(III)I
    istore 3                                                            ; Storing item into aux01
    aload 1                                                            ; Loading object
    aload 4                                                         ; Getting el01's value from local pool
    invokevirtual List/Insert(LElement;)LList;
    astore 1                                                            ; Storing item into head
    aload 1                                                            ; Loading object
    invokevirtual List/Print()I
    istore 3                                                            ; Storing item into aux01

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 2220000                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
    aload 1                                                            ; Loading object
    aload 5                                                         ; Getting el02's value from local pool
    invokevirtual List/Delete(LElement;)LList;
    astore 1                                                            ; Storing item into head
    aload 1                                                            ; Loading object
    invokevirtual List/Print()I
    istore 3                                                            ; Storing item into aux01

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 33300000                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
    aload 1                                                            ; Loading object
    aload 4                                                         ; Getting el01's value from local pool
    invokevirtual List/Delete(LElement;)LList;
    astore 1                                                            ; Storing item into head
    aload 1                                                            ; Loading object
    invokevirtual List/Print()I
    istore 3                                                            ; Storing item into aux01

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 44440000                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
    ldc 0                                                               ; Loading int constant


    ireturn
.end method



