package offer;

public class Num11_FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k < 0){
            return null;
        }
        ListNode fir = head;
        ListNode sec = head;
        int count = 0;
        while(fir != null){
            fir = fir.next;
            count++;
            if(count > k){
                sec = sec.next;
            }
        }
        if(count < k){
            return null;
        }
        return sec;
    }
}
