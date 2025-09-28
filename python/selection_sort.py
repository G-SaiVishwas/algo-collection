"""
Algorithm: Selection Sort
Description: Selects the smallest item iteratively to sort the list; runs in O(n^2) time.
Usage: Run with `python selection_sort.py`.
"""

def selection_sort(data):
    for i in range(len(data)):
        min_index = i
        for j in range(i + 1, len(data)):
            if data[j] < data[min_index]:
                min_index = j
        data[i], data[min_index] = data[min_index], data[i]
    return data


def main():
    values = [7, 3, 9, 2, 5]
    sorted_values = selection_sort(values[:])
    print("Selection sorted values:", sorted_values)


if __name__ == "__main__":
    main()
