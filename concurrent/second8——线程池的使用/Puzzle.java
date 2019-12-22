package concurrency.second8;

import java.util.Set;

/**
 * @author Woo_home
 * @create by 2019/12/15
 */
public interface Puzzle<P,M> {
    P initialPosition();
    boolean isGoal(P position);
    Set<M> legalMoves(P position);
    P move(P position, M move);
}
