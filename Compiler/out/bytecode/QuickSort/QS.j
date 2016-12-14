.source QS.j
.class public QS
.super java/lang/Object

.field public number [I                                                        ; Creating public field for class QS
.field public size I                                                        ; Creating public field for class QS
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
    aload 0                                                            ; Loading object
    iload 1                                                         ; Getting sz's value from local pool
    invokevirtual QS/Init(I)I
    istore 2                                                            ; Storing item into aux01
    aload 0                                                            ; Loading object
    invokevirtual QS/Print()I
    istore 2                                                            ; Storing item into aux01

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 9999                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
    aload 0
    getfield QS/size I                                                             ; Getting object into field size
    ldc 1                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    istore 2                                                            ; Storing item into aux01
    aload 0                                                            ; Loading object
    ldc 0                                                               ; Loading int constant
    iload 2                                                         ; Getting aux01's value from local pool
    invokevirtual QS/Sort(II)I
    istore 2                                                            ; Storing item into aux01
    aload 0                                                            ; Loading object
    invokevirtual QS/Print()I
    istore 2                                                            ; Storing item into aux01
    ldc 0                                                               ; Loading int constant


    ireturn
.end method

;================================
; Sort method
;================================
.method public Sort(II)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; v is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    ldc 0                                                               ; i is being initialized and set to zero/false
    istore 4                                                            ; Saving variable in locals
    ldc 0                                                               ; j is being initialized and set to zero/false
    istore 5                                                            ; Saving variable in locals
    ldc 0                                                               ; nt is being initialized and set to zero/false
    istore 6                                                            ; Saving variable in locals
    ldc 0                                                               ; t is being initialized and set to zero/false
    istore 7                                                            ; Saving variable in locals
    ldc 0                                                               ; cont01 is being initialized and set to zero/false
    istore 8                                                            ; Saving variable in locals
    ldc 0                                                               ; cont02 is being initialized and set to zero/false
    istore 9                                                            ; Saving variable in locals
    ldc 0                                                               ; aux03 is being initialized and set to zero/false
    istore 10                                                            ; Saving variable in locals
    ldc 0                                                               ; Loading int constant
    istore 7                                                            ; Storing item into t
    iload 1                                                         ; Getting left's value from local pool
    iload 2                                                         ; Getting right's value from local pool
    if_icmpge else_0                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_0
else_0:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_0:
    ifeq else_1
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    iload 2                                                         ; Getting right's value from local pool
    iaload                                                            ; pulling int from array
    istore 3                                                            ; Storing item into v
    iload 1                                                         ; Getting left's value from local pool
    ldc 1                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    istore 4                                                            ; Storing item into i
    iload 2                                                         ; Getting right's value from local pool
    istore 5                                                            ; Storing item into j
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 8                                                            ; Storing item into cont01
finally_2:
    iload 8                                                         ; Getting cont01's value from local pool
    ifeq else_2
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 9                                                            ; Storing item into cont02
finally_3:
    iload 9                                                         ; Getting cont02's value from local pool
    ifeq else_3
    iload 4                                                         ; Getting i's value from local pool
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 4                                                            ; Storing item into i
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    iload 4                                                         ; Getting i's value from local pool
    iaload                                                            ; pulling int from array
    istore 10                                                            ; Storing item into aux03
    iload 10                                                         ; Getting aux03's value from local pool
    iload 3                                                         ; Getting v's value from local pool
    if_icmpge else_5                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_5
else_5:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_5:
    ifne else_4                                                     ; Not the boolean expression
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_4
else_4:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_4:
    ifeq else_6
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 9                                                            ; Storing item into cont02
    goto finally_6
  else_6:
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 9                                                            ; Storing item into cont02
  finally_6:
    goto finally_3
  else_3:
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 9                                                            ; Storing item into cont02
finally_7:
    iload 9                                                         ; Getting cont02's value from local pool
    ifeq else_7
    iload 5                                                         ; Getting j's value from local pool
    ldc 1                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    istore 5                                                            ; Storing item into j
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    iload 5                                                         ; Getting j's value from local pool
    iaload                                                            ; pulling int from array
    istore 10                                                            ; Storing item into aux03
    iload 3                                                         ; Getting v's value from local pool
    iload 10                                                         ; Getting aux03's value from local pool
    if_icmpge else_9                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_9
else_9:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_9:
    ifne else_8                                                     ; Not the boolean expression
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_8
else_8:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_8:
    ifeq else_10
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 9                                                            ; Storing item into cont02
    goto finally_10
  else_10:
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 9                                                            ; Storing item into cont02
  finally_10:
    goto finally_7
  else_7:
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    iload 4                                                         ; Getting i's value from local pool
    iaload                                                            ; pulling int from array
    istore 7                                                            ; Storing item into t
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    iload 4                                                            ; Getting 'i' from the local pool
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    iload 5                                                         ; Getting j's value from local pool
    iaload                                                            ; pulling int from array
    iastore                                                            ; storing above variable
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    iload 5                                                            ; Getting 'j' from the local pool
    iload 7                                                         ; Getting t's value from local pool
    iastore                                                            ; storing above variable
    iload 5                                                         ; Getting j's value from local pool
    iload 4                                                         ; Getting i's value from local pool
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    if_icmpge else_11                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_11
else_11:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_11:
    ifeq else_12
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 8                                                            ; Storing item into cont01
    goto finally_12
  else_12:
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 8                                                            ; Storing item into cont01
  finally_12:
    goto finally_2
  else_2:
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    iload 5                                                            ; Getting 'j' from the local pool
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    iload 4                                                         ; Getting i's value from local pool
    iaload                                                            ; pulling int from array
    iastore                                                            ; storing above variable
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    iload 4                                                            ; Getting 'i' from the local pool
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    iload 2                                                         ; Getting right's value from local pool
    iaload                                                            ; pulling int from array
    iastore                                                            ; storing above variable
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    iload 2                                                            ; Getting 'right' from the local pool
    iload 7                                                         ; Getting t's value from local pool
    iastore                                                            ; storing above variable
    aload 0                                                            ; Loading object
    iload 1                                                         ; Getting left's value from local pool
    iload 4                                                         ; Getting i's value from local pool
    ldc 1                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    invokevirtual QS/Sort(II)I
    istore 6                                                            ; Storing item into nt
    aload 0                                                            ; Loading object
    iload 4                                                         ; Getting i's value from local pool
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    iload 2                                                         ; Getting right's value from local pool
    invokevirtual QS/Sort(II)I
    istore 6                                                            ; Storing item into nt
    goto finally_1
  else_1:
    ldc 0                                                               ; Loading int constant
    istore 6                                                            ; Storing item into nt
  finally_1:
    ldc 0                                                               ; Loading int constant


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
    ldc 0                                                               ; Loading int constant
    istore 1                                                            ; Storing item into j
finally_13:
    iload 1                                                         ; Getting j's value from local pool
    aload 0
    getfield QS/size I                                                             ; Getting object into field size
    if_icmpge else_14                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_14
else_14:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_14:
    ifeq else_13

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    iload 1                                                         ; Getting j's value from local pool
    iaload                                                            ; pulling int from array
    invokevirtual java/io/PrintStream/println(I)V
    iload 1                                                         ; Getting j's value from local pool
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 1                                                            ; Storing item into j
    goto finally_13
  else_13:
    ldc 0                                                               ; Loading int constant


    ireturn
.end method

;================================
; Init method
;================================
.method public Init(I)I
    .limit stack 10
    .limit locals 50

    aload_0                                                            ; Getting object reference
    iload 1                                                         ; Getting sz's value from local pool
    putfield QS/size I                                                             ; Storing object into field size
    aload_0                                                            ; Getting object reference
    iload 1                                                         ; Getting sz's value from local pool
    newarray int                                                        ; initializing int array
    putfield QS/number [I                                                            ; Storing object into field number
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    ldc 0                                                               ; Loading int constant
    ldc 20                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    ldc 1                                                               ; Loading int constant
    ldc 7                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    ldc 2                                                               ; Loading int constant
    ldc 12                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    ldc 3                                                               ; Loading int constant
    ldc 18                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    ldc 4                                                               ; Loading int constant
    ldc 2                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    ldc 5                                                               ; Loading int constant
    ldc 11                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    ldc 6                                                               ; Loading int constant
    ldc 6                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    ldc 7                                                               ; Loading int constant
    ldc 9                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    ldc 8                                                               ; Loading int constant
    ldc 19                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    aload 0
    getfield QS/number [I                                                            ; Getting object into field number
    ldc 9                                                               ; Loading int constant
    ldc 5                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    ldc 0                                                               ; Loading int constant


    ireturn
.end method



