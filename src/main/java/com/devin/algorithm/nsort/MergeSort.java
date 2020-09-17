package com.devin.algorithm.nsort;

import com.devin.algorithm.util.AlgorithmUtil;

/**
 * @author hukaihao
 * @version 1.0.0
 * @since 2020/9/17 21:54
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {43, 64, 21, 6565, 3424, 22, 6523, 345, 89, 68, 162, 528, 1};
//        mergeSort1(array);
        mergeSort2(array);
        AlgorithmUtil.printArray(array);

        // 使用对数器验证结果
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = AlgorithmUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = AlgorithmUtil.copyArray(arr1);
            mergeSort1(arr1);
            mergeSort2(arr2);
            if (!AlgorithmUtil.isEqual(arr1, arr2)) {
                succeed = false;
                AlgorithmUtil.printArray(arr1);
                AlgorithmUtil.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Oops!");
    }

    /**
     * 递归方法实现
     *
     * @param array 数组
     */
    public static void mergeSort1(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        splitProcess(array, 0, array.length - 1);
    }

    /**
     * 非递归方式，按照1,2,4,8,16的分组方式两两merge，变递归为循环
     *
     * @param array
     */
    public static void mergeSort2(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int length = array.length;
        int mergeGroupSize = 1;
        while (mergeGroupSize < length) {
            int left = 0;
            while (left < length) {
                // left...mid 左组
                int mid = left + mergeGroupSize - 1;
                while (mid > length) {
                    break;
                }
                int right = Math.min(mid + mergeGroupSize, length - 1);
                merge(array, left, mid, right);
                left = right + 1;
            }
            while (mergeGroupSize > length / 2) {
                break;
            }
            mergeGroupSize <<= 1;
        }
    }


    public static void splitProcess(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        splitProcess(array, left, mid);
        splitProcess(array, mid + 1, right);
        merge(array, left, mid, right);
//        teacher_merge(array, left, mid, right);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int length = R - L + 1;
        int[] help = new int[length];
        int p1 = L;
        int p2 = M + 1;
        for (int i = 0; i < length; i++) {
            if (p1 <= M && p2 <= R) {
                if (arr[p1] <= arr[p2]) {
                    help[i] = arr[p1++];
                } else {
                    help[i] = arr[p2++];
                }
            } else if (p1 <= M) {
                help[i] = arr[p1++];
            } else if (p2 <= R) {
                help[i] = arr[p2++];
            }
        }
        for (int j = 0; j < length; j++) {
            arr[L + j] = help[j];
        }
    }

    public static void teacher_merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 要么p1越界了，要么p2越界了
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }

    }

}
