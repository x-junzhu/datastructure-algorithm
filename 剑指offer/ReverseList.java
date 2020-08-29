package edu.fzu.lc;

import java.util.Stack;

/**
 * @author johnrambo
 * @create 2020-08-29 15:34
 */
public class ReverseList {

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null)
        {
            stack.push(p);
            p = p.next;
        }
        head = stack.pop();
        ListNode temp = head;
        while (!stack.isEmpty())
        {
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
        return head;

    }

}
