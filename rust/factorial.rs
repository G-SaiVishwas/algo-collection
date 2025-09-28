// Algorithm: Factorial (Recursive)
// Description: Calculates n! recursively to illustrate basic recursion patterns.
// Usage: Run with `rustc factorial.rs && ./factorial`.
fn factorial(n: u64) -> u64 {
    match n {
        0 | 1 => 1,
        _ => n * factorial(n - 1),
    }
}

fn main() {
    let value = 6;
    println!("{}! = {}", value, factorial(value));
}
