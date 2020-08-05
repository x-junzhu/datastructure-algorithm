package edu.fzu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author johnrambo
 * @create 2020-08-05 15:03
 */
public class MaxMatchBinaryGraph {

    public static int N = 510, M = 100010;

    public static int idx;
    public static int[] e = new int[M];
    public static int[] h = new int[N];
    public static int[] ne = new int[M];

    //match[i]=j表示第i个女生的对象时j
    public static int[] match = new int[N];

    //stk[i]表示第i个女生有对象了
    public static boolean[] stk = new boolean[N];

    public static int n1;
    public static int n2;
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] fLine = br.readLine().split(" ");
        n1 = Integer.parseInt(fLine[0]);
        n2 = Integer.parseInt(fLine[1]);
        m = Integer.parseInt(fLine[2]);

        Arrays.fill(h, -1);

        while ((m--) != 0)
        {
            String[] sLine = br.readLine().split(" ");
            int x = Integer.parseInt(sLine[0]);
            int y = Integer.parseInt(sLine[0]);
            insert(x, y);
        }

        int res = 0;
        for (int i = 1; i <= n1; i++)
        {
            Arrays.fill(stk, false);
            if (find(i) == true)
                res++;
        }

        System.out.println(res);
    }

    public static void insert(int k, int x)
    {
        e[idx] = x;
        ne[idx] = h[k];
        h[k] = idx++;
    }

    public static boolean find(int x)
    {
        for (int i = h[x]; i != -1; i = ne[i])
        {
            int j = e[i];
            if (stk[j] == false)
            {
                stk[j] = true;
                if (match[j] == 0 || find(match[j])) {
                    match[j] = x;
                    stk[j] = true;
                }
            }
        }
        return false;
    }
}
