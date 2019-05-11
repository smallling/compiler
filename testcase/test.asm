default rel

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
        sub rsp, 16
        push r12
        push r14
        push r13
        push r15
        push rbx
        mov r15, 10000
        mov r13, 0
        mov r14, 2800
        mov rax, 0
        mov [rbp+-8], rax
        mov r12, 0
        mov rdi, 22416
        call malloc
        mov rcx, rax
        lea rax, [rcx]
        mov rsi, 2801
        mov qword [rax], rsi
        mov rbx, rcx
        mov rcx, 0
        mov rax, r13
        sub rax, r14
        cmp rax, 0
        jne lb0
        jmp lb1
lb1:
        jmp lb2
lb2:
        mov rax, 0
        mov [rbp+-8], rax
        mov rax, r14
        sal rax, 1
        mov rcx, rax
        cmp rcx, 0
        je lb3
        jmp lb4
lb4:
        mov r13, r14
        jmp lb5
lb5:
        lea rax, [rbx+r13*8+8]
        mov rax, qword [rax]
        imul r15
        mov rsi, rax
        mov rax, [rbp+-8]
        mov rax, rax
        add rax, rsi
        mov rax, rax
        mov [rbp+-8], rax
        lea rdi, [rbx+r13*8+8]
        dec rcx
        mov rsi, rcx
        mov rax, [rbp+-8]
        mov rax, rax
        cqo
        idiv rsi
        mov rax, rdx
        mov qword [rdi], rax
        mov rax, rcx
        dec rcx
        mov rsi, rax
        mov rax, [rbp+-8]
        mov rax, rax
        cqo
        idiv rsi
        mov rax, rax
        mov rax, rax
        mov [rbp+-8], rax
        dec r13
        cmp r13, 0
        je lb6
        jmp lb7
lb7:
        mov rax, [rbp+-8]
        mov rax, rax
        imul r13
        mov rax, rax
        mov rax, rax
        mov [rbp+-8], rax
        jmp lb5
lb6:
        jmp lb8
lb8:
        mov rax, r14
        sub rax, 14
        mov r14, rax
        mov rcx, r15
        mov rax, [rbp+-8]
        mov rax, rax
        cqo
        idiv rcx
        mov rcx, rax
        mov rax, r12
        add rax, rcx
        mov rdi, rax
        call F_toString
        mov rax, rax
        mov rdi, rax
        call F_print
        mov rcx, r15
        mov rax, [rbp+-8]
        mov rax, rax
        cqo
        idiv rcx
        mov rax, rdx
        mov r12, rax
        jmp lb2
lb3:
        jmp lb9
lb9:
        mov rdi, S_0
        call F_print
        mov rax, 0
        jmp end_main
lb0:
        mov rax, r13
        inc r13
        lea rcx, [rbx+rax*8+8]
        mov rsi, 5
        mov rax, r15
        cqo
        idiv rsi
        mov rax, rax
        mov qword [rcx], rax
        mov rax, r13
        sub rax, r14
        cmp rax, 0
        jne lb0
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


SECTION .data    align=8

SECTION .bss     align=8

SECTION .rodata
S_0: 
         db 0AH, 00H

L_021:
        db 25H, 6CH, 64H, 00H

L_022:
        db 25H, 73H, 00H


