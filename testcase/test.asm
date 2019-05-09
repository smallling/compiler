global main

SECTION .text

main:
        push rbp
        mov rbp, rsp
        jmp end_main
        sub rsp, 0
        mov rdx, 6
        mov rcx, 7
        mov rax, 0
        cmp rdx, 5
        jg lb1
        jmp lb0
lb0:
        cmp rcx, 6
        jl lb1
        jmp lb2
lb2:
        mov rax, 20
        jmp lb3
lb3:
        mov rax, rax
        jmp end_main
lb1:
        mov rax, 10
        jmp lb3
end_main:
        mov rsp, rbp
        pop rbp
        ret
