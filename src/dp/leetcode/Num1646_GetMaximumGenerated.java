package dp.leetcode;

public class Num1646_GetMaximumGenerated {
    public int getMaximumGenerated(int n) {
        if(n < 2) {
            return n;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        int max = 0;
        for (int i = 2; i <= n; i++) {
            if(i % 2 == 0) {
                arr[i] = arr[i >> 1];
            }else {
                int temp = (i - 1) >> 1;
                arr[i] = arr[temp] + arr[temp + 1];
            }
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
