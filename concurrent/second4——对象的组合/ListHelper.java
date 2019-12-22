package concurrency.second4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Woo_home
 * @create by 2019/12/8
 */

/**
 * 通过客户端加锁实现“若没有则添加”
 * 该类是线程安全的
 * @param <E>
 */
public class ListHelper<E> {

    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    public boolean putIfAbsent(E x){
        synchronized (list){
            boolean absent = !list.contains(x);
            if (absent){
                list.add(x);
            }
            return absent;
        }
    }
}


/**
 * 该类不是线程安全的
 * @param <E>
 */
class ListHelper1<E>{

    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    public synchronized boolean putIfAbsent(E x){
        boolean absent = !list.contains(x);
        if (absent){
            list.add(x);
        }
        return absent;
    }
}