package network.y9;

public class LanQiuHandler extends AbstractHandler{
    @Override
    public void afterPropertiesSet() throws Exception {
        Factory2.register("lanqiu",this);
    }
}
