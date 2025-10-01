def quick_sort(data):
    if len(data)<2:
        return data
    else:
        pivot = data[0]
        less = [i for i in data[1:] if i<=pivot]
        greater = [i for i in data[1:] if i>pivot]
        return quick_sort(less) + [pivot] + quick_sort(greater)

def main():
    values = [99, 45, 23, 87, 33, 65, 12, 58]
    print(f"Unsorted list: {values}")
    sorted_values = quick_sort(values)
    print(f"Sorted list: {sorted_values}")

if __name__ == "__main__":
    main()
