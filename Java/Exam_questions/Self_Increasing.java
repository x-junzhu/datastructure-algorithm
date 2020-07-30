package edu.fzu.search;

/**
 * @author johnrambo
 * @create 2020-07-30 14:31
 */
public class Self_Increasing {

    //1.自增
    public static void main(String[] args){
        int i = 1;
        i = i++;
        int j = i++;
        int k = i +++i * i++;
        System.out.println("i=" + i);
        System.out.println("j=" + j);
        System.out.println("k=" + k);
    }
}
