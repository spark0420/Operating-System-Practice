; this functions as a bridge between the bootloader (GRUB) and the kernel
; the main purpose of this file it to set up symbols for the bootloader
; and jump to the kmain function in the kernel

; based on http://wiki.osdev.org/Bare_bones#NASM

global loader                           ; the entry point for the linker
global outb                             ; outb

extern kmain                            ; kmain is defined in kmain.c

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

outb:
    mov al, [esp + 8]    ; move the data to be sent into the al register
    mov dx, [esp + 4]    ; move the address of the I/O port into the dx register
    out dx, al           ; send the data to the I/O port
    ret                  ; return to the calling function

loader:
    mov esp, stack+STACKSIZE            ; sets up the stack pointer
    push eax                            ; eax contains the MAGIC number
    push ebx                            ; ebx contains the multiboot data 
                                        ; structure
    cli                                 ; disable interrupts
    call kmain                          ; call the kernel main function

hang:
    jmp hang                            ; loop forever

section .bss

align 4
stack:
    resb STACKSIZE                      ; reserve memory for stack on 
                                        ; doubleworded memory
