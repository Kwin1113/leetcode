package Daily;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author Kwin
 * @since 2020/3/25 22:27
 * <p>
 * 151. 翻转字符串里的单词
 * <p>
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * <p>
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class Daily200410 {

    static String s1 = "the sky is blue";
    static String s2 = "  hello world!";
    static String s3 = "a good   example";
    static String s4 = "";
    static String s5 = " ";
    static String s6 = "  asdf";
    static String s7 = "  asdf   ";
    static String s8 = "asdf   ";
    static String s9 = " as df   ";

    public static void main(String[] args) {
//        System.out.println("[" + solution1(s1) + "]");
//        System.out.println("[" + solution1(s2) + "]");
//        System.out.println("[" + solution1(s3) + "]");
//        System.out.println("[" + solution1(s4) + "]");
//        System.out.println("[" + solution1(s5) + "]");
//        System.out.println("[" + solution1(s6) + "]");
//        System.out.println("[" + solution1(s7) + "]");
//        System.out.println("[" + solution1(s8) + "]");
//        System.out.println("[" + solution1(s9) + "]");
//        System.out.println("[" + solution2(s1) + "]");
//        System.out.println("[" + solution2(s2) + "]");
        System.out.println("[" + solution2(s3) + "]");
//        System.out.println("[" + solution2(s4) + "]");
//        System.out.println("[" + solution2(s5) + "]");
//        System.out.println("[" + solution2(s6) + "]");
//        System.out.println("[" + solution2(s7) + "]");
//        System.out.println("[" + solution2(s8) + "]");
//        System.out.println("[" + solution2(s9) + "]");
    }

    static String solution1(String s) {
        Stack<String> stack = new Stack<>();
        int length = s.length();
        int i = 0;
        int index = i;
        int len = 0;
        while (i < length) {
            char c = s.charAt(i);
            if (c != ' ') {
                i++;
                len++;
            } else {
                if (len != 0) {
                    stack.push(s.substring(index, i));
                    len = 0;
                }
                i++;
                index = i;
            }
        }
        if (index != i) {
            stack.push(s.substring(index, i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        String result = sb.toString();
        return result.trim();
    }

    static String solution2(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
