package edu.fzu.algo;

/**
 * @author johnrambo
 * @create 2020-07-15 9:38
 */
public class Sort {
    public static int N = 1000000;
    public static int[] tmp = new int[N];

    public static void main(String[] args) {
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = (int)(Math.random() * N);
        long start = System.currentTimeMillis();
        mergeSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
//        System.out.println(Arrays.toString(arr));
        System.out.println(N + "个数据快速排序的时间是=" + (end - start));
    }

    /**
     * 冒泡排序 时间复杂度o(n^2)
     * @param arr
     */
    public static void bubbleSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = 0; j < arr.length - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序 时间复杂度o(n^2),因为交换次数少,所以时间比冒泡快一些
     * @param arr
     */
    public static void selectSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            int minNum = arr[i], t = 0;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] < minNum)
                {
                    minNum = arr[j];
                    t = j;
                }
            }

            if (minNum != arr[i])
            {
                arr[t] = arr[i];
                arr[i] = minNum;
            }
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            int insertValue = arr[i];
            int insertIndex = i - 1;//待插入数据前面有序序列的最后一个数
            while (insertIndex >= 0 && arr[insertIndex] > insertValue)
            {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            arr[insertIndex + 1] = insertValue;
        }
    }

    /**
     * 希尔排序 交换法
     * @param arr
     */
    public static void shellSort(int[] arr)
    {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的所有的元素
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前的元素大于加上步长的元素，要交换
                    if (arr[j] > arr[j + gap]) {
                        int t = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = t;
                    }
                }
            }
        }
    }

    /**
     * 希尔排序 移位法
     * @param arr
     */
    public static void shellSortEnhanced(int[] arr)
    {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从gap个元素开始，逐个对其所在的组进行插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int t = arr[j];
                if (arr[j] < arr[j - gap])
                {
                    while (j - gap >= 0 && t < arr[j - gap])
                    {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while，即找到插入位置
                    arr[j] = t;
                }
            }
        }
    }

    /**
     * 快速排序
     * @param arr
     * @param l
     * @param r
     */
    public static void quickSort(int[] arr, int l, int r)
    {
        if (l >= r) return;
        int i = l - 1, j = r + 1;
        int x = arr[l];
        while (i < j)
        {
            do i++; while (x > arr[i]);
            do j--; while (x < arr[j]);
            if (i < j)
            {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        quickSort(arr, l, j);
        quickSort(arr, j + 1, r);
    }

    /**
     * 归并排序
     * @param arr
     * @param l
     * @param r
     */
    public static void mergeSort(int[] arr, int l, int r)
    {
        if (l >= r) return;
        int mid = l + r >> 1;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r)
        {
            if (arr[i] <= arr[j]) tmp[k++] = arr[i++];
            else tmp[k++] = arr[j++];
        }

        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= r) tmp[k++] = arr[j++];

        for (i = l, k = 0; i <= r; i++, k++)
            arr[i] = tmp[k];
    }

}
