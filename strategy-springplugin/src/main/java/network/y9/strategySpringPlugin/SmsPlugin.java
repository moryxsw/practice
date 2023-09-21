package network.y9.strategySpringPlugin;

import org.springframework.plugin.core.Plugin;

/**
 * 基于spring plugin 实现策略模式
 * 主要利用spring plugin 自带的注册器
 */
public interface SmsPlugin extends Plugin<SmsRequest> {

    SmsResponse sendSms(SmsRequest request);
}
