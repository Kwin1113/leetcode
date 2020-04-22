package Daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Kwin
 * @since 2020/3/25 22:27
 * <p>
 * 199. 二叉树的右视图
 * <p>
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * <p>
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Daily200422 {

    static TreeNode root1;

    static {
        root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.right = new TreeNode(5);
        root1.right = new TreeNode(3);
//        root1.right.right = new TreeNode(4);
    }

    public static void main(String[] args) {
        System.out.println(solution1(root1));
        System.out.println(solution2(root1));
    }

    static List<Integer> solution1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    result.add(node.val);
                }
            }
        }
        return result;
    }

    static List<Integer> solution2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        findRight(result, root, 0);
        return result;
    }

    static void findRight(List<Integer> result, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (result.size() == depth) {
            result.add(root.val);
        }
        findRight(result, root.right, ++depth);
        findRight(result, root.left, depth);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
