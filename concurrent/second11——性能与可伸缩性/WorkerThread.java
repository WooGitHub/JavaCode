package concurrency.second11;

import java.util.concurrent.BlockingQueue;

/**
 * @author Woo_home
 * @create by 2019/12/21
 */
public class WorkerThread extends Thread {

    private final BlockingQueue<Runnable> queue;

    public WorkerThread(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Runnable task = queue.take();
                task.run();
            }catch (InterruptedException e) {
                break; /* 允许线程进出 */
            }
        }
    }
}
