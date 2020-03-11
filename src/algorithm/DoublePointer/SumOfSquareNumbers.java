package algorithm.DoublePointer;

/**
 * 2. 两数平方和
 * 633. Sum of Square Numbers (Easy)
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c。
 *
 * 示例1:
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *  
 * 示例2:
 * 输入: 3
 * 输出: False
 *
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 */
public class SumOfSquareNumbers {

    public static void main(String[] args) {
        int[] answer = bestSolution(falseNumber);
        if (answer != null) {
            System.out.println(String.format("a = %s, b = %s", answer[0], answer[1]));
        }
    }

    static int trueNumber = 5;
    static int falseNumber = 3;

    static void solution1() {

    }

    static int[] bestSolution(int number) {
        int i = 0;
        int j = (int) Math.sqrt(number);

        while (i <= j) {
            int sum = i * i + j * j;
            if (sum == number) {
                return new int[]{i, j};
            } else if (sum < number) {
                i++;
            } else {
                j++;
            }
        }

        return null;
    }
}
