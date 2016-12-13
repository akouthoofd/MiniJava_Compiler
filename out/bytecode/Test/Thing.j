.source Thing.j
.class public Thing
.super java/lang/Object

.field public number [I                                                        ; Creating public field for class Thing
.field public size I                                                        ; Creating public field for class Thing
.field public s I                                                        ; Creating public field for class Thing
;================================
; default constructor
;================================
.method public <init>()V
    aload_0
    invokespecial java/lang/Object/<init>()V
    return
.end method

;================================
; Search method
;================================
.method public Search(I)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; bs01 is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    ldc 0                                                               ; right is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    ldc 0                                                               ; left is being initialized and set to zero/false
    istore 4                                                            ; Saving variable in locals
    ldc 0                                                               ; var_cont is being initialized and set to zero/false
    istore 5                                                            ; Saving variable in locals
    ldc 0                                                               ; medium is being initialized and set to zero/false
    istore 6                                                            ; Saving variable in locals
    ldc 0                                                               ; aux01 is being initialized and set to zero/false
    istore 7                                                            ; Saving variable in locals
    ldc 0                                                               ; nt is being initialized and set to zero/false
    istore 8                                                            ; Saving variable in locals
    aload_0                                                            ; Getting object reference
    ldc 20                                                               ; Loading int constant
    newarray int                                                        ; initializing int array
    putfield Thing/number [I                                                            ; Storing object into field number
    aload 0
    getfield Thing/number [I                                                            ; Getting object into field number
    ldc 4                                                               ; Loading int constant
    ldc 15                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    ldc 0                                                               ; Loading int constant
    istore 7                                                            ; Storing item into aux01
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 2                                                            ; Storing item into bs01
    aload 0
    getfield Thing/number [I                                                            ; Getting object into field number
    arraylength                                                            ; getting length of loaded array
    istore 3                                                            ; Storing item into right
    iload 3                                                         ; Getting right's value from local pool
    ldc 1                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    istore 3                                                            ; Storing item into right
    ldc 0                                                               ; Loading int constant
    istore 4                                                            ; Storing item into left
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 5                                                            ; Storing item into var_cont
finally_0:
    iload 5                                                         ; Getting var_cont's value from local pool
    ifeq else_0
    iload 4                                                         ; Getting left's value from local pool
    iload 3                                                         ; Getting right's value from local pool
    iadd                                                            ; Adding top elements on stack
    istore 6                                                            ; Storing item into medium
    aload 0                                                            ; Loading object
    iload 6                                                         ; Getting medium's value from local pool
    invokevirtual Thing/Div(I)I
    istore 6                                                            ; Storing item into medium
    aload 0
    getfield Thing/number [I                                                            ; Getting object into field number
    iload 6                                                         ; Getting medium's value from local pool
    iaload                                                            ; pulling int from array
    istore 7                                                            ; Storing item into aux01
    iload 1                                                         ; Getting num's value from local pool
    iload 7                                                         ; Getting aux01's value from local pool
    if_icmpge else_1                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_1
else_1:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_1:
    ifeq else_2
    iload 6                                                         ; Getting medium's value from local pool
    ldc 1                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    istore 3                                                            ; Storing item into right
    goto finally_2
  else_2:
    iload 6                                                         ; Getting medium's value from local pool
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 4                                                            ; Storing item into left
  finally_2:
    aload 0                                                            ; Loading object
    iload 7                                                         ; Getting aux01's value from local pool
    iload 1                                                         ; Getting num's value from local pool
    invokevirtual Thing/Compare(II)I
    ifeq else_3
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 5                                                            ; Storing item into var_cont
    goto finally_3
  else_3:
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 5                                                            ; Storing item into var_cont
  finally_3:
    iload 3                                                         ; Getting right's value from local pool
    iload 4                                                         ; Getting left's value from local pool
    if_icmpge else_4                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_4
else_4:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_4:
    ifeq else_5
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 5                                                            ; Storing item into var_cont
    goto finally_5
  else_5:
    ldc 0                                                               ; Loading int constant
    istore 8                                                            ; Storing item into nt
  finally_5:
    goto finally_0
  else_0:
    aload 0                                                            ; Loading object
    iload 7                                                         ; Getting aux01's value from local pool
    iload 1                                                         ; Getting num's value from local pool
    invokevirtual Thing/Compare(II)I
    ifeq else_6
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 2                                                            ; Storing item into bs01
    goto finally_6
  else_6:
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 2                                                            ; Storing item into bs01
  finally_6:
    iload 2                                                         ; Getting bs01's value from local pool


    ireturn
.end method

;================================
; Div method
;================================
.method public Div(I)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; count01 is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    ldc 0                                                               ; count02 is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    ldc 0                                                               ; aux03 is being initialized and set to zero/false
    istore 4                                                            ; Saving variable in locals
    ldc 0                                                               ; Loading int constant
    istore 2                                                            ; Storing item into count01
    ldc 0                                                               ; Loading int constant
    istore 3                                                            ; Storing item into count02
    iload 1                                                         ; Getting num's value from local pool
    ldc 1                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    istore 4                                                            ; Storing item into aux03
finally_7:
    iload 3                                                         ; Getting count02's value from local pool
    iload 4                                                         ; Getting aux03's value from local pool
    if_icmpge else_8                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_8
else_8:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_8:
    ifeq else_7
    iload 2                                                         ; Getting count01's value from local pool
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 2                                                            ; Storing item into count01
    iload 3                                                         ; Getting count02's value from local pool
    ldc 2                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 3                                                            ; Storing item into count02
    goto finally_7
  else_7:
    iload 2                                                         ; Getting count01's value from local pool


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
    if_icmpge else_9                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_9
else_9:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_9:
    ifeq else_10
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 3                                                            ; Storing item into retval
    goto finally_10
  else_10:
    iload 1                                                         ; Getting num1's value from local pool
    iload 4                                                         ; Getting aux02's value from local pool
    if_icmpge else_12                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_12
else_12:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_12:
    ifne else_11                                                     ; Not the boolean expression
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_11
else_11:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_11:
    ifeq else_13
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 3                                                            ; Storing item into retval
    goto finally_13
  else_13:
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 3                                                            ; Storing item into retval
  finally_13:
  finally_10:
    iload 3                                                         ; Getting retval's value from local pool


    ireturn
.end method

;================================
; init method
;================================
.method public init(I)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; temp is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    new Some                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Some/<init>()V                                                        ; Calling parent's constructor
    astore 3                                                            ; store the reference to local variable 3
    new Some                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Some/<init>()V                                                        ; Calling parent's constructor
    astore 3                                                            ; Storing object into some
    aload 0                                                            ; Loading object
    iload 1                                                         ; Getting s's value from local pool
    invokevirtual Thing/doStuff(I)I
    istore 2                                                            ; Storing item into temp
    ldc 0                                                               ; Loading int constant


    ireturn
.end method

;================================
; doStuff method
;================================
.method public doStuff(I)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; a is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    ldc 1                                                               ; Loading int constant
    istore 2                                                            ; Storing item into a
finally_14:
    iload 2                                                         ; Getting a's value from local pool
    aload 0
    getfield Thing/size I                                                             ; Getting object into field size
    if_icmpge else_15                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_15
else_15:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_15:
    ifeq else_14
    iload 2                                                         ; Getting a's value from local pool
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 2                                                            ; Storing item into a
    goto finally_14
  else_14:
    aload 0
    getfield Thing/size I                                                             ; Getting object into field size
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 2                                                            ; Storing item into a
    aload_0                                                            ; Getting object reference
    iload 1                                                         ; Getting s's value from local pool
    putfield Thing/size I                                                             ; Storing object into field size
    aload_0                                                            ; Getting object reference
    aload 0
    getfield Thing/size I                                                             ; Getting object into field size
    newarray int                                                        ; initializing int array
    putfield Thing/number [I                                                            ; Storing object into field number

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 0
    getfield Thing/size I                                                             ; Getting object into field size
    invokevirtual java/io/PrintStream/println(I)V
    ldc 1                                                               ; Loading int constant


    ireturn
.end method

;================================
; doStuff2 method
;================================
.method public doStuff2()I
    .limit stack 10
    .limit locals 50

    aload_0                                                            ; Getting object reference
    ldc 5                                                               ; Loading int constant
    putfield Thing/s I                                                             ; Storing object into field s
    ldc 1                                                               ; Loading int constant


    ireturn
.end method

;================================
; more method
;================================
.method public more()I
    .limit stack 10
    .limit locals 50

    aload 0
    getfield Thing/s I                                                             ; Getting object into field s


    ireturn
.end method



