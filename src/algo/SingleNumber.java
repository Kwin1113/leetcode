package algo;

/**
 * @author Kwin
 * @since 2020/7/11 21:17
 *
 * 136. 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {
    static int[] nums1 = new int[]{2, 2, 1};
    static int[] nums2 = new int[]{4, 1, 2, 1, 2};

    public static void main(String[] args) {
        System.out.println(singleNumber(nums1));
        System.out.println(singleNumber(nums2));
    }

    static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
