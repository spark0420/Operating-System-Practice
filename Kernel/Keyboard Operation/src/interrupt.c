#include "interrupt.h"
#include "stdint.h"
#include "fb.h"
#include "pic.h"
#include "keyboard.h"
#include "common.h"

struct irq_info {
	uint32_t idt_index;
	uint32_t error_code;
} __attribute__((packed));
typedef struct irq_info irq_info_t;

struct cpu_state {
	uint32_t edi;
	uint32_t esi;
	uint32_t ebp;
	uint32_t esp;
	uint32_t ebx;
	uint32_t edx;
	uint32_t ecx;
	uint32_t eax;
} __attribute__((packed));
typedef struct cpu_state cpu_state_t;

void print_keyboard_input(void)
{
    uint8_t ch = kbd_scan_code_to_ascii(kbd_read_scan_code());
    if (ch == 8) {
        fb_backspace();
    } else if (ch != 0) {
        fb_putb(ch);
    }
}

void interrupt_handler(cpu_state_t state, irq_info_t info)
{
    UNUSED_ARGUMENT(state);

    if (info.idt_index == KEYBOARD_INTERRUPT_INDEX) {
        print_keyboard_input();
    }

    if (info.idt_index == TIMER_INTERRUPT_INDEX) {
        // Handle timer interrupt.
    }

    if (info.idt_index >= PIC1_START && 
        info.idt_index < (PIC1_START + PIC_NUM_IRQS)) {
        pic_acknowledge();
    }
}
