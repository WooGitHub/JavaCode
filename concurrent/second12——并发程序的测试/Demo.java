package concurrency.second12;

/**
 * @author Woo_home
 * @create by 2019/12/21
 */
public class Demo {

    static int xorShift(int y) {
        y ^= (y << 6);
        y ^= (y >>> 21);
        y ^= (y << 7);
        return y;
    }

    public static void main(String[] args) {
        int i = xorShift(10);
        System.out.println(i);
    }
}
