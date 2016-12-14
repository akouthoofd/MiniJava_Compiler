.source List.j
.class public List
.super java/lang/Object

.field public elem LElement;                                                        ; Creating public field for class List
.field public next LList;                                                        ; Creating public field for class List
.field public end I                                                        ; Creating public field for class List
;================================
; default constructor
;================================
.method public <init>()V
    aload_0
    invokespecial java/lang/Object/<init>()V
    return
.end method

;================================
; Init method
;================================
.method public Init()I
    .limit stack 10
    .limit locals 50

    aload_0                                                            ; Getting object reference
    ldc 1                                                               ; Loading in boolean constant(true)
    putfield List/end I                                                             ; Storing object into field end
    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
.end method

;================================
; InitNew method
;================================
.method public InitNew(LElement;LList;I)I
    .limit stack 10
    .limit locals 50

    aload_0                                                            ; Getting object reference
    iload 3                                                         ; Getting v_end's value from local pool
    putfield List/end I                                                             ; Storing object into field end
    aload_0                                                            ; Getting object reference
    aload 1                                                         ; Getting v_elem's value from local pool
    putfield List/elem LElement;                                                            ; Storing object into field elem
    aload_0                                                            ; Getting object reference
    aload 2                                                         ; Getting v_next's value from local pool
    putfield List/next LList;                                                            ; Storing object into field next
    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
.end method

;================================
; Insert method
;================================
.method public Insert(LElement;)LList;
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; ret_val is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    new List                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial List/<init>()V                                                        ; Calling parent's constructor
    astore 3                                                            ; store the reference to local variable 3
    new List                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial List/<init>()V                                                        ; Calling parent's constructor
    astore 4                                                            ; store the reference to local variable 4
    aload 0                                                         ; Getting this's value from local pool
    astore 3                                                            ; Storing item into aux03
    new List                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial List/<init>()V                                                        ; Calling parent's constructor
    astore 4                                                            ; Storing object into aux02
    aload 4                                                            ; Loading object
    aload 1                                                         ; Getting new_elem's value from local pool
    aload 3                                                         ; Getting aux03's value from local pool
    ldc 0                                                               ; Loading in boolean constant(false)
    invokevirtual List/InitNew(LElement;LList;I)I
    istore 2                                                            ; Storing item into ret_val
    aload 4                                                         ; Getting aux02's value from local pool


    areturn
.end method

;================================
; SetNext method
;================================
.method public SetNext(LList;)I
    .limit stack 10
    .limit locals 50

    aload_0                                                            ; Getting object reference
    aload 1                                                         ; Getting v_next's value from local pool
    putfield List/next LList;                                                            ; Storing object into field next
    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
.end method

;================================
; Delete method
;================================
.method public Delete(LElement;)LList;
    .limit stack 10
    .limit locals 50

    new List                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial List/<init>()V                                                        ; Calling parent's constructor
    astore 2                                                            ; store the reference to local variable 2
    ldc 0                                                               ; ret_val is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    ldc 0                                                               ; aux05 is being initialized and set to zero/false
    istore 4                                                            ; Saving variable in locals
    new List                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial List/<init>()V                                                        ; Calling parent's constructor
    astore 5                                                            ; store the reference to local variable 5
    new List                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial List/<init>()V                                                        ; Calling parent's constructor
    astore 6                                                            ; store the reference to local variable 6
    ldc 0                                                               ; var_end is being initialized and set to zero/false
    istore 7                                                            ; Saving variable in locals
    new Element                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Element/<init>()V                                                        ; Calling parent's constructor
    astore 8                                                            ; store the reference to local variable 8
    ldc 0                                                               ; aux04 is being initialized and set to zero/false
    istore 9                                                            ; Saving variable in locals
    ldc 0                                                               ; nt is being initialized and set to zero/false
    istore 10                                                            ; Saving variable in locals
    aload 0                                                         ; Getting this's value from local pool
    astore 2                                                            ; Storing item into my_head
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 3                                                            ; Storing item into ret_val
    ldc 0                                                               ; Loading int constant
    ldc 1                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    istore 9                                                            ; Storing item into aux04
    aload 0                                                         ; Getting this's value from local pool
    astore 5                                                            ; Storing item into aux01
    aload 0                                                         ; Getting this's value from local pool
    astore 6                                                            ; Storing item into prev
    aload 0
    getfield List/end I                                                             ; Getting object into field end
    istore 7                                                            ; Storing item into var_end
    aload 0
    getfield List/elem LElement;                                                            ; Getting object into field elem
    astore 8                                                            ; Storing item into var_elem
finally_13:
    iload 7                                                         ; Getting var_end's value from local pool
    ifne else_15                                                     ; Not the boolean expression
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_15
else_15:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_15:
    ifeq else_14                                                         ; Compare the two boolean expression to make sure they are both either true or false
    iload 3                                                         ; Getting ret_val's value from local pool
    ifne else_16                                                     ; Not the boolean expression
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_16
else_16:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_16:
    ifeq else_14                                                         ; Check if the conditional is true or false
    ldc 1                                                           ; Literal true given on successful pass of above conditionals
    goto finally_14
else_14:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_14:
    ifeq else_13
    aload 1                                                            ; Loading object
    aload 8                                                         ; Getting var_elem's value from local pool
    invokevirtual Element/Equal(LElement;)I
    ifeq else_17
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 3                                                            ; Storing item into ret_val
    iload 9                                                         ; Getting aux04's value from local pool
    ldc 0                                                               ; Loading int constant
    if_icmpge else_18                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_18
else_18:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_18:
    ifeq else_19
    aload 5                                                            ; Loading object
    invokevirtual List/GetNext()LList;
    astore 2                                                            ; Storing item into my_head
    goto finally_19
  else_19:

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 0                                                               ; Loading int constant
    ldc 555                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    invokevirtual java/io/PrintStream/println(I)V
    aload 6                                                            ; Loading object
    aload 5                                                            ; Loading object
    invokevirtual List/GetNext()LList;
    invokevirtual List/SetNext(LList;)I
    istore 4                                                            ; Storing item into aux05

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 0                                                               ; Loading int constant
    ldc 555                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    invokevirtual java/io/PrintStream/println(I)V
  finally_19:
    goto finally_17
  else_17:
    ldc 0                                                               ; Loading int constant
    istore 10                                                            ; Storing item into nt
  finally_17:
    iload 3                                                         ; Getting ret_val's value from local pool
    ifne else_20                                                     ; Not the boolean expression
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_20
else_20:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_20:
    ifeq else_21
    aload 5                                                         ; Getting aux01's value from local pool
    astore 6                                                            ; Storing item into prev
    aload 5                                                            ; Loading object
    invokevirtual List/GetNext()LList;
    astore 5                                                            ; Storing item into aux01
    aload 5                                                            ; Loading object
    invokevirtual List/GetEnd()I
    istore 7                                                            ; Storing item into var_end
    aload 5                                                            ; Loading object
    invokevirtual List/GetElem()LElement;
    astore 8                                                            ; Storing item into var_elem
    ldc 1                                                               ; Loading int constant
    istore 9                                                            ; Storing item into aux04
    goto finally_21
  else_21:
    ldc 0                                                               ; Loading int constant
    istore 10                                                            ; Storing item into nt
  finally_21:
    goto finally_13
  else_13:
    aload 2                                                         ; Getting my_head's value from local pool


    areturn
.end method

;================================
; Search method
;================================
.method public Search(LElement;)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; int_ret_val is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    new List                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial List/<init>()V                                                        ; Calling parent's constructor
    astore 3                                                            ; store the reference to local variable 3
    new Element                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Element/<init>()V                                                        ; Calling parent's constructor
    astore 4                                                            ; store the reference to local variable 4
    ldc 0                                                               ; var_end is being initialized and set to zero/false
    istore 5                                                            ; Saving variable in locals
    ldc 0                                                               ; nt is being initialized and set to zero/false
    istore 6                                                            ; Saving variable in locals
    ldc 0                                                               ; Loading int constant
    istore 2                                                            ; Storing item into int_ret_val
    aload 0                                                         ; Getting this's value from local pool
    astore 3                                                            ; Storing item into aux01
    aload 0
    getfield List/end I                                                             ; Getting object into field end
    istore 5                                                            ; Storing item into var_end
    aload 0
    getfield List/elem LElement;                                                            ; Getting object into field elem
    astore 4                                                            ; Storing item into var_elem
finally_22:
    iload 5                                                         ; Getting var_end's value from local pool
    ifne else_23                                                     ; Not the boolean expression
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_23
else_23:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_23:
    ifeq else_22
    aload 1                                                            ; Loading object
    aload 4                                                         ; Getting var_elem's value from local pool
    invokevirtual Element/Equal(LElement;)I
    ifeq else_24
    ldc 1                                                               ; Loading int constant
    istore 2                                                            ; Storing item into int_ret_val
    goto finally_24
  else_24:
    ldc 0                                                               ; Loading int constant
    istore 6                                                            ; Storing item into nt
  finally_24:
    aload 3                                                            ; Loading object
    invokevirtual List/GetNext()LList;
    astore 3                                                            ; Storing item into aux01
    aload 3                                                            ; Loading object
    invokevirtual List/GetEnd()I
    istore 5                                                            ; Storing item into var_end
    aload 3                                                            ; Loading object
    invokevirtual List/GetElem()LElement;
    astore 4                                                            ; Storing item into var_elem
    goto finally_22
  else_22:
    iload 2                                                         ; Getting int_ret_val's value from local pool


    ireturn
.end method

;================================
; GetEnd method
;================================
.method public GetEnd()I
    .limit stack 10
    .limit locals 50

    aload 0
    getfield List/end I                                                             ; Getting object into field end


    ireturn
.end method

;================================
; GetElem method
;================================
.method public GetElem()LElement;
    .limit stack 10
    .limit locals 50

    aload 0
    getfield List/elem LElement;                                                            ; Getting object into field elem


    areturn
.end method

;================================
; GetNext method
;================================
.method public GetNext()LList;
    .limit stack 10
    .limit locals 50

    aload 0
    getfield List/next LList;                                                            ; Getting object into field next


    areturn
.end method

;================================
; Print method
;================================
.method public Print()I
    .limit stack 10
    .limit locals 50

    new List                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial List/<init>()V                                                        ; Calling parent's constructor
    astore 1                                                            ; store the reference to local variable 1
    ldc 0                                                               ; var_end is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    new Element                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Element/<init>()V                                                        ; Calling parent's constructor
    astore 3                                                            ; store the reference to local variable 3
    aload 0                                                         ; Getting this's value from local pool
    astore 1                                                            ; Storing item into aux01
    aload 0
    getfield List/end I                                                             ; Getting object into field end
    istore 2                                                            ; Storing item into var_end
    aload 0
    getfield List/elem LElement;                                                            ; Getting object into field elem
    astore 3                                                            ; Storing item into var_elem
finally_25:
    iload 2                                                         ; Getting var_end's value from local pool
    ifne else_26                                                     ; Not the boolean expression
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_26
else_26:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_26:
    ifeq else_25

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 3                                                            ; Loading object
    invokevirtual Element/GetAge()I
    invokevirtual java/io/PrintStream/println(I)V
    aload 1                                                            ; Loading object
    invokevirtual List/GetNext()LList;
    astore 1                                                            ; Storing item into aux01
    aload 1                                                            ; Loading object
    invokevirtual List/GetEnd()I
    istore 2                                                            ; Storing item into var_end
    aload 1                                                            ; Loading object
    invokevirtual List/GetElem()LElement;
    astore 3                                                            ; Storing item into var_elem
    goto finally_25
  else_25:
    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
.end method



