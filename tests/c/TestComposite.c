#define main pattern_main
#include "../../oop_in_c/Composite/Composite.c"
#undef main
#include <stdio.h>

int main() {
  printf("Testing C Composite...\n");
  // Call pattern main
  pattern_main();
  printf("C Composite Test Passed!\n");
  return 0;
}
