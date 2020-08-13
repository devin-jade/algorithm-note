package com.devin.algorithm.sort;

import java.util.Arrays;

/**
 * @ClassName CountingSort
 * @Description TODO
 * @Author hukaihao
 * @Date 2019-02-21 12:38
 * @Version 1.0
 */
public class CountingSort {

    private static final int[] SORT_ARRAY = {43, 64, 21, 6565, 3424, 22, 6523, 345, 89, 68, 162, 528};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countingSort(SORT_ARRAY)));
    }
    /**
     * 计数排序
     *
     * @param array
     * @return
     */
    public static int[] countingSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }
        //计算偏移量，将 min ~ max 映射到 bucket 数组的 0 ~ (max - min) 位置上
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else {
                i++;
            }
        }
        return array;
    }
}
