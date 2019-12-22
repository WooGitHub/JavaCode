package concurrency.second7;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * @author Woo_home
 * @create by 2019/12/14
 * 增加了日志和计时器等功能的线程池
 */
public class TimingThreadPool extends ThreadPoolExecutor {

    private final ThreadLocal<Long> startTime;
    private final Logger logger = Logger.getLogger("TimingThreadPool");
    private final AtomicLong numTasks = new AtomicLong();
    private final AtomicLong totalTime = new AtomicLong();

    public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadLocal<Long> startTime) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        this.startTime = startTime;
    }

    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t,r);
        logger.fine(String.format("Thread %s : start %s",t,r));
        startTime.set(System.nanoTime());
    }

    protected void afterExecute(Runnable r, Throwable t) {
        try {
            long endTime = System.nanoTime();
            long taskTime = endTime - startTime.get();
            numTasks.incrementAndGet();
            totalTime.addAndGet(taskTime);
            logger.fine(String.format("Thread %s : end %s, time=%dns",t,r,taskTime));
        }finally {
            super.afterExecute(r,t);
        }
    }

    protected void terminated() {
        try {
            logger.fine(String.format("Terminated : avg time=%dns",totalTime.get() / numTasks.get()));
        }finally {
            super.terminated();
        }
    }
}
