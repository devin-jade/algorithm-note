package com.devin.algorithm.sort;

/**
 * @ClassName Sort
 * @Description TODO
 * @Author hukaihao
 * @Date 2019-02-20 11:36
 * @Version 1.0
 */
public class Sort {


    public static int[] bubbleSort(int[] array) {
        return com.devin.algorithm.sort.BubbleSort.bubbleSort(array);
    }

    public static int[] selectSort(int[] array) {
        return com.devin.algorithm.sort.SelectSort.selectSort(array);
    }

    public static int[] insertionSort(int[] array) {
        return com.devin.algorithm.sort.InsertSort.insertionSort(array);
    }

    public static int[] shellSort(int[] array) {
        return com.devin.algorithm.sort.ShellSort.shellSort(array);
    }

    public static int[] mergeSort(int[] array) {
        return com.devin.algorithm.sort.MergeSort.mergeSort(array);
    }

    public static int[] quickSort(int[] array) {
        return com.devin.common.sort.QuickSort.quickSort(array, 0, array.length - 1);
    }

    public static int[] heapSort(int[] array) {
        return com.devin.algorithm.sort.HeapSort.heapSort(array);
    }

    public static int[] countingSort(int[] array) {
        return com.devin.algorithm.sort.CountingSort.countingSort(array);
    }

    public static int[] bucketSort(int[] array) {
        return com.devin.algorithm.sort.BucketSort.bucketSort(array);
    }

    public static int[] radixSort(int[] array) {
        return com.devin.algorithm.sort.RadixSort.radixSort(array);
    }

}
