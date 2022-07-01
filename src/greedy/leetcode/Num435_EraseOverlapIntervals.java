package greedy.leetcode;

import java.util.Arrays;

public class Num435_EraseOverlapIntervals {
    // 左边界排序
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int count = 1;
        int n = intervals.length;
        int start = intervals[n - 1][0];
        for (int i = n - 2; i >= 0; i--) {
            if(intervals[i][1] <= start) {
                count++;
                start = intervals[i][0];
            }
        }
        return n - count;
    }


    // 右边界排序
//    public int eraseOverlapIntervals(int[][] intervals) {
//        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
////        Arrays.sort(intervals, (o1, o2) -> {
////            if(o1[1] == o2[1]) {
////                return o1[0] - o2[0];
////            }else {
////                return o1[1] - o2[1];
////            }
////        });
//        int count = 1;
//        int lastEnd = intervals[0][1];
//        for (int i = 1; i < intervals.length; i++) {
//            // 找到留下的区间
//            if(intervals[i][0] >= lastEnd) {
//                count++;
//                lastEnd = intervals[i][1];
//            }
//        }
//        return intervals.length - count;
//    }
}
