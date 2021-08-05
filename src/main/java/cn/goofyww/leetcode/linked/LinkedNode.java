package cn.goofyww.leetcode.linked;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 */
public class LinkedNode {

    public static void main(String[] args) {

        Node nd1 = new Node(1);
        Node nd2 = new Node(2);
        Node nd3 = new Node(3);
        nd1.setNext(nd2);
        nd2.setNext(nd3);
//        nd3.setNext(nd1);

//        System.out.println(hasCycle(nd1));
        System.out.println(hasCycleByQuickSolw(nd1));
    }

    /**
     * 判断是否为环形链表
     * 方法一：
     * 循环遍历节点，遍历一个便标记一个，遍历过程判断是否被标记，若已被标记则表示有环
     * 方法说明：头指针移动，若到达之前到达过的位置则表示有环，若无环则会走到链表末端
     */
    public static boolean hasCycle(Node head) {
        Set<Node> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
                head = head.getNext();
            }
        }
        return false;
    }

    /**
     * 判断是否为环形链表
     * 方法二：
     * 声明两个指针，一个指针走一次经过两个节点(快指针quick)，另一个走一次经过一个节点(慢指针slow)
     * 方法说明：快指针走的比较快，若链表有环，则一定会追上慢指针，若无环，则会走到链表末端。
     */
    public static boolean hasCycleByQuickSolw(Node head) {

        // 声明两个节点从头开始遍历节点
        Node quick = head;
        Node slow = head;

        // 当快指针能够走到头表示无环
        while (quick != null && quick.getNext() != null) {
            quick = quick.getNext().getNext();
            slow = slow.getNext();
            if (quick == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 找到单链表的第一个成环节点
     * 链表头指针为head, 目标找到红色节点，要求线性时间复杂度
     * 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 3
     * 要求找到 3
     */
    public static Node findFirstCycleNode(Node head) {

        return null;
    }


}
