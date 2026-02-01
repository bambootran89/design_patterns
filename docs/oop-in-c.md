# Object-Oriented Programming in C

## Overview

C is not an object-oriented language, but design patterns can still be implemented using C's features: structs, function pointers, and careful organization. This document explains the techniques used in this repository.

## Core Techniques

### 1. Structs as Classes

Structs serve as classes, containing data members and pointers to functions (methods).

```c
typedef struct Dog {
    char* name;
    int age;
    void (*bark)(struct Dog* me);
    void (*eat)(struct Dog* me);
} Dog;
```

### 2. Function Pointers as Methods

Function pointers in structs simulate methods. The first parameter is typically `me` or `this` (pointer to the struct itself).

```c
void Dog_bark(Dog* me) {
    printf("%s says: Woof!\n", me->name);
}

void Dog_eat(Dog* me) {
    printf("%s is eating\n", me->name);
}

// Constructor
Dog* Dog_new(char* name, int age) {
    Dog* dog = malloc(sizeof(Dog));
    dog->name = name;
    dog->age = age;
    dog->bark = Dog_bark;  // Bind method
    dog->eat = Dog_eat;
    return dog;
}

// Usage
Dog* myDog = Dog_new("Buddy", 3);
myDog->bark(myDog);  // Buddy says: Woof!
```

### 3. Inheritance through Composition

C doesn't support inheritance, but we can simulate it using composition and struct embedding.

```c
// Base "class"
typedef struct Animal {
    char* name;
    void (*makeSound)(struct Animal* me);
} Animal;

// Derived "class" - embeds Animal
typedef struct Dog {
    Animal super;  // Inheritance via composition
    char* breed;
    void (*wagTail)(struct Dog* me);
} Dog;

void Dog_makeSound(Animal* me) {
    printf("Woof!\n");
}

void Dog_wagTail(Dog* me) {
    printf("%s wags tail\n", me->super.name);
}

Dog* Dog_new(char* name, char* breed) {
    Dog* dog = malloc(sizeof(Dog));
    dog->super.name = name;
    dog->super.makeSound = Dog_makeSound;
    dog->breed = breed;
    dog->wagTail = Dog_wagTail;
    return dog;
}

// Polymorphism - can treat Dog as Animal
Animal* animal = (Animal*)Dog_new("Buddy", "Golden Retriever");
animal->makeSound(animal);  // Woof!
```

### 4. Polymorphism with Function Pointers

Function pointers enable runtime polymorphism. Different "subclasses" can implement the same interface differently.

```c
// Interface
typedef struct Shape {
    void (*draw)(struct Shape* me);
    double (*area)(struct Shape* me);
} Shape;

// Concrete implementation 1
typedef struct Circle {
    Shape super;
    double radius;
} Circle;

double Circle_area(Shape* me) {
    Circle* circle = (Circle*)me;
    return 3.14 * circle->radius * circle->radius;
}

void Circle_draw(Shape* me) {
    printf("Drawing circle with area: %.2f\n", me->area(me));
}

// Concrete implementation 2
typedef struct Rectangle {
    Shape super;
    double width;
    double height;
} Rectangle;

double Rectangle_area(Shape* me) {
    Rectangle* rect = (Rectangle*)me;
    return rect->width * rect->height;
}

// Polymorphic usage
Shape* shapes[2];
shapes[0] = (Shape*)Circle_new(5.0);
shapes[1] = (Shape*)Rectangle_new(4.0, 6.0);

for (int i = 0; i < 2; i++) {
    shapes[i]->draw(shapes[i]);  // Calls appropriate implementation
}
```

### 5. Encapsulation

Encapsulation is achieved through:
- **Opaque pointers**: Declare struct in header, define in .c file
- **Naming conventions**: Prefix private functions with underscore
- **Static functions**: Use `static` for "private" functions

```c
// header.h
typedef struct Private Private;  // Opaque pointer

Private* Private_new(void);
void Private_publicMethod(Private* me);

// implementation.c
struct Private {
    int secretValue;  // Not visible outside this file
};

static void _privateHelper(Private* me) {
    // Static = file scope only
    me->secretValue++;
}

void Private_publicMethod(Private* me) {
    _privateHelper(me);
}
```

## Pattern-Specific Techniques

### Observer Pattern

Uses function pointers for update notifications:

```c
typedef struct Observer {
    void (*update)(struct Observer* me, struct Observable* subject);
} Observer;

typedef struct Observable {
    Observer* observers[MAX];
    int count;
    void (*attach)(struct Observable* me, Observer* obs);
    void (*notify)(struct Observable* me);
} Observable;

void Observable_notify(Observable* me) {
    for (int i = 0; i < me->count; i++) {
        me->observers[i]->update(me->observers[i], me);
    }
}
```

### Decorator Pattern

Uses composition to wrap objects:

```c
typedef struct Component {
    double (*cost)(struct Component* me);
    char* (*description)(struct Component* me);
} Component;

typedef struct Decorator {
    Component super;
    Component* wrapped;  // Wraps another component
} Decorator;

double Mocha_cost(Component* me) {
    Decorator* dec = (Decorator*)me;
    return dec->wrapped->cost(dec->wrapped) + 0.20;
}
```

### Strategy Pattern

Swaps algorithm implementations at runtime:

```c
typedef struct FlyBehavior {
    void (*fly)(void);
} FlyBehavior;

typedef struct Duck {
    FlyBehavior* flyBehavior;  // Strategy can be changed
    void (*performFly)(struct Duck* me);
} Duck;

void Duck_performFly(Duck* me) {
    me->flyBehavior->fly();  // Delegates to strategy
}

// Can swap strategies
duck->flyBehavior = FlyWithWings_new();
duck->performFly(duck);  // Flies

duck->flyBehavior = FlyNoWay_new();
duck->performFly(duck);  // Can't fly
```

## Memory Management

C requires manual memory management:

```c
// Constructor pattern
Object* Object_new() {
    Object* obj = malloc(sizeof(Object));
    // Initialize
    return obj;
}

// Destructor pattern
void Object_destroy(Object* obj) {
    // Free nested allocations first
    free(obj->data);
    free(obj);
}

// Always pair new with destroy
Object* obj = Object_new();
// ... use obj ...
Object_destroy(obj);
```

## Naming Conventions

Consistent naming makes C OOP more readable:

```c
// ClassName_methodName pattern
Dog* Dog_new();              // Constructor
void Dog_bark(Dog* me);      // Instance method
void Dog_destroy(Dog* me);   // Destructor

// _private for internal functions
static void _Dog_helper(Dog* me);

// ALL_CAPS for constants
#define DOG_MAX_AGE 20
```

## Advantages and Limitations

### Advantages
- **Explicit**: Everything is visible, no hidden behavior
- **Performance**: No vtable overhead (unless you create one)
- **Portability**: Pure C works everywhere
- **Learning**: Understand OOP mechanics deeply

### Limitations
- **Verbose**: More boilerplate than C++ or Java
- **Manual**: No compiler enforcement of OOP rules
- **Error-prone**: Easy to forget vtable initialization
- **No RAII**: Must manually manage resources

## Examples in This Repository

See these patterns for complete C implementations:

- **Decorator**: [oop_in_c/Decorator/](file:///Users/cuongtranhuu/design_patterns/oop_in_c/Decorator/)
- **Observer**: [oop_in_c/Observer/](file:///Users/cuongtranhuu/design_patterns/oop_in_c/Observer/)
- **Factory Method**: [oop_in_c/FactoryMethod/](file:///Users/cuongtranhuu/design_patterns/oop_in_c/FactoryMethod/)
- **Strategy**: [oop_in_c/Strategy/](file:///Users/cuongtranhuu/design_patterns/oop_in_c/Strategy/)

## Further Reading

- "Object-Oriented Programming in ANSI C" by Axel Schreiner
- Linux kernel source code (extensive use of OOP techniques in C)
- GTK+ library (GObject system)
