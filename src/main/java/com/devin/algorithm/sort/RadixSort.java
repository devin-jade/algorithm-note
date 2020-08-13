package com.devin.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName RadixSort
 * @Description TODO
 * @Author hukaihao
 * @Date 2019-02-20 10:44
 * @Version 1.0
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] originalArry = {2, 50, 3, 48, 4, 47, 5, 467, 15, 144, 19, 38, 26, 36, 27};

        int maxDigit = getMaxDigit(originalArry);
        System.out.println("maxDigit is " + maxDigit);
        System.out.println("originalArry is " + Arrays.toString(originalArry));
        originalArry = radixSort(originalArry, maxDigit);
        System.out.println("After sort array is " + Arrays.toString(originalArry));
    }


    public static int[] radixSort(int[] array){
        return radixSort(array, getMaxDigit(array));
    }

    /**
     * 基数排序 LSD
     *
     * @param array
     * @return
     */
    public static int[] radixSort(int[] array, int maxDigit) {

        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    array[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }
        }
        return array;
    }

    /**
     * 算出最大数的位数
     *
     * @param originalArry
     * @return
     */
    public static int getMaxDigit(int[] originalArry) {
        int maxVal = originalArry[0];
        for (int i = 1; i < originalArry.length; i++) {
            maxVal = Math.max(maxVal, originalArry[i]);
        }
        int maxDigit = 0;
        while (maxVal != 0) {
            maxVal /= 10;
            maxDigit++;
        }
        return maxDigit;
    }

    /**
     * LSD
     *
     * @param array
     * @param maxDigit
     */
    public static void radixSort2(int[] array, int maxDigit) {
        int len = array.length;
        int digitCount = 1;
        int digitDev = 1;
        int[] tmp = new int[len];
        int[] count = new int[10];
        while (digitCount <= maxDigit) {
            Arrays.fill(count, 0);
            for (int i = 0; i < len; i++) {
                count[(array[i] / digitDev) % 10]++;
            }
            int sum = 0;
            for (int i = 1; i < 10; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (int i = len - 1; i >= 0; i--) {
                tmp[count[(array[i] / digitDev) % 10] - 1] = array[i];
                count[(array[i] / digitDev) % 10]--;
            }
            for (int i = 0; i < len; i++) {
                array[i] = tmp[i];
            }
            digitDev *= 10;
            digitCount++;
        }
        System.out.println("After sort array is " + Arrays.toString(array));
    }
}
