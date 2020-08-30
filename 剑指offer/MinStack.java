package edu.fzu.lc;

import java.util.Stack;

/**
 * @author johnrambo
 * @create 2020-08-30 10:09
 */
public class MinStack {

    Stack<Integer> minStack;
    //辅助栈:保持该栈一直是单调递减的,即栈顶就是最小的
    Stack<Integer> assistStack;

    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack<>();
        assistStack = new Stack<>();
    }

    public void push(int x) {
        minStack.push(x);
        //当辅助栈栈顶元素大于等于待添加的元素时,待添加的元素要入辅助栈,
        //这里一定要有等于,因为可能出现重复元素
        if (assistStack.isEmpty() || assistStack.peek() >= x)
            assistStack.push(x);
    }

    public void pop() {
        Integer x = minStack.pop();
        //只有出栈的元素和辅助栈栈顶元素相同时,辅助栈才出栈
        if (x.equals(assistStack.peek()))
            assistStack.pop();
    }

    public int top() {
        return minStack.peek();
    }

    public int min() {
        return assistStack.peek();
    }
}