package edu.fzu.lc;

/**
 * @author johnrambo
 * @create 2020-08-29 18:29
 */
public class ExchangeNumber {

    public static void main(String[] args) {
        ExchangeNumber en = new ExchangeNumber();
        int[] nums = new int[]{1, 2, 3, 4};
        en.exchange(nums);
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }

    /**
     * 调整奇数和偶数的位置
     * @param nums 待调整的数组
     * @return
     */
    public int[] exchange(int[] nums) {
        int i = -1, j = nums.length;
        while (i < j)
        {
            do i++; while (i < j && nums[i] % 2 == 1);
            do j--; while (i < j && nums[j] % 2 == 0);
            if (i < j)
            {
                int t;
                t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        return nums;
    }
}
