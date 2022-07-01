package greedy.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class GetMinTime {
    public static int getMinTime(int[] taskTime, int m) {
        int n = taskTime.length;
        int[] machines = new int[m];
        Arrays.sort(taskTime);
        for (int i = n - 1; i >= 0; i--) {
            int finish = 0;
            int machineTime = machines[finish];
            // 找到最先结束任务的机器
            for (int j = 1; j < m; j++) {
                if(machines[j] < machineTime) {
                    finish = j;
                    machineTime = machines[j];
                }
            }
            machines[finish] += taskTime[i];
        }
        // 找出工作时间最长的机器
        int max = machines[0];
        for (int i = 1; i < m; i++) {
            max = Math.max(max, machines[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] taskTime = new int[n];
        for (int i = 0; i < n; i++) {
            taskTime[i] = scanner.nextInt();
        }
        System.out.println("最短时间为：" + getMinTime(taskTime, m));
    }
}
