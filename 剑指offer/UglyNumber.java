package edu.fzu.lc2;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author johnrambo
 * @create 2020-09-01 18:25
 */
public class UglyNumber {

    int count = 2;

    public static void main(String[] args) {
        UglyNumber un = new UglyNumber();
        int ug = un.nthUglyNumber(7);
        System.out.println(ug);
    }

    /**
     * 找出第n个丑数
     * 时间复杂度: O(n*n)
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] nums = {2, 3, 5};
        int uglyNum = 1;
        for (int i = 1; i < n;)
        {
            int k = count;
            while (k != 1)
            {
                for (int j = 0; j < nums.length; j++)
                {
                    while (k % nums[j] == 0)
                        k /= nums[j];
                }
                if (k == 1) {
                    uglyNum = count;
                    i++;
                }
                else break;
            }
            count++;
        }
        return uglyNum;
    }

    /**
     * 堆优化版
     * 时间复杂度O(n * log n)
     * @param n
     * @return
     */
    public int nthUglyNumber1(int n){
        int[] nums = {2, 3, 5};
        Queue<Long> q = new PriorityQueue<>();
        q.add(1L);
        int count = 0;
        while (!q.isEmpty())
        {
            long cur = q.poll();

            if (++count == n) return (int)cur;
            for (int num: nums)
            {
                if (!q.contains(num * cur))
                    q.add(num * cur);
            }
        }
        return 0;
    }
}
