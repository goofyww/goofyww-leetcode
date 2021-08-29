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

        int m = null == arr1 ? 0 : arr1.length;
        int n = null == arr2 ? 0 : arr2.length;

        if (m == 0) {
            if (n % 2 == 0) {
                return (arr2[n / 2 - 1] + arr2[n / 2]) / 2.0;
            } else {
                return arr2[n / 2];
            }
        }

        if (n == 0) {
            if (m % 2 == 0) {
                return (arr1[m / 2 - 1] + arr1[m / 2]) / 2.0;
            } else {
                return arr1[m / 2];
            }
        }

        int len = m + n;
        if (len < 1) {
            return 0;
        }
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
    public static double findTopK(int[] arr1, int[] arr2, int k) {
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

    /**
     * 官方解法一
     * 暴力解法
     * 简单粗暴，先将两个数组合并，两个有序数组的合并也是归并排序中的一部分。然后根据奇数，还是偶数，返回中位数。
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {

                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }

    /**
     *
     *
     */
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        //如果A数组长度+B数组长度total是奇数，则找total/2+1小的元素即为中位数
        if (total % 2 == 1) {
            int midIndex = total / 2 + 1;
            return getKthElement(nums1, nums2, midIndex);
        }
        //否则，找total/2，total/2+1这两个元素
        else {
            int midIndex_1 = total / 2;
            int midIndex_2 = total / 2 + 1;
            double a = getKthElement(nums1, nums2, midIndex_1);
            double b = getKthElement(nums1, nums2, midIndex_2);
            return (a + b) / 2.0D;
        }
    }

    private int getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        while (true) {
            //边界情况，当index1越界时，直接返回nums2的第k小元素
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }
            //边界情况，当index2越界时，直接返回nums1的第k小元素
            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }
            //边界情况，k等于1时，返回nums1第一个元素和nums2第一个元素较小者
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];
            //比较nums1[k/2-1]和nums2[k/2-1]
            //如果nums1的小，则忽略掉nums1[0] - nums1[k/2-1]这些元素
            //再更新 k，k 要减去忽略掉的那些元素，index1也要更新，待下轮使用
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }
            //如果nums2的小，则忽略掉nums2[0] - nums2[k/2-1]这些元素
            //再更新 k，k 要减去忽略掉的那些元素，index2也要更新，待下轮使用
            else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

}
