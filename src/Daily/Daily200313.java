package Daily;

import java.util.Arrays;

/**
 * @author Kwin
 * @since 2020/3/13 22:05
 *
 * 169. 多数元素
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class Daily200313 {
    static int[] array1 = new int[]{3, 2, 3};
    static int[] array2 = new int[]{2, 2, 1, 1, 1, 2, 2};

    public static void main(String[] args) {
        System.out.println(solution1(array2));
    }

    static int solution1(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int result = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result = y = nums[i];
                x++;
                continue;
            }
            if (nums[i] == y) {
                x++;
                if (x > count) {
                    result = nums[i];
                    count = Math.max(x, count);
                    if (count > nums.length / 2) {
                        break;
                    }
                }
            } else {
                y = nums[i];
                x = 1;
            }
        }
        return result;
    }

    static int solution2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    static int bestSolution(int[] nums) {
        int count = 0;
        int x = nums[0];
        for (int num : nums) {
            if (count ==0) {
                x = num;
            }
            count += (num == x) ? 1 : -1;
        }
        return x;
    }
}
