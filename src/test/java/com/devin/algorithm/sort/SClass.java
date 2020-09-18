package com.devin.algorithm.sort;

/**
 * <p>
 *
 * </p>
 *
 * @author hkh
 * @since 2020/9/10
 */
public class SClass extends SSClass{

    private static int a = getA();
    public static int value = 123;
    static{
        System.out.println("a2 = "+a);
        a=2;
        System.out.println("a3 = "+a);
        System.out.println("SClass static!");
    }
    {
        a =3;
        System.out.println(a);
    }
    public static int getA(){
        System.out.println("getA");
        return 1;
    }



    public SClass(){
        a =4;
        System.out.println(a);
        System.out.println(" SClass construct init");
    }
}
