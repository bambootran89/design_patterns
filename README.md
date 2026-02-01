# Design Patterns

This repository contains implementations of standard design patterns in C and Java, along with an automated test suite.

## Prerequisites

Ensure the following tools are installed on your system:

*   **GCC** or **Clang** (for C patterns)
*   **JDK 11** or later (for Java patterns)
*   **Make** (for build orchestration)

## Usage

The project uses a `Makefile` to compile source code and execute tests.

### Running Tests

To run the full test suite for both C and Java:
```bash
make test
```

To run tests for a specific language:
```bash
make test-c
make test-java
```

### Logic Verification
Assertion-based tests verify the internal logic of complex patterns (e.g., Strategy):
```bash
make test-quality
```

## Project Structure

*   `oop_in_c/`: Source code for C pattern implementations.
*   `oop_in_java/`: Source code for Java pattern implementations.
*   `tests/`: Test runners and validation logic.
*   `Makefile`: Build and test commands.
*   `.github/`: CI/CD workflow configuration.

## Supported Patterns

### C
*   Abstract Factory
*   Adapter
*   Bridge
*   Composite
*   Decorator
*   Factory Method
*   Observer
*   Reactor
*   Strategy
*   Template Method

### Java
*   Abstract Factory
*   Adapter
*   Bridge
*   Builder
*   Command
*   Composite
*   Decorator
*   Facade
*   Factory Method
*   Interpreter
*   Iterator
*   Mediator
*   Observer
*   State
*   Strategy
*   Template Method
*   Thread
*   Visitor

## Continuous Integration

The repository includes a GitHub Actions workflow (`.github/workflows/ci.yml`) that automatically builds the project and runs `make test` on every push to the `main` branch.
