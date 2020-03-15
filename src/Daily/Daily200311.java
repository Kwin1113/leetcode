package Daily;

import java.util.Arrays;

/**
 * @author Kwin
 * @since 2020/3/11 22:46
 *
 * 1013. 将数组分成和相等的三个部分
 *
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 *
 * 示例 1：
 * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 *
 * 示例 2：
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 *
 * 示例 3：
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *
 * 提示：
 * 3 <= A.length <= 50000
 * -10^4 <= A[i] <= 10^4
 */
public class Daily200311 {

    static int[] a1 = new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
    static int[] a2 = new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1};
    static int[] a3 = new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4};

    public static void main(String[] args) {

    }

    static boolean solution1(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        int sum = Arrays.stream(A).sum();
        if (sum % 3 != 0) {
            return false;
        }
        int i = 0, j = A.length - 1;
        int sumi = A[i], sumj = A[j];
        while (i + 1 < j) {
            if (sumi == sum / 3 && sumj == sum / 3) {
                return true;
            }
            if (sumi != sum / 3) {
                sumi += A[++i];
            }
            if (sumj != sum / 3) {
                sumj += A[--j];
            }
        }
        return false;
    }

    static boolean solution2(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        int sum = Arrays.stream(A).sum();
        if (sum % 3 != 0) {
            return false;
        }
        int count = 0;
        int tmp = 0;
        for (int a : A) {
            tmp += a;
            if (tmp == sum / 3) {
                count++;
                tmp = 0;
            }
        }
        return count >= 3;
    }
}