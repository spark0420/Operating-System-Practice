#include "fb.h"
#include "io.h"

/* The I/O ports */
#define FB_COMMAND_PORT         0x3D4
#define FB_DATA_PORT            0x3D5

/* The I/O port commands */
#define FB_HIGH_BYTE_COMMAND    14
#define FB_LOW_BYTE_COMMAND     15

#define FB_MEMORY 0xB8000
#define FB_NUM_COLS 80
#define FB_NUM_ROWS 25

#define BLACK_ON_WHITE 0x0F

static uint8_t *fb = (uint8_t *) FB_MEMORY;

void fb_write(uint8_t c, uint32_t row, uint32_t col) {
    uint8_t *cell = fb + 2 * (row*FB_NUM_COLS + col);

    cell[0] = c;
    cell[1] = BLACK_ON_WHITE;
}

void fb_clear() {
	
	for(int i = 0; i < 25; i++){
		for(int j = 0; j < 80; j++){
			fb_write(' ', i, j);
		}
	 }
}

void fb_move_cursorc(unsigned short pos) {
    outb(FB_COMMAND_PORT, FB_HIGH_BYTE_COMMAND);
    outb(FB_DATA_PORT,    ((pos >> 8) & 0x00FF));
    outb(FB_COMMAND_PORT, FB_LOW_BYTE_COMMAND);
    outb(FB_DATA_PORT,    pos & 0x00FF);
}

// Write the character and then move the cursor to right AFTER that character
void fb_writec(uint8_t c, uint32_t row, uint32_t col) {
	
	uint8_t *cell = fb + 2 * (row * FB_NUM_COLS + col);

    	cell[0] = c;
    	cell[1] = BLACK_ON_WHITE;
    	   	
    	unsigned short pos = row * 80 + col + 1;
    	fb_move_cursorc(pos);
    	
}
