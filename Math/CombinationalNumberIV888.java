package edu.fzu.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author john
 * @create 2020-04-28 20:14
 */
public class CombinationalNumberIV888 {

    public static int N = 5010;
    public static int[] primes = new int[N];
    public static int cnt;
    public static int[] sum = new int[N];
    public static boolean[] st = new boolean[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CombinationalNumberIV888 cn4 = new CombinationalNumberIV888();

        String[] num = br.readLine().split(" ");
        int a = Integer.parseInt(num[0]);
        int b = Integer.parseInt(num[1]);

        cn4.get_primes(a);

        for(int i = 0; i < cnt; i++)
        {
            int p = primes[i];
            sum[i] = cn4.get(a, p) - cn4.get(b, p) - cn4.get(a - b, p);
        }

        List<Integer> res = new ArrayList<Integer>();
        res.add(1);

        for(int i = 0; i < cnt; i++)
            for(int j = 0;j < sum[i]; j++)
                res = cn4.mul(res, primes[i]);

        for(int i = res.size() - 1; i >= 0; i--) System.out.print(res.get(i));
        System.out.println();
    }

    public int get(int n, int p)
    {
        int res = 0;
        while(n != 0)
        {
            res += n / p;
            n /= p;
        }
        return res;
    }

    public void get_primes(int n)
    {
        for(int i = 2; i <= n; i++)
        {
            if(!st[i]) primes[cnt++] = i;
            for(int j = 0; primes[j] <= n / i; j++)
            {
                st[primes[j] * i] = true;
                if(i % primes[j] == 0) break;
            }
        }
    }

    public List<Integer> mul(List<Integer> a, int b)
    {
        int t = 0;
        List<Integer> c = new ArrayList<Integer>();
        for(int i = 0; i < a.size(); i++)
        {
            t += a.get(i) * b;
            c.add(t % 10);
            t /= 10;
        }
        while(t != 0)
        {
            c.add(t % 10);
            t /= 10;
        }
        return c;
    }
}
