package edu.fzu.search;

import java.util.Scanner;

/**n皇后问题
 * @author johnrambo
 * @create 2020-07-26 10:19
 */
public class N_Queen {

    public static int N = 110;
    //dg表示对角线
    public static boolean[] dg = new boolean[N];
    //udg表示斜对角线
    public static boolean[] udg = new boolean[N];
    //col[i]表示第i列
    public static boolean[] col = new boolean[N];
    public static char[][] g = new char[N][N];
    public static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                g[i][j] = '.';
        dfs(0);
    }

    public static void dfs(int u)
    {
        if (u == n)
        {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(g[i][j]);
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++)
        {
            if (col[i] == false && dg[i + u] == false && udg[i - u + n] == false)
            {
                g[u][i] = 'Q';
                col[i] = dg[i + u] = udg[i - u + n] = true;
                dfs(u + 1);
                g[u][i] = '.';
                col[i] = dg[i + u] = udg[i - u + n] = false;
            }
        }
    }
}
