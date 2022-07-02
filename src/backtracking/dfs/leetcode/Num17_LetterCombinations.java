package backtracking.dfs.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num17_LetterCombinations {
    private List<String> list = new ArrayList<>();

    private void dfs(char[] digits, Map<Integer, String> map, StringBuilder sb, int index) {
        if(index == digits.length) {
            if(index != 0)
                list.add(sb.toString());
            return;
        }
        String str = map.get(digits[index] - '0');
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            dfs(digits, map, sb.append(ch[i]), index + 1);
            sb.delete(index, sb.length());
        }
    }

    public List<String> letterCombinations(String digits) {
        String[] strSet = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Map<Integer, String> map = new HashMap<>();
        for (int i = 2; i <= 9; i++) {
            map.put(i, strSet[i]);
        }
        StringBuilder sb = new StringBuilder();
        dfs(digits.toCharArray(), map, sb, 0);
        return list;
    }
}
