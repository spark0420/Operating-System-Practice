#ifndef TIMER_H
#define TIMER_H

#include "stdint.h"
#include "common.h"

void init_timer(void);
void count_tick(void);
void print_timer(void);
void timer_2sec_on(void);
void timer_2sec_off(void);
uint8_t isPrime(uint32_t n);
void checkPrime(void);


#endif /* TIMER_H */
