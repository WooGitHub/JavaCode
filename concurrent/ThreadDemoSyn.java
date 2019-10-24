package com.example.testdemo.testdemo.concurrent;

/**
 * @author Woo_home
 * @create by 2019/10/20
 */
public class ThreadDemoSyn {
    public static void main(String[] args) {
        synchronized (ThreadDemoSyn.class){

        }
        m();
    }
    public static synchronized void m(){
        System.out.println("hello world");
    }
}
