package network.y9;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    private static void extracted() {
        String nickName = "lanqiu";
        AbstractHandler invokeStrategy = Factory2.getInvokeStrategy(nickName);

        invokeStrategy.AA(nickName);

        invokeStrategy.BB(nickName);


    }

}


