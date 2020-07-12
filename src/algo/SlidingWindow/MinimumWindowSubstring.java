package algorithm.SlidingWindow;

import java.util.Arrays;

/**
 * @author Kwin
 * @since 2020/6/14 15:29
 * <p>
 * 76. 最小覆盖子串
 * <p>
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * <p>
 * 示例：
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
@SuppressWarnings("DuplicatedCode")
public class MinimumWindowSubstring {

    static String S1 = "ADOBECODEBANC", T1 = "ABC";

    public static void main(String[] args) {
        System.out.println(solution(S1, T1));
    }

    static String solution(String s, String t) {
        // 声明两个字典分别保存s字符串和窗口当前的字符频数
        int[] target = new int[128];
        int[] window = new int[128];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        // 初始化origin字典
        for (char tChar : tChars) {
            target[tChar] += 1;
        }

        // 编辑距离
        // 当window字典中该字符的数量还不够时，则+1；如果够了或多了，则不变
        // 当window字典中该字符的数量不足t中频数时，则-1
        int editDistance = 0;
        // 保存最小字符串的相关字段
        int minLen = s.length() + 1;
        int index = 0;
        // 滑动窗口指针
        int left = 0, right = 0;
        while (right < s.length()) {
            char rightChar = sChars[right];
            if (target[rightChar] > window[rightChar]) {
                editDistance++;
            }
            // 窗口内right字符频数+1，窗口右边界+1
            window[rightChar]++;
            right++;
//            System.out.println("窗口扩张");
            printWindow(sChars, left, right);

            // 满足可行解，通过左边界收缩窗口获取局部最优解
            while (editDistance == t.length()) {
                // 获取局部最优解
                if (right - left < minLen) {
                    minLen = right - left;
                    index = left;
                    System.out.println("记录此时最小覆盖子串为" + s.substring(index, index + minLen));
                }
                char leftChar = sChars[left];
                if (target[leftChar] == window[leftChar])
                    editDistance--;
                // 窗口内left字符频数-1，窗口左边界+1
                window[leftChar]--;
                left++;
//                System.out.println("窗口收缩");
                printWindow(sChars, left, right);
            }
        }

        // 判断是否存在最小覆盖子串并返回
        return minLen == s.length() + 1 ? "" : s.substring(index, index + minLen);
    }

    static void printWindow(char[] array, int left, int right) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = left; i < right; i++) {
            sb.append(array[i]).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb.toString());
    }

}
