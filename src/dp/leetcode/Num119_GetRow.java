package dp.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Num119_GetRow {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> row = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> col = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    col.add(1);
                } else if (i == j) {
                    col.add(1);
                } else {
                    col.add(row.get(i - 1).get(j - 1) + row.get(i - 1).get(j));
                }
            }
            row.add(col);
        }
        return row.get(rowIndex);
    }
}
