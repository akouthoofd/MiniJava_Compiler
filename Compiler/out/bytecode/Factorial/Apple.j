.source Apple.j
.class public Apple
.super F

.field public variable [I                                                        ; Creating public field for class Apple
;================================
; default constructor
;================================
.method public <init>()V
    aload_0
    invokespecial F/<init>()V
    return
.end method

;================================
; test method
;================================
.method public test()I
    .limit stack 10
    .limit locals 50

    new F                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial F/<init>()V                                                        ; Calling parent's constructor
    astore 1                                                            ; store the reference to local variable 1
    new Fac                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Fac/<init>()V                                                        ; Calling parent's constructor
    astore 2                                                            ; store the reference to local variable 2
    ldc 2                                                            ; push 2 onto the stack
    newarray int                                                        ; call newarray to make a 2-element int array
    astore 3                                                            ; store the reference to the array in local variable 1
    aload 0
    getfield Apple/variable [I                                                            ; Getting object into field variable
    astore 3                                                            ; Storing item into num
    new F                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial F/<init>()V                                                        ; Calling parent's constructor
    astore 1                                                            ; Storing object into a
    new Fac                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Fac/<init>()V                                                        ; Calling parent's constructor
    astore 2                                                            ; Storing object into ap
    aload 0                                                            ; Loading object
    invokevirtual Apple/test()I


    ireturn
.end method

;================================
; one method
;================================
.method public one()I
    .limit stack 10
    .limit locals 50

    new Fac                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Fac/<init>()V                                                        ; Calling parent's constructor
    astore 1                                                            ; store the reference to local variable 1
    new F                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial F/<init>()V                                                        ; Calling parent's constructor
    astore 1                                                            ; Storing object into thing
    new Apple                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial Apple/<init>()V                                                        ; Calling parent's constructor
    astore 1                                                            ; Storing object into thing
    new N                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial N/<init>()V                                                        ; Calling parent's constructor
    astore 1                                                            ; Storing object into thing
    aload 0                                                            ; Loading object
    invokevirtual Apple/two()LF;
    invokevirtual F/F()I


    ireturn
.end method

;================================
; two method
;================================
.method public two()LF;
    .limit stack 10
    .limit locals 50

    ldc 2                                                            ; push 2 onto the stack
    newarray int                                                        ; call newarray to make a 2-element int array
    astore 1                                                            ; store the reference to the array in local variable 1
    ldc 5                                                               ; Loading int constant
    newarray int                                                        ; initializing int array
    astore 1                                                            ; Storing object into arr
    new F                                                            ; creating object
    dup                                                                 ; dup the object reference
    invokespecial F/<init>()V                                                        ; Calling parent's constructor


    areturn
.end method



