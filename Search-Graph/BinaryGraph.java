package edu.fzu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author johnrambo
 * @create 2020-08-05 14:29
 */
public class BinaryGraph {

    public static int N = 100010, M = 200010;

    public static int idx;
    public static int[] e = new int[M];
    public static int[] h = new int[N];
    public static int[] ne = new int[M];

    //color[i]=1 表示第i个点染为颜色1(且颜色只有两种1和2)
    public static int[] color = new int[N];
    public static int n;
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
            int x = Integer.parseInt(sLine[0]);
            int y = Integer.parseInt(sLine[1]);

            insert(x, y);
            insert(y, x);
        }

        boolean flag = false;
        for (int i = 1; i <= n; i++)
        {
            if (color[i] == 0)
            {
                if (dfs(i, 1) == false)
                {
                    flag = true;
                    break;
                }
            }
        }
        if (flag == true) System.out.println("Yes");
        else System.out.println("No");
    }

    public static void insert(int x, int y)
    {
        e[idx] = y;
        ne[idx] = h[x];
        h[x] = idx++;
    }

    public static boolean dfs(int u, int c)
    {
        color[u] = c;
        for (int i = h[u]; i != -1; i = ne[i])
        {
            int j = e[i];
            if (color[j] == 0)
            {
                if (dfs(j, 3 - c) == false)
                    return false;
            }else if (color[j] == c)
                return false;
        }
        return true;
    }
}
