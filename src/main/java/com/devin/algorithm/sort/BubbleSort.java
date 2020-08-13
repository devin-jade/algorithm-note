package com.devin.algorithm.sort;

import java.util.Arrays;

import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * @ClassName BubbleSort
 * @Description TODO
 * @Author hukaihao
 * @Date 2019-02-20 14:41
 * @Version 1.0
 */
public class BubbleSort {

    private static final int[] SORT_ARRAY = {43, 64, 21, 6565, 3424, 22, 6523, 345, 89, 68, 162, 528};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(SORT_ARRAY)));
        System.out.println(Arrays.toString(bubbleSortOutSide(SORT_ARRAY)));
        System.out.println(Arrays.toString(bubbleSortInSide(SORT_ARRAY)));
        System.out.println(Arrays.toString(cocktailSort(SORT_ARRAY)));
    }

    /**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 冒泡排序 外层循环优化
     *
     * @param array
     * @return
     */
    public static int[] bubbleSortOutSide(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int flag = 0;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = 1;
                }
            }
            if (flag == 0) {
                return array;
            }
        }
        return array;
    }

    /**
     * 冒泡排序 外层循环优化
     *
     * @param array
     * @return
     */
    public static int[] bubbleSortInSide(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int len = array.length;
        int pos = 0, k = len - 1;
        for (int i = 0; i < array.length; i++) {
            int flag = 0;
            for (int j = 0; j < k; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = 1;
                    pos = j;
                }
            }
            k = pos;
            if (flag == 0) {
                return array;
            }
        }
        return array;
    }


    /**
     * 鸡尾酒排序，大的向下冒泡，小的向上冒泡
     *
     * @param array
     * @return
     */
    public static int[] cocktailSort(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                }
            }
            left++;
        }
        return array;
    }


}
