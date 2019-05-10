default rel

global A_a
global main
global S_substring
global S_parseInt
global S_ord
global S_strcpy
global S_strcat
global S_strlen
global F_print
global F_println
global F_getString
global F_getInt
global F_toString

extern strcmp
extern __sprintf_chk
extern _IO_getc
extern stdin
extern puts
extern scanf
extern _IO_putc
extern stdout
extern __stack_chk_fail
extern sscanf
extern memcpy
extern malloc

SECTION .text

S_strlen:
        xor     eax, eax
        cmp     byte [rdi], 0
        jz      L_002





ALIGN   16
L_001:  add     rax, 1
        cmp     byte [rdi+rax], 0
        jnz     L_001

        ret

L_002:

        ret






ALIGN   8

S_strcat:
        jmp     L_004





ALIGN   8
L_003:  add     rdi, 1
L_004:  cmp     byte [rdi], 0
        jnz     L_003
        movzx   eax, byte [rsi]
        test    al, al
        jz      L_006




ALIGN   16
L_005:  add     rdi, 1
        add     rsi, 1
        mov     byte [rdi-1H], al
        movzx   eax, byte [rsi]
        test    al, al
        jnz     L_005
L_006:  mov     byte [rdi], 0
        ret







ALIGN   16

S_strcpy:
        jmp     L_008





ALIGN   8
L_007:  add     rdi, 1
        add     rsi, 1
        mov     byte [rdi-1H], al
L_008:  movzx   eax, byte [rsi]
        test    al, al
        jnz     L_007
        mov     byte [rdi], 0
        ret






ALIGN   8

S_substring:
push    r14
        push    r13
        mov     r14, rdi
        push    r12
        push    rbp
        mov     r12, rdx
        push    rbx
        mov     rbp, rdx
        mov     rbx, rsi
        mov     edi, 256
        sub     rbp, rsi
        call    malloc
        cmp     r12, rbx
        mov     rcx, rax
        jl      L_009
        lea     r13, [rbp+1H]
        lea     rsi, [r14+rbx]
        mov     rdi, rax
        mov     rdx, r13
        call    memcpy
        mov     rcx, rax
L_009:  mov     byte [rcx+rbp+1H], 0
        mov     rax, rcx
        pop     rbx
        pop     rbp
        pop     r12
        pop     r13
        pop     r14
        ret


S_parseInt:
        sub     rsp, 24
        mov     esi, L_021


        mov     rax, qword [fs:abs 28H]
        mov     qword [rsp+8H], rax
        xor     eax, eax
        mov     rdx, rsp
        call    sscanf
        mov     rcx, qword [rsp+8H]


        xor     rcx, qword [fs:abs 28H]
        mov     rax, qword [rsp]
        jnz     L_010
        add     rsp, 24
        ret

L_010:  call    __stack_chk_fail
        nop
ALIGN   16

S_ord:
        movsx   rax, byte [rdi+rsi]
        ret







ALIGN   16

F_print:
        push    rbx
        mov     rbx, rdi
        movsx   edi, byte [rdi]
        test    dil, dil
        jz      L_012




ALIGN   8
L_011:  mov     rsi, qword [rel stdout]
        add     rbx, 1
        call    _IO_putc
        movsx   edi, byte [rbx]
        test    dil, dil
        jnz     L_011
L_012:  pop     rbx
        ret






ALIGN   8

F_getString:
        push    rbx
        mov     edi, 256
        call    malloc
        mov     edi, L_022
        mov     rbx, rax
        mov     rsi, rax
        xor     eax, eax
        call    scanf
        mov     rax, rbx
        pop     rbx
        ret







ALIGN   16

F_println:
        jmp     puts


        nop





ALIGN   16

F_getInt:
        sub     rsp, 24
        mov     edi, L_021


        mov     rax, qword [fs:abs 28H]
        mov     qword [rsp+8H], rax
        xor     eax, eax
        mov     rsi, rsp
        call    scanf
        mov     rdx, qword [rsp+8H]


        xor     rdx, qword [fs:abs 28H]
        mov     rax, qword [rsp]
        jnz     L_013
        add     rsp, 24
        ret

L_013:  call    __stack_chk_fail
        nop
ALIGN   16

F_toString:
        push    rbx
        mov     rbx, rdi
        mov     edi, 256
        call    malloc
        test    rbx, rbx
        mov     r9, rax
        je      L_019
        js      L_020
        xor     edi, edi
L_014:  movsxd  rsi, edi
        mov     ecx, edi
        mov     r11, qword 6666666666666667H
        add     rsi, r9
        mov     r8, rsi
        jmp     L_016





ALIGN   8
L_015:  mov     ecx, r10d
L_016:  mov     rax, rbx
        add     r8, 1
        lea     r10d, [rcx+1H]
        imul    r11
        mov     rax, rbx
        sar     rax, 63
        sar     rdx, 2
        sub     rdx, rax
        lea     rax, [rdx+rdx*4]
        add     rax, rax
        sub     rbx, rax
        add     ebx, 48
        mov     byte [r8-1H], bl
        test    rdx, rdx
        mov     rbx, rdx
        jnz     L_015
        movsxd  rax, ecx
        add     rax, r9
        cmp     edi, ecx
        jge     L_018




ALIGN   8
L_017:  movzx   edx, byte [rsi]
        movzx   r8d, byte [rax]
        add     edi, 1
        sub     ecx, 1
        add     rsi, 1
        sub     rax, 1
        mov     byte [rsi-1H], r8b
        mov     byte [rax+1H], dl
        cmp     edi, ecx
        jl      L_017
L_018:  mov     rax, r9
        pop     rbx
        ret





ALIGN   8
L_019:  mov     byte [rax], 48
        mov     rax, r9
        pop     rbx
        ret





ALIGN   16
L_020:  neg     rbx
        mov     byte [rax], 45
        mov     edi, 1
        jmp     L_014




main:
        push rbp
        mov rbp, rsp
        sub rsp, 224
        push r12
        push r14
        push r13
        push r15
        push rbx
        call __init
        mov rdi, 40
        call malloc
        mov rax, rax
        lea rbx, [rax]
        mov rcx, 4
        mov qword [rbx], rcx
        mov rax, rax
        mov [rbp+-160], rax
        mov rax, [rbp+-160]
        lea r12, [rax+0*8+8]
        mov rax, qword [rel A_a]
        mov qword [r12], rax
        mov rax, [rbp+-160]
        lea r14, [rax+1*8+8]
        mov rax, qword [rel A_a]
        mov qword [r14], rax
        mov rax, [rbp+-160]
        lea r13, [rax+2*8+8]
        mov rax, qword [rel A_a]
        mov qword [r13], rax
        mov rcx, [rbp+-160]
        mov rax, [rbp+-8]
        lea rax, [rcx+3*8+8]
        mov [rbp+-8], rax
        mov rax, qword [rel A_a]
        mov rcx, [rbp+-8]
        mov qword [rcx], rax
        mov rax, [rbp+-160]
        lea r15, [rax]
        mov rax, qword [r15]
        mov rdi, rax
        call F_toString
        mov rax, rax
        mov rdi, rax
        call F_println
        mov rax, [rbp+-160]
        mov rcx, [rbp+-200]
        lea rcx, [rax+0*8+8]
        mov [rbp+-200], rcx
        mov rax, [rbp+-200]
        mov rax, qword [rax]
        mov rcx, [rbp+-192]
        lea rcx, [rax+0*8+8]
        mov [rbp+-192], rcx
        mov rax, [rbp+-192]
        mov qword [rax], 1
        mov rax, [rbp+-160]
        mov rcx, [rbp+-136]
        lea rcx, [rax+0*8+8]
        mov [rbp+-136], rcx
        mov rax, [rbp+-136]
        mov rax, qword [rax]
        mov rcx, [rbp+-104]
        lea rcx, [rax+1*8+8]
        mov [rbp+-104], rcx
        mov rax, [rbp+-104]
        mov qword [rax], 2
        mov rax, [rbp+-160]
        mov rcx, [rbp+-72]
        lea rcx, [rax+0*8+8]
        mov [rbp+-72], rcx
        mov rax, [rbp+-72]
        mov rax, qword [rax]
        mov rcx, [rbp+-64]
        lea rcx, [rax+2*8+8]
        mov [rbp+-64], rcx
        mov rax, [rbp+-64]
        mov qword [rax], 3
        mov rax, [rbp+-160]
        mov rcx, [rbp+-48]
        lea rcx, [rax+0*8+8]
        mov [rbp+-48], rcx
        mov rax, [rbp+-48]
        mov rax, qword [rax]
        mov rcx, [rbp+-24]
        lea rcx, [rax+3*8+8]
        mov [rbp+-24], rcx
        mov rax, [rbp+-24]
        mov qword [rax], 4
        mov rbx, 0
        mov rax, [rbp+-160]
        mov rcx, [rbp+-216]
        lea rcx, [rax+1*8+8]
        mov [rbp+-216], rcx
        mov rax, [rbp+-216]
        mov rax, qword [rax]
        mov rcx, [rbp+-144]
        lea rcx, [rax]
        mov [rbp+-144], rcx
        mov rax, [rbp+-144]
        mov rax, qword [rax]
        cmp rbx, rax
        jl lb0
        jmp lb1
lb1:
        mov rdi, S_0
        call F_println
        mov rbx, 0
        mov rax, [rbp+-160]
        mov rcx, [rbp+-224]
        lea rcx, [rax+2*8+8]
        mov [rbp+-224], rcx
        mov rax, [rbp+-224]
        mov rax, qword [rax]
        mov rcx, [rbp+-208]
        lea rcx, [rax]
        mov [rbp+-208], rcx
        mov rax, [rbp+-208]
        mov rax, qword [rax]
        cmp rbx, rax
        jl lb2
        jmp lb3
lb3:
        mov rbx, 0
        mov rax, [rbp+-160]
        mov rcx, [rbp+-32]
        lea rcx, [rax+3*8+8]
        mov [rbp+-32], rcx
        mov rax, [rbp+-32]
        mov rax, qword [rax]
        mov rcx, [rbp+-16]
        lea rcx, [rax]
        mov [rbp+-16], rcx
        mov rax, [rbp+-16]
        mov rax, qword [rax]
        cmp rbx, rax
        jl lb4
        jmp lb5
lb5:
        mov rax, 0
        jmp end_main
lb4:
        mov rcx, [rbp+-160]
        mov rax, [rbp+-184]
        lea rax, [rcx+3*8+8]
        mov [rbp+-184], rax
        mov rax, [rbp+-184]
        mov rax, qword [rax]
        mov rcx, [rbp+-168]
        lea rcx, [rax+rbx*8+8]
        mov [rbp+-168], rcx
        mov rax, [rbp+-168]
        mov rdi, qword [rax]
        call F_toString
        mov rax, rax
        mov rdi, rax
        call F_print
        mov rax, rbx
        inc rbx
        mov rax, [rbp+-160]
        mov rcx, [rbp+-120]
        lea rcx, [rax+3*8+8]
        mov [rbp+-120], rcx
        mov rax, [rbp+-120]
        mov rax, qword [rax]
        mov rcx, [rbp+-88]
        lea rcx, [rax]
        mov [rbp+-88], rcx
        mov rax, [rbp+-88]
        mov rax, qword [rax]
        cmp rbx, rax
        jl lb4
        jmp lb5
lb2:
        mov rax, [rbp+-160]
        mov rcx, [rbp+-176]
        lea rcx, [rax+2*8+8]
        mov [rbp+-176], rcx
        mov rax, [rbp+-176]
        mov rax, qword [rax]
        mov rcx, [rbp+-152]
        lea rcx, [rax+rbx*8+8]
        mov [rbp+-152], rcx
        mov rax, [rbp+-152]
        mov qword [rax], 0
        mov rax, rbx
        inc rbx
        mov rax, [rbp+-160]
        mov rcx, [rbp+-112]
        lea rcx, [rax+2*8+8]
        mov [rbp+-112], rcx
        mov rax, [rbp+-112]
        mov rax, qword [rax]
        mov rcx, [rbp+-80]
        lea rcx, [rax]
        mov [rbp+-80], rcx
        mov rax, [rbp+-80]
        mov rax, qword [rax]
        cmp rbx, rax
        jl lb2
        jmp lb3
lb0:
        mov rax, [rbp+-160]
        mov rcx, [rbp+-128]
        lea rcx, [rax+1*8+8]
        mov [rbp+-128], rcx
        mov rax, [rbp+-128]
        mov rax, qword [rax]
        mov rcx, [rbp+-96]
        lea rcx, [rax+rbx*8+8]
        mov [rbp+-96], rcx
        mov rax, [rbp+-96]
        mov rdi, qword [rax]
        call F_toString
        mov rax, rax
        mov rdi, rax
        call F_print
        mov rax, rbx
        inc rbx
        mov rcx, [rbp+-160]
        mov rax, [rbp+-56]
        lea rax, [rcx+1*8+8]
        mov [rbp+-56], rax
        mov rax, [rbp+-56]
        mov rax, qword [rax]
        mov rcx, [rbp+-40]
        lea rcx, [rax]
        mov [rbp+-40], rcx
        mov rax, [rbp+-40]
        mov rax, qword [rax]
        cmp rbx, rax
        jl lb0
        jmp lb1
end_main:
        pop rbx
        pop r15
        pop r13
        pop r14
        pop r12
        mov rsp, rbp
        pop rbp
        ret


__init:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push rbx
        mov rdi, 40
        call malloc
        mov rcx, rax
        lea rbx, [rcx]
        mov rax, 4
        mov qword [rbx], rax
        mov qword [rel A_a], rcx
end___init:
        pop rbx
        mov rsp, rbp
        pop rbp
        ret


SECTION .data    align=8

SECTION .bss     align=8
A_a:
         resq 1

SECTION .rodata
S_0: 
         db 00H

L_021:
        db 25H, 6CH, 64H, 00H

L_022:
        db 25H, 73H, 00H


