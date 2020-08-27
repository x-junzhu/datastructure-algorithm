package edu.fzu.lc;

import java.util.Stack;

/**
 * @author johnrambo
 * @create 2020-08-27 9:13
 */
public class ReverseLinkedList {

    /**
     * 逆序打印单链表:
     * 使用一个辅助栈,先将链表元素依次压入栈栈,然后把栈中元素依次出栈放入数组中
     * @param head 待打印的单链表头
     * @return 逆序单链表的数组
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> res = new Stack<>();
        ListNode p = head;
        int linkedListSize = 0;
        while (p != null)
        {
            res.add(p.val);
            p = p.next;
            linkedListSize++;
        }

        int[] finalRes = new int[linkedListSize];
        for (int i = 0; i < finalRes.length; i++)
        {
            finalRes[i] = res.pop();
        }
        return finalRes;
    }

}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int x)
    {
        val = x;
    }
}
