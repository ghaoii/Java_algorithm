package dp.leetcode;

public class Num518_Change {
    // 状态压缩
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= amount; j++) {
                if(j >= coins[i]) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }

//    public int change(int amount, int[] coins) {
//        int len = coins.length;
//        int[][] dp = new int[len + 1][amount + 1];
//        for (int i = 0; i <= len; i++) {
//            dp[i][0] = 1;
//        }
//        for (int i = 1; i <= len; i++) {
//            for (int j = 1; j <= amount; j++) {
//                if(j < coins[i - 1]) {
//                    dp[i][j] = dp[i - 1][j];
//                }else {
//                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
//                }
//            }
//        }
//        return dp[len][amount];
//    }

    public static void main(String[] args) {
        Num518_Change test = new Num518_Change();
        int amount = 5;
        int[] coins = {1, 2, 5};
        int ret = test.change(amount, coins);
        System.out.println(ret);
    }
}
