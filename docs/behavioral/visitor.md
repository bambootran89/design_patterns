# Visitor Pattern

## Intent

Represent an operation to be performed on elements of an object structure. Visitor lets you define a new operation without changing the classes of the elements on which it operates.

## Real-World Analogy

Imagine an insurance agent visiting different types of buildings.
- When visiting a **Residential House**, he sells medical insurance.
- When visiting a **Bank**, he sells theft insurance.
- When visiting a **Factory**, he sells fire insurance.

The buildings (Elements) are different classes. The agent (Visitor) performs a different operation depending on the building he is visiting.
You want to add this "selling insurance" capability without modifying the code of the buildings (they shouldn't know about insurance). The Visitor pattern lets you define this new operation in a separate class (the Agent) that visits the elements.

## Solution

Define visitor interface with visit methods for each element type. Elements accept visitors and call the appropriate visit method.

## Implementation

### Java Example

```java
// Visitor interface
public interface CarElementVisitor {
    void visit(Wheel wheel);
    void visit(Engine engine);
    void visit(Body body);
    void visit(Car car);
}

// Concrete Visitor
public class CarElementPrintVisitor implements CarElementVisitor {
    public void visit(Wheel wheel) {
        System.out.println("Visiting " + wheel.getName() + " wheel");
    }
    
    public void visit(Engine engine) {
        System.out.println("Visiting engine");
    }
    
    public void visit(Body body) {
        System.out.println("Visiting body");
    }
    
    public void visit(Car car) {
        System.out.println("Visiting car");
    }
}

// Element interface
public interface CarElement {
    void accept(CarElementVisitor visitor);
}

// Concrete Element
public class Wheel implements CarElement {
    private String name;
    
    public Wheel(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }
}
```

## Use Cases

- **Compiler operations** (type checking, code generation)
- **Document processing**
- **Object structure traversal**

## See Also

- Implementation: `/oop_in_java/Visitor/`
