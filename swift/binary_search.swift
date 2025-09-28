// Algorithm: Binary Search (Iterative)
// Description: Searches a sorted array for a target in O(log n) time.
// Usage: Run with `swift binary_search.swift`.
import Foundation

func binarySearch(data: [Int], target: Int) -> Int? {
    var left = 0
    var right = data.count - 1

    while left <= right {
        let mid = left + (right - left) / 2
        if data[mid] == target {
            return mid
        }
        if data[mid] < target {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return nil
}

let values = [3, 5, 7, 9, 11]
let target = 9
if let index = binarySearch(data: values, target: target) {
    print("Found \(target) at index \(index)")
} else {
    print("\(target) not found")
}
