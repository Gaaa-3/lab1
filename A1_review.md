## Summary

The repository contains real JMH benchmark code, all required dataset generators, and sorting implementations for Bubble Sort, Quick Sort, Radix Sort, and `Arrays.sort(int[])`. The submission still misses a core algorithm requirement because the radix implementation is decimal/base-10 rather than the required base-`256`, four-pass signed-int variant.

## Strengths

- `assignment/SortingBenchmark2/pom.xml` contains real JMH dependencies and shade-plugin packaging.
- `assignment/SortingBenchmark2/src/main/java/com/example/SortingBenchmark.java` benchmarks all four algorithms across random, sorted, reverse, and nearly sorted inputs.
- `assignment/SortingBenchmark2/src/main/java/com/example/SortVerifier.java` contains both sortedness checking and comparison against `Arrays.sort()`.
- `assignment/Read Me.txt` contains a substantive analytical write-up and correctly acknowledges major limitations in the current implementations.

## Findings

- Major: `assignment/SortingBenchmark2/src/main/java/com/example/RadixSRT.java` is a decimal LSD radix sort using `count[10]` and repeated `/ exp % 10` passes. That is not the required Assignment 1 radix sort, which must use base `256`, exactly `4` passes, and correct signed-int handling.
- Major: `assignment/Read Me.txt` explicitly states that Radix Sort crashes on inputs containing negative numbers. That confirms the repository does not satisfy the required negative-number support.
- Moderate: correctness logic exists in `assignment/SortingBenchmark2/src/main/java/com/example/SortVerifier.java`, but the repository does not contain a tracked execution path that actually runs it against the benchmarked algorithms.

## Requirement Checklist

- Java source code: Present
- Real JMH benchmark source: Present
- Build descriptor operational as submitted: Present
- Analytical report in submitted format: Present
- Bubble Sort with early exit: Present
- In-place Quick Sort with identifiable pivot strategy: Present
- LSD Radix Sort, base `256`, `4` passes, negative support: Fail
- `Arrays.sort(int[])` benchmark/reference: Present
- Uniform random dataset: Present
- Sorted dataset: Present
- Reverse-sorted dataset: Present
- Nearly sorted dataset with about `1%` swaps: Present
- Correctness check against `Arrays.sort()`: Partial
- Explicit sortedness check: Partial

## Verdict

The benchmark harness and dataset coverage are real, but the submission misses a core assignment requirement because the radix implementation is the wrong algorithm for this assignment. Not evidencing actual correctness-check execution further weakens the submission.
