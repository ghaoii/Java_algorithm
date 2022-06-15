package dp.leetcode;

public class Num338_CountBits {
    public int[] countBits(int n) {
        int[] ret = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ret[i] = count(i);
        }
        return ret;
    }

    private int count(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
