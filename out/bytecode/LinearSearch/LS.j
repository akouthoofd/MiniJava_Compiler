.source LS.j
.class public LS
.super java/lang/Object

.field public number [I                                                        ; Creating public field for class LS
.field public size I                                                        ; Creating public field for class LS
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
    invokevirtual LS/Init(I)I
    istore 2                                                            ; Storing item into aux01
    aload 0                                                            ; Loading object
    invokevirtual LS/Print()I
    istore 3                                                            ; Storing item into aux02

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 9999                                                               ; Loading int constant
    invokevirtual java/io/PrintStream/println(I)V

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 0                                                            ; Loading object
    ldc 8                                                               ; Loading int constant
    invokevirtual LS/Search(I)I
    invokevirtual java/io/PrintStream/println(I)V

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 0                                                            ; Loading object
    ldc 12                                                               ; Loading int constant
    invokevirtual LS/Search(I)I
    invokevirtual java/io/PrintStream/println(I)V

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 0                                                            ; Loading object
    ldc 17                                                               ; Loading int constant
    invokevirtual LS/Search(I)I
    invokevirtual java/io/PrintStream/println(I)V

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 0                                                            ; Loading object
    ldc 50                                                               ; Loading int constant
    invokevirtual LS/Search(I)I
    invokevirtual java/io/PrintStream/println(I)V
    ldc 55                                                               ; Loading int constant


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
finally_0:
    iload 1                                                         ; Getting j's value from local pool
    aload 0
    getfield LS/size I                                                             ; Getting object into field size
    if_icmpge else_1                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_1
else_1:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_1:
    ifeq else_0

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 0
    getfield LS/number [I                                                            ; Getting object into field number
    iload 1                                                         ; Getting j's value from local pool
    iaload                                                            ; pulling int from array
    invokevirtual java/io/PrintStream/println(I)V
    iload 1                                                         ; Getting j's value from local pool
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 1                                                            ; Storing item into j
    goto finally_0
  else_0:
    ldc 0                                                               ; Loading int constant


    ireturn
.end method

;================================
; Search method
;================================
.method public Search(I)I
    .limit stack 10
    .limit locals 50

    ldc 0                                                               ; j is being initialized and set to zero/false
    istore 2                                                            ; Saving variable in locals
    ldc 0                                                               ; ls01 is being initialized and set to zero/false
    istore 3                                                            ; Saving variable in locals
    ldc 0                                                               ; ifound is being initialized and set to zero/false
    istore 4                                                            ; Saving variable in locals
    ldc 0                                                               ; aux01 is being initialized and set to zero/false
    istore 5                                                            ; Saving variable in locals
    ldc 0                                                               ; aux02 is being initialized and set to zero/false
    istore 6                                                            ; Saving variable in locals
    ldc 0                                                               ; nt is being initialized and set to zero/false
    istore 7                                                            ; Saving variable in locals
    ldc 1                                                               ; Loading int constant
    istore 2                                                            ; Storing item into j
    ldc 0                                                               ; Loading in boolean constant(false)
    istore 3                                                            ; Storing item into ls01
    ldc 0                                                               ; Loading int constant
    istore 4                                                            ; Storing item into ifound
finally_2:
    iload 2                                                         ; Getting j's value from local pool
    aload 0
    getfield LS/size I                                                             ; Getting object into field size
    if_icmpge else_3                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_3
else_3:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_3:
    ifeq else_2
    aload 0
    getfield LS/number [I                                                            ; Getting object into field number
    iload 2                                                         ; Getting j's value from local pool
    iaload                                                            ; pulling int from array
    istore 5                                                            ; Storing item into aux01
    iload 1                                                         ; Getting num's value from local pool
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 6                                                            ; Storing item into aux02
    iload 5                                                         ; Getting aux01's value from local pool
    iload 1                                                         ; Getting num's value from local pool
    if_icmpge else_4                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_4
else_4:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_4:
    ifeq else_5
    ldc 0                                                               ; Loading int constant
    istore 7                                                            ; Storing item into nt
    goto finally_5
  else_5:
    iload 5                                                         ; Getting aux01's value from local pool
    iload 6                                                         ; Getting aux02's value from local pool
    if_icmpge else_7                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_7
else_7:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_7:
    ifne else_6                                                     ; Not the boolean expression
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_6
else_6:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_6:
    ifeq else_8
    ldc 0                                                               ; Loading int constant
    istore 7                                                            ; Storing item into nt
    goto finally_8
  else_8:
    ldc 1                                                               ; Loading in boolean constant(true)
    istore 3                                                            ; Storing item into ls01
    ldc 1                                                               ; Loading int constant
    istore 4                                                            ; Storing item into ifound
    aload 0
    getfield LS/size I                                                             ; Getting object into field size
    istore 2                                                            ; Storing item into j
  finally_8:
  finally_5:
    iload 2                                                         ; Getting j's value from local pool
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 2                                                            ; Storing item into j
    goto finally_2
  else_2:
    iload 4                                                         ; Getting ifound's value from local pool


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
    ldc 0                                                               ; aux01 is being initialized and set to zero/false
    istore 4                                                            ; Saving variable in locals
    ldc 0                                                               ; aux02 is being initialized and set to zero/false
    istore 5                                                            ; Saving variable in locals
    aload_0                                                            ; Getting object reference
    iload 1                                                         ; Getting sz's value from local pool
    putfield LS/size I                                                             ; Storing object into field size
    aload_0                                                            ; Getting object reference
    iload 1                                                         ; Getting sz's value from local pool
    newarray int                                                        ; initializing int array
    putfield LS/number [I                                                            ; Storing object into field number
    ldc 1                                                               ; Loading int constant
    istore 2                                                            ; Storing item into j
    aload 0
    getfield LS/size I                                                             ; Getting object into field size
    ldc 1                                                               ; Loading int constant
    iadd                                                            ; Adding top elements on stack
    istore 3                                                            ; Storing item into k
finally_9:
    iload 2                                                         ; Getting j's value from local pool
    aload 0
    getfield LS/size I                                                             ; Getting object into field size
    if_icmpge else_10                                                ; Comparing top two elements on the stack
    ldc 1                                                           ; Literal true given on successful pass of above conditional
    goto finally_10
else_10:
    ldc 0                                                           ; Literal true given on successful pass of above conditionals
finally_10:
    ifeq else_9
    ldc 2                                                               ; Loading int constant
    iload 2                                                         ; Getting j's value from local pool
    imul                                                            ; Multiplying top elements on stack
    istore 4                                                            ; Storing item into aux01
    iload 3                                                         ; Getting k's value from local pool
    ldc 3                                                               ; Loading int constant
    isub                                                            ; Subtracting top elements on stack
    istore 5                                                            ; Storing item into aux02
    aload 0
    getfield LS/number [I                                                            ; Getting object into field number
    iload 2                                                            ; Getting 'j' from the local pool
    iload 4                                                         ; Getting aux01's value from local pool
    iload 5                                                         ; Getting aux02's value from local pool
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
    goto finally_9
  else_9:
    ldc 0                                                               ; Loading int constant


    ireturn
.end method



