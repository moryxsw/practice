package network.y9;

import org.springframework.stereotype.Component;

/**
 * TransactionManagerImpl
 *
 * @author wanghongyu10924
 * @since 2023/10/9
 */
@Component
public class TransactionManagerImpl implements TransactionManager{
    @Override
    public void commit(TransactionAction action) {
        CommonRegistry.tradeTransactionTemplate().execute(transactionStatus -> {
            action.execute();
            return true;
        });
    }
}
