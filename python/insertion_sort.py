# Insertion Sort in Python

def insertion_sort(arr):
    # Traverse from 1 to len(arr)
    for i in range(1, len(arr)):
        key = arr[i]        # Current element to be inserted
        j = i - 1

        # Move elements of arr[0..i-1], that are greater than key,
        # one position ahead to make space for key
        while j >= 0 and key < arr[j]:
            arr[j + 1] = arr[j]
            j -= 1

        # Insert the key element at correct position
        arr[j + 1] = key

# Driver code
arr = [12, 11, 13, 5, 6]
print("Original array:", arr)

insertion_sort(arr)
print("Sorted array:", arr)
