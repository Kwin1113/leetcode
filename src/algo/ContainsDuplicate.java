package algo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kwin
 * @since 2020/7/11 21:02
 * <p>
 * 217. 存在重复元素
 * <p>
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class ContainsDuplicate {
    static int[] nums1 = new int[]{1, 2, 3, 1};
    static int[] nums2 = new int[]{1, 2, 3, 4};
    static int[] nums3 = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

    public static void main(String[] args) {
        System.out.println(containsDuplicate(nums1));
        System.out.println(containsDuplicate(nums2));
        System.out.println(containsDuplicate(nums3));
    }

    static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

}
