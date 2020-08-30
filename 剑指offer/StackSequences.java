package edu.fzu.lc;

import java.util.Stack;

/**
 * @author johnrambo
 * @create 2020-08-30 11:17
 */
public class StackSequences {

    public static void main(String[] args) {
        StackSequences ss = new StackSequences();
        int[] push = {1,2,3,4,5};
        int[] pop = {4,3,5,1,2};
        boolean res = ss.validateStackSequences(push, pop);
        System.out.println(res);
    }

    /**
     * 判断栈的弹出与压入是否一致
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushed.length; i++)
        {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j])
            {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
