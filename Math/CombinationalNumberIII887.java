package edu.fzu.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author john
 * @create 2020-04-28 15:39
 */
public class CombinationalNumberIII887 {

    public int p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CombinationalNumberIII887 cn3 = new CombinationalNumberIII887();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++)
        {
            String[] num = br.readLine().split(" ");
            int a = Integer.parseInt(num[0]);
            int b = Integer.parseInt(num[1]);
            cn3.p = Integer.parseInt(num[2]);

            System.out.println(cn3.lucas(a, b));
        }
    }

    public long lucas(long a, long b)
    {
        if(a < p && b < p) return C(a, b);
        return C(a % p, b % p) * lucas(a / p, b / p);
    }

    public long C(long a, long b)
    {
        long res = 1L;
        for(long i = 1, j = a; i <= b; i++, j--)
        {
            res = res * j % p;
            res = res * qmi(i, p - 2) % p;
        }
        return res;
    }

    public long qmi(long a, int k)
    {
        long res = 1L;
        while(k != 0)
        {
            if((k & 1) != 0) res = res * a % p;
            k >>= 1;
            a = a * a % p;
        }
        return res;
    }
}
