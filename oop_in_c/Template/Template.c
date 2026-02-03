#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
 * @brief Virtual Table for Template Method Pattern.
 *
 * Defines function pointers for the primitive operations that subclasses must
 * implement.
 *
 * @details
 * <b>Pattern Role:</b> VTable (C's mechanism for polymorphism).
 * Contains pointers to:
 * - `addCodiments`: Abstract operation.
 * - `brew`: Abstract operation.
 * - `customerWantsCodiments`: Hook method with default behavior.
 */
typedef struct VTable VTable;
/**
 * @brief Abstract Class (CaffeineBeverageWithHook).
 *
 * Encapsulates the template method algorithm.
 *
 * @details
 * <b>Pattern Role:</b> Abstract Class.
 * The `prepareRecipe()` function acts as the template method, defining the algorithm
 * skeleton:
 * 1. boilWater (concrete)
 * 2. brew (abstract - via VTable)
 * 3. pourInCup (concrete)
 * 4. Conditionally addCodiments (abstract, guarded by hook)
 */
typedef struct CaffeineBeverageWithHook CaffeineBeverageWithHook;

struct VTable {
  void (*addCodiments)(struct CaffeineBeverageWithHook* const me);
  void (*brew)(struct CaffeineBeverageWithHook* const me);
  int (*customerWantsCodiments)(struct CaffeineBeverageWithHook* const me);
};

struct CaffeineBeverageWithHook {
  const VTable* vptr;
};

void boilwater(CaffeineBeverageWithHook* const me_) { printf(" Pouring into cup\n"); }

int abstract_customerWantsCodiments(CaffeineBeverageWithHook* const me) { return 1; }

void pourInCup(CaffeineBeverageWithHook* const me_) { printf("Boiling water\n"); }
void abstract_addCodiments(CaffeineBeverageWithHook* const me) { return; }

void abstract_brew(CaffeineBeverageWithHook* const me) { return; }
void prepareRecipe(CaffeineBeverageWithHook* const me_) {
  boilwater(me_);
  me_->vptr->brew(me_);
  pourInCup(me_);
  if (me_->vptr->customerWantsCodiments(me_) == 1) {
    me_->vptr->addCodiments(me_);
  }
}

void CaffeineBeverageWithHook_ctor(CaffeineBeverageWithHook* const me) {
  static VTable const vtable = {

      .addCodiments = abstract_addCodiments,
      .brew = abstract_brew,
      .customerWantsCodiments = abstract_customerWantsCodiments};
  me->vptr = &vtable;
}
/**
 * @brief Concrete Class (CoffeeWithHook).
 *
 * Implements the primitive operations for making coffee.
 *
 * @details
 * <b>Pattern Role:</b> Concrete Class.
 * Provides specific implementations for `brew` and `addCodiments`,
 * and overrides the hook `customerWantsCodiments` with user input logic.
 */
typedef struct CoffeeWithHook {
  CaffeineBeverageWithHook super;

} CoffeeWithHook;

void coffeeWithHook_addCodiments(CaffeineBeverageWithHook* const me) {
  printf("Adding sugar and milk ... \n");
}

void coffeeWithHook_brew(CaffeineBeverageWithHook* const me) {
  printf("Dripping coffee throuh filter ...\n");
}

int coffeeWithHook_customerWantsCodiments(CaffeineBeverageWithHook* const me) {
  char ask;
  printf("Would you like milk or sugar with your coffee (y/n)? ");

  while (1) {
    scanf("%c", &ask);
    if (ask == 'y' || ask == 'Y')
      return 1;
    else if (ask == 'n' || ask == 'N')
      return 0;
    else {
      printf(" the decision is based on y or n \n plz write (y/n): ");
      continue;
    }
  }
}

void CoffeeWithHook_ctor(CoffeeWithHook* const me) {
  static VTable const vtable = {

      .addCodiments = coffeeWithHook_addCodiments,
      .brew = coffeeWithHook_brew,
      .customerWantsCodiments = coffeeWithHook_customerWantsCodiments};
  CaffeineBeverageWithHook_ctor(&me->super);
  me->super.vptr = &vtable;
}

/**
 * @brief Concrete Class: Tea with Hook.
 *
 * Pattern Role: Concrete Class.
 * Implements abstract methods and provides hook implementation.
 */
typedef struct TeaWithHook {
  CaffeineBeverageWithHook super;

} TeaWithHook;

void teaWithHook_addCodiments(CaffeineBeverageWithHook* const me) {
  printf("Adding sugar and milk ... \n");
}

void teaWithHook_brew(CaffeineBeverageWithHook* const me) {
  printf("Brewing tea and waiting for the strong taste ...\n");
}

int teaWithHook_customerWantsCodiments(CaffeineBeverageWithHook* const me) {
  char ask;
  printf("Would you like milk or sugar with your tea (y/n)? ");

  while (1) {
    scanf("%c", &ask);
    if (ask == 'y' || ask == 'Y')
      return 1;
    else if (ask == 'n' || ask == 'N')
      return 0;
    else {
      printf(" the decision is based on y or n \n plz write (y/n): ");
      continue;
    }
  }
}

void TeaWithHook_ctor(TeaWithHook* const me) {
  static VTable const vtable = {

      .addCodiments = teaWithHook_addCodiments,
      .brew = teaWithHook_brew,
      .customerWantsCodiments = teaWithHook_customerWantsCodiments};
  CaffeineBeverageWithHook_ctor(&me->super);
  me->super.vptr = &vtable;
}

int main() {
  TeaWithHook teaWithHook;
  TeaWithHook_ctor(&teaWithHook);
  CoffeeWithHook coffeeWithHook;
  CoffeeWithHook_ctor(&coffeeWithHook);
  printf(" Making tea ... \n");
  prepareRecipe((CaffeineBeverageWithHook* const)&teaWithHook);
  printf(" Making coffee ...\n");
  prepareRecipe((CaffeineBeverageWithHook* const)&coffeeWithHook);

  return 0;
}
