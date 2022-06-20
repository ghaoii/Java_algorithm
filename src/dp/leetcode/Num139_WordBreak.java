package dp.leetcode;

import java.util.List;

public class Num139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] canBreak = new boolean[len + 1];
        //初始化
        canBreak[0] = true;
        //状态转移方程:f(i) = f(1)...f(i-1) && [i+1, n]
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                // 注意字符串的截取是从[start, end)的，半闭半开区间
                if(canBreak[j] && wordDict.contains(s.substring(j, i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[len];
    }
}
