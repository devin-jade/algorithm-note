package com.devin.algorithm.sort;

import org.junit.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author hkh
 * @since 2020/9/10
 */
public class CommonTest {


    class Foo {
        int i = 1;

        Foo() {
            System.out.println("fool con " + i);
            int x = getValue();
            System.out.println("fool con " + x);
        }

        {
            i = 2;
            System.out.println("foo code ...."+i);
        }

        protected int getValue() {
            return i;
        }
    }

    //子类
    class Bar extends Foo {
        int j = 1;

        Bar() {
            j = 2;
            System.out.println("Bar con " + i);
        }

        {
            j = 3;
            System.out.println("foo code ...."+j);
        }

        @Override
        protected int getValue() {
            System.out.println("bar getValue ...."+j);
            return j;
        }
    }



    @Test
    public void test2(){
        Bar bar = new Bar();
        System.out.println(bar.getValue());
    }

    @Test
    public void test3(){
        SClass sc = new SClass();
        System.out.println(sc);
    }
}
