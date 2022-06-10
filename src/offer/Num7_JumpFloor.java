package offer;

public class Num7_JumpFloor {
    //优化
    public int jumpFloor(int target) {
        int fir = 1;
        int sec = 1;
        for (int i = 2; i <= target; i++) {
            int sum = fir + sec;
            fir = sec;
            sec = sum;
        }
        return sec;
    }

    //动态规划
//    public int jumpFloor(int target) {
//        // f(n) = f(n - 1) + f(n - 2)
//        //f(0) = 1,f(1) = 1, f(2) = 2
//        int[] arr = new int[target + 1];
//        arr[0] = 1;
//        arr[1] = 1;
//        for (int i = 2; i <= target ; i++) {
//            arr[i] = arr[i - 1] + arr[i - 2];
//        }
//        return arr[target];
//    }
}
