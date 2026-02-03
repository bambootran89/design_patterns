# Iterator Pattern

## Intent

Provide a way to access elements of an aggregate object sequentially without exposing its underlying representation.

## Real-World Analogy

You are a tourist visiting Rome. You want to see the sights (Colosseum, Vatican, Trevi Fountain).
You can traverse the city in multiple ways:
1. Walk randomly (might miss things, might get lost).
2. Take a guided tour bus (sequential, predefined route).
3. Use a detailed map and plan an optimized route.
4. Hire a private guide.

The city (Aggregate) is the same, but the method of traversing it (Iterator) varies. You (the Client) don't need to know how the city’s streets are laid out (internal structure); you just stick to your chosen travel method to get from one landmark to the next.

## Solution

Define iterator interface with methods like hasNext() and next(), encapsulating traversal logic.

## Implementation

### Java Example

```java
// Iterator interface
public interface Iterator {
    boolean hasNext();
    Object next();
}

// Concrete Iterator
public class MenuIterator implements Iterator {
    MenuItem[] items;
    int position = 0;
    
    public MenuIterator(MenuItem[] items) {
        this.items = items;
    }
    
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }
    
    public Object next() {
        MenuItem menuItem = items[position];
        position++;
        return menuItem;
    }
}

// Aggregate
public class Menu {
    MenuItem[] menuItems;
    
    public Iterator createIterator() {
        return new MenuIterator(menuItems);
    }
}
```

## Use Cases

- **Collection traversal**
- **Custom iteration logic**
- **Database result sets**

## See Also

- Implementation: `/oop_in_java/Iterator/`
