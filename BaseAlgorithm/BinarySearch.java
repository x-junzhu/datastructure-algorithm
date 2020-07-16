package edu.fzu.search;

/**
 * @author johnrambo
 * @create 2020-07-16 7:44
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 7, 9, 10, 15, 22};
        int index = binarySearch(arr, 22);
        System.out.println(index);
    }

    /**
     * 二分查找
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearch(int[] arr, int value)
    {
        int l = 0, r = arr.length - 1;
        while (l < r)
        {
            int mid = l + r >> 1;
            if (arr[mid] >= value) r = mid;
            else l = mid + 1;
        }
        if (arr[r] == value) return r;
        else return -1;
    }

    /**
     * 插值查找(自适应二分查找),二分查找的优化,一般使用在数据比较连续的数组中
     * @param arr 待查找数组
     * @param val 待查找值
     * @return
     */
    public static int binarySearchEnhanced(int[] arr, int val)
    {
        int l = 0, r = arr.length - 1;
        while (l < r)
        {
            //此处的mid值可能由于待查找的val值过大导致mid越界
            int mid = l + (r - l) * (val - arr[l]) / (arr[r] - arr[l]);
            if (arr[mid] >= val) r = mid;
            else l = mid + 1;
        }
        if (arr[r] == val) return r;
        else return -1;
    }
}
