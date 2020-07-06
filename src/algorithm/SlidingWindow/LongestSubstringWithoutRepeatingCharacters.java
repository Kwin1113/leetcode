package algorithm.SlidingWindow;

import java.util.Arrays;

/**
 * @author Kwin
 * @since 2020/6/14 21:06
 * <p>
 * 3. 无重复字符的最长子串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstringWithoutRepeatingCharacters {
    static String s1 = "abcabcbb";
    static String s2 = "bbbbb";
    static String s3 = "pwwkew";
    static String s4 = " ";
    static String s5 = "hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static void main(String[] args) {
        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
        System.out.println(solution(s5));
    }

    static int solution(String s) {
        char[] chars = s.toCharArray();
        int[] window = new int[128];

        int maxLen = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = chars[right];
            if (window[c] == 0) {
                window[c]++;
            } else {
                if (right - left > maxLen)
                    maxLen = right - left;
                while (chars[left] != c) {
                    window[chars[left++]] = 0;
                }
                window[chars[left++]] = 1;
            }
            right++;
        }
        if (right - left > maxLen)
            maxLen = right - left;

        return maxLen;
    }
}
