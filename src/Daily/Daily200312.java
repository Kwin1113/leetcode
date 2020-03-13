package Daily;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Kwin
 * @since 2020/3/12 22:37
 * <p>
 * 1071. 字符串的最大公因子
 * <p>
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * <p>
 * 示例 1：
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * <p>
 * 示例 2：
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * <p>
 * 示例 3：
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 * <p>
 * 提示：
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 */
public class Daily200312 {

    public static void main(String[] args) {
//        System.out.println(solution1("ABCABC", "ABC"));
//        System.out.println(solution1("ABABAB", "ABAB"));
//        System.out.println(solution1("LEET", "CODE"));
//        System.out.println(solution1("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
        System.out.println(solution1("NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM", "NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM"));
//        String a = "NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM";
//        System.out.println(a.substring(15, 20));
    }

    static String solution1(String str1, String str2) {
        String str = str1.length() <= str2.length() ? str1 : str2;
        String tmp = str1.length() <= str2.length() ? str2 : str1;
        Queue<String> dir = new LinkedBlockingQueue<>(str.length());
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
//        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
//            sb1.append(str.charAt(i));
//            sb2.append(str.charAt(j));
//            if (sb1.toString().equals(sb2.reverse().toString())) {
//                dir.add(sb1.toString());
//            }
//            sb2.reverse();
//        }
        LABEL1:
        for (int i = 1; i < str.length(); i++) {
            String substring = str.substring(0, i);
            if (str.length() % substring.length() != 0) {
                continue;
            }
            for (int j = 0; j < str.length() / substring.length(); j++) {
                int beginIndex = j * substring.length();
                int endIndex = (j + 1) * substring.length();
                if (!str.substring(beginIndex, endIndex).equals(substring)) {
                    continue LABEL1;
                }
            }
            dir.add(substring);
        }
        dir.add(str);
        String result = "";
        LABEL2:
        while (dir.size() > 0) {
            String test = dir.poll();
            if (tmp.length() % test.length() != 0) {
                continue;
            }
            for (int i = 0; i < tmp.length() / test.length(); i++) {
                if (!tmp.substring(i * test.length(), (i + 1) * test.length()-1).equals(test)) {
                    continue LABEL2;
                }
            }
            result = test;
        }
        return result;
    }

    static String bestSolution(String str1, String str2) {
        return null;
    }

    public String gcdOfStrings(String str1, String str2) {
        int len1=(int)str1.length();
        int len2=(int)str2.length();
        for(int i=Math.min(len1, len2);i>=1;--i){
            if(len1 % i==0 && len2 % i==0){
                String X=str1.substring(0,i);
                if(check(X, str1) && check(X, str2)) return X;
            }
        }
        return "";
    }
    private boolean check(String t, String s){
        int lenx = s.length() / t.length();
        String ans = "";
        for (int i = 1; i <= lenx; ++i){
            ans = ans + t;
        }
        //System.out.println(ans);
        // System.out.println(s);
        return ans.equals(s);
    }
}
