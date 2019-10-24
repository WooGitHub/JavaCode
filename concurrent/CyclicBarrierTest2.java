package com.example.testdemo.testdemo.concurrent;

/**
 * @author Woo_home
 * @create by 2019/10/23
 */

import org.springframework.web.servlet.support.JstlUtils;

import java.util.concurrent.CyclicBarrier;

/**
 * description
 * 如果把new CyclicBarrier(2)修改成new CyclicBarrier(3)，则主线程和子线程会永远等待，
 * 因为没有第三个线程执行await方法，即没有第三个线程到达屏障，所以之前到达屏障的两个
 * 线程都不会继续执行。
 * CyclicBarrier还提供一个更高级的构造函数CyclicBarrier（int parties，Runnable barrier-
 * Action），用于在线程到达屏障时，优先执行barrierAction，方便处理更复杂的业务场景，如代码
 */
public class CyclicBarrierTest2 {
    static CyclicBarrier c = new CyclicBarrier(2,new A());

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

        }
        System.out.println(2);
    }
    static class A implements Runnable{
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
