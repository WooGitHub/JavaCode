package concurrency.second5;

import java.util.concurrent.CountDownLatch;


/**
 * @author Woo_home
 * @create by 2019/12/13
 */

/**
 * 在计时测试中使用CountDownLatch来启动和停止线程
 */
public class TestHarness {

    public long timeTasks(int nThread,final Runnable task) throws InterruptedException{
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThread);

        for (int i = 0; i < nThread; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        // ignore error
                    }
                }
            };
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        long end = System.nanoTime();
        return end - start;
    }
}
