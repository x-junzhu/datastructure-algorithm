package edu.fzu.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author johnrambo
 * @create 2020-08-25 16:36
 */
public class Count_Prime {

    public static final int N = 1000010;
    public static int cnt;
    public static int[] primes = new int[N];
    public static boolean[] stk = new boolean[N];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        get_prime(n);
        System.out.println(cnt);
    }

    /**
     * 筛质数:每一次把i的倍数全部筛选掉
     * @param n
     */
    public static void get_prime(int n)
    {
        for (int i = 2; i <= n; i++)
        {
            if (stk[i] == false) primes[cnt++] = i;
            for (int j = i + i; j <= n; j += i) stk[j] = true;
        }
    }
}
