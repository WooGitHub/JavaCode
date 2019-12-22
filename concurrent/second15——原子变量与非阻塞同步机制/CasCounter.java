package concurrency.second15;

/**
 * @author Woo_home
 * @create by 2019/12/21
 * 基于 CAS 实现的非阻塞计数器
 */
public class CasCounter {

    private SimulatedCAS value;

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        }while (v != value.compareAndSwap(v,v + 1));
        return v + 1;
    }
}
