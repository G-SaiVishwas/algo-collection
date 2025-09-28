/*
 * Algorithm: Factorial (Recursive)
 * Description: Computes n! using recursion to demonstrate stack-based algorithms.
 * Usage: Compile with `gcc factorial.c -o factorial` and run `./factorial`.
 */
#include <stdio.h>

unsigned long long factorial(unsigned int n) {
    if (n == 0 || n == 1) {
        return 1ULL;
    }
    return n * factorial(n - 1);
}

int main(void) {
    unsigned int value = 5;
    unsigned long long result = factorial(value);
    printf("%u! = %llu\n", value, result);
    return 0;
}
