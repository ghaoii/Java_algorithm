package dp.leetcode;

import java.util.HashMap;
import java.util.Map;


public class Num887_SuperEggDrop {
    // dp(k,m): k个鸡蛋，丢m次最多能验证的楼层
    public int superEggDrop(int k, int n) {
        if(k == 1) {
            return n;
        }
        int[][] dp = new int[k + 1][n + 1];
        int m = 0;
        while(dp[k][m] < n) {
            m++;
            for (int i = 1; i <= k; i++) {
                dp[i][m] = dp[i - 1][m - 1] + dp[i][m - 1] + 1;
            }
        }
        return m;
    }

    // 备忘录+二分搜索优化
//    Map<String, Integer> map = new HashMap<>();
//    public int superEggDrop(int k, int n) {
//        if(k == 1) {
//            return n;
//        }
//        if(n == 0) {
//            return 0;
//        }
//        String str = k + ", " + n;
//        if(map.containsKey(str)) {
//            return map.get(str);
//        }
//        int ret = Integer.MAX_VALUE;
//        int low = 1;
//        int high = n;
//        while(low <= high) {
//            int mid = (low + high) / 2;
//            int broken = superEggDrop(k - 1, mid - 1);
//            int not_broken = superEggDrop(k, n - mid);
//            if(broken > not_broken) {
//                high = mid - 1;
//                ret = Math.min(ret, broken + 1);
//            }else {
//                low = mid + 1;
//                ret = Math.min(ret, not_broken + 1);
//            }
//        }
//        map.put(str, ret);
//        return ret;
//    }

    // dp，超时
//    public int superEggDrop(int k, int n) {
//        if(k == 1) {
//            return n;
//        }
//        int[][] dp = new int[k + 1][n + 1];
//        for (int i = 1; i <= n; i++) {
//            dp[1][i] = i;
//        }
//        for (int i = 1; i <= k; i++) {
//            dp[i][1] = 1;
//        }
//
//        for (int i = 2; i <= k; i++) {
//            for (int j = 2; j <= n; j++) {
//                int min = Integer.MAX_VALUE;
//                for (int l = 1; l <= j; l++) {
//                    min = Math.min(min, 1 + Math.max(dp[i - 1][l - 1], dp[i][j - l]));
//                }
//                dp[i][j] = min;
//            }
//        }
//        return dp[k][n];
//    }

    // 备忘录，超时
//    Map<String, Integer> map = new HashMap<>();
//    int ret = Integer.MAX_VALUE;
//    public int superEggDrop(int k, int n) {
//        if(k == 1) {
//            return n;
//        }
//        if(n == 0) {
//            return 0;
//        }
//        String str = k + ", " + n;
//        if(map.containsKey(str)) {
//            return map.get(str);
//        }
//        int ret = Integer.MAX_VALUE;
//        for (int i = 1; i <= n; i++) {
//            ret = Math.min(ret, 1 + Math.max(superEggDrop(k - 1, i - 1), superEggDrop(k, n - i)));
//        }
//        map.put(str, ret);
//        return ret;
//    }
}
