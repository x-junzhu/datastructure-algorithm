package edu.fzu.lc;

/**
 * @author johnrambo
 * @create 2020-08-27 16:14
 */
public class Fibonacci {

    public static final int mod = (int)1e9 + 7;

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        int res = f.fib(3);
        System.out.println(res);
    }

    /**
     * 斐波那契数列非递归
     * @param n
     * @return 第n个值
     */
    public int fib(int n) {
        int a = 0;
        int b = 1;
        int c;
        for (int i = 0; i < n; i++)
        {
            c = (a + b) % mod;
            a = b;
            b = c;
        }
        return a;
    }
}
