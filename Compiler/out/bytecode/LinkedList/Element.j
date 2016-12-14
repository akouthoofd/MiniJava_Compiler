.source Element.j
.class public Element
.super java/lang/Object

.field public Age I                                                        ; Creating public field for class Element
.field public Salary I                                                        ; Creating public field for class Element
.field public Married I                                                        ; Creating public field for class Element
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
.method public Init(III)I
    .limit stack 10
    .limit locals 50

    aload_0                                                            ; Getting object reference
    iload 1                                                         ; Getting v_Age's value from local pool
    putfield Element/Age I                                                             ; Storing object into field Age
    aload_0                                                            ; Getting object reference
    iload 2                                                         ; Getting v_Salary's value from local pool
    putfield Element/Salary I                                                             ; Storing object into field Salary
    aload_0                                                            ; Getting object reference
    iload 3                                                         ; Getting v_Married's value from local pool
    putfield Element/Married I                                                             ; Storing object into field Married
    ldc 1                                                               ; Loading in boolean constant(true)


    ireturn
.end method

;================================
; GetAge method
;================================
.method public GetAge()I
    .limit stack 10
    .limit locals 50

    aload 0
    getfield Element/Age I                                                             ; Getting object into field Age


    ireturn
.end method

;================================
; GetSalary method
;================================
.method public GetSalary()I
    .limit stack 10
    .limit locals 50

    aload 0
    getfield Element/Salary I                                                             ; Getting object into field Salary


    ireturn
.end method

;================================
; GetMarried method
;================================
.method public GetMarried()I
    .limit stack 10
    .limit locals 50

    aload 0
    getfield Element/Married I                                                             ; Getting object into field Married


    ireturn
.end method

;================================
; Equal method
;================================
.method public Equal(LElement;)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; ret_val is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    ldc 0                                                               ; aux01 is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    ldc 0                                                               ; aux02 is being initialized and set to zero/false
    istore 4                                                            ; Saving variable in locals
    ldc 0                                                               ; nt is being initialized and set to zero/false
    istore 5                                                            ; Saving variable in locals
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 2                                                            ; Storing item into ret_val
    aload 1                                                            ; Loading object
    invokevirtual Element/GetAge()I
    istore 3                                                            ; Storing item into aux01
    aload 0                                                            ; Loading object
    iload 3                                                         ; Getting aux01's value from local pool
    aload 0
    getfield Element/Age I                                                             ; Getting object into field Age
    invokevirtual Element/Compare(II)I
    ifne else_0                                                     ; Not the boolean expression
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_0
else_0:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_0:
    ifeq else_1
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 2                                                            ; Storing item into ret_val
    goto finally_1
  else_1:
    aload 1                                                            ; Loading object
    invokevirtual Element/GetSalary()I
    istore 4                                                            ; Storing item into aux02
    aload 0                                                            ; Loading object
    iload 4                                                         ; Getting aux02's value from local pool
    aload 0
    getfield Element/Salary I                                                             ; Getting object into field Salary
    invokevirtual Element/Compare(II)I
    ifne else_2                                                     ; Not the boolean expression
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_2
else_2:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_2:
    ifeq else_3
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 2                                                            ; Storing item into ret_val
    goto finally_3
  else_3:
    aload 0
    getfield Element/Married I                                                             ; Getting object into field Married
    ifeq else_4
    aload 1                                                            ; Loading object
    invokevirtual Element/GetMarried()I
    ifne else_5                                                     ; Not the boolean expression
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_5
else_5:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_5:
    ifeq else_6
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 2                                                            ; Storing item into ret_val
    goto finally_6
  else_6:
    ldc 0                                                               ; Loading int constant
    istore 5                                                            ; Storing item into nt
  finally_6:
    goto finally_4
  else_4:
    aload 1                                                            ; Loading object
    invokevirtual Element/GetMarried()I
    ifeq else_7
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 2                                                            ; Storing item into ret_val
    goto finally_7
  else_7:
    ldc 0                                                               ; Loading int constant
    istore 5                                                            ; Storing item into nt
  finally_7:
  finally_4:
  finally_3:
  finally_1:
    iload 2                                                         ; Getting ret_val's value from local pool


    ireturn
.end method

;================================
; Compare method
;================================
.method public Compare(II)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; retval is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    ldc 0                                                               ; aux02 is being initialized and set to zero/false
    istore 4                                                            ; Saving variable in locals
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 3                                                            ; Storing item into retval
    iload 2                                                         ; Getting num2's value from local pool
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 4                                                            ; Storing item into aux02
    iload 1                                                         ; Getting num1's value from local pool
    iload 2                                                         ; Getting num2's value from local pool
    if_icmpge else_8                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_8
else_8:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_8:
    ifeq else_9
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 3                                                            ; Storing item into retval
    goto finally_9
  else_9:
    iload 1                                                         ; Getting num1's value from local pool
    iload 4                                                         ; Getting aux02's value from local pool
    if_icmpge else_11                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_11
else_11:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_11:
    ifne else_10                                                     ; Not the boolean expression
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_10
else_10:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_10:
    ifeq else_12
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 3                                                            ; Storing item into retval
    goto finally_12
  else_12:
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 3                                                            ; Storing item into retval
  finally_12:
  finally_9:
    iload 3                                                         ; Getting retval's value from local pool


    ireturn
.end method



