package edu.fzu.lc;

/**
 * @author johnrambo
 * @create 2020-08-29 14:42
 */
public class SingleLinkedList {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode p = head;
        while(p.next != null)
        {
            //head就是第一个节点所以第一个节点要单独处理一下
            if(p.val == val) head = head.next;
            if(p.next.val == val)
            {
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
        return head;
    }

}

class Node{
    int val;
    ListNode next;
    public Node(int x)
    {
        this.val = x;
    }
}
