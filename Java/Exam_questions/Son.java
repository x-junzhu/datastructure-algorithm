package edu.fzu.pen;

/**3.类初始化与实例初始化
 * @author johnrambo
 * @create 2020-07-30 20:00
 */
public class Son extends Father{
    /*
    (5)(1)(10)(6) (9)(3)(2)(9)(8)(7)
    (9)(3)(2)(9)(8)(7)
    父类初始化<clinit>:(1和2也是按着声明顺序执行)
    (1)静态实例变量
    (2)父类的静态代码块

    子类实例化方法:(2和3按照声明的顺序)
    (1)super()(最前)
    (2)非静态属性
    (3)子类的非静态代码块
    (4)子类的无参构造(最后)

    非静态方法前面其实有一个默认的对象this
    this在构造器(或<init>)它表示正在创建的对象,因为这里创建的是Son对象,所有test()
    执行的是子类重写的代码(面向对象的多态性)
     */
    private int i = test();
    private static int j = method();

    static {
        System.out.print("(6)");
    }
    Son(){
        System.out.print("(7)");
    }
    {
        System.out.print("(8)");
    }
    public int test()
    {
        System.out.print("(9)");
        return 1;
    }

    public static int method(){
        System.out.print("(10)");
        return 1;
    }

    public static void main(String[] args) {
        Son s1 = new Son();
        System.out.println();
        Son s2 = new Son();
    }
}

class Father {

    /*
    父类初始化<clinit>:(1和2也是按着声明顺序执行)
            (1)静态实例变量
            (2)父类的静态代码块
    父类实例化方法:(2和3按照声明的顺序)
    (1)super()(最前)
    (2)非静态属性
    (3)父类的非静态代码块
    (4)父类的无参构造(最后)
     */
    private int i = test();
    private static int j = method();

    static{
        System.out.print("(1)");
    }
    Father(){
        System.out.print("(2)");
    }
    {
        System.out.print("(3)");
    }

    public int test()
    {
        System.out.print("(4)");
        return 1;
    }

    public static int method()
    {
        System.out.print("(5)");
        return 1;
    }
}

