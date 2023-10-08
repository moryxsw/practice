package network.y9;

import java.util.function.Function;
import java.util.function.Predicate;

public interface FunctionStrategy <P, T, R>{

    /**
     * 钩子函数
     * @return
     */
    Predicate<P> predicate();


    /**
     * 执行逻辑
     * @return
     */
    Function<T, R> function();


}
