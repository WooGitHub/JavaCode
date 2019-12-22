package concurrency.second11;

/**
 * @author Woo_home
 * @create by 2019/12/21
 * 在基于散列的Map中使用锁分段技术
 */
public class StripeMap {

    private static final int N_LOCKS = 16;

    private final Node[] buckets;

    private final Object[] locks;

    private static class Node {
        Node next;
        Node prev;
        Node key;
        int value;

        Node(Node next,Node prev) {
            this.next = next;
            this.prev = prev;
        }
    }

    public StripeMap(int numBuckets) {
        buckets = new Node[numBuckets];
        locks = new Object[N_LOCKS];
        for (int i = 0; i < N_LOCKS; i++) {
            locks[i] = new Object();
        }
    }

    private final int hash(Object key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public Object get(Object key) {
        int hash = hash(key);
        synchronized (locks[hash % N_LOCKS]) {
            for (Node m = buckets[hash]; m != null ; m = m.next) {
                if (m.key.equals(key)) {
                    return m.value;
                }
            }
        }
        return null;
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            synchronized (locks[i % N_LOCKS]) {
                buckets[i] = null;
            }
        }
    }
}
