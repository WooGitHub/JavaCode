package concurrency.second5;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * @author Woo_home
 * @create by 2019/12/14
 * 使用Semaphore为容器设置界限
 */
public class BoundedHashSet<T> {
    private final Set<T> set;
    private final Semaphore sem;

    public BoundedHashSet(int bound, Semaphore sem){
        this.set = Collections.synchronizedSet(new HashSet<>());
        this.sem = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException{
        sem.acquire();
        boolean wasAdded = false;
        try{
            wasAdded = set.add(o);
            return wasAdded;
        }finally {
            if (!wasAdded)
                sem.release();
        }
    }

    public boolean remove(Object o){
        boolean waRemoved = set.remove(o);
        if (waRemoved)
            sem.release();
        return waRemoved;
    }
}