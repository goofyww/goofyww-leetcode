package cn.goofyww.leetcode.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度：O(N^2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 */
public class PubbleSort {

    public static void main(String[] args) {
        int[] nums = {12, 3, 7, 2, 6, 5, 11, 13, 2, 1, 0, 8, 7, 9};
        sort(nums);
        System.out.print(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                if (nums[i] > nums[i1]) {
                    int temp = nums[i];
                    nums[i] = nums[i1];
                    nums[i1] = temp;
                }
            }
        }
    }

}
