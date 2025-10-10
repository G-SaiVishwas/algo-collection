from collections import Counter

def frequency_of_elements(arr):
    freq = Counter(arr)
    for num, count in freq.items():
        print(f"{num}: {count}")

if __name__ == "__main__":
    arr = [1, 2, 2, 3, 3, 3, 4]
    frequency_of_elements(arr)

