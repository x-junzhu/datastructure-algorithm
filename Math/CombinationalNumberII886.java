package edu.fzu.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author john
 * @create 2020-04-28 13:58
 */
public class CombinationalNumberII886 {
    public static int N = 100010;

    //fact[i]:表示i的阶乘
    public static long[] fact = new long[N];
    //infact[i]:表示i的阶乘的逆元
    public static long[] infact = new long[N];
    public static int mod = 1000000000 + 7;
    /*
    C(a, b) = a! / ((a - b)! * b!)
    借助逆元将除法转换为乘法 => C(a, b) = fact[a] * infact[a - b] * infact[b]
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CombinationalNumberII886 cn2 = new CombinationalNumberII886();

        fact[0] = 1L;
        infact[0] = 1L;
        for(int i = 1; i < N; i++)
        {
            fact[i] = fact[i - 1] * i % mod;
            infact[i] = infact[i - 1] * cn2.qmi(i, mod - 2, mod) % mod;
        }

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++)
        {
            String[] num = br.readLine().split(" ");
            int a = Integer.parseInt(num[0]);
            int b = Integer.parseInt(num[1]);

            System.out.println(fact[a] * infact[a - b] % mod * infact[b] % mod);
        }
    }

    public long qmi(long a, int k, int p)
    {
        long res = 1;
        while(k != 0)
        {
            if((k & 1) > 0) res = res * a % p;
            k >>= 1;
            a = a * a % p;
        }
        return res;
    }


}
