package Daily;

/**
 * @author Kwin
 * @since 2020/3/25 22:27
 * <p>
 * 1248. 统计「优美子数组」
 * <p>
 * 给你一个整数数组 nums 和一个整数 k。
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * <p>
 * 示例 2：
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * <p>
 * 示例 3：
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 * <p>
 * 提示：
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 */
public class Daily200421 {
    static int[] nums1 = new int[]{1, 1, 2, 1, 1};
    static int k1 = 3;
    static int[] nums2 = new int[]{2, 4, 6};
    static int k2 = 1;
    static int[] nums3 = new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
    static int k3 = 2;
    static int[] nums4 = new int[]{1, 1, 1, 1, 1};
    static int k4 = 1;

    public static void main(String[] args) {
        System.out.println(solution1(nums1, k1));
        System.out.println(solution1(nums2, k2));
        System.out.println(solution1(nums3, k3));
        System.out.println(solution1(nums4, k4));
        System.out.println(solution2(nums1, k1));
        System.out.println(solution2(nums2, k2));
        System.out.println(solution2(nums3, k3));
        System.out.println(solution2(nums4, k4));
    }

    static int solution1(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int count = 0;
            int j = i;
            while (j < nums.length) {
                count += nums[j++] % 2 == 1 ? 1 : 0;
                result += count == k ? 1 : 0;
                if (count > k) {
                    break;
                }
            }
        }
        return result;
    }

    static int solution2(int[] nums, int k) {
        int n = nums.length;
        int[] odd = new int[n + 2];
        int ans = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) odd[++cnt] = i;
        }
        odd[0] = -1;
        odd[++cnt] = n;
        for (int i = 1; i + k <= cnt; i++) {
            ans += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        return ans;
    }
}
