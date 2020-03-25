package Daily;

/**
 * @author Kwin
 * @since 2020/3/25 22:27
 *
 * 892. 三维形体的表面积
 *
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 请你返回最终形体的表面积。
 *
 * 示例 1：
 * 输入：[[2]]
 * 输出：10
 *
 * 示例 2：
 * 输入：[[1,2],[3,4]]
 * 输出：34
 *
 * 示例 3：
 * 输入：[[1,0],[0,2]]
 * 输出：16
 *
 * 示例 4：
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 *
 * 示例 5：
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 *
 * 提示：
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 */
public class Daily200325 {

    static int[][] grid1 = new int[][]{
            {2}
    };
    static int[][] grid2 = new int[][]{
            {1, 2},
            {3, 4}
    };
    static int[][] grid3 = new int[][]{
            {1, 0},
            {0, 2}
    };
    static int[][] grid4 = new int[][]{
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
    };
    static int[][] grid5 = new int[][]{
            {2, 2, 2},
            {2, 1, 2},
            {2, 2, 2}
    };
    static int[][] grid6 = new int[][]{
            {3, 3, 3},
            {3, 4, 5},
            {5, 0, 4}
    };

    public static void main(String[] args) {
        System.out.println(solution1(grid1));
        System.out.println(solution1(grid2));
        System.out.println(solution1(grid3));
        System.out.println(solution1(grid4));
        System.out.println(solution1(grid5));
        System.out.println(solution1(grid6));
    }

    static int solution1(int[][] grid) {
        int count = 0;
        int overlap = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int cur = grid[i][j];
                count += cur;
                overlap += cur != 0 ? 2 * (cur - 1) : 0;
                if (i > 0) {
                    overlap += Math.min(cur, grid[i - 1][j]);
                }
                if (j > 0) {
                    overlap += Math.min(cur, grid[i][j - 1]);
                }
                if (i < grid.length - 1) {
                    overlap += Math.min(cur, grid[i + 1][j]);
                }
                if (j < grid[0].length - 1) {
                    overlap += Math.min(cur, grid[i][j + 1]);
                }
            }
        }

        return 6 * count - overlap;
    }
}
