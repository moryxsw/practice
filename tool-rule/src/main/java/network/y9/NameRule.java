package network.y9;

public class NameRule extends AbstractRule{
    @Override
    public boolean execute(RuleDTO dto) {
        System.out.println("NameRule invoke!");
        return dto.getName().startsWith("woniu");

    }
}
