def find_largest(arr):
    arr.sort()
    return arr[-1]

if __name__ == "__main__":
    arr1 = [2, 5, 1, 3, 0]
    print("The Largest element in the array is:", find_largest(arr1))

    arr2 = [8, 10, 5, 7, 9]
    print("The Largest element in the array is:", find_largest(arr2))
