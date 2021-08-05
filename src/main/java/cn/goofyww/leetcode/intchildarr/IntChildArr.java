package cn.goofyww.leetcode.intchildarr;

import java.util.*;

/**
 * 最大子数组
 */
public class IntChildArr {

    public static void main(String[] args) {

        int[] nums = {1, 4, 2, 7, 9, 4, 2, 2, 3};
        System.out.println(maxSumChildArr(nums));
    }

    /**
     * 获取最大子数组之和
     *
     * @param arr
     * @return
     */
    public static int maxSumChildArr(int[] arr) {
        int maxs = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int z = i; z < j; z++) {
                    sum += arr[z];
                }
                if (maxs < sum) {
                    maxs = sum;
                }
            }
        }
        return maxs;
    }


}
