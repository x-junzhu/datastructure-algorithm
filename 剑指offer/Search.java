package edu.fzu.lc2;

/**
 * @author johnrambo
 * @create 2020-09-02 19:34
 */
public class Search {

    /**
     * 统计一个数字在排序数组中出现的次数。
     * 思路:二分查找数组中第一次出现target的位置
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int count = 0;
        int l = 0, r = nums.length - 1;
        while(l < r)
        {
            int mid = l + r >> 1;
            if(nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        count = r;
        if(nums[r] != target) return 0;
        else
        {
            while(nums[count] == target)
            {
                count++;
                if(count == nums.length) break;
            }
        }
        return count - r;

    }
}
