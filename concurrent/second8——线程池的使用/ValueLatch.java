package concurrency.second8;

import java.util.concurrent.CountDownLatch;

/**
 * @author Woo_home
 * @create by 2019/12/15
 */
public class ValueLatch<T> {

    private T value = null;

    private final CountDownLatch done = new CountDownLatch(1);

    public boolean isSet() {
        return (done.getCount() == 0);
    }

    public synchronized void setValue(T newValue) {
        if (!isSet()) {
            newValue = newValue;
            done.countDown();
        }
    }

    public T getValue() throws InterruptedException {
        done.wait();
        synchronized (this) {
            return value;
        }
    }
}
