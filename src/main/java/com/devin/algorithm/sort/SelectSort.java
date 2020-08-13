package com.devin.algorithm.sort;

import java.util.Arrays;

import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * @ClassName SelectSort
 * @Description TODO
 * @Author hukaihao
 * @Date 2019-02-20 15:37
 * @Version 1.0
 */
public class SelectSort {

    private static final int[] SORT_ARRAY = {43, 64, 21, 6565, 3424, 22, 6523, 345, 89, 68, 162, 528};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectSort(SORT_ARRAY)));
        System.out.println(Arrays.toString(selectionSort(SORT_ARRAY)));
    }

    /**
     * 选择排序
     *
     * @param array
     * @return
     */
    public static int[] selectSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {//找到最小的数
                    minIndex = j; //将最小数的索引保存
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * 直接交换
     *
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        // 存储最小值的下标
        int min = 0;
        //存储最大值的下标
        int max = 0;
        while (left <= right) {
            min = left;
            max = left;
            for (int i = left; i <= right; ++i) {
                if (array[i] < array[min]) {
                    min = i;
                }
                if (array[i] > array[max]) {
                    max = i;
                }
            }
            swap(array, left, min);
            if (left == max) {
                max = min;
            }
            swap(array, right, max);
            ++left;
            --right;
        }
        return array;
    }

}
