package edu.fzu.lc2;

/**
 * @author johnrambo
 * @create 2020-09-01 9:17
 */
public class LeastNumbers {

    public static final int N = 10010;
    public static int[] h = new int[N];
    int len;

    public static void main(String[] args) {
        LeastNumbers ln = new LeastNumbers();
        int[] arr = {4, 5,1, 2, 3, 8, 7, 6};
        int[] leastNumbers = ln.getLeastNumbers(arr, 4);
        for (int i = 0; i < leastNumbers.length; i++)
            System.out.print(leastNumbers[i] + " ");
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        for (int i = 1; i <= arr.length; i++)
            h[i] = arr[i - 1];
        len = arr.length;
        for (int i = arr.length / 2; i > 0; i--) down(i);

        for (int i = 0; i < k; i++)
        {
            res[i] = h[1];
            h[1] = h[len];
            len--;
            down(1);
        }
        return res;
    }

    public void down(int u)
    {
        int t = u;
        if (2 * u <= len && h[t] > h[2 * u]) t = 2 * u;
        if (2 * u + 1 <= len && h[t] > h[2 * u + 1]) t = 2 * u + 1;
        if (t != u)
        {
            int tmp = h[t];
            h[t] = h[u];
            h[u] = tmp;
            down(t);
        }
    }
}
