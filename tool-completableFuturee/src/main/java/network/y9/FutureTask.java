package network.y9;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FutureTask {


    /**
     *
     * @param list 数据源
     * @param api 调用逻辑
     * @param exceptionHandle 异常处理逻辑
     * @return
     * @param <S> 数据源类型
     * @param <T> 程序返回类型
     */
    public <S,T> List<T> parallelFutureJoin(Collection<S> list, Function<S,T> api, BiFunction<Throwable,S, T> exceptionHandle){
        List<CompletableFuture<T>> collectFuture = list.stream().map(s -> this.createFuture(() -> api.apply(s), e ->exceptionHandle.apply(e, s))).collect(Collectors.toList());
        return collectFuture.stream().map(CompletableFuture::join).filter(Objects::nonNull).collect(Collectors.toList());
    }

    private <T> CompletableFuture<T> createFuture(Supplier<T> logic, Function<Throwable, T> exceptionHandle) {
        return CompletableFuture.supplyAsync(logic).exceptionally(exceptionHandle);
    }
}
