package cn.goofyww.leetcode.topk;

/**
 * 两个正序排序的数组，求合并后的第K个。(数组内元素没有重复数字; 数组没有 0，找不到第 K 个数可以返回 0)
 * <p>
 * 示例 1：
 * 如果 K = 5
 * >array1 = [1, 13, 16, 20]
 * >array2 = [2, 8, 12, 27]
 * >则第K个数是：13
 * <p>
 * ====================================注意=========================================
 * 要求：不要申请额外的数组空间(List、Set、Map底层也是数组,不可使用)；
 */
public class ArrTopK {

    public static void main(String[] args) {

        int[] arr1 = {1, 13, 16};
        int[] arr2 = {2, 8, 12, 15, 17, 19, 20, 27};

//        Queue<Integer> s = new PriorityQueue<>(Comparator.reverseOrder());
//        for (int i : arr1) {
//            s.offer(i);
//        }

        System.out.println(findK(arr1, arr2, 0));
        System.out.println(findK(arr1, arr2, 1));
        System.out.println(findK(arr1, arr2, 2));
        System.out.println(findK(arr1, arr2, 3));
        System.out.println(findK(arr1, arr2, 4));
        System.out.println(findK(arr1, arr2, 5));
        System.out.println(findK(arr1, arr2, 6));
        System.out.println(findK(arr1, arr2, 7));
        System.out.println(findK(arr1, arr2, 8));
        System.out.println(findK(arr1, arr2, 9));
        System.out.println(findK(arr1, arr2, 10));
        System.out.println(findK(arr1, arr2, 11));
        System.out.println(findK(arr1, arr2, 12));

    }

    private static int findK(int[] arr1, int[] arr2, int k) {
        // 消除边界问题
        if (k <= 0) return -1;
        int length1 = null == arr1 ? -1 : arr1.length;
        int length2 = null == arr2 ? -1 : arr2.length;

        if (length1 + length2 < k) return -1;
        if (length1 == -1) return arr2[k - 1];
        if (length2 == -1) return arr1[k - 1];

        // 双指针解法
        int res = 0;
        int index1 = 0, index2 = 0;
        while (index1 + index2 < k) {
            if (index1 >= length1) {
                return arr2[k - length1 - 1];
            }
            if (index2 >= length2) {
                return arr1[k - length2 - 1];
            }
            if (arr1[index1] >= arr2[index2]) {
                res = arr2[index2++];
                continue;
            }
            if (arr1[index1] <= arr2[index2]) {
                res = arr1[index1++];
            }
        }
        return res;
    }

}
