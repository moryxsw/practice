package network.y9.strategySpringPlugin;

import java.util.Objects;

public class TencentSmsPluginImpl implements SmsPlugin{
    @Override
    public SmsResponse sendSms(SmsRequest request) {

        System.out.print("tencent send sms success");
        return SmsResponse.builder().result(true).source(request.getSmsType().toString()).build();
    }

    @Override
    public boolean supports(SmsRequest request) {
        return Objects.equals(SmsType.TENCENT, request.getSmsType());
    }
}
