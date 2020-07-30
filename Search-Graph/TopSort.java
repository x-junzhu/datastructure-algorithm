package edu.fzu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author johnrambo
 * @create 2020-07-30 10:20
 */
public class TopSort {

    public static int N = 100010;

    public static int idx;
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int[] h = new int[N];

    //保存入度为0的节点,拓扑序列每次遍历从入度为0开始
    public static int[] q = new int[N];
    //d[i]=k表示节点i的入度为k
    public static int[] d = new int[N];

    //n个节点
    public static int n;
    //m条边
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] fLine = br.readLine().split(" ");
        n = Integer.parseInt(fLine[0]);
        m = Integer.parseInt(fLine[1]);

        Arrays.fill(h, -1);

        for (int i = 0; i < m; i++)
        {
            String[] sLine = br.readLine().split(" ");
            int k = Integer.parseInt(sLine[0]);
            int x = Integer.parseInt(sLine[1]);
            insert(k, x);
            d[x]++;
        }

        if (top())
        {
            for (int i = 0; i < n; i++) System.out.print(q[i] + " ");
        }
        else{
            System.out.println("-1");
        }
    }

    public static void insert(int k, int x)
    {
        e[idx] = x;
        ne[idx] = h[k];
        h[k] = idx++;
    }

    public static boolean top(){
        int hh = 0, tt = -1;

        for (int i = 1; i <= n; i++)
        {
            if (d[i] == 0) q[++tt] = i;
        }

        while (hh <= tt)
        {
            int t = q[hh++];
            for (int i = h[t]; i != -1; i = ne[i])
            {
                int j = e[i];
                d[j]--;
                //遍历完该节点如果入度为0则加入到栈中继续遍历
                if (d[j] == 0) q[++tt] = j;
            }
        }

        return tt == n - 1;
    }
}
