// Algorithm: Selection Sort
// Description: Repeatedly selects the minimum from the unsorted part; O(n^2) time.
// Usage: Run with `go run selection-sort.go`.
package main

import "fmt"

func selectionSort(data []int) {
    for i := 0; i < len(data); i++ {
        minIndex := i
        for j := i + 1; j < len(data); j++ {
            if data[j] < data[minIndex] {
                minIndex = j
            }
        }
        data[i], data[minIndex] = data[minIndex], data[i]
    }
}

func main() {
    values := []int{5, 3, 6, 2, 1}
    selectionSort(values)
    fmt.Println("Selection sorted values:", values)
}
