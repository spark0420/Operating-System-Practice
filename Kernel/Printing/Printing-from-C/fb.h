#ifndef FB_H

#include "stdint.h"

void fb_write(uint8_t ch, uint32_t row, uint32_t col); 
void fb_clear();
void fb_writec(uint8_t ch, uint32_t row, uint32_t col); 

#endif /* FB_H */
