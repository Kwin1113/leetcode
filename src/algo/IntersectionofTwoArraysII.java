package algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Kwin
 * @since 2020/7/11 21:20
 *
 * 350. 两个数组的交集 II
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 *
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 进阶:
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class IntersectionofTwoArraysII {
    static int[] nums11 = new int[]{1, 2, 2, 1}, nums21 = new int[]{2, 2};
    static int[] nums12 = new int[]{4,9,5}, nums22 = new int[]{9, 4, 9, 8, 4};

    public static void main(String[] args) {
        System.out.println(intersect(nums11, nums21));
        System.out.println(intersect(nums12, nums22));
    }

    static int[] intersect(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }

        int k = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                nums1[k++] = num;
                map.put(num, count - 1);
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }
}
