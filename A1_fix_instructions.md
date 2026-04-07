The main repair target is radix-sort compliance.

Action items:

- Replace `assignment/SortingBenchmark2/src/main/java/com/example/RadixSRT.java` with a base-`256`, exactly four-pass LSD radix sort for signed `int[]` values.
- Add a tracked correctness-check runner that actually invokes `SortVerifier.assertCorrect(...)` on each algorithm and dataset.
- Keep `assignment/Read Me.txt` aligned with the actual benchmark behavior after the code fixes.

Recommended order:

1. Fix the radix implementation.
2. Add and run correctness verification.
3. Regenerate benchmark results and update the text report.
