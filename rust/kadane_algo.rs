// Algorithm: Kadane's Algorithm
// Description: Finds the maximum subarray sum in a slice in O(n) time using dynamic programming.
// Usage: Run with `rustc kadane.rs && ./kadane`.

fn kadane(arr: &[i32]) -> i32 {
    if arr.is_empty() {
        return 0;
    }

    let mut max_current = arr[0];
    let mut max_global = arr[0];

    for &num in &arr[1..] {
        max_current = i32::max(num, max_current + num);
        max_global = i32::max(max_global, max_current);
    }

    max_global
}

fn main() {
    let arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4];
    let max_sum = kadane(&arr);
    println!("Maximum subarray sum is {}", max_sum);
}