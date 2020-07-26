package edu.fzu.search;

import java.util.Scanner;

/**
 * @author johnrambo
 * @create 2020-07-26 7:47
 */
public class DFS {

    public static int N = 10;
    //保存一种方案
    public static int[] path = new int[N];
    //stk[i]=true:表示第i个节点已经遍历过
    public static boolean[] stk = new boolean[N];
    //n:表示1~n个待排列数字
    public static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        dfs(0);
    }

    /**
     * 深度优先遍历
     * @param u 第u个位置
     */
    public static void dfs(int u)
    {
        if (u == n)
        {
            for (int i = 0; i < n; i++)
                System.out.print(path[i] + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++)
        {
            //如果节点i没有遍历过
            if (stk[i] == false)
            {
                stk[i] = true;
                path[u] = i;
                dfs(u + 1);
                stk[i] = false;
            }
        }
    }
}
