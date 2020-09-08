package edu.fzu.lc2;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence {

    /**
     * 滑动窗口:输出和为target的连续子序列
     * @param target 目标和
     * @return 包含所有子序列的数组
     */
    public int[][] findContinuousSequence(int target) {
        int i = 1;//左端点闭区间
        int j = 1;//右端点开区间
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        while (i <= target / 2)
        {
            if (sum < target)
            {
                sum += j;//右边界向右移动
                j++;
            }
            else if (sum > target)
            {
                sum -= i;//左边界向右移动
                i++;
            }
            else
            {
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++)
                {
                    arr[k - i] = k;
                }
                res.add(arr);
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
