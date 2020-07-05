package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Kwin
 * @since 2020/7/5 10:05
 * <p>
 * 102. 二叉树的层序遍历
 * <p>
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {
    static TreeNode root1 = new TreeNode(3);

    static {
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
    }

    public static void main(String[] args) {
        System.out.println(levelOrder(root1));
        System.out.println(levelOrder0(root1));
    }

    /**
     * BFS
     */
    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // 定义一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 首先将root放进去
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 定义题目需要的List<Integer>
            List<Integer> level = new ArrayList<>();
            // 队列中的元素数量即当前树层次数量
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                level.add(cur.val);
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            if (!level.isEmpty()) {
                res.add(level);
            }
        }
        return res;
    }

    /**
     * DFS
     */
    static List<List<Integer>> levelOrder0(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            dfs(res, root, 0);
        }
        return res;
    }

    static void dfs(List<List<Integer>> res, TreeNode root, int level) {
        // 当结果集合中没有对应级别的数据时，新建
        if (res.size() - 1 < level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        if (root.left != null) {
            dfs(res, root.left, level + 1);
        }
        if (root.right != null) {
            dfs(res, root.right, level + 1);
        }
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
