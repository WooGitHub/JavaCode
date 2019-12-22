package concurrency.second3;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author Woo_home
 * @create by 2019/12/8
 */
public class OneValueCache {

    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger i,BigInteger[] factors){
        lastNumber = i;
        lastFactors = Arrays.copyOf(factors,factors.length);
    }

    public BigInteger[] getFactors(BigInteger i){
        if (lastNumber == null || !lastNumber.equals(i)){
            return null;
        }else{
            return Arrays.copyOf(lastFactors,lastFactors.length);
        }
    }
}
