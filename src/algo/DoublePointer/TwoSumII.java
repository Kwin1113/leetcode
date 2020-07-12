package algo.DoublePointer;

/**
 * 1. 有序数组的 Two Sum
 * 167. Two Sum II - Input array is sorted (Easy)
 * <p>
 * 给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class TwoSumII {

    public static void main(String[] args) {
//        solution1();
        bestSolution();
    }

    static int[] numbers = new int[]{2, 7, 11, 15};
    static int target = 9;

    /**
     * 时间复杂度为O(N^2)
     */
    static void solution1() {
        for (int i = 0; i < numbers.length; i++) {
            int j = i + 1;
            int index1 = numbers[i];
            int index2 = numbers[j];

            while (j < numbers.length && index1 + index2 != target) {
                j++;
            }

            if (index1 + index2 == target) {
                System.out.println("index1 = " + (i + 1) + ", index2 = " + (j + 1));
                break;
            }
        }
    }

    /**
     * 时间复杂度为O(N)，空间复杂度为O(1)
     */
    static void bestSolution() {
        int index1 = 0;
        int index2 = numbers.length - 1;

        int sum = 0;
        while (index1 < index2) {
            sum = numbers[index1] + numbers[index2];
            if (sum == target) {
                break;
            } else if (sum < target) {
                ++index1;
            } else {
                --index2;
            }
        }

        if (sum == target) {
            System.out.println("index1 = " + (index1 + 1) + ", index2 = " + (index2 + 1));
        }
    }
}
