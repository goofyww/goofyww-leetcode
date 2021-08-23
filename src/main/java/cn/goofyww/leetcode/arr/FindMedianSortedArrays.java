package cn.goofyww.leetcode.arr;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 难度：困难
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {

    }

    /**
     * 方法1：双指针遍历比较法
     * 时间复杂度：O(m+n)
     */
    public static double findMedianSortedArrays1(int[] arr1, int[] arr2) {

        int aLen = null == arr1 ? 0 : arr1.length;
        int bLen = null == arr2 ? 0 : arr2.length;
        int len = aLen + bLen;
        if (len < 1) return 0;
        double res = 0;
        if (len % 2 != 0) {
            // 奇数
            res = findTopK(arr1, arr2, len / 2);
        } else {
            // 偶数
            res = findTopK(arr1, arr2, len / 2 - 1) / 2 + findTopK(arr1, arr2, len / 2) / 2;
        }
        return res;
    }

    /**
     * 求双数组topK位的元素内容
     */
    public static double findTopK(int[] arr1,int[] arr2,int k){
        int aLen = null == arr1 ? -1 : arr1.length;
        int bLen = null == arr2 ? -1 : arr2.length;
        if (aLen == -1) return new Double(arr2[k - 1]);
        if (bLen == -1) return new Double(arr1[k - 1]);

        int[] resArr = new int[arr1.length + arr2.length];
        int i = 0, j = 0, n = 0;
        while (i < aLen && j < bLen && n <= k) {
            if (arr1[i] <= arr2[j]) {
                resArr[n++] = arr1[i++];
            } else {
                resArr[n++] = arr2[j++];
            }
        }
        while (i < aLen && n <= k) {
            resArr[n++] = arr1[i++];
        }
        while (j < bLen && n <= k) {
            resArr[n++] = arr2[j++];
        }
        return new Double(resArr[n - 1]);
    }


}
