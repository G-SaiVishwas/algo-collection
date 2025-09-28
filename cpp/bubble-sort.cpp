/*
 * Algorithm: Bubble Sort
 * Description: Repeatedly swaps adjacent elements to sort an array in O(n^2) time.
 * Usage: Compile with `g++ bubble-sort.cpp -o bubble-sort` and run `./bubble-sort`.
 */
#include <iostream>
#include <vector>

void bubble_sort(std::vector<int>& data) {
    bool swapped = true;
    while (swapped) {
        swapped = false;
        for (size_t i = 1; i < data.size(); ++i) {
            if (data[i - 1] > data[i]) {
                std::swap(data[i - 1], data[i]);
                swapped = true;
            }
        }
    }
}

int main() {
    std::vector<int> values {5, 1, 4, 2, 8};
    bubble_sort(values);

    std::cout << "Bubble sorted values: ";
    for (int value : values) {
        std::cout << value << ' ';
    }
    std::cout << std::endl;
    return 0;
}
