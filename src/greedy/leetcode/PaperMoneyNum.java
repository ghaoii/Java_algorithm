package greedy.leetcode;

import java.util.Arrays;

public class PaperMoneyNum {
    public static int maxNum(int[][] money, int k) {
        int count = 0;
        for (int i = money.length - 1; i >= 0; i--) {
            int c = k / money[i][0];
            c = Math.min(c, money[i][1]);
            k -= c * money[i][0];
            count += c;
        }
        if(k > 0) {
            return -1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] money = {{1, 10}, {2, 5}, {5, 5}, {10, 1}, {20, 9}, {50, 3}, {100, 20}};
        System.out.println(maxNum(money, 248));// 7
    }
}
