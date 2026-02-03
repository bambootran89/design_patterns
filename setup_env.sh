#!/bin/bash

# setup_env.sh
# Script to setup the development environment for Design Patterns (C and Java)

set -e

echo "Starting environment setup..."

# Function to check if a command exists
command_exists() {
    command -v "$1" >/dev/null 2>&1
}

OS="$(uname -s)"
echo "Detected OS: $OS"

if [ "$OS" = "Linux" ]; then
    # Assume Debian/Ubuntu for now as per user context
    if command_exists apt-get; then
        echo "Detected apt-get. Updating and installing dependencies..."
        sudo apt-get update
        sudo apt-get install -y gcc make openjdk-17-jdk clang-format cppcheck
    else
        echo "Warning: apt-get not found. Manual installation required for non-Debian Linux."
    fi
elif [ "$OS" = "Darwin" ]; then
    # MacOS
    # 1. Check for Homebrew
    if ! command_exists brew; then
        echo "Homebrew not found. Installing Homebrew..."
        /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
    else
        echo "Homebrew is already installed."
    fi

    # 2. Install Dependencies
    echo "Installing GCC, OpenJDK, clang-format, cppcheck via Brew..."
    brew install gcc openjdk clang-format cppcheck make
    
    # Suggest adding java to path if needed
    echo "Note: You might need to add java to your PATH manually if not already there."
else
    echo "Unsupported OS: $OS. Please install dependencies manually."
fi

echo "Dependencies installed."

# Run Style Checks
if [ -f "./scripts/style.sh" ]; then
    echo "Running Style Checks..."
    ./scripts/style.sh
else
    echo "Warning: scripts/style.sh not found."
fi

# Run Tests
if [ -f "Makefile" ]; then
    echo "Running Tests..."
    make test
else
    echo "Warning: Makefile not found."
fi

echo "Environment setup complete! You are ready to run the Design Patterns."
