# Mediator Pattern

## Intent

Define an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly.

## Problem

Objects communicate with each other in complex ways, creating tight coupling.

## Solution

Introduce mediator object that coordinates interactions between colleague objects.

## Implementation

### Java Example

```java
// Mediator
public interface Mediator {
    void notify(Component sender, String event);
}

// Concrete Mediator
public class DialogMediator implements Mediator {
    private Button button;
    private Textbox textbox;
    
    public void notify(Component sender, String event) {
        if (sender == button && event.equals("click")) {
            textbox.setText("Button clicked!");
        }
    }
}

// Colleague
public abstract class Component {
    protected Mediator mediator;
    
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
```

## Use Cases

- **GUI dialogs**
- **Chat rooms**
- **Air traffic control**

## See Also

- Implementation: `/oop_in_java/Mediator/`
