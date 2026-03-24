package com.example;
import org.openjdk.jmh.annotations.*;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
@State(Scope.Thread)
public class SortingBenchmark {

    private static final int N = 1_000_000;
    private static final Random rng = new Random(42);

    private int[] uniform, sorted, reverse, nearly;

    @Setup(Level.Invocation)
    public void setup() {
        uniform = generateUniform();
        sorted  = generateSorted();
        reverse = generateReverse();
        nearly  = generateNearly();
    }

    // ===== DATASET GENERATORS =====
    private int[] generateUniform() {
        int[] a = new int[N];
        for (int i = 0; i < N; i++) a[i] = rng.nextInt();
        return a;
    }

    private int[] generateSorted() {
        int[] a = generateUniform();
        Arrays.sort(a);
        return a;
    }

    private int[] generateReverse() {
        int[] a = generateSorted();
        for (int i = 0, j = N - 1; i < j; i++, j--) {
            int tmp = a[i]; a[i] = a[j]; a[j] = tmp;
        }
        return a;
    }

    private int[] generateNearly() {
        int[] a = generateSorted();
        int swaps = N / 100;
        for (int i = 0; i < swaps; i++) {
            int x = rng.nextInt(N), y = rng.nextInt(N);
            int tmp = a[x]; a[x] = a[y]; a[y] = tmp;
        }
        return a;
    }

    @Benchmark public void bubble_uniform() { BubbleSRT.sort(uniform.clone()); }
    @Benchmark public void bubble_sorted()  { BubbleSRT.sort(sorted.clone()); }
    @Benchmark public void bubble_reverse() { BubbleSRT.sort(reverse.clone()); }
    @Benchmark public void bubble_nearly()  { BubbleSRT.sort(nearly.clone()); }

    @Benchmark public void quick_uniform() { int[] a = uniform.clone(); QuickSRT.QuickSort(a, 0, a.length - 1); }
    @Benchmark public void quick_sorted()  { int[] a = sorted.clone();  QuickSRT.QuickSort(a, 0, a.length - 1); }
    @Benchmark public void quick_reverse() { int[] a = reverse.clone(); QuickSRT.QuickSort(a, 0, a.length - 1); }
    @Benchmark public void quick_nearly()  { int[] a = nearly.clone();  QuickSRT.QuickSort(a, 0, a.length - 1); }


    @Benchmark public void radix_uniform() { RadixSRT.radixSort(uniform.clone()); }
    @Benchmark public void radix_sorted()  { RadixSRT.radixSort(sorted.clone()); }
    @Benchmark public void radix_reverse() { RadixSRT.radixSort(reverse.clone()); }
    @Benchmark public void radix_nearly()  { RadixSRT.radixSort(nearly.clone()); }

    @Benchmark public void arrays_uniform() { ArrSRT.javaSort(uniform.clone()); }
    @Benchmark public void arrays_sorted()  { ArrSRT.javaSort(sorted.clone()); }
    @Benchmark public void arrays_reverse() { ArrSRT.javaSort(reverse.clone()); }
    @Benchmark public void arrays_nearly()  { ArrSRT.javaSort(nearly.clone()); }
}