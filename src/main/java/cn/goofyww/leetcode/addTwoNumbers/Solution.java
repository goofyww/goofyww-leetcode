package cn.goofyww.leetcode.addTwoNumbers;

/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字
 * 请你将两个数相加，并以相同形式返回一个表示和的链表
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
 */
public class Solution {

    public static void main(String[] args) {
        /**
         * 输入：l1 = [2,4,3], l2 = [5,6,4]
         * 输出：[7,0,8]
         * 解释：342 + 465 = 807.
         */
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        addTwoNumbersShow(l1, l2);
        /**
         * 输入：l1 = [0], l2 = [0]
         * 输出：[0]
         */
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(0);
        addTwoNumbersShow(n1, n2);
        /**
         * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
         * 输出：[8,9,9,9,0,0,0,1]
         */
        ListNode ln1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode ln2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        addTwoNumbersShow(ln1, ln2);
    }

    public static void addTwoNumbersShow(ListNode l1, ListNode l2) {
        ListNode node = addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.printf("%d\t", node.val);
            node = node.next;
        }
        System.out.println("");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode custor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sv = v1 + v2 + carry;

            custor.next = new ListNode(sv % 10);
            custor = custor.next;
            carry = sv / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return root.next;
    }

}
