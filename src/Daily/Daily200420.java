package Daily;

/**
 * @author Kwin
 * @since 2020/3/25 22:27
 * <p>
 * 200. 岛屿数量
 * <p>
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */
public class Daily200420 {
    static char[][] grid1 = new char[][]{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
    };
    static char[][] grid2 = new char[][]{
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
    };

    public static void main(String[] args) {
        System.out.println(solution1(grid1));
        System.out.println(solution1(grid2));
    }

    static int solution1(char[][] grid) {
        int count = 0;
        char[][] clone = grid.clone();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                boolean explore = explore(clone, i, j);
                System.out.print(explore+" ");
                count += explore ? 1 : 0;
            }
        }
        return count;
    }

    static boolean explore(char[][] grid, int x, int y) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') {
            return false;
        }
        grid[x][y] = 2;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            while (true) {
                if (!explore(grid, newX, newY)) break;
            }
        }
        return true;
    }
}
