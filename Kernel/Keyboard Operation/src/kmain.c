#include "fb.h"
#include "gdt.h"
#include "pic.h"
#include "idt.h"
#include "interrupt.h"
#include "common.h"

void kinit() {
    disable_interrupts();
    gdt_init();
    pic_init();
    idt_init();
    enable_interrupts();
}

void print_hello() {
    int i;

    fb_clear();
    for (i = 0; i < 5; i++) {
        fb_puts("Sunyoung Park!\n");
    }
    fb_puts("Sunyoung Park!\n");
}

int kmain(void *mboot, unsigned int magic_number)
{
    UNUSED_ARGUMENT(mboot);
    UNUSED_ARGUMENT(magic_number);

    kinit();
    print_hello();

    return 0xDEADBEEF;
}
