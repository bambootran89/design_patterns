# Singleton Pattern

## Intent

Ensure a class has only one instance and provide a global point of access to it.

## Problem

Need to ensure exactly one instance of a class exists and provide controlled access to it.

## Solution

Make constructor private, provide static method that returns the single instance.

## Implementation

### Java Example

```java
public class Singleton {
    private static Singleton uniqueInstance;
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}

// Thread-safe version
public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;
    
    private ThreadSafeSingleton() {}
    
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
```

## Use Cases

- **Configuration managers**
- **Logger instances**
- **Database connection pools**
- **Thread pools**

## See Also

- Implementation: `/oop_in_java/Singleton/`
