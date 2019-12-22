package concurrency.second14;

/**
 * @author Woo_home
 * @create by 2019/12/21
 * 当不满足前提条件时，有界缓存不会执行相应的操作
 */
public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer {

    protected GrumpyBoundedBuffer(int size) {
        super(size);
    }

    public synchronized void put(V v) {
        if (isFull())
            System.out.println("BufferFullException");
        doPut(v);
    }

    public synchronized V take() {
        if (isEmpty())
            System.out.println("BufferEmptyException");
        return (V) doTake();
    }
}
