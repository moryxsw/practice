package network.y9;

import org.springframework.stereotype.Component;

@Component
public class PiQiuHandler extends AbstractHandler{
    @Override
    public void afterPropertiesSet() throws Exception {

        Factory2.register("piqiu",this);
    }
}
