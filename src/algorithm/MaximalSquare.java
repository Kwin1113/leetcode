package algorithm;

/**
 * @author Kwin
 * @since 2020/7/4 10:25
 * <p>
 * 221. 最大正方形
 * <p>
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * <p>
 * 示例:
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 输出: 4
 */
public class MaximalSquare {
    static char[][] matrix1 = new char[][]{
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
    };
    static char[][] matrix2 = new char[][]{
            {}
    };
    static char[][] matrix3 = new char[][]{
            {'1'},
            {'1'},
            {'0'},
            {'1'}
    };
    static char[][] matrix4 = new char[][]{
            {'1', '0', '1'}
    };

    public static void main(String[] args) {
        System.out.println(maximalSquare(matrix1));
        System.out.println(maximalSquare(matrix2));
        System.out.println(maximalSquare(matrix3));
        System.out.println(maximalSquare(matrix4));
    }

    static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int max = 0;

        // 定义dp数组
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max * max;
    }
}
