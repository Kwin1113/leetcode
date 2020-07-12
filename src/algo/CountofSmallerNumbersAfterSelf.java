package algo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kwin
 * @since 2020/7/11 20:54
 *
 * 315. 计算右侧小于当前元素的个数
 *
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * 示例:
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 */
public class CountofSmallerNumbersAfterSelf {
    static int[] nums1 = new int[]{5, 2, 6, 1};
    static int[] nums2 = new int[]{};
    static int[] nums3 = new int[]{1};
    static int[] nums4 = new int[]{0};

    public static void main(String[] args) {
        System.out.println(countSmaller(nums1));
        System.out.println(countSmaller(nums2));
        System.out.println(countSmaller(nums3));
        System.out.println(countSmaller(nums4));
    }

    static List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            res.add(count);
        }

        return res;
    }
}
