package dp.leetcode;

public class Num1137_Tribonacci {
    public int tribonacci(int n) {
        if(n < 2) {
            return n;
        }
        if(n == 2) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        for (int i = 3; i <= n; i++) {
            int temp = a + b + c;
            a = b;
            b = c;
            c = temp;
        }
        return c;
    }
}
