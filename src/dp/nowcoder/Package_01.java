package dp.nowcoder;

import java.util.*;

public class Package_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int n = scanner.nextInt();
        int[] volume = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            volume[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }

        int[][] dp = new int[n + 1][v + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= v; j++) {
                if(volume[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - volume[i - 1]] + value[i - 1]);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n][v]);
    }
}
