default rel

global V_INF
global V_nMax
global V_n
global V_m
global V_id_cnt
global A_din
global A_sp
global A_dintree
global A_char_ID
global F_max
global C_Node_F_copy
global C_Node_F_init
global C_Node_F_judge
global C_Node_F_push_up
global C_Node_F_addtag_ch
global C_Node_F_addtag_ro
global C_Node_F_push_down
global C_Node_F_rot
global C_Node_F_rotto
global C_Node_F_Node
global C_splay_tree_F_build
global C_splay_tree_F_build_tree
global C_splay_tree_F_find
global C_splay_tree_F_dfs
global C_splay_tree_F_del
global C_splay_tree_F_change
global C_splay_tree_F_rol
global C_splay_tree_F_getsum
global C_splay_tree_F_getMax
global C_splay_tree_F_splay_tree
global F_equ
global F_merge
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




F_max:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rax, rsi
        mov rcx, rdi
        cmp rcx, rax
        jg lb0
        jmp lb1
lb1:
        mov rax, rax
        jmp end_F_max
lb0:
        mov rax, rcx
        jmp end_F_max
end_F_max:
        mov rsp, rbp
        pop rbp
        ret


C_Node_F_copy:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rdx, rsi
        mov rcx, rdi
        lea rax, [rdx+72]
        mov rax, qword [rax]
        mov qword [rcx+72], rax
        lea rax, [rdx+56]
        mov rax, qword [rax]
        mov qword [rcx+56], rax
        lea rax, [rdx+8]
        mov rax, qword [rax]
        mov qword [rcx+8], rax
        lea rax, [rdx+32]
        mov rax, qword [rax]
        mov qword [rcx+32], rax
        lea rax, [rdx+64]
        mov rax, qword [rax]
        mov qword [rcx+64], rax
        lea rax, [rdx+16]
        mov rax, qword [rax]
        mov qword [rcx+16], rax
        lea rax, [rdx+24]
        mov rax, qword [rax]
        mov qword [rcx+24], rax
        lea rax, [rdx+80]
        mov rax, qword [rax]
        mov qword [rcx+80], rax
        lea rax, [rdx+0]
        mov rax, qword [rax]
        mov qword [rcx+0], rax
        lea rax, [rdx+40]
        mov rax, qword [rax]
        mov qword [rcx+40], rax
        mov rax, qword [rcx+48]
        lea rsi, [rax+0*8+8]
        lea rax, [rdx+48]
        mov rax, qword [rax]
        lea rax, [rax+0*8+8]
        mov rax, qword [rax]
        mov qword [rsi], rax
        mov rax, qword [rcx+48]
        lea rsi, [rax+1*8+8]
        lea rax, [rdx+48]
        mov rax, qword [rax]
        lea rax, [rax+1*8+8]
        mov rax, qword [rax]
        mov qword [rsi], rax
        lea rax, [rdx+88]
        mov rax, qword [rax]
        mov qword [rcx+88], rax
        jmp end_C_Node_F_copy
end_C_Node_F_copy:
        mov rsp, rbp
        pop rbp
        ret


C_Node_F_init:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push r14
        push rbx
        mov rcx, rdx
        mov rax, rsi
        mov rbx, rdi
        mov qword [rbx+72], rcx
        mov qword [rbx+8], 1
        mov qword [rbx+64], 0
        mov qword [rbx+24], 0
        mov qword [rbx+16], 0
        mov qword [rbx+32], rax
        mov qword [rbx+56], rax
        mov qword [rbx+80], rax
        mov qword [rbx+0], rax
        mov qword [rbx+40], rax
        mov rdi, 24
        call malloc
        mov r14, rax
        lea rcx, [r14]
        mov rax, 2
        mov qword [rcx], rax
        mov r12, 0
        cmp r12, 2
        jl lb2
        jmp lb3
lb3:
        mov qword [rbx+48], r14
        mov rax, qword [rbx+48]
        lea rax, [rax+0*8+8]
        mov qword [rax], 0
        mov rax, qword [rbx+48]
        lea rax, [rax+1*8+8]
        mov qword [rax], 0
        mov qword [rbx+88], 0
        jmp end_C_Node_F_init
lb2:
        mov rdi, 96
        call malloc
        mov rcx, rax
        lea rax, [r14+r12*8+8]
        mov qword [rax], rcx
        mov r12, r12
        add r12, 1
        cmp r12, 2
        jl lb2
        jmp lb3
end_C_Node_F_init:
        pop rbx
        pop r14
        pop r12
        mov rsp, rbp
        pop rbp
        ret


C_Node_F_judge:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rax, rsi
        mov rcx, rdi
        mov rcx, qword [rcx+48]
        lea rcx, [rcx+0*8+8]
        mov rdi, qword [rcx]
        mov rsi, rax
        call F_equ
        mov rax, rax
        cmp rax, 0
        jne lb4
        jmp lb5
lb5:
        mov rax, 1
        jmp end_C_Node_F_judge
lb4:
        mov rax, 0
        jmp end_C_Node_F_judge
end_C_Node_F_judge:
        mov rsp, rbp
        pop rbp
        ret


C_Node_F_push_up:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push r14
        push rbx
        mov rbx, rdi
        mov qword [rbx+8], 1
        mov rax, qword [rbx+56]
        mov qword [rbx+32], rax
        mov r12, 0
        cmp r12, 2
        jl lb7
        jmp lb10
lb10:
        mov rax, qword [rbx+56]
        mov qword [rbx+80], rax
        mov rax, qword [rbx+56]
        mov qword [rbx+0], rax
        mov rax, qword [rbx+56]
        mov qword [rbx+40], rax
        mov r14, qword [rbx+56]
        mov r12, qword [rbx+56]
        mov rax, qword [rbx+48]
        lea rax, [rax+0*8+8]
        mov rax, qword [rax]
        cmp rax, 0
        jne lb11
        jmp lb12
lb12:
        mov rax, qword [rbx+48]
        lea rax, [rax+1*8+8]
        mov rax, qword [rax]
        cmp rax, 0
        jne lb13
        jmp lb14
lb14:
        mov rdi, qword [rbx+80]
        mov rsi, r14
        call F_max
        mov rax, rax
        mov qword [rbx+80], rax
        mov rdi, qword [rbx+0]
        mov rsi, r12
        call F_max
        mov rax, rax
        mov qword [rbx+0], rax
        mov r12, 0
        cmp r12, 2
        jl lb15
        jmp lb18
lb18:
        mov r12, qword [rbx+56]
        mov rax, qword [rbx+48]
        lea rax, [rax+0*8+8]
        mov rax, qword [rax]
        cmp rax, 0
        jne lb19
        jmp lb20
lb20:
        mov rax, qword [rbx+48]
        lea rax, [rax+1*8+8]
        mov rax, qword [rax]
        cmp rax, 0
        jne lb21
        jmp lb22
lb22:
        mov rdi, qword [rbx+40]
        mov rsi, r12
        call F_max
        mov rax, rax
        mov qword [rbx+40], rax
        jmp end_C_Node_F_push_up
lb21:
        mov rax, qword [rbx+48]
        lea rax, [rax+1*8+8]
        mov rax, qword [rax]
        lea rax, [rax+80]
        mov rdi, qword [rax]
        mov rsi, 0
        call F_max
        mov rax, rax
        mov rcx, r12
        add rcx, rax
        mov r12, rcx
        jmp lb22
lb19:
        mov rax, qword [rbx+48]
        lea rax, [rax+0*8+8]
        mov rax, qword [rax]
        lea rax, [rax+0]
        mov rdi, qword [rax]
        mov rsi, 0
        call F_max
        mov rcx, rax
        mov rax, r12
        add rax, rcx
        mov r12, rax
        jmp lb20
lb15:
        mov rax, qword [rbx+48]
        lea rax, [rax+r12*8+8]
        mov rax, qword [rax]
        cmp rax, 0
        jne lb16
        jmp lb17
lb17:
        inc r12
        cmp r12, 2
        jl lb15
        jmp lb18
lb16:
        mov rax, qword [rbx+48]
        lea rax, [rax+r12*8+8]
        mov rax, qword [rax]
        lea rax, [rax+40]
        mov rdi, qword [rbx+40]
        mov rsi, qword [rax]
        call F_max
        mov rax, rax
        mov qword [rbx+40], rax
        jmp lb17
lb13:
        mov rax, qword [rbx+48]
        lea rax, [rax+1*8+8]
        mov rax, qword [rax]
        lea rax, [rax+0]
        mov rax, qword [rax]
        mov qword [rbx+0], rax
        mov rax, qword [rbx+48]
        lea rax, [rax+1*8+8]
        mov rax, qword [rax]
        lea rax, [rax+32]
        mov rcx, r12
        add rcx, qword [rax]
        mov r12, rcx
        mov rax, qword [rbx+48]
        lea rax, [rax+1*8+8]
        mov rax, qword [rax]
        lea rax, [rax+80]
        mov rdi, qword [rax]
        mov rsi, 0
        call F_max
        mov rcx, rax
        mov rax, r14
        add rax, rcx
        mov r14, rax
        jmp lb14
lb11:
        mov rax, qword [rbx+48]
        lea rax, [rax+0*8+8]
        mov rax, qword [rax]
        lea rax, [rax+80]
        mov rax, qword [rax]
        mov qword [rbx+80], rax
        mov rax, qword [rbx+48]
        lea rax, [rax+0*8+8]
        mov rax, qword [rax]
        lea rcx, [rax+32]
        mov rax, r14
        add rax, qword [rcx]
        mov r14, rax
        mov rax, qword [rbx+48]
        lea rax, [rax+0*8+8]
        mov rax, qword [rax]
        lea rax, [rax+0]
        mov rdi, qword [rax]
        mov rsi, 0
        call F_max
        mov rax, rax
        mov rcx, r12
        add rcx, rax
        mov r12, rcx
        jmp lb12
lb7:
        mov rax, qword [rbx+48]
        lea rax, [rax+r12*8+8]
        mov rax, qword [rax]
        cmp rax, 0
        jne lb8
        jmp lb9
lb9:
        inc r12
        cmp r12, 2
        jl lb7
        jmp lb10
lb8:
        mov rax, qword [rbx+48]
        lea rax, [rax+r12*8+8]
        mov rax, qword [rax]
        lea rax, [rax+8]
        mov rcx, qword [rbx+8]
        add rcx, qword [rax]
        mov qword [rbx+8], rcx
        mov rax, qword [rbx+48]
        lea rax, [rax+r12*8+8]
        mov rax, qword [rax]
        lea rax, [rax+32]
        mov rcx, qword [rbx+32]
        add rcx, qword [rax]
        mov qword [rbx+32], rcx
        jmp lb9
end_C_Node_F_push_up:
        pop rbx
        pop r14
        pop r12
        mov rsp, rbp
        pop rbp
        ret


C_Node_F_addtag_ch:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rsi, rsi
        mov rcx, rdi
        mov qword [rcx+56], rsi
        mov rax, qword [rcx+8]
        imul rsi
        mov rax, rax
        mov qword [rcx+32], rax
        cmp rsi, 0
        jge lb23
        jmp lb24
lb24:
        mov qword [rcx+80], rsi
        mov qword [rcx+0], rsi
        mov qword [rcx+40], rsi
        jmp lb25
lb25:
        mov qword [rcx+64], 1
        mov qword [rcx+16], rsi
        jmp end_C_Node_F_addtag_ch
lb23:
        mov rax, qword [rcx+32]
        mov qword [rcx+80], rax
        mov rax, qword [rcx+32]
        mov qword [rcx+0], rax
        mov rax, qword [rcx+32]
        mov qword [rcx+40], rax
        jmp lb25
end_C_Node_F_addtag_ch:
        mov rsp, rbp
        pop rbp
        ret


C_Node_F_addtag_ro:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rdx, rdi
        mov rax, qword [rdx+48]
        lea rax, [rax+0*8+8]
        mov rsi, qword [rax]
        mov rax, qword [rdx+48]
        lea rcx, [rax+0*8+8]
        mov rax, qword [rdx+48]
        lea rax, [rax+1*8+8]
        mov rax, qword [rax]
        mov qword [rcx], rax
        mov rax, qword [rdx+48]
        lea rax, [rax+1*8+8]
        mov qword [rax], rsi
        mov rcx, qword [rdx+80]
        mov rax, qword [rdx+0]
        mov qword [rdx+80], rax
        mov qword [rdx+0], rcx
        mov rax, qword [rdx+24]
        xor rax, 1
        mov qword [rdx+24], rax
        jmp end_C_Node_F_addtag_ro
end_C_Node_F_addtag_ro:
        mov rsp, rbp
        pop rbp
        ret


C_Node_F_push_down:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push rbx
        mov r12, rdi
        mov rax, qword [r12+64]
        cmp rax, 1
        je lb26
        jmp lb31
lb31:
        mov rax, qword [r12+24]
        cmp rax, 1
        je lb32
        jmp lb37
lb37:
        jmp end_C_Node_F_push_down
lb32:
        mov rbx, 0
        cmp rbx, 2
        jl lb33
        jmp lb36
lb36:
        mov qword [r12+24], 0
        jmp lb37
lb33:
        mov rax, qword [r12+48]
        lea rax, [rax+rbx*8+8]
        mov rax, qword [rax]
        cmp rax, 0
        jne lb34
        jmp lb35
lb35:
        inc rbx
        cmp rbx, 2
        jl lb33
        jmp lb36
lb34:
        mov rax, qword [r12+48]
        lea rax, [rax+rbx*8+8]
        mov rdi, qword [rax]
        call C_Node_F_addtag_ro
        jmp lb35
lb26:
        mov rbx, 0
        cmp rbx, 2
        jl lb27
        jmp lb30
lb30:
        mov qword [r12+64], 0
        jmp lb31
lb27:
        mov rax, qword [r12+48]
        lea rax, [rax+rbx*8+8]
        mov rax, qword [rax]
        cmp rax, 0
        jne lb28
        jmp lb29
lb29:
        inc rbx
        cmp rbx, 2
        jl lb27
        jmp lb30
lb28:
        mov rax, qword [r12+48]
        lea rax, [rax+rbx*8+8]
        mov rdi, qword [rax]
        mov rsi, qword [r12+16]
        call C_Node_F_addtag_ch
        jmp lb29
end_C_Node_F_push_down:
        pop rbx
        pop r12
        mov rsp, rbp
        pop rbp
        ret


C_Node_F_rot:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push r14
        push rbx
        mov rbx, rdi
        mov r14, qword [rbx+88]
        mov rdi, r14
        mov rsi, rbx
        call C_Node_F_judge
        mov rax, rax
        mov rax, rax
        mov rdx, rax
        lea rax, [r14+48]
        mov rax, qword [rax]
        lea rsi, [rax+rdx*8+8]
        mov rax, rdx
        xor rax, 1
        mov rcx, qword [rbx+48]
        lea rax, [rcx+rax*8+8]
        mov rax, qword [rax]
        mov qword [rsi], rax
        mov rax, rdx
        xor rax, 1
        mov rcx, qword [rbx+48]
        lea rax, [rcx+rax*8+8]
        mov qword [rax], r14
        lea rax, [r14+48]
        mov rax, qword [rax]
        lea rax, [rax+rdx*8+8]
        mov rax, qword [rax]
        cmp rax, 0
        jne lb38
        jmp lb39
lb39:
        lea rax, [r14+88]
        mov rax, qword [rax]
        mov qword [rbx+88], rax
        lea rax, [r14+88]
        mov qword [rax], rbx
        mov rax, qword [rbx+88]
        cmp rax, 0
        jne lb40
        jmp lb41
lb41:
        mov rdi, r14
        call C_Node_F_push_up
        jmp end_C_Node_F_rot
lb40:
        mov rax, qword [rbx+88]
        lea r12, [rax+48]
        mov rdi, qword [rbx+88]
        mov rsi, r14
        call C_Node_F_judge
        mov rax, rax
        mov rax, rax
        mov rcx, qword [r12]
        lea rax, [rcx+rax*8+8]
        mov qword [rax], rbx
        jmp lb41
lb38:
        lea rax, [r14+48]
        mov rax, qword [rax]
        lea rax, [rax+rdx*8+8]
        mov rax, qword [rax]
        lea rax, [rax+88]
        mov qword [rax], r14
        jmp lb39
end_C_Node_F_rot:
        pop rbx
        pop r14
        pop r12
        mov rsp, rbp
        pop rbp
        ret


C_Node_F_rotto:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push r14
        push r13
        push rbx
        mov r14, rsi
        mov rbx, rdi
        mov rdi, qword [rbx+88]
        mov rsi, r14
        call F_equ
        mov rax, rax
        cmp rax, 0
        jne lb48
        jmp lb42
lb42:
        mov r13, qword [rbx+88]
        lea rax, [r13+88]
        mov rdi, qword [rax]
        mov rsi, r14
        call F_equ
        mov rax, rax
        cmp rax, 0
        jne lb43
        jmp lb44
lb44:
        lea rax, [r13+88]
        mov rdi, qword [rax]
        mov rsi, r13
        call C_Node_F_judge
        mov rax, rax
        mov r12, rax
        mov rdi, r13
        mov rsi, rbx
        call C_Node_F_judge
        mov rax, rax
        mov rax, rax
        cmp r12, rax
        je lb45
        jmp lb46
lb46:
        mov rdi, rbx
        call C_Node_F_rot
        mov rdi, rbx
        call C_Node_F_rot
        jmp lb47
lb47:
        mov rdi, qword [rbx+88]
        mov rsi, r14
        call F_equ
        mov rax, rax
        cmp rax, 0
        jne lb48
        jmp lb42
lb45:
        mov rdi, r13
        call C_Node_F_rot
        mov rdi, rbx
        call C_Node_F_rot
        jmp lb47
lb43:
        mov rdi, rbx
        call C_Node_F_rot
        jmp lb47
lb48:
        mov rdi, rbx
        call C_Node_F_push_up
        mov rax, qword [rbx+88]
        cmp rax, 0
        jne lb49
        jmp lb50
lb50:
        jmp end_C_Node_F_rotto
lb49:
        mov rdi, qword [rbx+88]
        call C_Node_F_push_up
        jmp lb50
end_C_Node_F_rotto:
        pop rbx
        pop r13
        pop r14
        pop r12
        mov rsp, rbp
        pop rbp
        ret


C_Node_F_Node:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rax, rdi
        jmp end_C_Node_F_Node
end_C_Node_F_Node:
        mov rsp, rbp
        pop rbp
        ret


C_splay_tree_F_build:
        push rbp
        mov rbp, rsp
        sub rsp, 32
        push r12
        push r14
        push r13
        push r15
        push rbx
        mov rax, r8
        mov [rbp+-24], rax
        mov r13, rcx
        mov rax, rdx
        mov [rbp+-8], rax
        mov rbx, rsi
        mov r12, rdi
        mov rax, r13
        mov rcx, [rbp+-24]
        add rax, rcx
        mov rax, rax
        sal rax, 1
        mov r14, rax
        mov rdi, 96
        call malloc
        mov r15, rax
        mov rdi, r15
        call C_Node_F_Node
        mov r15, r15
        mov rax, qword [rel A_din]
        lea rax, [rax+r14*8+8]
        inc qword [rel V_id_cnt]
        mov rdi, r15
        mov rsi, qword [rax]
        mov rdx, qword [rel V_id_cnt]
        call C_Node_F_init
        mov rdi, rbx
        mov rsi, r15
        call C_Node_F_copy
        lea rax, [rbx+88]
        mov rcx, [rbp+-8]
        mov qword [rax], rcx
        cmp r13, r14
        jl lb51
        jmp lb52
lb52:
        mov rax, [rbp+-24]
        cmp rax, r14
        jg lb53
        jmp lb54
lb54:
        mov rdi, rbx
        call C_Node_F_push_up
        jmp end_C_splay_tree_F_build
lb53:
        lea rax, [rbx+48]
        mov rax, qword [rax]
        lea r13, [rax+1*8+8]
        mov rdi, 96
        call malloc
        mov r15, rax
        mov rdi, r15
        call C_Node_F_Node
        mov qword [r13], r15
        lea rax, [rbx+48]
        mov rax, qword [rax]
        lea rax, [rax+1*8+8]
        inc qword [rel V_id_cnt]
        mov rdi, qword [rax]
        mov rsi, 0
        mov rdx, qword [rel V_id_cnt]
        call C_Node_F_init
        lea rax, [rbx+48]
        mov rax, qword [rax]
        lea rax, [rax+1*8+8]
        mov rax, r14
        add rax, 1
        lea rax, [rbx+48]
        mov rax, qword [rax]
        lea rcx, [rax+1*8+8]
        mov rax, r14
        add rax, 1
        mov rdi, r12
        mov rsi, qword [rcx]
        mov rdx, rbx
        mov rcx, rax
        mov rax, [rbp+-24]
        mov r8, rax
        call C_splay_tree_F_build
        jmp lb54
lb51:
        lea rax, [rbx+48]
        mov rax, qword [rax]
        lea r15, [rax+0*8+8]
        mov rdi, 96
        call malloc
        mov rax, rax
        mov [rbp+-16], rax
        mov rax, [rbp+-16]
        mov rdi, rax
        call C_Node_F_Node
        mov rax, [rbp+-16]
        mov qword [r15], rax
        lea rax, [rbx+48]
        mov rax, qword [rax]
        lea rax, [rax+0*8+8]
        inc qword [rel V_id_cnt]
        mov rdi, qword [rax]
        mov rsi, 0
        mov rdx, qword [rel V_id_cnt]
        call C_Node_F_init
        lea rax, [rbx+48]
        mov rax, qword [rax]
        lea rax, [rax+0*8+8]
        mov rax, r14
        sub rax, 1
        lea rax, [rbx+48]
        mov rax, qword [rax]
        lea rcx, [rax+0*8+8]
        mov rax, r14
        sub rax, 1
        mov rdi, r12
        mov rsi, qword [rcx]
        mov rdx, rbx
        mov rcx, r13
        mov r8, rax
        call C_splay_tree_F_build
        jmp lb52
end_C_splay_tree_F_build:
        pop rbx
        pop r15
        pop r13
        pop r14
        pop r12
        mov rsp, rbp
        pop rbp
        ret


C_splay_tree_F_build_tree:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push r14
        push r13
        push rbx
        mov r13, rdx
        mov r12, rsi
        mov rbx, rdi
        mov rdi, 96
        call malloc
        mov r14, rax
        mov rdi, r14
        call C_Node_F_Node
        mov qword [rbx+0], r14
        inc qword [rel V_id_cnt]
        mov rdi, qword [rbx+0]
        mov rsi, 0
        mov rdx, qword [rel V_id_cnt]
        call C_Node_F_init
        mov rdi, rbx
        mov rsi, qword [rbx+0]
        mov rdx, 0
        mov rcx, r12
        mov r8, r13
        call C_splay_tree_F_build
        jmp end_C_splay_tree_F_build_tree
end_C_splay_tree_F_build_tree:
        pop rbx
        pop r13
        pop r14
        pop r12
        mov rsp, rbp
        pop rbp
        ret


C_splay_tree_F_find:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push r14
        push rbx
        mov r12, rsi
        mov rax, rdi
        mov r14, qword [rax+0]
        mov rbx, 0
        lea rax, [r14+48]
        mov rax, qword [rax]
        lea rax, [rax+0*8+8]
        mov rax, qword [rax]
        cmp rax, 0
        jne lb55
        jmp lb56
lb56:
        mov rcx, 1
        jmp lb57
lb57:
        mov rax, rbx
        add rax, rcx
        cmp rax, r12
        jne lb58
        jmp lb65
lb65:
        mov rax, r14
        jmp end_C_splay_tree_F_find
lb58:
        mov rax, rbx
        add rax, rcx
        cmp r12, rax
        jl lb59
        jmp lb60
lb60:
        mov rax, rbx
        add rax, rcx
        mov rbx, rax
        lea rax, [r14+48]
        mov rax, qword [rax]
        lea rax, [rax+1*8+8]
        mov r14, qword [rax]
        jmp lb61
lb61:
        mov rdi, r14
        call C_Node_F_push_down
        lea rax, [r14+48]
        mov rax, qword [rax]
        lea rax, [rax+0*8+8]
        mov rax, qword [rax]
        cmp rax, 0
        jne lb62
        jmp lb63
lb63:
        mov rcx, 1
        jmp lb64
lb64:
        mov rax, rbx
        add rax, rcx
        cmp rax, r12
        jne lb58
        jmp lb65
lb62:
        lea rax, [r14+48]
        mov rax, qword [rax]
        lea rax, [rax+0*8+8]
        mov rax, qword [rax]
        lea rax, [rax+8]
        mov rax, qword [rax]
        add rax, 1
        mov rcx, rax
        jmp lb64
lb59:
        lea rax, [r14+48]
        mov rax, qword [rax]
        lea rax, [rax+0*8+8]
        mov r14, qword [rax]
        jmp lb61
lb55:
        lea rax, [r14+48]
        mov rax, qword [rax]
        lea rax, [rax+0*8+8]
        mov rax, qword [rax]
        lea rax, [rax+8]
        mov rax, qword [rax]
        add rax, 1
        mov rcx, rax
        jmp lb57
end_C_splay_tree_F_find:
        pop rbx
        pop r14
        pop r12
        mov rsp, rbp
        pop rbp
        ret


C_splay_tree_F_dfs:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push r14
        push rbx
        mov r14, rsi
        mov r12, rdi
        mov rbx, 0
        cmp rbx, 2
        jl lb66
        jmp lb69
lb69:
        jmp end_C_splay_tree_F_dfs
lb66:
        lea rax, [r14+48]
        mov rax, qword [rax]
        lea rax, [rax+rbx*8+8]
        mov rax, qword [rax]
        cmp rax, 0
        jne lb67
        jmp lb68
lb68:
        mov rax, rbx
        inc rbx
        cmp rbx, 2
        jl lb66
        jmp lb69
lb67:
        lea rax, [r14+48]
        mov rax, qword [rax]
        lea rax, [rax+rbx*8+8]
        lea rax, [r14+48]
        mov rax, qword [rax]
        lea rax, [rax+rbx*8+8]
        mov rdi, r12
        mov rsi, qword [rax]
        call C_splay_tree_F_dfs
        jmp lb68
end_C_splay_tree_F_dfs:
        pop rbx
        pop r14
        pop r12
        mov rsp, rbp
        pop rbp
        ret


C_splay_tree_F_del:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push r14
        push rbx
        mov rcx, rdx
        mov r12, rsi
        mov rbx, rdi
        mov rax, rcx
        add rax, 1
        mov rax, rcx
        add rax, 1
        mov rdi, rbx
        mov rsi, rax
        call C_splay_tree_F_find
        mov rax, rax
        mov rax, rax
        mov r14, rax
        mov rdi, r14
        mov rsi, 0
        call C_Node_F_rotto
        mov qword [rbx+0], r14
        mov rax, r12
        sub rax, 1
        mov rax, r12
        sub rax, 1
        mov rdi, rbx
        mov rsi, rax
        call C_splay_tree_F_find
        mov rax, rax
        mov rax, rax
        mov r14, rax
        mov rdi, r14
        mov rsi, qword [rbx+0]
        call C_Node_F_rotto
        lea rax, [r14+48]
        mov rax, qword [rax]
        lea rax, [rax+1*8+8]
        mov rax, qword [rax]
        cmp rax, 0
        jne lb70
        jmp lb71
lb71:
        lea rax, [r14+48]
        mov rax, qword [rax]
        lea rax, [rax+1*8+8]
        mov qword [rax], 0
        mov rdi, r14
        mov rsi, 0
        call C_Node_F_rotto
        mov qword [rbx+0], r14
        jmp end_C_splay_tree_F_del
lb70:
        lea rax, [r14+48]
        mov rax, qword [rax]
        lea rax, [rax+1*8+8]
        lea rax, [r14+48]
        mov rax, qword [rax]
        lea rax, [rax+1*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call C_splay_tree_F_dfs
        jmp lb71
end_C_splay_tree_F_del:
        pop rbx
        pop r14
        pop r12
        mov rsp, rbp
        pop rbp
        ret


C_splay_tree_F_change:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push r14
        push r13
        push rbx
        mov r14, rcx
        mov rcx, rdx
        mov r12, rsi
        mov rbx, rdi
        mov rax, rcx
        add rax, 1
        mov rax, rcx
        add rax, 1
        mov rdi, rbx
        mov rsi, rax
        call C_splay_tree_F_find
        mov rax, rax
        mov rax, rax
        mov r13, rax
        mov rdi, r13
        mov rsi, 0
        call C_Node_F_rotto
        mov qword [rbx+0], r13
        mov rax, r12
        sub rax, 1
        mov rax, r12
        sub rax, 1
        mov rdi, rbx
        mov rsi, rax
        call C_splay_tree_F_find
        mov rax, rax
        mov rax, rax
        mov r13, rax
        mov rdi, r13
        mov rsi, qword [rbx+0]
        call C_Node_F_rotto
        lea rax, [r13+48]
        mov rax, qword [rax]
        lea rax, [rax+1*8+8]
        mov r13, qword [rax]
        mov rdi, r13
        call C_Node_F_push_down
        mov rdi, r13
        mov rsi, r14
        call C_Node_F_addtag_ch
        mov rdi, r13
        call C_Node_F_push_down
        mov rdi, r13
        mov rsi, 0
        call C_Node_F_rotto
        mov qword [rbx+0], r13
        jmp end_C_splay_tree_F_change
end_C_splay_tree_F_change:
        pop rbx
        pop r13
        pop r14
        pop r12
        mov rsp, rbp
        pop rbp
        ret


C_splay_tree_F_rol:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push r14
        push rbx
        mov rax, rdx
        mov r12, rsi
        mov rbx, rdi
        mov rcx, rax
        add rcx, 1
        mov rax, rax
        add rax, 1
        mov rdi, rbx
        mov rsi, rax
        call C_splay_tree_F_find
        mov rax, rax
        mov rax, rax
        mov r14, rax
        mov rdi, r14
        mov rsi, 0
        call C_Node_F_rotto
        mov qword [rbx+0], r14
        mov rax, r12
        sub rax, 1
        mov rax, r12
        sub rax, 1
        mov rdi, rbx
        mov rsi, rax
        call C_splay_tree_F_find
        mov rax, rax
        mov rax, rax
        mov r14, rax
        mov rdi, r14
        mov rsi, qword [rbx+0]
        call C_Node_F_rotto
        lea rax, [r14+48]
        mov rax, qword [rax]
        lea rax, [rax+1*8+8]
        mov r14, qword [rax]
        mov rdi, r14
        call C_Node_F_push_down
        mov rdi, r14
        call C_Node_F_addtag_ro
        mov rdi, r14
        call C_Node_F_push_down
        mov rdi, r14
        mov rsi, 0
        call C_Node_F_rotto
        mov qword [rbx+0], r14
        jmp end_C_splay_tree_F_rol
end_C_splay_tree_F_rol:
        pop rbx
        pop r14
        pop r12
        mov rsp, rbp
        pop rbp
        ret


C_splay_tree_F_getsum:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push r14
        push rbx
        mov rcx, rdx
        mov r12, rsi
        mov rbx, rdi
        mov rax, rcx
        add rax, 1
        mov rax, rcx
        add rax, 1
        mov rdi, rbx
        mov rsi, rax
        call C_splay_tree_F_find
        mov rax, rax
        mov rax, rax
        mov r14, rax
        mov rdi, r14
        mov rsi, 0
        call C_Node_F_rotto
        mov qword [rbx+0], r14
        mov rax, r12
        sub rax, 1
        mov rax, r12
        sub rax, 1
        mov rdi, rbx
        mov rsi, rax
        call C_splay_tree_F_find
        mov rax, rax
        mov rax, rax
        mov r14, rax
        mov rdi, r14
        mov rsi, qword [rbx+0]
        call C_Node_F_rotto
        lea rax, [r14+48]
        mov rax, qword [rax]
        lea rax, [rax+1*8+8]
        mov r14, qword [rax]
        mov rdi, r14
        call C_Node_F_push_down
        lea rax, [r14+32]
        mov r12, qword [rax]
        mov rdi, r14
        mov rsi, 0
        call C_Node_F_rotto
        mov qword [rbx+0], r14
        mov rax, r12
        jmp end_C_splay_tree_F_getsum
end_C_splay_tree_F_getsum:
        pop rbx
        pop r14
        pop r12
        mov rsp, rbp
        pop rbp
        ret


C_splay_tree_F_getMax:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push rbx
        mov rbx, rdi
        mov rdi, qword [rbx+0]
        call C_Node_F_push_down
        mov rax, qword [rbx+0]
        lea rax, [rax+40]
        mov rax, qword [rax]
        jmp end_C_splay_tree_F_getMax
end_C_splay_tree_F_getMax:
        pop rbx
        mov rsp, rbp
        pop rbp
        ret


C_splay_tree_F_splay_tree:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rax, rdi
        mov qword [rax+0], 0
        jmp end_C_splay_tree_F_splay_tree
end_C_splay_tree_F_splay_tree:
        mov rsp, rbp
        pop rbp
        ret


F_equ:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rcx, rsi
        mov rax, rdi
        cmp rax, 0
        je lb72
        jmp lb75
lb75:
        cmp rcx, 0
        je lb76
        jmp lb77
lb77:
        lea rax, [rax+72]
        lea rcx, [rcx+72]
        mov rax, qword [rax]
        cmp rax, qword [rcx]
        je lb78
        jmp lb79
lb79:
        mov rax, 0
        jmp lb80
lb80:
        mov rax, rax
        jmp end_F_equ
lb78:
        mov rax, 1
        jmp lb80
lb76:
        mov rax, 0
        jmp end_F_equ
lb72:
        cmp rcx, 0
        je lb73
        jmp lb74
lb74:
        mov rax, 0
        jmp end_F_equ
lb73:
        mov rax, 1
        jmp end_F_equ
end_F_equ:
        mov rsp, rbp
        pop rbp
        ret


F_merge:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push r14
        push r13
        push rbx
        mov rbx, rdx
        mov r12, rsi
        mov r14, rdi
        mov rax, r14
        add rax, 1
        mov rdi, r12
        mov rsi, rax
        call C_splay_tree_F_find
        mov rax, rax
        mov rax, rax
        mov r13, rax
        mov rdi, r13
        mov rsi, 0
        call C_Node_F_rotto
        lea rax, [r12+0]
        mov qword [rax], r13
        mov rdi, r12
        mov rsi, r14
        call C_splay_tree_F_find
        mov rax, rax
        mov rax, rax
        mov r13, rax
        lea rax, [r12+0]
        mov rdi, r13
        mov rsi, qword [rax]
        call C_Node_F_rotto
        lea rax, [r13+48]
        mov rax, qword [rax]
        lea rcx, [rax+1*8+8]
        lea rax, [rbx+0]
        mov rax, qword [rax]
        mov qword [rcx], rax
        lea rax, [rbx+0]
        mov rax, qword [rax]
        lea rax, [rax+88]
        mov qword [rax], r13
        mov rdi, r13
        mov rsi, 0
        call C_Node_F_rotto
        lea rax, [r12+0]
        mov qword [rax], r13
        jmp end_F_merge
end_F_merge:
        pop rbx
        pop r13
        pop r14
        pop r12
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
        call F_getInt
        mov rax, rax
        mov qword [rel V_n], rax
        call F_getInt
        mov rax, rax
        mov qword [rel V_m], rax
        mov rdi, 8
        call malloc
        mov rbx, rax
        mov rdi, rbx
        call C_splay_tree_F_splay_tree
        mov qword [rel A_sp], rbx
        mov rdi, 8
        call malloc
        mov rbx, rax
        mov rdi, rbx
        call C_splay_tree_F_splay_tree
        mov qword [rel A_dintree], rbx
        mov rax, qword [rel A_din]
        lea rcx, [rax+0*8+8]
        mov rax, qword [rel V_INF]
        neg rax
        mov qword [rcx], rax
        mov rax, qword [rel V_n]
        add rax, 1
        mov rcx, qword [rel A_din]
        lea rcx, [rcx+rax*8+8]
        mov rax, qword [rel V_INF]
        neg rax
        mov qword [rcx], rax
        mov r12, 1
        cmp r12, qword [rel V_n]
        jle lb81
        jmp lb82
lb82:
        mov rax, qword [rel V_n]
        add rax, 1
        mov rdi, qword [rel A_sp]
        mov rsi, 0
        mov rdx, rax
        call C_splay_tree_F_build_tree
        mov r12, 1
        cmp r12, qword [rel V_m]
        jle lb83
        jmp lb102
lb102:
        mov rax, 0
        jmp end_main
lb83:
        mov rdi, 256
        call malloc
        mov r13, rax
        call F_getString
        mov rax, rax
        mov rdi, r13
        mov rsi, rax
        call S_strcpy
        mov rdi, r13
        mov rsi, 0
        call S_ord
        mov rbx, rax
        mov rdi, qword [rel A_char_ID]
        mov rsi, 0
        call S_ord
        mov rax, rax
        cmp rbx, rax
        je lb84
        jmp lb87
lb87:
        mov rdi, r13
        mov rsi, 0
        call S_ord
        mov rbx, rax
        mov rdi, qword [rel A_char_ID]
        mov rsi, 1
        call S_ord
        mov rax, rax
        cmp rbx, rax
        je lb88
        jmp lb89
lb89:
        mov rdi, r13
        mov rsi, 0
        call S_ord
        mov rax, rax
        cmp rax, 82
        je lb90
        jmp lb91
lb91:
        mov rdi, r13
        mov rsi, 0
        call S_ord
        mov rax, rax
        cmp rax, 71
        je lb92
        jmp lb96
lb96:
        mov rdi, r13
        mov rsi, 0
        call S_ord
        mov rax, rax
        cmp rax, 77
        je lb97
        jmp lb101
lb101:
        inc r12
        cmp r12, qword [rel V_m]
        jle lb83
        jmp lb102
lb97:
        mov rdi, r13
        mov rsi, 2
        call S_ord
        mov rax, rax
        cmp rax, 75
        je lb98
        jmp lb99
lb99:
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rdi, qword [rel A_sp]
        call C_splay_tree_F_getMax
        mov rax, rax
        mov rax, rax
        mov rdi, rax
        call F_toString
        mov rax, rax
        mov rdi, rbx
        mov rsi, rax
        call S_strcat
        mov rdi, rbx
        mov rsi, S_2
        call S_strcat
        mov rdi, rbx
        call F_print
        jmp lb100
lb100:
        jmp lb101
lb98:
        call F_getInt
        mov rax, rax
        mov rbx, rax
        call F_getInt
        mov rax, rax
        mov r14, rax
        call F_getInt
        mov rax, rax
        mov rcx, rax
        mov rax, rbx
        add rax, 1
        mov rdx, rbx
        add rdx, r14
        mov rdi, qword [rel A_sp]
        mov rsi, rax
        mov rdx, rdx
        mov rcx, rcx
        call C_splay_tree_F_change
        jmp lb100
lb92:
        call F_getInt
        mov rax, rax
        mov rbx, rax
        call F_getInt
        mov rax, rax
        mov rax, rax
        cmp rax, 0
        jg lb93
        jmp lb94
lb94:
        mov rdi, S_1
        call F_print
        jmp lb95
lb95:
        jmp lb96
lb93:
        mov rcx, rbx
        add rcx, 1
        mov rdx, rbx
        add rdx, rax
        mov rdi, qword [rel A_sp]
        mov rsi, rcx
        mov rdx, rdx
        call C_splay_tree_F_getsum
        mov rax, rax
        mov rax, rax
        mov rdi, rax
        call F_toString
        mov rax, rax
        mov rdi, rax
        call F_println
        jmp lb95
lb90:
        call F_getInt
        mov rax, rax
        mov rbx, rax
        call F_getInt
        mov rax, rax
        mov rdx, rax
        mov rax, rbx
        add rax, 1
        mov rcx, rbx
        add rcx, rdx
        mov rdi, qword [rel A_sp]
        mov rsi, rax
        mov rdx, rcx
        call C_splay_tree_F_rol
        jmp lb91
lb88:
        call F_getInt
        mov rax, rax
        mov rbx, rax
        call F_getInt
        mov rax, rax
        mov rax, rax
        mov rcx, rbx
        add rcx, 1
        mov rdx, rbx
        add rdx, rax
        mov rdi, qword [rel A_sp]
        mov rsi, rcx
        mov rdx, rdx
        call C_splay_tree_F_del
        jmp lb89
lb84:
        call F_getInt
        mov rax, rax
        mov r15, rax
        call F_getInt
        mov rax, rax
        mov r14, rax
        mov rbx, 1
        cmp rbx, r14
        jle lb85
        jmp lb86
lb86:
        mov rdi, qword [rel A_dintree]
        mov rsi, 1
        mov rdx, r14
        call C_splay_tree_F_build_tree
        mov rax, r15
        add rax, 1
        mov rdi, rax
        mov rsi, qword [rel A_sp]
        mov rdx, qword [rel A_dintree]
        call F_merge
        jmp lb87
lb85:
        mov rax, qword [rel A_din]
        lea rax, [rax+rbx*8+8]
        mov [rbp+-8], rax
        call F_getInt
        mov rax, rax
        mov rcx, [rbp+-8]
        mov qword [rcx], rax
        inc rbx
        cmp rbx, r14
        jle lb85
        jmp lb86
lb81:
        mov rax, qword [rel A_din]
        lea rbx, [rax+r12*8+8]
        call F_getInt
        mov rax, rax
        mov qword [rbx], rax
        mov rax, r12
        inc r12
        cmp r12, qword [rel V_n]
        jle lb81
        jmp lb82
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
        mov qword [rel V_INF], 1000000000
        mov qword [rel V_nMax], 4000010
        mov qword [rel V_id_cnt], 0
        mov rax, qword [rel V_nMax]
        sal rax, 3
        mov rax, rax
        add rax, 8
        mov rdi, rax
        call malloc
        mov rcx, rax
        lea rax, [rcx]
        mov rdx, qword [rel V_nMax]
        mov qword [rax], rdx
        mov qword [rel A_din], rcx
        mov rdi, 256
        call malloc
        mov qword [rel A_char_ID], rax
        mov qword [rel A_char_ID], S_0
        jmp end___init
end___init:
        mov rsp, rbp
        pop rbp
        ret


SECTION .data    align=8

SECTION .bss     align=8
V_INF:
         resq 1
V_nMax:
         resq 1
V_n:
         resq 1
V_m:
         resq 1
V_id_cnt:
         resq 1
A_din:
         resq 1
A_sp:
         resq 1
A_dintree:
         resq 1
A_char_ID:
         resq 256

SECTION .rodata
S_0: 
         db 49H, 44H, 00H
S_1: 
         db 30H, 0AH, 00H
S_2: 
         db 0AH, 00H

L_021:
        db 25H, 6CH, 64H, 00H

L_022:
        db 25H, 73H, 00H


