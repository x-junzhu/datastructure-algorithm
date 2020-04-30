package edu.fzu.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author john
 * @create 2020-04-29 17:16
 */
public class InclusionExclusion890 {

    public static int N = 20;
    //p[]表示几个不同的质数
    public static int[] p = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] operator = br.readLine().split(" ");
        int n = Integer.parseInt(operator[0]);
        int m = Integer.parseInt(operator[1]);

        String[] num = br.readLine().split(" ");
        for(int j = 0; j < num.length; j++)
            p[j] = Integer.parseInt(num[j]);

        int res = 0;
        //1 << m = 2 ^ m
        //此处的i二进制中的1就是容斥原理中选几个集合的个数
        for(int i = 1; i < 1 << m; i++)
        {
            //t表示当前质数p(i)(此处描述的不够准确)
            long t = 1;
            //cnt表示当前i中包含几个1(是控制容斥原理中是加还是减)
            int cnt = 0;
            //这里的j表示i的二进制中被选的1的位置
            for(int j = 0; j < m; j++)
                if((i >> j & 1) != 0)//比如3的二进制是011,那么t就等于6, cnt = 2就是偶数
                {
                    cnt++;
                    if(t * p[j] > n)//如果当前的t比给定的范围n大即结束本次循环
                    {
                        t = -1;
                        break;
                    }
                    t *= p[j];
                }
            if(t != -1)
            {
                if(cnt % 2 != 0) res += n / t;
                else res -= n / t;//那么既是2的倍数又是3的倍数的个数就等于10/6=1
            }
        }
        System.out.println(res);
    }
}
