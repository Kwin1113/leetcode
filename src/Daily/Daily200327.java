package Daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Kwin
 * @since 2020/3/25 22:27
 * <p>
 * 914. 卡牌分组
 * <p>
 * 给定一副牌，每张牌上都写着一个整数。
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 * <p>
 * 示例 1：
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * <p>
 * 示例 2：
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * <p>
 * 示例 3：
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * <p>
 * 示例 4：
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * <p>
 * 示例 5：
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 * <p>
 * 提示：
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 */
public class Daily200327 {

    static int[] deck1 = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
    static int[] deck2 = new int[]{1, 1, 1, 2, 2, 2, 3, 3};
    static int[] deck3 = new int[]{1};
    static int[] deck4 = new int[]{1, 1};
    static int[] deck5 = new int[]{1, 1, 2, 2, 2, 2};
    static int[] deck6 = new int[]{1, 1, 1, 1, 2, 2, 2, 2, 2, 2};
    static int[] deck7 = new int[]{1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3};

    public static void main(String[] args) {
        System.out.println(solution1(deck1));
        System.out.println(solution1(deck2));
        System.out.println(solution1(deck3));
        System.out.println(solution1(deck4));
        System.out.println(solution1(deck5));
        System.out.println(solution1(deck6));
        System.out.println(solution1(deck7));
//        System.out.println(devide(4));
    }

    static boolean solution1(int[] deck) {
        if (deck.length < 2) {
            return false;
        }
        int[] count = new int[deck.length];
        for (int i : deck) {
            count[i]++;
        }
        int min = Arrays.stream(count).filter(e -> e > 0).min().getAsInt();
        if (min == 1) {
            return false;
        }
        Set<Integer> devides = new HashSet<>();
        devides.add(min);
        devides.addAll(devide(min));
        for (int i : count) {
            Iterator<Integer> iterator = devides.iterator();
            while (iterator.hasNext()) {
                Integer devide = iterator.next();
                if (i % devide == 0) {
                    break;
                } else {
                    iterator.remove();
                }
            }
        }
        return devides.size() != 0;
    }

    static Set<Integer> devide(int num) {
        Set<Integer> devide = new HashSet<>();
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                devide.add(i);
                devide.add(num / i);
            }
        }
        return devide;
    }

}
