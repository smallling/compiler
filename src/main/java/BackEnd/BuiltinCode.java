package main.java.BackEnd;


public class BuiltinCode {
    static public String text = "\n" +
            "SECTION .text   6\n" +
            "\n" +
            "ALIGN   16\n" +
            "\n" +
            "F_print:\n" +
            "        lea     rdx, [rdi+8H]\n" +
            "        mov     esi, L_032\n" +
            "        mov     edi, 1\n" +
            "        xor     eax, eax\n" +
            "        jmp     __printf_chk\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "ALIGN   16\n" +
            "\n" +
            "F_println:\n" +
            "        add     rdi, 8\n" +
            "        jmp     puts\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "ALIGN   8\n" +
            "\n" +
            "F_getString:\n" +
            "        push    rbp\n" +
            "        mov     esi, __buffer.3442\n" +
            "        mov     edi, L_032\n" +
            "        xor     eax, eax\n" +
            "        push    rbx\n" +
            "        mov     ebx, __buffer.3442\n" +
            "        sub     rsp, 8\n" +
            "        call    __isoc99_scanf\n" +
            "L_016:  mov     edx, dword [rbx]\n" +
            "        add     rbx, 4\n" +
            "        lea     eax, [rdx-1010101H]\n" +
            "        not     edx\n" +
            "        and     eax, edx\n" +
            "        and     eax, 80808080H\n" +
            "        jz      L_016\n" +
            "        mov     edx, eax\n" +
            "        shr     edx, 16\n" +
            "        test    eax, 8080H\n" +
            "        cmove   eax, edx\n" +
            "        lea     rdx, [rbx+2H]\n" +
            "        cmove   rbx, rdx\n" +
            "        add     al, al\n" +
            "        sbb     rbx, 3\n" +
            "        sub     rbx, __buffer.3442\n" +
            "        lea     edi, [rbx+8H]\n" +
            "        movsxd  rdi, edi\n" +
            "        call    malloc\n" +
            "        mov     rbp, rax\n" +
            "        lea     rdx, [rbx+1H]\n" +
            "        movsxd  rax, ebx\n" +
            "        lea     rdi, [rbp+8H]\n" +
            "        mov     qword [rbp], rax\n" +
            "        mov     esi, __buffer.3442\n" +
            "        call    memcpy\n" +
            "        add     rsp, 8\n" +
            "        mov     rax, rbp\n" +
            "        pop     rbx\n" +
            "        pop     rbp\n" +
            "        ret\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "ALIGN   16\n" +
            "\n" +
            "F_getInt:\n" +
            "        sub     rsp, 24\n" +
            "        mov     edi, L_033\n" +
            "        xor     eax, eax\n" +
            "        lea     rsi, [rsp+8H]\n" +
            "        call    __isoc99_scanf\n" +
            "        mov     rax, qword [rsp+8H]\n" +
            "        add     rsp, 24\n" +
            "        ret\n" +
            "\n" +
            "\n" +
            "        nop\n" +
            "\n" +
            "ALIGN   16\n" +
            "F_toString:\n" +
            "        push    rbp\n" +
            "        mov     rbp, rdi\n" +
            "        mov     edi, 32\n" +
            "        push    rbx\n" +
            "        sub     rsp, 8\n" +
            "        call    malloc\n" +
            "        lea     rdi, [rax+8H]\n" +
            "        mov     rbx, rax\n" +
            "        mov     r8, rbp\n" +
            "        mov     ecx, L_033\n" +
            "        mov     edx, 24\n" +
            "        mov     esi, 1\n" +
            "        xor     eax, eax\n" +
            "        call    __sprintf_chk\n" +
            "        cdqe\n" +
            "        mov     qword [rbx], rax\n" +
            "        add     rsp, 8\n" +
            "        mov     rax, rbx\n" +
            "        pop     rbx\n" +
            "        pop     rbp\n" +
            "        ret\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "ALIGN   16\n" +
            "\n" +
            "S_strlen:\n" +
            "        mov     rax, qword [rdi]\n" +
            "        ret\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "ALIGN   16\n" +
            "\n" +
            "S_substring:\n" +
            "        push    r15\n" +
            "        push    r14\n" +
            "        push    r13\n" +
            "        movsxd  r13, esi\n" +
            "        push    r12\n" +
            "        mov     r12d, edx\n" +
            "        sub     r12d, r13d\n" +
            "        push    rbp\n" +
            "        mov     rbp, rdi\n" +
            "        lea     edi, [r12+0AH]\n" +
            "        push    rbx\n" +
            "        lea     ebx, [r12+1H]\n" +
            "        movsxd  rdi, edi\n" +
            "        sub     rsp, 8\n" +
            "        call    malloc\n" +
            "        movsxd  rdx, ebx\n" +
            "        test    ebx, ebx\n" +
            "        mov     qword [rax], rdx\n" +
            "        jle     L_018\n" +
            "        lea     edi, [r13+8H]\n" +
            "        add     r13, rbp\n" +
            "        lea     rcx, [rax+18H]\n" +
            "        lea     rdx, [r13+8H]\n" +
            "        lea     rsi, [r13+18H]\n" +
            "        cmp     rcx, rdx\n" +
            "        lea     rdx, [rax+8H]\n" +
            "        setbe   cl\n" +
            "        cmp     rsi, rdx\n" +
            "        setbe   dl\n" +
            "        or      cl, dl\n" +
            "        je      L_019\n" +
            "        cmp     ebx, 15\n" +
            "        jbe     L_019\n" +
            "        mov     esi, ebx\n" +
            "        xor     edx, edx\n" +
            "        xor     r8d, r8d\n" +
            "        shr     esi, 4\n" +
            "        mov     ecx, esi\n" +
            "        shl     ecx, 4\n" +
            "L_017:  movdqu  xmm0, oword [r13+rdx+8H]\n" +
            "        add     r8d, 1\n" +
            "        movdqu  oword [rax+rdx+8H], xmm0\n" +
            "        add     rdx, 16\n" +
            "        cmp     r8d, esi\n" +
            "        jc      L_017\n" +
            "        cmp     ebx, ecx\n" +
            "        je      L_018\n" +
            "        lea     edx, [rdi+rcx]\n" +
            "        lea     r13d, [rcx+8H]\n" +
            "        movsxd  rdx, edx\n" +
            "        movzx   esi, byte [rbp+rdx]\n" +
            "        movsxd  rdx, r13d\n" +
            "        mov     byte [rax+rdx], sil\n" +
            "        lea     edx, [rcx+1H]\n" +
            "        cmp     ebx, edx\n" +
            "        jle     L_018\n" +
            "        add     edx, edi\n" +
            "        lea     r11d, [rcx+9H]\n" +
            "        movsxd  rdx, edx\n" +
            "        movzx   esi, byte [rbp+rdx]\n" +
            "        movsxd  rdx, r11d\n" +
            "        mov     byte [rax+rdx], sil\n" +
            "        lea     edx, [rcx+2H]\n" +
            "        cmp     ebx, edx\n" +
            "        jle     L_018\n" +
            "        add     edx, edi\n" +
            "        lea     r10d, [rcx+0AH]\n" +
            "        movsxd  rdx, edx\n" +
            "        movzx   esi, byte [rbp+rdx]\n" +
            "        movsxd  rdx, r10d\n" +
            "        mov     byte [rax+rdx], sil\n" +
            "        lea     edx, [rcx+3H]\n" +
            "        cmp     ebx, edx\n" +
            "        jle     L_018\n" +
            "        add     edx, edi\n" +
            "        lea     r9d, [rcx+0BH]\n" +
            "        movsxd  rdx, edx\n" +
            "        movzx   esi, byte [rbp+rdx]\n" +
            "        movsxd  rdx, r9d\n" +
            "        mov     byte [rax+rdx], sil\n" +
            "        lea     edx, [rcx+4H]\n" +
            "        cmp     ebx, edx\n" +
            "        jle     L_018\n" +
            "        add     edx, edi\n" +
            "        lea     r8d, [rcx+0CH]\n" +
            "        movsxd  rdx, edx\n" +
            "        movzx   esi, byte [rbp+rdx]\n" +
            "        movsxd  rdx, r8d\n" +
            "        mov     byte [rax+rdx], sil\n" +
            "        lea     edx, [rcx+5H]\n" +
            "        cmp     ebx, edx\n" +
            "        jle     L_018\n" +
            "        add     edx, edi\n" +
            "        lea     esi, [rcx+0DH]\n" +
            "        movsxd  rdx, edx\n" +
            "        movzx   r14d, byte [rbp+rdx]\n" +
            "        movsxd  rdx, esi\n" +
            "        mov     byte [rax+rdx], r14b\n" +
            "        lea     edx, [rcx+6H]\n" +
            "        cmp     ebx, edx\n" +
            "        jle     L_018\n" +
            "        add     edx, edi\n" +
            "        movsxd  rdx, edx\n" +
            "        movzx   r15d, byte [rbp+rdx]\n" +
            "        lea     edx, [rcx+0EH]\n" +
            "        movsxd  r14, edx\n" +
            "        mov     byte [rax+r14], r15b\n" +
            "        lea     r14d, [rcx+7H]\n" +
            "        cmp     ebx, r14d\n" +
            "        jle     L_018\n" +
            "        add     r14d, edi\n" +
            "        cmp     ebx, r13d\n" +
            "        movsxd  r14, r14d\n" +
            "        movzx   r15d, byte [rbp+r14]\n" +
            "        lea     r14d, [rcx+0FH]\n" +
            "        movsxd  r14, r14d\n" +
            "        mov     byte [rax+r14], r15b\n" +
            "        jle     L_018\n" +
            "        add     r13d, edi\n" +
            "        cmp     ebx, r11d\n" +
            "        movsxd  r13, r13d\n" +
            "        movzx   r14d, byte [rbp+r13]\n" +
            "        lea     r13d, [rcx+10H]\n" +
            "        movsxd  r13, r13d\n" +
            "        mov     byte [rax+r13], r14b\n" +
            "        jle     L_018\n" +
            "        add     r11d, edi\n" +
            "        cmp     ebx, r10d\n" +
            "        movsxd  r11, r11d\n" +
            "        movzx   r13d, byte [rbp+r11]\n" +
            "        lea     r11d, [rcx+11H]\n" +
            "        movsxd  r11, r11d\n" +
            "        mov     byte [rax+r11], r13b\n" +
            "        jle     L_018\n" +
            "        add     r10d, edi\n" +
            "        cmp     ebx, r9d\n" +
            "        movsxd  r10, r10d\n" +
            "        movzx   r11d, byte [rbp+r10]\n" +
            "        lea     r10d, [rcx+12H]\n" +
            "        movsxd  r10, r10d\n" +
            "        mov     byte [rax+r10], r11b\n" +
            "        jle     L_018\n" +
            "        add     r9d, edi\n" +
            "        cmp     ebx, r8d\n" +
            "        movsxd  r9, r9d\n" +
            "        movzx   r10d, byte [rbp+r9]\n" +
            "        lea     r9d, [rcx+13H]\n" +
            "        movsxd  r9, r9d\n" +
            "        mov     byte [rax+r9], r10b\n" +
            "        jle     L_018\n" +
            "        add     r8d, edi\n" +
            "        cmp     ebx, esi\n" +
            "        movsxd  r8, r8d\n" +
            "        movzx   r9d, byte [rbp+r8]\n" +
            "        lea     r8d, [rcx+14H]\n" +
            "        movsxd  r8, r8d\n" +
            "        mov     byte [rax+r8], r9b\n" +
            "        jle     L_018\n" +
            "        add     esi, edi\n" +
            "        cmp     ebx, edx\n" +
            "        movsxd  rsi, esi\n" +
            "        movzx   r8d, byte [rbp+rsi]\n" +
            "        lea     esi, [rcx+15H]\n" +
            "        movsxd  rsi, esi\n" +
            "        mov     byte [rax+rsi], r8b\n" +
            "        jle     L_018\n" +
            "        add     edx, edi\n" +
            "        add     ecx, 22\n" +
            "        movsxd  rdx, edx\n" +
            "        movsxd  rcx, ecx\n" +
            "        movzx   edx, byte [rbp+rdx]\n" +
            "        mov     byte [rax+rcx], dl\n" +
            "L_018:  add     r12d, 9\n" +
            "        movsxd  r12, r12d\n" +
            "        mov     byte [rax+r12], 0\n" +
            "        add     rsp, 8\n" +
            "        pop     rbx\n" +
            "        pop     rbp\n" +
            "        pop     r12\n" +
            "        pop     r13\n" +
            "        pop     r14\n" +
            "        pop     r15\n" +
            "        ret\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "ALIGN   16\n" +
            "L_019:  movsxd  rdi, edi\n" +
            "        xor     ecx, ecx\n" +
            "        add     rbp, rdi\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "ALIGN   16\n" +
            "L_020:  movzx   edx, byte [rbp+rcx]\n" +
            "        mov     byte [rax+rcx+8H], dl\n" +
            "        add     rcx, 1\n" +
            "        cmp     ebx, ecx\n" +
            "        jg      L_020\n" +
            "        jmp     L_018\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "ALIGN   16\n" +
            "\n" +
            "S_parseInt:\n" +
            "        movsx   edx, byte [rdi+8H]\n" +
            "        cmp     dl, 45\n" +
            "        jz      L_024\n" +
            "        lea     rcx, [rdi+8H]\n" +
            "        xor     edi, edi\n" +
            "L_021:  lea     eax, [rdx-30H]\n" +
            "        cmp     al, 9\n" +
            "        mov     eax, 0\n" +
            "        ja      L_023\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "ALIGN   8\n" +
            "L_022:  sub     edx, 48\n" +
            "        lea     rax, [rax+rax*4]\n" +
            "        add     rcx, 1\n" +
            "        movsxd  rdx, edx\n" +
            "        lea     rax, [rdx+rax*2]\n" +
            "        movsx   edx, byte [rcx]\n" +
            "        lea     esi, [rdx-30H]\n" +
            "        cmp     sil, 9\n" +
            "        jbe     L_022\n" +
            "L_023:  mov     rdx, rax\n" +
            "        neg     rdx\n" +
            "        test    edi, edi\n" +
            "        cmovne  rax, rdx\n" +
            "        ret\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "ALIGN   8\n" +
            "L_024:  lea     rcx, [rdi+9H]\n" +
            "        movsx   edx, byte [rdi+9H]\n" +
            "        mov     edi, 1\n" +
            "        jmp     L_021\n" +
            "\n" +
            "\n" +
            "        nop\n" +
            "\n" +
            "ALIGN   16\n" +
            "S_ord:\n" +
            "        movsx   rax, byte [rdi+rsi+8H]\n" +
            "        ret\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "ALIGN   16\n" +
            "\n" +
            "S_strcat:\n" +
            "        push    r15\n" +
            "        push    r14\n" +
            "        push    r13\n" +
            "        push    r12\n" +
            "        mov     r12, rsi\n" +
            "        push    rbp\n" +
            "        mov     rbp, rdi\n" +
            "        push    rbx\n" +
            "        sub     rsp, 8\n" +
            "        mov     rbx, qword [rdi]\n" +
            "        mov     r13, qword [rsi]\n" +
            "        lea     r14, [rbx+r13]\n" +
            "        lea     rdi, [r14+9H]\n" +
            "        call    malloc\n" +
            "        test    rbx, rbx\n" +
            "        mov     qword [rax], r14\n" +
            "        jle     L_026\n" +
            "        lea     rcx, [rbp+8H]\n" +
            "        lea     rdx, [rax+18H]\n" +
            "        lea     rsi, [rbp+18H]\n" +
            "        cmp     rcx, rdx\n" +
            "        lea     rdx, [rax+8H]\n" +
            "        setae   cl\n" +
            "        cmp     rsi, rdx\n" +
            "        setbe   dl\n" +
            "        or      cl, dl\n" +
            "        je      L_029\n" +
            "        cmp     rbx, 15\n" +
            "        jbe     L_029\n" +
            "        mov     rsi, rbx\n" +
            "        xor     ecx, ecx\n" +
            "        xor     edi, edi\n" +
            "        shr     rsi, 4\n" +
            "        mov     rdx, rsi\n" +
            "        shl     rdx, 4\n" +
            "L_025:  movdqu  xmm0, oword [rbp+rcx+8H]\n" +
            "        add     rdi, 1\n" +
            "        movdqu  oword [rax+rcx+8H], xmm0\n" +
            "        add     rcx, 16\n" +
            "        cmp     rsi, rdi\n" +
            "        ja      L_025\n" +
            "        cmp     rbx, rdx\n" +
            "        je      L_026\n" +
            "        lea     r14d, [rdx+8H]\n" +
            "        movsxd  r14, r14d\n" +
            "        movzx   ecx, byte [rbp+r14]\n" +
            "        mov     byte [rax+r14], cl\n" +
            "        lea     ecx, [rdx+1H]\n" +
            "        movsxd  rcx, ecx\n" +
            "        cmp     rbx, rcx\n" +
            "        jle     L_026\n" +
            "        lea     r10d, [rdx+9H]\n" +
            "        movsxd  rcx, r10d\n" +
            "        movzx   esi, byte [rbp+rcx]\n" +
            "        mov     byte [rax+rcx], sil\n" +
            "        lea     ecx, [rdx+2H]\n" +
            "        movsxd  rcx, ecx\n" +
            "        cmp     rbx, rcx\n" +
            "        jle     L_026\n" +
            "        lea     r9d, [rdx+0AH]\n" +
            "        movsxd  rcx, r9d\n" +
            "        movzx   esi, byte [rbp+rcx]\n" +
            "        mov     byte [rax+rcx], sil\n" +
            "        lea     ecx, [rdx+3H]\n" +
            "        movsxd  rcx, ecx\n" +
            "        cmp     rbx, rcx\n" +
            "        jle     L_026\n" +
            "        lea     r8d, [rdx+0BH]\n" +
            "        movsxd  rcx, r8d\n" +
            "        movzx   esi, byte [rbp+rcx]\n" +
            "        mov     byte [rax+rcx], sil\n" +
            "        lea     ecx, [rdx+4H]\n" +
            "        movsxd  rcx, ecx\n" +
            "        cmp     rbx, rcx\n" +
            "        jle     L_026\n" +
            "        lea     edi, [rdx+0CH]\n" +
            "        movsxd  rcx, edi\n" +
            "        movzx   esi, byte [rbp+rcx]\n" +
            "        mov     byte [rax+rcx], sil\n" +
            "        lea     ecx, [rdx+5H]\n" +
            "        movsxd  rcx, ecx\n" +
            "        cmp     rbx, rcx\n" +
            "        jle     L_026\n" +
            "        lea     esi, [rdx+0DH]\n" +
            "        movsxd  rcx, esi\n" +
            "        movzx   r11d, byte [rbp+rcx]\n" +
            "        mov     byte [rax+rcx], r11b\n" +
            "        lea     ecx, [rdx+6H]\n" +
            "        movsxd  rcx, ecx\n" +
            "        cmp     rbx, rcx\n" +
            "        jle     L_026\n" +
            "        lea     ecx, [rdx+0EH]\n" +
            "        movsxd  r11, ecx\n" +
            "        movzx   r15d, byte [rbp+r11]\n" +
            "        mov     byte [rax+r11], r15b\n" +
            "        lea     r11d, [rdx+7H]\n" +
            "        movsxd  r11, r11d\n" +
            "        cmp     rbx, r11\n" +
            "        jle     L_026\n" +
            "        lea     r11d, [rdx+0FH]\n" +
            "        cmp     rbx, r14\n" +
            "        movsxd  r11, r11d\n" +
            "        movzx   r15d, byte [rbp+r11]\n" +
            "        mov     byte [rax+r11], r15b\n" +
            "        jle     L_026\n" +
            "        lea     r11d, [rdx+10H]\n" +
            "        movsxd  r10, r10d\n" +
            "        cmp     rbx, r10\n" +
            "        movsxd  r11, r11d\n" +
            "        movzx   r14d, byte [rbp+r11]\n" +
            "        mov     byte [rax+r11], r14b\n" +
            "        jle     L_026\n" +
            "        lea     r10d, [rdx+11H]\n" +
            "        movsxd  r9, r9d\n" +
            "        cmp     rbx, r9\n" +
            "        movsxd  r10, r10d\n" +
            "        movzx   r11d, byte [rbp+r10]\n" +
            "        mov     byte [rax+r10], r11b\n" +
            "        jle     L_026\n" +
            "        lea     r9d, [rdx+12H]\n" +
            "        movsxd  r8, r8d\n" +
            "        cmp     rbx, r8\n" +
            "        movsxd  r9, r9d\n" +
            "        movzx   r10d, byte [rbp+r9]\n" +
            "        mov     byte [rax+r9], r10b\n" +
            "        jle     L_026\n" +
            "        lea     r8d, [rdx+13H]\n" +
            "        movsxd  rdi, edi\n" +
            "        cmp     rbx, rdi\n" +
            "        movsxd  r8, r8d\n" +
            "        movzx   r9d, byte [rbp+r8]\n" +
            "        mov     byte [rax+r8], r9b\n" +
            "        jle     L_026\n" +
            "        lea     edi, [rdx+14H]\n" +
            "        movsxd  rsi, esi\n" +
            "        cmp     rbx, rsi\n" +
            "        movsxd  rdi, edi\n" +
            "        movzx   r8d, byte [rbp+rdi]\n" +
            "        mov     byte [rax+rdi], r8b\n" +
            "        jle     L_026\n" +
            "        lea     esi, [rdx+15H]\n" +
            "        movsxd  rcx, ecx\n" +
            "        cmp     rbx, rcx\n" +
            "        movsxd  rsi, esi\n" +
            "        movzx   edi, byte [rbp+rsi]\n" +
            "        mov     byte [rax+rsi], dil\n" +
            "        jle     L_026\n" +
            "        add     edx, 22\n" +
            "        movsxd  rdx, edx\n" +
            "        movzx   ecx, byte [rbp+rdx]\n" +
            "        mov     byte [rax+rdx], cl\n" +
            "L_026:  test    r13, r13\n" +
            "        jle     L_031\n" +
            "        lea     rsi, [r13+1H]\n" +
            "        add     rbx, 8\n" +
            "        mov     edx, 1\n" +
            "        xor     ecx, ecx\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "ALIGN   8\n" +
            "L_027:  movzx   edi, byte [r12+rdx+7H]\n" +
            "        add     rcx, rax\n" +
            "        mov     byte [rcx+rbx], dil\n" +
            "        mov     rcx, rdx\n" +
            "        add     rdx, 1\n" +
            "        cmp     rdx, rsi\n" +
            "        jnz     L_027\n" +
            "L_028:  add     r13, rax\n" +
            "        mov     byte [r13+rbx], 0\n" +
            "        add     rsp, 8\n" +
            "        pop     rbx\n" +
            "        pop     rbp\n" +
            "        pop     r12\n" +
            "        pop     r13\n" +
            "        pop     r14\n" +
            "        pop     r15\n" +
            "        ret\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "ALIGN   8\n" +
            "L_029:  xor     edx, edx\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "ALIGN   8\n" +
            "L_030:  movzx   ecx, byte [rbp+rdx+8H]\n" +
            "        mov     byte [rax+rdx+8H], cl\n" +
            "        add     rdx, 1\n" +
            "        cmp     rbx, rdx\n" +
            "        jnz     L_030\n" +
            "        jmp     L_026\n" +
            "\n" +
            "L_031:  add     rbx, 8\n" +
            "        jmp     L_028\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "ALIGN   16\n" +
            "\n" +
            "S_strcmp:\n" +
            "        sub     rsp, 8\n" +
            "        add     rsi, 8\n" +
            "        add     rdi, 8\n" +
            "        call    strcmp\n" +
            "        add     rsp, 8\n" +
            "        cdqe\n" +
            "        ret\n" +
            "\n" +
            "\n" +
            "\n" +
            "SECTION .data   \n" +
            "\n" +
            "\n" +
            "\n" +
            "__buffer.3442:\n" +
            "        resb    1048576\n" +
            "\n" +
            "\n" +
            "\n" +
            "SECTION .rodata.str1.1 \n" +
            "\n" +
            "L_032:\n" +
            "        db 25H, 73H, 00H\n" +
            "\n" +
            "L_033:\n" +
            "        db 25H, 6CH, 64H, 00H";
}
