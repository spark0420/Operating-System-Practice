#include "idt.h"
#include "io.h"
#include "interrupt.h"
#include "common.h"
#include "pic.h"
#include "timer.h"
#include "fb.h"

#define PIT_CHANNEL_0_DATA  0x40
#define PIT_COMMAND         0x43

#define PIT_FREQUENCY       1193182
#define frequency	    1000

#define SCHEDULER_PIT_INTERVAL 2 /* in ms */
#define SCHEDULER_TIME_SLICE   (5 * SCHEDULER_PIT_INTERVAL) /* in ms */
static uint32_t total_tick = 0;
static uint32_t total_sec = 0;
static uint8_t 	display_on = 0;
static uint32_t start_s = 0;

void init_timer(void)
{

	uint32_t divisor = PIT_FREQUENCY / frequency;

	outb(PIT_COMMAND, 0x36);

	uint8_t low = (uint8_t)(divisor & 0xFF);
	uint8_t high = (uint8_t)((divisor >> 8 & 0xFF));

	outb(PIT_CHANNEL_0_DATA, low);
	outb(PIT_CHANNEL_0_DATA, high);
	
	// This is to just double check that we are starting
	// at zero for both.	
	total_tick = 0;
	total_sec = 0;
	
	//fb_puts("Timer initialized!\n");
}

void count_tick(void)
{
	total_tick++;
	if(total_tick == 1000){
		total_sec++;
		if(display_on) {
			if(total_sec % 2 == 0) {
				fb_puts("It's been 2 seconds!\n");
			}
		}
		total_tick = 0;
	}
}

void checkPrime(void)
{
    uint32_t curr_time = total_sec;
    uint32_t result = 0;
    
    fb_puts("Starting time: ");
    fb_putui(curr_time);
    fb_putb('\n');
    
    for(uint32_t i = 2; i <= 10000; i++){
	if(isPrime(i) == 1){
	    result++;
	}
    }

    uint32_t curr_time2 = total_sec;
    
    
    uint32_t curr_time3 = curr_time2 - curr_time;
    fb_puts("Number of primes: ");
    fb_putui(result);
    fb_putb('\n');
    fb_puts("Ending time: ");
    fb_putui(curr_time2);
    fb_putb('\n');
    fb_puts("Total execution time: ");
    fb_putui(curr_time3);
    fb_putb('\n');
}

uint8_t isPrime(uint32_t n)
{
    /*uint32_t curr_time = total_sec;
    uint32_t result = 0;*/

    if(n <= 3){
	return 1;
    }
    for(uint32_t j = 2; j < n; j++){
	if(n % j == 0){
            return 0;
        }	 
    }
    return 1;
}

void time_start_s(void)
{
	start_s = total_sec;
	fb_puts("Timer Initialized\n");
}

void time_end_s(void)
{
	uint32_t end_s = total_sec - start_s;
	fb_puts("Time Elapsed: ");
	fb_putui(end_s);
	fb_puts(" Seconds.\n");
	
}

void timer_2sec_on(void)
{
	fb_puts("Printing every 2sec!\n");
	display_on = 1;
	
}

void timer_2sec_off(void)
{
	fb_puts("Stop printing.\n");
	display_on = 0;
}
	






