.source BS.j
.class public BS
.super java/lang/Object

.field public number [I                                                        ; Creating public field for class BS
.field public size I                                                        ; Creating public field for class BS
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
.method public Start(I)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; aux01 is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    ldc 0                                                               ; aux02 is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    aload 0                                                            ; Loading object
    iload 1                                                         ; Getting sz's value from local pool
    invokevirtual BS/Init(I)I
    istore 2                                                            ; Storing item into aux01
    aload 0                                                            ; Loading object
    invokevirtual BS/Print()I
    istore 3                                                            ; Storing item into aux02
    aload 0                                                            ; Loading object
    ldc 8                                                               ; Loading int constant
    invokevirtual BS/Search(I)I
    ifeq else_0

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 1                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
    goto finally_0
  else_0:

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 0                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
  finally_0:
    aload 0                                                            ; Loading object
    ldc 19                                                               ; Loading int constant
    invokevirtual BS/Search(I)I
    ifeq else_1

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 1                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
    goto finally_1
  else_1:

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 0                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
  finally_1:
    aload 0                                                            ; Loading object
    ldc 20                                                               ; Loading int constant
    invokevirtual BS/Search(I)I
    ifeq else_2

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 1                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
    goto finally_2
  else_2:

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 0                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
  finally_2:
    aload 0                                                            ; Loading object
    ldc 21                                                               ; Loading int constant
    invokevirtual BS/Search(I)I
    ifeq else_3

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 1                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
    goto finally_3
  else_3:

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 0                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
  finally_3:
    aload 0                                                            ; Loading object
    ldc 37                                                               ; Loading int constant
    invokevirtual BS/Search(I)I
    ifeq else_4

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 1                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
    goto finally_4
  else_4:

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 0                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
  finally_4:
    aload 0                                                            ; Loading object
    ldc 38                                                               ; Loading int constant
    invokevirtual BS/Search(I)I
    ifeq else_5

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 1                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
    goto finally_5
  else_5:

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 0                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
  finally_5:
    aload 0                                                            ; Loading object
    ldc 39                                                               ; Loading int constant
    invokevirtual BS/Search(I)I
    ifeq else_6

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 1                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
    goto finally_6
  else_6:

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 0                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
  finally_6:
    aload 0                                                            ; Loading object
    ldc 50                                                               ; Loading int constant
    invokevirtual BS/Search(I)I
    ifeq else_7

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 1                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
    goto finally_7
  else_7:

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 0                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
  finally_7:
    ldc 999                                                               ; Loading int constant


    ireturn
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
    iload 1                                                         ; Getting num's value from local pool
    newarray int                                                        ; initializing int array
    putfield BS/number [I                                                            ; Storing object into field number
    ldc 0                                                               ; Loading int constant
    istore 7                                                            ; Storing item into aux01
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 2                                                            ; Storing item into bs01
    aload 0
    getfield BS/number [I                                                            ; Getting object into field number
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
finally_8:
    iload 5                                                         ; Getting var_cont's value from local pool
    ifeq else_8
    iload 4                                                         ; Getting left's value from local pool
    iload 3                                                         ; Getting right's value from local pool
    iadd                                                            ; Adding top elements on stack
    istore 6                                                            ; Storing item into medium
    aload 0                                                            ; Loading object
    iload 6                                                         ; Getting medium's value from local pool
    invokevirtual BS/Div(I)I
    istore 6                                                            ; Storing item into medium
    aload 0
    getfield BS/number [I                                                            ; Getting object into field number
    iload 6                                                         ; Getting medium's value from local pool
    iaload                                                            ; pulling int from array
    istore 7                                                            ; Storing item into aux01
    iload 1                                                         ; Getting num's value from local pool
    iload 7                                                         ; Getting aux01's value from local pool
    if_icmpge else_9                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_9
else_9:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_9:
    ifeq else_10
    iload 6                                                         ; Getting medium's value from local pool
    ldc 1                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    istore 3                                                            ; Storing item into right
    goto finally_10
  else_10:
    iload 6                                                         ; Getting medium's value from local pool
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 4                                                            ; Storing item into left
  finally_10:
    aload 0                                                            ; Loading object
    iload 7                                                         ; Getting aux01's value from local pool
    iload 1                                                         ; Getting num's value from local pool
    invokevirtual BS/Compare(II)I
    ifeq else_11
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 5                                                            ; Storing item into var_cont
    goto finally_11
  else_11:
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 5                                                            ; Storing item into var_cont
  finally_11:
    iload 3                                                         ; Getting right's value from local pool
    iload 4                                                         ; Getting left's value from local pool
    if_icmpge else_12                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_12
else_12:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_12:
    ifeq else_13
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 5                                                            ; Storing item into var_cont
    goto finally_13
  else_13:
    ldc 0                                                               ; Loading int constant
    istore 8                                                            ; Storing item into nt
  finally_13:
    goto finally_8
  else_8:
    aload 0                                                            ; Loading object
    iload 7                                                         ; Getting aux01's value from local pool
    iload 1                                                         ; Getting num's value from local pool
    invokevirtual BS/Compare(II)I
    ifeq else_14
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 2                                                            ; Storing item into bs01
    goto finally_14
  else_14:
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 2                                                            ; Storing item into bs01
  finally_14:
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
finally_15:
    iload 3                                                         ; Getting count02's value from local pool
    iload 4                                                         ; Getting aux03's value from local pool
    if_icmpge else_16                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_16
else_16:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_16:
    ifeq else_15
    iload 2                                                         ; Getting count01's value from local pool
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 2                                                            ; Storing item into count01
    iload 3                                                         ; Getting count02's value from local pool
    ldc 2                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 3                                                            ; Storing item into count02
    goto finally_15
  else_15:
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
    if_icmpge else_17                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_17
else_17:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_17:
    ifeq else_18
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 3                                                            ; Storing item into retval
    goto finally_18
  else_18:
    iload 1                                                         ; Getting num1's value from local pool
    iload 4                                                         ; Getting aux02's value from local pool
    if_icmpge else_20                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_20
else_20:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_20:
    ifne else_19                                                     ; Not the boolean expression
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_19
else_19:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_19:
    ifeq else_21
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 3                                                            ; Storing item into retval
    goto finally_21
  else_21:
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 3                                                            ; Storing item into retval
  finally_21:
  finally_18:
    iload 3                                                         ; Getting retval's value from local pool


    ireturn
.end method

;================================
; Print method
;================================
.method public Print()I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; j is being initialized and set to zero/false
    istore 1                                                            ; Saving variable in locals
    ldc 1                                                               ; Loading int constant
    istore 1                                                            ; Storing item into j
finally_22:
    iload 1                                                         ; Getting j's value from local pool
    aload 0
    getfield BS/size I                                                             ; Getting object into field size
    if_icmpge else_23                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_23
else_23:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_23:
    ifeq else_22

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 0
    getfield BS/number [I                                                            ; Getting object into field number
    iload 1                                                         ; Getting j's value from local pool
    iaload                                                            ; pulling int from array
    invokevirtual java/io/PrintStream/println(I)V
    iload 1                                                         ; Getting j's value from local pool
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 1                                                            ; Storing item into j
    goto finally_22
  else_22:

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 99999                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
    ldc 0                                                               ; Loading int constant


    ireturn
.end method

;================================
; Init method
;================================
.method public Init(I)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; j is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    ldc 0                                                               ; k is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    ldc 0                                                               ; aux02 is being initialized and set to zero/false
    istore 4                                                            ; Saving variable in locals
    ldc 0                                                               ; aux01 is being initialized and set to zero/false
    istore 5                                                            ; Saving variable in locals
    aload_0                                                            ; Getting object reference
    iload 1                                                         ; Getting sz's value from local pool
    putfield BS/size I                                                             ; Storing object into field size
    aload_0                                                            ; Getting object reference
    iload 1                                                         ; Getting sz's value from local pool
    newarray int                                                        ; initializing int array
    putfield BS/number [I                                                            ; Storing object into field number
    ldc 1                                                               ; Loading int constant
    istore 2                                                            ; Storing item into j
    ldc 1                                                               ; Loading int constant
    istore 3                                                            ; Storing item into k
    aload 0
    getfield BS/size I                                                             ; Getting object into field size
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 3                                                            ; Storing item into k
finally_24:
    iload 2                                                         ; Getting j's value from local pool
    aload 0
    getfield BS/size I                                                             ; Getting object into field size
    if_icmpge else_25                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_25
else_25:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_25:
    ifeq else_24
    ldc 2                                                               ; Loading int constant
    iload 2                                                         ; Getting j's value from local pool
    imul                                                            ; Multiplying top elements on stack
    istore 5                                                            ; Storing item into aux01
    iload 3                                                         ; Getting k's value from local pool
    ldc 3                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    istore 4                                                            ; Storing item into aux02
    aload 0
    getfield BS/number [I                                                            ; Getting object into field number
    iload 2                                                            ; Getting 'j' from the local pool
    iload 5                                                         ; Getting aux01's value from local pool
    iload 4                                                         ; Getting aux02's value from local pool
    iadd                                                            ; Adding top elements on stack
    iastore                                                            ; storing above variable
    iload 2                                                         ; Getting j's value from local pool
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 2                                                            ; Storing item into j
    iload 3                                                         ; Getting k's value from local pool
    ldc 1                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    istore 3                                                            ; Storing item into k
    goto finally_24
  else_24:
    ldc 0                                                               ; Loading int constant


    ireturn
.end method



