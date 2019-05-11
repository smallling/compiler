default rel

global V_N
global V_M
global V_i
global V_j
global V_primeCount
global V_resultCount
global A_b
global A_prime
global A_gps
global A_tmp
global A_result
global F_origin
global F_getPrime
global F_getResult
global F_printF
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




F_origin:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push rbx
        mov r12, rdi
        mov rax, r12
        sal rax, 3
        mov rax, rax
        add rax, 8
        mov rdi, rax
        call malloc
        mov rcx, rax
        lea rax, [rcx]
        mov qword [rax], r12
        mov qword [rel A_result], rcx
        mov qword [rel V_i], 0
        mov rax, qword [rel V_i]
        cmp rax, r12
        jl lb0
        jmp lb3
lb3:
        jmp end_F_origin
lb0:
        mov rcx, qword [rel A_result]
        mov rax, qword [rel V_i]
        lea rbx, [rcx+rax*8+8]
        mov rax, r12
        sal rax, 3
        mov rax, rax
        add rax, 8
        mov rdi, rax
        call malloc
        mov rax, rax
        lea rcx, [rax]
        mov qword [rcx], r12
        mov qword [rbx], rax
        mov qword [rel V_j], 0
        mov rax, qword [rel V_j]
        cmp rax, r12
        jl lb1
        jmp lb2
lb2:
        mov rax, qword [rel V_i]
        inc qword [rel V_i]
        mov rax, qword [rel V_i]
        cmp rax, r12
        jl lb0
        jmp lb3
lb1:
        mov rcx, qword [rel A_result]
        mov rax, qword [rel V_i]
        lea rax, [rcx+rax*8+8]
        mov rcx, qword [rax]
        mov rax, qword [rel V_j]
        lea rax, [rcx+rax*8+8]
        mov qword [rax], 0
        mov rax, qword [rel V_j]
        inc qword [rel V_j]
        mov rax, qword [rel V_j]
        cmp rax, r12
        jl lb1
        jmp lb2
end_F_origin:
        pop rbx
        pop r12
        mov rsp, rbp
        pop rbp
        ret


F_getPrime:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rdi, rdi
        mov r8, 2
        mov rsi, 2
        cmp rsi, rdi
        jle lb4
        jmp lb9
lb9:
        jmp end_F_getPrime
lb4:
        mov rax, qword [rel A_b]
        lea rax, [rax+rsi*8+8]
        mov rax, qword [rax]
        cmp rax, 1
        je lb5
        jmp lb6
lb6:
        mov rax, rsi
        imul r8
        mov rax, rax
        cmp rax, rdi
        jle lb7
        jmp lb8
lb8:
        mov r8, 2
        mov rax, rsi
        add rax, 1
        mov rsi, rax
        cmp rsi, rdi
        jle lb4
        jmp lb9
lb7:
        mov rax, rsi
        imul r8
        mov rcx, rax
        mov rax, qword [rel A_b]
        lea rax, [rax+rcx*8+8]
        mov qword [rax], 0
        mov rax, r8
        add rax, 1
        mov r8, rax
        mov rax, rsi
        imul r8
        mov rax, rax
        cmp rax, rdi
        jle lb7
        jmp lb8
lb5:
        mov rax, qword [rel A_tmp]
        lea rcx, [rax+0*8+8]
        mov rax, qword [rel A_tmp]
        lea rax, [rax+0*8+8]
        mov rax, qword [rax]
        add rax, 1
        mov qword [rcx], rax
        mov rax, qword [rel A_tmp]
        lea rax, [rax+0*8+8]
        mov rcx, qword [rel A_prime]
        mov rax, qword [rax]
        lea rax, [rcx+rax*8+8]
        mov qword [rax], rsi
        mov rax, qword [rel A_gps]
        lea rcx, [rax+rsi*8+8]
        mov rax, qword [rel A_tmp]
        lea rax, [rax+0*8+8]
        mov rax, qword [rax]
        mov qword [rcx], rax
        jmp lb6
end_F_getPrime:
        mov rsp, rbp
        pop rbp
        ret


F_getResult:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rax, rdx
        mov rax, rsi
        mov rax, rdi
        mov rax, 0
        jmp end_F_getResult
end_F_getResult:
        mov rsp, rbp
        pop rbp
        ret


F_printF:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push r14
        push rbx
        mov rbx, rdx
        mov r12, rsi
        mov r14, rdi
        mov rdi, r14
        call F_toString
        mov rax, rax
        mov rdi, rax
        call F_print
        cmp rbx, 0
        jg lb18
        jmp lb19
lb19:
        mov rdi, S_1
        call F_print
        jmp end_F_printF
lb18:
        mov rdi, S_0
        call F_print
        mov rdi, r12
        call F_toString
        mov rax, rax
        mov rdi, rax
        call F_print
        mov rax, r12
        sal rax, 1
        mov rax, rax
        sub rax, r14
        mov r12, rax
        mov rax, r14
        add rax, r12
        mov rax, rax
        sar rax, 1
        mov r14, rax
        mov rax, rbx
        sub rax, 1
        mov rbx, rax
        cmp rbx, 0
        jg lb18
        jmp lb19
end_F_printF:
        pop rbx
        pop r14
        pop r12
        mov rsp, rbp
        pop rbp
        ret


main:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push rbx
        call __init
        mov rdi, 170
        call F_origin
        mov qword [rel V_N], 1000
        call F_getInt
        mov rax, rax
        mov qword [rel V_M], rax
        mov qword [rel V_primeCount], 0
        mov qword [rel V_resultCount], 0
        mov rax, qword [rel A_tmp]
        lea rax, [rax+0*8+8]
        mov qword [rax], 0
        mov qword [rel V_i], 0
        mov rcx, qword [rel V_N]
        add rcx, 1
        mov rax, qword [rel V_i]
        cmp rax, rcx
        jl lb20
        jmp lb21
lb21:
        mov qword [rel V_i], 0
        mov rax, qword [rel V_M]
        add rax, 1
        mov rcx, qword [rel V_i]
        cmp rcx, rax
        jl lb22
        jmp lb23
lb23:
        mov qword [rel V_i], 0
        mov rax, qword [rel V_i]
        cmp rax, qword [rel V_M]
        jle lb24
        jmp lb27
lb27:
        mov rdi, qword [rel V_N]
        call F_getPrime
        mov rax, rax
        mov rax, qword [rel A_tmp]
        lea rax, [rax+0*8+8]
        mov rax, qword [rax]
        mov qword [rel V_primeCount], rax
        mov qword [rel V_i], 1
        mov rax, qword [rel V_i]
        cmp rax, qword [rel V_primeCount]
        jl lb28
        jmp lb35
lb35:
        mov rdi, S_3
        call F_print
        mov rdi, qword [rel V_resultCount]
        call F_toString
        mov rax, rax
        mov rdi, rax
        call F_println
        mov rax, 0
        jmp end_main
lb28:
        mov rax, qword [rel V_i]
        add rax, 1
        mov qword [rel V_j], rax
        mov rax, qword [rel V_j]
        cmp rax, qword [rel V_primeCount]
        jle lb29
        jmp lb34
lb34:
        mov rax, 0
        jmp end_main
lb29:
        mov rax, qword [rel A_result]
        mov rcx, qword [rel V_i]
        lea rax, [rax+rcx*8+8]
        mov rax, qword [rax]
        mov rcx, qword [rel V_j]
        lea rax, [rax+rcx*8+8]
        mov rax, qword [rax]
        cmp rax, -1
        je lb30
        jmp lb33
lb33:
        mov rax, qword [rel V_j]
        add rax, 1
        mov qword [rel V_j], rax
        mov rax, qword [rel V_j]
        cmp rax, qword [rel V_primeCount]
        jle lb29
        jmp lb34
lb30:
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rdi, qword [rel V_i]
        call F_toString
        mov rax, rax
        mov rdi, rbx
        mov rsi, rax
        call S_strcat
        mov rdi, rbx
        mov rsi, S_2
        call S_strcat
        mov rdi, qword [rel V_j]
        call F_toString
        mov rax, rax
        mov rdi, rbx
        mov rsi, rax
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rax, 0
        jmp end_main
lb24:
        mov qword [rel V_j], 0
        mov rax, qword [rel V_j]
        cmp rax, qword [rel V_M]
        jle lb25
        jmp lb26
lb26:
        mov rax, qword [rel V_i]
        add rax, 1
        mov qword [rel V_i], rax
        mov rax, qword [rel V_i]
        cmp rax, qword [rel V_M]
        jle lb24
        jmp lb27
lb25:
        mov rax, qword [rel A_result]
        mov rcx, qword [rel V_i]
        lea rax, [rax+rcx*8+8]
        mov rax, qword [rax]
        mov rcx, qword [rel V_j]
        lea rax, [rax+rcx*8+8]
        mov qword [rax], -1
        mov rax, qword [rel V_j]
        add rax, 1
        mov qword [rel V_j], rax
        mov rax, qword [rel V_j]
        cmp rax, qword [rel V_M]
        jle lb25
        jmp lb26
lb22:
        mov rax, qword [rel A_prime]
        mov rcx, qword [rel V_i]
        lea rax, [rax+rcx*8+8]
        mov qword [rax], 0
        mov rax, qword [rel V_i]
        add rax, 1
        mov qword [rel V_i], rax
        mov rcx, qword [rel V_M]
        add rcx, 1
        mov rax, qword [rel V_i]
        cmp rax, rcx
        jl lb22
        jmp lb23
lb20:
        mov rcx, qword [rel A_b]
        mov rax, qword [rel V_i]
        lea rax, [rcx+rax*8+8]
        mov qword [rax], 1
        mov rax, qword [rel A_gps]
        mov rcx, qword [rel V_i]
        lea rax, [rax+rcx*8+8]
        mov qword [rax], 0
        mov rax, qword [rel V_i]
        add rax, 1
        mov qword [rel V_i], rax
        mov rax, qword [rel V_N]
        add rax, 1
        mov rcx, qword [rel V_i]
        cmp rcx, rax
        jl lb20
        jmp lb21
end_main:
        pop rbx
        mov rsp, rbp
        pop rbp
        ret


__init:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rdi, 8016
        call malloc
        mov rcx, rax
        lea rax, [rcx]
        mov rdx, 1001
        mov qword [rax], rdx
        mov qword [rel A_b], rcx
        mov rdi, 1368
        call malloc
        mov rcx, rax
        lea rax, [rcx]
        mov rdx, 170
        mov qword [rax], rdx
        mov qword [rel A_prime], rcx
        mov rdi, 8016
        call malloc
        mov rcx, rax
        lea rax, [rcx]
        mov rdx, 1001
        mov qword [rax], rdx
        mov qword [rel A_gps], rcx
        mov rdi, 16
        call malloc
        mov rax, rax
        lea rcx, [rax]
        mov rdx, 1
        mov qword [rcx], rdx
        mov qword [rel A_tmp], rax
end___init:
        mov rsp, rbp
        pop rbp
        ret


SECTION .data    align=8

SECTION .bss     align=8
V_N:
         resq 1
V_M:
         resq 1
V_i:
         resq 1
V_j:
         resq 1
V_primeCount:
         resq 1
V_resultCount:
         resq 1
A_b:
         resq 1
A_prime:
         resq 1
A_gps:
         resq 1
A_tmp:
         resq 1
A_result:
         resq 1

SECTION .rodata
S_0: 
         db 20H, 00H
S_1: 
         db 0AH, 00H
S_2: 
         db 20H, 00H
S_3: 
         db 54H, 6FH, 74H, 61H, 6CH, 3AH, 20H, 00H

L_021:
        db 25H, 6CH, 64H, 00H

L_022:
        db 25H, 73H, 00H


