// Algorithm: Binary Search (Iterative)
// Description: Finds a target in a sorted slice in O(log n) time.
// Usage: Run with `go run binary-search.go`.
package main

import "fmt"

func binarySearch(data []int, target int) int {
    left, right := 0, len(data)-1
    for left <= right {
        mid := left + (right-left)/2
        if data[mid] == target {
            return mid
        }
        if data[mid] < target {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return -1
}

func main() {
    values := []int{2, 4, 6, 8, 10, 12}
    target := 10
    index := binarySearch(values, target)
    if index >= 0 {
        fmt.Printf("Found %d at index %d\n", target, index)
    } else {
        fmt.Printf("Value %d not found\n", target)
    }
}
