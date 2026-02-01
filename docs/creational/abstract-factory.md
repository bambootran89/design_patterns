# Abstract Factory Pattern

## Intent

Provide an interface for creating families of related or dependent objects without specifying their concrete classes.

## Problem

Need to create families of related objects that must be used together, ensuring compatibility between products.

## Solution

Define an abstract factory interface with methods for creating each product type. Concrete factories implement these methods to create compatible product families.

## Structure

```mermaid
classDiagram
    class AbstractFactory {
        <<interface>>
        +createProductA()
        +createProductB()
    }
    class ConcreteFactory1 {
        +createProductA()
        +createProductB()
    }
    class ConcreteFactory2 {
        +createProductA()
        +createProductB()
    }
    class AbstractProductA {
        <<interface>>
    }
    class AbstractProductB {
        <<interface>>
    }
    AbstractFactory <|-- ConcreteFactory1
    AbstractFactory <|-- ConcreteFactory2
    AbstractFactory ..> AbstractProductA
    AbstractFactory ..> AbstractProductB
```

## Implementation

### Java Example

```java
// Abstract Products
public interface Button {
    void paint();
}

public interface Checkbox {
    void paint();
}

// Concrete Products - Windows
public class WinButton implements Button {
    public void paint() {
        System.out.println("Windows button");
    }
}

public class WinCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Windows checkbox");
    }
}

// Concrete Products - Mac
public class MacButton implements Button {
    public void paint() {
        System.out.println("Mac button");
    }
}

// Abstract Factory
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factories
public class WinFactory implements GUIFactory {
    public Button createButton() {
        return new WinButton();
    }
    
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}

public class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }
    
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
```

### C Example

```c
typedef struct Button {
    void (*paint)(struct Button* me);
} Button;

typedef struct GUIFactory {
    Button* (*createButton)(void);
    Checkbox* (*createCheckbox)(void);
} GUIFactory;
```

## Use Cases

- **UI toolkits**: Platform-specific widgets (Windows, Mac, Linux)
- **Theme systems**: Different visual themes with consistent components
- **Database access**: Different database families (MySQL, PostgreSQL)

## See Also

- Implementation: `/oop_in_java/AbstractFactory/`
- Implementation: `/oop_in_c/AbstractFactory/`
