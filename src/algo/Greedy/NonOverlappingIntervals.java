package algo.Greedy;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 2. 不重叠的区间个数
 * 435. Non-overlapping Intervals (Medium)
 * <p>
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * <p>
 * 示例 1:
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 * <p>
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * <p>
 * 示例 2:
 * 输入: [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * <p>
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * <p>
 * 示例 3:
 * 输入: [ [1,2], [2,3] ]
 * 输出: 0
 * <p>
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
public class NonOverlappingIntervals {

    public static void main(String[] args) {
//        dynamicProgramming1(intervals1);
//        bestSolution1(intervals1);
//        bestSolution2(intervals1);
        dynamicProgramming2(null);
    }

    static Interval[] intervals1 = new Interval[]{new Interval(1, 2), new Interval(2, 3), new Interval(3, 4), new Interval(1, 3)};
    static Interval[] intervals2 = new Interval[]{new Interval(1, 2), new Interval(1, 2), new Interval(1, 2)};
    static Interval[] intervals3 = new Interval[]{new Interval(1, 2), new Interval(2, 3)};

    static void solution1() {

    }

    /**
     * 起点排序的贪心算法
     */
    static void dynamicProgramming1(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(Interval::getStart));

        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            for (int j = i - 1; j >=0; j--) {
                if (isOverlapping(intervals[j], intervals[i])) {
                    continue;
                }
                count++;
            }
        }

        System.out.println(intervals.length - count);
    }

    /**
     * 终点排序的贪心算法
     */
    static void dynamicProgramming2(Interval[] intervals) {
        InputStream inputStream = null;
        byte[] bytes = new byte[10];
        try {
            int read = inputStream.read(bytes);
            System.out.println(read);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            int read = inputStream.read();
            System.out.println(read);
        } catch (Exception e) {

        }
    }

    static boolean isOverlapping(Interval pre, Interval cur) {
        return pre.end > cur.start;
    }

    /**
     * 起点排序的贪心算法
     */
    static void bestSolution1(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(Interval::getStart));

        int prev = 0;
        int cur = prev + 1;
        int count = 0;
        while (cur < intervals.length) {
            if (intervals[prev].end <= intervals[cur].start) {
                prev++;
                cur++;
            } else {
                if (intervals[prev].end >= intervals[cur].end) {
                    prev = cur;
                }
                cur++;
                count++;
            }
        }

        System.out.println(count);
    }

    /**
     * 终点排序的贪心算法
     */
    static void bestSolution2(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(Interval::getEnd));

        int prev = 0;
        int cur = 1;
        int count = 0;
        while (cur < intervals.length) {
            if (intervals[prev].end <= intervals[cur].start) {
                prev++;
                cur++;
            } else {
                cur++;
                count++;
            }
        }

        System.out.println(count);
    }

    static class Interval {
        public int start;
        public int end;

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
