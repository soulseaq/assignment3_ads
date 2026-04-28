# Assignment 3: Sorting and Searching Algorithm Analysis System

## A. Project Overview

This project implements and compares three algorithms in Java:

- **Insertion Sort** — basic sorting algorithm
- **Merge Sort** — advanced sorting algorithm  
- **Binary Search** — searching algorithm

The goal is to measure how fast each algorithm runs on arrays of different sizes and input types (random vs sorted), and to check whether the real results match what Big-O theory predicts.

---

## B. Algorithm Descriptions

### Insertion Sort (Basic Sort)

Insertion Sort goes through the array from left to right. For each element, it looks at the elements before it, shifts the larger ones one step to the right, and places the current element in the correct position. It works similarly to sorting a hand of playing cards.

| Case | Time Complexity |
|------|----------------|
| Best (already sorted) | O(n) |
| Average | O(n²) |
| Worst (reverse sorted) | O(n²) |

### Merge Sort (Advanced Sort)

Merge Sort splits the array in half repeatedly until each piece has one element, then merges those pieces back together in sorted order. It performs consistently regardless of whether the input is random or already sorted.

| Case | Time Complexity |
|------|----------------|
| Best | O(n log n) |
| Average | O(n log n) |
| Worst | O(n log n) |

### Binary Search

Binary Search looks at the middle element of a sorted array. If the target is smaller it searches the left half, if larger it searches the right half. It repeats this until it finds the target or runs out of elements to check.

| Case | Time Complexity |
|------|----------------|
| Best (target is the middle) | O(1) |
| Average | O(log n) |
| Worst | O(log n) |

---

## C. Experimental Results

Each experiment tests two input types:
- **Random** — array filled with randomly generated numbers
- **Sorted** — the same array after being sorted

The search target is always the middle element of the sorted array (`array[n/2]`), which guarantees it exists in the array.

### Run 1

| Size | Input | Insertion Sort (ns) | Merge Sort (ns) | Binary Search (ns) |
|------|-------|--------------------|-----------------|--------------------|
| Small (10) | Random | 2,250 | 5,333 | 1,166 |
| Small (10) | Sorted | 1,167 | 7,375 | 625 |
| Medium (100) | Random | 60,250 | 67,917 | 417 |
| Medium (100) | Sorted | 2,833 | 68,083 | 417 |
| Large (1000) | Random | 1,329,458 | 504,208 | 834 |
| Large (1000) | Sorted | 3,416 | 355,458 | 709 |

### Run 2

| Size | Input | Insertion Sort (ns) | Merge Sort (ns) | Binary Search (ns) |
|------|-------|--------------------|-----------------|--------------------|
| Small (10) | Random | 2,250 | 5,583 | 959 |
| Small (10) | Sorted | 1,291 | 6,833 | 584 |
| Medium (100) | Random | 40,083 | 66,875 | 583 |
| Medium (100) | Sorted | 2,875 | 69,042 | 667 |
| Large (1000) | Random | 2,125,084 | 114,416 | 1,167 |
| Large (1000) | Sorted | 3,375 | 61,916 | 666 |

### Run 3

| Size | Input | Insertion Sort (ns) | Merge Sort (ns) | Binary Search (ns) |
|------|-------|--------------------|-----------------|--------------------|
| Small (10) | Random | 2,375 | 27,458 | 1,250 |
| Small (10) | Sorted | 1,125 | 6,792 | 542 |
| Medium (100) | Random | 37,291 | 65,042 | 542 |
| Medium (100) | Sorted | 2,708 | 100,792 | 583 |
| Large (1000) | Random | 1,329,833 | 93,500 | 750 |
| Large (1000) | Sorted | 3,541 | 62,375 | 750 |

---

### Analysis

**1. Which sorting algorithm performed faster? Why?**

It depends on the array size. On small arrays (10 elements), Insertion Sort was consistently faster — around 2,000–2,400 ns compared to Merge Sort's 5,000–27,000 ns. On large arrays (1000 elements), Merge Sort was much faster — averaging around 200,000–500,000 ns, while Insertion Sort reached up to 2,125,084 ns on random data. The reason is that Insertion Sort is O(n²) and its time grows quadratically as the array gets bigger, while Merge Sort is O(n log n) and scales much better with size.

**2. How does performance change with input size?**

Insertion Sort on random data went from roughly 2,300 ns at size 10 to over 1,300,000–2,100,000 ns at size 1000 — a 600 to 900 times increase for a 100 times increase in size. This matches O(n²) behavior closely. Merge Sort went from around 5,000–27,000 ns at size 10 to 93,000–504,000 ns at size 1000 — a much smaller relative increase, matching O(n log n). Binary Search barely changed across all sizes, staying under 1,300 ns every time regardless of array size, which matches O(log n).

**3. How does sorted vs unsorted data affect performance?**

Insertion Sort benefits enormously from sorted input. At size 1000 it went from over 1,300,000 ns on random data down to just 3,400–3,500 ns on sorted data — roughly 400 times faster. This is because on a sorted array, each element is already in place and the inner loop never runs, giving O(n) behavior instead of O(n²). Merge Sort also improved on sorted data but by a smaller margin. Binary Search was not affected since it always runs on a sorted array.

**4. Do the results match expected Big-O complexity?**

Yes. Insertion Sort's time grew roughly quadratically with size, matching O(n²). Merge Sort's time grew much more slowly, matching O(n log n). Binary Search stayed nearly constant across all sizes, matching O(log n). The practical results confirmed the theoretical predictions across all three runs.

**5. Which searching algorithm is more efficient? Why?**

Binary Search is far more efficient than Linear Search. Across all three runs it finished in under 1,300 ns even on 1000 elements, because it only needs about 10 comparisons (log₂(1000) ≈ 10). Linear Search could need up to 1000 comparisons in the worst case. The advantage grows even larger on bigger arrays — at one million elements, Binary Search still needs only about 20 steps.

**6. Why does Binary Search require a sorted array?**

Binary Search works by looking at the middle element and deciding which half of the array to search next. This decision only makes sense when the array is sorted. If the array is unsorted, there is no way to know which half contains the target, and the algorithm would skip over it and return the wrong answer.

---

## D. Screenshots

## E. Reflection

This assignment made the difference between O(n²) and O(n log n) very concrete. Seeing Insertion Sort take over two million nanoseconds on just 1000 random elements while Merge Sort handled the same data in around 100,000–500,000 ns made the gap feel real in a way that reading formulas alone never did. It was also surprising to see Insertion Sort beat Merge Sort on small arrays — a reminder that Big-O describes how an algorithm scales, not how fast it is in absolute terms at small sizes.

The most interesting result was how dramatically sorted input improved Insertion Sort. On sorted data it dropped to under 4,000 ns even at size 1000, faster than everything else. This showed that choosing the right algorithm depends not just on the size of the data but also on what you already know about it. The small variations between the three runs also demonstrated that real execution times are affected by CPU load and system state, which is why running multiple tests and comparing them matters more than relying on a single result.
