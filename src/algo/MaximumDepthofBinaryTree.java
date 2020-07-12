package algo;

import javax.swing.tree.TreeNode;

/**
 * @author Kwin
 * @since 2020/7/5 10:32
 * <p>
 * 104. 二叉树的最大深度
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * 返回它的最大深度 3 。
 */
public class MaximumDepthofBinaryTree {
    static TreeNode root1 = new TreeNode(3);
    static {
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
    }

    public static void main(String[] args) {
        System.out.println(maxDepth(root1));
    }

    static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
