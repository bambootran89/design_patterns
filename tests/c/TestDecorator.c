#define main pattern_main
#include "../../oop_in_c/Decorator/Decorator.c"
#undef main
#include <stdio.h>

int main() {
  printf("Testing C Decorator...\n");
  // Call pattern main
  pattern_main();
  printf("C Decorator Test Passed!\n");
  return 0;
}
