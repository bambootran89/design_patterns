# Command Pattern

## Intent

Encapsulate a request as an object, allowing you to parameterize clients with different requests, queue requests, and support undoable operations.

## Real-World Analogy

Imagine you order food at a restaurant. You (the Client) give your order to the waiter (the Invoker). The waiter writes it on a slip of paper (the Command). The waiter sticks the order on the wall in the kitchen.

After a while, the chef (the Receiver) picks up the order and cooks it.
You don't talk to the chef directly. You don't know who the chef is. The waiter triggers the process, but the order encapsulates all the details (what meal, which table). The slip of paper can be queued, re-ordered, or thrown away (undo).

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
