package network.y9;

public abstract class AbstractRule implements Rule {

    protected <T> T convert(RuleDTO dto){
        return (T) dto;
    }

    @Override
    public boolean execute(RuleDTO dto) {
        return executeRule(convert(dto));
    }

    protected <T> boolean executeRule(T t){
        return false;
    }
}
