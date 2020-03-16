package Daily;

/**
 * @author kwin <969263948@qq.com>
 * @since 2020/3/14 15:19
 * <p>
 * 300. 最长上升子序列
 * <p>
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * <p>
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n^2) 。
 * <p>
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 **/
public class Daily200314 {

    static int[] array1 = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
    static int[] array2 = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
    static int[] array3 = new int[]{11,12,13,14,15,6,7,8,101,18};

    public static void main(String[] args) {
        System.out.println(solution1(array1)); // 4
        System.out.println(solution1(array2)); // 6
        System.out.println(solution1(array3)); // 6
    }

    static int solution1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] seq = new int[nums.length];
        seq[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int value = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    value = Math.max(value, seq[j]);
                }
            }
            seq[i] = value + 1;
            max = Math.max(seq[i], max);
        }
        return max;
    }

    static int bestSolution(int[] nums) {
        return 0;
    }
}
