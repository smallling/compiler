default rel

global V_n
global V_h
global V_now
global A_a
global V_A
global V_M
global V_Q
global V_R
global V_seed
global F_random
global F_initialize
global F_swap
global F_pd
global F_show
global F_win
global F_merge
global F_move
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




F_random:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rcx, qword [rel V_Q]
        mov rax, qword [rel V_seed]
        cqo
        idiv rcx
        mov rcx, rdx
        mov rax, qword [rel V_A]
        imul rcx
        mov rsi, rax
        mov rcx, qword [rel V_Q]
        mov rax, qword [rel V_seed]
        cqo
        idiv rcx
        mov rcx, rax
        mov rax, qword [rel V_R]
        imul rcx
        mov rax, rax
        mov rcx, rsi
        sub rcx, rax
        mov rax, rcx
        cmp rax, 0
        jge lb0
        jmp lb1
lb1:
        mov rax, rax
        add rax, qword [rel V_M]
        mov qword [rel V_seed], rax
        jmp lb2
lb2:
        mov rax, qword [rel V_seed]
        jmp end_F_random
lb0:
        mov qword [rel V_seed], rax
        jmp lb2
end_F_random:
        mov rsp, rbp
        pop rbp
        ret


F_initialize:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rax, rdi
        mov qword [rel V_seed], rax
        jmp end_F_initialize
end_F_initialize:
        mov rsp, rbp
        pop rbp
        ret


F_swap:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rdx, rsi
        mov rcx, rdi
        mov rax, qword [rel A_a]
        lea rax, [rax+rcx*8+8]
        mov rsi, qword [rax]
        mov rax, qword [rel A_a]
        lea rcx, [rax+rcx*8+8]
        mov rax, qword [rel A_a]
        lea rax, [rax+rdx*8+8]
        mov rax, qword [rax]
        mov qword [rcx], rax
        mov rax, qword [rel A_a]
        lea rax, [rax+rdx*8+8]
        mov qword [rax], rsi
        jmp end_F_swap
end_F_swap:
        mov rsp, rbp
        pop rbp
        ret


F_pd:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rsi, rdi
        mov rax, qword [rel V_h]
        cmp rax, rsi
        jle lb3
        jmp lb6
lb6:
        mov rax, 0
        jmp end_F_pd
lb3:
        mov rcx, qword [rel V_h]
        add rcx, 1
        mov rax, qword [rel V_h]
        imul rcx
        mov rax, rax
        mov rax, rax
        sar rax, 1
        cmp rsi, rax
        je lb4
        jmp lb5
lb5:
        inc qword [rel V_h]
        mov rax, qword [rel V_h]
        cmp rax, rsi
        jle lb3
        jmp lb6
lb4:
        mov rax, 1
        jmp end_F_pd
end_F_pd:
        mov rsp, rbp
        pop rbp
        ret


F_show:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push r14
        push rbx
        mov r12, 0
        cmp r12, qword [rel V_now]
        jl lb7
        jmp lb8
lb8:
        mov rdi, S_1
        call F_println
        jmp end_F_show
lb7:
        mov rax, qword [rel A_a]
        lea rax, [rax+r12*8+8]
        mov rdi, qword [rax]
        call F_toString
        mov r14, rax
        mov rdi, r14
        call S_strlen
        mov rcx, rax
        mov rax, 1
        mov rax, rax
        add rax, rcx
        mov rdi, rax
        call malloc
        mov rbx, rax
        mov rdi, rbx
        mov rsi, r14
        call S_strcat
        mov rdi, rbx
        mov rsi, S_0
        call S_strcat
        mov rdi, rbx
        call F_print
        inc r12
        cmp r12, qword [rel V_now]
        jl lb7
        jmp lb8
end_F_show:
        pop rbx
        pop r14
        pop r12
        mov rsp, rbp
        pop rbp
        ret


F_win:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rdi, 808
        call malloc
        mov rdx, rax
        lea rcx, [rdx]
        mov rax, 100
        mov qword [rcx], rax
        mov rdx, rdx
        mov rax, qword [rel V_now]
        cmp rax, qword [rel V_h]
        jne lb9
        jmp lb10
lb10:
        mov r8, 0
        cmp r8, qword [rel V_now]
        jl lb11
        jmp lb12
lb12:
        mov rcx, 0
        mov rax, qword [rel V_now]
        sub rax, 1
        cmp rcx, rax
        jl lb13
        jmp lb18
lb18:
        mov rcx, 0
        cmp rcx, qword [rel V_now]
        jl lb19
        jmp lb22
lb22:
        mov rax, 1
        jmp end_F_win
lb19:
        lea rax, [rdx+rcx*8+8]
        mov rsi, rcx
        add rsi, 1
        mov rax, qword [rax]
        cmp rax, rsi
        jne lb20
        jmp lb21
lb21:
        inc rcx
        cmp rcx, qword [rel V_now]
        jl lb19
        jmp lb22
lb20:
        mov rax, 0
        jmp end_F_win
lb13:
        mov rax, rcx
        add rax, 1
        mov r8, rax
        cmp r8, qword [rel V_now]
        jl lb14
        jmp lb17
lb17:
        inc rcx
        mov rax, qword [rel V_now]
        sub rax, 1
        cmp rcx, rax
        jl lb13
        jmp lb18
lb14:
        lea rax, [rdx+rcx*8+8]
        lea rsi, [rdx+r8*8+8]
        mov rax, qword [rax]
        cmp rax, qword [rsi]
        jg lb15
        jmp lb16
lb16:
        inc r8
        cmp r8, qword [rel V_now]
        jl lb14
        jmp lb17
lb15:
        lea rax, [rdx+rcx*8+8]
        mov rax, qword [rax]
        lea rsi, [rdx+rcx*8+8]
        lea rdi, [rdx+r8*8+8]
        mov rdi, qword [rdi]
        mov qword [rsi], rdi
        lea rsi, [rdx+r8*8+8]
        mov qword [rsi], rax
        jmp lb16
lb11:
        lea rax, [rdx+r8*8+8]
        mov rcx, qword [rel A_a]
        lea rcx, [rcx+r8*8+8]
        mov rcx, qword [rcx]
        mov qword [rax], rcx
        inc r8
        cmp r8, qword [rel V_now]
        jl lb11
        jmp lb12
lb9:
        mov rax, 0
        jmp end_F_win
end_F_win:
        mov rsp, rbp
        pop rbp
        ret


F_merge:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push rbx
        mov rbx, 0
        cmp rbx, qword [rel V_now]
        jl lb23
        jmp lb30
lb30:
        mov rbx, 0
        cmp rbx, qword [rel V_now]
        jl lb31
        jmp lb34
lb34:
        jmp end_F_merge
lb31:
        mov rax, qword [rel A_a]
        lea rax, [rax+rbx*8+8]
        mov rax, qword [rax]
        cmp rax, 0
        je lb32
        jmp lb33
lb33:
        inc rbx
        cmp rbx, qword [rel V_now]
        jl lb31
        jmp lb34
lb32:
        mov qword [rel V_now], rbx
        jmp lb34
lb23:
        mov rax, qword [rel A_a]
        lea rax, [rax+rbx*8+8]
        mov rax, qword [rax]
        cmp rax, 0
        je lb24
        jmp lb29
lb29:
        inc rbx
        cmp rbx, qword [rel V_now]
        jl lb23
        jmp lb30
lb24:
        mov rax, rbx
        add rax, 1
        mov rcx, rax
        cmp rcx, qword [rel V_now]
        jl lb25
        jmp lb28
lb28:
        jmp lb29
lb25:
        mov rax, qword [rel A_a]
        lea rax, [rax+rcx*8+8]
        mov rax, qword [rax]
        cmp rax, 0
        jne lb26
        jmp lb27
lb27:
        inc rcx
        cmp rcx, qword [rel V_now]
        jl lb25
        jmp lb28
lb26:
        mov rdi, rbx
        mov rsi, rcx
        call F_swap
        jmp lb28
end_F_merge:
        pop rbx
        mov rsp, rbp
        pop rbp
        ret


F_move:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rcx, 0
        cmp rcx, qword [rel V_now]
        jl lb35
        jmp lb36
lb36:
        mov rax, qword [rel A_a]
        mov rcx, qword [rel V_now]
        lea rax, [rax+rcx*8+8]
        mov rcx, qword [rel V_now]
        mov qword [rax], rcx
        mov rax, qword [rel V_now]
        inc qword [rel V_now]
        jmp end_F_move
lb35:
        mov rax, qword [rel A_a]
        lea rax, [rax+rcx*8+8]
        dec qword [rax]
        mov rax, rcx
        add rax, 1
        mov rcx, rax
        cmp rcx, qword [rel V_now]
        jl lb35
        jmp lb36
end_F_move:
        mov rsp, rbp
        pop rbp
        ret


main:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push r14
        push r13
        push rbx
        call __init
        mov r14, 0
        mov r12, 0
        mov r13, 0
        mov qword [rel V_n], 210
        mov qword [rel V_h], 0
        mov rdi, 808
        call malloc
        mov rcx, rax
        lea rsi, [rcx]
        mov rax, 100
        mov qword [rsi], rax
        mov qword [rel A_a], rcx
        mov rcx, qword [rel V_A]
        mov rax, qword [rel V_M]
        cqo
        idiv rcx
        mov rax, rax
        mov qword [rel V_Q], rax
        mov rcx, qword [rel V_A]
        mov rax, qword [rel V_M]
        cqo
        idiv rcx
        mov rax, rdx
        mov qword [rel V_R], rax
        mov rdi, qword [rel V_n]
        call F_pd
        mov rax, rax
        cmp rax, 0
        jne lb38
        jmp lb37
lb37:
        mov rdi, S_2
        call F_println
        mov rax, 1
        jmp end_main
lb38:
        mov rdi, S_3
        call F_println
        mov rdi, 3654898
        call F_initialize
        call F_random
        mov rax, rax
        mov rcx, 10
        mov rax, rax
        cqo
        idiv rcx
        mov rax, rdx
        mov rax, rax
        add rax, 1
        mov qword [rel V_now], rax
        mov rdi, qword [rel V_now]
        call F_toString
        mov rax, rax
        mov rdi, rax
        call F_println
        mov rax, qword [rel V_now]
        sub rax, 1
        cmp r14, rax
        jl lb39
        jmp lb42
lb42:
        mov rax, qword [rel V_now]
        sub rax, 1
        mov rcx, qword [rel A_a]
        lea rcx, [rcx+rax*8+8]
        mov rax, qword [rel V_n]
        sub rax, r12
        mov qword [rcx], rax
        call F_show
        call F_merge
        call F_win
        mov rax, rax
        cmp rax, 0
        jne lb44
        jmp lb43
lb43:
        mov r12, 5
        inc r13
        mov rdi, r13
        call F_toString
        mov rbx, rax
        mov rdi, rbx
        call S_strlen
        mov rax, rax
        mov rcx, rax
        add rcx, r12
        mov rax, 1
        mov rax, rax
        add rax, rcx
        mov rdi, rax
        call malloc
        mov r14, rax
        mov rdi, r14
        mov rsi, S_4
        call S_strcat
        mov rdi, r14
        mov rsi, rbx
        call S_strcat
        mov rdi, r14
        mov rsi, S_5
        call S_strcat
        mov rdi, r14
        call F_println
        call F_move
        call F_merge
        call F_show
        call F_win
        mov rax, rax
        cmp rax, 0
        jne lb44
        jmp lb43
lb44:
        mov rbx, 7
        mov rdi, r13
        call F_toString
        mov r12, rax
        mov rdi, r12
        call S_strlen
        mov rax, rax
        mov rax, rax
        add rax, rbx
        mov rcx, 8
        mov rcx, rcx
        add rcx, rax
        mov rdi, rcx
        call malloc
        mov r14, rax
        mov rdi, r14
        mov rsi, S_6
        call S_strcat
        mov rdi, r14
        mov rsi, r12
        call S_strcat
        mov rdi, r14
        mov rsi, S_7
        call S_strcat
        mov rdi, r14
        call F_println
        mov rax, 0
        jmp end_main
lb39:
        mov rax, qword [rel A_a]
        lea rbx, [rax+r14*8+8]
        call F_random
        mov rax, rax
        mov rcx, 10
        mov rax, rax
        cqo
        idiv rcx
        mov rax, rdx
        mov rax, rax
        add rax, 1
        mov qword [rbx], rax
        mov rax, qword [rel A_a]
        lea rax, [rax+r14*8+8]
        mov rax, qword [rax]
        add rax, r12
        cmp rax, qword [rel V_n]
        jg lb40
        jmp lb41
lb41:
        mov rax, qword [rel A_a]
        lea rcx, [rax+r14*8+8]
        mov rax, r12
        add rax, qword [rcx]
        mov r12, rax
        inc r14
        mov rax, qword [rel V_now]
        sub rax, 1
        cmp r14, rax
        jl lb39
        jmp lb42
lb40:
        mov rax, qword [rel A_a]
        lea rbx, [rax+r14*8+8]
        call F_random
        mov rax, rax
        mov rcx, 10
        mov rax, rax
        cqo
        idiv rcx
        mov rax, rdx
        mov rax, rax
        add rax, 1
        mov qword [rbx], rax
        mov rax, qword [rel A_a]
        lea rax, [rax+r14*8+8]
        mov rax, qword [rax]
        add rax, r12
        cmp rax, qword [rel V_n]
        jg lb40
        jmp lb41
end_main:
        pop rbx
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
        mov qword [rel V_A], 48271
        mov qword [rel V_M], 2147483647
        mov qword [rel V_seed], 1
        jmp end___init
end___init:
        mov rsp, rbp
        pop rbp
        ret


SECTION .data    align=8

SECTION .bss     align=8
V_n:
         resq 1
V_h:
         resq 1
V_now:
         resq 1
A_a:
         resq 1
V_A:
         resq 1
V_M:
         resq 1
V_Q:
         resq 1
V_R:
         resq 1
V_seed:
         resq 1

SECTION .rodata
S_0: 
         db 20H, 00H
S_1: 
         db 00H
S_2: 
         db 53H, 6FH, 72H, 72H, 79H, 2CH, 20H, 74H, 68H, 65H, 20H, 6EH, 75H, 6DH, 62H, 65H, 72H, 20H, 6EH, 20H, 6DH, 75H, 73H, 74H, 20H, 62H, 65H, 20H, 61H, 20H, 6EH, 75H, 6DH, 62H, 65H, 72H, 20H, 73H, 2EH, 74H, 2EH, 20H, 74H, 68H, 65H, 72H, 65H, 20H, 65H, 78H, 69H, 73H, 74H, 73H, 20H, 69H, 20H, 73H, 61H, 74H, 69H, 73H, 66H, 79H, 69H, 6EH, 67H, 20H, 6EH, 3DH, 31H, 2BH, 32H, 2BH, 2EH, 2EH, 2EH, 2BH, 69H, 00H
S_3: 
         db 4CH, 65H, 74H, 27H, 73H, 20H, 73H, 74H, 61H, 72H, 74H, 21H, 00H
S_4: 
         db 73H, 74H, 65H, 70H, 20H, 00H
S_5: 
         db 3AH, 00H
S_6: 
         db 54H, 6FH, 74H, 61H, 6CH, 3AH, 20H, 00H
S_7: 
         db 20H, 73H, 74H, 65H, 70H, 28H, 73H, 29H, 00H

L_021:
        db 25H, 6CH, 64H, 00H

L_022:
        db 25H, 73H, 00H


