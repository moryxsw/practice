package network.y9.strategySpringPlugin;

import java.util.Objects;

public class AliSmsPluginImpl implements SmsPlugin {
    @Override
    public SmsResponse sendSms(SmsRequest request) {

        System.out.print("ali send sms success");
        return SmsResponse.builder().result(true).source(request.getSmsType().toString()).build();
    }

    @Override
    public boolean supports(SmsRequest request) {
        return Objects.equals(SmsType.ALI, request.getSmsType());
    }
}
