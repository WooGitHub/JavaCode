package concurrency.second14;

/**
 * @author Woo_home
 * @create by 2019/12/21
 * 使用 wait 和 notifyAll 来实现可重新关闭的阀门
 */
public class ThreadGate {

    private boolean isOpen;

    private int generation;

    public synchronized void close() {
        isOpen = false;
    }

    public synchronized void open() {
        ++generation;
        isOpen = true;
        notifyAll();
    }

    // 阻塞并直到：opened-since(generation on entry)
    public synchronized void await() throws InterruptedException {
        int arrivalGeneration = generation;
        while (!isOpen && arrivalGeneration == generation) {
            wait();
        }
    }
}
