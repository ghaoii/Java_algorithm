package RealQuestion.nowcoder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//字符串压缩算法
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int count = 0;
            while(i < ch.length - 1 && ch[i] == ch[i + 1]) {
                count++;
                i++;
            }
            if(count != 0) {
                System.out.print(count);
            }
            System.out.print(ch[i]);
        }
    }
}

// 求表达式 f(n)结果末尾0的个数
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int count = 0;
//        int n = scanner.nextInt();
//        for (int i = 1; i <= n; i++) {
//            count += calNum(i) * (n - i + 1);
//        }
//        System.out.println(count);
//    }
//
//    private static int calNum(int i) {
//        int count = 0;
//        while(i > 0) {
//            if(i % 5 == 0) {
//                count++;
//                i /= 5;
//            }else {
//                break;
//            }
//        }
//        return count;
//    }
//}

//合并二叉树
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//}
//public class Main {
//    static Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        TreeNode[] root1 = new TreeNode[n];
//        TreeNode[] root2 = new TreeNode[m];
//        for (int i = 0; i < n; i++) {
//            root1[i] = new TreeNode();
//        }
//        for (int i = 0; i < m; i++) {
//            root2[i] = new TreeNode();
//        }
//        buildTree(root1, n);
//        buildTree(root2, m);
//
//        // 传入两棵树的跟结点
//        TreeNode root = merge(root1[0], root2[0]);
//
//        //层序遍历输出合并后的数
//        Deque<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while(!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            System.out.print(node.val + " ");
//            if(node.left != null) {
//                queue.offer(node.left);
//            }
//            if(node.right != null) {
//                queue.offer(node.right);
//            }
//        }
//    }
//
//    /**
//     * 传入两棵树的根节点，就能将这两棵树合并(合并到root1中)
//     * @param root1
//     * @param root2
//     */
//    private static TreeNode merge(TreeNode root1, TreeNode root2) {
//        // 只有当两棵树的根节点都存在，才进行值相加
//        if(root1 != null && root2 != null) {
//            root1.val += root2.val;
//            root1.left = merge(root1.left, root2.left);
//            root1.right = merge(root1.right, root2.right);
//            return root1;
//        }
//
//        return root1 != null ? root1 : root2;
//    }
//
//    private static void buildTree(TreeNode[] node, int n) {
//        for (int i = 0; i < n; i++) {
//            int left = scanner.nextInt();
//            int right = scanner.nextInt();
//            int val = scanner.nextInt();
//            node[i].val = val;
//            // 存在一个单位的偏移量
//            node[i].left = left == 0 ? null : node[left - 1];
//            node[i].right = right == 0 ? null : node[right - 1];
//        }
//    }
//}

// 硬币划分(动归、回溯)
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int[] coin = {1, 2, 5, 10};
//        while(scanner.hasNextInt()) {
//            int n = scanner.nextInt();
//            int[][] dp = new int[n + 1][5];
//            for (int i = 0; i <= 4; i++) {
//                dp[0][i] = 1;
//            }
//            for (int i = 1; i <= n; i++) {
//                for (int j = 1; j <= 4; j++) {
//                    dp[i][j] += dp[i][j - 1];
//                    if(i >= coin[j - 1]) {
//                        dp[i][j] += dp[i - coin[j - 1]][j];
//                    }
//                    dp[i][j] %= 1e9+7;
//                }
//            }
//            System.out.println(dp[n][4]);
//        }
//    }
//}

// 递增子序列：判断一个无序数组中是否存在长度为3的递增子序列。（不要求连续）（满足O(n)的时间复杂度和O(1)的空间复杂度。）
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        if(n < 3) {
//            System.out.println(false);
//            return;
//        }
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        int fir = arr[0];
//        int sec = Integer.MAX_VALUE;
//        // 12 7 36 9 5 20 和 12 7 36 9 5 8 和 12 7 36 9 5 12 8
//        // 理论上这三个的答案分别是 T F T
//        // 但这个算法的输出结果是 F F F
//        // 但是竟然能通过测试用例？？？？
//        for (int i = 1; i < n; i++) {
//            if(arr[i] < fir) {
//                fir = arr[i];
//                sec = Integer.MAX_VALUE;
//            }else if(arr[i] > fir && arr[i] < sec) {
//                sec = arr[i];
//            }else if(arr[i] > sec){
//                System.out.println("true");
//                return;
//            }
//        }
//        System.out.println("false");
//    }
//}


// k个一组翻转链表
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int time = 0;
//        while(scanner.hasNextLine()) {
//            if(time > 0) {
//                scanner.nextLine();// 拿取换行符
//            }
//            String str = scanner.nextLine();
//            String[] val = str.split(" ");
//            int len = val.length - 1;
//            int n = scanner.nextInt();
//            int start = 0;
//            while (start < len) {
//                int left = start;
//                int right = left + n - 1;
//                if(right >= len) {
//                    break;
//                }
//                while(left < right) {
//                    String temp = val[left];
//                    val[left] = val[right];
//                    val[right] = temp;
//                    left++;
//                    right--;
//                }
//                start += n;
//            }
//            for (int j = 0; j < len; j++) {
//                System.out.print(val[j]);
//                if(j != len - 1) {
//                    System.out.print("->");
//                }
//            }
//            System.out.println();
//            time++;
//        }
//    }
//}


// 一年中的第几天
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextLine()) {
//            String str = scanner.nextLine();
//            String[] date = str.split("-");
//            int year = strToInt(date[0]);
//            int month = strToInt(date[1]);
//            int day = strToInt(date[2]);
//            int days = 0;
//            int[] eachMon = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//            // 写法二
//            for (int i = 1; i < month; i++) {
//                days += eachMon[i];
//            }
//            days += day;
//            if(month > 2) {
//                if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
//                    days += 29;
//                }else {
//                    days += 28;
//                }
//            }
//
//            // 写法一
////            for (int i = 0; i <= month; i++) {
////                if(i != month) {
////                    days += eachMon[i];
////                }
////                if(i != month && i == 2) {
////                    if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
////                        days += 29;
////                    }else {
////                        days += 28;
////                    }
////                }
////                if(i == month) {
////                    days += day;
////                }
////            }
//            System.out.println(days);
//        }
//    }
//    private static int strToInt(String str) {
//        int num = 0;
//        for (int i = 0; i < str.length(); i++) {
//            num = num * 10 + str.charAt(i) - '0';
//        }
//        return num;
//    }
//}

// 复数相乘
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()) {
//            String str1 = scanner.nextLine();
//            String str2 = scanner.nextLine();
//            // split参数并不是String，而是regex即正则表达式
//            // +号在正则表达式中有特殊意义（表示一次或多次）
//            // 所以“+”就是“”出现一次或多次，“”没有意义也不是空格“ ”，因此会报错
//            String[] s1 = str1.split("\\+");
//            String[] s2 = str2.split("\\+");
//            // 获取整数部分
//            String s1Fir = s1[0];
//            String s2Fir = s2[0];
//            String s1Sec = s1[1];
//            String s2Sec = s2[1];
//            // 把获取的字符串转化为整数
//            int s1F = strToInt(s1Fir);
//            int s2F = strToInt(s2Fir);
//            int s1S = strToInt(s1Sec);
//            int s2S = strToInt(s2Sec);
//
//            // 进行运算
//            System.out.println((s1F * s2F - s1S * s2S) + "+" + (s1F * s2S + s2F * s1S) + "i");
//        }
//    }
//
//    private static int strToInt(String str) {
//        int num = 0;
//        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//            if(ch >= '0' && ch <= '9') {
//                num = num * 10 + ch - '0';
//            }
//        }
//        if(str.contains("-")) {
//            num = -num;
//        }
//        return num;
//    }
//}
