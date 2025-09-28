// Algorithm: Fibonacci (Iterative DP)
// Description: Builds Fibonacci numbers up to n using bottom-up dynamic programming in O(n) time.
// Usage: Run with `ts-node fibonacci.ts` or compile using `tsc`.
export {};

function fibonacci(n: number): number[] {
  if (n < 0) {
    throw new Error("n must be non-negative");
  }
  const sequence: number[] = [];
  for (let i = 0; i <= n; i += 1) {
    if (i === 0) {
      sequence.push(0);
    } else if (i === 1) {
      sequence.push(1);
    } else {
      sequence.push(sequence[i - 1] + sequence[i - 2]);
    }
  }
  return sequence;
}

const limit = 10;
console.log(`Fibonacci sequence up to index ${limit}:`, fibonacci(limit));
