#define main pattern_main
#include "../../oop_in_c/Observer/Observer.c"
#undef main
#include <stdio.h>

int main() {
  printf("Testing C Observer...\n");
  // Call pattern main
  pattern_main();
  printf("C Observer Test Passed!\n");
  return 0;
}
