default rel

global A_s
global A_c
global A_co
global A_a2q
global A_a2b
global F_digt
global F_s2
global F_c2
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




F_digt:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        mov rax, rdi
        cmp rax, 0
        je lb4
        jmp lb5
lb5:
        cmp rax, 1
        je lb6
        jmp lb7
lb7:
        cmp rax, 2
        je lb8
        jmp lb9
lb9:
        cmp rax, 3
        je lb10
        jmp lb11
lb11:
        cmp rax, 4
        je lb12
        jmp lb13
lb13:
        cmp rax, 5
        je lb14
        jmp lb15
lb15:
        cmp rax, 6
        je lb16
        jmp lb17
lb17:
        cmp rax, 7
        je lb18
        jmp lb19
lb19:
        cmp rax, 8
        je lb20
        jmp lb21
lb21:
        cmp rax, 9
        je lb22
        jmp lb23
lb23:
        jmp end_F_digt
lb22:
        mov rax, S_12
        jmp end_F_digt
lb20:
        mov rax, S_11
        jmp end_F_digt
lb18:
        mov rax, S_10
        jmp end_F_digt
lb16:
        mov rax, S_9
        jmp end_F_digt
lb14:
        mov rax, S_8
        jmp end_F_digt
lb12:
        mov rax, S_7
        jmp end_F_digt
lb10:
        mov rax, S_6
        jmp end_F_digt
lb8:
        mov rax, S_5
        jmp end_F_digt
lb6:
        mov rax, S_4
        jmp end_F_digt
lb4:
        mov rax, S_3
        jmp end_F_digt
end_F_digt:
        mov rsp, rbp
        pop rbp
        ret


F_s2:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push rbx
        mov r12, rdi
        cmp r12, 9
        jle lb24
        jmp lb25
lb25:
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rdi, rbx
        mov rsi, S_15
        call S_strcat
        mov rcx, 10
        mov rax, r12
        cqo
        idiv rcx
        mov rax, rax
        mov rdi, rax
        call F_digt
        mov rax, rax
        mov rdi, rbx
        mov rsi, rax
        call S_strcat
        mov rcx, 10
        mov rax, r12
        cqo
        idiv rcx
        mov rax, rdx
        mov rdi, rax
        call F_digt
        mov rax, rax
        mov rdi, rbx
        mov rsi, rax
        call S_strcat
        mov rdi, rbx
        mov rsi, S_16
        call S_strcat
        mov rax, rbx
        jmp end_F_s2
lb24:
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rdi, rbx
        mov rsi, S_13
        call S_strcat
        mov rdi, r12
        call F_digt
        mov rax, rax
        mov rdi, rbx
        mov rsi, rax
        call S_strcat
        mov rdi, rbx
        mov rsi, S_14
        call S_strcat
        mov rax, rbx
        jmp end_F_s2
end_F_s2:
        pop rbx
        pop r12
        mov rsp, rbp
        pop rbp
        ret


F_c2:
        push rbp
        mov rbp, rsp
        sub rsp, 0
        push r12
        push rbx
        mov r12, rdi
        cmp r12, 9
        jle lb26
        jmp lb27
lb27:
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rdi, rbx
        mov rsi, S_19
        call S_strcat
        mov rcx, 10
        mov rax, r12
        cqo
        idiv rcx
        mov rax, rax
        mov rdi, rax
        call F_digt
        mov rax, rax
        mov rdi, rbx
        mov rsi, rax
        call S_strcat
        mov rcx, 10
        mov rax, r12
        cqo
        idiv rcx
        mov rax, rdx
        mov rdi, rax
        call F_digt
        mov rax, rax
        mov rdi, rbx
        mov rsi, rax
        call S_strcat
        mov rdi, rbx
        mov rsi, S_20
        call S_strcat
        mov rax, rbx
        jmp end_F_c2
lb26:
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rdi, rbx
        mov rsi, S_17
        call S_strcat
        mov rdi, r12
        call F_digt
        mov rax, rax
        mov rdi, rbx
        mov rsi, rax
        call S_strcat
        mov rdi, rbx
        mov rsi, S_18
        call S_strcat
        mov rax, rbx
        jmp end_F_c2
end_F_c2:
        pop rbx
        pop r12
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
        push r15
        push rbx
        call __init
        mov r14, 0
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, qword [rax]
        mov rsi, S_21
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+1*8+8]
        mov rdi, qword [rax]
        mov rsi, S_22
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+2*8+8]
        mov rdi, qword [rax]
        mov rsi, S_23
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+3*8+8]
        mov rdi, qword [rax]
        mov rsi, S_24
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+4*8+8]
        mov rdi, qword [rax]
        mov rsi, S_25
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+5*8+8]
        mov rdi, qword [rax]
        mov rsi, S_26
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+6*8+8]
        mov rdi, qword [rax]
        mov rsi, S_27
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, qword [rax]
        mov rsi, S_28
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, qword [rax]
        mov rsi, S_29
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+9*8+8]
        mov rdi, qword [rax]
        mov rsi, S_30
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+10*8+8]
        mov rdi, qword [rax]
        mov rsi, S_31
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+11*8+8]
        mov rdi, qword [rax]
        mov rsi, S_32
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+12*8+8]
        mov rdi, qword [rax]
        mov rsi, S_33
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+13*8+8]
        mov rdi, qword [rax]
        mov rsi, S_34
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+14*8+8]
        mov rdi, qword [rax]
        mov rsi, S_35
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+15*8+8]
        mov rdi, qword [rax]
        mov rsi, S_36
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+16*8+8]
        mov rdi, qword [rax]
        mov rsi, S_37
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+17*8+8]
        mov rdi, qword [rax]
        mov rsi, S_38
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+18*8+8]
        mov rdi, qword [rax]
        mov rsi, S_39
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+19*8+8]
        mov rdi, qword [rax]
        mov rsi, S_40
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+20*8+8]
        mov rdi, qword [rax]
        mov rsi, S_41
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+21*8+8]
        mov rdi, qword [rax]
        mov rsi, S_42
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+22*8+8]
        mov rdi, qword [rax]
        mov rsi, S_43
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+23*8+8]
        mov rdi, qword [rax]
        mov rsi, S_44
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+24*8+8]
        mov rdi, qword [rax]
        mov rsi, S_45
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+25*8+8]
        mov rdi, qword [rax]
        mov rsi, S_46
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, qword [rax]
        mov rsi, S_47
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+27*8+8]
        mov rdi, qword [rax]
        mov rsi, S_48
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, qword [rax]
        mov rsi, S_49
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+29*8+8]
        mov rdi, qword [rax]
        mov rsi, S_50
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+30*8+8]
        mov rdi, qword [rax]
        mov rsi, S_51
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+31*8+8]
        mov rdi, qword [rax]
        mov rsi, S_52
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+32*8+8]
        mov rdi, qword [rax]
        mov rsi, S_53
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+33*8+8]
        mov rdi, qword [rax]
        mov rsi, S_54
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+34*8+8]
        mov rdi, qword [rax]
        mov rsi, S_55
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+35*8+8]
        mov rdi, qword [rax]
        mov rsi, S_56
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+36*8+8]
        mov rdi, qword [rax]
        mov rsi, S_57
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+37*8+8]
        mov rdi, qword [rax]
        mov rsi, S_58
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+38*8+8]
        mov rdi, qword [rax]
        mov rsi, S_59
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+39*8+8]
        mov rdi, qword [rax]
        mov rsi, S_60
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+40*8+8]
        mov rdi, qword [rax]
        mov rsi, S_61
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+41*8+8]
        mov rdi, qword [rax]
        mov rsi, S_62
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+42*8+8]
        mov rdi, qword [rax]
        mov rsi, S_63
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+43*8+8]
        mov rdi, qword [rax]
        mov rsi, S_64
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+44*8+8]
        mov rdi, qword [rax]
        mov rsi, S_65
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+45*8+8]
        mov rdi, qword [rax]
        mov rsi, S_66
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+46*8+8]
        mov rdi, qword [rax]
        mov rsi, S_67
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+47*8+8]
        mov rdi, qword [rax]
        mov rsi, S_68
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+48*8+8]
        mov rdi, qword [rax]
        mov rsi, S_69
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+49*8+8]
        mov rdi, qword [rax]
        mov rsi, S_70
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+50*8+8]
        mov rdi, qword [rax]
        mov rsi, S_71
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+51*8+8]
        mov rdi, qword [rax]
        mov rsi, S_72
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+52*8+8]
        mov rdi, qword [rax]
        mov rsi, S_73
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+53*8+8]
        mov rdi, qword [rax]
        mov rsi, S_74
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+54*8+8]
        mov rdi, qword [rax]
        mov rsi, S_75
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+55*8+8]
        mov rdi, qword [rax]
        mov rsi, S_76
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+56*8+8]
        mov rdi, qword [rax]
        mov rsi, S_77
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+57*8+8]
        mov rdi, qword [rax]
        mov rsi, S_78
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+58*8+8]
        mov rdi, qword [rax]
        mov rsi, S_79
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+59*8+8]
        mov rdi, qword [rax]
        mov rsi, S_80
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+60*8+8]
        mov rdi, qword [rax]
        mov rsi, S_81
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+61*8+8]
        mov rdi, qword [rax]
        mov rsi, S_82
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+62*8+8]
        mov rdi, qword [rax]
        mov rsi, S_83
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+63*8+8]
        mov rdi, qword [rax]
        mov rsi, S_84
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+64*8+8]
        mov rdi, qword [rax]
        mov rsi, S_85
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+65*8+8]
        mov rdi, qword [rax]
        mov rsi, S_86
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+66*8+8]
        mov rdi, qword [rax]
        mov rsi, S_87
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+67*8+8]
        mov rdi, qword [rax]
        mov rsi, S_88
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+68*8+8]
        mov rdi, qword [rax]
        mov rsi, S_89
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+69*8+8]
        mov rdi, qword [rax]
        mov rsi, S_90
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+70*8+8]
        mov rdi, qword [rax]
        mov rsi, S_91
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, qword [rax]
        mov rsi, S_92
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+72*8+8]
        mov rdi, qword [rax]
        mov rsi, S_93
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+73*8+8]
        mov rdi, qword [rax]
        mov rsi, S_94
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+74*8+8]
        mov rdi, qword [rax]
        mov rsi, S_95
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+75*8+8]
        mov rdi, qword [rax]
        mov rsi, S_96
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, qword [rax]
        mov rsi, S_97
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+77*8+8]
        mov rdi, qword [rax]
        mov rsi, S_98
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+78*8+8]
        mov rdi, qword [rax]
        mov rsi, S_99
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+79*8+8]
        mov rdi, qword [rax]
        mov rsi, S_100
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, qword [rax]
        mov rsi, S_101
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, qword [rax]
        mov rsi, S_102
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, qword [rax]
        mov rsi, S_103
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+83*8+8]
        mov rdi, qword [rax]
        mov rsi, S_104
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+84*8+8]
        mov rdi, qword [rax]
        mov rsi, S_105
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+85*8+8]
        mov rdi, qword [rax]
        mov rsi, S_106
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+86*8+8]
        mov rdi, qword [rax]
        mov rsi, S_107
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+87*8+8]
        mov rdi, qword [rax]
        mov rsi, S_108
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+88*8+8]
        mov rdi, qword [rax]
        mov rsi, S_109
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+89*8+8]
        mov rdi, qword [rax]
        mov rsi, S_110
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+90*8+8]
        mov rdi, qword [rax]
        mov rsi, S_111
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+91*8+8]
        mov rdi, qword [rax]
        mov rsi, S_112
        call S_strcpy
        mov rax, qword [rel A_c]
        lea rax, [rax+92*8+8]
        mov rdi, qword [rax]
        mov rsi, S_113
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+0*8+8]
        mov rdi, qword [rax]
        mov rsi, S_114
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+1*8+8]
        mov rdi, qword [rax]
        mov rsi, S_115
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+2*8+8]
        mov rdi, qword [rax]
        mov rsi, S_116
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+3*8+8]
        mov rdi, qword [rax]
        mov rsi, S_117
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+4*8+8]
        mov rdi, qword [rax]
        mov rsi, S_118
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+5*8+8]
        mov rdi, qword [rax]
        mov rsi, S_119
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+6*8+8]
        mov rdi, qword [rax]
        mov rsi, S_120
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+7*8+8]
        mov rdi, qword [rax]
        mov rsi, S_121
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+8*8+8]
        mov rdi, qword [rax]
        mov rsi, S_122
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+9*8+8]
        mov rdi, qword [rax]
        mov rsi, S_123
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+10*8+8]
        mov rdi, qword [rax]
        mov rsi, S_124
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+11*8+8]
        mov rdi, qword [rax]
        mov rsi, S_125
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+12*8+8]
        mov rdi, qword [rax]
        mov rsi, S_126
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+13*8+8]
        mov rdi, qword [rax]
        mov rsi, S_127
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+14*8+8]
        mov rdi, qword [rax]
        mov rsi, S_128
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+15*8+8]
        mov rdi, qword [rax]
        mov rsi, S_129
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+16*8+8]
        mov rdi, qword [rax]
        mov rsi, S_130
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+17*8+8]
        mov rdi, qword [rax]
        mov rsi, S_131
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+18*8+8]
        mov rdi, qword [rax]
        mov rsi, S_132
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+19*8+8]
        mov rdi, qword [rax]
        mov rsi, S_133
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+20*8+8]
        mov rdi, qword [rax]
        mov rsi, S_134
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+21*8+8]
        mov rdi, qword [rax]
        mov rsi, S_135
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+22*8+8]
        mov rdi, qword [rax]
        mov rsi, S_136
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+23*8+8]
        mov rdi, qword [rax]
        mov rsi, S_137
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+24*8+8]
        mov rdi, qword [rax]
        mov rsi, S_138
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+25*8+8]
        mov rdi, qword [rax]
        mov rsi, S_139
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+26*8+8]
        mov rdi, qword [rax]
        mov rsi, S_140
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+27*8+8]
        mov rdi, qword [rax]
        mov rsi, S_141
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+28*8+8]
        mov rdi, qword [rax]
        mov rsi, S_142
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+29*8+8]
        mov rdi, qword [rax]
        mov rsi, S_143
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+30*8+8]
        mov rdi, qword [rax]
        mov rsi, S_144
        call S_strcpy
        mov rax, qword [rel A_s]
        lea rax, [rax+31*8+8]
        mov rdi, qword [rax]
        mov rsi, S_145
        call S_strcpy
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+69*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+66*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+69*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+86*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+89*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+68*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+86*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+15*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+67*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+83*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+15*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+68*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+86*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+16*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+67*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+83*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+16*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+68*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+86*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+17*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+67*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+83*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+17*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+68*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+86*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+18*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+67*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+83*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+18*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+68*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+86*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+19*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+67*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+83*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+19*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+68*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+86*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+20*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+67*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+83*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+20*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+68*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+86*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+21*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+67*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+83*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+21*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+68*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+86*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+22*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+67*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+83*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+22*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+68*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+86*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+23*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+67*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+83*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+23*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+68*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+86*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+24*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+67*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+83*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+24*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rax, qword [rel A_c]
        lea rax, [rax+91*8+8]
        mov rdi, qword [rax]
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+69*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+58*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+59*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+67*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+85*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+69*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+58*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+17*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+20*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+21*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+59*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+69*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+58*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+59*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+65*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+67*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+85*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+69*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+58*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+17*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+20*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+21*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+59*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+69*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+17*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+89*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+68*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+27*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+24*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+67*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+83*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+58*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+10*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+66*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+69*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+10*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+59*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+67*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+83*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+58*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+10*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+66*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+69*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+14*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+16*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+15*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+10*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+66*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+69*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+4*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+16*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+15*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+10*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+59*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rax, qword [rel A_c]
        lea rax, [rax+91*8+8]
        mov rdi, qword [rax]
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+69*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+65*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+17*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+65*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+65*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+89*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+68*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+65*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+65*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+27*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+24*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+67*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+83*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+65*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+58*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+10*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+66*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+69*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+65*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+65*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+10*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+59*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+67*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+83*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+65*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+58*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+10*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+66*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+69*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+65*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+65*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+14*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+16*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+15*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+10*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+66*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+69*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+7*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+65*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+65*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+4*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+16*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+15*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+8*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+10*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+59*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rax, qword [rel A_c]
        lea rax, [rax+91*8+8]
        mov rdi, qword [rax]
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+69*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+65*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+77*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+69*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+63*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+17*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+79*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2b]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rdi, 256
        call malloc
        mov rbx, rax
        mov rax, qword [rel A_c]
        lea rax, [rax+81*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+82*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+80*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+71*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+76*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+69*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+0*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+63*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+17*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+64*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+28*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2b]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2b]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rax, qword [rel A_c]
        lea rax, [rax+26*8+8]
        mov rdi, rbx
        mov rsi, qword [rax]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rax, qword [rel A_s]
        lea rax, [rax+0*8+8]
        mov rdi, qword [rax]
        call F_println
        mov r14, 0
        cmp r14, 93
        jl lb28
        jmp lb29
lb29:
        mov r14, 0
        cmp r14, 32
        jl lb30
        jmp lb31
lb31:
        mov r14, 1
        cmp r14, 32
        jl lb32
        jmp lb33
lb33:
        mov rax, 0
        jmp end_main
lb32:
        mov rax, qword [rel A_s]
        lea rax, [rax+r14*8+8]
        mov rdi, qword [rax]
        call F_println
        mov rax, r14
        inc r14
        cmp r14, 32
        jl lb32
        jmp lb33
lb30:
        mov rdi, r14
        call F_s2
        mov r13, rax
        mov rdi, r13
        call S_strlen
        mov r12, rax
        mov rdi, qword [rel A_a2q]
        call S_strlen
        mov rax, rax
        mov rbx, rax
        add rbx, r12
        mov rax, qword [rel A_s]
        lea r15, [rax+r14*8+8]
        mov rdi, qword [r15]
        call S_strlen
        mov rax, rax
        mov r12, rax
        add r12, rbx
        mov rdi, qword [rel A_a2q]
        call S_strlen
        mov rax, rax
        mov rbx, rax
        add rbx, r12
        mov rdi, qword [rel A_co]
        call S_strlen
        mov rax, rax
        mov rax, rax
        add rax, rbx
        inc rax
        mov rdi, rax
        call malloc
        mov rbx, rax
        mov rdi, rbx
        mov rsi, r13
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [r15]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_co]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rax, r14
        inc r14
        cmp r14, 32
        jl lb30
        jmp lb31
lb28:
        mov rdi, r14
        call F_c2
        mov r13, rax
        mov rdi, r13
        call S_strlen
        mov rbx, rax
        mov rdi, qword [rel A_a2q]
        call S_strlen
        mov rax, rax
        mov r12, rax
        add r12, rbx
        mov rax, qword [rel A_c]
        lea r15, [rax+r14*8+8]
        mov rdi, qword [r15]
        call S_strlen
        mov rax, rax
        mov rbx, rax
        add rbx, r12
        mov rdi, qword [rel A_a2q]
        call S_strlen
        mov rax, rax
        mov r12, rax
        add r12, rbx
        mov rdi, qword [rel A_co]
        call S_strlen
        mov rax, rax
        mov rax, rax
        add rax, r12
        inc rax
        mov rdi, rax
        call malloc
        mov rbx, rax
        mov rdi, rbx
        mov rsi, r13
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [r15]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_a2q]
        call S_strcat
        mov rdi, rbx
        mov rsi, qword [rel A_co]
        call S_strcat
        mov rdi, rbx
        call F_println
        mov rax, r14
        inc r14
        cmp r14, 93
        jl lb28
        jmp lb29
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
        push r12
        push rbx
        mov rdi, 65792
        call malloc
        mov rbx, rax
        lea rax, [rbx]
        mov rcx, 256
        mov qword [rax], rcx
        mov r12, 0
        cmp r12, 256
        jl lb0
        jmp lb1
lb1:
        mov qword [rel A_s], rbx
        mov rdi, 65792
        call malloc
        mov rbx, rax
        lea rax, [rbx]
        mov rcx, 256
        mov qword [rax], rcx
        mov r12, 0
        cmp r12, 256
        jl lb2
        jmp lb3
lb3:
        mov qword [rel A_c], rbx
        mov rdi, 256
        call malloc
        mov qword [rel A_co], rax
        mov qword [rel A_co], S_0
        mov rdi, 256
        call malloc
        mov qword [rel A_a2q], rax
        mov qword [rel A_a2q], S_1
        mov rdi, 256
        call malloc
        mov qword [rel A_a2b], rax
        mov qword [rel A_a2b], S_2
        jmp end___init
lb2:
        mov rdi, 256
        call malloc
        mov rcx, rax
        lea rax, [rbx+r12*8+8]
        mov qword [rax], rcx
        mov r12, r12
        add r12, 1
        cmp r12, 256
        jl lb2
        jmp lb3
lb0:
        mov rdi, 256
        call malloc
        mov rcx, rax
        lea rax, [rbx+r12*8+8]
        mov qword [rax], rcx
        mov r12, r12
        add r12, 1
        cmp r12, 256
        jl lb0
        jmp lb1
end___init:
        pop rbx
        pop r12
        mov rsp, rbp
        pop rbp
        ret


SECTION .data    align=8

SECTION .bss     align=8
A_s:
         resq 1
A_c:
         resq 1
A_co:
         resq 256
A_a2q:
         resq 256
A_a2b:
         resq 256

SECTION .rodata
S_0: 
         db 3BH, 00H
S_1: 
         db 22H, 00H
S_2: 
         db 5CH, 00H
S_3: 
         db 30H, 00H
S_4: 
         db 31H, 00H
S_5: 
         db 32H, 00H
S_6: 
         db 33H, 00H
S_7: 
         db 34H, 00H
S_8: 
         db 35H, 00H
S_9: 
         db 36H, 00H
S_10: 
         db 37H, 00H
S_11: 
         db 38H, 00H
S_12: 
         db 39H, 00H
S_13: 
         db 73H, 5BH, 00H
S_14: 
         db 5DH, 3DH, 00H
S_15: 
         db 73H, 5BH, 00H
S_16: 
         db 5DH, 3DH, 00H
S_17: 
         db 63H, 5BH, 00H
S_18: 
         db 5DH, 3DH, 00H
S_19: 
         db 63H, 5BH, 00H
S_20: 
         db 5DH, 3DH, 00H
S_21: 
         db 20H, 00H
S_22: 
         db 21H, 00H
S_23: 
         db 23H, 00H
S_24: 
         db 24H, 00H
S_25: 
         db 25H, 00H
S_26: 
         db 26H, 00H
S_27: 
         db 27H, 00H
S_28: 
         db 28H, 00H
S_29: 
         db 29H, 00H
S_30: 
         db 2AH, 00H
S_31: 
         db 2BH, 00H
S_32: 
         db 2CH, 00H
S_33: 
         db 2DH, 00H
S_34: 
         db 2EH, 00H
S_35: 
         db 2FH, 00H
S_36: 
         db 30H, 00H
S_37: 
         db 31H, 00H
S_38: 
         db 32H, 00H
S_39: 
         db 33H, 00H
S_40: 
         db 34H, 00H
S_41: 
         db 35H, 00H
S_42: 
         db 36H, 00H
S_43: 
         db 37H, 00H
S_44: 
         db 38H, 00H
S_45: 
         db 39H, 00H
S_46: 
         db 3AH, 00H
S_47: 
         db 3BH, 00H
S_48: 
         db 3CH, 00H
S_49: 
         db 3DH, 00H
S_50: 
         db 3EH, 00H
S_51: 
         db 3FH, 00H
S_52: 
         db 40H, 00H
S_53: 
         db 41H, 00H
S_54: 
         db 42H, 00H
S_55: 
         db 43H, 00H
S_56: 
         db 44H, 00H
S_57: 
         db 45H, 00H
S_58: 
         db 46H, 00H
S_59: 
         db 47H, 00H
S_60: 
         db 48H, 00H
S_61: 
         db 49H, 00H
S_62: 
         db 4AH, 00H
S_63: 
         db 4BH, 00H
S_64: 
         db 4CH, 00H
S_65: 
         db 4DH, 00H
S_66: 
         db 4EH, 00H
S_67: 
         db 4FH, 00H
S_68: 
         db 50H, 00H
S_69: 
         db 51H, 00H
S_70: 
         db 52H, 00H
S_71: 
         db 53H, 00H
S_72: 
         db 54H, 00H
S_73: 
         db 55H, 00H
S_74: 
         db 56H, 00H
S_75: 
         db 57H, 00H
S_76: 
         db 58H, 00H
S_77: 
         db 59H, 00H
S_78: 
         db 5AH, 00H
S_79: 
         db 5BH, 00H
S_80: 
         db 5DH, 00H
S_81: 
         db 5EH, 00H
S_82: 
         db 5FH, 00H
S_83: 
         db 60H, 00H
S_84: 
         db 61H, 00H
S_85: 
         db 62H, 00H
S_86: 
         db 63H, 00H
S_87: 
         db 64H, 00H
S_88: 
         db 65H, 00H
S_89: 
         db 66H, 00H
S_90: 
         db 67H, 00H
S_91: 
         db 68H, 00H
S_92: 
         db 69H, 00H
S_93: 
         db 6AH, 00H
S_94: 
         db 6BH, 00H
S_95: 
         db 6CH, 00H
S_96: 
         db 6DH, 00H
S_97: 
         db 6EH, 00H
S_98: 
         db 6FH, 00H
S_99: 
         db 70H, 00H
S_100: 
         db 71H, 00H
S_101: 
         db 72H, 00H
S_102: 
         db 73H, 00H
S_103: 
         db 74H, 00H
S_104: 
         db 75H, 00H
S_105: 
         db 76H, 00H
S_106: 
         db 77H, 00H
S_107: 
         db 78H, 00H
S_108: 
         db 79H, 00H
S_109: 
         db 7AH, 00H
S_110: 
         db 7BH, 00H
S_111: 
         db 7CH, 00H
S_112: 
         db 7DH, 00H
S_113: 
         db 7EH, 00H
S_114: 
         db 69H, 6EH, 74H, 20H, 6DH, 61H, 69H, 6EH, 28H, 29H, 7BH, 69H, 6EH, 74H, 20H, 69H, 3DH, 30H, 3BH, 2FH, 2FH, 20H, 51H, 75H, 69H, 6EH, 65H, 20H, 69H, 73H, 20H, 61H, 20H, 61H, 20H, 70H, 72H, 6FH, 67H, 72H, 61H, 6DH, 20H, 74H, 68H, 61H, 74H, 20H, 70H, 72H, 6FH, 64H, 75H, 63H, 65H, 73H, 20H, 69H, 74H, 73H, 20H, 73H, 6FH, 75H, 72H, 63H, 65H, 20H, 63H, 6FH, 64H, 65H, 20H, 61H, 73H, 20H, 6FH, 75H, 74H, 70H, 75H, 74H, 2EH, 00H
S_115: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 36H, 39H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 63H, 5BH, 36H, 36H, 5DH, 2BH, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 36H, 39H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 63H, 5BH, 38H, 36H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 38H, 39H, 5DH, 29H, 3BH, 00H
S_116: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 36H, 38H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 38H, 36H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 31H, 35H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 36H, 37H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 33H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 31H, 35H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 36H, 5DH, 29H, 3BH, 00H
S_117: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 36H, 38H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 38H, 36H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 31H, 36H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 36H, 37H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 33H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 31H, 36H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 36H, 5DH, 29H, 3BH, 00H
S_118: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 36H, 38H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 38H, 36H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 31H, 37H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 36H, 37H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 33H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 31H, 37H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 36H, 5DH, 29H, 3BH, 00H
S_119: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 36H, 38H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 38H, 36H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 31H, 38H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 36H, 37H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 33H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 31H, 38H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 36H, 5DH, 29H, 3BH, 00H
S_120: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 36H, 38H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 38H, 36H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 31H, 39H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 36H, 37H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 33H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 31H, 39H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 36H, 5DH, 29H, 3BH, 00H
S_121: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 36H, 38H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 38H, 36H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 32H, 30H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 36H, 37H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 33H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 30H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 36H, 5DH, 29H, 3BH, 00H
S_122: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 36H, 38H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 38H, 36H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 32H, 31H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 36H, 37H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 33H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 31H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 36H, 5DH, 29H, 3BH, 00H
S_123: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 36H, 38H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 38H, 36H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 32H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 36H, 37H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 33H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 32H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 36H, 5DH, 29H, 3BH, 00H
S_124: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 36H, 38H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 38H, 36H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 32H, 33H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 36H, 37H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 33H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 33H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 36H, 5DH, 29H, 3BH, 00H
S_125: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 36H, 38H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 38H, 36H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 32H, 34H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 36H, 37H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 33H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 34H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 36H, 5DH, 29H, 3BH, 00H
S_126: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 39H, 31H, 5DH, 29H, 3BH, 00H
S_127: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 36H, 39H, 5DH, 2BH, 63H, 5BH, 35H, 38H, 5DH, 2BH, 63H, 5BH, 35H, 39H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 36H, 37H, 5DH, 2BH, 63H, 5BH, 38H, 35H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 36H, 39H, 5DH, 2BH, 63H, 5BH, 35H, 38H, 5DH, 2BH, 63H, 5BH, 31H, 37H, 5DH, 2BH, 63H, 5BH, 32H, 30H, 5DH, 2BH, 63H, 5BH, 32H, 31H, 5DH, 2BH, 63H, 5BH, 35H, 39H, 5DH, 2BH, 63H, 5BH, 32H, 36H, 5DH, 29H, 3BH, 00H
S_128: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 36H, 39H, 5DH, 2BH, 63H, 5BH, 35H, 38H, 5DH, 2BH, 63H, 5BH, 35H, 39H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 63H, 5BH, 36H, 35H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 36H, 37H, 5DH, 2BH, 63H, 5BH, 38H, 35H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 36H, 39H, 5DH, 2BH, 63H, 5BH, 35H, 38H, 5DH, 2BH, 63H, 5BH, 31H, 37H, 5DH, 2BH, 63H, 5BH, 32H, 30H, 5DH, 2BH, 63H, 5BH, 32H, 31H, 5DH, 2BH, 63H, 5BH, 35H, 39H, 5DH, 2BH, 63H, 5BH, 32H, 36H, 5DH, 29H, 3BH, 00H
S_129: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 36H, 39H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 31H, 37H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 38H, 39H, 5DH, 29H, 3BH, 00H
S_130: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 36H, 38H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 32H, 37H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 32H, 34H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 36H, 37H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 33H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 35H, 38H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 31H, 30H, 5DH, 2BH, 63H, 5BH, 36H, 36H, 5DH, 2BH, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 36H, 39H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 31H, 30H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 35H, 39H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 36H, 5DH, 29H, 3BH, 00H
S_131: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 36H, 37H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 33H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 35H, 38H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 31H, 30H, 5DH, 2BH, 63H, 5BH, 36H, 36H, 5DH, 2BH, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 36H, 39H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 31H, 34H, 5DH, 2BH, 63H, 5BH, 31H, 36H, 5DH, 2BH, 63H, 5BH, 31H, 35H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 31H, 30H, 5DH, 2BH, 63H, 5BH, 36H, 36H, 5DH, 2BH, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 36H, 39H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 34H, 5DH, 2BH, 63H, 5BH, 31H, 36H, 5DH, 2BH, 63H, 5BH, 31H, 35H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 31H, 30H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 35H, 39H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 36H, 5DH, 29H, 3BH, 00H
S_132: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 39H, 31H, 5DH, 29H, 3BH, 00H
S_133: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 36H, 39H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 63H, 5BH, 36H, 35H, 5DH, 2BH, 63H, 5BH, 31H, 37H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 63H, 5BH, 36H, 35H, 5DH, 2BH, 63H, 5BH, 36H, 35H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 38H, 39H, 5DH, 29H, 3BH, 00H
S_134: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 36H, 38H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 36H, 35H, 5DH, 2BH, 63H, 5BH, 36H, 35H, 5DH, 2BH, 63H, 5BH, 32H, 37H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 63H, 5BH, 32H, 34H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 36H, 37H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 33H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 36H, 35H, 5DH, 2BH, 63H, 5BH, 35H, 38H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 31H, 30H, 5DH, 2BH, 63H, 5BH, 36H, 36H, 5DH, 2BH, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 36H, 39H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 36H, 35H, 5DH, 2BH, 63H, 5BH, 36H, 35H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 31H, 30H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 35H, 39H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 36H, 5DH, 29H, 3BH, 00H
S_135: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 36H, 37H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 33H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 36H, 35H, 5DH, 2BH, 63H, 5BH, 35H, 38H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 31H, 30H, 5DH, 2BH, 63H, 5BH, 36H, 36H, 5DH, 2BH, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 36H, 39H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 36H, 35H, 5DH, 2BH, 63H, 5BH, 36H, 35H, 5DH, 2BH, 63H, 5BH, 31H, 34H, 5DH, 2BH, 63H, 5BH, 31H, 36H, 5DH, 2BH, 63H, 5BH, 31H, 35H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 31H, 30H, 5DH, 2BH, 63H, 5BH, 36H, 36H, 5DH, 2BH, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 36H, 39H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 37H, 5DH, 2BH, 63H, 5BH, 36H, 35H, 5DH, 2BH, 63H, 5BH, 36H, 35H, 5DH, 2BH, 63H, 5BH, 34H, 5DH, 2BH, 63H, 5BH, 31H, 36H, 5DH, 2BH, 63H, 5BH, 31H, 35H, 5DH, 2BH, 63H, 5BH, 38H, 5DH, 2BH, 63H, 5BH, 31H, 30H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 35H, 39H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 36H, 5DH, 29H, 3BH, 00H
S_136: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 39H, 31H, 5DH, 29H, 3BH, 00H
S_137: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 36H, 39H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 63H, 5BH, 36H, 35H, 5DH, 2BH, 63H, 5BH, 37H, 37H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 36H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 36H, 5DH, 29H, 3BH, 00H
S_138: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 36H, 39H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 63H, 5BH, 36H, 33H, 5DH, 2BH, 63H, 5BH, 31H, 37H, 5DH, 2BH, 63H, 5BH, 37H, 39H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 61H, 32H, 62H, 2BH, 61H, 32H, 71H, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 36H, 5DH, 29H, 3BH, 00H
S_139: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 5BH, 38H, 31H, 5DH, 2BH, 63H, 5BH, 38H, 32H, 5DH, 2BH, 63H, 5BH, 38H, 30H, 5DH, 2BH, 63H, 5BH, 37H, 31H, 5DH, 2BH, 63H, 5BH, 37H, 36H, 5DH, 2BH, 63H, 5BH, 36H, 39H, 5DH, 2BH, 63H, 5BH, 30H, 5DH, 2BH, 63H, 5BH, 36H, 33H, 5DH, 2BH, 63H, 5BH, 31H, 37H, 5DH, 2BH, 63H, 5BH, 36H, 34H, 5DH, 2BH, 63H, 5BH, 32H, 38H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 61H, 32H, 62H, 2BH, 61H, 32H, 62H, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 32H, 36H, 5DH, 29H, 3BH, 00H
S_140: 
         db 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 73H, 5BH, 30H, 5DH, 29H, 3BH, 00H
S_141: 
         db 66H, 6FH, 72H, 28H, 69H, 3DH, 30H, 3BH, 69H, 3CH, 39H, 33H, 3BH, 69H, 2BH, 2BH, 29H, 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 63H, 32H, 28H, 69H, 29H, 2BH, 61H, 32H, 71H, 2BH, 63H, 5BH, 69H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 6FH, 29H, 3BH, 00H
S_142: 
         db 66H, 6FH, 72H, 28H, 69H, 3DH, 30H, 3BH, 69H, 3CH, 33H, 32H, 3BH, 69H, 2BH, 2BH, 29H, 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 73H, 32H, 28H, 69H, 29H, 2BH, 61H, 32H, 71H, 2BH, 73H, 5BH, 69H, 5DH, 2BH, 61H, 32H, 71H, 2BH, 63H, 6FH, 29H, 3BH, 00H
S_143: 
         db 66H, 6FH, 72H, 28H, 69H, 3DH, 31H, 3BH, 69H, 3CH, 33H, 32H, 3BH, 69H, 2BH, 2BH, 29H, 70H, 72H, 69H, 6EH, 74H, 6CH, 6EH, 28H, 73H, 5BH, 69H, 5DH, 29H, 3BH, 00H
S_144: 
         db 72H, 65H, 74H, 75H, 72H, 6EH, 20H, 30H, 3BH, 00H
S_145: 
         db 7DH, 00H

L_021:
        db 25H, 6CH, 64H, 00H

L_022:
        db 25H, 73H, 00H


