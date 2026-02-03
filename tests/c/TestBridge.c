#define main pattern_main
#include "../../oop_in_c/Bridge/Bridge.c"
#undef main
#include <stdio.h>

int main() {
  printf("Testing C Bridge...\n");
  // Call pattern main
  pattern_main();
  printf("C Bridge Test Passed!\n");
  return 0;
}
