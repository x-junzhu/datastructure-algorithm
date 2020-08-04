package edu.fzu.pen;

import org.junit.Test;

/**
 * @author johnrambo
 * @create 2020-08-02 22:07
 */
public class TestStep {

    @Test
    public void test()
    {
        System.out.println(f(3));
    }

    public int f(int n)
    {
        if (n == 1 || n == 2) return n;
        return f(n - 1) + f(n - 2);
    }

    public int loop(int n)
    {
        if (n == 1 || n == 2) return n;

        //初始化为走到第二级台阶的走法
        int one = 2;
        //初始化为走到第一级台阶的走法
        int two = 1;

        int sum = 0;

        for (int i = 3; i <= n; i++) {
            //最后跨两步+最后跨一步
            sum = two + one;
            two = one;
            one = sum;
        }

        return sum;
    }
}
