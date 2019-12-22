package concurrency.second8;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * @author Woo_home
 * @create by 2019/12/21
 * 使用Semaphore来控制任务的提交速率
 */
public class BoundExecutor {

    private final Executor exec;

    private final Semaphore semaphore;

    public BoundExecutor(Executor exec, int bound) {
        this.exec = exec;
        this.semaphore = new Semaphore(bound);
    }

    public void submitTask(final Runnable command) throws InterruptedException {
        semaphore.acquire();
        try {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        command.run();
                    }finally {
                        semaphore.release();
                    }
                }
            });
        }catch (RejectedExecutionException e) {
            semaphore.release();
        }
    }
}
