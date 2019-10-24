package com.example.testdemo.testdemo.ThreadPoolPackage;

import rx.Single;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Woo_home
 * @create by 2019/10/24
 *
 * @description：
 * corePoolSize：线程池的核心线程数；
 * maximumPoolSize：线程池的最大线程数；
 * keepAliveTime：线程池空闲时线程的存活时长；
 * timeUnit：线程存活时长大单位，结合上个参数使用；
 * workQueue：存放任务的队列，使用的是阻塞队列；
 */
public class ThreadPoolDemo {

    /**
     * corePoolSize（线程池的基本大小）：当提交一个任务到线程池时，线程池会创建一个线
     * 程来执行任务，即使其他空闲的基本线程能够执行新任务也会创建线程，等到需要执行的任
     * 务数大于线程池基本大小时就不再创建。如果调用了线程池的prestartAllCoreThreads()方法，
     * 线程池会提前创建并启动所有基本线程
     */
    private int corePoolSize;


    /**
     * maximumPoolSize（线程池最大数量）：线程池允许创建的最大线程数。如果队列满了，并
     * 且已创建的线程数小于最大线程数，则线程池会再创建新的线程执行任务。值得注意的是，如
     * 果使用了无界的任务队列这个参数就没什么效果
     */
    private int maximumPoolSize;


    /**
     * keepAliveTime（线程活动保持时间）：线程池的工作线程空闲后，保持存活的时间。所以，
     * 如果任务很多，并且每个任务执行的时间比较短，可以调大时间，提高线程的利用率
     */
    private long keepAliveTime;


    /**
     * TimeUnit（线程活动保持时间的单位）：可选的单位有天（DAYS）、小时（HOURS）、分钟
     * （MINUTES）、毫秒（MILLISECONDS）、微秒（MICROSECONDS，千分之一毫秒）和纳秒
     * （NANOSECONDS，千分之一微秒）
     */
    private TimeUnit timeUnit;


    /**
     * workQueue（任务队列）：用于保存等待执行的任务的阻塞队列。可以选择以下几
     * 个阻塞队列。
     * ·ArrayBlockingQueue：是一个基于数组结构的有界阻塞队列，此队列按FIFO（先进先出）原
     * 则对元素进行排序。
     * ·LinkedBlockingQueue：一个基于链表结构的阻塞队列，此队列按FIFO排序元素，吞吐量通
     * 常要高于ArrayBlockingQueue。静态工厂方法Executors.newFixedThreadPool()使用了这个队列。
     * ·SynchronousQueue：一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用
     * 移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于Linked-BlockingQueue，静态工
     * 厂方法Executors.newCachedThreadPool使用了这个队列。
     * ·PriorityBlockingQueue：一个具有优先级的无限阻塞队列
     */
    private BlockingQueue<Runnable> workQueue;

    /**
     * 创建线程池 ThreadPoolExecutor
     */
    ThreadPoolExecutor executors = new ThreadPoolExecutor(corePoolSize,maximumPoolSize,
            keepAliveTime,timeUnit,workQueue);

    public static void main(String[] args) {

    }
}
