package edu.fzu.lc;

/**
 * @author johnrambo
 * @create 2020-08-29 11:01
 */
public class MaxPrintNumber {

    public static void main(String[] args) {
        MaxPrintNumber mpn = new MaxPrintNumber();
        int[] items = mpn.printNumbers(1);
        for(int item: items) System.out.print(item + " ");
    }
    public int[] printNumbers(int n) {
        int N = (int)Math.pow(10, n) - 1;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
        {
            arr[i] = i + 1;
        }
        return arr;
    }
}
