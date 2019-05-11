default rel

global A_sat
global A_assignment
global A_cond_ass
global V_k
global V_n
global V_m
global V_last
global V_times
global V_myHash
global F_check
global F_myprint
global F_payoff
global F_print_cond
global F_dfs
global F_print_last_cond
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




F_check:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rsi, 0
        cmp rsi, qword [rel V_m]
        jl lb0
        jmp lb11
lb11:
        mov rax, 1
        jmp end_F_check
lb0:
        mov rdi, 0
        mov rdx, 0
        cmp rdx, 3
        jl lb1
        jmp lb8
lb8:
        cmp rdi, 0
        je lb9
        jmp lb10
lb10:
        inc rsi
        cmp rsi, qword [rel V_m]
        jl lb0
        jmp lb11
lb9:
        mov rax, 0
        jmp end_F_check
lb1:
        mov rax, qword [rel A_sat]
        lea rax, [rax+rsi*8+8]
        mov rax, qword [rax]
        lea rax, [rax+rdx*8+8]
        mov rcx, qword [rax]
        cmp rcx, 0
        jg lb2
        jmp lb4
lb4:
        cmp rcx, 0
        jl lb5
        jmp lb7
lb7:
        inc rdx
        cmp rdx, 3
        jl lb1
        jmp lb8
lb5:
        mov rcx, rcx
        neg rcx
        mov rax, qword [rel A_assignment]
        lea rax, [rax+rcx*8+8]
        mov rax, qword [rax]
        cmp rax, 0
        je lb6
        jmp lb7
lb6:
        mov rdi, 1
        jmp lb7
lb2:
        mov rax, qword [rel A_assignment]
        lea rax, [rax+rcx*8+8]
        mov rax, qword [rax]
        cmp rax, 1
        je lb3
        jmp lb4
lb3:
        mov rdi, 1
        jmp lb4
end_F_check:
        mov rsp, rbp
        pop rbp
        ret


F_myprint:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push rbx
        mov rbx, rdi
        mov r12, 0
        mov rdi, rbx
        call S_strlen
        mov rax, rax
        cmp r12, rax
        jl lb12
        jmp lb13
lb13:
        jmp end_F_myprint
lb12:
        mov rdi, rbx
        mov rsi, r12
        call S_ord
        mov rax, rax
        mov rcx, qword [rel V_myHash]
        add rcx, rax
        mov qword [rel V_myHash], rcx
        inc r12
        mov rdi, rbx
        call S_strlen
        mov rax, rax
        cmp r12, rax
        jl lb12
        jmp lb13
end_F_myprint:
        pop rbx
        pop r12
        mov rsp, rbp
        pop rbp
        ret


F_payoff:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rdx, rsi
        mov rsi, rdi
        mov rdi, 0
        mov rcx, 0
        cmp rcx, 3
        jl lb14
        jmp lb17
lb17:
        mov rax, rdi
        jmp end_F_payoff
lb14:
        lea rax, [rsi+rcx*8+8]
        lea r8, [rdx+rcx*8+8]
        mov rax, qword [rax]
        cmp rax, qword [r8]
        jne lb15
        jmp lb16
lb16:
        inc rcx
        cmp rcx, 3
        jl lb14
        jmp lb17
lb15:
        mov rax, rdi
        inc rdi
        jmp lb16
end_F_payoff:
        mov rsp, rbp
        pop rbp
        ret


F_print_cond:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push rbx
        mov rbx, rdi
        cmp rbx, qword [rel V_n]
        je lb18
        jmp lb23
lb23:
        mov rcx, rbx
        add rcx, 1
        mov rax, qword [rel A_cond_ass]
        lea rax, [rax+rcx*8+8]
        mov qword [rax], 1
        mov rax, rbx
        add rax, 1
        mov rdi, rax
        call F_print_cond
        mov rcx, rbx
        add rcx, 1
        mov rax, qword [rel A_cond_ass]
        lea rax, [rax+rcx*8+8]
        mov qword [rax], 0
        mov rax, rbx
        add rax, 1
        mov rdi, rax
        call F_print_cond
        jmp end_F_print_cond
lb18:
        mov rax, qword [rel V_times]
        inc qword [rel V_times]
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rdi, rbx
        mov rsi, S_0
        call S_strcat
        mov rdi, qword [rel A_cond_ass]
        mov rsi, qword [rel A_assignment]
        call F_payoff
        mov rax, rax
        mov rdi, rax
        call F_toString
        mov rax, rax
        mov rdi, rbx
        mov rsi, rax
        call S_strcat
        mov rdi, rbx
        mov rsi, S_1
        call S_strcat
        mov rdi, rbx
        call F_myprint
        mov rbx, 0
        cmp rbx, qword [rel V_n]
        jl lb19
        jmp lb22
lb22:
        jmp end_F_print_cond
lb19:
        mov rcx, 10
        mov rax, rbx
        cqo
        idiv rcx
        mov rax, rdx
        cmp rax, 0
        je lb20
        jmp lb21
lb21:
        inc rbx
        cmp rbx, qword [rel V_n]
        jl lb19
        jmp lb22
lb20:
        mov rcx, rbx
        add rcx, 1
        mov rax, qword [rel A_cond_ass]
        lea rax, [rax+rcx*8+8]
        mov rdi, qword [rax]
        call F_toString
        mov rax, rax
        mov rdi, rax
        call F_myprint
        jmp lb21
end_F_print_cond:
        pop rbx
        mov rsp, rbp
        pop rbp
        ret


F_dfs:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push rbx
        mov rbx, rdi
        cmp rbx, qword [rel V_n]
        je lb24
        jmp lb27
lb27:
        mov rcx, rbx
        add rcx, 1
        mov rax, qword [rel A_assignment]
        lea rax, [rax+rcx*8+8]
        mov qword [rax], 1
        mov rax, rbx
        add rax, 1
        mov rdi, rax
        call F_dfs
        mov rax, rbx
        add rax, 1
        mov rcx, qword [rel A_assignment]
        lea rax, [rcx+rax*8+8]
        mov qword [rax], 0
        mov rax, rbx
        add rax, 1
        mov rdi, rax
        call F_dfs
        jmp end_F_dfs
lb24:
        call F_check
        mov rax, rax
        cmp rax, 1
        je lb25
        jmp lb26
lb26:
        jmp end_F_dfs
lb25:
        mov rdi, S_2
        call F_myprint
        mov rdi, 0
        call F_print_cond
        mov rdi, S_3
        call F_myprint
        jmp lb26
end_F_dfs:
        pop rbx
        mov rsp, rbp
        pop rbp
        ret


F_print_last_cond:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push rbx
        mov rbx, rdi
        cmp rbx, qword [rel V_n]
        je lb28
        jmp lb36
lb36:
        mov rax, rbx
        add rax, 1
        mov rcx, qword [rel A_assignment]
        lea rax, [rcx+rax*8+8]
        mov qword [rax], 1
        mov rax, rbx
        add rax, 1
        mov rdi, rax
        call F_print_last_cond
        mov rax, rbx
        add rax, 1
        mov rcx, qword [rel A_assignment]
        lea rax, [rcx+rax*8+8]
        mov qword [rax], 0
        mov rax, rbx
        add rax, 1
        mov rdi, rax
        call F_print_last_cond
        jmp end_F_print_last_cond
lb28:
        mov rdi, S_4
        call F_myprint
        mov r12, 1
        mov rbx, 0
        cmp rbx, qword [rel V_n]
        jl lb29
        jmp lb32
lb32:
        cmp r12, 0
        je lb33
        jmp lb34
lb34:
        mov rdi, S_6
        call F_myprint
        jmp lb35
lb35:
        jmp end_F_print_last_cond
lb33:
        mov rdi, S_5
        call F_myprint
        jmp lb35
lb29:
        mov rax, rbx
        add rax, 1
        mov rcx, qword [rel A_assignment]
        lea rax, [rcx+rax*8+8]
        mov rax, qword [rax]
        cmp rax, 1
        je lb30
        jmp lb31
lb31:
        mov rcx, rbx
        add rcx, 1
        mov rax, qword [rel A_assignment]
        lea rax, [rax+rcx*8+8]
        mov rdi, qword [rax]
        call F_toString
        mov rax, rax
        mov rdi, rax
        call F_myprint
        inc rbx
        cmp rbx, qword [rel V_n]
        jl lb29
        jmp lb32
lb30:
        mov r12, 0
        jmp lb31
end_F_print_last_cond:
        pop rbx
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
        mov qword [rel V_k], 5
        mov rax, qword [rel V_k]
        sal rax, 1
        mov rax, rax
        add rax, 1
        mov qword [rel V_n], rax
        mov rax, qword [rel V_k]
        mov qword [rel V_m], rax
        mov qword [rel V_last], 1
        mov rdi, S_7
        call F_myprint
        mov rax, qword [rel V_m]
        sal rax, 3
        mov rax, rax
        add rax, 8
        mov rdi, rax
        call malloc
        mov rcx, rax
        lea rdx, [rcx]
        mov rax, qword [rel V_m]
        mov qword [rdx], rax
        mov qword [rel A_sat], rcx
        mov rbx, 0
        cmp rbx, qword [rel V_m]
        jl lb37
        jmp lb38
lb38:
        mov rbx, qword [rel V_n]
        add rbx, 1
        mov rax, rbx
        sal rax, 3
        mov rax, rax
        add rax, 8
        mov rdi, rax
        call malloc
        mov rax, rax
        lea rcx, [rax]
        mov qword [rcx], rbx
        mov qword [rel A_assignment], rax
        mov rbx, qword [rel V_n]
        add rbx, 1
        mov rax, rbx
        sal rax, 3
        mov rax, rax
        add rax, 8
        mov rdi, rax
        call malloc
        mov rax, rax
        lea rcx, [rax]
        mov qword [rcx], rbx
        mov qword [rel A_cond_ass], rax
        mov rdi, 0
        call F_dfs
        mov rdi, 0
        call F_print_last_cond
        mov rdi, qword [rel V_myHash]
        call F_toString
        mov rax, rax
        mov rdi, rax
        call F_println
        mov rdi, qword [rel V_times]
        call F_toString
        mov rax, rax
        mov rdi, rax
        call F_println
        mov rax, 0
        jmp end_main
lb37:
        mov rdi, 32
        call malloc
        mov rax, rax
        lea rcx, [rax]
        mov rdx, 3
        mov qword [rcx], rdx
        mov rdx, rax
        lea rax, [rdx+0*8+8]
        mov rcx, qword [rel V_last]
        mov qword [rax], rcx
        lea rcx, [rdx+1*8+8]
        mov rax, qword [rel V_last]
        add rax, 1
        mov qword [rcx], rax
        lea rcx, [rdx+2*8+8]
        mov rax, qword [rel V_last]
        add rax, 2
        mov rax, rax
        neg rax
        mov qword [rcx], rax
        mov rax, qword [rel V_last]
        add rax, 2
        mov qword [rel V_last], rax
        mov rax, qword [rel A_sat]
        lea rax, [rax+rbx*8+8]
        mov qword [rax], rdx
        inc rbx
        cmp rbx, qword [rel V_m]
        jl lb37
        jmp lb38
end_main:
        pop rbx
        mov rsp, rbp
        pop rbp
        ret


__init:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov qword [rel V_times], 0
        mov qword [rel V_myHash], 0
        jmp end___init
end___init:
        mov rsp, rbp
        pop rbp
        ret


SECTION .data    align=8

SECTION .bss     align=8
A_sat:
         resq 1
A_assignment:
         resq 1
A_cond_ass:
         resq 1
V_k:
         resq 1
V_n:
         resq 1
V_m:
         resq 1
V_last:
         resq 1
V_times:
         resq 1
V_myHash:
         resq 1

SECTION .rodata
S_0: 
         db 2DH, 20H, 00H
S_1: 
         db 2AH, 78H, 00H
S_2: 
         db 78H, 7AH, 20H, 00H
S_3: 
         db 20H, 3CH, 3DH, 20H, 30H, 3BH, 0AH, 00H
S_4: 
         db 78H, 00H
S_5: 
         db 20H, 2BH, 20H, 00H
S_6: 
         db 20H, 3DH, 20H, 31H, 3BH, 0AH, 00H
S_7: 
         db 6DH, 61H, 78H, 3AH, 20H, 78H, 7AH, 3BH, 0AH, 00H

L_021:
        db 25H, 6CH, 64H, 00H

L_022:
        db 25H, 73H, 00H


