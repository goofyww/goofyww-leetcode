package cn.goofyww.leetcode.linked;

/**
 * 链表反转
 */
public class LinkedListInversion {

    public static void main(String[] args) {

        Node n = CrossLinkedList.randomBuildLinkedList(5, 10);
        Node r = n;
        while (n != null) {
            System.out.printf("%d\t", n.getValue());
            n = n.getNext();
        }

//        System.out.println();
//
//        Node m = reverseA(r);
//        while (m != null) {
//            System.out.printf("%d\t", m.getValue());
//            m = m.getNext();
//        }

        System.out.println();

        Node f = reverseB(r);
        while (f != null) {
            System.out.printf("%d\t", f.getValue());
            f = f.getNext();
        }

    }

    /**
     * 链表反转
     * 方式一：头插法
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public static Node reverseA(Node node) {
        // 定义一个带头节点的
        Node root = new Node(-1);
        // 循环节点
        Node p = node;
        while (p != null) {
            // 保存插入点之后的数据
            Node temp = p.getNext();
            p.setNext(root.getNext());
            root.setNext(p);
            p = temp;
        }
        return root.getNext();
    }

    /**
     * 链表反转
     * 方式一：原地置换
     */
    public static Node reverseB(Node node) {
        Node resultList = new Node(-1);
        // -1 -> * -> * -> *
        resultList.setNext(node);
        // * -> * -> *
        Node p = node;
        // * -> *
        Node pNext = p.getNext();
        while (pNext != null) {
            p.setNext(pNext.getNext());
            pNext.setNext(resultList.getNext());
            resultList.setNext(pNext);
            pNext = p.getNext();
        }
        return resultList.getNext();
    }

}
