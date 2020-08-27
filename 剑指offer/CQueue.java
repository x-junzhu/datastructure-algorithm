package edu.fzu.lc;

import java.util.Stack;

/**ImplementQueueByStack
 * @author johnrambo
 * @create 2020-08-27 15:54
 */
public class CQueue {

    //stack1只作为插入元素的栈
    Stack<Integer> stack1;
    //stack2只作为可以删除元素的栈
    Stack<Integer> stack2;

    public CQueue()
    {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * 使用栈模拟往队列中插入元素
     * @param value 待插入的值
     */
    public void appendTail(int value)
    {
        stack1.push(value);
    }

    /**
     * 使用两个栈模拟从队列中删除元素
     * 1.若stack2不为空,则直接将栈顶元素弹出就是模拟队列的头元素
     * 2.若stack2为空,则将stack1中元素全部压入stack2中.也就是负负得正的原理,
     * 两次栈的先进后出最后就模拟出了队列的先进先出
     * @return "队列"的头元素
     */
    public int deleteHead()
    {
        if (stack2.isEmpty())
        {
            while (!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty())
        {
            return -1;
        }
        else
        {
            int value = stack2.pop();
            return value;
        }
    }
}
