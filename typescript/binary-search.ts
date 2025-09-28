// Algorithm: Binary Search (Iterative)
// Description: Locates a target in a sorted array with O(log n) comparisons.
// Usage: Run with `ts-node binary-search.ts` or compile using `tsc`.
export {};

function binarySearch(data: number[], target: number): number {
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

const values = [2, 5, 7, 9, 11];
const searchTarget = 7;
const index = binarySearch(values, searchTarget);
console.log(index >= 0 ? `Found ${searchTarget} at index ${index}` : `${searchTarget} not found`);
