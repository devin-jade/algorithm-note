package com.devin.algorithm.nsort;

import com.devin.algorithm.util.AlgorithmUtil;

/**
 * <p>
 * 在一个数组中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来，叫数组小和。求数组小和。
 * 例子： [1,3,4,2,5]
 * 1左边比1小的数：没有
 * 3左边比3小的数：1
 * 4左边比4小的数：1、3
 * 2左边比2小的数：1
 * 5左边比5小的数：1、3、4、 2
 * 所以数组的小和为1+1+3+1+1+3+4+2=16
 * </p>
 *
 * @author hkh
 * @since 2020/9/18
 */
public class MergeSort_SmallAnd {
    public static void main(String[] args) {
        int[] NO_SORT_ARRAY = {1, 3, 4, 2, 5};
        System.out.println(smallAnd(NO_SORT_ARRAY));
        AlgorithmUtil.printArray(NO_SORT_ARRAY);
    }

    public static int smallAnd(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        return process(array, 0, array.length - 1);
    }

    public static int process(int[] array, int L, int R) {
        int result = 0;
        if (L == R) {
            return result;
        }

        int M = L + ((R - L) >> 2);
        process(array, L, M);
        process(array, M + 1, R);
        result += merge(array, L, M, R);
        return result;
    }

    public static int merge(int[] array, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int result = 0;
        int i = 0;
        int l1 = L;
        int r1 = M + 1;
        while (l1 <= M && r1 <= R) {
            if (array[l1] < array[r1]) {
                help[i++] = array[l1];
                result = result + array[l1];
                System.out.println(array[l1]);
                l1++;
            } else {
                help[i++] = array[r1++];
            }
        }
        while (l1 <= M) {
            help[i++] = array[l1++];
        }
        while (r1 <= R) {
            help[i++] = array[r1++];
        }
        for (i = 0; i < help.length; i++) {
            array[L + i] = help[i];
        }
        return result;
    }
}
