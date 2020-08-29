package edu.fzu.lc;

/**
 * @author johnrambo
 * @create 2020-08-29 15:30
 */
public class KthNumber {

    /**
     * 链表中倒数第k个数
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        int count = 1;
        while(fast.next != null)
        {
            if(count >= k) slow = slow.next;
            fast = fast.next;
            count++;
        }
        head = slow;
        return head;
    }
}
