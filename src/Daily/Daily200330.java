package Daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kwin
 * @since 2020/3/25 22:27
 *
 * 面试题62. 圆圈中最后剩下的数字
 *
 * 0,1,...,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 示例 1：
 * 输入: n = 5, m = 3
 * 输出: 3
 *
 * 示例 2：
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 * 限制：
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 */
public class Daily200330 {

    static int n1 = 5, m1 = 3;
    static int n2 = 10, m2 = 17;

    public static void main(String[] args) {
        System.out.println(solution1(n1, m1));
        System.out.println(solution1(n2, m2));
        System.out.println(bestSolution(n1, m1));
        System.out.println(bestSolution(n2, m2));
    }

    /**
     * 暴力
     */
    static int solution1(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    static int bestSolution(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
