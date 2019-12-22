package concurrency.second4;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Woo_home
 * @create by 2019/12/8
 */

/**
 * 将线程安全委托给ConcurrentHashMap
 */
public class DelegatingVehicleTracker {

    private final ConcurrentHashMap<String,Point> locations;
    private final Map<String,Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String,Point> points){
        locations = new ConcurrentHashMap<>(points);
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String,Point> getLocations(){
        return unmodifiableMap;
    }

    public Point getLocation(String id){
        return locations.get(id);
    }

    public void setLocation(String id,int x,int y){
        if (locations.replace(id,new Point(x,y)) == null){
            throw new IllegalArgumentException("invalid vehicle name: " + id);
        }
    }

}

/**
 * 不可变的Point类
 */
class Point{
    public final int x,y;

    public Point(int x,int y){
        this.x= x;
        this.y = y;
    }
}