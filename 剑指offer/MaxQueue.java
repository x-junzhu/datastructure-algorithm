package edu.fzu.lc2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author johnrambo
 * @create 2020-09-02 9:39
 */
public class MaxQueue {

    //双端队列
    LinkedList<Integer> assist;
    LinkedList<Integer> queue;

    public MaxQueue() {
        assist = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        if (assist.isEmpty()) return -1;
        else return assist.getFirst();
    }

    /**
     * assist队列中保证队头始终是最大的,紧靠着队头的是次大的
     * @param value 待插入的值
     */
    public void push_back(int value) {
        queue.add(value);
        while (!assist.isEmpty() && assist.getLast() < value)
            assist.removeLast();
        assist.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        //如果出队的值是assist队列中的最大值则将assist队列里的队头元素出队
        if (queue.peek().equals(assist.getFirst()))
            assist.removeFirst();

        return queue.pollFirst();
    }
}
