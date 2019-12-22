package concurrency.second12;

import java.util.concurrent.Semaphore;

/**
 * @author Woo_home
 * @create by 2019/12/21
 * 基于信号量的有界缓存
 */
public class BoundedBuffer<E> {

    private final Semaphore availableItems,avilableSpaces;

    private final E[] items;

    private int putPosition = 0, takePosition = 0;

    public BoundedBuffer(int capacity) {
        availableItems = new Semaphore(0);
        avilableSpaces = new Semaphore(capacity);
        items = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return availableItems.availablePermits() == 0;
    }

    public boolean isFull() {
        return avilableSpaces.availablePermits() == 0;
    }

    public  void put(E x) throws InterruptedException {
        avilableSpaces.acquire();
        doInsert(x);
        availableItems.release();
    }

    public E take() throws InterruptedException {
        availableItems.acquire();
        E item = doExtract();
        availableItems.release();
        return item;
    }

    public synchronized void doInsert(E x) {
        int i = putPosition;
        items[i] = x;
        putPosition = (++i == items.length) ? 0 : i;
    }

    public synchronized E doExtract() {
        int i = takePosition;
        E x = items[i];
        items[i] = null;
        takePosition = (++i == items.length) ? 0 : i;
        return x;
    }
}
