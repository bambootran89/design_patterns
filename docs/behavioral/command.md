# Command Pattern

## Intent

Encapsulate a request as an object, allowing you to parameterize clients with different requests, queue requests, and support undoable operations.

## Problem

Need to decouple the object that invokes an operation from the object that performs the operation.

## Solution

Encapsulate requests as command objects with a common execute interface.

## Implementation

### Java Example

```java
// Command interface
public interface Command {
    void execute();
    void undo();
}

// Concrete Commands
public class LightOnCommand implements Command {
    Light light;
    
    public LightOnCommand(Light light) {
        this.light = light;
    }
    
    public void execute() {
        light.on();
    }
    
    public void undo() {
        light.off();
    }
}

// Receiver
public class Light {
    public void on() {
        System.out.println("Light is ON");
    }
    
    public void off() {
        System.out.println("Light is OFF");
    }
}

// Invoker
public class RemoteControl {
    Command command;
    
    public void setCommand(Command command) {
        this.command = command;
    }
    
    public void pressButton() {
        command.execute();
    }
}
```

## Use Cases

- **Menu systems**
- **Undo/redo operations**
- **Transaction systems**
- **Job queues**

## See Also

- Implementation: `/oop_in_java/Command/`
