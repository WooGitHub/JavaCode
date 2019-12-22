package concurrency.second3;

import java.util.*;

/**
 * @author Woo_home
 * @create by 2019/12/8
 */
public class ThreeStooges {
    private final Set<String> stooges = new HashSet<>();

    public Map<String, Date> lastLogin = Collections.synchronizedMap(new HashMap<>());

    public ThreeStooges(){
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }

    public boolean isStooges(String name){
        return stooges.contains(name);
    }
}
