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
global S_strcmp
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
extern __isoc99_scanf
extern __printf_chk

SECTION .text

SECTION .text   6

ALIGN   16

F_print:
        lea     rdx, [rdi+8H]
        mov     esi, L_032
        mov     edi, 1
        xor     eax, eax
        jmp     __printf_chk







ALIGN   16

F_println:
        add     rdi, 8
        jmp     puts






ALIGN   8

F_getString:
        push    rbp
        mov     esi, __buffer.3442
        mov     edi, L_032
        xor     eax, eax
        push    rbx
        mov     ebx, __buffer.3442
        sub     rsp, 8
        call    __isoc99_scanf
L_016:  mov     edx, dword [rbx]
        add     rbx, 4
        lea     eax, [rdx-1010101H]
        not     edx
        and     eax, edx
        and     eax, 80808080H
        jz      L_016
        mov     edx, eax
        shr     edx, 16
        test    eax, 8080H
        cmove   eax, edx
        lea     rdx, [rbx+2H]
        cmove   rbx, rdx
        add     al, al
        sbb     rbx, 3
        sub     rbx, __buffer.3442
        lea     edi, [rbx+8H]
        movsxd  rdi, edi
        call    malloc
        mov     rbp, rax
        lea     rdx, [rbx+1H]
        movsxd  rax, ebx
        lea     rdi, [rbp+8H]
        mov     qword [rbp], rax
        mov     esi, __buffer.3442
        call    memcpy
        add     rsp, 8
        mov     rax, rbp
        pop     rbx
        pop     rbp
        ret







ALIGN   16

F_getInt:
        sub     rsp, 24
        mov     edi, L_033
        xor     eax, eax
        lea     rsi, [rsp+8H]
        call    __isoc99_scanf
        mov     rax, qword [rsp+8H]
        add     rsp, 24
        ret


        nop

ALIGN   16
F_toString:
        push    rbp
        mov     rbp, rdi
        mov     edi, 32
        push    rbx
        sub     rsp, 8
        call    malloc
        lea     rdi, [rax+8H]
        mov     rbx, rax
        mov     r8, rbp
        mov     ecx, L_033
        mov     edx, 24
        mov     esi, 1
        xor     eax, eax
        call    __sprintf_chk
        cdqe
        mov     qword [rbx], rax
        add     rsp, 8
        mov     rax, rbx
        pop     rbx
        pop     rbp
        ret







ALIGN   16

S_strlen:
        mov     rax, qword [rdi]
        ret







ALIGN   16

S_substring:
        push    r15
        push    r14
        push    r13
        movsxd  r13, esi
        push    r12
        mov     r12d, edx
        sub     r12d, r13d
        push    rbp
        mov     rbp, rdi
        lea     edi, [r12+0AH]
        push    rbx
        lea     ebx, [r12+1H]
        movsxd  rdi, edi
        sub     rsp, 8
        call    malloc
        movsxd  rdx, ebx
        test    ebx, ebx
        mov     qword [rax], rdx
        jle     L_018
        lea     edi, [r13+8H]
        add     r13, rbp
        lea     rcx, [rax+18H]
        lea     rdx, [r13+8H]
        lea     rsi, [r13+18H]
        cmp     rcx, rdx
        lea     rdx, [rax+8H]
        setbe   cl
        cmp     rsi, rdx
        setbe   dl
        or      cl, dl
        je      L_019
        cmp     ebx, 15
        jbe     L_019
        mov     esi, ebx
        xor     edx, edx
        xor     r8d, r8d
        shr     esi, 4
        mov     ecx, esi
        shl     ecx, 4
L_017:  movdqu  xmm0, oword [r13+rdx+8H]
        add     r8d, 1
        movdqu  oword [rax+rdx+8H], xmm0
        add     rdx, 16
        cmp     r8d, esi
        jc      L_017
        cmp     ebx, ecx
        je      L_018
        lea     edx, [rdi+rcx]
        lea     r13d, [rcx+8H]
        movsxd  rdx, edx
        movzx   esi, byte [rbp+rdx]
        movsxd  rdx, r13d
        mov     byte [rax+rdx], sil
        lea     edx, [rcx+1H]
        cmp     ebx, edx
        jle     L_018
        add     edx, edi
        lea     r11d, [rcx+9H]
        movsxd  rdx, edx
        movzx   esi, byte [rbp+rdx]
        movsxd  rdx, r11d
        mov     byte [rax+rdx], sil
        lea     edx, [rcx+2H]
        cmp     ebx, edx
        jle     L_018
        add     edx, edi
        lea     r10d, [rcx+0AH]
        movsxd  rdx, edx
        movzx   esi, byte [rbp+rdx]
        movsxd  rdx, r10d
        mov     byte [rax+rdx], sil
        lea     edx, [rcx+3H]
        cmp     ebx, edx
        jle     L_018
        add     edx, edi
        lea     r9d, [rcx+0BH]
        movsxd  rdx, edx
        movzx   esi, byte [rbp+rdx]
        movsxd  rdx, r9d
        mov     byte [rax+rdx], sil
        lea     edx, [rcx+4H]
        cmp     ebx, edx
        jle     L_018
        add     edx, edi
        lea     r8d, [rcx+0CH]
        movsxd  rdx, edx
        movzx   esi, byte [rbp+rdx]
        movsxd  rdx, r8d
        mov     byte [rax+rdx], sil
        lea     edx, [rcx+5H]
        cmp     ebx, edx
        jle     L_018
        add     edx, edi
        lea     esi, [rcx+0DH]
        movsxd  rdx, edx
        movzx   r14d, byte [rbp+rdx]
        movsxd  rdx, esi
        mov     byte [rax+rdx], r14b
        lea     edx, [rcx+6H]
        cmp     ebx, edx
        jle     L_018
        add     edx, edi
        movsxd  rdx, edx
        movzx   r15d, byte [rbp+rdx]
        lea     edx, [rcx+0EH]
        movsxd  r14, edx
        mov     byte [rax+r14], r15b
        lea     r14d, [rcx+7H]
        cmp     ebx, r14d
        jle     L_018
        add     r14d, edi
        cmp     ebx, r13d
        movsxd  r14, r14d
        movzx   r15d, byte [rbp+r14]
        lea     r14d, [rcx+0FH]
        movsxd  r14, r14d
        mov     byte [rax+r14], r15b
        jle     L_018
        add     r13d, edi
        cmp     ebx, r11d
        movsxd  r13, r13d
        movzx   r14d, byte [rbp+r13]
        lea     r13d, [rcx+10H]
        movsxd  r13, r13d
        mov     byte [rax+r13], r14b
        jle     L_018
        add     r11d, edi
        cmp     ebx, r10d
        movsxd  r11, r11d
        movzx   r13d, byte [rbp+r11]
        lea     r11d, [rcx+11H]
        movsxd  r11, r11d
        mov     byte [rax+r11], r13b
        jle     L_018
        add     r10d, edi
        cmp     ebx, r9d
        movsxd  r10, r10d
        movzx   r11d, byte [rbp+r10]
        lea     r10d, [rcx+12H]
        movsxd  r10, r10d
        mov     byte [rax+r10], r11b
        jle     L_018
        add     r9d, edi
        cmp     ebx, r8d
        movsxd  r9, r9d
        movzx   r10d, byte [rbp+r9]
        lea     r9d, [rcx+13H]
        movsxd  r9, r9d
        mov     byte [rax+r9], r10b
        jle     L_018
        add     r8d, edi
        cmp     ebx, esi
        movsxd  r8, r8d
        movzx   r9d, byte [rbp+r8]
        lea     r8d, [rcx+14H]
        movsxd  r8, r8d
        mov     byte [rax+r8], r9b
        jle     L_018
        add     esi, edi
        cmp     ebx, edx
        movsxd  rsi, esi
        movzx   r8d, byte [rbp+rsi]
        lea     esi, [rcx+15H]
        movsxd  rsi, esi
        mov     byte [rax+rsi], r8b
        jle     L_018
        add     edx, edi
        add     ecx, 22
        movsxd  rdx, edx
        movsxd  rcx, ecx
        movzx   edx, byte [rbp+rdx]
        mov     byte [rax+rcx], dl
L_018:  add     r12d, 9
        movsxd  r12, r12d
        mov     byte [rax+r12], 0
        add     rsp, 8
        pop     rbx
        pop     rbp
        pop     r12
        pop     r13
        pop     r14
        pop     r15
        ret





ALIGN   16
L_019:  movsxd  rdi, edi
        xor     ecx, ecx
        add     rbp, rdi




ALIGN   16
L_020:  movzx   edx, byte [rbp+rcx]
        mov     byte [rax+rcx+8H], dl
        add     rcx, 1
        cmp     ebx, ecx
        jg      L_020
        jmp     L_018







ALIGN   16

S_parseInt:
        movsx   edx, byte [rdi+8H]
        cmp     dl, 45
        jz      L_024
        lea     rcx, [rdi+8H]
        xor     edi, edi
L_021:  lea     eax, [rdx-30H]
        cmp     al, 9
        mov     eax, 0
        ja      L_023




ALIGN   8
L_022:  sub     edx, 48
        lea     rax, [rax+rax*4]
        add     rcx, 1
        movsxd  rdx, edx
        lea     rax, [rdx+rax*2]
        movsx   edx, byte [rcx]
        lea     esi, [rdx-30H]
        cmp     sil, 9
        jbe     L_022
L_023:  mov     rdx, rax
        neg     rdx
        test    edi, edi
        cmovne  rax, rdx
        ret





ALIGN   8
L_024:  lea     rcx, [rdi+9H]
        movsx   edx, byte [rdi+9H]
        mov     edi, 1
        jmp     L_021


        nop

ALIGN   16
S_ord:
        movsx   rax, byte [rdi+rsi+8H]
        ret







ALIGN   16

S_strcat:
        push    r15
        push    r14
        push    r13
        push    r12
        mov     r12, rsi
        push    rbp
        mov     rbp, rdi
        push    rbx
        sub     rsp, 8
        mov     rbx, qword [rdi]
        mov     r13, qword [rsi]
        lea     r14, [rbx+r13]
        lea     rdi, [r14+9H]
        call    malloc
        test    rbx, rbx
        mov     qword [rax], r14
        jle     L_026
        lea     rcx, [rbp+8H]
        lea     rdx, [rax+18H]
        lea     rsi, [rbp+18H]
        cmp     rcx, rdx
        lea     rdx, [rax+8H]
        setae   cl
        cmp     rsi, rdx
        setbe   dl
        or      cl, dl
        je      L_029
        cmp     rbx, 15
        jbe     L_029
        mov     rsi, rbx
        xor     ecx, ecx
        xor     edi, edi
        shr     rsi, 4
        mov     rdx, rsi
        shl     rdx, 4
L_025:  movdqu  xmm0, oword [rbp+rcx+8H]
        add     rdi, 1
        movdqu  oword [rax+rcx+8H], xmm0
        add     rcx, 16
        cmp     rsi, rdi
        ja      L_025
        cmp     rbx, rdx
        je      L_026
        lea     r14d, [rdx+8H]
        movsxd  r14, r14d
        movzx   ecx, byte [rbp+r14]
        mov     byte [rax+r14], cl
        lea     ecx, [rdx+1H]
        movsxd  rcx, ecx
        cmp     rbx, rcx
        jle     L_026
        lea     r10d, [rdx+9H]
        movsxd  rcx, r10d
        movzx   esi, byte [rbp+rcx]
        mov     byte [rax+rcx], sil
        lea     ecx, [rdx+2H]
        movsxd  rcx, ecx
        cmp     rbx, rcx
        jle     L_026
        lea     r9d, [rdx+0AH]
        movsxd  rcx, r9d
        movzx   esi, byte [rbp+rcx]
        mov     byte [rax+rcx], sil
        lea     ecx, [rdx+3H]
        movsxd  rcx, ecx
        cmp     rbx, rcx
        jle     L_026
        lea     r8d, [rdx+0BH]
        movsxd  rcx, r8d
        movzx   esi, byte [rbp+rcx]
        mov     byte [rax+rcx], sil
        lea     ecx, [rdx+4H]
        movsxd  rcx, ecx
        cmp     rbx, rcx
        jle     L_026
        lea     edi, [rdx+0CH]
        movsxd  rcx, edi
        movzx   esi, byte [rbp+rcx]
        mov     byte [rax+rcx], sil
        lea     ecx, [rdx+5H]
        movsxd  rcx, ecx
        cmp     rbx, rcx
        jle     L_026
        lea     esi, [rdx+0DH]
        movsxd  rcx, esi
        movzx   r11d, byte [rbp+rcx]
        mov     byte [rax+rcx], r11b
        lea     ecx, [rdx+6H]
        movsxd  rcx, ecx
        cmp     rbx, rcx
        jle     L_026
        lea     ecx, [rdx+0EH]
        movsxd  r11, ecx
        movzx   r15d, byte [rbp+r11]
        mov     byte [rax+r11], r15b
        lea     r11d, [rdx+7H]
        movsxd  r11, r11d
        cmp     rbx, r11
        jle     L_026
        lea     r11d, [rdx+0FH]
        cmp     rbx, r14
        movsxd  r11, r11d
        movzx   r15d, byte [rbp+r11]
        mov     byte [rax+r11], r15b
        jle     L_026
        lea     r11d, [rdx+10H]
        movsxd  r10, r10d
        cmp     rbx, r10
        movsxd  r11, r11d
        movzx   r14d, byte [rbp+r11]
        mov     byte [rax+r11], r14b
        jle     L_026
        lea     r10d, [rdx+11H]
        movsxd  r9, r9d
        cmp     rbx, r9
        movsxd  r10, r10d
        movzx   r11d, byte [rbp+r10]
        mov     byte [rax+r10], r11b
        jle     L_026
        lea     r9d, [rdx+12H]
        movsxd  r8, r8d
        cmp     rbx, r8
        movsxd  r9, r9d
        movzx   r10d, byte [rbp+r9]
        mov     byte [rax+r9], r10b
        jle     L_026
        lea     r8d, [rdx+13H]
        movsxd  rdi, edi
        cmp     rbx, rdi
        movsxd  r8, r8d
        movzx   r9d, byte [rbp+r8]
        mov     byte [rax+r8], r9b
        jle     L_026
        lea     edi, [rdx+14H]
        movsxd  rsi, esi
        cmp     rbx, rsi
        movsxd  rdi, edi
        movzx   r8d, byte [rbp+rdi]
        mov     byte [rax+rdi], r8b
        jle     L_026
        lea     esi, [rdx+15H]
        movsxd  rcx, ecx
        cmp     rbx, rcx
        movsxd  rsi, esi
        movzx   edi, byte [rbp+rsi]
        mov     byte [rax+rsi], dil
        jle     L_026
        add     edx, 22
        movsxd  rdx, edx
        movzx   ecx, byte [rbp+rdx]
        mov     byte [rax+rdx], cl
L_026:  test    r13, r13
        jle     L_031
        lea     rsi, [r13+1H]
        add     rbx, 8
        mov     edx, 1
        xor     ecx, ecx




ALIGN   8
L_027:  movzx   edi, byte [r12+rdx+7H]
        add     rcx, rax
        mov     byte [rcx+rbx], dil
        mov     rcx, rdx
        add     rdx, 1
        cmp     rdx, rsi
        jnz     L_027
L_028:  add     r13, rax
        mov     byte [r13+rbx], 0
        add     rsp, 8
        pop     rbx
        pop     rbp
        pop     r12
        pop     r13
        pop     r14
        pop     r15
        ret





ALIGN   8
L_029:  xor     edx, edx




ALIGN   8
L_030:  movzx   ecx, byte [rbp+rdx+8H]
        mov     byte [rax+rdx+8H], cl
        add     rdx, 1
        cmp     rbx, rdx
        jnz     L_030
        jmp     L_026

L_031:  add     rbx, 8
        jmp     L_028







ALIGN   16

S_strcmp:
        sub     rsp, 8
        add     rsi, 8
        add     rdi, 8
        call    strcmp
        add     rsp, 8
        cdqe
        ret



SECTION .data   



__buffer.3442:
        resb    1048576



SECTION .rodata.str1.1 

L_032:
        db 25H, 73H, 00H

L_033:
        db 25H, 6CH, 64H, 00H
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
        mov rcx, rsi
        sub rcx, rax
        mov rax, rcx
        cmp rax, 0
        jge lb0
lb1:
        add rax, qword [rel V_M]
        mov qword [rel V_seed], rax
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
lb6:
        mov rax, 0
        jmp end_F_pd
lb3:
        mov rcx, qword [rel V_h]
        add rcx, 1
        mov rax, qword [rel V_h]
        imul rcx
        sar rax, 1
        cmp rsi, rax
        je lb4
lb5:
        inc qword [rel V_h]
        mov rax, qword [rel V_h]
        cmp rax, rsi
        jle lb3
        jmp lb6
lb4:
        mov rax, 1
end_F_pd:
        mov rsp, rbp
        pop rbp
        ret


F_show:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push rbx
        mov rbx, 0
        cmp rbx, qword [rel V_now]
        jl lb7
lb8:
        mov rdi, S_1
        call F_println
        jmp end_F_show
lb7:
        mov rax, qword [rel A_a]
        lea rax, [rax+rbx*8+8]
        mov rdi, qword [rax]
        call F_toString
        mov rdi, rax
        mov rsi, S_0
        call S_strcat
        mov rdi, rax
        call F_print
        inc rbx
        cmp rbx, qword [rel V_now]
        jl lb7
        jmp lb8
end_F_show:
        pop rbx
        mov rsp, rbp
        pop rbp
        ret


F_win:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rdi, 816
        call malloc
        lea rdx, [rax]
        mov rcx, 101
        mov qword [rdx], rcx
        mov rsi, rax
        mov rax, qword [rel V_now]
        cmp rax, qword [rel V_h]
        jne lb9
lb10:
        mov rdi, 0
        cmp rdi, qword [rel V_now]
        jl lb11
lb12:
        mov rcx, 0
        mov rax, qword [rel V_now]
        sub rax, 1
        cmp rcx, rax
        jl lb13
lb18:
        mov rcx, 0
        cmp rcx, qword [rel V_now]
        jl lb19
lb22:
        mov rax, 1
        jmp end_F_win
lb19:
        lea rax, [rsi+rcx*8+8]
        mov rdx, rcx
        add rdx, 1
        mov rax, qword [rax]
        cmp rax, rdx
        jne lb20
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
        mov rdi, rax
        cmp rdi, qword [rel V_now]
        jl lb14
lb17:
        inc rcx
        mov rax, qword [rel V_now]
        sub rax, 1
        cmp rcx, rax
        jl lb13
        jmp lb18
lb14:
        lea rax, [rsi+rcx*8+8]
        lea rdx, [rsi+rdi*8+8]
        mov rax, qword [rax]
        cmp rax, qword [rdx]
        jg lb15
lb16:
        inc rdi
        cmp rdi, qword [rel V_now]
        jl lb14
        jmp lb17
lb15:
        lea rax, [rsi+rcx*8+8]
        mov rdx, qword [rax]
        lea r8, [rsi+rcx*8+8]
        lea rax, [rsi+rdi*8+8]
        mov rax, qword [rax]
        mov qword [r8], rax
        lea rax, [rsi+rdi*8+8]
        mov qword [rax], rdx
        jmp lb16
lb11:
        lea rcx, [rsi+rdi*8+8]
        mov rax, qword [rel A_a]
        lea rax, [rax+rdi*8+8]
        mov rax, qword [rax]
        mov qword [rcx], rax
        inc rdi
        cmp rdi, qword [rel V_now]
        jl lb11
        jmp lb12
lb9:
        mov rax, 0
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
lb30:
        mov rbx, 0
        cmp rbx, qword [rel V_now]
        jl lb31
lb34:
        jmp end_F_merge
lb31:
        mov rax, qword [rel A_a]
        lea rax, [rax+rbx*8+8]
        mov rax, qword [rax]
        cmp rax, 0
        je lb32
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
lb29:
        inc rbx
        cmp rbx, qword [rel V_now]
        jl lb23
        jmp lb30
lb24:
        mov rax, rbx
        add rax, 1
        cmp rax, qword [rel V_now]
        jl lb25
lb28:
        jmp lb29
lb25:
        mov rcx, qword [rel A_a]
        lea rcx, [rcx+rax*8+8]
        mov rcx, qword [rcx]
        cmp rcx, 0
        jne lb26
lb27:
        inc rax
        cmp rax, qword [rel V_now]
        jl lb25
        jmp lb28
lb26:
        mov rdi, rbx
        mov rsi, rax
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
        sub rsp, 16
        push r12
        push r14
        push r13
        push r15
        push rbx
        call __init
        mov r14, 0
        mov r15, 100
        cmp r14, r15
        jl lb37
lb46:
        mov rax, 0
        jmp end_main
lb37:
        mov r13, 0
        mov rax, 0
        mov [rbp+-8], rax
        mov r12, 0
        mov qword [rel V_n], 5050
        mov qword [rel V_h], 0
        mov rdi, 1608
        call malloc
        lea rcx, [rax]
        mov rsi, 200
        mov qword [rcx], rsi
        mov qword [rel A_a], rax
        mov rcx, qword [rel V_A]
        mov rax, qword [rel V_M]
        cqo
        idiv rcx
        mov qword [rel V_Q], rax
        mov rcx, qword [rel V_A]
        mov rax, qword [rel V_M]
        cqo
        idiv rcx
        mov rax, rdx
        mov qword [rel V_R], rax
        mov rdi, qword [rel V_n]
        call F_pd
        cmp rax, 0
        jne lb39
lb38:
        mov rdi, S_2
        call F_println
        mov rax, 1
        jmp end_main
lb39:
        mov rdi, S_3
        call F_println
        call F_random
        mov rdi, rax
        call F_initialize
        call F_random
        mov rcx, rax
        mov rsi, rcx
        sar rsi, 1
        imul rsi, rsi, 858993460
        sar rsi, 32
        imul rsi, rsi, 10
        mov rax, rcx
        sub rax, rsi
        add rax, 1
        mov qword [rel V_now], rax
        mov rdi, qword [rel V_now]
        call F_toString
        mov rdi, rax
        call F_println
        mov rax, qword [rel V_now]
        sub rax, 1
        cmp r13, rax
        jl lb40
lb43:
        mov rax, qword [rel V_now]
        sub rax, 1
        mov rcx, qword [rel A_a]
        lea rcx, [rcx+rax*8+8]
        mov rax, qword [rel V_n]
        mov rdx, [rbp+-8]
        sub rax, rdx
        mov qword [rcx], rax
        call F_show
        call F_merge
        call F_win
        cmp rax, 0
        jne lb45
lb44:
        inc r12
        call F_move
        call F_merge
        call F_win
        cmp rax, 0
        jne lb45
        jmp lb44
lb45:
        mov rdi, r12
        call F_toString
        mov rdi, S_4
        mov rsi, rax
        call S_strcat
        mov rdi, rax
        mov rsi, S_5
        call S_strcat
        mov rdi, rax
        call F_println
        inc r14
        cmp r14, r15
        jl lb37
        jmp lb46
lb40:
        mov rax, qword [rel A_a]
        lea rbx, [rax+r13*8+8]
        call F_random
        mov rcx, rax
        mov rsi, rcx
        sar rsi, 1
        imul rsi, rsi, 858993460
        sar rsi, 32
        imul rsi, rsi, 10
        mov rax, rcx
        sub rax, rsi
        add rax, 1
        mov qword [rbx], rax
        mov rax, qword [rel A_a]
        lea rax, [rax+r13*8+8]
        mov rax, qword [rax]
        mov rcx, [rbp+-8]
        add rax, rcx
        cmp rax, qword [rel V_n]
        jg lb41
lb42:
        mov rax, qword [rel A_a]
        lea rax, [rax+r13*8+8]
        mov rcx, [rbp+-8]
        add rcx, qword [rax]
        mov rax, rcx
        mov [rbp+-8], rax
        inc r13
        mov rax, qword [rel V_now]
        sub rax, 1
        cmp r13, rax
        jl lb40
        jmp lb43
lb41:
        mov rax, qword [rel A_a]
        lea rbx, [rax+r13*8+8]
        call F_random
        mov rcx, rax
        mov rsi, rcx
        sar rsi, 1
        imul rsi, rsi, 858993460
        sar rsi, 32
        imul rsi, rsi, 10
        mov rax, rcx
        sub rax, rsi
        add rax, 1
        mov qword [rbx], rax
        mov rax, qword [rel A_a]
        lea rax, [rax+r13*8+8]
        mov rax, qword [rax]
        mov rcx, [rbp+-8]
        add rax, rcx
        cmp rax, qword [rel V_n]
        jg lb41
        jmp lb42
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
        mov qword [rel V_A], 48271
        mov qword [rel V_M], 2147483647
        mov qword [rel V_seed], 1
end___init:
        mov rsp, rbp
        pop rbp
        ret


SECTION .data    align=8

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

S_0: 
         dq 1
         db 20H, 00H
S_1: 
         dq 0
         db 00H
S_2: 
         dq 79
         db 53H, 6FH, 72H, 72H, 79H, 2CH, 20H, 74H, 68H, 65H, 20H, 6EH, 75H, 6DH, 62H, 65H, 72H, 20H, 6EH, 20H, 6DH, 75H, 73H, 74H, 20H, 62H, 65H, 20H, 61H, 20H, 6EH, 75H, 6DH, 62H, 65H, 72H, 20H, 73H, 2EH, 74H, 2EH, 20H, 74H, 68H, 65H, 72H, 65H, 20H, 65H, 78H, 69H, 73H, 74H, 73H, 20H, 69H, 20H, 73H, 61H, 74H, 69H, 73H, 66H, 79H, 69H, 6EH, 67H, 20H, 6EH, 3DH, 31H, 2BH, 32H, 2BH, 2EH, 2EH, 2EH, 2BH, 69H, 00H
S_3: 
         dq 12
         db 4CH, 65H, 74H, 27H, 73H, 20H, 73H, 74H, 61H, 72H, 74H, 21H, 00H
S_4: 
         dq 7
         db 54H, 6FH, 74H, 61H, 6CH, 3AH, 20H, 00H
S_5: 
         dq 8
         db 20H, 73H, 74H, 65H, 70H, 28H, 73H, 29H, 00H
