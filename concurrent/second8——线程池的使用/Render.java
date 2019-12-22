package concurrency.second8;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Woo_home
 * @create by 2019/12/15
 * 用于解决谜题的框架的链表节点
 */

public class Render<T> {
    static class Node<P,M> {
        final P pos;
        final M move;
        final Node<P,M> prev;

        Node(P pos, M move, Node<P,M> prev) {
            this.pos = pos;
            this.move = move;
            this.prev = prev;
        }

        List<M> asMoveList() {
            List<M> solution = new LinkedList<>();
            for (Node<P,M> n = this; n.move != null; n = n.prev) {
                solution.add(0,n.move);
            }
            return solution;
        }
    }
}