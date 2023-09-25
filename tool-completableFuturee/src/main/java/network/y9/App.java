package network.y9;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App {

    static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(50,100,10, TimeUnit.SECONDS,new ArrayBlockingQueue<>(200), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


    public static void main( String[] args ) {
        FutureTask task = new FutureTask();
        List<Integer> numList = task.parallelFutureJoin(Arrays.asList(1,2,3), num -> {
            return num + 1;
        }, (e, num) -> {
            return -1;
        });
    }


    private static void userTask() {
        long start = System.currentTimeMillis();


        Future<BigDecimal> baoFuture = threadPool.submit(() ->{
            return new BigDecimal(20);
        });

        Future<BigDecimal> dongFuture = threadPool.submit(() ->{
            return new BigDecimal(30);
        });


        BigDecimal min = Stream.of(baoFuture, dongFuture)
                .map(priFuture -> {
                    try{
                        return priFuture.get(10L, TimeUnit.SECONDS);
                    }catch (Exception e){
                        return null;
                    }
                }).filter(Objects::nonNull)
                .sorted(BigDecimal::compareTo)
                .findFirst().get();
    }


    private static void userTask2() {
        long start = System.currentTimeMillis();

        CompletableFuture<BigDecimal> bao = CompletableFuture.supplyAsync(() ->{
            return new BigDecimal(10);
        }).thenCombine(CompletableFuture.supplyAsync(() ->{
            return new BigDecimal(20);
        }), BigDecimal::add);
    }
}
