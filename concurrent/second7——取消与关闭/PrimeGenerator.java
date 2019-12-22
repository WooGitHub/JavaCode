package concurrency.second7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Woo_home
 * @create by 2019/12/14
 * 使用volatile类型的域来保存取消状态
 */
public class PrimeGenerator implements Runnable{

    private final List<BigInteger> primes = new ArrayList<>();
    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled){
            p = p.nextProbablePrime();
            synchronized (this){
                primes.add(p);
            }
        }
    }

    public void cancel(){
        cancelled = true;
    }

    public synchronized List<BigInteger> get(){
        return new ArrayList<>(primes);
    }
}
