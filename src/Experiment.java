import java.util.Arrays;
import java.util.Random;

public class Experiment {

    private final Sorter sorter;
    private final Searcher searcher;
    private final Random random = new Random();

    public Experiment(Sorter sorter, Searcher searcher) {
        this.sorter = sorter;
        this.searcher = searcher;
    }

    // Measures time in nanoseconds to sort a copy of the given array
    public long measureSortTime(int[] arr, String type) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        long start = System.nanoTime();
        if (type.equals("basic")) sorter.basicSort(copy);
        else sorter.advancedSort(copy);
        return System.nanoTime() - start;
    }

    // Measures time in nanoseconds to search for target in the given sorted array
    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        return System.nanoTime() - start;
    }

    // Runs all experiments across three array sizes and two input types (random and sorted)
    public void runAllExperiments() {
        int[] sizes  = {10, 100, 1000};
        String[] labels = {"Small (10)", "Medium (100)", "Large (1000)"};

        System.out.println("=".repeat(90));
        System.out.println("                          PERFORMANCE RESULTS");
        System.out.println("=".repeat(90));
        System.out.printf("%-14s | %-8s | %-22s | %-20s | %-18s%n",
                "Size", "Input", "Insertion Sort (ns)", "Merge Sort (ns)", "Binary Search (ns)");
        System.out.println("-".repeat(90));

        for (int s = 0; s < sizes.length; s++) {
            int size = sizes[s];

            int[] randomArr = sorter.generateRandomArray(size);
            int[] sorted = Arrays.copyOf(randomArr, size);
            sorter.advancedSort(sorted);

            // Use middle element as search target to guarantee it exists in the array
            int target = sorted[size / 2];
            System.out.println("  Searching for: " + target);

            long insRandom  = measureSortTime(randomArr, "basic");
            long merRandom  = measureSortTime(randomArr, "advanced");
            long srchRandom = measureSearchTime(sorted, target);

            System.out.printf("%-14s | %-8s | %-22d | %-20d | %-18d%n",
                    labels[s], "Random", insRandom, merRandom, srchRandom);

            long insSorted = measureSortTime(sorted, "basic");
            long merSorted = measureSortTime(sorted, "advanced");
            long srchSorted = measureSearchTime(sorted, target);

            System.out.printf("%-14s | %-8s | %-22d | %-20d | %-18d%n",
                    "", "Sorted", insSorted, merSorted, srchSorted);

            System.out.println("-".repeat(90));
        }
    }
}