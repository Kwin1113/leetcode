package algo;

/**
 * @author Kwin
 * @since 2020/7/12 10:40
 * <p>
 * 66. 加一
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {
    static int[] digits1 = new int[]{1, 2, 3};
    static int[] digits2 = new int[]{4, 3, 2, 1};

    public static void main(String[] args) {
        System.out.println(plusOne(digits1));
        System.out.println(plusOne(digits2));
    }


    static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[]{1};
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }

        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
