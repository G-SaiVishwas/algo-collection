/*
 * Algorithm: Binary Search (Iterative)
 * Description: Searches for a target value in a sorted array in O(log n) time.
 * Usage: Compile with `gcc binary-search.c -o binary-search` and run `./binary-search`.
 */
#include <stdio.h>

int binary_search(int arr[], int size, int target) {
    int left = 0;
    int right = size - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return -1;
}

int main(void) {
    int data[] = {1, 3, 5, 7, 9, 11};
    int size = sizeof(data) / sizeof(data[0]);
    int target = 7;

    int index = binary_search(data, size, target);

    if (index >= 0) {
        printf("Found %d at index %d\n", target, index);
    } else {
        printf("Value %d not found\n", target);
    }

    return 0;
}
