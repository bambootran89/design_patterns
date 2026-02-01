# Interpreter Pattern

## Intent

Define a representation for a grammar and an interpreter that uses the representation to interpret sentences in the language.

## Problem

Need to interpret sentences in a language or evaluate expressions.

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
