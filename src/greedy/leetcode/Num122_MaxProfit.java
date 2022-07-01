package greedy.leetcode;

public class Num122_MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i -1]) {
                // 如果今天的价格高于昨天的价格，我就买入前一天卖出今天
                // 现实生活中，这是不可能的
                count += prices[i] - prices[i -1];
            }
        }
        return count;
    }
}
