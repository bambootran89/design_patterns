#define main pattern_main
#include "../../oop_in_c/Reactor/Reactor.c"
#undef main
#include <stdio.h>

int main() {
    printf("Testing C Reactor...\n");
    // Call pattern main
    pattern_main();
    printf("C Reactor Test Passed!\n");
    return 0;
}
