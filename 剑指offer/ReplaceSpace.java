package edu.fzu.lc;

/**
 * @author johnrambo
 * @create 2020-08-26 19:14
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        String s = "We are happy.";
        ReplaceSpace rs = new ReplaceSpace();
        String myString = rs.replaceSpace(s);
        System.out.println(myString);
    }

    /**
     * 将字符串中的空格替换成"%20"
     * @param s 待替换的字符串
     * @return 替换后的字符串
     */
    public String replaceSpace(String s)
    {
        char[] items = s.toCharArray();
        int oldSize = s.length();
        int count = 0;
        for (int i = 0; i < oldSize; i++)
        {
            if (s.charAt(i) == ' ')
                count++;
        }

        char[] s1 = new char[oldSize + 2 * count];
        int newSize = s1.length;
        for (int i = newSize - 1, j = oldSize - 1; j >= 0 && i >= 0; i--, j--)
        {
            if (items[j] != ' ')
                s1[i] = items[j];
            else
            {
                s1[i] = '0';
                s1[i - 1] = '2';
                s1[i - 2] = '%';
                i -= 2;
            }
        }
        String s2 = new String(s1);
        return s2;
    }

    /*
    StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) != ' ')
                sb.append(s.charAt(i));
            else
                sb.append("%20");
        }
        return sb.toString();
     */
}
