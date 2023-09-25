package network.y9.logger.service;

import com.baomidou.mybatisplus.extension.service.IService;
import network.y9.logger.entity.LoggerInfoEntity;
import org.springframework.scheduling.annotation.Async;

public interface ILoggerInfoService  extends IService<LoggerInfoEntity> {

    /**
     * 功能描述: 异步保存 <br/>
     *
     * @param info 日志信息
     */
    @Async
    default void saveAsync(LoggerInfoEntity info) {
        save(info);
    }
}
