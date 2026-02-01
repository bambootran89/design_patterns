# Facade Pattern

## Intent

Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.

## Problem

A complex subsystem with many interdependent classes is difficult to use directly.

## Solution

Create a facade class that provides simple methods for common tasks, delegating to subsystem classes.

## Implementation

### Java Example

```java
// Subsystem classes
public class CPU {
    public void freeze() { System.out.println("CPU: Freeze"); }
    public void jump(long position) { System.out.println("CPU: Jump to " + position); }
    public void execute() { System.out.println("CPU: Execute"); }
}

public class Memory {
    public void load(long position, byte[] data) {
        System.out.println("Memory: Load at " + position);
    }
}

public class HardDrive {
    public byte[] read(long lba, int size) {
        System.out.println("HardDrive: Read from " + lba);
        return new byte[size];
    }
}

// Facade
public class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;
    
    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }
    
    public void start() {
        cpu.freeze();
        memory.load(0, hardDrive.read(0, 1024));
        cpu.jump(0);
        cpu.execute();
    }
}

// Usage
ComputerFacade computer = new ComputerFacade();
computer.start();  // Simple!
```

## Use Cases

- **Library wrappers**
- **API simplification**
- **Legacy system integration**

## See Also

- Implementation: `/oop_in_java/Facade/`
