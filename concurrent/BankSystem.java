package com.example.testdemo.testdemo.concurrent;

import org.junit.Test;

/**
 * @author Woo_home
 * @create by 2019/10/18
 */
public class BankSystem {
    int a;
    volatile int v1 = 1;
    volatile int v2 = 2;

    @Test
    public void readAndWrite(){
        int i = v1;
        int j = v2;
        a = i + j;
        v1 = i + 1;
        v2 = j * 2;
        System.out.println(v1+"------------"+v2);
    }
}