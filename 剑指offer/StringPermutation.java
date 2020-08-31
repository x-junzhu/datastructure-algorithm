package edu.fzu.lc;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author johnrambo
 * @create 2020-08-31 15:08
 */
public class StringPermutation {

    public static int N = 20;
    public static int n;

    StringBuilder sb = new StringBuilder();
    boolean[] stk = new boolean[N];
    char[] res = new char[N];

    public String[] permutation(String s) {
        n = s.length();
        int size = 1;
        for (int i = 1; i <= n; i++)
            size *= i;

        dfs(0, s);

        //对于"aab"这样的字符串去重
        HashSet<String> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < sb.length(); i += n)
        {
            set.add(sb.substring(i, i + n));
        }

        String[] finalRes = new String[set.size()];
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext())
            finalRes[count++] = iterator.next();
        return finalRes;
    }

    public void dfs(int u, String s)
    {
        if (u == n)
        {
            for (int i = 0; i < n; i++)
                sb.append(res[i]);
            return;
        }

        for (int i = 0; i < n; i++)
        {
            if (stk[i] == false)
            {
                res[u] = s.charAt(i);
                stk[i] = true;
                dfs(u + 1, s);
                stk[i] = false;
            }
        }

    }


}
