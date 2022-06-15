package dp.leetcode;

public class Num1025_DivisorGame {
    public boolean divisorGame(int n) {
        if(n < 2) {
            return false;
        }
        boolean[] win = new boolean[n + 1];
        win[1] = false;
        win[2] = true;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if(i % j == 0 && !win[i - j]) {
                    win[i] = true;
                    break;
                }
            }
        }
        return win[n];
    }
}
