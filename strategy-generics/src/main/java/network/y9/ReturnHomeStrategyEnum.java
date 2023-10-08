package network.y9;

import java.util.function.Function;
import java.util.function.Predicate;

public enum ReturnHomeStrategyEnum implements FunctionStrategy<String, Integer, String>{

    HIGH(from -> "High Risk".equals(from), i -> i + "高风险回归"),
    ;


    private final Predicate<String> predicate;

    private final Function<Integer, String> function;


    public Predicate<String> getPredicate() {
        return predicate;
    }

    public Function<Integer, String> getFunction() {
        return function;
    }

    ReturnHomeStrategyEnum(Predicate<String> predicate, Function<Integer, String> function) {
        this.predicate = predicate;
        this.function = function;
    }

    @Override
    public Predicate<String> predicate() {
        return this.predicate;
    }

    @Override
    public Function<Integer, String> function() {
        return this.function;
    }
}
