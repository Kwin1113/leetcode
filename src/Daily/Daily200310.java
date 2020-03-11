package Daily;

/**
 * @author Kwin
 * @since 2020/3/10 22:36
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Daily200310 {
    static TreeNode tree1;

    static {
        tree1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        tree1.left = node2;
        tree1.right = node3;
        node2.left = node4;
        node2.right = node5;
    }

    public static void main(String[] args) {
        System.out.println(solution1(tree1));
    }

    static int ans;

    static int solution1(TreeNode root) {
        return 0;
    }

    static int bestSolution(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        ans = Math.max(ans, l + r + 1);
        return Math.max(l, r) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
