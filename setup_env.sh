#!/bin/bash

# setup_env.sh
# Script to setup the development environment for Design Patterns (C and Java)

set -e

echo "Starting environment setup..."

# Function to check if a command exists
command_exists() {
    command -v "$1" >/dev/null 2>&1
}

# 1. Check for Homebrew (MacOS Package Manager)
if ! command_exists brew; then
    echo "Homebrew not found. Installing Homebrew..."
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
else
    echo "Homebrew is already installed."
fi

# 2. Check for GCC (for C)
if ! command_exists gcc; then
    echo "GCC not found. Installing GCC..."
    brew install gcc
else
    echo "GCC is installed: $(gcc --version | head -n 1)"
fi

# 3. Check for Java (JDK)
if ! command_exists java; then
    echo "Java not found. Installing OpenJDK..."
    brew install openjdk
    
    # Suggest adding to path if needed (simplified for this script)
    echo "Note: You might need to add java to your PATH permanently."
else
    echo "Java is installed: $(java -version 2>&1 | head -n 1)"
fi

echo "Environment setup complete! You are ready to run the Design Patterns."
