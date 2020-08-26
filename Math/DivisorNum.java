package edu.fzu.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.BatchUpdateException;

/**
 * @author johnrambo
 * @create 2020-08-26 11:17
 */
public class DivisorNum {

    public static final int mod = (int)1e9 + 7, N = (int)3e9 + 7;

    public static long[] primes = new long[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while ((n--) != 0)
        {
            int x = Integer.parseInt(br.readLine());
            for (int i = 2; i <= x / i; i++)
            {
                while (x % i == 0)
                {
                    x /= i;
                    primes[i]++;
                }
            }
            if (x > 1) primes[x]++;
        }

        long res = 1;
        /*
        N = p1 ^ a1 * p2 ^ a2...pk ^ ak
        N的约数个数(a1 + 1) * (a2 + 1) * ... * (ak + 1)
        例如:N = 2 * 6 * 8
        N = (2 ^ 5) * (3 ^ 1) 则N的约数个数为(5 + 1) * (1 + 1) = 12
        */
        for (int i = 2; i < N; i++)
            if (primes[i] != 0)
                res = res * (primes[i] + 1) % mod;

    }


}
