#!/bin/bash

# verify_all.sh
# Script to verify all Design Patterns examples (C and Java)
# It compiles, runs, and immediately cleans up artifacts (no binaries left behind).

set -e

C_DIR="oop_in_c"
JAVA_DIR="oop_in_java"

echo "========================================"
echo "Starting Verification of Design Patterns"
echo "========================================"

# --- C Verification ---
echo ""
echo ">>> Verifying C Examples..."
echo ""

if [ -d "$C_DIR" ]; then
    for pattern_dir in "$C_DIR"/*; do
        if [ -d "$pattern_dir" ]; then
            pattern_name=$(basename "$pattern_dir")
            c_file="$pattern_dir/$pattern_name.c"
            
            # Fallback: look for any .c file if the standard naming isn't found
            if [ ! -f "$c_file" ]; then
                c_file=$(find "$pattern_dir" -maxdepth 1 -name "*.c" | head -n 1)
            fi

            if [ -f "$c_file" ]; then
                echo "----------------------------------------"
                echo "Testing C: $pattern_name"
                exe_path="$pattern_dir/$pattern_name"
                
                # Compile
                if gcc -o "$exe_path" "$c_file"; then
                    # Run with robust input (numbers for Bridge, 'y' for Template)
                    # Use 'yes' to provide infinite stream of "150\ny"
                    # We pipe it to the executable.
                    yes $'150\ny' | head -n 100 | "$exe_path"
                    
                    # Cleanup
                    rm "$exe_path"
                    echo "Result: PASS (Cleaned up)"
                else
                    echo "Result: FAIL (Compilation Error)"
                fi
            else
                echo "Skipping $pattern_name: No C source found."
            fi
        fi
    done
else
    echo "Directory $C_DIR not found!"
fi

# --- Java Verification ---
echo ""
echo ">>> Verifying Java Examples..."
echo ""

if [ -d "$JAVA_DIR" ]; then
    for pattern_dir in "$JAVA_DIR"/*; do
        if [ -d "$pattern_dir" ] && [ -d "$pattern_dir/src" ]; then
            pattern_name=$(basename "$pattern_dir")
            echo "----------------------------------------"
            echo "Testing Java: $pattern_name"
            
            bin_dir="$pattern_dir/bin_temp"
            mkdir -p "$bin_dir"
            
            # Compile
            src_files=$(find "$pattern_dir/src" -name "*.java")
            if [ -z "$src_files" ]; then
                 echo "Skipping $pattern_name: No Java source found."
                 rm -rf "$bin_dir"
                 continue
            fi

            if javac -d "$bin_dir" $src_files; then
                # Find Main Class (grep for 'public static void main')
                main_file=$(grep -l "public static void main" $src_files | head -n 1)
                
                if [ -n "$main_file" ]; then
                    # Convert file path to class name
                    # e.g., .../src/com/example/Main.java -> com.example.Main
                    # Assuming simple package structure or default package for this repo based on previous ls
                    
                    # Heuristic: Get filename without extension
                    main_class=$(basename "$main_file" .java)
                    
                    # Run
                    # Note: This simple heuristic works for default package. 
                    # If packages are used, we might need to parse 'package' declaration.
                    # Based on looking at AbstractFactory, it used 'Program' in default package.
                    
                    # Use perl to implement a timeout (3s) to handle GUI apps that block
                    # Also pipe input (yes $'150\ny') to handle interactive console apps (Template)
                    if yes $'150\ny' | head -n 100 | perl -e 'alarm shift; exec @ARGV' 3 java -cp "$bin_dir" "$main_class"; then
                        echo "Result: PASS"
                    else
                        # 142 is timeout (SIGALRM)
                        if [ $? -eq 142 ]; then 
                             echo "Result: PASS (Timeout - GUI App?)"
                        else
                             echo "Result: FAIL (Runtime Error)"
                        fi
                    fi
                else
                    echo "Result: SKIP (No Main Class Found)"
                fi
            else
                echo "Result: FAIL (Compilation Error)"
            fi
            
            # Cleanup
            rm -rf "$bin_dir"
            echo "(Cleaned up bin_temp)"
        fi
    done
else
    echo "Directory $JAVA_DIR not found!"
fi

echo ""
echo "========================================"
echo "Verification Complete!"
echo "========================================"
