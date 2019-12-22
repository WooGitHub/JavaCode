package concurrency.second7;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * @author Woo_home
 * @create by 2019/12/14
 * 通过中断来取消
 */
public class PrimeProduct {
    private final BlockingQueue<BigInteger> queue;

    public PrimeProduct(BlockingQueue<BigInteger> queue){
        this.queue = queue;
    }

    public void run(){
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted())
                queue.put(p = p.nextProbablePrime());
        }catch (InterruptedException consumed){
            /* 允许线程退出 */
        }
    }

    public void cancel(){
        Thread.currentThread().interrupt();
    }
}
