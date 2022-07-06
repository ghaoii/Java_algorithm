package backtracking.bfs.leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Num752_OpenLock {
    public int openLock(String[] deadEnds, String target) {
        // 把死亡数字存到Set集合中
        Set<String> dead = new HashSet<>();
        for(String str : deadEnds) {
            dead.add(str);
        }
        if(dead.contains("0000")) {
            return -1;
        }

        Deque<String> queue = new LinkedList<>();
        queue.offer("0000");

        // 创建一个Set集合用于包房已经搜索过的数字
        Set<String> book = new HashSet<>();
        book.add("0000");

        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if(str.equals(target)) {
                    return count;
                }
                for (int j = 0; j < 4; j++) {
                    StringBuilder sb1 = new StringBuilder(str);
                    StringBuilder sb2 = new StringBuilder(str);

                    char ch1 = str.charAt(j);
                    char ch2 = str.charAt(j);
                    // 向上转动
                    if(ch1 == '9') {
                        ch1 = '0';
                    }else {
                        ch1++;
                    }
                    // 向下转动
                    if(ch2 == '0') {
                        ch2 = '9';
                    }else {
                        ch2--;
                    }
                    sb1.setCharAt(j, ch1);
                    sb2.setCharAt(j, ch2);

                    String str1 = sb1.toString();
                    if(!dead.contains(str1) && !book.contains(str1)) {
                        queue.offer(str1);
                        book.add(str1);
                    }
                    String str2 = sb2.toString();
                    if(!dead.contains(str2) && !book.contains(str2)) {
                        queue.offer(str2);
                        book.add(str2);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
