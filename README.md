# Counting-Inversions

This is a Java program that demonstrates two methods of counting inversions in an array of integers, brute force and dive and conquer.

## Description
The program generates an array of 10000 random integers between 1000 and 1000000 (inclusive). It then uses the two methods to count the number of inversions in the array.

The brute force approach compares each pair of elements in the array and counts the number of inversions. The time complexity of this method is O(n^2).

The divide and conquer approach uses the merge sort algorithm to count the number of inversions. The time complexity of this method is O(nlogn).

## Example Output
Brute force method:<br>
Number of inversions: 24717929<br>
Execution time in milliseconds: 5403

Divide and conquer method:<br>
Number of inversions: 24717929<br>
Execution time in milliseconds: 15
