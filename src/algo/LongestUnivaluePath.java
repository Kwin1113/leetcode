package algo;

/**
 * @author Kwin
 * @since 2020/7/6 11:57
 *
 * 687. 最长同值路径
 *
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 * 2
 *
 * 示例 2:
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 */
public class LongestUnivaluePath {
    static TreeNode root1 = new TreeNode(5, new TreeNode(4, new TreeNode(1), new TreeNode(1)), new TreeNode(5, null, new TreeNode(5)));
    static TreeNode root2 = new TreeNode(1, new TreeNode(4, new TreeNode(4), new TreeNode(4)), new TreeNode(5, null, new TreeNode(5)));
    static int ans = 0;

    public static void main(String[] args) {

    }

    static int longestUnivaluePath(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftans = 0, rightans = 0;
        if (root.left != null && root.left.val == root.val) {
            leftans += left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rightans += right + 1;
        }
        ans = Math.max(ans, leftans + rightans);
        return Math.max(leftans, rightans);
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
