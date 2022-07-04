package backtracking.dfs.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Num1079_NumTilePossibilities {
    public int numTilePossibilities(String tiles) {
        char[] ch = tiles.toCharArray();
        StringBuilder sb = new StringBuilder();
        int[] book = new int[tiles.length()];
        Set<String> set = new HashSet<>();
        dfs(ch, book, set, sb);
        return set.size();
    }

    private void dfs(char[] tiles, int[] book, Set<String> set, StringBuilder sb) {
        if(sb.length() != 0) {
            set.add(sb.toString());
        }
        for (int i = 0; i < tiles.length; i++) {
            if(book[i] == 0) {
                book[i] = 1;
                dfs(tiles, book, set, sb.append(tiles[i]));
                sb.deleteCharAt(sb.length() - 1);
                book[i] = 0;
            }
        }
    }
}
