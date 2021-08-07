package cn.goofyww.leetcode.tree;

import java.util.HashSet;
import java.util.Set;

public class BinaryTreeExample {

    public static void main(String[] args) {
        TreeNode nd1 = new TreeNode(5);

        TreeNode nd2 = new TreeNode(8);
        TreeNode nd3 = new TreeNode(4);

        TreeNode nd4 = new TreeNode(11);

        TreeNode nd5 = new TreeNode(7);
        TreeNode nd6 = new TreeNode(2);

        TreeNode nd7 = new TreeNode(13);
        TreeNode nd8 = new TreeNode(4);

        TreeNode nd9 = new TreeNode(1);

        Set<Object> set = new HashSet<>();

        nd1.left = nd2;
        nd1.right = nd3;

        nd2.left = nd4;

        nd4.left = nd5;
        nd4.right = nd6;

        nd3.left = nd7;
        nd3.right = nd8;

        nd8.right = nd9;

        System.out.println(hasSum(nd1, 22));
    }

    /**
     * 二叉树中的路径和
     *
     * @param root 二叉树 根节点
     * @param sum  路径和
     * @return
     */
    public static boolean hasSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.value == sum && root.left == null && root.right == null) return true;
        return hasSum(root.left, sum - root.value) || hasSum(root.right, sum - root.value);
    }

}
