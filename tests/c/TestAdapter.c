#define main pattern_main
#include "../../oop_in_c/Adapter/Adapter.c"
#undef main
#include <stdio.h>

int main() {
  printf("Testing C Adapter...\n");
  // Call pattern main
  pattern_main();
  printf("C Adapter Test Passed!\n");
  return 0;
}
