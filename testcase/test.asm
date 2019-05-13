default rel

global A_asciiTable
global F_hilo
global F_shift_l
global F_shift_r
global F_xorshift
global F_int2chr
global F_toStringHex
global F_getnumber
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
F_hilo:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rdx, rsi
        mov rax, rdi
        mov rcx, rax
        sal rcx, 16
        mov rax, rdx
        or rax, rcx
end_F_hilo:
        mov rsp, rbp
        pop rbp
        ret


F_shift_l:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push rbx
        mov rcx, rsi
        mov rax, rdi
        mov rbx, rax
        sal rbx, cl
        mov rdi, 32767, 
        mov rsi, 65535, 
        call F_hilo
        mov rcx, rbx
        and rcx, rax
        mov rax, rcx
end_F_shift_l:
        pop rbx
        mov rsp, rbp
        pop rbp
        ret


F_shift_r:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push r14
        push rbx
        mov r14, rsi
        mov rbx, rdi
        mov rdi, 32767, 
        mov rsi, 65535, 
        call F_hilo
        mov r12, rax
        mov rax, r12
        mov rcx, r14
        sar rax, cl
        sal rax, 1
        add rax, 1
        mov r12, rax
        mov rdx, rbx
        mov rcx, r14
        sar rdx, cl
        mov rax, r12
        and rax, rdx
        mov r12, rax
        mov rdi, 32767, 
        mov rsi, 65535, 
        call F_hilo
        mov rcx, rax
        mov rax, r12
        and rax, rcx
end_F_shift_r:
        pop rbx
        pop r14
        pop r12
        mov rsp, rbp
        pop rbp
        ret


F_xorshift:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push r14
        push r13
        push rbx
        mov r12, rsi
        mov rcx, rdi
        add rcx, 1
        mov rbx, rcx
        mov r14, 0
        imul rsi, r12, 10
        cmp r14, rsi
        jl lb0
lb1:
        mov rax, rbx
        xor rax, 123456789
        jmp end_F_xorshift
lb0:
        mov rdi, rbx, 
        mov rsi, 13, 
        call F_shift_l
        mov rcx, rax
        mov rax, rbx
        xor rax, rcx
        mov rbx, rax
        mov rdi, rbx, 
        mov rsi, 17, 
        call F_shift_r
        mov rcx, rax
        mov rax, rbx
        xor rax, rcx
        mov rbx, rax
        mov rdi, rbx, 
        mov rsi, 5, 
        call F_shift_l
        mov rdx, rax
        mov rcx, rbx
        xor rcx, rdx
        mov rbx, rcx
        mov rcx, r14
        inc r14
        imul r13, r12, 10
        cmp r14, r13
        jl lb0
        jmp lb1
end_F_xorshift:
        pop rbx
        pop r13
        pop r14
        pop r12
        mov rsp, rbp
        pop rbp
        ret


F_int2chr:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rax, rdi
        cmp rax, 32
        jge lb2
lb4:
        mov rax, S_1
        jmp end_F_int2chr
lb2:
        cmp rax, 126
        jle lb3
        jmp lb4
lb3:
        mov rcx, rax
        sub rcx, 32
        sub rax, 32
        mov rdi, qword [rel A_asciiTable], 
        mov rsi, rcx, 
        mov rdx, rax, 
        call S_substring
end_F_int2chr:
        mov rsp, rbp
        pop rbp
        ret


F_toStringHex:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push r14
        push rbx
        mov rbx, rdi
        mov rdi, 256, 
        call malloc
        mov r14, rax
        mov r14, S_2
        mov r12, 28
        cmp r12, 0
        jge lb5
lb9:
        mov rax, r14
        jmp end_F_toStringHex
lb5:
        mov rax, rbx
        mov rcx, r12
        sar rax, cl
        and rax, 15
        cmp rax, 10
        jl lb6
lb7:
        mov rcx, 65
        add rcx, rax
        mov rax, rcx
        sub rax, 10
        mov rdi, rax, 
        call F_int2chr
        mov rdi, r14, 
        mov rsi, rax, 
        call S_strcat
        mov r14, rax
lb8:
        mov rax, r12
        sub rax, 4
        mov r12, rax
        cmp r12, 0
        jge lb5
        jmp lb9
lb6:
        mov rcx, 48
        add rcx, rax
        mov rdi, rcx, 
        call F_int2chr
        mov rdi, r14, 
        mov rsi, rax, 
        call S_strcat
        mov r14, rax
        jmp lb8
end_F_toStringHex:
        pop rbx
        pop r14
        pop r12
        mov rsp, rbp
        pop rbp
        ret


F_getnumber:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push r14
        push rbx
        mov rax, rsi
        mov rcx, rdi
        and rdx, 31
        mov rbx, rdx
        mov rdi, rcx, 
        mov rsi, rax, 
        call F_xorshift
        mov r14, rax
        mov rdi, r14, 
        mov rsi, rbx, 
        call F_shift_l
        mov r12, rax
        mov rax, 32
        sub rax, rbx
        mov rdi, r14, 
        mov rsi, rax, 
        call F_shift_r
        mov rcx, rax
        mov rax, r12
        or rax, rcx
end_F_getnumber:
        pop rbx
        pop r14
        pop r12
        mov rsp, rbp
        pop rbp
        ret


main:
        push rbp
        mov rbp, rsp
        sub rsp, 112
        push r12
        push r14
        push r13
        push r15
        push rbx
        call __init
        mov rax, 0
        mov [rbp+-112], rax
        mov rax, 40
        mov [rbp+-16], rax
        mov rax, 100
        mov [rbp+-104], rax
        mov rax, 200
        mov [rbp+-40], rax
        mov rax, 125
        mov [rbp+-96], rax
        mov rax, 250
        mov [rbp+-64], rax
        mov rax, 30
        mov [rbp+-88], rax
        mov rax, 0
        mov [rbp+-48], rax
        mov rax, 0
        mov [rbp+-72], rax
        mov rax, 0
        mov [rbp+-8], rax
        mov rax, 0
        mov [rbp+-24], rax
        mov rax, [rbp+-112]
        mov [rbp+-32], rax
        mov rax, [rbp+-32]
        mov rcx, [rbp+-16]
        cmp rax, rcx
        jl lb10
lb15:
        mov rax, [rbp+-48]
        mov rdi, rax, 
        call F_toStringHex
        mov rdi, rax, 
        mov rsi, S_3, 
        call S_strcat
        mov rdi, rax, 
        call F_print
        mov rax, [rbp+-72]
        mov rdi, rax, 
        call F_toStringHex
        mov rdi, rax, 
        mov rsi, S_4, 
        call S_strcat
        mov rdi, rax, 
        call F_print
        mov rax, [rbp+-8]
        mov rdi, rax, 
        call F_toStringHex
        mov rdi, rax, 
        mov rsi, S_5, 
        call S_strcat
        mov rdi, rax, 
        call F_print
        mov rax, [rbp+-24]
        mov rdi, rax, 
        call F_toStringHex
        mov rdi, rax, 
        mov rsi, S_6, 
        call S_strcat
        mov rdi, rax, 
        call F_print
        mov rdi, S_7, 
        call F_println
        mov rax, 0
        jmp end_main
lb10:
        mov rax, [rbp+-104]
        mov [rbp+-56], rax
        mov rax, [rbp+-56]
        mov rcx, [rbp+-40]
        cmp rax, rcx
        jl lb11
lb14:
        mov rax, [rbp+-32]
        mov rax, [rbp+-32]
        inc rax
        mov [rbp+-32], rax
        mov rcx, [rbp+-32]
        mov rax, [rbp+-16]
        cmp rcx, rax
        jl lb10
        jmp lb15
lb11:
        mov rax, [rbp+-96]
        mov [rbp+-80], rax
        mov rcx, [rbp+-80]
        mov rax, [rbp+-64]
        cmp rcx, rax
        jl lb12
lb13:
        mov rax, [rbp+-56]
        mov rax, [rbp+-56]
        inc rax
        mov [rbp+-56], rax
        mov rax, [rbp+-56]
        mov rcx, [rbp+-40]
        cmp rax, rcx
        jl lb11
        jmp lb14
lb12:
        mov rax, [rbp+-112]
        mov rdi, rax, 
        mov rax, [rbp+-88]
        mov rsi, rax, 
        mov rax, [rbp+-80]
        mov rdx, rax, 
        call F_getnumber
        mov r12, rax
        mov rax, [rbp+-32]
        mov rdi, rax, 
        mov rax, [rbp+-88]
        mov rsi, rax, 
        mov rax, [rbp+-80]
        mov rdx, rax, 
        call F_getnumber
        mov r14, rax
        mov rax, [rbp+-56]
        mov rdi, rax, 
        mov rax, [rbp+-88]
        mov rsi, rax, 
        mov rax, [rbp+-80]
        mov rdx, rax, 
        call F_getnumber
        mov r13, rax
        mov rax, [rbp+-32]
        mov rcx, [rbp+-56]
        xor rax, rcx
        mov rdi, rax, 
        mov rax, [rbp+-88]
        mov rsi, rax, 
        mov rax, [rbp+-80]
        mov rdx, rax, 
        call F_getnumber
        mov r15, rax
        mov rax, [rbp+-80]
        mov rdi, rax, 
        mov rsi, 1, 
        call F_xorshift
        mov rbx, rax
        mov rax, [rbp+-56]
        mov rdi, rax, 
        mov rsi, 1, 
        call F_xorshift
        xor rbx, rax
        mov rax, [rbp+-32]
        mov rdi, rax, 
        mov rsi, 1, 
        call F_xorshift
        mov rcx, rax
        mov rax, rbx
        xor rax, rcx
        mov rbx, rax
        mov rax, r12
        xor rax, rbx
        mov rdi, rax, 
        mov rsi, 1, 
        call F_xorshift
        mov rcx, [rbp+-48]
        add rcx, rax
        mov rax, rcx
        mov [rbp+-48], rax
        mov rax, r14
        xor rax, rbx
        mov rdi, rax, 
        mov rsi, 1, 
        call F_xorshift
        mov rcx, [rbp+-72]
        add rcx, rax
        mov rax, rcx
        mov [rbp+-72], rax
        mov rax, r13
        xor rax, rbx
        mov rdi, rax, 
        mov rsi, 1, 
        call F_xorshift
        mov rcx, rax
        mov rax, [rbp+-8]
        add rax, rcx
        mov [rbp+-8], rax
        mov rax, r15
        xor rax, rbx
        mov rdi, rax, 
        mov rsi, 1, 
        call F_xorshift
        mov rcx, [rbp+-24]
        add rcx, rax
        mov rax, rcx
        mov [rbp+-24], rax
        mov rax, [rbp+-80]
        mov rax, [rbp+-80]
        inc rax
        mov [rbp+-80], rax
        mov rcx, [rbp+-80]
        mov rax, [rbp+-64]
        cmp rcx, rax
        jl lb12
        jmp lb13
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
        mov rdi, 256, 
        call malloc
        mov qword [rel A_asciiTable], rax
        mov qword [rel A_asciiTable], S_0
end___init:
        mov rsp, rbp
        pop rbp
        ret


SECTION .data    align=8

A_asciiTable:
         resq 256

S_0: 
         dq 95
         db 20H, 21H, 22H, 23H, 24H, 25H, 26H, 27H, 28H, 29H, 2AH, 2BH, 2CH, 2DH, 2EH, 2FH, 30H, 31H, 32H, 33H, 34H, 35H, 36H, 37H, 38H, 39H, 3AH, 3BH, 3CH, 3DH, 3EH, 3FH, 40H, 41H, 42H, 43H, 44H, 45H, 46H, 47H, 48H, 49H, 4AH, 4BH, 4CH, 4DH, 4EH, 4FH, 50H, 51H, 52H, 53H, 54H, 55H, 56H, 57H, 58H, 59H, 5AH, 5BH, 5CH, 5DH, 5EH, 5FH, 60H, 61H, 62H, 63H, 64H, 65H, 66H, 67H, 68H, 69H, 6AH, 6BH, 6CH, 6DH, 6EH, 6FH, 70H, 71H, 72H, 73H, 74H, 75H, 76H, 77H, 78H, 79H, 7AH, 7BH, 7CH, 7DH, 7EH, 00H
S_1: 
         dq 0
         db 00H
S_2: 
         dq 0
         db 00H
S_3: 
         dq 1
         db 20H, 00H
S_4: 
         dq 1
         db 20H, 00H
S_5: 
         dq 1
         db 20H, 00H
S_6: 
         dq 1
         db 20H, 00H
S_7: 
         dq 0
         db 00H
