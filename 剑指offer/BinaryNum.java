package edu.fzu.lc;

/**
 * @author johnrambo
 * @create 2020-08-29 9:25
 */
public class BinaryNum {

    public static void main(String[] args) {
        BinaryNum bn = new BinaryNum();
        int num = bn.hammingWeight(001100001);
        System.out.println(num);

    }

    /**
     * 二进制中1的个数
     * @param n 二进制数或者十进制的数
     * @return 二进制数中1的个数
     */
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0)
        {
            if((n & 1) == 1) count++;
            n >>>= 1;
        }
        return count;
    }
}
