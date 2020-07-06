package algorithm.SlidingWindow;

/**
 * @author Kwin
 * @since 2020/6/14 19:13
 * <p>
 * 567. 字符串的排列
 * <p>
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 * 注意：
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */
@SuppressWarnings("DuplicatedCode")
public class PermutationInString {
    static String s1 = "ab", s2 = "eidbaooo";
    static String s3 = "ab", s4 = "eidboaoo";
    static String s5 = "adc", s6 = "dcda";
    static String s7 = "ab", s8 = "a";

    public static void main(String[] args) {
        System.out.println(solution(s1, s2));
//        System.out.println(solution(s3, s4));
//        System.out.println(solution(s5, s6));
//        System.out.println(solution(s7, s8));
    }

    static boolean solution(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;
        int[] target = new int[26];
        int[] window = new int[26];
        char[] sChars = s2.toCharArray();
        char[] tChars = s1.toCharArray();
        for (char tChar : tChars)
            target[tChar - 'a']++;

        // 滑动窗口的长度限定为s1的长度
        int left = 0, right = s1.length();
        for (char c : s2.substring(left, right).toCharArray())
            window[c - 'a']++;
        while (right < s2.length()) {
            if (equal(target, window))
                return true;
            // 右边界+1
            window[sChars[right++] - 'a']++;
            // 左边界+1，保证滑动窗口长度不变
            window[sChars[left++] - 'a']--;
        }
        return equal(target, window);
    }

    /**
     * 条件满足的判断 - 两char数组中相同字符频数相等
     */
    static boolean equal(int[] c1, int[] c2) {
        if (c1.length != c2.length)
            return false;
        for (int i = 0; i < c1.length; i++)
            if (c1[i] != c2[i])
                return false;
        return true;
    }
}
