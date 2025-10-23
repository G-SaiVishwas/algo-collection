import sys

def second_smallest(arr):
    if len(arr) < 2:
        return -1

    small = sys.maxsize
    second_small = sys.maxsize

    for num in arr:
        if num < small:
            second_small = small
            small = num
        elif small < num < second_small:
            second_small = num

    return second_small

def second_largest(arr):
    if len(arr) < 2:
        return -1

    large = -sys.maxsize - 1
    second_large = -sys.maxsize - 1

    for num in arr:
        if num > large:
            second_large = large
            large = num
        elif second_large < num < large:
            second_large = num

    return second_large

if __name__ == "__main__":
    arr = [1, 2, 4, 7, 7, 5]
    sS = second_smallest(arr)
    sL = second_largest(arr)
    print("Second smallest is", sS)
    print("Second largest is", sL)
