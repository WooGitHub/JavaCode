package concurrency.second4;

import java.util.Vector;

/**
 * @author Woo_home
 * @create by 2019/12/8
 */

/**
 * 扩展Vector
 * 并增加一个putIfAbsent()方法（若没有则添加）
 */
public class BetterVector{
    public static void main(String[] args) {
        BetterVectorDemo vectorDemo = new BetterVectorDemo();
        vectorDemo.add("hello");
        vectorDemo.add("hi");
        vectorDemo.putIfAbsent("hello1");
        System.out.println(vectorDemo);
    }
}

class BetterVectorDemo<E> extends Vector {

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !contains(x);
        if (absent) {
            add(x);
        }
        return absent;
    }
}