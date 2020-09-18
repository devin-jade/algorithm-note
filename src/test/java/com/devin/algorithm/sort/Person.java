package com.devin.algorithm.sort;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author hkh
 * @since 2020/9/10
 */
@Data
public class Person implements IPerson{

    private String name;

    private String age;

    public Person(){
    }

    public Person(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("hehhahahha" + name);
    }


}
