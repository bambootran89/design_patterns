# Singleton Pattern

## Intent

Ensure a class has only one instance and provide a global point of access to it.

## Real-World Analogy

The government is an excellent example of the Singleton pattern. A country can have only one official government. Regardless of the personal identities of the individuals who form governments, the title, "The Government of X", is a global point of access that identifies the group of people in charge.

Clients (citizens) don't create the government. They access the existing instance. If you try to create a new government, you might end up starting a revolution (or just getting an error).

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
