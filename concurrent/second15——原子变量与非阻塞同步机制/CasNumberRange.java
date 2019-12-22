package concurrency.second15;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Woo_home
 * @create by 2019/12/21
 * 通过CAS来维持包含多个变量的不变性操作
 */
public class CasNumberRange {

    private static class IntPair {
        final int lower;
        final int upper;

        IntPair(int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
        }
    }

    private final AtomicReference<IntPair> values = new AtomicReference<>(new IntPair(0,0));

    public int getLower() {
        return values.get().lower;
    }

    public int getUpper() {
        return values.get().upper;
    }

    public void setLower(int i) {
        while (true) {
            IntPair oldv = values.get();
            if (i > oldv.upper) {
                throw new IllegalArgumentException("Can't set lower to " + i + " > upper");
            }
            IntPair newv = new IntPair(i, oldv.upper);
            if (values.compareAndSet(oldv, newv))
                return;
        }
    }
}
