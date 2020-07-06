package algorithm;

import java.util.HashMap;

/**
 * @author Kwin
 * @since 2020/7/5 10:58
 *
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    static int[] preorder = new int[]{3, 9, 20, 15, 7};
    static int[] inorder = new int[]{9, 3, 15, 20, 7};
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) {

    }

    static TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    static TreeNode build(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        // 根据前序遍历找到根节点
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);

        // 在中序遍历中找到该节点下标
        Integer inIndex = map.get(rootVal);

        root.left = build(preorder, preLeft + 1, inIndex - inLeft + preLeft, inorder, inLeft, inIndex - 1);
        root.right = build(preorder, inIndex - inLeft + preLeft + 1, preRight, inorder, inIndex + 1, inRight);
        return root;
    }

    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
