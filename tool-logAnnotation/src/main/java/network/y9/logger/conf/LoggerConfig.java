package network.y9.logger.conf;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "logger.project")
public class LoggerConfig {

    /** 定义日志级别 */
    private LoggerLevelEnum level = LoggerLevelEnum.NONE;
}
