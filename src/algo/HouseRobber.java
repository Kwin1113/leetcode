package algo;

/**
 * @author Kwin
 * @since 2020/7/5 20:13
 *
 * 198. 打家劫舍
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *  
 * 提示：
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
public class HouseRobber {
    static int[] nums1 = new int[]{1, 2, 3, 1};
    static int[] nums2 = new int[]{2, 7, 9, 3, 1};

    public static void main(String[] args) {
        System.out.println(rob(nums1));
        System.out.println(rob(nums2));
        System.out.println(rob0(nums1));
        System.out.println(rob0(nums2));
        System.out.println(rob1(nums1));
        System.out.println(rob1(nums2));
    }

    static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 定义dp数组
        int[][] dp = new int[nums.length][2];
        // 初始化dp数组
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }

        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    static int rob0(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 定义dp数组
        int[] dp = new int[nums.length];
        // 初始化dp数组
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

    static int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 定义两个变量存储
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }
        return Math.max(first, second);
    }
}
