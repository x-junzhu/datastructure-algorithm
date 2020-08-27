package edu.fzu.lc;

/**
 * @author johnrambo
 * @create 2020-08-27 19:22
 */
public class GoSteps {

    public static final int mod = (int)1e9 + 7;

    public int numWays(int n) {
        if(n == 0) return 1;
        if(n == 1 || n == 2) return n;
        //初始化走到第二级台阶的步数
        int one = 2;
        //初始化走到第一级台阶的步数
        int two = 1;
        int sum = 0;
        for(int i = 3; i <= n; i++)
        {
            //假如n=3,最后一步走到第二级台阶+最后一步走到第一级台阶
            sum = (two + one) % mod;
            two = one;
            one = sum;
        }
        return sum;
    }
}
