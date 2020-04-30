package edu.fzu.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author john
 * @create 2020-04-29 9:26
 */
public class Cattleya889 {

    public static int mod = 1000000000 + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Cattleya889 cattley = new Cattleya889();

        int n = Integer.parseInt(br.readLine());

        int a = 2 * n, b = n;
        long res = 1L;

        for(int i = a; i > a - b; i--) res = res * i % mod;
        for(int i = 1; i <= b; i++) res = res * cattley.qmi(i, mod - 2, mod) % mod;

        res = res * cattley.qmi(n + 1, mod - 2, mod) % mod;
        System.out.println(res);

    }

    public long qmi(long a, int k, int p)
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
