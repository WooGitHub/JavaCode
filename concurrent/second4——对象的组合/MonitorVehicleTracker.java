package concurrency.second4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Woo_home
 * @create by 2019/12/8
 */

/**
 * 基于监视器模式的车辆追踪，追踪器是线程安全的
 * 它所包含的Map对象和可变的Point对象都未曾发布。当需要返回车辆的位置时
 * 通过MMutablePoint拷贝构造函数或者deepCopy方法复制正确的值，从而生成一个新的Map对象
 * 并且该对象中的值与原有的Map对象中的key值和value值都相同
 */
public class MonitorVehicleTracker {

    private final Map<String,MutablePoint> locations;

    public MonitorVehicleTracker(Map<String,MutablePoint> locations){
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String,MutablePoint> getLocations(){
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id){
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }

    public synchronized void setLocations(String id,int x,int y){
        MutablePoint loc = locations.get(id);
        if (loc == null){
            throw new IllegalArgumentException("No such ID: " + id);
        }
        loc.x = x;
        loc.y = y;
    }

    public static Map<String,MutablePoint> deepCopy(Map<String,MutablePoint> m){
        Map<String, MutablePoint> result = new HashMap<>();
        for (String id : m.keySet()) {
            result.put(id,new MutablePoint(m.get(id)));
        }
        return Collections.unmodifiableMap(result);
    }
}


/**
 * MutablePoint类并不是线程安全的
 */
class MutablePoint{
    public int x;
    public int y;

    public MutablePoint(){
        x = 0;
        y = 0;
    }

    public MutablePoint(MutablePoint p){
        this.x = p.x;
        this.y = p.y;
    }
}