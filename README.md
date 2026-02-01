# Design Patterns

Implementations of classic design patterns in C and Java with comprehensive test coverage.

## Quick Links

- [Test Results](#test-results)
- [Pattern Catalog](#pattern-catalog)
- [Usage](#usage)

## Test Results

```
C Tests: 10/10 PASSED
Java Tests: 18/18 PASSED  
Assertion Tests: 2/2 PASSED
Total: 30/30 PASSED
```

Note: Mediator test requires GUI, runs locally only (not in CI).

## Pattern Catalog

### Creational Patterns

| Pattern | Description | Java | C | Docs |
|---------|-------------|------|---|------|
| **Abstract Factory** | Create families of related objects | ✓ | ✓ | [Details](docs/creational/abstract-factory.md) |
| **Builder** | Construct complex objects step by step | ✓ | | [Details](docs/creational/builder.md) |
| **Factory Method** | Define interface for object creation | ✓ | ✓ | [Details](docs/creational/factory-method.md) |
| **Singleton** | Ensure single instance with global access | ✓ | | [Details](docs/creational/singleton.md) |

### Structural Patterns

| Pattern | Description | Java | C | Docs |
|---------|-------------|------|---|------|
| **Adapter** | Convert interface to expected interface | ✓ | ✓ | [Details](docs/structural/adapter.md) |
| **Bridge** | Decouple abstraction from implementation | ✓ | ✓ | [Details](docs/structural/bridge.md) |
| **Composite** | Compose objects into tree structures | ✓ | ✓ | [Details](docs/structural/composite.md) |
| **Decorator** | Attach responsibilities dynamically | ✓ | ✓ | [Details](docs/structural/decorator.md) |
| **Facade** | Unified interface to subsystem | ✓ | | [Details](docs/structural/facade.md) |

### Behavioral Patterns

| Pattern | Description | Java | C | Docs |
|---------|-------------|------|---|------|
| **Command** | Encapsulate request as an object | ✓ | | [Details](docs/behavioral/command.md) |
| **Interpreter** | Define grammar and interpreter | ✓ | | [Details](docs/behavioral/interpreter.md) |
| **Iterator** | Access elements sequentially | ✓ | | [Details](docs/behavioral/iterator.md) |
| **Mediator** | Encapsulate object interactions | ✓ | | [Details](docs/behavioral/mediator.md) |
| **Observer** | Notify dependents of state changes | ✓ | ✓ | [Details](docs/behavioral/observer.md) |
| **State** | Alter behavior when state changes | ✓ | | [Details](docs/behavioral/state.md) |
| **Strategy** | Encapsulate interchangeable algorithms | ✓ | ✓ | [Details](docs/behavioral/strategy.md) |
| **Template Method** | Define algorithm skeleton | ✓ | ✓ | [Details](docs/behavioral/template-method.md) |
| **Visitor** | Define new operations on elements | ✓ | | [Details](docs/behavioral/visitor.md) |

## Prerequisites

- GCC or Clang (for C patterns)
- JDK 11 or later (for Java patterns)
- Make (for build orchestration)

## Usage

```bash
# Run all tests
make test

# Run C tests only
make test-c

# Run Java tests only
make test-java

# Run specific pattern test
make test-observer-java
make test-decorator-c

# Clean build artifacts
make clean
```

## Project Structure

```
oop_in_java/          # Java pattern implementations
oop_in_c/             # C pattern implementations
docs/                 # Detailed pattern documentation
  creational/         # Creational pattern docs
  structural/         # Structural pattern docs
  behavioral/         # Behavioral pattern docs
tests/                # Test suite
  c/                  # C tests
  java/               # Java tests
Makefile              # Build and test orchestration
```

## Documentation

Each pattern has:
- Detailed documentation in `docs/` with examples and diagrams
- Inline Javadoc/Doxygen comments with pattern role annotations
- Test cases demonstrating usage
- Both procedural (C) and object-oriented (Java) implementations

## Continuous Integration

GitHub Actions automatically runs the test suite on every push to master branch.

## License

MIT License
