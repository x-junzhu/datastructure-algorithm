package edu.fzu.lc;

/**
 * @author johnrambo
 * @create 2020-08-29 17:01
 */
public class MergeSortedLinkedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode head = new ListNode(-1);
        ListNode current = head;
        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                current.next = l1;
                l1 = l1.next;
                current = current.next;
            }
            else
            {
                current.next = l2;
                l2 = l2.next;
                current = current.next;
            }

        }

        while(l1 != null)
        {
            current.next = l1;
            l1 = l1.next;
            current = current.next;
        }

        while(l2 != null)
        {
            current.next = l2;
            l2 = l2.next;
            current = current.next;
        }
        return head.next;
    }

}
