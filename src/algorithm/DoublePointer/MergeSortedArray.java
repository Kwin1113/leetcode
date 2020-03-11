package algorithm.DoublePointer;

import java.util.Arrays;

/**
 * 5. 归并两个有序数组
 * 88. Merge Sorted Array (Easy)
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * nums1 = [1,5,6,0,0,0], m = 3
 * nums2 = [2,3,4],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bestSolution()));
    }

    static int m = 3, n = 3;
//    static int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
//    static int[] nums2 = new int[]{2, 5, 6};

    static int[] nums1 = new int[]{1, 5, 6, 0, 0, 0};
    static int[] nums2 = new int[]{2, 3, 4};

    static int[] solution1() {
        return null;
    }

    static int[] bestSolution() {
        int i = m - 1;
        int j = n - 1;
        int total = m + n - 1;
        while (j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[total--] = nums2[j--];
            } else if (nums1[i] > nums2[j]) {
                nums1[total--] = nums1[i--];
            } else {
                nums1[total--] = nums1[i--];
                nums1[total--] = nums2[j--];
            }
        }

        return nums1;
    }
}
