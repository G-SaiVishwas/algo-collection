"""
Algorithm: Binary Search (Iterative)
Description: Finds the index of a target in a sorted list in O(log n) time.
Usage: Run with `python binary_search.py`.
"""

def binary_search(data, target):
    left, right = 0, len(data) - 1
    while left <= right:
        mid = (left + right) // 2
        if data[mid] == target:
            return mid
        if data[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1


def main():
    values = [2, 4, 6, 8, 10, 12]
    target = 10
    index = binary_search(values, target)
    if index >= 0:
        print(f"Found {target} at index {index}")
    else:
        print(f"Value {target} not found")


if __name__ == "__main__":
    main()
