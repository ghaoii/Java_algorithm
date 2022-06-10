package offer;

import java.util.HashMap;
import java.util.Map;

public class Num6_Fibonacci {
    //动态规划
    public int Fibonacci(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //借助Map解决的递归
//    Map<Integer, Integer> map = new HashMap<>();
//    public int Fibonacci(int n) {
//        if(n == 0){
//            return 0;
//        }
//        if(n <= 2){
//            return 1;
//        }
//        int ppre = 0;
//        if(map.containsKey( n - 2)){
//            ppre = map.get(n - 2);
//        }else{
//            ppre = Fibonacci(n - 2);
//            map.put(n - 2, ppre);
//        }
//        int pre = 0;
//        if(map.containsKey(n - 1)){
//            pre = map.get(n - 1);
//        }else{
//            pre = Fibonacci(n - 1);
//            map.put(n - 1, pre);
//        }
//
//        return pre + ppre;
//    }


    //递归解决
//    public int Fibonacci(int n) {
//        if(n == 0){
//            return 0;
//        }
//        if(n <= 2){
//            return 1;
//        }
//        return Fibonacci(n - 1) + Fibonacci(n - 2);
//    }


    //迭代解决
//    public int Fibonacci(int n) {
//        if(n == 0){
//            return 0;
//        }
//        int fir = 1;
//        int sec = 1;
//        for (int i = 3; i <= n; i++) {
//            int tmp = fir + sec;
//            fir = sec;
//            sec = tmp;
//        }
//        return sec;
//    }
}
