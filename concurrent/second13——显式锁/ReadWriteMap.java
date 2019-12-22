package concurrency.second13;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Woo_home
 * @create by 2019/12/21
 * 用 ReadWriteLock 读写锁来包装 Map
 */
public class ReadWriteMap<K,V> {

    private final Map<K,V> map;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();

    private final Lock writeLock = lock.writeLock();

    public ReadWriteMap(Map<K,V> map) {
        this.map = map;
    }

    public V put(K key, V value) {
        writeLock.lock();
        try {
            return map.put(key,value);
        }finally {
            writeLock.unlock();
        }
    }

    // 对remove(),putAll(),clear()等方法执行相同的操作

    public V get(Object key) {
        readLock.lock();
        try {
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }

    // 对其它只读的Map方法执行相同的操作
}
