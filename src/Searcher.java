public class Searcher {

    // Binary Search - O(log n)
    // Requires a sorted array. Repeatedly halves the search space by comparing
    // the target to the middle element, eliminating half the remaining elements each step.
    public int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // avoids integer overflow
            if (arr[mid] == target)      return mid;
            else if (arr[mid] < target)  left = mid + 1;  // search right half
            else                         right = mid - 1; // search left half
        }
        return -1; // target not found
    }
}