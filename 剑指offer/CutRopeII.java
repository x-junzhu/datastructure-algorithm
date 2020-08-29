package edu.fzu.lc;

/**
 * @author johnrambo
 * @create 2020-08-29 8:54
 */
public class CutRopeII {

    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int b = n % 3, p = (int)1e9 + 7;
        int k = n / 3 - 1;
        long res = qmi(3, k, p);
        if (b == 0) return (int)(res * 3 % p);
        if (b == 1) return (int)(res * 4 % p);
        return (int)(res * 6 % p);
    }

    public long qmi(int a, int k, int p)
    {
        long res = 1;
        while (k != 0)
        {
            res = res * a % p;
            k >>= 1;
            a = a * a % p;
        }
        return res;
    }
}
