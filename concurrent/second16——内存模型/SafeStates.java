package concurrency.second16;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Woo_home
 * @create by 2019/12/22
 * 不可变对象的初始化安全性
 */
public class SafeStates {

    private final Map<String,String> states;

    public SafeStates() {
        states = new HashMap<>();
        states.put("1","John");
        states.put("2","Lisa");
        states.put("3","grates");
    }

    public String getAbbreviation(String a) {
        return states.get(a);
    }

    public static void main(String[] args) {
        SafeStates safeStates = new SafeStates();
        String abbreviation = safeStates.getAbbreviation("1");
        System.out.println(abbreviation);
    }
}
