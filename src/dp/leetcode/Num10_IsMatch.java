package dp.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Num10_IsMatch {
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0, new HashMap<>());
    }

    private boolean helper(String s, String p, int i, int j, Map<String, Boolean> map) {
        if(j == p.length()) {
            return i == s.length();
        }
        if(i == s.length()) {
            if((p.length() - j) % 2 == 1) {
                return false;
            }
            for( ; j < p.length(); j += 2) {
                if(p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }

        String str = s.substring(0, i + 1) + ", " + p.substring(0, j + 1);
        if(map.containsKey(str)) {
            return map.get(str);
        }
        boolean flag = false;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if(j < p.length() - 1 && p.charAt(j + 1) == '*') {
                // 如果后面是'*', 可以匹配多次也可以不匹配
                flag =  helper(s, p, i + 1, j, map) || helper(s, p, i, j + 2, map);
            }else {
                // 如果不是'*', 那么只能一对一匹配
                flag =  helper(s, p, i + 1, j + 1, map);
            }
        }else {
            if(j < p.length() - 1 && p.charAt(j + 1) == '*') {
                // 这种情况只能不进行匹配
                flag =  helper(s, p, i, j + 2, map);
            }
        }
        map.put(str, flag);
        return flag;
    }
}

//public class Num10_IsMatch {
//    public boolean isMatch(String s, String p) {
//        return helper(s, p, 0, 0);
//    }
//
//    private boolean helper(String s, String p, int i, int j) {
//        if(j == p.length()) {
//            return i == s.length();
//        }
//        if(i == s.length()) {
//            if((p.length() - j) % 2 == 1) {
//                return false;
//            }
//            for(; j < p.length(); j += 2) {
//                if(p.charAt(j + 1) != '*') {
//                    return false;
//                }
//            }
//            return true;
//        }
//
//        if(j < p.length() - 1 && p.charAt(j + 1) == '*') {
//            if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
//                // 可以不进行匹配、匹配多次、匹配一次
//                return helper(s, p, i, j + 2) || helper(s, p , i + 1, j) || helper(s, p, i + 1, j + 2);
//            }else {
//                return helper(s, p, i + 1, j + 2);
//            }
//        }else {
//            if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
//                return helper(s, p, i + 1, j + 1);
//            }else {
//                return false;
//            }
//        }
//    }
//}
