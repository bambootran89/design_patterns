#include <stdio.h>
#include <string.h>
/**
 * @brief Target Interface (SolidObject).
 *
 * Defines the interface used by client code to package objects.
 *
 * @details
 * <b>Pattern Role:</b> Target.
 * This is the common interface through which Furniture, Books, and adapted Liquids
 * are packaged. All must provide a `packageObject` function pointer.
 */
struct SolidObject {
  const struct SolidObject* super;
  void (*packageObject)(const struct SolidObject* me);
};

typedef struct {
  const struct SolidObject* pSolidObject;
  char name[100];
  int timelife;
} Furniture;
static void furniture_packageObject(const struct SolidObject* me) {
  Furniture* const me_ = (Furniture*)me;
  printf(" Putting Furniture %s to the van\n", me_->name);
}
void furniture_ctor(Furniture* const me, const char* const name_) {
  static struct SolidObject const solidObject = {
      &solidObject, .packageObject = furniture_packageObject};
  me->pSolidObject = &solidObject;
  strcpy(me->name, name_);
}

typedef struct {
  const struct SolidObject* pSolidObject;
  int isbn;
  char name[100];
} Book;
static void book_packageObject(const struct SolidObject* me) {
  Book* const me_ = (Book*)me;
  printf(" Putting Book %s to the van\n", me_->name);
}
void book_ctor(Book* const me, const char* const name_) {
  static struct SolidObject const solidObject = {&solidObject,
                                                 .packageObject = book_packageObject};
  me->pSolidObject = &solidObject;
  strcpy(me->name, name_);
}

/**
 * @brief Adaptee (Liquid).
 *
 * An incompatible interface that needs to be adapted.
 *
 * @details
 * <b>Pattern Role:</b> Adaptee.
 * Liquid uses `packing()` instead of `packageObject()`. The LiquidAdapter
 * wraps this struct and translates the Target interface calls to Adaptee calls.
 */
typedef struct Liquid {
  void (*packing)(const struct Liquid* me);
  char name[100];
} Liquid;

static void liquid_packing(const Liquid* me) {
  printf(" Pouring the liquid %s into a container for packaging into the van\n",
         me->name);
}

void liquid_ctor(Liquid* const me, const char* const name_) {
  me->packing = &liquid_packing;
  strcpy(me->name, name_);
}

/**
 * @brief Adapter (LiquidAdapter).
 *
 * Converts the Liquid interface to SolidObject interface.
 *
 * @details
 * <b>Pattern Role:</b> Adapter.
 * Implements SolidObject's interface but delegates to Liquid's `packing()` method.
 * This allows Liquid to be used polymorphically alongside Book and Furniture.
 */
typedef struct {
  const struct SolidObject* pSolidObject;
  char name[100];
  const Liquid* liquid;
} LiquidAdapter;
static void liquid_packageObject(const struct SolidObject* me) {
  LiquidAdapter* const me_ = (LiquidAdapter*)me;
  me_->liquid->packing(me_->liquid);
}
void liquidAdapter_ctor(LiquidAdapter* const me, const char* const name_,
                        const Liquid* const liquid_) {
  static struct SolidObject const solidObject = {&solidObject,
                                                 .packageObject = liquid_packageObject};
  me->pSolidObject = &solidObject;
  strcpy(me->name, name_);
  me->liquid = liquid_;
}

static void packageObject(struct SolidObject* const me) {
  me->super->packageObject(me);
}
int main() {
  int i;
  Book book;
  book_ctor(&book, "book");
  Furniture furniture;
  furniture_ctor(&furniture, "furniture");

  Liquid liquid;
  liquid_ctor(&liquid, "liquid");

  LiquidAdapter liquidAdapter;
  liquidAdapter_ctor(&liquidAdapter, "liquidAdapter", &liquid);

  struct SolidObject* const solidObject[3] = {
      (struct SolidObject* const)&book, (struct SolidObject* const)&furniture,
      (struct SolidObject* const)&liquidAdapter};

  for (i = 0; i < 3; i++) {
    packageObject(solidObject[i]);
  }

  return 0;
}
