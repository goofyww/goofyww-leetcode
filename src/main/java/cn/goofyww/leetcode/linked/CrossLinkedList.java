package cn.goofyww.leetcode.linked;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

/**
 * 判断是否为交叉链表
 */
public class CrossLinkedList {

    public static void main(String[] args) throws Exception {

        Node[] nds = buildCrossLinkedList(10, 7, 5, 5, 3);

        for (Node nd : nds) {
            while (nd != null) {
                System.out.printf("%d\t", nd.getValue());
                nd = nd.getNext();
            }
            System.out.println();
        }

        Node nd1 = nds[0];
        Node nd2 = nds[1];

        Node q1 = violentSolution(nd1, nd2);
        System.out.println(q1.getValue());

        Node q2 = hashSolution(nd1, nd2);
        System.out.println(q2.getValue());

        Node q3 = stackSolution(nd1, nd2);
        System.out.println(q3.getValue());

        Node q4 = pointerSolution(nd1, nd2);
        System.out.println(q4.getValue());
    }

    /**
     * 暴力解法
     */
    public static Node violentSolution(Node nd1, Node nd2) {
        Node node = null;
        if (nd1 == null || nd2 == null) {
            return null;
        }
        Node nd2head = nd2;
        while (nd1 != null) {
            while (nd2 != null) {
                if (nd1 == nd2) {
                    node = nd1;
                    return node;
                }
                nd2 = nd2.getNext();
            }
            nd1 = nd1.getNext();
            nd2 = nd2head;
        }
        return node;
    }

    /**
     * hash解法
     *
     * @param nd1
     * @param nd2
     * @return
     */
    public static Node hashSolution(Node nd1, Node nd2) throws Exception {
        Set<Node> hash = new HashSet<>();
        while (nd1 != null) {
            if (hash.contains(nd1)) {
                throw new Exception("链表成环，不符合题意");
            }
            hash.add(nd1);
            nd1 = nd1.getNext();
        }
        while (nd2 != null) {
            if (hash.contains(nd2)) {
                return nd2;
            }
            hash.add(nd2);
            nd2 = nd2.getNext();
        }
        return null;
    }

    /**
     * 基于栈的解法
     */
    public static Node stackSolution(Node nd1, Node nd2) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        while (nd1 != null) {
            s1.push(nd1);
            nd1 = nd1.getNext();
        }

        while (nd2 != null) {
            s2.push(nd2);
            nd2 = nd2.getNext();
        }

        Node first = null;
        while (s1.peek() != null || s2.peek() != null) {
            Node sd1 = s1.pop();
            Node sd2 = s2.pop();
            if (sd1 == sd2) {
                first = sd1;
            }
            if (sd1 != sd2) {
                return first;
            }
        }
        return first;
    }

    /**
     * 指针解法（掐头去尾法）
     */
    public static Node pointerSolution(Node nd1, Node nd2) {
        int nla = 0;
        int nlb = 0;

        Node l = nd1;
        Node r = nd2;

        while (nd1 != null || nd2 != null) {
            if (nd1 != null) {
                nla++;
                nd1 = nd1.getNext();
            }
            if (nd2 != null) {
                nlb++;
                nd2 = nd2.getNext();
            }
        }

        if (nla > nlb) {
            int i = nla - nlb;
            while (i > 0) {
                l = l.getNext();
                i--;
            }
        } else {
            int i = nlb - nla;
            while (i > 0) {
                r = r.getNext();
                i--;
            }
        }

        while (l != null || r != null) {
            if (l == r) {
                return l;
            }
            l = l.getNext();
            r = r.getNext();
        }
        return null;
    }

    /**
     * 构造交叉链表
     *
     * @return
     */
    public static Node[] buildCrossLinkedList(int firstLen, int firstRange, int sendLen, int sendRange, int crossIndex) {
        Node nd1 = randomBuildLinkedList(firstLen, firstRange);
        Node nd2 = randomBuildLinkedList(sendLen, sendRange);
        Node[] nds = {nd1, nd2};
        int i = 0;
        while (nd1 != null) {
            Node cur = nd1;
            nd1 = nd1.getNext();
            if (i == crossIndex) {
                Node c = cur;               // 交叉节点前面的节点
                Node f = nd1.getNext();     // 交叉节点后面的节点
                while (nd2 != null) {
                    Node h = nd2;
                    nd2 = nd2.getNext();
                    if (nd2 == null) {
                        c.setNext(h);
                        h.setNext(f);
                        break;
                    }
                }
                break;
            }
            i++;
        }
        return nds;
    }

    /**
     * 随机构造一个链表
     *
     * @param len 链表长度
     * @param rr  随机范围
     * @return
     */
    public static Node randomBuildLinkedList(int len, int rr) {
        if (len < 1 || rr < 1) {
            return null;
        }
        Node root = new Node(-1); // 根节点
        Node head = root;
        Random rd = new Random();
        for (int i = 0; i < len; i++) {
            head.setNext(new Node(rd.nextInt(rr) + 1));
            head = head.getNext();
        }
        return root.getNext();
    }

}
