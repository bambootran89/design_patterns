#define main pattern_main
#include "../../oop_in_c/FactoryMethod/FactoryMethod.c"
#undef main
#include <stdio.h>

int main() {
    printf("Testing C FactoryMethod...\n");
    // Call pattern main
    pattern_main();
    printf("C FactoryMethod Test Passed!\n");
    return 0;
}
