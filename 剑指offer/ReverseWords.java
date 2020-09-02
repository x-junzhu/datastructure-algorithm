package edu.fzu.lc2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author johnrambo
 * @create 2020-09-02 15:00
 */
public class ReverseWords {

    public static final int N = 50010;

    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        String s = "a good   example";
        String s1 = rw.reverseWords(s);
        System.out.println(s1);
    }

    public String reverseWords(String s) {
        String s1 = s.trim();
        String[] res = new String[N];
        StringBuilder finalRes = new StringBuilder();
        int count = 0;
        String sb = "";
        //hello world!
        for (int i = 0; i < s1.length(); i++)
        {
            if (s1.charAt(i) != ' ')
                sb += s1.charAt(i);
            else
            {
                if (s1.charAt(i + 1) == ' '){

                }
                else {
                    sb += ' ';
                    res[count++] = sb;
                    sb = "";
                }
            }
        }
        sb += ' ';
        res[count] = sb;
        for (int i = count; i >= 0; i--)
            finalRes.append(res[i]);
        return finalRes.toString().trim();
    }
}
