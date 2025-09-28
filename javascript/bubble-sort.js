// Algorithm: Bubble Sort
// Description: Swaps adjacent elements to sort array; simple O(n^2) demo.
// Usage: Run with `node bubble-sort.js`.
function bubbleSort(data) {
  let swapped = true;
  while (swapped) {
    swapped = false;
    for (let i = 1; i < data.length; i += 1) {
      if (data[i - 1] > data[i]) {
        [data[i - 1], data[i]] = [data[i], data[i - 1]];
        swapped = true;
      }
    }
  }
  return data;
}

const values = [9, 3, 7, 1, 5];
console.log("Bubble sorted values:", bubbleSort(values.slice()));
