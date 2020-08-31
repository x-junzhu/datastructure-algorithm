package edu.fzu.lc;

import java.util.HashMap;

/**
 * @author johnrambo
 * @create 2020-08-31 8:46
 */
public class RandomList {

    public Node copyRandomList(Node head) {
        Node cur = new Node(head.val);
        Node newHead = cur;
        while (head.next != null)
        {
            cur.next = new Node(head.next.val);
            if (head.random != null)
            {
                Node tmp = newHead;
                while (tmp != null)
                {
                    if (tmp.val == head.random.val)
                        break;
                    tmp = tmp.next;
                }
                if (tmp != null)
                    cur.random = tmp;
                else
                {
                    cur.random = new Node(head.random.val);
                }
            }
            head = head.next;
            cur = cur.next;
        }
        return newHead;
    }


    public Node copyList(Node head){
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null)
        {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null)
        {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

}

class Node{
    int val;
    Node next;
    Node random;

    public Node(int val)
    {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
