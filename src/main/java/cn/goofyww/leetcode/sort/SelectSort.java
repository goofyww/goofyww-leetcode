package cn.goofyww.leetcode.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度：O(N^2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] nums = {12, 3, 7, 2, 6, 5, 11, 13, 2, 1, 0, 8, 7, 9};
        sort(nums);
        System.out.print(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i]; // min 表示最小变量值，默认以第一个数值为最小值
            int index = i;// index用来记录最小值的下标
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    index = j;
                }
            }
            if (index != i) { // 判断index是否被交换过，当前下标值不是最小数的情况
                nums[index] = nums[i];
                nums[i] = min;
            }
        }
    }

}
