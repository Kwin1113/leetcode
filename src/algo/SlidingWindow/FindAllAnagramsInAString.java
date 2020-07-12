package algo.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kwin
 * @since 2020/6/14 20:55
 * <p>
 * 438. 找到字符串中所有字母异位词
 * <p>
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * <p>
 * 示例 1:
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * <p>
 * 示例 2:
 * 输入:
 * s: "abab" p: "ab"
 * 输出:
 * [0, 1, 2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
@SuppressWarnings("DuplicatedCode")
public class FindAllAnagramsInAString {
    static String s1 = "cbaebabacd", p1 = "abc";
    static String s2 = "abab", p2 = "ab";

    public static void main(String[] args) {
        System.out.println(solution(s1, p1));
        System.out.println(solution(s2, p2));
    }

    static List<Integer> solution(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length())
            return result;
        int[] target = new int[26];
        int[] window = new int[26];
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        for (char pChar : pChars) {
            target[pChar - 'a']++;
        }

        int left = 0, right = p.length();
        for (int i = 0; i < right; i++)
            window[sChars[i] - 'a']++;
        while (right < s.length()) {
            if (equal(target, window))
                result.add(left);
            window[sChars[right++] - 'a']++;
            window[sChars[left++] - 'a']--;
        }
        if (equal(target, window))
            result.add(left);

        return result;
    }

    static boolean equal(int[] c1, int[] c2) {
        if (c1.length != c2.length)
            return false;
        for (int i = 0; i < c1.length; i++)
            if (c1[i]!=c2[i])
                return false;
        return true;
    }
}
