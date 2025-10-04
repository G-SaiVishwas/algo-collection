#include <bits/stdc++.h>
using namespace std;

// Bucket sort for numbers in [minVal, maxVal)
void bucketSort(vector<double>& arr, double minVal, double maxVal, int k = -1) {
    int n = arr.size();
    if (n <= 1) return;
    if (k <= 0) k = n; // default # buckets = n

    double range = maxVal - minVal;
    if (range <= 0) return; // all equal or invalid range

    vector<vector<double>> buckets(k);

    // distribute
    for (double x : arr) {
        int idx = int(((x - minVal) / range) * k);
        if (idx == k) idx = k - 1; // handle x == maxVal edge-case
        buckets[idx].push_back(x);
    }

    // sort each bucket and concatenate
    arr.clear();
    for (auto &b : buckets) {
        if (!b.empty()) {
            sort(b.begin(), b.end()); // stable sort optional: stable_sort(b.begin(), b.end());
            arr.insert(arr.end(), b.begin(), b.end());
        }
    }
}

// Example usage
int main() {
    vector<double> a = {0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68};
    double minV = 0.0, maxV = 1.0;
    bucketSort(a, minV, maxV);
    for (double v : a) cout << v << " ";
    cout << "\n";
    return 0;
}
