#define main pattern_main
#include "../../oop_in_c/Strategy/Strategy.c"
#undef main
#include <stdio.h>

int main() {
    printf("Testing C Strategy...\n");
    // Call pattern main
    pattern_main();
    printf("C Strategy Test Passed!\n");
    return 0;
}
