package network.y9.logger.aspect;


import cn.hutool.core.net.NetUtil;
import cn.hutool.json.JSONUtil;
import network.y9.logger.conf.LoggerConfig;
import network.y9.logger.conf.LoggerLevelEnum;
import network.y9.logger.entity.LoggerInfoEntity;
import network.y9.logger.service.ILoggerInfoService;
import network.y9.logger.utils.HttpRequestUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

@Order(99)
@Aspect
@Component
public class RequestLogAspect {

    @Autowired
    private LoggerConfig loggerConfig;
    @Autowired
    private ILoggerInfoService loggerInfoService;

    @Around("execution(* network.y9..*.*(..))")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        // 如果没有开启，则直接返回
        if (LoggerLevelEnum.NONE.equals(loggerConfig.getLevel())) {
            return point.proceed();
        }
        long startTime = System.currentTimeMillis();
        LoggerInfoEntity info = new LoggerInfoEntity();
        // 设置url
        info.setUrl(Optional.ofNullable((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).map(ServletRequestAttributes::getRequest).map(HttpServletRequest::getRequestURI).orElse(""));
        // 设置类名
        info.setClassName(point.getTarget().getClass().getName());
        // 设置方法名
        info.setMethodName(point.getSignature().getName());
        // 设置请求IP地址
        info.setReqIpAdr(HttpRequestUtil.getRealIpAddress());
        // 设置响应IP地址
        info.setRspIpAdr(NetUtil.getLocalhostStr());
        // 设置请求头
        info.setReqHeader(JSONUtil.toJsonStr(HttpRequestUtil.getHeader()));
        // 设置请求体
        info.setReqBody(JSONUtil.toJsonStr(point.getArgs()));
        // 设置请求成功
        info.setSuccessInd(Boolean.TRUE);
        // 定义返回值
        Object obj;
        try {
            Object result = point.proceed();
            info.setRspBody(JSONUtil.toJsonStr(result));
            obj = result;
        } catch (Exception e) {
            // 设置请求异常
            info.setSuccessInd(Boolean.FALSE);
            // 设置异常信息
            info.setErrorMsg(e.getLocalizedMessage());
            throw e;
        } finally {
            // 计算处理时间
            info.setTotalTime(System.currentTimeMillis() - startTime);
            // 如果为全部打印或正常打印，并且为正常标志，记录
            if (LoggerLevelEnum.ALL.equals(loggerConfig.getLevel()) || (LoggerLevelEnum.PRINT.equals(loggerConfig.getLevel()) && info.getSuccessInd())) {
                loggerInfoService.saveAsync(info);
            }
            // 如果为全部打印或者异常打印，并且为异常标志，记录
            if (LoggerLevelEnum.ALL.equals(loggerConfig.getLevel()) || (LoggerLevelEnum.ERROR.equals(loggerConfig.getLevel())) && !info.getSuccessInd()) {
                loggerInfoService.saveAsync(info);
            }
        }
        return obj;
    }
}
