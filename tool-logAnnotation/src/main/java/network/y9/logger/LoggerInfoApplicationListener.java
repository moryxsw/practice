package network.y9.logger;

import com.alibaba.druid.DbType;
import com.alibaba.druid.util.JdbcUtils;
import network.y9.logger.conf.LoggerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.beans.Statement;
import java.sql.Connection;

@Component
public class LoggerInfoApplicationListener implements CommandLineRunner {


    @Autowired
    private DataSource dataSource;
    @Autowired
    private LoggerConfig loggerConfig;
/

    @Override
    public void run(String... args) throws Exception {
        // 判断数据库类型
        Connection conn = dataSource.getConnection();
        try (Statement statement = conn.createStatement()) {
            DbType dbType = JdbcUtils.getDbType(conn.getMetaData().getURL());
            ddl = DdlSqlFactory.valueOf(dbType.name()).getDdl();
            // 查询表有没有存在
            if (!existTable(statement)) {
                createTable(statement);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能描述: 建表 <br/>
     */
    private void createTable(Statement statement) throws SQLException {
        statement.execute(ddl.createTable());
    }


    /**
     * 功能描述: 是否存在表 <br/>
     */
    private boolean existTable(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery(ddl.queryTable(""));
        resultSet.next();
        return resultSet.getInt(1) == 1;
    }
}
