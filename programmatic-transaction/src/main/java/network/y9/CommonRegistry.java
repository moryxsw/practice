package network.y9;

import org.springframework.transaction.support.TransactionTemplate;

/**
 * CommonRegistry
 *
 * @author wanghongyu10924
 * @since 2023/10/9
 */
public class CommonRegistry {


    /**
     * 从 Spring 上下文 获取 TransactionTemplate 的实例
     *
     * @return
     */
    public static TransactionTemplate tradeTransactionTemplate() {
        return SpringContextHolder.getBean("tradeTransactionTemplate");
    }
}
