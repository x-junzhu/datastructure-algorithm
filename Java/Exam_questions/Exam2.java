package edu.fzu.pen;

/**
 * @author johnrambo
 * @create 2020-08-04 22:11
 */
public class Exam2 {

    static int s;

    int i;
    int j;
    {
        int i = 1;
        i++;//就近原则
        j++;
        s++;
    }

    public void test(int j)
    {
        j++;
        i++;
        s++;
    }

    public static void main(String[] args) {
        Exam2 obj1 = new Exam2();
        Exam2 obj2 = new Exam2();
        obj1.test(10);//0,1,1 => 1,1,2
        obj1.test(20);//2,1,3
        obj2.test(30);//0,1,4 => 1,1,5
        System.out.println(obj1.i + "," + obj1.j + "," + obj1.s);//3,1,5
        System.out.println(obj2.i + "," + obj2.j + "," + obj2.s);//2,1,5
    }
}
