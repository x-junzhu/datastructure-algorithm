package edu.fzu.lc2;

/**
 * @author johnrambo
 * @create 2020-09-02 8:32
 */
public class ReversePairs {

    public static final int N = 50010;
    public static int[] tmp = new int[N];

    public int reversePairs(int[] nums) {
        int n = nums.length;
        int res = merge_sort(nums, 0, n - 1);
        return res;

    }

    /**
     * 归并排序求逆序对个数
     * @param nums
     * @param l 数组左端点
     * @param r 数组右端点
     * @return 逆序对个数
     */
    public int merge_sort(int[] nums, int l, int r)
    {
        if (l >= r) return 0;
        int mid = l + r >> 1;
        //[l, mid]归并过程中左半边逆序对个数+[mid+1, r]归并排序右半边逆序对个数
        int res = merge_sort(nums, l, mid) + merge_sort(nums, mid + 1, r);
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r)
        {
            if (nums[i] <= nums[j]) tmp[k++] = nums[i++];
            else
            {
                tmp[k++] = nums[j++];
                //进入当前分支后nums[i]>nums[j]
                //归并排序过程中左边一个右边一个
                res += mid - i + 1;
            }
        }

        while (i <= mid) tmp[k++] = nums[i++];
        while (j <= r) tmp[k++] = nums[j++];

        for (i = l, k = 0; i <= r; i++, k++) nums[i] = tmp[k];
        return res;
    }
}
