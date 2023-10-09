package network.y9;

/**
 * TransactionManager
 *
 * @author wanghongyu10924
 * @since 2023/10/9
 */
public interface TransactionManager {

    void commit(TransactionAction action);
}
