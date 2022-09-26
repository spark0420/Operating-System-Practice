OBJECTS = obj/io.o obj/loader.o obj/kmain.o obj/fb.o obj/gdt.o obj/gdt_asm.o src/interrupt.o src/pic.o src/keyboard.o obj/idt.o obj/interrupt_asm.o obj/idt_asm.o src/timer.o
CC = gcc
CFLAGS = -O2 -m32 -nostdlib -nostdinc -fno-builtin -fno-stack-protector \
	-nostartfiles -nodefaultlibs -Wall -Wextra -c
LDFLAGS = -T link.ld -melf_i386
AS = nasm
ASFLAGS = -f elf

all: kernel.elf

obj:
	mkdir -p obj

kernel.elf: $(OBJECTS)
	ld $(LDFLAGS) $(OBJECTS) -o kernel.elf

os.iso: kernel.elf
	cp kernel.elf iso/boot/kernel.elf
	genisoimage -R                              \
                -b boot/grub/stage2_eltorito    \
                -no-emul-boot                   \
                -boot-load-size 4               \
                -A os                           \
                -input-charset utf8             \
                -quiet                          \
                -boot-info-table                \
                -o os.iso                       \
                iso

floppy: kernel
	./create_floppy.sh

image: kernel
	./create_image.sh

run: os.iso
	qemu-system-i386 -boot d -cdrom os.iso

obj/%.o: src/%.c obj
	$(CC) $(CFLAGS)  $< -o $@

obj/%.o: src/%.s obj
	$(AS) $(ASFLAGS) $< -o $@

clean:
	rm -rf *.o kernel.elf os.iso obj iso/boot/kernel.elf src/*.o
