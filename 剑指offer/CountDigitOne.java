package edu.fzu.lc2;

/**
 * @author johnrambo
 * @create 2020-09-01 10:04
 */
public class CountDigitOne {

    public static void main(String[] args) {
        CountDigitOne cdo = new CountDigitOne();
        int count = cdo.countDigitOne(100);
        System.out.println(count);
    }

    /**
     * 求解1-n中所有数字里1出现的次数
     * 
     * 1.当cur=0时,此位 11 的出现次数只由高位high决定，计算公式为:high * digit
     * 2.当cur=1时,此位 11 的出现次数由高位high和低位 low 决定，计算公式为：
     *      high×digit+low+1
     * 3.当cur=2, 3,...,9时：此位1的出现次数只由高位high决定，计算公式为:
     *      (high+1)×digit
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0)
        {
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
