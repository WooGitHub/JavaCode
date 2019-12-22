package concurrency.second14;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author Woo_home
 * @create by 2019/12/21
 * 使用 AbstractQueuedSynchronizer 实现的二元闭锁
 */
public class OneShotLatch {

    private class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected int tryAcquireShared(int arg) {
            // 如果闭锁是开的(state == 1)，那么这个操作将成功，否则将失败
            return (getState() == 1) ? 1 : -1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            setState(1); // 打开闭锁
            return true; // 现在其他的线程可以获取该闭锁
        }
    }
}
