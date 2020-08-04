package edu.fzu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author johnrambo
 * @create 2020-08-04 14:40
 */
public class Prim {

    public static int N = 510, INF = 0x3f3f3f3f;

    public static int[] dist = new int[N];
    public static int[][] g = new int[N][N];
    public static boolean[] stk = new boolean[N];

    public static int n;
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] fLine = br.readLine().split(" ");
        n = Integer.parseInt(fLine[0]);
        m = Integer.parseInt(fLine[1]);

        for(int i = 0; i < N; i++)
            Arrays.fill(g[i], INF);

        while ((m--) != 0)
        {
            String[] sLine = br.readLine().split(" ");
            int a = Integer.parseInt(sLine[0]);
            int b = Integer.parseInt(sLine[1]);
            int w = Integer.parseInt(sLine[2]);

            g[a][b] = g[b][a] = Math.min(g[a][b], w);
        }

        int t = prim();

        if(t == INF) System.out.println("impossible");
        else System.out.println(t);
    }

    public static int prim()
    {
        Arrays.fill(dist, INF);

        int res = 0;
        for(int i = 0; i < n; i++)
        {
            int t = -1;
            /*查找所有节点到到"集合"中距离最短的点
		    这里的集合是指当前已经在连通块中的所有点
		    */
            for(int j = 1; j <= n; j++)
                if(stk[j] == false && (t == -1 || dist[t] > dist[j]))
                    t = j;
            /*如果存在一个节点到"集合"的距离为INF，则此图为不连通图*/
            if(i > 0 && dist[t] >= INF) return INF;
            if(i > 0) res += dist[t];

            /*此时t是到集合距离最短的点，所以以t为出发点更新dist数组*/
            for(int j = 1; j <= n; j++) dist[j] = Math.min(dist[j], g[t][j]);

            stk[t] = true;
        }
        return res;
    }
}
