default rel

global V_n
global A_a
global F_exchange
global F_makeHeap
global F_adjustHeap
global F_heapSort
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




F_exchange:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rcx, rsi
        mov rax, rdi
        mov rdx, qword [rel A_a]
        lea rdx, [rdx+rax*8+8]
        mov rsi, qword [rdx]
        mov rdx, qword [rel A_a]
        lea rdx, [rdx+rax*8+8]
        mov rax, qword [rel A_a]
        lea rax, [rax+rcx*8+8]
        mov rax, qword [rax]
        mov qword [rdx], rax
        mov rax, qword [rel A_a]
        lea rax, [rax+rcx*8+8]
        mov qword [rax], rsi
        jmp end_F_exchange
end_F_exchange:
        mov rsp, rbp
        pop rbp
        ret


F_makeHeap:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push rbx
        mov rax, qword [rel V_n]
        sub rax, 1
        mov rax, rax
        sar rax, 1
        mov rbx, rax
        mov rax, 0
        mov rcx, 0
        cmp rbx, 0
        jge lb0
        jmp lb6
lb6:
        mov rax, 0
        jmp end_F_makeHeap
lb0:
        mov rax, rbx
        sal rax, 1
        mov rcx, rax
        mov rax, rbx
        sal rax, 1
        mov rax, rax
        add rax, 1
        cmp rax, qword [rel V_n]
        jl lb1
        jmp lb3
lb3:
        mov rax, qword [rel A_a]
        lea rax, [rax+rbx*8+8]
        mov rdx, qword [rel A_a]
        lea rdx, [rdx+rcx*8+8]
        mov rax, qword [rax]
        cmp rax, qword [rdx]
        jg lb4
        jmp lb5
lb5:
        mov rax, rbx
        sub rax, 1
        mov rbx, rax
        cmp rbx, 0
        jge lb0
        jmp lb6
lb4:
        mov rdi, rbx
        mov rsi, rcx
        call F_exchange
        jmp lb5
lb1:
        mov rax, rbx
        sal rax, 1
        mov rax, rax
        add rax, 1
        mov rdx, qword [rel A_a]
        lea rax, [rdx+rax*8+8]
        mov rsi, rbx
        sal rsi, 1
        mov rdx, qword [rel A_a]
        lea rdx, [rdx+rsi*8+8]
        mov rax, qword [rax]
        cmp rax, qword [rdx]
        jl lb2
        jmp lb3
lb2:
        mov rax, rbx
        sal rax, 1
        mov rax, rax
        add rax, 1
        mov rcx, rax
        jmp lb3
end_F_makeHeap:
        pop rbx
        mov rsp, rbp
        pop rbp
        ret


F_adjustHeap:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov r8, rdi
        mov rsi, 0
        mov rdx, 0
        mov rax, 0
        mov rax, rsi
        sal rax, 1
        cmp rax, r8
        jl lb7
        jmp lb14
lb14:
        mov rax, 0
        jmp end_F_adjustHeap
lb7:
        mov rax, rsi
        sal rax, 1
        mov rdx, rax
        mov rax, rsi
        sal rax, 1
        mov rax, rax
        add rax, 1
        cmp rax, r8
        jl lb8
        jmp lb10
lb10:
        mov rax, qword [rel A_a]
        lea rcx, [rax+rsi*8+8]
        mov rax, qword [rel A_a]
        lea rax, [rax+rdx*8+8]
        mov rcx, qword [rcx]
        cmp rcx, qword [rax]
        jg lb11
        jmp lb12
lb12:
        jmp lb14
lb11:
        mov rax, qword [rel A_a]
        lea rax, [rax+rsi*8+8]
        mov rdi, qword [rax]
        mov rax, qword [rel A_a]
        lea rcx, [rax+rsi*8+8]
        mov rax, qword [rel A_a]
        lea rax, [rax+rdx*8+8]
        mov rax, qword [rax]
        mov qword [rcx], rax
        mov rax, qword [rel A_a]
        lea rax, [rax+rdx*8+8]
        mov qword [rax], rdi
        mov rsi, rdx
        jmp lb13
lb13:
        mov rax, rsi
        sal rax, 1
        cmp rax, r8
        jl lb7
        jmp lb14
lb8:
        mov rax, rsi
        sal rax, 1
        mov rcx, rax
        add rcx, 1
        mov rax, qword [rel A_a]
        lea rax, [rax+rcx*8+8]
        mov rdi, rsi
        sal rdi, 1
        mov rcx, qword [rel A_a]
        lea rcx, [rcx+rdi*8+8]
        mov rax, qword [rax]
        cmp rax, qword [rcx]
        jl lb9
        jmp lb10
lb9:
        mov rax, rsi
        sal rax, 1
        mov rax, rax
        add rax, 1
        mov rdx, rax
        jmp lb10
end_F_adjustHeap:
        mov rsp, rbp
        pop rbp
        ret


F_heapSort:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push rbx
        mov rax, 0
        mov rbx, 0
        cmp rbx, qword [rel V_n]
        jl lb15
        jmp lb16
lb16:
        mov rax, 0
        jmp end_F_heapSort
lb15:
        mov rax, qword [rel A_a]
        lea rax, [rax+0*8+8]
        mov rax, qword [rax]
        mov rcx, qword [rel A_a]
        lea rsi, [rcx+0*8+8]
        mov rcx, qword [rel V_n]
        sub rcx, rbx
        mov rcx, rcx
        sub rcx, 1
        mov rdx, qword [rel A_a]
        lea rcx, [rdx+rcx*8+8]
        mov rcx, qword [rcx]
        mov qword [rsi], rcx
        mov rcx, qword [rel V_n]
        sub rcx, rbx
        mov rdx, rcx
        sub rdx, 1
        mov rcx, qword [rel A_a]
        lea rcx, [rcx+rdx*8+8]
        mov qword [rcx], rax
        mov rax, qword [rel V_n]
        sub rax, rbx
        mov rax, rax
        sub rax, 1
        mov rdi, rax
        call F_adjustHeap
        mov rax, rax
        mov rax, rbx
        add rax, 1
        mov rbx, rax
        cmp rbx, qword [rel V_n]
        jl lb15
        jmp lb16
end_F_heapSort:
        pop rbx
        mov rsp, rbp
        pop rbp
        ret


main:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push rbx
        mov qword [rel V_n], 9987
        mov rax, qword [rel V_n]
        sal rax, 3
        mov rax, rax
        add rax, 8
        mov rdi, rax
        call malloc
        mov rcx, rax
        lea rdx, [rcx]
        mov rax, qword [rel V_n]
        mov qword [rdx], rax
        mov qword [rel A_a], rcx
        mov r12, 0
        mov rax, qword [rel A_a]
        lea rax, [rax]
        mov rax, qword [rax]
        cmp r12, rax
        jl lb17
        jmp lb18
lb18:
        call F_makeHeap
        mov rax, rax
        call F_heapSort
        mov rax, rax
        mov r12, 0
        mov rax, qword [rel A_a]
        lea rax, [rax]
        mov rax, qword [rax]
        cmp r12, rax
        jl lb19
        jmp lb20
lb20:
        mov rdi, S_1
        call F_print
        mov rax, 0
        jmp end_main
lb19:
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_a]
        lea rax, [rax+r12*8+8]
        mov rdi, qword [rax]
        call F_toString
        mov rax, rax
        mov rdi, rbx
        mov rsi, rax
        call S_strcat
        mov rdi, rbx
        mov rsi, S_0
        call S_strcat
        mov rdi, rbx
        call F_print
        mov rax, r12
        add rax, 1
        mov r12, rax
        mov rax, qword [rel A_a]
        lea rax, [rax]
        mov rax, qword [rax]
        cmp r12, rax
        jl lb19
        jmp lb20
lb17:
        mov rax, qword [rel A_a]
        lea rax, [rax+r12*8+8]
        mov qword [rax], r12
        mov rax, r12
        add rax, 1
        mov r12, rax
        mov rax, qword [rel A_a]
        lea rax, [rax]
        mov rax, qword [rax]
        cmp r12, rax
        jl lb17
        jmp lb18
end_main:
        pop rbx
        pop r12
        mov rsp, rbp
        pop rbp
        ret


SECTION .data    align=8

SECTION .bss     align=8
V_n:
         resq 1
A_a:
         resq 1

SECTION .rodata
S_0: 
         db 20H, 00H
S_1: 
         db 0AH, 00H

L_021:
        db 25H, 6CH, 64H, 00H

L_022:
        db 25H, 73H, 00H


