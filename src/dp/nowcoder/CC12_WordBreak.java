package dp.nowcoder;

import java.util.Set;

public class CC12_WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || dict.isEmpty()){
            return false;
        }
        boolean[] canBreak = new boolean[s.length() + 1];
        //初始化
        canBreak[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            //f(n) = j < i && f(j) && [j + 1, i]
            for (int j = 0; j < i; j++) {
                if(canBreak[j] && dict.contains(s.substring(j, i))){
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }
}
