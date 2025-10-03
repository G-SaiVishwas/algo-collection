#include <bits/stdc++.h>
using namespace std;

// stable counting sort by digit (base = 10)
void countingSortByDigit(vector<int>& arr, int exp) {
    int n = arr.size();
    vector<int> output(n);
    int count[10] = {0};

    // count occurrences of digit (arr[i] / exp) % 10
    for (int i = 0; i < n; ++i) {
        int digit = (arr[i] / exp) % 10;
        ++count[digit];
    }
    // cumulative
    for (int i = 1; i < 10; ++i) count[i] += count[i - 1];

    // build output (iterate from end for stability)
    for (int i = n - 1; i >= 0; --i) {
        int digit = (arr[i] / exp) % 10;
        output[count[digit] - 1] = arr[i];
        --count[digit];
    }

    // copy back
    for (int i = 0; i < n; ++i) arr[i] = output[i];
}

void radixSort(vector<int>& arr) {
    if (arr.empty()) return;
    int maxVal = *max_element(arr.begin(), arr.end());
    // Do counting sort for every digit (exp = 1, 10, 100, ...)
    for (int exp = 1; maxVal / exp > 0; exp *= 10) {
        countingSortByDigit(arr, exp);
    }
}

// Example usage (non-negative integers)
int main() {
    vector<int> a = {170, 45, 75, 90, 802, 24, 2, 66};
    radixSort(a);
    for (int v : a) cout << v << " ";
    cout << "\n";
    return 0;
}
