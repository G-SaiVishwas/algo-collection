/*
 * Algorithm: Linear Search
 * Description: Scans each element sequentially to find the target; runs in O(n) time.
 * Usage: Compile with `g++ linear-search.cpp -o linear-search` and run `./linear-search`.
 */
#include <iostream>
#include <vector>

int linear_search(const std::vector<int>& data, int target) {
    for (size_t i = 0; i < data.size(); ++i) {
        if (data[i] == target) {
            return static_cast<int>(i);
        }
    }
    return -1;
}

int main() {
    std::vector<int> values {9, 2, 7, 4, 3};
    int target = 4;

    int index = linear_search(values, target);
    if (index >= 0) {
        std::cout << "Found " << target << " at index " << index << std::endl;
    } else {
        std::cout << target << " not found" << std::endl;
    }
    return 0;
}
