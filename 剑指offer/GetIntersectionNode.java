package edu.fzu.lc2;

/**
 * @author johnrambo
 * @create 2020-09-02 20:53
 */
public class GetIntersectionNode {

    /**
     * 两个链表的第一个公共节点
     * 思路:首先利用链表长度差将两个链表对齐开始遍历
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        int x = 0, y = 0;
        while (A != null)
        {
            x++;
            A = A.next;
        }
        while (B != null)
        {
            y++;
            B = B.next;
        }
        boolean flag = x - y > 0? true :false;
        int diff = Math.abs(x - y);
        A = headA;
        B = headB;
        if (flag)
        {
            while ((diff--) != 0) A = A.next;
        }
        else
        {
            while ((diff--) != 0) B = B.next;
        }

        while (A != B)
        {
            A = A.next;
            B = B.next;
        }
        return A;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
