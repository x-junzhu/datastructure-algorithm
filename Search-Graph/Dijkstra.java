package edu.fzu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author johnrambo
 * @create 2020-07-31 8:02
 */
public class Dijkstra {

    public static int N = 510;

    public static int[][] g = new int[N][N];

    //dist[i]=l表示从节点1到节点n的最短距离为l
    public static int[] dist = new int[N];
    public static boolean[] stk = new boolean[N];

    //n个点
    public static int n;
    //m条边
    public static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] fLine = br.readLine().split(" ");
        n = Integer.parseInt(fLine[0]);
        m = Integer.parseInt(fLine[1]);

        for (int i = 0; i < N; i++)
            Arrays.fill(g[i], 0x3f3f);

        for (int i = 0; i < m; i++)
        {
            String[] sLine = br.readLine().split(" ");
            int x = Integer.parseInt(sLine[0]);
            int y = Integer.parseInt(sLine[1]);
            //x->y的权重
            int w = Integer.parseInt(sLine[2]);
            g[x][y] = Math.min(w, g[x][y]);
        }

        System.out.println(dijkstra());

    }

    public static int dijkstra()
    {
        Arrays.fill(dist, 0x3f);

        dist[1] = 0;
        for (int i = 0; i < n; i++)
        {
            int t = -1;
            for (int j = 1; j <= n; j++)
                if (stk[j] == false && (t == -1 || dist[t] > dist[j]))
                    t = j;

            stk[t] = true;

            for (int j = 1; j <= n; j++)
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
        }
        if (dist[n] >= 0x3f3f) return -1;
        return dist[n];
    }
}
