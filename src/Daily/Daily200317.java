package Daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kwin <969263948@qq.com>
 * @since 2020/3/17 10:25
 * <p>
 * 1160. 拼写单词
 * <p>
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * <p>
 * 示例 1：
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * <p>
 * 示例 2：
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 *  
 * 提示：
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 **/
public class Daily200317 {

    static String[] words1 = new String[]{"cat", "bt", "hat", "tree"};
    static String chars1 = "atach";

    static String[] words2 = new String[]{"hello", "world", "leetcode"};
    static String chars2 = "welldownhoneyr";

    static String[] words3 = new String[]{"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin", "ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb", "ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl", "boygirdlggnh", "xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx", "nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop", "hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx", "juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr", "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo", "oxgaskztzroxuntiwlfyufddl", "tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp", "qnagrpfzlyrouolqquytwnwnsqnmuzphne", "eeilfdaookieawrrbvtnqfzcricvhpiv", "sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz", "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue", "hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv", "cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo", "teyygdmmyadppuopvqdodaczob", "qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs", "qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"};
    static String chars3 = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";

    public static void main(String[] args) {
        System.out.println(solution1(words1, chars1));
        System.out.println(solution1(words2, chars2));
        System.out.println(solution1(words3, chars3));
        System.out.println(solution2(words1, chars1));
        System.out.println(solution2(words2, chars2));
        System.out.println(solution2(words3, chars3));
        System.out.println(bestSolution(words1, chars1));
        System.out.println(bestSolution(words2, chars2));
        System.out.println(bestSolution(words3, chars3));
    }

    static int solution1(String[] words, String chars) {
        int res = 0;
        for (String word : words) {
            int[] seq = new int[word.length()];
            for (int i = 0; i < chars.length(); i++) {
                char c = chars.charAt(i);
                for (int j = 0; j < word.length(); j++) {
                    if (c == word.charAt(j) && seq[j] != 1) {
                        seq[j] = 1;
                        break;
                    }
                }
            }
            if (Arrays.stream(seq).sum() == word.length()) {
                res += seq.length;
            }
        }
        return res;
    }

    static int solution2(String[] words, String chars) {
        int res = 0;
        Map<Character, Integer> cSeq = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            Integer seq = cSeq.getOrDefault(c, 0);
            cSeq.put(c, ++seq);
        }
        for (String word : words) {
            Map<Character, Integer> wSeq = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Integer seq = wSeq.getOrDefault(c, 0);
                wSeq.put(c, ++seq);
            }
            boolean flag = true;
            for (Map.Entry<Character, Integer> entry : wSeq.entrySet()) {
                Integer count = cSeq.get(entry.getKey());
                if (count == null || count < entry.getValue()) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res += word.length();
            }
        }
        return res;
    }

    static int bestSolution(String[] words, String chars) {
        int res = 0;
        int[] count = count(chars);
        for (String word : words) {
            int[] wCount = count(word);
            if (contains(count, wCount)) {
                res += word.length();
            }
        }
        return res;
    }

    static boolean contains(int[] count, int wCount[]) {
        for (int i = 0; i < wCount.length; i++) {
            if (wCount[i] > count[i]) {
                return false;
            }
        }
        return true;
    }

    static int[] count(String word) {
        int[] count = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            count[c - 'a']++;
        }
        return count;
    }

}
