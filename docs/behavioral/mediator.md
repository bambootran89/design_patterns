# Mediator Pattern

## Intent

Define an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly.

## Real-World Analogy

Runway pilots don't talk to each other directly to decide who lands next. "Hey AirBus A380, I'm landing now, move over!" — that would be chaos.
Instead, they communicate with the Air Traffic Control (ATC) tower.

The pilots (Colleagues) only talk to the ATC (Mediator). The ATC decides who lands and who takes off. The pilots don't need to know about the existence of other planes, they just follow the ATC's instructions. This reduces the dependencies between planes from Many-to-Many to One-to-Many.

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
