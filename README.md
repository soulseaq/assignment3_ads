Assignment 3: Sorting and Searching Algorithm Analysis System

A. Project Overview

This project implements and compares three algorithms in Java: Insertion Sort as a basic sorting algorithm, Merge Sort as an advanced sorting algorithm, and Binary Search as a searching algorithm. The objective is to measure and analyze their execution times on arrays of different sizes and input types (random and sorted), and to evaluate whether the observed results align with theoretical Big-O complexity.

B. Algorithm Descriptions

Insertion Sort

Insertion Sort iterates through the array from left to right. For each element, it compares it with previous elements, shifts larger elements to the right, and inserts the current element into its correct position. This process is similar to sorting playing cards by hand.

Best case: O(n)
Average case: O(n²)
Worst case: O(n²)

Merge Sort

Merge Sort follows a divide-and-conquer approach. It repeatedly divides the array into smaller halves until each subarray contains a single element, then merges them back together in sorted order. Its performance remains consistent regardless of input type.

Best case: O(n log n)
Average case: O(n log n)
Worst case: O(n log n)

Binary Search

Binary Search operates on a sorted array. It repeatedly checks the middle element and eliminates half of the remaining elements based on comparison, continuing until the target is found or the search space is empty.

Best case: O(1)
Average case: O(log n)
Worst case: O(log n)

C. Experimental Results

Each experiment was conducted using two input types: random arrays and sorted arrays. The search target was selected as the middle element of the sorted array (array[n/2]) to ensure its presence.

Run 1

Size: Small (10)
Random: Insertion Sort 2250 ns, Merge Sort 5333 ns, Binary Search 1166 ns
Sorted: Insertion Sort 1167 ns, Merge Sort 7375 ns, Binary Search 625 ns

Size: Medium (100)
Random: Insertion Sort 60250 ns, Merge Sort 67917 ns, Binary Search 417 ns
Sorted: Insertion Sort 2833 ns, Merge Sort 68083 ns, Binary Search 417 ns

Size: Large (1000)
Random: Insertion Sort 1329458 ns, Merge Sort 504208 ns, Binary Search 834 ns
Sorted: Insertion Sort 3416 ns, Merge Sort 355458 ns, Binary Search 709 ns

Run 2

Size: Small (10)
Random: Insertion Sort 2250 ns, Merge Sort 5583 ns, Binary Search 959 ns
Sorted: Insertion Sort 1291 ns, Merge Sort 6833 ns, Binary Search 584 ns

Size: Medium (100)
Random: Insertion Sort 40083 ns, Merge Sort 66875 ns, Binary Search 583 ns
Sorted: Insertion Sort 2875 ns, Merge Sort 69042 ns, Binary Search 667 ns

Size: Large (1000)
Random: Insertion Sort 2125084 ns, Merge Sort 114416 ns, Binary Search 1167 ns
Sorted: Insertion Sort 3375 ns, Merge Sort 61916 ns, Binary Search 666 ns

Run 3

Size: Small (10)
Random: Insertion Sort 2375 ns, Merge Sort 27458 ns, Binary Search 1250 ns
Sorted: Insertion Sort 1125 ns, Merge Sort 6792 ns, Binary Search 542 ns

Size: Medium (100)
Random: Insertion Sort 37291 ns, Merge Sort 65042 ns, Binary Search 542 ns
Sorted: Insertion Sort 2708 ns, Merge Sort 100792 ns, Binary Search 583 ns

Size: Large (1000)
Random: Insertion Sort 1329833 ns, Merge Sort 93500 ns, Binary Search 750 ns
Sorted: Insertion Sort 3541 ns, Merge Sort 62375 ns, Binary Search 750 ns

D. Analysis

Sorting performance

Insertion Sort performs better on small arrays, while Merge Sort becomes significantly faster on larger arrays. This is because Insertion Sort has quadratic time complexity, whereas Merge Sort has logarithmic scaling combined with linear merging, resulting in better performance as input size increases.

Effect of input size

Insertion Sort shows a dramatic increase in execution time as array size grows, consistent with O(n²). Merge Sort increases more gradually, consistent with O(n log n). Binary Search shows minimal variation, confirming O(log n) behavior.

Sorted versus unsorted input

Insertion Sort performs significantly faster on sorted arrays due to reduced comparisons, achieving near-linear performance. Merge Sort shows minor improvement with sorted input, while Binary Search is unaffected because it always operates on sorted data.

Consistency with Big-O theory

The experimental results align with theoretical expectations. Insertion Sort demonstrates quadratic growth, Merge Sort demonstrates logarithmic-linear growth, and Binary Search maintains logarithmic behavior.

Searching efficiency

Binary Search is significantly more efficient than Linear Search due to its logarithmic complexity. It requires far fewer comparisons, especially as input size increases.

Requirement for sorted data in Binary Search

Binary Search depends on sorted input because it eliminates half of the search space based on comparisons with the middle element. Without sorting, this elimination strategy is invalid.

E. Screenshots

Run 1: docs/screenshots/run1.png
Run 2: docs/screenshots/run2.png
Run 3: docs/screenshots/run3.png

F. Reflection

This assignment demonstrated the practical differences between algorithm complexities. The performance gap between quadratic and logarithmic-linear algorithms became clear through execution time measurements. Insertion Sort proved efficient for small or already sorted datasets, while Merge Sort showed strong scalability. Binary Search consistently maintained high efficiency regardless of input size.

The results also highlighted that theoretical complexity does not always determine performance for small inputs. Additionally, variations across runs showed the influence of system conditions, reinforcing the importance of repeated testing for reliable conclusions.
