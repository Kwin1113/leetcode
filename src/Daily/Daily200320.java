package Daily;

import java.util.Arrays;

/**
 * @author kwin <969263948@qq.com>
 * @since 2020/3/20 11:44
 *
 * 面试题40. 最小的k个数
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 **/
public class Daily200320 {

    static int[] arr1 = new int[]{3, 2, 1};
    static int k1 = 2;

    static int[] arr2 = new int[]{0, 1, 2, 1};
    static int k2 = 1;

    public static void main(String[] args) {
//        int[] ints = solution1(arr1, k1);
        int[] ints = solution1(arr2, k2);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    static int[] solution1(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];
        System.arraycopy(arr, 0, result, 0, k);
        return result;
    }
}
