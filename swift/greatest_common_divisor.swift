// Algorithm: Greatest Common Divisor (Euclidean Algorithm)
// Description: Recursively computes gcd(a, b) in O(log min(a, b)).
// Usage: Run with `swift greatest_common_divisor.swift`.
import Foundation

func gcd(_ a: Int, _ b: Int) -> Int {
    if b == 0 {
        return abs(a)
    }
    return gcd(b, a % b)
}

let a = 84
let b = 18
print("gcd(\(a), \(b)) = \(gcd(a, b))")
