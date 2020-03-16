package Daily;

/**
 * @author kwin <969263948@qq.com>
 * @since 2020/3/16 17:20
 * <p>
 * 面试题 01.06. 字符串压缩
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。
 * 若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * <p>
 * 示例2:
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * <p>
 * 提示：
 * 字符串长度在[0, 50000]范围内。
 **/
public class Daily200316 {

    static String s1 = "aabcccccaaa";
    static String s2 = "abbccd";

    public static void main(String[] args) {
        System.out.println(solution1(s1));
        System.out.println(solution1(s2));
        System.out.println(bestSolution(s1));
        System.out.println(bestSolution(s2));
    }

    static String solution1(String S) {
        int count = 0;
        char tmp = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (count == 0) {
                sb.append(c);
                tmp = c;
                count++;
            } else {
                if (c == tmp) {
                    count++;
                } else {
                    sb.append(count).append(c);
                    tmp = c;
                    count = 1;
                }
            }
        }
        sb.append(count);
        return sb.toString().length() < S.length() ? sb.toString() : S;
    }

    static String bestSolution(String S) {
        int l = 0;
        int r = 1;
        int count = 1;
        StringBuilder sb = new StringBuilder();
        while (r < S.length()) {
            if (S.charAt(l) == S.charAt(r)) {
                r++;
                count++;
            } else {
                sb.append(S.charAt(l)).append(count);
                l = r;
                r++;
                count = 1;
            }
        }
        sb.append(S.charAt(l)).append(count);
        return sb.toString().length() < S.length() ? sb.toString() : S;
    }
}
