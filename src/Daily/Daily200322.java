package Daily;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO
 * @author Kwin
 * @since 2020/3/22 21:33
 * <p>
 * 945. 使数组唯一的最小增量
 * <p>
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 * <p>
 * 示例 1:
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * <p>
 * 示例 2:
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * <p>
 * 提示：
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 */
public class Daily200322 {

    static int[] A0 = new int[]{3, 2, 2};
    static int[] A1 = new int[]{1, 2, 2};
    static int[] A2 = new int[]{3, 2, 1, 2, 1, 7};

    public static void main(String[] args) {
        System.out.println(solution1(A1));
        System.out.println(solution1(A2));
        System.out.println(solution2(A1));
        System.out.println(solution2(A2));
        System.out.println(solution3(A1));
        System.out.println(solution3(A2));
        System.out.println(bestSolution(A1));
        System.out.println(bestSolution(A2));
    }

    static int solution1(int[] A) {
        Set<Integer> dir = new HashSet<>();
        int count = 0;
        for (int value : A) {
            int num = value;
            while (dir.contains(num)) {
                count++;
                num++;
            }
            dir.add(num);
        }
        return count;
    }

    static int solution2(int[] A) {
        Queue<Integer> heap = Arrays.stream(A).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        int tmp = -1;
        int count = 0;
        while (heap.size() > 0) {
            Integer min = heap.poll();
            if (min == tmp) {
                heap.add(++min);
                count++;
            } else {
                tmp = min;
            }
        }
        return count;
    }

    static int solution3(int[] A) {
        int[] arr = new int[80000];
        for (int i : A) {
            arr[i]++;
        }
        int result = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1) {
                int num = arr[i] - 1;
                result -= num * i;
                count += num;
            } else if (arr[i] == 0 && count > 0) {
                count--;
                result += i;
            }
        }
        return result;
    }

    static int bestSolution(int[] A) {
        Arrays.sort(A);

        int count = 0, res = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                res -= A[i];
                count++;
            } else {
                int taken = Math.min(count, A[i] - A[i - 1] - 1);
                res += (taken / 2) * (A[i] + A[i - 1]);
                count -= taken;
            }
        }

        if (count > 0) {
            res += (2 * A[A.length - 1] + count + 1) * (count / 2);
        }

        return res;
    }
}
