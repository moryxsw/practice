package network.y9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

@org.springframework.stereotype.Service
public class Service {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * spring事务失效的场景
     * 1. 方法内的自调用
     * 2. 方法是private的
     * 3. 方法是final的
     * 4. 单独的线程调用方法
     * 5. 异常被吃掉
     * 6. 类没有被spring管理
     */

    //    public void save() {
////        userService.save2();
//        UserService userService = (UserService) AopContext.currentProxy();
//        userService.save2();
//    }

//    @Transactional
//    public final void save2() {
//        jdbcTemplate.execute("INSERT INTO user (id, name) VALUES (6, 'Jack6')");
//        int i = 1/0;
//    }

//    @Transactional
//    public  void save2() {
//        jdbcTemplate.execute("INSERT INTO user (id, name) VALUES (2, 'Jack6')");
//        new Thread(()->{
//            jdbcTemplate.execute("INSERT INTO user (id, name) VALUES (6, 'Jack6')");
//            int i = 1/0;
//        }).start();
//    }

    @Autowired
    private PlatformTransactionManager transactionManager;

    // 编程式事务
    public void save() {
        TransactionStatus transaction = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            jdbcTemplate.execute("INSERT INTO user (id, name) VALUES (6, 'Jack6')");
            int i = 1 / 0;
            transactionManager.commit(transaction);
        } catch (DataAccessException e) {
            transactionManager.rollback(transaction);
        }
    }



    @Autowired
    private TransactionTemplate transactionTemplate;

    public void save2(User user) {
        jdbcTemplate.execute("INSERT INTO user (id, name) VALUES (5, 'Jack5')");

        transactionTemplate.execute((status) -> {
            jdbcTemplate.execute("INSERT INTO user (id, name) VALUES (6, 'Jack6')");
            int i = 1 / 0;
            return Boolean.TRUE;
        });

    }




}
