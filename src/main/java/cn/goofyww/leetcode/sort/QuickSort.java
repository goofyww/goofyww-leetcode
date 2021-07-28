package cn.goofyww.leetcode.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 时间复杂度：最优情况 O(nlogn) 最糟情况 O(n^2)
 * 空间复杂度：O(1)，使用了交换法，不需要开辟额外的空间
 * 稳定性：分区过程涉及交换操作，是不稳定的排序算法
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {12, 3, 7, 2, 6, 5, 11, 13, 2, 1, 0, 8, 7, 9};
        sort(nums, 0, nums.length - 1);
        System.out.print(Arrays.toString(nums));
    }

    public static void sort(int[] is, int left, int right) {
        if (left < right) {
            int index = portion(is, left, right);
            sort(is, left, index - 1);
            sort(is, index + 1, right);
        }
    }

    /**
     * 寻找基准，
     * 将比基准大的数放入数组右侧，比基准小的数放入数组左侧
     */
    private static int portion(int[] is, int left, int right) {
        // base 变量用存储基准数
        int base = is[left];
        while (left < right) {
            while (left < right && is[right] >= base) {
                right--;
            }
            is[left] = is[right];
            while (left < right && is[left] <= base) {
                left++;
            }
            is[right] = is[left];
        }
        is[left] = base;
        return left;
    }


}
