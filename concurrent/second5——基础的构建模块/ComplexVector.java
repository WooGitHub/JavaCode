package concurrency.second5;

/**
 * @author Woo_home
 * @create by 2019/12/8
 */

import java.util.Vector;

/**
 * 在使用客户端加锁的Vector上的复合操作
 */
public class ComplexVector {

    public static Object getLast(Vector list){
        synchronized (list){
            int lastIndex = list.size() - 1;
            return list.get(lastIndex);
        }
    }

    public static void deleteLast(Vector list){
        synchronized (list){
            int lastIndex = list.size() - 1;
            list.remove(lastIndex);
        }
    }

}
