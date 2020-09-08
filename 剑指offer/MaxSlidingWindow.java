package edu.fzu.lc2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaxSlidingWindow {

    /**
     * 滑动窗口内的最大值
     * @param nums
     * @param k
     * @return 每k个滑动窗口里的最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++)
        {
            if (!q.isEmpty() && i - k + 1 > q.getFirst()) q.pollFirst();
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) q.pollLast();
            q.add(i);
            if (i >= k - 1) res.add(nums[q.getFirst()]);
        }
        int[] finalRes = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            finalRes[i] = res.get(i);
        return finalRes;
    }
}
