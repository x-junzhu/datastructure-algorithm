package edu.fzu.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author johnrambo
 * @create 2020-08-26 10:19
 */
public class Divisor {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while ((n--) != 0)
        {
            int x = Integer.parseInt(br.readLine());
            List<Integer> res = get_divisor(x);
            for (Integer item: res) System.out.print(item + " ");
            System.out.println();
        }
    }

    public static List<Integer> get_divisor(int x)
    {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= x / i; i++)
        {
            if (x % i == 0){
                res.add(i);
                if (i != x / i) res.add(x / i);
            }
        }
        Collections.sort(res);
        return res;
    }
}
