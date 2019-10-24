package com.example.testdemo.testdemo.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * @author Woo_home
 * @create by 2019/10/23
 */

/**
 * description
 * CyclicBarrier默认的构造方法是CyclicBarrier（int parties），其参数表示屏障拦截的线程数
 * 量，每个线程调用await方法告诉CyclicBarrier我已经到达了屏障，然后当前线程被阻塞。示例
 */
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.wait();
                }catch (Exception e){

                }
                System.out.println(1);
            }
        }).start();
        try {
            c.wait();
        }catch (Exception e){
            System.out.println(2);
        }
    }
}
