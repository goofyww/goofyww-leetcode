package cn.goofyww.leetcode.find;

/**
 * 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr1 = {7, 8, 9, 10, 11, 12, 1, 2, 3};
        System.out.println(binarySearch(arr1, 2));

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int x = 1;
        System.out.println(binarySearch(arr2, x));
    }

    /**
     * 旋转有序数组
     * 二分查找O(logn)
     */
    public static int reBinarySearch(int[] arr, int target) {
        int i = -1, l = arr.length;
        if (l < 1) {
            return i;
        }
        if (l == 1) {
            return arr[0] == target ? 0 : -1;
        }
        int s = 0, e = l - 1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (arr[m] == target) {
                return m;
            }

            if (arr[0] <= arr[m]) {
                if (arr[0] <= target && target < arr[m]) {
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            } else {
                if (arr[m] < target && target <= arr[l - 1]) {
                    s = m + 1;
                } else {
                    e = m - 1;
                }
            }
        }
        return i;
    }

    /**
     * 有序数组
     * 二分查找O(logn)
     */
    public static int binarySearch(int[] arr, int x) {
        int res = -1, l = arr.length;
        if (l < 1) return res;
        if (l == 1) return arr[0] == x ? 0 : -1;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (x == arr[mid]) {
                return mid;
            }
            if (x < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

}
