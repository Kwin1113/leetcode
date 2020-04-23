package Daily;

/**
 * @author Kwin
 * @since 2020/4/23 22:24
 * <p>
 * 面试题 08.11. 硬币
 * <p>
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 * <p>
 * 示例1:
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * <p>
 * 示例2:
 * 输入: n = 10
 * 输出：4
 * 解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * <p>
 * 说明：
 * 注意:
 * 你可以假设：
 * 0 <= n (总金额) <= 1000000
 */
public class Daily200423 {

    static int n1 = 5;
    static int n2 = 10;

    public static void main(String[] args) {
        System.out.println(solution1(n1));
        System.out.println(solution1(n2));
        System.out.println(solution2(n1));
        System.out.println(solution2(n2));
    }

    /**
     * dp[i][j] = dp[i-1][j] + dp[i][j-coin]
     */
    static int solution1(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        int[][] dp = new int[5][n + 1];
        for (int i = 1; i <= 4; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j] % 1000000007;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - coins[i - 1]]) % 1000000007;
                }
            }
        }
        return dp[4][n];
    }

    /**
     * dp[i] = dp[i] + d[i-coin]
     */
    static int solution2(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = 1; i <= n; i++) {
                if (i - coin >= 0) {
                    dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
                }
            }
        }
        return dp[n];
    }
}
