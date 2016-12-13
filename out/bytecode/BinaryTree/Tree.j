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
; Init method
;================================
.method public Init(I)I
    .limit stack 10
    .limit locals 50

    aload_0                                                            ; Getting object reference
    iload 1                                                         ; Getting v_key's value from local pool
    putfield Tree/key I                                                             ; Storing object into field key
    aload_0                                                            ; Getting object reference
    ldc 0                                                               ; Loading in boolean constant(false)
    putfield Tree/has_left I                                                             ; Storing object into field has_left
    aload_0                                                            ; Getting object reference
    ldc 0                                                               ; Loading in boolean constant(false)
    putfield Tree/has_right I                                                             ; Storing object into field has_right
    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
.end method

;================================
; SetRight method
;================================
.method public SetRight(LTree;)I
    .limit stack 10
    .limit locals 50

    aload_0                                                            ; Getting object reference
    aload 1                                                         ; Getting rn's value from local pool
    putfield Tree/right LTree;                                                            ; Storing object into field right
    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
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
; GetRight method
;================================
.method public GetRight()LTree;
    .limit stack 10
    .limit locals 50

    aload 0
    getfield Tree/right LTree;                                                            ; Getting object into field right


    areturn
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
; GetHas_Right method
;================================
.method public GetHas_Right()I
    .limit stack 10
    .limit locals 50

    aload 0
    getfield Tree/has_right I                                                             ; Getting object into field has_right


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
; SetHas_Right method
;================================
.method public SetHas_Right(I)I
    .limit stack 10
    .limit locals 50

    aload_0                                                            ; Getting object reference
    iload 1                                                         ; Getting val's value from local pool
    putfield Tree/has_right I                                                             ; Storing object into field has_right
    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
.end method

;================================
; Compare method
;================================
.method public Compare(II)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; ntb is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    ldc 0                                                               ; nti is being initialized and set to zero/false
    istore 4                                                            ; Saving variable in locals
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 3                                                            ; Storing item into ntb
    iload 2                                                         ; Getting num2's value from local pool
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 4                                                            ; Storing item into nti
    iload 1                                                         ; Getting num1's value from local pool
    iload 2                                                         ; Getting num2's value from local pool
    if_icmpge else_0                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_0
else_0:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_0:
    ifeq else_1
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 3                                                            ; Storing item into ntb
    goto finally_1
  else_1:
    iload 1                                                         ; Getting num1's value from local pool
    iload 4                                                         ; Getting nti's value from local pool
    if_icmpge else_3                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_3
else_3:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_3:
    ifne else_2                                                     ; Not the boolean expression
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_2
else_2:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_2:
    ifeq else_4
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 3                                                            ; Storing item into ntb
    goto finally_4
  else_4:
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 3                                                            ; Storing item into ntb
  finally_4:
  finally_1:
    iload 3                                                         ; Getting ntb's value from local pool


    ireturn
.end method

;================================
; Insert method
;================================
.method public Insert(I)I
    .limit stack 10
    .limit locals 50

    new Tree                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Tree/<init>()V                                                        ; Calling parent's constructor
    astore 2                                                            ; store the reference to local variable 2
    ldc 0                                                               ; ntb is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    ldc 0                                                               ; cont is being initialized and set to zero/false
    istore 4                                                            ; Saving variable in locals
    ldc 0                                                               ; key_aux is being initialized and set to zero/false
    istore 5                                                            ; Saving variable in locals
    new Tree                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Tree/<init>()V                                                        ; Calling parent's constructor
    astore 6                                                            ; store the reference to local variable 6
    new Tree                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Tree/<init>()V                                                        ; Calling parent's constructor
    astore 2                                                            ; Storing object into new_node
    aload 2                                                            ; Loading object
    iload 1                                                         ; Getting v_key's value from local pool
    invokevirtual Tree/Init(I)I
    istore 3                                                            ; Storing item into ntb
    aload 0                                                         ; Getting this's value from local pool
    astore 6                                                            ; Storing item into current_node
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 4                                                            ; Storing item into cont
finally_5:
    iload 4                                                         ; Getting cont's value from local pool
    ifeq else_5
    aload 6                                                            ; Loading object
    invokevirtual Tree/GetKey()I
    istore 5                                                            ; Storing item into key_aux
    iload 1                                                         ; Getting v_key's value from local pool
    iload 5                                                         ; Getting key_aux's value from local pool
    if_icmpge else_6                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_6
else_6:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_6:
    ifeq else_7
    aload 6                                                            ; Loading object
    invokevirtual Tree/GetHas_Left()I
    ifeq else_8
    aload 6                                                            ; Loading object
    invokevirtual Tree/GetLeft()LTree;
    astore 6                                                            ; Storing item into current_node
    goto finally_8
  else_8:
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 4                                                            ; Storing item into cont
    aload 6                                                            ; Loading object
    ldc 1                                                               ; Loading in boolean constant(true)
    invokevirtual Tree/SetHas_Left(I)I
    istore 3                                                            ; Storing item into ntb
    aload 6                                                            ; Loading object
    aload 2                                                         ; Getting new_node's value from local pool
    invokevirtual Tree/SetLeft(LTree;)I
    istore 3                                                            ; Storing item into ntb
  finally_8:
    goto finally_7
  else_7:
    aload 6                                                            ; Loading object
    invokevirtual Tree/GetHas_Right()I
    ifeq else_9
    aload 6                                                            ; Loading object
    invokevirtual Tree/GetRight()LTree;
    astore 6                                                            ; Storing item into current_node
    goto finally_9
  else_9:
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 4                                                            ; Storing item into cont
    aload 6                                                            ; Loading object
    ldc 1                                                               ; Loading in boolean constant(true)
    invokevirtual Tree/SetHas_Right(I)I
    istore 3                                                            ; Storing item into ntb
    aload 6                                                            ; Loading object
    aload 2                                                         ; Getting new_node's value from local pool
    invokevirtual Tree/SetRight(LTree;)I
    istore 3                                                            ; Storing item into ntb
  finally_9:
  finally_7:
    goto finally_5
  else_5:
    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
.end method

;================================
; Delete method
;================================
.method public Delete(I)I
    .limit stack 10
    .limit locals 50

    new Tree                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Tree/<init>()V                                                        ; Calling parent's constructor
    astore 2                                                            ; store the reference to local variable 2
    new Tree                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Tree/<init>()V                                                        ; Calling parent's constructor
    astore 3                                                            ; store the reference to local variable 3
    ldc 0                                                               ; cont is being initialized and set to zero/false
    istore 4                                                            ; Saving variable in locals
    ldc 0                                                               ; found is being initialized and set to zero/false
    istore 5                                                            ; Saving variable in locals
    ldc 0                                                               ; is_root is being initialized and set to zero/false
    istore 6                                                            ; Saving variable in locals
    ldc 0                                                               ; key_aux is being initialized and set to zero/false
    istore 7                                                            ; Saving variable in locals
    ldc 0                                                               ; ntb is being initialized and set to zero/false
    istore 8                                                            ; Saving variable in locals
    aload 0                                                         ; Getting this's value from local pool
    astore 2                                                            ; Storing item into current_node
    aload 0                                                         ; Getting this's value from local pool
    astore 3                                                            ; Storing item into parent_node
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 4                                                            ; Storing item into cont
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 5                                                            ; Storing item into found
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 6                                                            ; Storing item into is_root
finally_10:
    iload 4                                                         ; Getting cont's value from local pool
    ifeq else_10
    aload 2                                                            ; Loading object
    invokevirtual Tree/GetKey()I
    istore 7                                                            ; Storing item into key_aux
    iload 1                                                         ; Getting v_key's value from local pool
    iload 7                                                         ; Getting key_aux's value from local pool
    if_icmpge else_11                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_11
else_11:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_11:
    ifeq else_12
    aload 2                                                            ; Loading object
    invokevirtual Tree/GetHas_Left()I
    ifeq else_13
    aload 2                                                         ; Getting current_node's value from local pool
    astore 3                                                            ; Storing item into parent_node
    aload 2                                                            ; Loading object
    invokevirtual Tree/GetLeft()LTree;
    astore 2                                                            ; Storing item into current_node
    goto finally_13
  else_13:
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 4                                                            ; Storing item into cont
  finally_13:
    goto finally_12
  else_12:
    iload 7                                                         ; Getting key_aux's value from local pool
    iload 1                                                         ; Getting v_key's value from local pool
    if_icmpge else_14                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_14
else_14:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_14:
    ifeq else_15
    aload 2                                                            ; Loading object
    invokevirtual Tree/GetHas_Right()I
    ifeq else_16
    aload 2                                                         ; Getting current_node's value from local pool
    astore 3                                                            ; Storing item into parent_node
    aload 2                                                            ; Loading object
    invokevirtual Tree/GetRight()LTree;
    astore 2                                                            ; Storing item into current_node
    goto finally_16
  else_16:
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 4                                                            ; Storing item into cont
  finally_16:
    goto finally_15
  else_15:
    iload 6                                                         ; Getting is_root's value from local pool
    ifeq else_17
    aload 2                                                            ; Loading object
    invokevirtual Tree/GetHas_Right()I
    ifne else_19                                                     ; Not the boolean expression
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_19
else_19:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_19:
    ifeq else_18                                                         ; Compare the two boolean expression to make sure they are both either true or false
    aload 2                                                            ; Loading object
    invokevirtual Tree/GetHas_Left()I
    ifne else_20                                                     ; Not the boolean expression
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_20
else_20:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_20:
    ifeq else_18                                                         ; Check if the conditional is true or false
    ldc 1                                                           ; Literal true given on successful pass of above conditionals
    goto finally_18
else_18:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_18:
    ifeq else_21
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 8                                                            ; Storing item into ntb
    goto finally_21
  else_21:
    aload 0                                                            ; Loading object
    aload 3                                                         ; Getting parent_node's value from local pool
    aload 2                                                         ; Getting current_node's value from local pool
    invokevirtual Tree/Remove(LTree;LTree;)I
    istore 8                                                            ; Storing item into ntb
  finally_21:
    goto finally_17
  else_17:
    aload 0                                                            ; Loading object
    aload 3                                                         ; Getting parent_node's value from local pool
    aload 2                                                         ; Getting current_node's value from local pool
    invokevirtual Tree/Remove(LTree;LTree;)I
    istore 8                                                            ; Storing item into ntb
  finally_17:
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 5                                                            ; Storing item into found
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 4                                                            ; Storing item into cont
  finally_15:
  finally_12:
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 6                                                            ; Storing item into is_root
    goto finally_10
  else_10:
    iload 5                                                         ; Getting found's value from local pool


    ireturn
.end method

;================================
; Remove method
;================================
.method public Remove(LTree;LTree;)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; ntb is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    ldc 0                                                               ; auxkey1 is being initialized and set to zero/false
    istore 4                                                            ; Saving variable in locals
    ldc 0                                                               ; auxkey2 is being initialized and set to zero/false
    istore 5                                                            ; Saving variable in locals
    aload 2                                                            ; Loading object
    invokevirtual Tree/GetHas_Left()I
    ifeq else_22
    aload 0                                                            ; Loading object
    aload 1                                                         ; Getting p_node's value from local pool
    aload 2                                                         ; Getting c_node's value from local pool
    invokevirtual Tree/RemoveLeft(LTree;LTree;)I
    istore 3                                                            ; Storing item into ntb
    goto finally_22
  else_22:
    aload 2                                                            ; Loading object
    invokevirtual Tree/GetHas_Right()I
    ifeq else_23
    aload 0                                                            ; Loading object
    aload 1                                                         ; Getting p_node's value from local pool
    aload 2                                                         ; Getting c_node's value from local pool
    invokevirtual Tree/RemoveRight(LTree;LTree;)I
    istore 3                                                            ; Storing item into ntb
    goto finally_23
  else_23:
    aload 2                                                            ; Loading object
    invokevirtual Tree/GetKey()I
    istore 4                                                            ; Storing item into auxkey1
    aload 1                                                            ; Loading object
    invokevirtual Tree/GetLeft()LTree;
    invokevirtual Tree/GetKey()I
    istore 5                                                            ; Storing item into auxkey2
    aload 0                                                            ; Loading object
    iload 4                                                         ; Getting auxkey1's value from local pool
    iload 5                                                         ; Getting auxkey2's value from local pool
    invokevirtual Tree/Compare(II)I
    ifeq else_24
    aload 1                                                            ; Loading object
    aload 0
    getfield Tree/my_null LTree;                                                            ; Getting object into field my_null
    invokevirtual Tree/SetLeft(LTree;)I
    istore 3                                                            ; Storing item into ntb
    aload 1                                                            ; Loading object
    ldc 0                                                               ; Loading in boolean constant(false)
    invokevirtual Tree/SetHas_Left(I)I
    istore 3                                                            ; Storing item into ntb
    goto finally_24
  else_24:
    aload 1                                                            ; Loading object
    aload 0
    getfield Tree/my_null LTree;                                                            ; Getting object into field my_null
    invokevirtual Tree/SetRight(LTree;)I
    istore 3                                                            ; Storing item into ntb
    aload 1                                                            ; Loading object
    ldc 0                                                               ; Loading in boolean constant(false)
    invokevirtual Tree/SetHas_Right(I)I
    istore 3                                                            ; Storing item into ntb
  finally_24:
  finally_23:
  finally_22:
    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
.end method

;================================
; RemoveRight method
;================================
.method public RemoveRight(LTree;LTree;)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; ntb is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
finally_25:
    aload 2                                                            ; Loading object
    invokevirtual Tree/GetHas_Right()I
    ifeq else_25
    aload 2                                                            ; Loading object
    aload 2                                                            ; Loading object
    invokevirtual Tree/GetRight()LTree;
    invokevirtual Tree/GetKey()I
    invokevirtual Tree/SetKey(I)I
    istore 3                                                            ; Storing item into ntb
    aload 2                                                         ; Getting c_node's value from local pool
    astore 1                                                            ; Storing item into p_node
    aload 2                                                            ; Loading object
    invokevirtual Tree/GetRight()LTree;
    astore 2                                                            ; Storing item into c_node
    goto finally_25
  else_25:
    aload 1                                                            ; Loading object
    aload 0
    getfield Tree/my_null LTree;                                                            ; Getting object into field my_null
    invokevirtual Tree/SetRight(LTree;)I
    istore 3                                                            ; Storing item into ntb
    aload 1                                                            ; Loading object
    ldc 0                                                               ; Loading in boolean constant(false)
    invokevirtual Tree/SetHas_Right(I)I
    istore 3                                                            ; Storing item into ntb
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
finally_26:
    aload 2                                                            ; Loading object
    invokevirtual Tree/GetHas_Left()I
    ifeq else_26
    aload 2                                                            ; Loading object
    aload 2                                                            ; Loading object
    invokevirtual Tree/GetLeft()LTree;
    invokevirtual Tree/GetKey()I
    invokevirtual Tree/SetKey(I)I
    istore 3                                                            ; Storing item into ntb
    aload 2                                                         ; Getting c_node's value from local pool
    astore 1                                                            ; Storing item into p_node
    aload 2                                                            ; Loading object
    invokevirtual Tree/GetLeft()LTree;
    astore 2                                                            ; Storing item into c_node
    goto finally_26
  else_26:
    aload 1                                                            ; Loading object
    aload 0
    getfield Tree/my_null LTree;                                                            ; Getting object into field my_null
    invokevirtual Tree/SetLeft(LTree;)I
    istore 3                                                            ; Storing item into ntb
    aload 1                                                            ; Loading object
    ldc 0                                                               ; Loading in boolean constant(false)
    invokevirtual Tree/SetHas_Left(I)I
    istore 3                                                            ; Storing item into ntb
    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
.end method

;================================
; Search method
;================================
.method public Search(I)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; cont is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    ldc 0                                                               ; ifound is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    new Tree                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Tree/<init>()V                                                        ; Calling parent's constructor
    astore 4                                                            ; store the reference to local variable 4
    ldc 0                                                               ; key_aux is being initialized and set to zero/false
    istore 5                                                            ; Saving variable in locals
    aload 0                                                         ; Getting this's value from local pool
    astore 4                                                            ; Storing item into current_node
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 2                                                            ; Storing item into cont
    ldc 0                                                               ; Loading int constant
    istore 3                                                            ; Storing item into ifound
finally_27:
    iload 2                                                         ; Getting cont's value from local pool
    ifeq else_27
    aload 4                                                            ; Loading object
    invokevirtual Tree/GetKey()I
    istore 5                                                            ; Storing item into key_aux
    iload 1                                                         ; Getting v_key's value from local pool
    iload 5                                                         ; Getting key_aux's value from local pool
    if_icmpge else_28                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_28
else_28:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_28:
    ifeq else_29
    aload 4                                                            ; Loading object
    invokevirtual Tree/GetHas_Left()I
    ifeq else_30
    aload 4                                                            ; Loading object
    invokevirtual Tree/GetLeft()LTree;
    astore 4                                                            ; Storing item into current_node
    goto finally_30
  else_30:
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 2                                                            ; Storing item into cont
  finally_30:
    goto finally_29
  else_29:
    iload 5                                                         ; Getting key_aux's value from local pool
    iload 1                                                         ; Getting v_key's value from local pool
    if_icmpge else_31                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_31
else_31:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_31:
    ifeq else_32
    aload 4                                                            ; Loading object
    invokevirtual Tree/GetHas_Right()I
    ifeq else_33
    aload 4                                                            ; Loading object
    invokevirtual Tree/GetRight()LTree;
    astore 4                                                            ; Storing item into current_node
    goto finally_33
  else_33:
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 2                                                            ; Storing item into cont
  finally_33:
    goto finally_32
  else_32:
    ldc 1                                                               ; Loading int constant
    istore 3                                                            ; Storing item into ifound
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 2                                                            ; Storing item into cont
  finally_32:
  finally_29:
    goto finally_27
  else_27:
    iload 3                                                         ; Getting ifound's value from local pool


    ireturn
.end method

;================================
; Print method
;================================
.method public Print()I
    .limit stack 10
    .limit locals 50

    new Tree                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Tree/<init>()V                                                        ; Calling parent's constructor
    astore 1                                                            ; store the reference to local variable 1
    ldc 0                                                               ; ntb is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    aload 0                                                         ; Getting this's value from local pool
    astore 1                                                            ; Storing item into current_node
    aload 0                                                            ; Loading object
    aload 1                                                         ; Getting current_node's value from local pool
    invokevirtual Tree/RecPrint(LTree;)I
    istore 2                                                            ; Storing item into ntb
    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
.end method

;================================
; RecPrint method
;================================
.method public RecPrint(LTree;)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; ntb is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    aload 1                                                            ; Loading object
    invokevirtual Tree/GetHas_Left()I
    ifeq else_34
    aload 0                                                            ; Loading object
    aload 1                                                            ; Loading object
    invokevirtual Tree/GetLeft()LTree;
    invokevirtual Tree/RecPrint(LTree;)I
    istore 2                                                            ; Storing item into ntb
    goto finally_34
  else_34:
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 2                                                            ; Storing item into ntb
  finally_34:

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 1                                                            ; Loading object
    invokevirtual Tree/GetKey()I
    invokevirtual java/io/PrintStream/println(I)V
    aload 1                                                            ; Loading object
    invokevirtual Tree/GetHas_Right()I
    ifeq else_35
    aload 0                                                            ; Loading object
    aload 1                                                            ; Loading object
    invokevirtual Tree/GetRight()LTree;
    invokevirtual Tree/RecPrint(LTree;)I
    istore 2                                                            ; Storing item into ntb
    goto finally_35
  else_35:
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 2                                                            ; Storing item into ntb
  finally_35:
    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
.end method



