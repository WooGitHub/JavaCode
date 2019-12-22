package concurrency.second11;

import java.util.Set;

/**
 * @author Woo_home
 * @create by 2019/12/21
 */
public class ServerStatus2 {

    private final Set<String> users;

    private final Set<String> queries;

    public ServerStatus2(Set<String> users, Set<String> queries) {
        this.users = users;
        this.queries = queries;
    }

    public void addUser(String u) {
        synchronized (users) {
            users.add(u);
        }
    }

    public void addQuery(String u) {
        synchronized (queries) {
            queries.add(u);
        }
    }

    /**
     * 去掉同样被改写为使用被分解锁方法
     */
}
