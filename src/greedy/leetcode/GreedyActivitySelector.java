package greedy.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyActivitySelector {
    public static int greedyActivitySelector(int[][] act) {
        int finishTime = act[0][1];
        int count = 1;
        for (int i = 1; i < act.length; i++) {
            // 找到下一个活动开始时间不小于当前活动的结束时间
            if(act[i][0] >= finishTime) {
                // 如果找到了，就让计数器加1，并更新活动结束时间
                count++;
                finishTime = act[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] act = new int[n][2];
        for (int i = 0; i < n; i++) {
            act[i][0] = scanner.nextInt();
            act[i][1] = scanner.nextInt();
        }
        Arrays.sort(act, (o1, o2) -> o1[1] - o2[1]);
        System.out.println(greedyActivitySelector(act));
    }
}
