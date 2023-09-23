package network.y9;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        App.whetherTure(true).throwMessage("测试异常");

        App.trueOrFalse(false)
                .trueOrFalse(() -> {
                    System.out.println("true");
                }, ()->{
                    System.out.println("false");
                });

    }



    public static ThrowExceptionFunction whetherTure(boolean b){

        return (message) -> {
            if(b){
                throw new RuntimeException(message);
            }
        };
    }

    public static BranchHandle trueOrFalse(boolean b){
        return (trueHandle, falseHandle) -> {
            if(b){
                trueHandle.run();
            }else {
                falseHandle.run();
            }
        };
    }
}
