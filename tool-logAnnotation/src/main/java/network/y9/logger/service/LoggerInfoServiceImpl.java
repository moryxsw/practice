package network.y9.logger.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import network.y9.logger.entity.LoggerInfoEntity;
import network.y9.logger.mapper.LoggerInfoMapper;
import org.springframework.stereotype.Service;

@Service
public class LoggerInfoServiceImpl implements ServiceImpl<LoggerInfoMapper, LoggerInfoEntity> implements ILoggerInfoService {
}
