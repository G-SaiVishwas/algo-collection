// Algorithm: Binary Search (Iterative)
// Description: Finds target in sorted array using O(log n) comparisons.
// Usage: Run with `node binary-search.js`.
function binarySearch(data, target) {
  let left = 0;
  let right = data.length - 1;

  while (left <= right) {
    const mid = Math.floor((left + right) / 2);
    if (data[mid] === target) {
      return mid;
    }
    if (data[mid] < target) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }
  return -1;
}

const values = [1, 4, 6, 8, 10, 13];
const target = 8;
const result = binarySearch(values, target);
console.log(result >= 0 ? `Found ${target} at index ${result}` : `${target} not found`);
