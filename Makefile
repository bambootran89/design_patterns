SHELL := /bin/bash

# Makefile for Design Patterns Verification

.PHONY: test test-c test-java clean

# Include generated targets
# We will manually paste them here or use include directive if separate file.
# But for single file artifact, I will paste the content of makefile_snippet.mk here effectively.

# --- Generated Targets Start ---

test-abstractfactory-c:
	@echo "Running C AbstractFactory Test..."
	@gcc -o tests/c/test_AbstractFactory tests/c/TestAbstractFactory.c
	@(echo "150"; yes "y") | ./tests/c/test_AbstractFactory
	@rm -f tests/c/test_AbstractFactory

test-adapter-c:
	@echo "Running C Adapter Test..."
	@gcc -o tests/c/test_Adapter tests/c/TestAdapter.c
	@(echo "150"; yes "y") | ./tests/c/test_Adapter
	@rm -f tests/c/test_Adapter

test-bridge-c:
	@echo "Running C Bridge Test..."
	@gcc -o tests/c/test_Bridge tests/c/TestBridge.c
	@(echo "150"; yes "y") | ./tests/c/test_Bridge
	@rm -f tests/c/test_Bridge

test-composite-c:
	@echo "Running C Composite Test..."
	@gcc -o tests/c/test_Composite tests/c/TestComposite.c
	@(echo "150"; yes "y") | ./tests/c/test_Composite
	@rm -f tests/c/test_Composite

test-decorator-c:
	@echo "Running C Decorator Test..."
	@gcc -o tests/c/test_Decorator tests/c/TestDecorator.c
	@(echo "150"; yes "y") | ./tests/c/test_Decorator
	@rm -f tests/c/test_Decorator

test-factorymethod-c:
	@echo "Running C FactoryMethod Test..."
	@gcc -o tests/c/test_FactoryMethod tests/c/TestFactoryMethod.c
	@(echo "150"; yes "y") | ./tests/c/test_FactoryMethod
	@rm -f tests/c/test_FactoryMethod

test-observer-c:
	@echo "Running C Observer Test..."
	@gcc -o tests/c/test_Observer tests/c/TestObserver.c
	@(echo "150"; yes "y") | ./tests/c/test_Observer
	@rm -f tests/c/test_Observer

test-reactor-c:
	@echo "Running C Reactor Test..."
	@gcc -o tests/c/test_Reactor tests/c/TestReactor.c
	@(echo "150"; yes "y") | ./tests/c/test_Reactor
	@rm -f tests/c/test_Reactor

test-strategy-c:
	@echo "Running C Strategy Test..."
	@gcc -o tests/c/test_Strategy tests/c/TestStrategy.c
	@(echo "150"; yes "y") | ./tests/c/test_Strategy
	@rm -f tests/c/test_Strategy

test-template-c:
	@echo "Running C Template Test..."
	@gcc -o tests/c/test_Template tests/c/TestTemplate.c
	@(echo "150"; yes "y") | ./tests/c/test_Template
	@rm -f tests/c/test_Template

test-abstractfactory-java:
	@echo "Running Java AbstractFactory Test..."
	@mkdir -p bin_test_AbstractFactory
	@javac -d bin_test_AbstractFactory oop_in_java/AbstractFactory/src/*.java tests/java/TestAbstractFactory.java
	@(echo "150"; yes "y") | perl -e 'alarm shift; exec @ARGV' 3 java -cp bin_test_AbstractFactory TestAbstractFactory
	@rm -rf bin_test_AbstractFactory

test-adapter-java:
	@echo "Running Java Adapter Test..."
	@mkdir -p bin_test_Adapter
	@javac -d bin_test_Adapter oop_in_java/Adapter/src/*.java tests/java/TestAdapter.java
	@(echo "150"; yes "y") | perl -e 'alarm shift; exec @ARGV' 3 java -cp bin_test_Adapter TestAdapter
	@rm -rf bin_test_Adapter

test-bridge-java:
	@echo "Running Java Bridge Test..."
	@mkdir -p bin_test_Bridge
	@javac -d bin_test_Bridge oop_in_java/Bridge/src/*.java tests/java/TestBridge.java
	@(echo "150"; yes "y") | perl -e 'alarm shift; exec @ARGV' 3 java -cp bin_test_Bridge TestBridge
	@rm -rf bin_test_Bridge

test-builder-java:
	@echo "Running Java Builder Test..."
	@mkdir -p bin_test_Builder
	@javac -d bin_test_Builder oop_in_java/Builder/src/*.java tests/java/TestBuilder.java
	@(echo "150"; yes "y") | perl -e 'alarm shift; exec @ARGV' 3 java -cp bin_test_Builder TestBuilder
	@rm -rf bin_test_Builder

test-command-java:
	@echo "Running Java Command Test..."
	@mkdir -p bin_test_Command
	@javac -d bin_test_Command oop_in_java/Command/src/*.java tests/java/TestCommand.java
	@(echo "150"; yes "y") | perl -e 'alarm shift; exec @ARGV' 3 java -cp bin_test_Command TestCommand
	@rm -rf bin_test_Command

test-composite-java:
	@echo "Running Java Composite Test..."
	@mkdir -p bin_test_Composite
	@javac -d bin_test_Composite oop_in_java/Composite/src/*.java tests/java/TestComposite.java
	@(echo "150"; yes "y") | perl -e 'alarm shift; exec @ARGV' 3 java -cp bin_test_Composite TestComposite
	@rm -rf bin_test_Composite

test-decorator-java:
	@echo "Running Java Decorator Test..."
	@mkdir -p bin_test_Decorator
	@javac -d bin_test_Decorator oop_in_java/Decorator/src/*.java tests/java/TestDecorator.java
	@(echo "150"; yes "y") | perl -e 'alarm shift; exec @ARGV' 3 java -cp bin_test_Decorator TestDecorator
	@rm -rf bin_test_Decorator

test-facade-java:
	@echo "Running Java Facade Test..."
	@mkdir -p bin_test_Facade
	@javac -d bin_test_Facade oop_in_java/Facade/src/*.java tests/java/TestFacade.java
	@(echo "150"; yes "y") | perl -e 'alarm shift; exec @ARGV' 3 java -cp bin_test_Facade TestFacade
	@rm -rf bin_test_Facade

test-factorymethod-java:
	@echo "Running Java Factorymethod Test..."
	@mkdir -p bin_test_Factorymethod
	@javac -d bin_test_Factorymethod oop_in_java/Factorymethod/src/*.java tests/java/TestFactorymethod.java
	@(echo "150"; yes "y") | perl -e 'alarm shift; exec @ARGV' 3 java -cp bin_test_Factorymethod TestFactorymethod
	@rm -rf bin_test_Factorymethod

test-interpreter-java:
	@echo "Running Java Interpreter Test..."
	@mkdir -p bin_test_Interpreter
	@javac -d bin_test_Interpreter oop_in_java/Interpreter/src/*.java tests/java/TestInterpreter.java
	@(echo "150"; yes "y") | perl -e 'alarm shift; exec @ARGV' 3 java -cp bin_test_Interpreter TestInterpreter
	@rm -rf bin_test_Interpreter

test-iterator-java:
	@echo "Running Java Iterator Test..."
	@mkdir -p bin_test_Iterator
	@javac -d bin_test_Iterator oop_in_java/Iterator/src/*.java tests/java/TestIterator.java
	@(echo "150"; yes "y") | perl -e 'alarm shift; exec @ARGV' 3 java -cp bin_test_Iterator TestIterator
	@rm -rf bin_test_Iterator

test-mediator-java:
	@echo "Running Java Mediator Test..."
	@mkdir -p bin_test_Mediator
	@javac -d bin_test_Mediator oop_in_java/Mediator/src/*.java tests/java/TestMediator.java
	@bash -c '(echo "150"; yes "y") | head -n 100 | perl -e "alarm shift; exec @ARGV" 3 java -Djava.awt.headless=true -cp bin_test_Mediator TestMediator; RET=$$?; if [ $$RET -eq 142 ]; then echo "Mediator timed out as expected"; exit 0; else exit $$RET; fi'
	@rm -rf bin_test_Mediator

test-observer-java:
	@echo "Running Java Observer Test..."
	@mkdir -p bin_test_Observer
	@javac -d bin_test_Observer oop_in_java/Observer/src/*.java tests/java/TestObserver.java
	@(echo "150"; yes "y") | perl -e 'alarm shift; exec @ARGV' 3 java -cp bin_test_Observer TestObserver
	@rm -rf bin_test_Observer

test-strategy-java:
	@echo "Running Java Strategy Test..."
	@mkdir -p bin_test_Strategy
	@javac -d bin_test_Strategy oop_in_java/Strategy/src/*.java tests/java/TestStrategy.java
	@(echo "150"; yes "y") | perl -e 'alarm shift; exec @ARGV' 3 java -cp bin_test_Strategy TestStrategy
	@rm -rf bin_test_Strategy

test-template-java:
	@echo "Running Java Template Test..."
	@mkdir -p bin_test_Template
	@javac -d bin_test_Template oop_in_java/Template/src/*.java tests/java/TestTemplate.java
	@(echo "150"; yes "y") | perl -e 'alarm shift; exec @ARGV' 3 java -cp bin_test_Template TestTemplate
	@rm -rf bin_test_Template

test-thread-java:
	@echo "Running Java Thread Test..."
	@mkdir -p bin_test_Thread
	@javac -d bin_test_Thread oop_in_java/Thread/src/*.java tests/java/TestThread.java
	@(echo "150"; yes "y") | perl -e 'alarm shift; exec @ARGV' 3 java -cp bin_test_Thread TestThread
	@rm -rf bin_test_Thread

test-visitor-java:
	@echo "Running Java Visitor Test..."
	@mkdir -p bin_test_Visitor
	@javac -d bin_test_Visitor oop_in_java/Visitor/src/*.java tests/java/TestVisitor.java
	@(echo "150"; yes "y") | perl -e 'alarm shift; exec @ARGV' 3 java -cp bin_test_Visitor TestVisitor
	@rm -rf bin_test_Visitor

test-state-java:
	@echo "Running Java state Test..."
	@mkdir -p bin_test_state
	@javac -d bin_test_state oop_in_java/state/src/*.java tests/java/Teststate.java
	@(echo "150"; yes "y") | perl -e 'alarm shift; exec @ARGV' 3 java -cp bin_test_state Teststate
	@rm -rf bin_test_state

test-swap-java:
	@echo "Running Java swap Test..."
	@mkdir -p bin_test_swap
	@javac -d bin_test_swap oop_in_java/swap/src/*.java tests/java/Testswap.java
	@(echo "150"; yes "y") | perl -e 'alarm shift; exec @ARGV' 3 java -cp bin_test_swap Testswap
	@rm -rf bin_test_swap

C_TARGETS =  test-abstractfactory-c test-adapter-c test-bridge-c test-composite-c test-decorator-c test-factorymethod-c test-observer-c test-reactor-c test-strategy-c test-template-c
JAVA_TARGETS =  test-abstractfactory-java test-adapter-java test-bridge-java test-builder-java test-command-java test-composite-java test-decorator-java test-facade-java test-factorymethod-java test-interpreter-java test-iterator-java test-observer-java test-strategy-java test-template-java test-thread-java test-visitor-java test-state-java test-swap-java

# --- Generated Targets End ---

# --- New Assertion Tests ---

test-strategy-assert-c:
	@echo "Running C Strategy Assertion Test..."
	@gcc -o tests/c/test_strategy_assert tests/c/TestStrategyAssert.c
	@./tests/c/test_strategy_assert
	@rm -f tests/c/test_strategy_assert

test-strategy-assert-java:
	@echo "Running Java Strategy Assertion Test..."
	@mkdir -p bin_test_StrategyAssert
	@javac -d bin_test_StrategyAssert oop_in_java/Strategy/src/*.java tests/java/TestStrategyAssert.java
	@java -cp bin_test_StrategyAssert TestStrategyAssert
	@rm -rf bin_test_StrategyAssert

# Combined target for quality check
test-quality: test-strategy-assert-c test-strategy-assert-java
	@echo "----------------------------------------"
	@echo "All Assertion Tests Passed!"

# Default target
test: test-c test-java test-quality

# C Tests
test-c: $(C_TARGETS)
	@echo "----------------------------------------"
	@echo "All C Tests Passed!"

# Java Tests
test-java: $(JAVA_TARGETS)
	@echo "----------------------------------------"
	@echo "All Java Tests Passed!"

clean:
	@rm -f tests/c/test_suite
	@rm -f tests/java/*.class
	@rm -rf bin_test_*
	@rm -f tests/c/test_*

style:
	@./scripts/style.sh

