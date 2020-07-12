package algo;

/**
 * @author Kwin
 * @since 2020/7/6 23:27
 * <p>
 * 226. 翻转二叉树
 *
 * 翻转一棵二叉树。
 *
 * 示例：
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class InvertBinaryTree {
    static TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));

    public static void main(String[] args) {

    }

    static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftTree = invertTree(root.left);
        TreeNode rightTree = invertTree(root.right);
        root.left = rightTree;
        root.right = leftTree;
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }
}
