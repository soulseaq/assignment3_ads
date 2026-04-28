import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Instantiate all required classes
        Sorter sorter = new Sorter();
        Searcher searcher = new Searcher();
        Experiment experiment = new Experiment(sorter, searcher);

        // Demo on a small array of 10 elements
        int[] small = sorter.generateRandomArray(10);
        System.out.println("Original:       "); sorter.printArray(small);

        int[] afterInsertion = Arrays.copyOf(small, small.length);
        sorter.basicSort(afterInsertion);
        System.out.println("Insertion Sort: "); sorter.printArray(afterInsertion);

        int[] afterMerge = Arrays.copyOf(small, small.length);
        sorter.advancedSort(afterMerge);
        System.out.println("Merge Sort:     "); sorter.printArray(afterMerge);

        // Binary search on sorted array using middle element as target
        int target = afterMerge[5];
        System.out.println("\nBinary Search for " + target + ":");
        int idx = searcher.search(afterMerge, target);
        System.out.println("  Found at index: " + idx);

        // Run full performance experiments
        System.out.println();
        experiment.runAllExperiments();
    }
}