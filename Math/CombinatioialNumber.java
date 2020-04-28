package edu.fzu.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author john
 * @create 2020-04-28 10:02
 */
public class CombinatioialNumber {
    public static int N = 2010;
    public static int mod = 1000000000 + 7;
    public static int c[][] = new int[N][N];

    public static void main(String[] args) throws IOException {
        CombinatioialNumber cn = new CombinatioialNumber();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cn.init();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++)
        {
            String[] num = br.readLine().split(" ");
            int a = Integer.parseInt(num[0]);
            int b = Integer.parseInt(num[1]);
            System.out.println(c[a][b]);
        }

    }
    /*
    预处理组合数
    C(a, b) = C(a - 1, b - 1) + C(a - 1, b)
     */
    public void init()
    {
        for(int i = 0; i < N; i++)
            for(int j = 0; j <= i; j++)
                if(j == 0) c[i][j] = 1;
                else c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % mod;
    }
}
