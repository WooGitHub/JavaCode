package concurrency.second4;

/**
 * @author Woo_home
 * @create by 2019/12/8
 */

/**
 * 通过一个私有锁来保护状态
 */
public class PrivateLock {

    private final Object myLock = new Object();

    Widget widget;

    void someMethod(){
        synchronized (myLock){
            // 访问或修改widget的状态
        }
    }

}

class Widget{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Widget{" +
                "name='" + name + '\'' +
                '}';
    }
}