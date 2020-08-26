package edu.fzu.java;

/**
 * @author johnrambo
 * @create 2020-08-26 14:56
 */
public class RepeatNumber {

    public static final int N = 100010;

    public static void main(String[] args) {
        RepeatNumber re = new RepeatNumber();
        int[] num = {2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = re.findRepeatNumber(num);
        System.out.println(repeatNumber);
    }

    /**
     * 找出数组中任意一个重复的数字
     * @param nums 待查找数组
     * @return 任意一个重复的数字
     */
    public int findRepeatNumber(int[] nums) {
        //count[i]=n表示nums中的元素i出现的次数为n
        int[] count = new int[N];
        int repeat = -1;
        for (int i = 0; i < nums.length; i++)
        {
            count[nums[i]]++;
            if (count[nums[i]] > 1)
            {
                repeat = nums[i];
                break;
            }
        }
        return repeat;
    }
}
