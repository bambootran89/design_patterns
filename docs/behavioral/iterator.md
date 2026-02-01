# Iterator Pattern

## Intent

Provide a way to access elements of an aggregate object sequentially without exposing its underlying representation.

## Problem

Need to traverse a collection without exposing its internal structure.

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
