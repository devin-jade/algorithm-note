package com.devin.common.sort;

import com.devin.algorithm.sort.InsertSort;

import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Description TODO
 * @Author hukaihao
 * @Date 2019-02-20 16:44
 * @Version 1.0
 */
public class QuickSort {
    private static final int[] SORT_ARRAY = {43, 64, 21, 6565, 3424, 22, 6523, 345, 89, 68, 162, 528};

    public static void main(String[] args) {

        System.out.println(Arrays.toString(quickSort(SORT_ARRAY, 0, SORT_ARRAY.length - 1)));
    }


    /**
     * 快速排序方法
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int[] quickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) {
            return null;
        }
        if (end - start > 1) { // 当待排序序列的长度分割到一定大小后，使用插入排序
            int pivot = partition1(array, start, end);
            if (pivot > start) {
                quickSort(array, start, pivot - 1);
            }
            if (pivot < end) {
                quickSort(array, pivot + 1, end);
            }
        } else {
            InsertSort.insertsortExchage(array);
        }
        return array;
    }

    /**
     * left right pointer
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    public static int partition1(int[] array, int left, int right) {
        int begin = left;
        int end = right;
        // 固定基准
        int key = right;

        while (begin < end) {
            // begin find big
            while (begin < end && array[begin] <= array[key]) {
                begin++;
            }
            // end find small
            while (begin < end && array[end] >= array[key]) {
                end--;
            }
            swap(array, begin, end);
        }
        swap(array, begin, key);
        key = begin;
        return key;
    }

    /**
     * 挖坑法
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    public static int partition2(int[] array, int left, int right) {
        //初始坑
        int key = array[right];

        while (left < right) {
            //left找大
            while (left < right && array[left] <= key) {
                left++;
            }
            //赋值，然后left作为新坑
            array[right] = array[left];
            //right找小
            while (left < right && array[right] >= key) {
                right--;
            }
            //right作为新坑
            array[left] = array[right];
        }
        array[left] = key;
       /*将key赋值给left和right的相遇点，
        保持key的左边都是比key小的数，key的右边都是比key大的数*/
        return left;
    }

    /**
     * 快速排序算法——随机基准
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition3(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex) {
                    swap(array, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }

    /**
     * 三数中值
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition4(int[] array, int start, int end) {
        int pivot = getMid(array, start, end);
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex) {
                    swap(array, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }


    public static void quicksort5(int array[], int left, int right) {
        if (left < right) {
            int[] p = partition5(array, left, right);
            quicksort5(array, left, p[0] - 1); //避开重复元素区间
            quicksort5(array, p[1] + 1, right);
        }
    }

    /**
     * 三路划分
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    public static int[] partition5(int[] array, int left, int right) {
        int v = array[right]; //选择右边界为基准
        int less = left - 1; // < v 部分的最后一个数
        int more = right + 1; // > v 部分的第一个数
        int cur = left;
        while (cur < more) {
            if (array[cur] < v) {
                swap(array, ++less, cur++);
            } else if (array[cur] > v) {
                swap(array, --more, cur);
            } else {
                cur++;
            }
        }
        return new int[]{less + 1, more - 1};  //返回的是 = v 区域的左右下标
    }

    /**
     * 三数取中，返回array[left]、array[mid]、array[right]三者的中间者下标作为基准
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    public static int getMid(int[] array, int left, int right) {
        int mid = left + ((right - left) >> 1);
        int a = array[left];
        int b = array[mid];
        int c = array[right];
        if ((b <= a && a <= c) || (c <= a && a <= b)) { //a为中间值
            return left;
        }
        if ((a <= b && b <= c) || (c <= b && b <= a)) { //b为中间值
            return mid;
        }
        if ((a <= c && c <= b) || (b <= c && c <= a)) { //c为中间值
            return right;
        }
        return left;
    }

    /**
     * 交换数组内两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
