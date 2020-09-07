package edu.fzu.lc2;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberII {

    /**
     * 数组中只有一个数字出现一个其他数字均出现三次
     * @param nums 待查找数组
     * @return 只出现一次的那个数字
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> items = new HashMap<>();
        for (int num: nums)
        {
            if (items.containsKey(num))
            {
                int count = items.get(num);
                items.put(num, count + 1);
            }
            else items.put(num, 1);
        }

        for (Map.Entry<Integer, Integer> element: items.entrySet())
        {
            if (element.getValue() == 1) return element.getKey();
        }
        return 0;
    }

    public int singleNumber1(int[] nums) {
        int[] counts = new int[32];
        for (int num: nums)
        {
            for (int j = 0; j < 32; j++)
            {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++)
        {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}

