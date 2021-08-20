package cn.goofyww.leetcode.linked;

import java.util.Objects;

/**
 * 用一个 非空单链表 来表示一个 非负整数，然后将这个整数加一。你可以假设这个整数除了0本身，
 * 没有任何前导的0。这个整数的各个数位按照高位在链表头部、低位在链表尾部的顺序排列
 * <p>
 * 示例:输入: [1,2,3]输出: [1,2,4]
 */
public class LinkedListIncr {

    public static void main(String[] args) {

        Node root = new Node(9, new Node(9, new Node(8, new Node(9))));
        Node head = root;
        while (head != null) {
            System.out.printf("%d\t", head.value);
            head = head.next;
        }

        System.out.println();
        Node afterNode = incr(root);
        while (afterNode != null) {
            System.out.printf("%d\t", afterNode.value);
            afterNode = afterNode.next;
        }
    }

    public static Node incr(Node root) {
        if (Objects.isNull(root)) {
            return root;
        }
        Node reNode = revers(root);
        Node p = reNode;
        boolean b = true;
        int custor = 0;
        int v;
        while (p != null) {
            if (b) {
                p.value = ++p.value;
                v = p.value;
                b = false;
            } else {
                p.value += custor;
                v = p.value;
            }

            if (v > 9) {
                p.value = v % 10;
                custor = v / 10;
            } else {
                custor = 0;
            }
            if (p.next == null && custor != 0) {
                p.next = new Node(custor);
                custor = 0;
            }
            p = p.next;
        }
        return revers(reNode);
    }

    public static Node revers(Node root) {
        if (Objects.isNull(root)) {
            return root;
        }
        Node r = new Node(-1);
        r.next = root;

        Node p = root;
        Node pNext = p.next;
        while (pNext != null) {
            p.next = pNext.next;
            pNext.next = r.next;
            r.next = pNext;
            pNext = p.next;
        }
        return r.next;
    }

}
