package edu.fzu.lc2;

import java.util.HashMap;

/**
 * @author johnrambo
 * @create 2020-09-01 20:28
 */
public class SingleNumbers {

    /**
     * 借助HashMap辅助记录每个数出现的次数
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(nums[i])) map.put(nums[i], 2);
            else map.put(nums[i], 1);
        }

        for (Integer num: map.keySet())
        {
            if (map.get(num) == 1)
                if (res[0] == 0) res[0] = num;
                else res[1] = num;
        }
        return res;
    }

    /**
     * 分组异或
     * @param nums
     * @return
     */
    public int[] singleNumbers1(int[] nums){
        int ret = 0;
        for (int num: nums)
            ret ^= num;

        int div = 1;
        while ((div & ret) == 0)
            div <<= 1;

        int a = 0, b = 0;
        for (int num: nums)
        {
            if ((div & num) != 0)
                a ^= num;
            else
                b ^= num;
        }
        return new int[]{a, b};
    }
}
