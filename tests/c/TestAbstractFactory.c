#define main pattern_main
#include "../../oop_in_c/AbstractFactory/AbstractFactory.c"
#undef main
#include <stdio.h>

int main() {
    printf("Testing C AbstractFactory...\n");
    // Call pattern main
    pattern_main();
    printf("C AbstractFactory Test Passed!\n");
    return 0;
}
