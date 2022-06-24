package dp.leetcode;

public class Num91_NumDecodings {
    //优化
    public int numDecodings(String s) {
        int len = s.length();
        s = " " + s;
        char[] ch = s.toCharArray();
        int prev = 1;
        int pprev = 1;
        for (int i = 1; i <= len; i++) {
            int a = ch[i] - '0';
            int b = (ch[i - 1] - '0') * 10 + (ch[i] - '0');
            int temp = 0;
            if(a >= 1 && a <= 9) {
                temp = prev;
            }
            if(b >= 10 && b <= 26) {
                temp += pprev;
            }
            pprev = prev;
            prev = temp;
        }
        return prev;
    }

    //未优化
//    public int numDecodings(String s) {
//        int[] nums = new int[s.length() + 1];
//        char[] ch = s.toCharArray();
//        nums[0] = 1;
//        for (int i = 1; i <= s.length(); i++) {
//            if(ch[i - 1] >= '1' && ch[i - 1] <= '9') {
//                nums[i] = nums[i - 1];
//            }
//            if(i > 1) {
//                int k = (ch[i - 2] - '0') * 10 + (ch[i - 1] - '0');
//                if(k >= 10 && k <= 26) {
//                    nums[i] += nums[i - 2];
//                }
//            }
//        }
//        return nums[s.length()];
//    }
}
