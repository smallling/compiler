default rel

global A_c
global V_ans
global A_visit
global A_pre
global A_f
global V_i
global V_j
global V_open
global V_closed
global F_origin
global F_build
global F_find
global F_improve
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
F_origin:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push rbx
        mov r12, rdi
        mov rax, r12
        sal rax, 3
        add rax, 8
        mov rdi, rax, 
        call malloc
        lea rcx, [rax]
        mov qword [rcx], r12
        mov qword [rel A_c], rax
        mov qword [rel V_i], 0
        mov rax, qword [rel V_i]
        cmp rax, r12
        jl lb0
lb3:
        jmp end_F_origin
lb0:
        mov rcx, qword [rel A_c]
        mov rax, qword [rel V_i]
        lea rbx, [rcx+rax*8+8]
        mov rax, r12
        sal rax, 3
        add rax, 8
        mov rdi, rax, 
        call malloc
        lea rcx, [rax]
        mov qword [rcx], r12
        mov qword [rbx], rax
        mov qword [rel V_j], 0
        mov rax, qword [rel V_j]
        cmp rax, r12
        jl lb1
lb2:
        mov rax, qword [rel V_i]
        inc qword [rel V_i]
        mov rax, qword [rel V_i]
        cmp rax, r12
        jl lb0
        jmp lb3
lb1:
        mov rcx, qword [rel A_c]
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


F_build:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rdx, rsi
        mov rsi, rdi
        mov qword [rel V_i], 1
        mov rax, qword [rel V_i]
        cmp rax, 49
        jle lb4
lb7:
        mov qword [rel V_i], 1
        mov rax, qword [rel V_i]
        cmp rax, 49
        jle lb8
lb9:
        mov qword [rel V_i], 50
        mov rax, qword [rel V_i]
        cmp rax, 98
        jle lb10
lb11:
        xor rax, rax
        jmp end_F_build
lb10:
        mov rcx, qword [rel A_c]
        mov rax, qword [rel V_i]
        lea rax, [rcx+rax*8+8]
        mov rax, qword [rax]
        lea rax, [rax+rdx*8+8]
        mov qword [rax], 1
        mov rax, qword [rel V_i]
        inc qword [rel V_i]
        mov rax, qword [rel V_i]
        cmp rax, 98
        jle lb10
        jmp lb11
lb8:
        mov rax, qword [rel A_c]
        lea rax, [rax+rsi*8+8]
        mov rcx, qword [rax]
        mov rax, qword [rel V_i]
        lea rax, [rcx+rax*8+8]
        mov qword [rax], 1
        mov rax, qword [rel V_i]
        inc qword [rel V_i]
        mov rax, qword [rel V_i]
        cmp rax, 49
        jle lb8
        jmp lb9
lb4:
        mov qword [rel V_j], 50
        mov rax, 98
        sub rax, qword [rel V_i]
        mov rcx, rax
        add rcx, 1
        mov rax, qword [rel V_j]
        cmp rax, rcx
        jle lb5
lb6:
        mov rax, qword [rel V_i]
        inc qword [rel V_i]
        mov rax, qword [rel V_i]
        cmp rax, 49
        jle lb4
        jmp lb7
lb5:
        mov rax, qword [rel A_c]
        mov rcx, qword [rel V_i]
        lea rax, [rax+rcx*8+8]
        mov rcx, qword [rax]
        mov rax, qword [rel V_j]
        lea rax, [rcx+rax*8+8]
        mov qword [rax], 1
        mov rax, qword [rel V_j]
        inc qword [rel V_j]
        mov rax, 98
        sub rax, qword [rel V_i]
        mov rcx, rax
        add rcx, 1
        mov rax, qword [rel V_j]
        cmp rax, rcx
        jle lb5
        jmp lb6
end_F_build:
        mov rsp, rbp
        pop rbp
        ret


F_find:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rcx, rsi
        mov rsi, rdi
        mov qword [rel V_open], 0
        mov qword [rel V_closed], 1
        mov qword [rel V_i], 1
        mov rax, qword [rel V_i]
        cmp rax, rsi
        jle lb12
lb13:
        mov rax, qword [rel A_f]
        lea rax, [rax+1*8+8]
        mov qword [rax], rcx
        mov rax, qword [rel A_visit]
        lea rax, [rax+rcx*8+8]
        mov qword [rax], 1
        mov rax, qword [rel A_pre]
        lea rax, [rax+rcx*8+8]
        mov qword [rax], 0
        xor rax, rax
        mov rcx, qword [rel V_open]
        cmp rcx, qword [rel V_closed]
        jl lb14
lb24:
        jmp end_F_find
lb14:
        cmp rax, 0
        je lb15
        jmp lb24
lb15:
        mov rcx, qword [rel V_open]
        inc qword [rel V_open]
        mov rcx, qword [rel A_f]
        mov rdx, qword [rel V_open]
        lea rcx, [rcx+rdx*8+8]
        mov rcx, qword [rcx]
        mov qword [rel V_i], rcx
        mov qword [rel V_j], 1
        mov rcx, qword [rel V_j]
        cmp rcx, rsi
        jle lb16
lb22:
        mov rcx, qword [rel V_open]
        cmp rcx, qword [rel V_closed]
        jl lb23
        jmp lb24
lb23:
        cmp rax, 0
        je lb15
        jmp lb24
lb16:
        mov rcx, qword [rel A_c]
        mov rdx, qword [rel V_i]
        lea rcx, [rcx+rdx*8+8]
        mov rcx, qword [rcx]
        mov rdx, qword [rel V_j]
        lea rcx, [rcx+rdx*8+8]
        mov rcx, qword [rcx]
        cmp rcx, 0
        jg lb17
lb21:
        mov rcx, qword [rel V_j]
        inc qword [rel V_j]
        mov rcx, qword [rel V_j]
        cmp rcx, rsi
        jle lb16
        jmp lb22
lb17:
        mov rcx, qword [rel A_visit]
        mov rdx, qword [rel V_j]
        lea rcx, [rcx+rdx*8+8]
        mov rcx, qword [rcx]
        cmp rcx, 0
        je lb18
        jmp lb21
lb18:
        mov rcx, qword [rel A_visit]
        mov rdx, qword [rel V_j]
        lea rcx, [rcx+rdx*8+8]
        mov qword [rcx], 1
        mov rcx, qword [rel V_closed]
        inc qword [rel V_closed]
        mov rcx, qword [rel A_f]
        mov rdx, qword [rel V_closed]
        lea rdx, [rcx+rdx*8+8]
        mov rcx, qword [rel V_j]
        mov qword [rdx], rcx
        mov rdx, qword [rel A_pre]
        mov rcx, qword [rel V_j]
        lea rdx, [rdx+rcx*8+8]
        mov rcx, qword [rel V_i]
        mov qword [rdx], rcx
        mov rcx, qword [rel V_closed]
        cmp rcx, rsi
        je lb19
lb20:
        jmp lb21
lb19:
        mov rax, 1
        jmp lb20
lb12:
        mov rdx, qword [rel A_visit]
        mov rax, qword [rel V_i]
        lea rax, [rdx+rax*8+8]
        mov qword [rax], 0
        mov rax, qword [rel V_i]
        inc qword [rel V_i]
        mov rax, qword [rel V_i]
        cmp rax, rsi
        jle lb12
        jmp lb13
end_F_find:
        mov rsp, rbp
        pop rbp
        ret


F_improve:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rax, rdi
        mov qword [rel V_i], rax
        mov rax, qword [rel V_ans]
        inc qword [rel V_ans]
        mov rax, qword [rel A_pre]
        mov rcx, qword [rel V_i]
        lea rax, [rax+rcx*8+8]
        mov rax, qword [rax]
        cmp rax, 0
        jg lb25
lb26:
        xor rax, rax
        jmp end_F_improve
lb25:
        mov rcx, qword [rel A_pre]
        mov rax, qword [rel V_i]
        lea rax, [rcx+rax*8+8]
        mov rax, qword [rax]
        mov qword [rel V_j], rax
        mov rax, qword [rel A_c]
        mov rcx, qword [rel V_j]
        lea rax, [rax+rcx*8+8]
        mov rax, qword [rax]
        mov rcx, qword [rel V_i]
        lea rcx, [rax+rcx*8+8]
        mov rax, qword [rcx]
        dec qword [rcx]
        mov rcx, qword [rel A_c]
        mov rax, qword [rel V_i]
        lea rax, [rcx+rax*8+8]
        mov rax, qword [rax]
        mov rcx, qword [rel V_j]
        lea rax, [rax+rcx*8+8]
        mov rcx, qword [rax]
        inc qword [rax]
        mov rax, qword [rel V_j]
        mov qword [rel V_i], rax
        mov rax, qword [rel A_pre]
        mov rcx, qword [rel V_i]
        lea rax, [rax+rcx*8+8]
        mov rax, qword [rax]
        cmp rax, 0
        jg lb25
        jmp lb26
end_F_improve:
        mov rsp, rbp
        pop rbp
        ret


main:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push r14
        push rbx
        call __init
        mov rdi, 110, 
        call F_origin
        xor rax, rax
        mov r12, 99
        mov r14, 100
        xor rbx, rbx
        mov rdi, r12, 
        mov rsi, r14, 
        call F_build
        mov rdi, r14, 
        mov rsi, r12, 
        mov rdx, rbx, 
        call F_find
        cmp rax, 0
        jg lb27
lb28:
        mov rdi, qword [rel V_ans], 
        call F_toString
        mov rdi, rax, 
        call F_println
        xor rax, rax
        jmp end_main
lb27:
        mov rdi, r14, 
        call F_improve
        mov rdi, r14, 
        mov rsi, r12, 
        mov rdx, rbx, 
        call F_find
        cmp rax, 0
        jg lb27
        jmp lb28
end_main:
        pop rbx
        pop r14
        pop r12
        mov rsp, rbp
        pop rbp
        ret


__init:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov qword [rel V_ans], 0
        mov rdi, 888, 
        call malloc
        mov rcx, rax
        lea rax, [rcx]
        mov rdx, 110
        mov qword [rax], rdx
        mov qword [rel A_visit], rcx
        mov rdi, 888, 
        call malloc
        mov rcx, rax
        lea rax, [rcx]
        mov rdx, 110
        mov qword [rax], rdx
        mov qword [rel A_pre], rcx
        mov rdi, 888, 
        call malloc
        mov rcx, rax
        lea rax, [rcx]
        mov rdx, 110
        mov qword [rax], rdx
        mov qword [rel A_f], rcx
end___init:
        mov rsp, rbp
        pop rbp
        ret


SECTION .data    align=8

A_c:
         resq 1
V_ans:
         resq 1
A_visit:
         resq 1
A_pre:
         resq 1
A_f:
         resq 1
V_i:
         resq 1
V_j:
         resq 1
V_open:
         resq 1
V_closed:
         resq 1

