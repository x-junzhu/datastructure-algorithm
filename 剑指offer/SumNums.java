package edu.fzu.lc2;

/**
 * @author johnrambo
 * @create 2020-09-02 9:13
 */
public class SumNums {

    /**
     * 求1+2+...+n,
     * 要求不能使用乘除法、for、while、if、else、switch、case
     * 等关键字及条件判断语句(A?B:C)
     *
     * 短路与:当&&符号前面为false时则后面不执行
     * @param n
     * @return
     */
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
