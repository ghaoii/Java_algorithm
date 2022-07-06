package backtracking.bfs.leetcode;

import java.util.*;

public class Num127_LadderLength {
    // 使用Set集合
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 把线性表替换成查询效率更高的Set集合
        Set<String> set = new HashSet<>();
        for(String str : wordList) {
            set.add(str);
        }
        // 用于标记单词是否已经使用过
        Set<String> book = new HashSet<>();
        Deque<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                for (int j = 0; j < str.length(); j++) {
                    StringBuilder sb = new StringBuilder(str);
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        sb.setCharAt(j, ch);
                        String temp = sb.toString();
                        // 如果该单词不在词典中或已经使用过，则跳过
                        if(!set.contains(temp) || book.contains(temp)) {
                            continue;
                        }
                        // 如果该单词就是目标单词，则返回
                        if(temp.equals(endWord)) {
                            return count + 1;
                        }
                        // 如果存在于词典，没有使用过，且不是目标单词
                        queue.offer(temp);
                        book.add(temp);
                    }
                }
            }
            count++;
        }
        return 0;
    }
}

//public class Num127_LadderLength {
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Deque<String> queue = new LinkedList<>();
//        queue.offer(beginWord);
//        int len = wordList.size();
//
//        int[] book = new int[len];
//        int count = 1;// 记录层数
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                String str = queue.poll();
//                if(str.equals(endWord)) {
//                    return count;
//                }
//                for (int j = 0; j < len; j++) {
//                    String word = wordList.get(j);
//                    if(book[j] == 0 && checkWord(str, word)) {
//                        queue.offer(word);
//                        book[j] = 1;
//                    }
//                }
//            }
//            count++;
//        }
//        return 0;
//    }
//
//    private boolean checkWord(String a, String b) {
//        int count = 0;
//        if(Math.abs(a.length() - b.length()) > 1) {
//            return false;
//        }
//        int l = Math.min(a.length(), b.length());
//        for (int i = 0; i < l; i++) {
//            if(a.charAt(i) != b.charAt(i)) {
//                count++;
//                if(count == 2) {
//                    return false;
//                }
//            }
//        }
//        return a.length() == b.length() || count == 0;
//    }
//}
