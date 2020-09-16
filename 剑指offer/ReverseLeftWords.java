package edu.fzu.lc3;

public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (j < n) j++;
        while (j < s.length()) sb.append(s.charAt(j++));
        while (i < n) sb.append(s.charAt(i++));
        return sb.toString();
    }

    public String reverseLeftWords1(String s, int n) {
        int l = s.length();
        char[] res = new char[l];
        int index = 0;
        for (int j = n; j < l; j++) res[index++] = s.charAt(j);
        for (int i = 0; i < n; i++) res[index++] = s.charAt(i);
        return new String(res);
    }
}
