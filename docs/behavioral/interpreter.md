# Interpreter Pattern

## Intent

Define a representation for a grammar and an interpreter that uses the representation to interpret sentences in the language.

## Real-World Analogy

Imagine you are a musician. You have a sheet of music. The notes (symbols) on the staff represent a language. You (the interpreter) read these symbols and produce music.

The sheet music is a representation of the melody. Your brain acts as the interpreter that executes the instructions defined by that language. Different musicians (interpreters) might play the same sheet slightly differently, but the underlying grammar (notes, rests, clefs) is the same.

## Solution

Define grammar as class hierarchy with interpret method. Build abstract syntax tree and interpret it.

## Implementation

### Java Example

```java
// Abstract Expression
public interface Expression {
    int interpret();
}

// Terminal Expression
public class Number implements Expression {
    private int number;
    
    public Number(int number) {
        this.number = number;
    }
    
    public int interpret() {
        return number;
    }
}

// Non-terminal Expression
public class Plus implements Expression {
    Expression leftOperand;
    Expression rightOperand;
    
    public Plus(Expression left, Expression right) {
        leftOperand = left;
        rightOperand = right;
    }
    
    public int interpret() {
        return leftOperand.interpret() + rightOperand.interpret();
    }
}
```

## Use Cases

- **Expression evaluation**
- **SQL parsing**
- **Configuration languages**

## See Also

- Implementation: `/oop_in_java/Interpreter/`
