package com.example;
import java.util.Scanner;

public class QuickSRT {

    public static int[] QuickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivotFinalIndex = PartitionARR(arr, low, high);
            QuickSort(arr, low, pivotFinalIndex - 1);
            QuickSort(arr, pivotFinalIndex + 1, high);
        }
        return arr;
    }

    public static int PartitionARR(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner Scan1 = new Scanner(System.in);
        int n = Integer.parseInt(Scan1.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(Scan1.nextLine());
        }
        arr = QuickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }
}