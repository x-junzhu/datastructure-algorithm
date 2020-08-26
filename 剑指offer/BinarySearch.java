package edu.fzu.java;

/**
 * @author johnrambo
 * @create 2020-08-26 16:05
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[][] m = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
    };

        BinarySearch binarySearch = new BinarySearch();
        boolean numberIn2DArray = binarySearch.findNumberIn2DArray(m, 0);
        System.out.println(numberIn2DArray);
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0)
        {
            int t = matrix[i][j];
            if (t == target) return true;
            if (t > target) j--;
            else i++;
        }
        return false;
    }
}
