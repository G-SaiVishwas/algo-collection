#include <iostream>
#include <vector>
using namespace std;

// Function to perform selection sort
void selectionSort(vector<int>& arr) {
    int n = arr.size();

    for (int i = 0; i < n - 1; i++) {
        // Assume the minimum is the first element
        int minIndex = i;

        // Find the index of the smallest element in the remaining unsorted array
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }

        // Swap the found minimum element with the first element of unsorted part
        if (minIndex != i) {
            swap(arr[i], arr[minIndex]);
        }
    }
}

// Utility function to print an array
void printArray(const vector<int>& arr) {
    for (int num : arr) {
        cout << num << " ";
    }
    cout << endl;
}

// Example usage
int main() {
    vector<int> arr = {64, 25, 12, 22, 11};

    cout << "Original array: ";
    printArray(arr);

    selectionSort(arr);

    cout << "Sorted array: ";
    printArray(arr);

    return 0;
}
