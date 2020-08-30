package edu.fzu.lc;

/**
 * @author johnrambo
 * @create 2020-08-30 8:38
 */
public class SpiralPrint {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},{4, 5, 6}, {7, 8, 9}};
        SpiralPrint sp = new SpiralPrint();
        int[] items = sp.spiralOrder(matrix);
        for(int i = 0; i < items.length; i++)
            System.out.print(items[i] + " ");
    }


    /**
     * 顺时针打印矩阵
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int m = matrix.length, n = matrix[0].length;

        int[] res = new int[m * n];
        boolean[][] stk = new boolean[m][n];

        //d记录当前方向
        int x = 0, y = 0, d = 0;
        int count = 0;
        for (int k = 0; k < m * n; k++)
        {
            res[count++] = matrix[x][y];
            stk[x][y] = true;
            int a = x + dx[d], b = y + dy[d];
            if (a < 0 || a >= m || b < 0 || b >= n || stk[a][b])
            {
                //如果当前在矩阵边界或者当前元素已经被遍历过了,则改变方向
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            //如果不在边界并且当前元素没有遍历过则继续朝当前方向
            x = a;
            y = b;
        }
        return res;
    }
}
