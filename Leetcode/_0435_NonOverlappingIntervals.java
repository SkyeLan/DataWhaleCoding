package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make
 * the rest of the intervals non-overlapping.
 * <p>
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 */
public class _0435_NonOverlappingIntervals {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return 0;
        }

        // 对数组排序，从小到大排序，首先比较start，再比较end
        // 排序前 [ [1,2], [2,3], [3,4], [1,3] ]
        // 排序后 [ [1,2], [1,3]，[2,3], [3,4] ]
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });
        int[] dp = new int[intervals.length];
        dp[0] = 1;
        for (int i = 1; i < intervals.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++)
                if (intervals[i].start >= intervals[j].end)
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
        }
        int res = 0;
        for (int i1 : dp)
            res = Math.max(res, i1);
        return intervals.length - res;
    }

    public static void main(String[] args) {
        Interval a = new _0435_NonOverlappingIntervals().new Interval(1, 2);
        Interval b = new _0435_NonOverlappingIntervals().new Interval(2, 3);
        Interval c = new _0435_NonOverlappingIntervals().new Interval(3, 4);
        Interval d = new _0435_NonOverlappingIntervals().new Interval(1, 3);
        Interval[] intervals = new Interval[]{a, b, c, d};
        System.out.println(new _0435_NonOverlappingIntervals().eraseOverlapIntervals(intervals));
    }
}
