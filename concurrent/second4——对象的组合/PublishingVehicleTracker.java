package concurrency.second4;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Woo_home
 * @create by 2019/12/8
 */

/**
 * 安全发布底层状态的车辆追踪器
 * 总结：
 * 1、底层对象是否安全：加锁，final修饰
 * 2、管理中间层安全：安全容器、加锁（复合操作）
 */
public class PublishingVehicleTracker {

    private final Map<String,SafePoint> locations;

    private final Map<String,SafePoint> unmodifiableMap;

    public PublishingVehicleTracker(Map<String,SafePoint> locations){
        this.locations = new ConcurrentHashMap<>(locations);
        this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
    }

    public Map<String,SafePoint> getLocations(){
        return unmodifiableMap;
    }

    public SafePoint getLocation(String id){
        return locations.get(id);
    }

    public void setLocation(String id,int x,int y){
        if (!locations.containsKey(id)){
            throw new IllegalArgumentException("invalid vehicle name: " + id);
        }
        locations.get(id);
    }
}


/**
 * 线程安全可变的Point类
 */
class SafePoint{

    private int x,y;

    private SafePoint(int[] a){
        this(a[0],a[1]);
    }

    public SafePoint(SafePoint p) {
        this(p.get());
    }

    public SafePoint(int x,int y){
        this.x = x;
        this.y = y;
    }

    public synchronized int[] get(){
        return new int[]{x,y};
    }

    public synchronized void set(int x,int y){
        this.x = x;
        this.y = y;
    }
}
