#define main pattern_main
#include "../../oop_in_c/Template/Template.c"
#undef main
#include <stdio.h>

int main() {
  printf("Testing C Template...\n");
  // Call pattern main
  pattern_main();
  printf("C Template Test Passed!\n");
  return 0;
}
