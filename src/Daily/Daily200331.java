package Daily;

import java.util.Arrays;

/**
 * @author Kwin
 * @since 2020/3/31 22:21
 *
 * 912. 排序数组
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *
 * 提示：
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 */
public class Daily200331 {
    static int[] nums1 = new int[]{5, 2, 3, 1};
    static int[] nums2 = new int[]{5, 1, 1, 2, 0, 0};

    public static void main(String[] args) {
        System.out.println("Arrays.sort:");
        sout(solution1(nums1));
        sout(solution1(nums2));
        System.out.println("SelectionSort:");
        sout(selectionSort(nums1));
        sout(selectionSort(nums2));
        System.out.println("InsertionSort:");
        sout(insertionSort(nums1));
        sout(insertionSort(nums2));
    }

    static void sout(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    static int[] solution1(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 选择排序
     * 每次在未排定部分的数组中选择一个最小值，将其排到最前面
     */
    static int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            for (int j = index + 1; j < nums.length; j++) {
                if (nums[index] > nums[j]) {
                    index = j;
                }
            }
            swap(nums, index, i);
        }
        return nums;
    }

    /**
     * 插入排序
     * 每次选中一个数字后，插入到前面已经排好序的数组中
     */
    static int[] insertionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            int j = i;
            while (j > 0 && nums[j-1] > tmp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = tmp;
        }
        return nums;
    }
}
