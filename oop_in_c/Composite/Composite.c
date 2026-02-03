#include <stdio.h>
#include <string.h>

#define MAX 100

/**
 * @brief Component Interface.
 *
 * Pattern Role: Component.
 * Common interface for both Composite and Leaf nodes.
 */
typedef struct Graphic Graphic;

struct Graphic {
  const struct Graphic* super;
  void (*print)(struct Graphic* const me);
};

void print(Graphic* const graphic);

/**
 * @brief Composite: Composite Graphic.
 *
 * Pattern Role: Composite.
 * Can contain child Graphic objects.
 */
typedef struct CompositeGraphic {
  struct Graphic const* pGraphic;
  char name[100];
  int num;
  const Graphic* list[MAX];
} CompositeGraphic;

void compositeGraphic_print(Graphic* const me_) {
  CompositeGraphic* const me = (CompositeGraphic* const)me_;
  int i;
  printf("this is CompositeGraphic %s \n", me->name);
  for (i = 0; i < me->num; i++) {
    Graphic* const item = (Graphic* const)me->list[i];
    print(item);
  }
}

void CompositeGraphic_ctor(CompositeGraphic* const me, const char* const name_) {
  static Graphic const graphic = {&graphic, .print = compositeGraphic_print};

  me->pGraphic = &graphic;
  strcpy(me->name, name_);
  me->num = 0;
}

int add(CompositeGraphic* const me_, Graphic* const graphic) {
  CompositeGraphic* const me = (CompositeGraphic* const)me_;
  if (me->num == MAX - 1) {
    printf(" Can not add new elements \n");
    return -1;
  } else {
    me->list[me->num] = graphic;

    (me->num)++;
    return 0;
  }
}

/**
 * @brief Leaf: Leaf Graphic.
 *
 * Pattern Role: Leaf.
 * Terminal node with no children.
 */
typedef struct LeafGraphic {
  struct Graphic const* pGraphic;
  char name[100];
} LeafGraphic;

void leafGraphic_print(Graphic* const me_) {
  LeafGraphic* const me = (LeafGraphic* const)me_;
  printf("this is LeafGraphic %s \n", me->name);
}

void LeafGraphic_ctor(LeafGraphic* const me, const char* const name_) {
  static Graphic const graphic = {&graphic, .print = leafGraphic_print};

  me->pGraphic = &graphic;
  strcpy(me->name, name_);
}

void print(Graphic* const graphic) { (graphic->super->print)(graphic); }

int main() {
  LeafGraphic leaf0, leaf1, leaf2, leaf3;

  LeafGraphic_ctor(&leaf0, "Button 1");
  LeafGraphic_ctor(&leaf1, "Text");
  LeafGraphic_ctor(&leaf2, "Checked");
  LeafGraphic_ctor(&leaf3, "Contents");

  CompositeGraphic maingraphic;
  CompositeGraphic_ctor(&maingraphic, "Main Graphic");
  CompositeGraphic left;
  CompositeGraphic_ctor(&left, "Left Graphic");
  CompositeGraphic right;
  CompositeGraphic_ctor(&right, "Right Graphic");

  add(&left, (Graphic* const)&leaf1);
  add(&left, (Graphic* const)&leaf0);

  add(&right, (Graphic* const)&leaf3);
  add(&right, (Graphic* const)&leaf2);

  add(&maingraphic, (Graphic* const)&right);
  add(&maingraphic, (Graphic* const)&left);

  print((Graphic* const)&maingraphic);
  return 0;
}
