#include "fb.h"
#include "io.h"

/* The I/O ports */
#define FB_COMMAND_PORT         0x3D4
#define FB_DATA_PORT            0x3D5

/* The I/O port commands */
#define FB_HIGH_BYTE_COMMAND    14
#define FB_LOW_BYTE_COMMAND     15

/** fb_move_cursor:
 *  Moves the cursor of the framebuffer to the given position
 *
 *  @param pos The new position of the cursor
 */
void fb_move_cursor(unsigned short pos) {
    outb(FB_COMMAND_PORT, FB_HIGH_BYTE_COMMAND);
    outb(FB_DATA_PORT,    ((pos >> 8) & 0x00FF));
    outb(FB_COMMAND_PORT, FB_LOW_BYTE_COMMAND);
    outb(FB_DATA_PORT,    pos & 0x00FF);
}

#define UNUSED_ARGUMENT(x) (void) x

int kmain(void *mboot, unsigned int magic_number) {

    UNUSED_ARGUMENT(mboot); // So the compiler/link does not complain.
    UNUSED_ARGUMENT(magic_number); // So the compiler/link does not complain.

    fb_clear();

    fb_write('h', 0, 0);
    fb_write('e', 0, 1);
    fb_write('l', 0, 2);
    fb_write('l', 0, 3);
    fb_write('o', 0, 4);

    fb_write('!', 3, 4);
    //fb_move_cursor(4);
    fb_writec('?', 0, 80);

    return 0xDEADBEEF;
}
