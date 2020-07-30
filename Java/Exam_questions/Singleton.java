package edu.fzu.pen;

/**
 * @author johnrambo
 * @create 2020-07-28 22:00
 */
public class Singleton {

    private Singleton()
    {

    }

    /*1.饿汉式
    private static Singleton instance = new Singleton();

    public static Singleton getInstance()
    {
        return instance;
    }
     */

    /*2.懒汉式-线程不安全
    private static Singleton instance = null;

    public static Singleton getInstance()
    {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
     */

    /*3.懒汉式-线程安全(同步代码块)
    private static Singleton instance = null;

    public static Singleton getInstance()
    {
        if (instance == null){
            synchronized(Singleton.class){
                instance = new Singleton();
            }
        }
        return instance;
    }
     */

    /*静态内部类:不会随着外部类的加载而加载,它是单独加载和初始化的
    private static class Inner{
        private static Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance()
    {
        return Inner.INSTANCE;
    }
     */

}
