package com.devin.algorithm.sort;

import java.util.Arrays;

import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * @ClassName ShellSort
 * @Description TODO
 * @Author hukaihao
 * @Date 2019-02-20 16:02
 * @Version 1.0
 */
public class ShellSort {
    private static final int[] SORT_ARRAY = {43, 64, 21, 6565, 3424, 22, 6523, 345, 89, 68, 162, 528};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shellSort(SORT_ARRAY)));
        System.out.println(Arrays.toString(shellsortExchange(SORT_ARRAY)));
    }

    /**
     * 希尔排序
     *
     * @param array
     * @return
     */
    public static int[] shellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    public static int[] shellsortExchange(int a[]) {
        int i, j, gap;
        int n = a.length;
        for (gap = n / 2; gap > 0; gap /= 2) {
            for (i = gap; i < n; i++) {
                for (j = i - gap; j >= 0 && a[j] > a[j + gap]; j -= gap) {
                    swap(a, j, j + gap);
                }
            }
        }
        return a;
    }
}
