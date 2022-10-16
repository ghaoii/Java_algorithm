package ds;

public class Num25_ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        // a保存了每组链表的旧头结点
        ListNode a = head;
        // prev保存了上一组链表的新尾结点
        ListNode dummyHead = new ListNode();
        ListNode prev = dummyHead;
        while(a != null) {
            ListNode b = a;
            int i = 0;
            while(i < k && b != null) {
                b = b.next;
                i++;
            }
            if(i == k) {
                ListNode newHead = reverse(a, b);
                a.next = b;
                prev.next = newHead;
            }
            prev = a;
            a = b;
        }
        return dummyHead.next;
    }

    // 反转从a到b(开区间)的链表，并返回反转后的头结点
    private ListNode reverse(ListNode a, ListNode b) {
        ListNode prev = null;
        while(a != b) {
            ListNode next = a.next;
            a.next = prev;
            prev = a;
            a = next;
        }
        return prev;
    }
}
