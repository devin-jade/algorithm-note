package com.devin.algorithm.sort;

import java.util.Arrays;

import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * @ClassName InsertSort
 * @Description TODO
 * @Author hukaihao
 * @Date 2019-02-20 15:11
 * @Version 1.0
 */
public class InsertSort {
    private static final int[] SORT_ARRAY = {43, 64, 21, 6565, 3424, 22, 6523, 345, 89, 68, 162, 528};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(SORT_ARRAY)));
        System.out.println(Arrays.toString(insertsortExchage(SORT_ARRAY)));
    }

    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }


    public static int[] insertsortExchage(int array[]) {
        int i, j;
        int n = array.length;
        for (i = 1; i < n; i++) {
            for (j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                swap(array, j, j + 1);
            }
        }
        return array;
    }

}
