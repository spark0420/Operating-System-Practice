; this functions as a bridge between the bootloader (GRUB) and the kernel
; the main purpose of this file it to set up symbols for the bootloader
; and jump to the kmain function in the kernel

; based on http://wiki.osdev.org/Bare_bones#NASM

global loader                           ; the entry point for the linker

; setting up the multiboot headers for GRUB
MODULEALIGN equ 1<<0                    ; align loaded modules on page 
                                        ; boundaries
MEMINFO     equ 1<<1                    ; provide memory map
FLAGS       equ MODULEALIGN | MEMINFO   ; the multiboot flag field
MAGIC       equ 0x1BADB002              ; magic number for bootloader to 
                                        ; find the header
CHECKSUM    equ -(MAGIC + FLAGS)        ; checksum required

section .text

align 4
    dd MAGIC
    dd FLAGS
    dd CHECKSUM

; reserve initial stack space
STACKSIZE equ 0x4000                    ; 16kB

loader:
    mov esp, stack+STACKSIZE            ; sets up the stack pointer
    push eax                            ; eax contains the MAGIC number
    push ebx                            ; ebx contains the multiboot data 
                                        ; structure
    cli                                 ; disable interrupts

    push 0x00000048 ; H
    push 0x00000320 ; line 5 column 0
    call fb_write
    pop ebp
    pop ebp

    push 0x0000006F ; o
    push 0x00000322 ; line 5 colume 1
    call fb_write
    pop ebp
    pop ebp

    push 0x0000006C ; l
    push 0x00000324 ; line 5 colume 2
    call fb_write
    pop ebp
    pop ebp

    push 0x0000006C ; l
    push 0x00000326 ; line 5 colume 3
    call fb_write
    pop ebp
    pop ebp

    push 0x0000006F ; o
    push 0x00000328 ; line 5 colume 4
    call fb_write
    pop ebp
    pop ebp

hang:
    jmp hang                            ; loop forever

fb_write:
    push   ebp             ; Store the current stack frame pointer
    mov    ebp, esp        ; Preserve ESP into EBP for argument references
    mov    eax, [ebp+8]    ; Move the contents of EBP+4 into EAX
                           ; EBP should be pointing at the 32 bit RIP.
                           ; EBP+4 should be the pushed parameter.
    mov    ecx, [ebp+12]   ; grab the character
    mov    BYTE [eax+0xb8000],cl   ; eax is the position on the Frame Buffer
                                   ; cl is the character to display
    mov    BYTE [eax+0xb8001],0xf  ; This is the format to display 
                                   ; (bright white on black.)
    mov  esp, ebp          ; Restore the stack and ebp
    pop  ebp
    ret    

section .bss

align 4
stack:
    resb STACKSIZE                      ; reserve memory for stack on 
                                        ; doubleworded memory
