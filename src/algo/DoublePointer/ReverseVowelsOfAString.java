package algo.DoublePointer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 3. 反转字符串中的元音字符
 * 345. Reverse Vowels of a String (Easy)
 * <p>
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * 输入: "hello"
 * 输出: "holle"
 * <p>
 * 示例 2:
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 */
public class ReverseVowelsOfAString {

    public static void main(String[] args) {
        solution1(s2);
    }

    static String s1 = "hello";
    static String s2 = "leetcode";

    static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    static void solution1(String s) {
        char[] result = new char[s.length()];

        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            char start = s.charAt(i);
            char end = s.charAt(j);
            if (!vowels.contains(start)) {
                result[i++] = start;
            } else if (!vowels.contains(end)) {
                result[j--] = end;
            } else {
                result[i++] = end;
                result[j--] = start;
            }
        }

        System.out.println(new String(result));
    }

    static void bestSolution() {

    }
}
