package cn.goofyww.leetcode.linked;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 */
public class LinkedNode {

    public static void main(String[] args) {

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 3

        Node nd1 = new Node(1);
        Node nd2 = new Node(2);
        Node nd3 = new Node(3);
        Node nd4 = new Node(4);
        Node nd5 = new Node(5);
        Node nd6 = new Node(6);

        nd1.setNext(nd2);
        nd2.setNext(nd3);
        nd3.setNext(nd4);
        nd4.setNext(nd5);
        nd5.setNext(nd6);
        nd6.setNext(nd3);

//        System.out.println(findFirstCycleNode(nd1).getValue());
        System.out.println(findFirstCycleNode2(nd1).getValue());
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
     * 方式一：
     * 找到单链表的第一个成环节点（判断链表的入口）
     * 链表头指针为head, 目标找到红色节点，要求线性时间复杂度
     * 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 3
     * 要求找到 3
     */
    public static Node findFirstCycleNode(Node head) {
        Set<Node> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
                head = head.getNext();
            }
        }
        return head;
    }

    /**
     * 方式二：
     * 要求 空间复杂度 O(1)
     * 时间复杂度 O()
     * 解题思路：
     * 从头结点出发，慢指针一次移动一个位置，快指针一次移动两个位置。如果有环的话，他们一定会在某个位置相遇。
     * 但这个位置不一定是入口，只能说在环内某个位置相遇
     * 然后相遇之后，快指针从头开始每次向后移动一个位置。慢指针从相遇位置向后移动，他们一定会相遇
     * -----------------------------------------------------------------------------
     * 找到单链表的第一个成环节点（判断链表的入口）
     * 链表头指针为head, 目标找到红色节点，要求线性时间复杂度
     * 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 3
     * 要求找到 3
     *
     * @param head
     * @return
     */
    public static Node findFirstCycleNode2(Node head) {
        Node fast = head, slow = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    fast = fast.getNext();
                    slow = slow.getNext();
                }
                return slow;
            }
        }
        return null;
    }


}
