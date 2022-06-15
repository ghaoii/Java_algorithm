package dp.leetcode;

public class Num121_MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int min = prices[0];//记录最小股价
        int max = 0;//记录最大利润
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }else if(prices[i] - min > max){
                max = prices[i] - min;
            }
        }
        return max;
    }
}
