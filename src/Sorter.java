import java.util.Random;
import java.util.Arrays;

public class Sorter {

    // Insertion Sort - O(n^2)
    // Builds sorted array one element at a time by inserting each element into its correct position
    public void basicSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            // Shift elements greater than key one position to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Merge Sort - O(n log n)
    // Recursively splits array in half, sorts each half, then merges them back together
    public void advancedSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    // Recursively divides array into halves until single elements remain
    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    // Merges two sorted subarrays back into one sorted array
    private void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr  = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            arr[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length)  arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    // Prints all elements of the array to the console
    public void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println(" ]");
    }

    // Generates an array of given size filled with random integers between 0 and 9999
    public int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = random.nextInt(10000);
        return arr;
    }
}