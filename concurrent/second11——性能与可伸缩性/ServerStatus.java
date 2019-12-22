package concurrency.second11;

import java.util.Set;

/**
 * @author Woo_home
 * @create by 2019/12/21
 * 对锁进行分解
 */
public class ServerStatus {

    public final Set<String> users;

    public final Set<String> queries;

    public ServerStatus(Set<String> users, Set<String> queries) {
        this.users = users;
        this.queries = queries;
    }

    public synchronized void addUsers(String u) {
        users.add(u);
    }

    public synchronized void addQuery(String q) {
        queries.add(q);
    }

    public synchronized void removeUser(String u) {
        users.remove(u);
    }

    public synchronized void removeQuery(String q) {
        queries.remove(q);
    }
}
