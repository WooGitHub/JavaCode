package concurrency.second14;

/**
 * @author Woo_home
 * @create by 2019/12/21
 * 使用条件队列实现的有界缓存
 */
public class BoundedBuffer<V> extends BaseBoundedBuffer {

    protected BoundedBuffer(int capacity) {
        super(capacity);
    }

    // 阻塞并直到：not-full
    public synchronized void put(V v) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        doPut(v);
        notify();
    }

    // 阻塞并直到：not-empty
    public synchronized V take() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        V v = (V) doTake();
        notifyAll();
        return v;
    }
}
