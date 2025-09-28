// Algorithm: Binary Search (Iterative)
// Description: Locates a target in a sorted slice in O(log n) time using iterative bounds.
// Usage: Run with `rustc binary_search.rs && ./binary_search`.
fn binary_search(data: &[i32], target: i32) -> Option<usize> {
    let mut left: i32 = 0;
    let mut right: i32 = (data.len() as i32) - 1;

    while left <= right {
        let mid = left + ((right - left) / 2);
        let mid_index = mid as usize;
        if data[mid_index] == target {
            return Some(mid_index);
        }
        if data[mid_index] < target {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    None
}

fn main() {
    let values = [1, 4, 6, 8, 10];
    let target = 6;
    match binary_search(&values, target) {
        Some(index) => println!("Found {} at index {}", target, index),
        None => println!("{} not found", target),
    }
}
