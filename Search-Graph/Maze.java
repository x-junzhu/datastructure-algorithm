package edu.fzu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author johnrambo
 * @create 2020-07-26 10:43
 */
public class Maze {

    public static int N = 110;
    public static int[][] g = new int[N][N];

    //d[i][j]=l表示起点(0,0)到(i,j)的最短距离是l
    public static int[][] d = new int[N][N];
    //队列
    public static Pair[] q = new Pair[N * N];
    public static int n;
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] fLine = br.readLine().split(" ");
        n = Integer.parseInt(fLine[0]);
        m = Integer.parseInt(fLine[1]);

        for (int i = 0; i < n; i++)
        {
            String[] sLine = br.readLine().split(" ");
            for (int j = 0; j < m; j++)
                g[i][j] = Integer.parseInt(sLine[j]);
        }

        System.out.println(bfs());
    }

    public static int bfs()
    {
        int tt = 0, hh = 0;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                d[i][j] = -1;
        d[0][0] = 0;
        q[0] = new Pair(0, 0);
        //方向数组:以向右向下为正
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while (hh <= tt)
        {
            Pair<Integer, Integer> t = q[hh++];
            for (int i = 0; i < 4; i++)
            {
                int x = t.getFirst() + dx[i];
                int y = t.getSecond() + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m && g[x][y] == 0 && d[x][y] == -1)
                {
                    d[x][y] = d[t.getFirst()][t.getSecond()] + 1;
                    q[++tt] = new Pair(x, y);
                }
            }
        }
        return d[n - 1][m - 1];
    }
}

class Pair<E extends Object, F extends Object>{
    private E first;
    private F second;

    public Pair(E first, F second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public void setFirst(E first) {
        this.first = first;
    }

    public F getSecond() {
        return second;
    }

    public void setSecond(F second) {
        this.second = second;
    }
}
