package cn.goofyww.leetcode.tree;

import java.util.*;

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

        nd1.left = nd2;
        nd1.right = nd3;

        nd2.left = nd4;

        nd4.left = nd5;
        nd4.right = nd6;

        nd3.left = nd7;
        nd3.right = nd8;

        nd8.right = nd9;
         /*
                            5
                          /   \
                         8     4
                       /  \   /  \
                     11     13    4
                   /   \         /  \
                  7    2             1
          */
//        System.out.println(hasSum(nd1, 22));

//        preorderTraversal(nd1);               // 前序 递归实现
//        preorderTraversal2(nd1);              // 前序 非递归实现1
//        preorderTraversal3(nd1);              // 前序 非递归实现2

//        mediumOrderTraversal(nd1);            // 中序 递归实现
//        mediumOrderTraversal2(nd1);           // 中序 非递归实现1

//        postorderTraversal(nd1);              // 后序
        postorderTraversal2(nd1);             // 后序 非递归实现1
//        postorderTraversal3(nd1);             // 后序 非递归实现2

//        levelTraversal(nd1);                  // 层序

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

    /**
     * 前序遍历，递归实现
     * 深度优先遍历
     * root -> left -> right
     */
    public static void preorderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.printf("%d\t", root.value);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    /**
     * 前序遍历，非递归实现
     * 深度优先遍历，深度优先搜索(Depth First Search)是沿着树的深度遍历树的节点，尽可能深的搜索树的分支
     * 深度优先搜索二叉树是先访问根结点，然后遍历左子树接着是遍历右子树，因此我们可以利用堆栈的先进后出的特点
     * root -> left -> right
     */
    public static void preorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();                  // 用一个栈来存放树中的节点
        while (root != null || !stack.isEmpty()) {              // 只要当前节点不为空(即当前节点的左右子树没有访问完毕)或者栈中还有节点(还有节点没有访问)
            while (root != null) {                              // 一直往左走
                stack.push(root);                               // 根节点入栈
                System.out.printf("%d\t", root.value);          // 打印根节点
                root = root.left;                               // 访问左子树
            }
            root = stack.pop();                                 // 取出根节点
            root = root.right;                                  // 访问右子树
        }
    }

    /**
     * 前序遍历，非递归实现2
     * 深度优先遍历，深度优先搜索(Depth First Search)是沿着树的深度遍历树的节点，尽可能深的搜索树的分支
     * 深度优先搜索二叉树是先访问根结点，然后遍历左子树接着是遍历右子树，因此我们可以利用堆栈的先进后出的特点
     * root -> left -> right
     */
    public static void preorderTraversal3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return;                              // 树为空
        stack.push(root);                                      // 将根节点压入栈中
        while (!stack.isEmpty()) {                             // 只要栈不为空，执行循环
            root = stack.pop();                                // 取出栈顶元素打印，此时的栈顶元素是以node为根的子树的根
            System.out.printf("%d\t", root.value);
            if (root.right != null) {                          // 将右子树压入栈中
                stack.push(root.right);
            }
            if (root.left != null) {                           // 将左子树压入栈中
                stack.push(root.left);
            }
        }
    }

    /**
     * 中序遍历，递归实现
     * left -> root - right
     */
    public static void mediumOrderTraversal(TreeNode root) {
        if (root == null) return;
        mediumOrderTraversal(root.left);
        System.out.printf("%d\t", root.value);
        mediumOrderTraversal(root.right);
    }

    /**
     * 中序遍历，非递归实现
     * left -> root - right
     */
    public static void mediumOrderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {              // 只要当前节点不为空(即当前节点的左右子树没有访问完毕)或者栈中还有节点(还有节点没有访问)
            while (root != null) {
                stack.push(root);                               // 根节点入栈
                root = root.left;                               // 访问左子树
            }
            root = stack.pop();                                 // 取出左子树的根节点
            System.out.printf("%d\t", root.value);              // 打印
            root = root.right;                                  // 访问右子树
        }
    }

    /**
     * 后序遍历
     * left -> right -> root
     */
    public static void postorderTraversal(TreeNode root) {
        if (root == null) return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.printf("%d\t", root.value);
    }

    /**
     * 后序遍历，非递归实现1
     * left -> right -> root
     */
    public static void postorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode pre = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;                                   // 访问左子树
            }
            node = stack.peek();                                    // 判断栈顶元素(根)

            // 1. 如果此时的根的右子树为空 node.right == null
            // 2. 如果此时的根的右子树已经访问过了
            //    node.right == prev (prev记录的是上次访问打印的节点)
            if (node.right == null || node.right == pre) {
                stack.pop();                                        // 打印根节点，并出栈，将打印过的节点从栈中删除
                System.out.printf("%d\t", node.value);
                pre = node;                                         // 记录prev，表示以当前 prev 为根的子树已经访问过了
                node = null;                                        // node置null就不会再次访问以node为根节点的左右子树，这里的node既然已经打印，说明它的左右子树早已访问完毕
            } else {
                node = node.right;                                  // 访问右子树
            }
        }
    }

    /**
     * 后序遍历，非递归实现2
     * left -> right -> root
     */
    public static void postorderTraversal3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        if (root == null) return;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(0, node.value);                // 头插此时根节点
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        for (Integer v : list) {
            System.out.printf("%d\t", v);
        }
    }

    /**
     * 广度优先遍历
     * 广度优先搜索(Breadth First Search),又叫宽度优先搜索 or 横向优先搜索 or 层序遍历，是从根结点开始沿着树的宽度搜索遍历
     * 可以利用队列实现广度优先搜索
     */
    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {                             // 如果根节点不为空,将第一层根节点入队列
            queue.offer(root);
        }
        while (!queue.isEmpty()) {                      // 只要队列不为空，执行循环
            int num = queue.size();                     // 记录此时队列的长度，此时的num代表了某一层一共有多少个节点，防止被后边入队的节点个数影响输出这一层的节点
            for (int i = 0; i < num; i++) {             // 对某一层的所有节点进行操作(从左到右)
                TreeNode node = queue.poll();           // 取出这一层第一个节点
                System.out.printf("%d\t", node.value);  // 打印节点
                if (node.left != null) {                // 将此节点的左子树根节点入队列
                    queue.offer(node.left);
                }
                if (node.right != null) {               // 将此节点的右子树根节点入队列
                    queue.offer(node.right);
                }
            }
        }
    }

}
