package com.devin.algorithm.sort;

import org.junit.Test;


public class BucketSortTest {

    @Test
    public void test() {
        int[] SORT_ARRAY = {43, 64, 21, 6565, 3424, 22, 6523, 345, 89, 68, 162, 528};
        System.out.println(BucketSort.bucketSort(SORT_ARRAY));
    }

}