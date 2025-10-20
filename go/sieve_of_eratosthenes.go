// Algorithm: Sieve of Eratosthenes
// Description: Generates all prime numbers up to a given limit using an efficient O(n log log n) method.
// Usage: Run with `go run sieve.go`.

package main

import (
	"fmt"
	"math"
)

func sieve(limit int) []int {
	if limit < 2 { return []int{} }

	isPrime := make([]bool, limit+1)
	for i := 2; i <= limit; i++ { isPrime[i] = true }

	for num := 2; num <= int(math.Sqrt(float64(limit))); num++ {
		if isPrime[num] {
			for multiple := num * num; multiple <= limit; multiple += num {
				isPrime[multiple] = false
			}
		}
	}

	primes := []int{}
	for i, prime := range isPrime {
		if prime { primes = append(primes, i) }
	}

	return primes
}

func main() {
	limit := 50
	primes := sieve(limit)
	fmt.Printf("Primes up to %d: %v\n", limit, primes)
}