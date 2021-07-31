package cn.goofyww.leetcode.twolistnodes;

/**
 * 双链表找相同节点第一位
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode l2 = new ListNode(10, new ListNode(2, new ListNode(1, new ListNode(4, new ListNode(5, new ListNode(6))))));

        ListNode l = getCommonFirstNode(l1, l2);
        System.out.println(l.val);

    }

    public static ListNode getCommonFirstNode(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode custor = root;
        int i = 0;
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                l1 = l1.next;
                l2 = l2.next;
                i = 0;
            } else {
                if (++i == 1) {
                    custor.next = new ListNode(l1.val);
                    custor = custor.next;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        return root.next = custor;
    }

}
