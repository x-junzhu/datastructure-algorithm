package edu.fzu.lc2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author johnrambo
 * @create 2020-08-31 19:35
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] nums ={1, 2, 3, 2, 2, 2, 5, 4, 2};
        int res = me.majorityElement2(nums);
        System.out.println(res);
    }

    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = nums.length;
        int major = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (hashMap.containsKey(nums[i]))
            {
                int count = hashMap.get(nums[i]);
                hashMap.put(nums[i], count + 1);
            }
            else
                hashMap.put(nums[i], 1);
        }

        for (Integer item: hashMap.keySet())
        {
            if (hashMap.get(item) * 2 > n) {
                major = item;
                break;
            }
        }
        return major;
    }

    public int majorityElement1(int[] nums) {

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
        {
            arr.add(nums[i]);
        }

        Collections.sort(arr);
        int n = arr.size();
        return arr.get(n / 2);
    }

    public int majorityElement2(int[] nums) {
        int votes = 0, x = 0;
        for (int num: nums)
        {
            if (votes == 0) x = num;
            int t = (num == x ? 1: -1);
            votes += t;
        }
        return x;
    }
}
