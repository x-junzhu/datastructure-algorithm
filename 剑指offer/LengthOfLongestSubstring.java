package edu.fzu.lc2;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    /**
     * 最长不重复子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dict = new HashMap<>();

        int res = 0, t = 0;
        for (int j = 0; j < s.length(); j++)
        {
            int i = dict.getOrDefault(s.charAt(j), -1);
            dict.put(s.charAt(j), j);
            t = t < j - i ? t + i: j - i;
            res = Math.max(res, t);
        }
        return res;
    }

    /**
     * 最长不重复子串：双指针+哈希表
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {

        Map<Character, Integer> dict = new HashMap<>();
        int res = 0, i = -1;
        for (int j = 0; j < s.length(); j++)
        {
            if (dict.containsKey(s.charAt(j)))
                i = Math.max(i, dict.get(s.charAt(j)));
            dict.put(s.charAt(j), j);
            res = Math.max(res, j - i);
        }
        return res;
    }
}
