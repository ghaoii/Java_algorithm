package greedy.leetcode;

public class Num1221_BalancedStringSplit {

    public int balancedStringSplit(String s) {
        int balance = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'L'){
                balance++;
            }else {
                balance--;
            }
            if(balance == 0) {
                count++;
            }
        }
        return count;
    }

//    public int balancedStringSplit(String s) {
//        int l = 0;
//        int r = 0;
//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if(s.charAt(i) == 'L'){
//                l++;
//            }else {
//                r++;
//            }
//            if(l == r) {
//                count++;
//            }
//        }
//        return count;
//    }
}
