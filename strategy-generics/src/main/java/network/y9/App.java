package network.y9;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        String from = "Low";

        Integer id = 1;

        for (ReturnHomeStrategyEnum value : ReturnHomeStrategyEnum.values()) {
            if(value.predicate().test(from)){
                System.out.println(value.function().apply(id));
            }
        }
        System.out.println( "Hello World!" );
    }
}
