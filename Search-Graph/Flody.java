package edu.fzu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author johnrambo
 * @create 2020-08-04 8:09
 */
public class Flody {

    public static int N = 210, INF = (int)1e7;

    public static int[][] dist = new int[N][N];

    public static int n;
    public static int m;
    public static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] fLine = br.readLine().split(" ");
        n = Integer.parseInt(fLine[0]);
        m = Integer.parseInt(fLine[1]);
        k = Integer.parseInt(fLine[2]);

        for (int i = 0; i < m; i++)
        {
            String[] sLine = br.readLine().split(" ");
            int x = Integer.parseInt(sLine[0]);
            int y = Integer.parseInt(sLine[1]);
            int z = Integer.parseInt(sLine[2]);
            dist[x][y] = Math.min(dist[x][y], z);
        }

        flody();

        for (int i = 0; i < k; i++)
        {
            String[] tLine = br.readLine().split(" ");
            int x = Integer.parseInt(tLine[0]);
            int y = Integer.parseInt(tLine[1]);
            int t = dist[x][y];
            if (t >= INF / 2) System.out.println("impossible");
            else System.out.println(t);
        }
    }

    public static void flody()
    {
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
    }
}
