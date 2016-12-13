.source BBS.j
.class public BBS
.super java/lang/Object

.field public number [I                                                        ; Creating public field for class BBS
.field public size I                                                        ; Creating public field for class BBS
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
    invokevirtual BBS/Init(I)I
    istore 2                                                            ; Storing item into aux01
    aload 0                                                            ; Loading object
    invokevirtual BBS/Print()I
    istore 2                                                            ; Storing item into aux01

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 99999                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V
    aload 0                                                            ; Loading object
    invokevirtual BBS/Sort()I
    istore 2                                                            ; Storing item into aux01
    aload 0                                                            ; Loading object
    invokevirtual BBS/Print()I
    istore 2                                                            ; Storing item into aux01
    ldc 0                                                               ; Loading int constant


    ireturn
.end method

;================================
; Sort method
;================================
.method public Sort()I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; nt is being initialized and set to zero/false
    istore 1                                                            ; Saving variable in locals
    ldc 0                                                               ; i is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    ldc 0                                                               ; aux02 is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    ldc 0                                                               ; aux04 is being initialized and set to zero/false
    istore 4                                                            ; Saving variable in locals
    ldc 0                                                               ; aux05 is being initialized and set to zero/false
    istore 5                                                            ; Saving variable in locals
    ldc 0                                                               ; aux06 is being initialized and set to zero/false
    istore 6                                                            ; Saving variable in locals
    ldc 0                                                               ; aux07 is being initialized and set to zero/false
    istore 7                                                            ; Saving variable in locals
    ldc 0                                                               ; j is being initialized and set to zero/false
    istore 8                                                            ; Saving variable in locals
    ldc 0                                                               ; t is being initialized and set to zero/false
    istore 9                                                            ; Saving variable in locals
    aload 0
    getfield BBS/size I                                                             ; Getting object into field size
    ldc 1                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    istore 2                                                            ; Storing item into i
    ldc 0                                                               ; Loading int constant
    ldc 1                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    istore 3                                                            ; Storing item into aux02
finally_0:
    iload 3                                                         ; Getting aux02's value from local pool
    iload 2                                                         ; Getting i's value from local pool
    if_icmpge else_1                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_1
else_1:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_1:
    ifeq else_0
    ldc 1                                                               ; Loading int constant
    istore 8                                                            ; Storing item into j
finally_2:
    iload 8                                                         ; Getting j's value from local pool
    iload 2                                                         ; Getting i's value from local pool
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    if_icmpge else_3                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_3
else_3:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_3:
    ifeq else_2
    iload 8                                                         ; Getting j's value from local pool
    ldc 1                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    istore 7                                                            ; Storing item into aux07
    aload 0
    getfield BBS/number [I                                                            ; Getting object into field number
    iload 7                                                         ; Getting aux07's value from local pool
    iaload                                                            ; pulling int from array
    istore 4                                                            ; Storing item into aux04
    aload 0
    getfield BBS/number [I                                                            ; Getting object into field number
    iload 8                                                         ; Getting j's value from local pool
    iaload                                                            ; pulling int from array
    istore 5                                                            ; Storing item into aux05
    iload 5                                                         ; Getting aux05's value from local pool
    iload 4                                                         ; Getting aux04's value from local pool
    if_icmpge else_4                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_4
else_4:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_4:
    ifeq else_5
    iload 8                                                         ; Getting j's value from local pool
    ldc 1                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    istore 6                                                            ; Storing item into aux06
    aload 0
    getfield BBS/number [I                                                            ; Getting object into field number
    iload 6                                                         ; Getting aux06's value from local pool
    iaload                                                            ; pulling int from array
    istore 9                                                            ; Storing item into t
    aload 0
    getfield BBS/number [I                                                            ; Getting object into field number
    iload 6                                                            ; Getting 'aux06' from the local pool
    aload 0
    getfield BBS/number [I                                                            ; Getting object into field number
    iload 8                                                         ; Getting j's value from local pool
    iaload                                                            ; pulling int from array
    iastore                                                            ; storing above variable
    aload 0
    getfield BBS/number [I                                                            ; Getting object into field number
    iload 8                                                            ; Getting 'j' from the local pool
    iload 9                                                         ; Getting t's value from local pool
    iastore                                                            ; storing above variable
    goto finally_5
  else_5:
    ldc 0                                                               ; Loading int constant
    istore 1                                                            ; Storing item into nt
  finally_5:
    iload 8                                                         ; Getting j's value from local pool
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 8                                                            ; Storing item into j
    goto finally_2
  else_2:
    iload 2                                                         ; Getting i's value from local pool
    ldc 1                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    istore 2                                                            ; Storing item into i
    goto finally_0
  else_0:
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
finally_6:
    iload 1                                                         ; Getting j's value from local pool
    aload 0
    getfield BBS/size I                                                             ; Getting object into field size
    if_icmpge else_7                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_7
else_7:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_7:
    ifeq else_6

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 0
    getfield BBS/number [I                                                            ; Getting object into field number
    iload 1                                                         ; Getting j's value from local pool
    iaload                                                            ; pulling int from array
    invokevirtual java/io/PrintStream/println(I)V
    iload 1                                                         ; Getting j's value from local pool
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 1                                                            ; Storing item into j
    goto finally_6
  else_6:
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
    putfield BBS/size I                                                             ; Storing object into field size
    aload_0                                                            ; Getting object reference
    iload 1                                                         ; Getting sz's value from local pool
    newarray int                                                        ; initializing int array
    putfield BBS/number [I                                                            ; Storing object into field number
    aload 0
    getfield BBS/number [I                                                            ; Getting object into field number
    ldc 0                                                               ; Loading int constant
    ldc 20                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    aload 0
    getfield BBS/number [I                                                            ; Getting object into field number
    ldc 1                                                               ; Loading int constant
    ldc 7                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    aload 0
    getfield BBS/number [I                                                            ; Getting object into field number
    ldc 2                                                               ; Loading int constant
    ldc 12                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    aload 0
    getfield BBS/number [I                                                            ; Getting object into field number
    ldc 3                                                               ; Loading int constant
    ldc 18                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    aload 0
    getfield BBS/number [I                                                            ; Getting object into field number
    ldc 4                                                               ; Loading int constant
    ldc 2                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    aload 0
    getfield BBS/number [I                                                            ; Getting object into field number
    ldc 5                                                               ; Loading int constant
    ldc 11                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    aload 0
    getfield BBS/number [I                                                            ; Getting object into field number
    ldc 6                                                               ; Loading int constant
    ldc 6                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    aload 0
    getfield BBS/number [I                                                            ; Getting object into field number
    ldc 7                                                               ; Loading int constant
    ldc 9                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    aload 0
    getfield BBS/number [I                                                            ; Getting object into field number
    ldc 8                                                               ; Loading int constant
    ldc 19                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    aload 0
    getfield BBS/number [I                                                            ; Getting object into field number
    ldc 9                                                               ; Loading int constant
    ldc 5                                                               ; Loading int constant
    iastore                                                            ; storing above variable
    ldc 0                                                               ; Loading int constant


    ireturn
.end method



