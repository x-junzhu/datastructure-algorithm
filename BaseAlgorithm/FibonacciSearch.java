package edu.fzu.search;

import java.util.Arrays;

/**
 * @author johnrambo
 * @create 2020-07-16 9:43
 */
public class FibonacciSearch {

    public static int N = 1010;
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int index = fibonacciSearch(arr, 1);
        System.out.println(index);

    }

    //得到一个斐波那契数列
    public static int[] fib() {
        int[] f = new int[N];
        f[0] = f[1] = 1;
        for (int i = 2; i < N; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * 黄金分割查找法(斐波那契查找)
     * @param arr
     * @param val
     * @return 查找成功返回数组中的下标，否则返回-1
     */
    public static int fibonacciSearch(int[] arr, int val)
    {
        int l = 0, r = arr.length - 1;
        int k = 0;//菲波那切分割数值的下标
        int mid = 0;
        int f[] = fib();//获取斐波那契数列
        //获取斐波那契分割数值的下标
        while (r > f[k] - 1) k++;
        //因为f[k]值可能大于数组arr的长度,所以我们需要使用一个Arrays类构造一个新的数组
        //并指向temp
        int[] temp = Arrays.copyOf(arr, f[k]);
        //实际上需要使用arr数组的最后一个数填充temp
        for (int i = r + 1; i < temp.length; i++)
        {
            temp[i] = arr[r];
        }

        while (l < r)
        {
            mid = l + f[k - 1] - 1;
            if (temp[mid] >= val) {
                r = mid;
                k--;
            }
            else {
                l = mid + 1;
                k -= 2;
            }
        }

        if (arr[r] == val) return r;
        else return -1;
    }
}
