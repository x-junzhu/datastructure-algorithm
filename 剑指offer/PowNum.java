package edu.fzu.lc;

/**
 * @author johnrambo
 * @create 2020-08-29 9:49
 */
public class PowNum {

    public static void main(String[] args) {
        PowNum pn = new PowNum();
        double num = pn.myPow(2.00000, -2);
        System.out.println(num);

    }

    /**
     * 浮点数 大次幂计算
     * @param x 底数
     * @param n 幂
     * @return
     */
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0)
        {
            x = 1 / x;
            b = -b;
        }
        //快速幂计算高次幂
        while (b > 0)
        {
            if ((b & 1) == 1) res = res * x;
            b >>= 1;
            x *= x;
        }
        return res;
    }
}
