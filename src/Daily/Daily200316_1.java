package Daily;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kwin
 * @since 2020/3/16 22:12
 * <p>
 * 179. 最大数
 * <p>
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * <p>
 * 示例 1:
 * 输入: [10,2]
 * 输出: 210
 * <p>
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class Daily200316_1 {
    static int[] array1 = new int[]{10, 2};
    static int[] array2 = new int[]{3, 30, 34, 5, 9};
    static int[] array3 = new int[]{3, 30, 34};

    public static void main(String[] args) {
        System.out.println(solution1(array1));
        System.out.println(solution1(array2));
        System.out.println(solution1(array3));
    }

    static String solution1(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.sort(new comparator().reversed());
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
        }
        if (list.get(0) == 0) {
            return "0";
        }
        return sb.toString();
    }

    static class comparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            return (s1 + s2).compareTo((s2 + s1));
        }
    }

    static String bestSolution(int[] nums) {
        return null;
    }
}
