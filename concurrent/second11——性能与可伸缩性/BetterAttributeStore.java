package concurrency.second11;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author Woo_home
 * @create by 2019/12/21
 * 减少锁持有时间
 */
public class BetterAttributeStore {

    private final Map<String,String> attribute = new HashMap<>();

    public boolean userLocationMatches(String name, String regexp) {
        String key = "user." + name + ".location";
        String location;
        synchronized (this) {
            location = attribute.get(key);
        }
        if (location == null) {
            return false;
        }else {
            return Pattern.matches(regexp,location);
        }
    }
}
