package edu.fzu.lc2;

/**
 * @author johnrambo
 * @create 2020-09-01 19:58
 */
public class MissingNumber {

    public static final int INF = 0x3f3f3f3f;

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        int[] nums = {1, 2};
        int missingNumber = mn.missingNumber(nums);
        System.out.println(missingNumber);
    }

    /**
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
     * 并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字
     * 不在该数组中，请找出这个数字。
     *
     * @param nums 缺失值数组
     * @return 缺失值
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int missingNum = INF;
        for(int i = 0; i < nums.length; i++)
        {
            if (nums[i] != i)
            {
                missingNum = i;
                break;
            }
        }
        if (missingNum == INF) missingNum = n;
        return missingNum;
    }
}
