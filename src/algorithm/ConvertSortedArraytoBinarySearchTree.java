package algorithm;

/**
 * @author Kwin
 * @since 2020/7/5 10:24
 * <p>
 * 108. 将有序数组转换为二叉搜索树
 * <p>
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 *       0
 *      / \
 *    -3   9
 *   /   /
 * -10  5
 */
public class ConvertSortedArraytoBinarySearchTree {
    static int[] nums1 = new int[]{-10, -3, 0, 5, 9};

    public static void main(String[] args) {
        sortedArrayToBST(nums1);
    }

    /**
     * 中序遍历，选择最中间左边的元素做根
     */
    static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    static TreeNode helper(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        int mid = (i + j) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, i, mid - 1);
        root.right = helper(nums, mid + 1, j);
        return root;
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
