package offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Num3_PrintListFromTailToHead {
    //链表逆序
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if(listNode == null){
            return ret;
        }
        ListNode prev = null;
        ListNode cur = listNode;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        while(prev != null){
            ret.add(prev.val);
            prev = prev.next;
        }
        return ret;
    }


    //递归解决问题，语义 - 传入链表的头结点，就能将链表逆序输入数组，并返回数组
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> ret = new ArrayList<>();
//        if(listNode == null){
//            return ret;
//        }
//        ret = printListFromTailToHead(listNode.next);
//        ret.add(listNode.val);
//        return ret;
//    }


    //先遍历链表，把链表里的值保存到数组中，然后逆序数组
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> ret = new ArrayList<>();
//        if(listNode == null){
//            return ret;
//        }
//        for(ListNode x = listNode; x != null; x = x.next){
//            ret.add(x.val);
//        }
//        //逆序数组
//        int left = 0;
//        int right = ret.size() - 1;
//        while(left < right){
//            int tmp = ret.get(left);
//            ret.set(left, ret.get(right));
//            ret.set(right, tmp);
//            left++;
//            right--;
//        }
//        return ret;
//    }

    //借助栈解决问题，但是空间复杂度比较高
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> ret = new ArrayList<>();
//        if(listNode == null){
//            return ret;
//        }
//        Deque<Integer> stack = new LinkedList<>();
//        for (ListNode x = listNode; x != null ; x = x.next) {
//            stack.push(x.val);
//        }
//        while(!stack.isEmpty()){
//            ret.add(stack.pop());
//        }
//        return ret;
//    }
}
