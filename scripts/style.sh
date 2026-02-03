#!/bin/bash

# scripts/style.sh: Style checker for C and Java
# Enforces Google Style with 88-char line limit and complexity checks.

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$ROOT_DIR"

EXIT_CODE=0

echo "========================================"
echo "Checking Style (Google + 88 chars)"
echo "========================================"

# --- 1. Java Checks (Checkstyle) ---
CHECKSTYLE_VER="10.13.0"
JAR_PATH="scripts/checkstyle-${CHECKSTYLE_VER}-all.jar"
JAR_URL="https://github.com/checkstyle/checkstyle/releases/download/checkstyle-${CHECKSTYLE_VER}/checkstyle-${CHECKSTYLE_VER}-all.jar"

if command -v java &> /dev/null; then
    if [ ! -f "$JAR_PATH" ]; then
        echo "[Java] Downloading Checkstyle $CHECKSTYLE_VER..."
        if command -v curl &> /dev/null; then
             curl -L "$JAR_URL" -o "$JAR_PATH"
        elif command -v wget &> /dev/null; then
             wget "$JAR_URL" -O "$JAR_PATH"
        else
             echo "Error: curl or wget not found. Cannot download Checkstyle."
             EXIT_CODE=1
        fi
    fi

    if [ -f "$JAR_PATH" ]; then
        echo "[Java] Running Checkstyle on oop_in_java..."
        # Checkstyle handles directory recursion
        java -jar "$JAR_PATH" -c config/checkstyle.xml oop_in_java
        if [ $? -ne 0 ]; then
            echo "[Java] Checkstyle FAILED."
            EXIT_CODE=1
        else
            echo "[Java] Checkstyle PASSED."
        fi
        
        # Also run formatting check (clang-format) on Java to be safe on physical layout
        if command -v clang-format &> /dev/null; then
             echo "[Java] Checking formatting with clang-format..."
             JAVA_FILES_CF=$(find oop_in_java -name "*.java")
             FAILED_J=0
             for file in $JAVA_FILES_CF; do
                 clang-format -n -Werror "$file"
                 if [ $? -ne 0 ]; then
                     echo "Format violation: $file"
                     FAILED_J=1
                 fi
             done
             if [ $FAILED_J -ne 0 ]; then
                 echo "[Java] clang-format FAILED."
                 EXIT_CODE=1
             fi
        fi
    fi
else
    echo "[Java] 'java' command not found. Skipping Java checks."
fi

# --- 2. C Checks (clang-format) ---
echo "[C] Checking formatting with clang-format..."
if command -v clang-format &> /dev/null; then
    # -n: Dry run, -Werror: Fail on warnings (format diffs)
    C_FILES=$(find oop_in_c \( -name "*.c" -o -name "*.h" \))
    
    if [ -z "$C_FILES" ]; then
        echo "[C] No C files found."
    else
        FAILED_C=0
        for file in $C_FILES; do
            clang-format -n -Werror "$file"
            if [ $? -ne 0 ]; then
                 echo "Format violation: $file"
                 FAILED_C=1
            fi
        done

        if [ $FAILED_C -ne 0 ]; then
            echo "[C] clang-format FAILED."
            EXIT_CODE=1
        else
            echo "[C] clang-format PASSED."
        fi
    fi
else
    echo "WARNING: clang-format not found. Install it for C style checks."
fi

# --- 3. C Complexity (cppcheck) ---
if command -v cppcheck &> /dev/null; then
    echo "[C] Checking complexity with cppcheck..."
    # --enable=style includes complexity warnings
    cppcheck --enable=style,performance,portability --error-exitcode=1 --suppress=missingIncludeSystem oop_in_c
    if [ $? -ne 0 ]; then
        echo "[C] cppcheck FAILED."
        EXIT_CODE=1
    else
        echo "[C] cppcheck PASSED."
    fi
else
    echo "[C] cppcheck not found. Skipping complexity check."
fi

exit $EXIT_CODE
