package edu.fzu.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author john
 * @create 2020-04-29 20:25
 */
public class NimGame891 {

    /*
    简单博弈论
    如果a1 ^ a2 ^ a3 ^ ... ^ an = 0先手必败
    如果a1 ^ a2 ^ a3 ^ ... ^ an != 0先手必胜
    注: 每一次的策略两人都采用最优策略
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = 0;
        String[] num = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            res ^= Integer.parseInt(num[i]);

        if(res != 0) System.out.println("Yes");
        else System.out.println("No");
    }
}
