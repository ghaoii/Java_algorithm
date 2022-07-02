package backtracking.dfs;

import java.util.Scanner;

public class DFSTest {
    public static void dfs(int[] book, int[] box, int index, int n) {
        if(index == n + 1) {
            // 所有的盒子里都放了牌
            for (int i = 1; i <= n; i++) {
                System.out.print(box[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(book[i] == 0) {
                book[i] = 1;
                box[index] = i;
                // 接着处理下一个盒子
                dfs(book, box, index + 1, n);
                // 处理之后进行回收
                book[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] book = new int[n + 1];
        int[] box = new int[n + 1];
        dfs(book, box, 1, n);
    }
}
