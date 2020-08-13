package com.devin.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @ClassName BucketSort
 * @Description TODO
 * @Author hukaihao
 * @Date 2019-02-21 13:05
 * @Version 1.0
 */
public class BucketSort {

    private static final int[] SORT_ARRAY = {43, 64, 21, 6565, 3424, 22, 6523, 345, 89, 68, 162, 528};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bucketSort(SORT_ARRAY)));
    }

    public static int[] bucketSort(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }

        /**
         * 桶映射函数：自己设计，要保证桶 i 的数均小于桶 j （i < j）的数，
         * 即必须桶间必须有序，桶内可以无序。这里桶映射函数为：(i - min) / arr.length
         */
        int bucketNum = (max - min) / array.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        //将每个元素放入桶
        for (int i = 0; i < array.length; i++) {
            int num = (array[i] - min) / (array.length);
            bucketArr.get(num).add(array[i]);
        }

        //对每个桶进行排序
        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }

        int k = 0;
        for (int i = 0; i < bucketArr.size(); i++) {
            for (int j = 0; j < bucketArr.get(i).size(); j++) {
                array[k++] = bucketArr.get(i).get(j);
            }
        }
        return array;
    }
}
