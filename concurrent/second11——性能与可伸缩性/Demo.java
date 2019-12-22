package concurrency.second11;

import java.util.List;
import java.util.Vector;

/**
 * @author Woo_home
 * @create by 2019/12/21
 * 通过锁消除优化去掉的锁获取操作
 */
public class Demo {
    public String getStoogeName() {
        List<String> stooges = new Vector<>();
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
        return stooges.toString();
    }
}
