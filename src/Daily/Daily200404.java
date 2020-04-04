package Daily;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Kwin
 * @since 2020/4/4 22:27
 * <p>
 * 42. 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Daily200404 {

    static int[] height1 = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    static int[] height2 = new int[]{};
    static int[] height3 = new int[]{1, 0, 1};
    static int[] height4 = new int[]{2, 0, 1};

    public static void main(String[] args) {
//        System.out.println(solution1(height1));
//        System.out.println(solution1(height2));
//        System.out.println(solution1(height3));
//        System.out.println(solution1(height4));
        System.out.println(bestSolution(height1));
        System.out.println(bestSolution(height2));
        System.out.println(bestSolution(height3));
        System.out.println(bestSolution(height4));
    }

    static int solution1(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int h = Arrays.stream(height).max().getAsInt();
        int count = 0;
        while (h-- > 0) {
            boolean start = false;
            int pool = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] == 0 && start) {
                    pool++;
                }
                if (height[i] != 0) {
                    start = true;
                    height[i]--;
                    count += pool;
                    pool = 0;
                }
            }
        }
        return count;
    }

    static int bestSolution(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int cur = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[cur]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int top = stack.peek();
                    ans += (Math.min(height[top], height[i]) - height[cur]) * (i - top - 1);
                }
            }
            stack.add(i);
        }
        return ans;
    }

}
