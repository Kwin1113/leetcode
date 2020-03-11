package algorithm.DoublePointer;

/**
 * 4. 回文字符串
 * 680. Valid Palindrome II (Easy)
 * <p>
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * 输入: "aba"
 * 输出: True
 * <p>
 * 示例 2:
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 */
public class ValidPalindromeII {

    public static void main(String[] args) {
//        System.out.println(solution1(s2));
        System.out.println(bestResolution(s1));
    }

    static String s1 = "aba";
    static String s2 = "abca";

    static boolean solution1(String s) {
        int count = 1;

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (ci != cj) {
                if (count == 0) {
                    return false;
                }
                if (s.charAt(i + 1) == cj) {
                    i++;
                    count--;
                } else if (ci == s.charAt(j - 1)) {
                    j--;
                    count--;
                } else {
                    return false;
                }
                continue;
            }
            i++;
            j--;
        }
        return true;
    }

    static boolean bestResolution(String s) {
        int i = 0;
        int j = s.length() - 1;

        for (; i < j; i++, j--) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (ci != cj) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
